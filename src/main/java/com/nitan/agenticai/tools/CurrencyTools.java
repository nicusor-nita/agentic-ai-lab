package com.nitan.agenticai.tools;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

@Component
public class CurrencyTools {

    @McpTool(name = "get-exchange-rate", description = "Get the exchange rate between two currencies")
    public double getExchangeRate(
        @McpToolParam(description = "Source currency code, e.g. USD", required = true) String fromCurrency,
        @McpToolParam(description = "Target currency code, e.g. EUR", required = true) String toCurrency) {
        System.out.println("Fetching exchange rate from " + fromCurrency + " to " + toCurrency);

        return 0.92;
    }
}