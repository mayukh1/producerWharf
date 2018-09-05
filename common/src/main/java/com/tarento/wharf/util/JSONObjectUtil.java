package com.tarento.wharf.util;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Abhishek on 10/5/2017.
 */
@Service(value = "jsonObjectUtil")
public class JSONObjectUtil {
    @Autowired
    public ObjectMapper mapper;
    @Autowired
    public Gson gson;

    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(JSONObjectUtil.class);


    /**
     * @return
     */
    public static String getJsonString(ObjectMapper objectMapper,Object object) throws JsonProcessingException {
        //initialize();
        if(objectMapper != null){
            return  objectMapper.writeValueAsString(object);
        }
        return null;
    }

    public String getJsonString(Object object) throws JsonProcessingException {
        //initialize();
        if(mapper != null){
            return  mapper.writeValueAsString(object);
        }
        if(gson != null){
            return gson.toJson(object);
        }
        return null;
    }


    public ObjectMapper getMapper() {
        return mapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper){
        mapper=objectMapper;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gsonn)
    {
        gson = gsonn;
    }
}
