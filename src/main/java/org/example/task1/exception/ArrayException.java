package org.example.task1.exception;

public class ArrayException extends Exception{
    public ArrayException(){
        super();
    }
    public ArrayException(String message){
        super(message);
    }
    public ArrayException(Throwable cause){
        super(cause);
    }

}
