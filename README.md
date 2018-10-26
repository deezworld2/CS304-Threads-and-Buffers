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

