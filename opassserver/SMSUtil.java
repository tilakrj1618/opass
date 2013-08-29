import java.io.*;
import java.util.*;
import javax.comm.*;

import java.net.HttpURLConnection;

public abstract class SMSUtil implements Runnable
{
 private static int responseCode = -1;
 private static String userCredentials = null;
 private static String cookie = null;
 private static String site = null;
 private static String actionStr = null;
		 private Enumeration portList;
    	 private CommPortIdentifier portId;
		 private SerialPort serialPort;
		 private OutputStream outputStream;
		 private String strPortName;
		 private InputStream inputStream;
		 private boolean boolKeepReceiving=true;
		 private Thread threadRX;
		 private ArrayList alSMSStore;
		 private int intDelay;
		 public SMSUtil(String strPortName) throws Exception{
		 		this.strPortName=strPortName;
	 			initCommPort();

		 }

		 private void initCommPort() throws Exception{
		 	 	boolean boolPortOK=false;
		 	 	portList = CommPortIdentifier.getPortIdentifiers();
		 	 	while (portList.hasMoreElements()) {
		 	           portId = (CommPortIdentifier) portList.nextElement();
		 	            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
		 		                if (portId.getName().equalsIgnoreCase(strPortName)) {
		 		                    this.serialPort = (SerialPort)portId.open("SimpleWriteApp", 2000);
		 		                    outputStream = serialPort.getOutputStream();
		 							inputStream=serialPort.getInputStream();

		 		  					serialPort.notifyOnDataAvailable(true);
		 		                    serialPort.setSerialPortParams(9600,
		 		                            SerialPort.DATABITS_8,
		 		                            SerialPort.STOPBITS_1,
		 		                            SerialPort.PARITY_NONE);
		 		                           // System.out.println("Here I come!");
		 		                    boolPortOK=true;
		 							break;
		 						}


		 	 			}
		 		}
		 		if(!boolPortOK) throw new Exception("Port "+strPortName+" does not exist!");

		 	}


	private String readSMSByIndex(int index) throws Exception        {


		final String AT_LIST="AT+CMGR="+index+"\r";
		StringBuffer sb=new StringBuffer();

		sb.append(writeATCmd(AT_LIST));
		return sb.toString();
	}

	private String readSMS() throws Exception{


		final String AT_LIST="AT+CMGR=1\r";
		StringBuffer sb=new StringBuffer();
		sb.append(writeATCmd(AT_LIST));
		return sb.toString();
	}


	private String writeATCmd(String strATCmd) throws Exception{
			outputStream.write(strATCmd.getBytes());
			outputStream.flush();

			byte[] data=new byte[1024];
			int ch=inputStream.read(data);
			String str=new String(data,0,ch);
			return str;

	}

	private void writeATCmdSMS(String strATCmd) throws Exception{

				outputStream.write(strATCmd.getBytes());
				outputStream.flush();
				System.out.println("Done");
				byte[] data=new byte[20];
				int ch=inputStream.read(data);
				System.out.println(new String(data,0,ch));



			}

public void deleteSMS(String strATCmd) throws Exception
            {
				outputStream.write(strATCmd.getBytes());
				outputStream.flush();

				byte[] data=new byte[20];
				int ch=inputStream.read(data);
				System.out.println(new String(data,0,ch));
                              Thread.sleep(2000);
			}


final public void sendSMS(String strPhNo,String strMsg) throws Exception
{


final String STR_AT_CMGS="AT+CMGS=\""+strPhNo+"\"\rLongterm Password";
System.out.println(STR_AT_CMGS);

final String STR_CTRL_Z=strMsg+(char)26;
System.out.println(STR_CTRL_Z);
Thread.sleep(1500);
writeATCmdSMS(STR_AT_CMGS);
Thread.sleep(1500);
writeATCmdSMS(STR_CTRL_Z);
Thread.sleep(1500);

}

	private String getPhoneNoFromRsp(String rsp){
			final String OFFSET_PH_NO="READ\",\"";
			final int PH_NO_LNGTH=13;
			int offset=rsp.indexOf(OFFSET_PH_NO)+OFFSET_PH_NO.length();
			int end=rsp.indexOf("\"",offset);
			String result = rsp.substring(offset,end);
			return result;
		}

	private	String getMsgFromRsp(String str){

			int offset1=str.indexOf("/");
			int off1=str.indexOf("\"",offset1)+1;
			int endOffset=str.lastIndexOf("OK");
			String msg=str.substring(off1,endOffset).trim();
			System.out.println("msg = " +msg );
			return msg;
	}

	private int getMsgIndex() throws Exception{
		int intCount=1;
		final String ERROR="ERROR:321";
		while(true){
			try{
				String str=this.readSMSByIndex(intCount);
				if(str.toUpperCase().indexOf(ERROR)!=-1){
					break;
				}else{
					intCount++;
				}
			}catch(Throwable t){
			}
		}
		return intCount;
	}

	private void startReceivingSMS() throws Exception{
			final String ERROR="ERROR";
			while(boolKeepReceiving){
			Thread.sleep(intDelay);
			try{
					String str=this.readSMS();
     	    	    System.out.println(str);
 						if(str.toUpperCase().indexOf(ERROR)!=-1){
							System.out.println("NO MSG");
						}else{
 						 if(str.indexOf("REC UNREAD") != -1) {
                         Random generator = new Random();
                         int r = generator.nextInt(999999);
                         String ran12=new Integer(r).toString();
                         String ran="Long Term Password : "+ran12;
						processSMS(str,ran12);
						final String STR_AT_CMGD="AT+CMGD=1\r";
						Thread.sleep(1000);
                        String phoneNo1 = str.substring(str.indexOf("REC UNREAD\",\"")+16, str.indexOf("REC UNREAD\",\"")+26);
		                this.deleteSMS(STR_AT_CMGD);
                        System.out.println("+++++");
                        System.out.println("Phono No and Password"+phoneNo1+" "+ran);
						}
						}
					}catch(Throwable t){

						System.out.println("ERROR RECEIVING MSG");
						t.printStackTrace();

					}
 			}
 	}



	final public void startReceive(ArrayList alSMSStore,int intDelay) throws Exception{
		this.alSMSStore=alSMSStore;
		this.intDelay=intDelay;
		threadRX=new Thread(this);
		threadRX.start();
	}

	final public void run(){
		try{
			startReceivingSMS();
		}catch(Throwable t){
			t.printStackTrace();
		}
	}



	final public void stopReceivingSMS(){
		this.boolKeepReceiving=false;
	}





	public ArrayList getReceivedMessages(){
			return this.alSMSStore;
	}




    //----------------

 private static void exit(String errorMsg) {
  System.err.println(errorMsg);
  System.exit(1);
 }

 //--------------------

	public abstract void processSMS(String message,String ran1) throws Exception;



}