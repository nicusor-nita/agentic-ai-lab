package com.nitan.agenticai.resources;

import org.springframework.ai.mcp.annotation.McpResource;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
class TicketResources {

  private static final Map<String, String> TICKETS =
          Map.of(
                  "TCK-1", "Login page returns 500 after password reset. Priority: high.",
                  "TCK-2", "Export to CSV drops the last row. Priority: medium.");

  @McpResource(
      uri = "ticket://{id}",
      name = "ticket",
      description = "Content of a ticket by its id, for example TCK-1.",
      mimeType = "text/plain")
  public String ticket(String id) {
    String content = TICKETS.get(id);
    if (content == null) {
      throw new IllegalArgumentException("Unknown ticket: " + id);
    }
    return content;
  }
}