package com.nitan.agenticai.tools;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

@Component
public class WeatherTool {
  @McpTool(name = "get-weather", description = "Get the weather forecast for a given city")
  public String getWeather(@McpToolParam(description = "city", required = true) String city) {
    System.out.println("Fetching weather for: " + city);
    return "Tomorrow in " + city + ": sunny, 24°C, light breeze.";
  }
}
