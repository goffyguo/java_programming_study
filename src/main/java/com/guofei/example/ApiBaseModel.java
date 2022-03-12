package com.guofei.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: GuoFei
 * @date: 2022-03-12 11:32
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiBaseModel implements Serializable {
  private int returncode;

  private String message;

  private CalendarEvent result;
}
