import java.io.*;
import java.net.*;

class UDPClient {
	public static void main(String...a) throws Exception {
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket =new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("192.168.1.57");
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();
	}
}
