/**
 * Producer.java
 *
 * This is the producer thread for the bounded buffer problem.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */
//Deric Grayson
//February 13, 2018
//CS350-Section 001
//Programming Assignment 1
/* this file contains the producer thread class. This class
creates integer values between 8000 and 50000 and places them
into a buffer shared with a consumer class for the consumer to
make use of.
*/

import java.util.*;

public class Producer extends Thread
{
  //constructor to initialize Producer with buffer and string args
   public Producer(BoundedBuffer b, String n) {
      buffer = b;
      name = n;
   }
   public String name; //holds name of the producer
   public void run()
   {
   Integer message;

      while (true)
      {
        //generates a random sleep time between 1 and BoundedBuffer.PNAP_TIME
        Random t = new Random();
         int sleeptime = t.nextInt(BoundedBuffer.PNAP_TIME) +1;

         System.out.println(name + " sleeping for " + sleeptime + " seconds");

         try { sleep(sleeptime*1000); }
         catch(InterruptedException e) {}

         // produce an item & enter it into the buffer
         Random i = new Random();
         //generates a random number between 8000 and 50000
         message = Integer.valueOf(i.nextInt((50000 - 8000) + 1) + 8000);
         System.out.println(name + " produced " + message.intValue());

         buffer.enter(message);
      }
   }

   private  BoundedBuffer buffer;

}
