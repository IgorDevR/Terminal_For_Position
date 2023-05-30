package com.app.util;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Обработка json данных и прочее
 */
public class Parser {

  /**
   * Сериалезуем json в список с переданным классом
   *
   * @param json строка с которой парсим.
   * @return Список указанного типа.
   */
  public static <T> List<T> parseJsonToList(String json, TypeToken<List<T>> typeToken) {
    Type listType = typeToken.getType();

    if (!json.isEmpty()) {
      try {
        Gson gson = new Gson();
        return gson.fromJson(json, listType);
      } catch (JsonSyntaxException e) {
        // Здесь вы можете обработать исключение, возникшее при разборе JSON
        e.printStackTrace();
      }
    }
    return new ArrayList<>();
  }



}


