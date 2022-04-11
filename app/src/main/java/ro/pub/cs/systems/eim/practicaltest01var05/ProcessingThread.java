package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

import java.util.Date;
import java.util.Random;

public class ProcessingThread extends Thread {
    private Context context;
    private boolean isRunning = true;
    private String[] text;

    public ProcessingThread(Context context, String[] text) {
        this.context = context;
        this.text = text;

    }

    @Override
    public void run() {
        while (isRunning) {
            sendMessage();
            sleep();
        }


    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction(Constants.action_type);
        int i = 0;
        for (String str : text) {
            intent.putExtra("Message " + i , str);
            i++;
        }
        context.sendBroadcast(intent);
    }

    public void stopThread() {
        isRunning = false;
    }
}
