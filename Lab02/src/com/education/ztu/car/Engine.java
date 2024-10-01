package com.education.ztu.car;

public class Engine {
    protected boolean engineWorks;

    public Engine(){
        engineWorks = false;
    }

    public void startEngine(){
        engineWorks = true;
    }

    public void stopEngine(){
        engineWorks = false;
    }

    public boolean isEngineWorks(){
        return engineWorks;
    }
}
