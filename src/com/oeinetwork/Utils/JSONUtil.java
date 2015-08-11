package com.oeinetwork.Utils;

import com.oeinetwork.Database.AdviceBean;
import com.oeinetwork.Database.ApplyBean;
import com.oeinetwork.Models.MixMessage;
import com.oeinetwork.Models.MixMsg;
import com.oeinetwork.Models.MixSingleMessage;
import com.oeinetwork.Models.TextMessage;
import com.sun.istack.internal.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Project OEIWebServer
 * Created by Zhen on 2015/8/4.
 */
public class JSONUtil {

    public static TextMessage translateTextMessage(@NotNull String input) {
        try {
            JSONObject jsonObject = new JSONObject(input);
            TextMessage textMessage = new TextMessage();
            textMessage.setContent(jsonObject.getString("Content"));
            textMessage.setMsgType(jsonObject.getString("MsgType"));
            return textMessage;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MixMessage translateMixMessage(@NotNull String input) {
        try {
            MixMessage mixMessage = new MixMessage();

            MixMsg msg = new MixMsg();
            ArrayList<MixSingleMessage> list = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(input);
            int count = jsonObject.getInt("Count");
            JSONArray jsonArray = jsonObject.getJSONArray("messageArray");
            JSONObject temp;
            MixSingleMessage singleOne;
            for (int i = 0; i < count; i++) {
                temp = jsonArray.getJSONObject(i);
                singleOne = new MixSingleMessage();
                singleOne.setDescription(temp.getString("Description"));
                singleOne.setPicUrl(temp.getString("PicUrl"));
                singleOne.setTitle(temp.getString("Title"));
                singleOne.setUrl(temp.getString("Url"));
                list.add(singleOne);
            }
            msg.setList(list);
            mixMessage.setMsgList(msg);
            mixMessage.setMsgType(jsonObject.getString("MsgType"));
            return mixMessage;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String translateTextIntoJson(@NotNull TextMessage input) {
        JSONObject object = new JSONObject();
        try {
            object.put("MsgType", input.getMsgType());
            object.put("Content", input.getContent());
            return object.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String translateMixIntoJson(@NotNull MixMessage input) {
        JSONObject object = new JSONObject();
        try {
            object.put("MsgType", input.getMsgType());
            MixMsg msg = input.getMsgList();
            ArrayList<MixSingleMessage> list = msg.getList();
            JSONArray array = new JSONArray();
            JSONObject singleMixMessage;
            MixSingleMessage singleObj;
            for (int i = 0; i < list.size(); i++) {
                singleMixMessage = new JSONObject();
                singleObj = list.get(i);
                singleMixMessage.put("Description", singleObj.getDescription());
                singleMixMessage.put("PicUrl", singleObj.getPicUrl());
                singleMixMessage.put("Title", singleObj.getTitle());
                singleMixMessage.put("Url", singleObj.getUrl());
                array.put(i, singleMixMessage);
            }
            object.put("Count", list.size());
            object.put("messageArray", array);
            return object.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String translateBeanIntoJSON(Object bean, String typeName) {
        JSONObject object = beanFactory(bean);
        try {
            object.put("beanType", typeName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return object.toString();
    }

    private static JSONObject beanFactory(Object bean) {
        JSONObject object = new JSONObject();
        Method[] methods = bean.getClass().getMethods();
        String methodName;
        String regPattern = "^get+[a-zA-z]*";
        for (Method method : methods) {
            methodName = method.getName();
            if (Pattern.matches(regPattern, methodName) && (!methodName.equals("getClass"))) {
                try {
                    object.put(methodName.substring(3), method.getReturnType().cast(method.invoke(bean)));
                } catch (IllegalAccessException | InvocationTargetException | JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        ApplyBean al = new ApplyBean();


        return object;
    }

    public static }
