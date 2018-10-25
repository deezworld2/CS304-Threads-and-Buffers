/**
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */
//Deric Grayson
//February 13, 2018
//CS350-Section 001
//Programming Assignment #1
/** this file holds the bounded buffer class, which
will store all of the items produced and consumed
by the Producer and Consumer thread objects
*/

import java.util.*;

public class BoundedBuffer
{
   public BoundedBuffer()
   {
      // buffer is initially empty
      count = 0;
      in = 0;
      out = 0;

      buffer = new Object[BUFFER_SIZE];
   }

   // producer calls this method
   public void enter(Object item) {
      while (count == BUFFER_SIZE)
         ; // do nothing

      // add an item to the buffer
      ++count;
      buffer[in] = item;
      in = (in + 1) % BUFFER_SIZE;

	if (count == BUFFER_SIZE)
                System.out.println(" Buffer FULL");

   }

   // consumer calls this method
   public Object remove() {
      Object item;

      while (count == 0)
         ; // do nothing

      // remove an item from the buffer
      --count;
      item = buffer[out];
      out = (out + 1) % BUFFER_SIZE;

	if (count == 0)

                System.out.println(" Buffer EMPTY");

      return item;
   }


   public static final int    PNAP_TIME = 7; //Producer sleep max time
   public static final int CNAP_TIME = 12; //consumer sleep max time
   private static final int   BUFFER_SIZE = 5;

   private volatile int count;
   private int in;   // points to the next free position in the buffer
   private int out;  // points to the next full position in the buffer
   private Object[] buffer;
}
