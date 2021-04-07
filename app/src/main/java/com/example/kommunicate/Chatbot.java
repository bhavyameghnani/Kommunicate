package com.example.kommunicate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.kommunicate.KmConversationBuilder;
import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KmCallback;

public class Chatbot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);


        List<String> agentList = new ArrayList();
        agentList.add(""); //add your agentID
        List<String> botList = new ArrayList();
        botList.add(""); //enter your integrated bot Ids

        Kommunicate.init(Chatbot.this, "");
        Kommunicate.openConversation(Chatbot.this);



        new KmConversationBuilder(Chatbot.this)
                .setAgentIds(agentList)
                .setBotIds(botList)
                .createConversation(new KmCallback() {
                    @Override
                    public void onSuccess(Object message) {
                        Log.d("ChatLaunch", "Success : " + message);

                    }

                    @Override
                    public void onFailure(Object error) {
                        Log.d( "ChatLaunch", "Failure : " + error);

                    }
                });

//        Kommunicate.launchSingleChat(Chatbot.this, "Support", Kommunicate.getVisitor(), false, true, agentList, botList, new KmCallback(){
//            @Override
//            public void onSuccess(Object message) {
//                Log.d("ChatLaunch", "Success : " + message);
//            }
//            @Override
//            public void onFailure(Object error) {
//                Log.d( "ChatLaunch", "Failure : " + error);
//            }
//        });

    }
}