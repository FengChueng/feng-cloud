package com.feng.uitls;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        //不允许出现特殊字符和转义符
        mapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;
        //支持单引号
        mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
        // 设置输出时包含属性的风格
        mapper.configure(MapperFeature.USE_ANNOTATIONS, false);
        
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        //jackson 实体转json为NULL或者为空不参加序列化
//      objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        //jackson实体转json为null时修改null值为""
        mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                jsonGenerator.writeString("");
            }
        });
    }



    private static String toString(Object obj){
        return toJson(obj);
    }

    private static String toJson(Object obj){
        try{
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, obj);
            return writer.toString();
        }catch(Exception e){
            throw new RuntimeException("序列化对象【"+obj+"】时出错", e);
        }
    }

    /**
     * 用于对象通过其他工具已转为JSON的字符形式，这里不需要再加上引号
     * @param obj
     * @param isObject
     */
    public static String getJsonSuccess(String obj, boolean isObject){
        String jsonString = null;
        if(obj == null){
            jsonString = "{\"success\":true}";
        }else{
            jsonString = "{\"success\":true,\"data\":"+obj+"}";
        }
        return jsonString;
    }

    public static String getJsonSuccess(Object obj){
        return getJsonSuccess(obj, null);
    }

    public static String getJsonSuccess(Object obj, String message) {
        if(obj == null){
            return "{\"success\":true,\"message\":\""+message+"\"}";
        }else{
            try{
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("success", true);
                return "{\"success\":true,"+toString(obj)+",\"message\":\""+message+"\"}";
            }catch(Exception e){
                throw new RuntimeException("序列化对象【"+obj+"】时出错", e);
            }
        }
    }

    public static String getJsonError(Object obj){
        return getJsonError(obj, null);
    }

    public static String getJsonError(Object obj, String message) {
        if(obj == null){
            return "{\"success\":false,\"message\":\""+message+"\"}";
        }else{
            try{
                obj = parseIfException(obj);
                return "{\"success\":false,\"data\":"+toString(obj)+",\"message\":\""+message+"\"}";
            }catch(Exception e){
                throw new RuntimeException("序列化对象【"+obj+"】时出错", e);
            }
        }
    }

    public static Object parseIfException(Object obj){
        if(obj instanceof Exception){
            return getErrorMessage((Exception) obj, null);
        }
        return obj;
    }

    public static String getErrorMessage(Exception e, String defaultMessage){
        return defaultMessage != null ? defaultMessage : null;
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }
    
    /**
     * JSON字符串转对象
     * @param json
     * @param valueType
     * @return
     */
    public static <T> T parse(String json, Class<T> valueType) {

        try {
            return mapper.readValue(json, valueType);
        } catch (Exception e) {
            throw new RuntimeException("序列化对象【"+json+"】时出错", e);
        }
    }

    /**
     * 对象转json字符串
     * @param obj
     * @return
     */
    public static String parse(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
            throw new RuntimeException("序列化对象【"+obj+"】时出错", e);
        }
    }

    /**
     * 获取泛型的Collection Type
     * @param collectionClass
     * @param elementClasses
     * @return
     */
    @SuppressWarnings("deprecation")
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * 泛型反序列化 ,如List<T>,Map<K,V>
     * @param json
     * @param collectionClass
     * @param clazz
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static Collection parse(String json, Class<?> collectionClass, Class<?> clazz) {
        JavaType javaType = getCollectionType(collectionClass, clazz);
        try {
            return mapper.readValue(json, javaType);
        } catch (IOException e) {
            throw new RuntimeException("泛型反序列化【"+json+"】时出错", e);
        }
    }
    
    public static <T> T parse(String json, TypeReference<T> typeReference) {
        try {
            return mapper.readValue(json, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("泛型反序列化【"+json+"】时出错", e);
        }
    }
    
    
}