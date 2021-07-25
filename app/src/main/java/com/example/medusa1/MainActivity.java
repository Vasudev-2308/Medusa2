package com.example.medusa1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static android.media.MediaPlayer.*;
import static com.example.medusa1.R.raw.hi;

public class MainActivity extends AppCompatActivity {
    EditText userInput;
    RecyclerView recyclerView;
    List<ResponseMessage> responseMessagesList;
    MessageAdaptor messageAdaptor;
    MediaPlayer mediaPlayer=new MediaPlayer();
    TextToSpeech t1;
    String Reply;
    String userName=openingScreenActivity.name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput=findViewById(R.id.userInput);
        recyclerView=findViewById(R.id.recyclerview);
        responseMessagesList=new ArrayList<>();
        messageAdaptor=new MessageAdaptor(responseMessagesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(messageAdaptor);
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    t1.setLanguage(Locale.US);
                }
            }
        });
        userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_SEND){
                    ResponseMessage message=new ResponseMessage(userInput.getText().toString(),true);
                    responseMessagesList.add(message);

                    ResponseMessage message1= null;
                    try {
                        message1 = new ResponseMessage(botResponse(userInput.getText().toString()),false);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    responseMessagesList.add(message1);
                    userInput.setText("");
                    messageAdaptor.notifyDataSetChanged();
                }
                return true;
            }

            private String botResponse(String toString) throws InterruptedException {
                if(toString.equalsIgnoreCase("hi")||toString.equalsIgnoreCase("hello")) {
                    t1.speak("Hello "+userName+" , This is Medusa",TextToSpeech.QUEUE_FLUSH,null);
                    return "hello "+userName+" ,this is medusa";
                }
                if(toString.toLowerCase().contains("intro")){
                    Reply="I am Medusa the brain child of Vinuta .A. M, I am a chat bot \n nice to meet you ";
                    t1.speak(Reply,TextToSpeech.QUEUE_FLUSH,null);
                    return Reply;
                }
                if(toString.toLowerCase().contains("how are you")||toString.toLowerCase().contains("how r u")){
                    Reply="I am absolutely bug free ";
                    t1.speak(Reply,TextToSpeech.QUEUE_FLUSH,null);
                    return Reply;
                }
                Reply= "sorry i didn't get that";
                t1.speak(Reply,TextToSpeech.QUEUE_FLUSH,null);
                return Reply;
            }

        });

    }
}
