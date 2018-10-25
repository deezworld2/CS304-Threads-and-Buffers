/**
 * Server.java
 *
 * This creates the buffer and the producer and consumer threads.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */
/**
* Name: Deric Grayson
* Date: February 13, 2018
* Course: CS350-001
* Assignment: Programming #1
* Description: This file contains the Server class, which
* serves as the main class for the producer, consumer, and Buffer
* classes. This class creates two producer threads and two consumer threads
*. each producer thread shares a buffer with exaclty one consumer thread.
*/
public class Server
{
	public static void main(String args[]) {
		//creates the two producer-consumer servers
		BoundedBuffer server1 = new BoundedBuffer();
		BoundedBuffer server2 = new BoundedBuffer();

      		// now create the producer and consumer threads

      		Producer producerThread1 = new Producer(server1, "John");
      		Consumer consumerThread1 = new Consumer(server1, "Mary");
					Producer producerThread2 = new Producer(server2, "Liz");
					Consumer consumerThread2 = new Consumer(server2, "Bert");
					//start the producer and the consumer threads
      		producerThread1.start();
      		consumerThread1.start();
					producerThread2.start();
					consumerThread2.start();

	}//main
}//class
