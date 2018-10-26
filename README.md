# Threads-and-Buffers
This project was developed as an assignment for my Fundamentals of Computer Operating Systems class at my university. This was a solo project, and all source code used in the project is either supplied by the university or written by myself.

## Introduction
The purpose of this project it to demonstrate the use of shared resources in computer operating systems using bounded buffers and threads. The project takes a look at a problem called the Producer-Consumer problem. The idea is to produce a program that would have two objects, a Producer and a Consumer, that share a data structure and perform operations on it. Producers sleep for a random amount of time, then they place items into the data structure, and consumers sleep for a random amount of time and then take items out of the buffer.

## Documentation
The entirety of this project is written in Java.
   * ### BoundedBuffer.java
     This class contains the code to manage an array of ```Object``` to be used by the ```Producer``` and ```Consumer``` classes.
     #### Structures and Variables
      * ```public static final int PNAP_TIME``` holds the maximum number of seconds for producers to sleep.
      * ```public static final int CNAP_TIME``` holds the maximum number of seconds for consumers to sleep.
      * ```private static final int BUFFER_SIZE``` holds the size of the buffer.
      * ```privste volatile int count``` keeps track of the number of items in the buffer.
      * ```private int in``` points to the next free position in the buffer.
      * ```private int out``` points to the next full position in the buffer.
      * ```private Object[] buffer``` holds all of the objects to be used by the producer and the consumer.
      
      #### Methods
      * ```public BoundedBuffer()``` default constructor that initializes ```count```, ```in```, and ```out``` to 0 and initializes ```buffer``` to an array of size ```BUFFER_SIZE``` and type ```Object```.
      * ```public void enter(Object item)``` checks to see if the buffer is full. If it is full, a full buffer message is printed. If the buffer is not full, the method increments ```count``` and places ```item``` at the ```buffer[in]``` position. ```in``` is then moved to the next position in the buffer.
      * ```public Object remove()``` checks to see if there is anything in the buffer. If the buffer is empty, an empty buffer message is printed. If there is an item in the buffer, the method deincrements ```count``` and removes the item at ```buffer[out]```. The method moves ```out``` to point to the next place in the buffer, then returns the item that was removed. 
   * ### Producer.java
     This class contains the code for the ```Producer``` class. A ```Producer``` sleeps for a random amount of time, then places an item in a buffer to be used by a consumer. __NOTE:__ ```Producer``` ```extends Thread```.
     #### Structures and Variables
      * ```private BoundedBuffer buffer``` holds the items that are produced by ```Producer```.
      * ```public String name``` holds the name of the producer.
     #### Methods
      * ```public Producer(BoundedBuffer b, String n)``` constructor that initializes the ```buffer``` variable to ```b``` and ```name``` to ```n```.
      * ```public void run()``` starts the producer thread and runs indefinitely. The method begins by creating an item to place in the buffer, ```Integer message```. The method then generates a random number between 1 and ```BoundedBuffer.PNAP_TIME``` to sleep for (in milliseconds). The method prints that the producer is sleeping as well as the amount of time that it will sleep for. The producer will then sleep for the amount of time selected * 1000 to convert to seconds. The method will generate another random number, this time between 8,000 and 50,000 to store in ```message```. The method prints the name of the producer and the value that it produced, and then it places that value into the buffer via ```buffer.enter(message)```.
   * ### Consumer.java
     This class contains the code for the ```Consumer``` class. A ```Consumer``` sleeps for a random amount of time, then takes items that are placed into a buffer by ```Producer``` and consumes them. __NOTE:__ ```Consumer``` ```extends Thread```.
     #### Structures and Variables
     * ```private BoundedBuffer buffer``` holds the items to be consumed.
     * ```public String name``` holds the name of the consumer.
     #### Methods
     * ```public Consumer(BoundedBuffer b , String n)``` constructor that initializes ```buffer``` to ```b``` and ```name``` to ```n```.
     * ```public void run()``` starts the consumer thread and runs indefinitely. The method begins by creating an item to remove from the buffer, ```Integer message```. The method then generates a random number between 1 and ```BoundedBuffer.CNAP_TIME``` to sleep for (in milliseconds). The method prints that the consumer is sleeping as well as the amount of time that it is sleeping for. The consumer will then sleep for the amount of time selected * 1000 to convert to seconds. The method will then print that the consumer is ready to consume. The method will remove an item from the buffer using ```message = (Integer)buffer.remove()```. The method will finally print the name of the consumer and the value of the item that it consumed. 
      
