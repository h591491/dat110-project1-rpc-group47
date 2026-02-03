package no.hvl.dat110.messaging;

import java.util.Arrays;
import java.util.Random;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = new byte[SEGMENTSIZE];
		byte[] data = message.getData();
		
		// TODO - START - ferdig
		
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer

		byte header = (byte) data.length;

		segment[0] = header;

		for(int i = 0; i < data.length; i++){
			segment[i+1] = data[i];
		}

		// TODO - END - ferdig
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		
		// TODO - START - ferdig
		// decapsulate segment and put received payload data into a message

		int header = Byte.toUnsignedInt(segment[0]);
		byte[] data = new byte[header];

		for(int i = 1; i <= header; i++){
			data[i-1] = segment[i];
		}

		message = new Message(data);

		// TODO - END - ferdig
		
		return message;
		
	}
	
}
