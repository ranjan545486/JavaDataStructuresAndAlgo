package LinkedInQuestions.other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by rmukherj on 8/5/16.
 */
public class ParseMessage {
    public static void main(String[] args){
        Message msg = new Message();
        msg.setEventId("1");
        msg.setEventDateTime("2016-07-16");
        msg.setEventType("createpartner");
        msg.setEventVersion("1.0");
        msg.setPayload("<Hello>Thor saying hello.</Hello>");

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(msg);
        System.out.println("the deserialize is "+ json);
        ObjectMapper mapper = new ObjectMapper();
        try {
            String js = mapper.writeValueAsString(msg);
            System.out.println();
            System.out.println(js);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
