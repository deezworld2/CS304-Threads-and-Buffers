/**
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */
 //Deric Grayson
 //February 13, 2018
 //CS350-Section 001
 //Programming assignment 1
 /* this file contains the consumer thread class,
 which takes Integer items from a buffer shared with
 a producer thread and returns the value of the items
 in addition to whether or not the values are prime numbers.
 */

import java.util.*;

public class Consumer extends Thread
{
  //constructor for the consumer, which initializes the buffer and the name
   public Consumer(BoundedBuffer b, String n)
   {
      buffer = b;
      name = n;
   }

   public String name; //holds name of the consumer

   public void run()
   {
     Integer message;

     while (true)
      {
        //generates a random sleep time
         Random num = new Random();
         int sleeptime = num.nextInt(BoundedBuffer.CNAP_TIME) +1;

         System.out.println(name + " sleeping for " + sleeptime + " seconds");

         try { sleep(sleeptime*1000); }
         catch(InterruptedException e) {}

         // consume an item from the buffer
         System.out.println(name + " wants to consume.");
         //takes an Integer object from the buffer
         message = (Integer)buffer.remove();
         //checks if the number pulled from the buffer is prime
         boolean isPrime;
         if (message.intValue()%2 != 0 && message.intValue()%3 != 0 && message.intValue()%5 != 0){
           isPrime = true;
         }else{
           isPrime = false;
         }
         //prints the number that was consumed and says whether it was prime
         if (isPrime){
           System.out.println(name + " consumed " + message.intValue() + " and IT IS A PRIME!");
         }else{
           System.out.println(name + " consumed " + message.intValue() + " and IT IS NOT A PRIME!");
         }
      }
   }

   private  BoundedBuffer buffer;

}
