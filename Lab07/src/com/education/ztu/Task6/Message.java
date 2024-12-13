package com.education.ztu.Task6;

public class Message {
    private String content = "";
    private boolean contentReceived = true;

    public synchronized String getContent() {
        while(contentReceived){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread is interrupted.");
            }
        }

        contentReceived = true;
        notifyAll();
        return content;
    }

    public synchronized void setContent(String content) {
        while(!contentReceived){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread is interrupted.");
            }
        }

        contentReceived = false;
        this.content = content;
        notifyAll();
    }
}
