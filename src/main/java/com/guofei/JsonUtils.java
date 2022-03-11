package com.guofei;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;

/**
 * @author: GuoFei
 * @date: 2022-03-10 20:23
 */
public class JsonUtils {
  public JsonUtils() {
  }

  public static JsonUtils.JsonWapper builder() {
    return new JsonUtils.JsonWapper();
  }

  public static String toString(Object obj, String dateFormat) {
    return builder().setDateFormat(dateFormat).toString(obj);
  }

  public static <T> T toObject(String jsonString, Class<T> clz, String dateFormat) {
    return builder().setDateFormat(dateFormat).toObject(jsonString, clz);
  }

  public static <T> T toObject(String jsonString, TypeReference<T> tr, String dateFormat) {
    return builder().setDateFormat(dateFormat).toObject(jsonString, tr);
  }

  public static String toString(Object obj) {
    return toString(obj, (String) null);
  }

  public static <T> T toObject(String jsonString, Class<T> clz) {
    return (T) toObject(jsonString, (Class) clz, (String) null);
  }

  public static <T> T toObject(String jsonString, TypeReference<T> tr) {
    return (T) toObject(jsonString, (TypeReference) tr, (String) null);
  }

  public static <T> List<T> toObjectList(String jsonString, Class<T> clz) {
    return toObjectList(jsonString, clz, (String) null);
  }

  public static <T> List<T> toObjectList(String jsonString, Class<T> clz, String dateFormat) {
    return builder().setDateFormat(dateFormat).toObjectList(jsonString, clz);
  }

  private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
    return builder().getObjectMapper().getTypeFactory().constructParametricType(collectionClass, elementClasses);
  }

  public static class JsonWapper {
    ObjectMapper objectMapper = null;

    public JsonWapper() {
    }

    public ObjectMapper getObjectMapper() {
      if (this.objectMapper == null) {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS).configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).configure(
            SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
      }

      return this.objectMapper;
    }

    public String toString(Object obj) {
      try {
        return this.getObjectMapper().writeValueAsString(obj);
      } catch (JsonProcessingException var3) {
        throw new RuntimeException(var3);
      }
    }

    public <T> T toObject(String jsonString, TypeReference<T> tr) {
      if (jsonString != null && !"".equals(jsonString)) {
        try {
          return this.getObjectMapper().readValue(jsonString, tr);
        } catch (Exception var4) {
          throw new RuntimeException(var4);
        }
      } else {
        return null;
      }
    }

    public <T> List<T> toObjectList(String jsonString, Class<T> clz) {
      JavaType javaType = JsonUtils.getCollectionType(ArrayList.class, clz);

      try {
        return (List) this.getObjectMapper().readValue(jsonString, javaType);
      } catch (IOException var5) {
        throw new RuntimeException(var5);
      }
    }

    public <T> T toObject(String jsonString, Class<T> clz) {
      try {
        return this.getObjectMapper().readValue(jsonString, clz);
      } catch (IOException var4) {
        throw new RuntimeException(var4);
      }
    }

    public JsonUtils.JsonWapper setPropertyNamingStrategy(
        PropertyNamingStrategy propertyNamingStrategy) {
      if (propertyNamingStrategy != null) {
        this.getObjectMapper().setPropertyNamingStrategy(propertyNamingStrategy);
      }

      return this;
    }

    public JsonUtils.JsonWapper setDateFormat(String dateFormat) {
      if (!StringUtils.isEmpty(dateFormat)) {
        this.getObjectMapper().setDateFormat(new SimpleDateFormat(dateFormat));
      }

      return this;
    }
  }
}
