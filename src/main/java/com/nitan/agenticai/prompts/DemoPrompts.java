package com.nitan.agenticai.prompts;

import java.util.List;
import java.util.Map;

import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSchema.GetPromptResult;
import io.modelcontextprotocol.spec.McpSchema.PromptMessage;
import io.modelcontextprotocol.spec.McpSchema.Role;
import io.modelcontextprotocol.spec.McpSchema.TextContent;
import org.springframework.ai.mcp.annotation.McpArg;
import org.springframework.ai.mcp.annotation.McpPrompt;
import org.springframework.stereotype.Component;

import static org.antlr.v4.runtime.misc.Utils.readFile;

@Component
public class DemoPrompts {

    private static final Map<String, String> FILES = Map.of(
            "/src/Calculator.java", """
                    public class Calculator {
                        public int divide(int a, int b) {
                            return a / b;
                        }
                    }
                    """,
            "/src/Greeter.java", """
                    public class Greeter {
                        public String greet(String name) {
                            return "Hello, " + name.toUpperCase();
                        }
                    }
                    """);

    @McpPrompt(name = "code-reviewer-persona", description = "Reviewer instructions for a language")
    public GetPromptResult codeReviewer(
            @McpArg(name = "language", description = "Programming language", required = true)
            String language) {

        String text = "You are a strict " + language + " code reviewer. Be concise.";
        return new GetPromptResult("Reviewer persona",
                List.of(new PromptMessage(Role.USER, new TextContent(text))));
    }

    @McpPrompt(name = "review-code", description = "Asks for a review of a code snippet")
    public GetPromptResult reviewCode(
            @McpArg(name = "language", description = "Programming language", required = true)
            String language,
            @McpArg(name = "code", description = "Code to review", required = true)
            String code) {

        String text = "Review this " + language + " code and list concrete problems:\n\n" + code;
        return GetPromptResult.builder(
                        List.of(new PromptMessage(Role.USER, TextContent.builder(text).build())))
                .description("Code review request")
                .build();
    }

    @McpPrompt(name = "review-file", description = "Review a file")
    public GetPromptResult reviewEmbeddedResource(
            @McpArg(name = "path", description = "File path", required = true)
            String path) {

        String source = FILES.get(path);
        if (source == null) {
            throw new IllegalArgumentException("Unknown file: " + path);
        }

        McpSchema.TextResourceContents resource =
                new McpSchema.TextResourceContents("file://" + path, "text/x-java", source);

        return new GetPromptResult("Review file", List.of(
                new PromptMessage(Role.USER, new TextContent("Review this file:")),
                new PromptMessage(Role.USER, new McpSchema.EmbeddedResource(null, resource))));
    }

    @McpPrompt(name = "classify-sentiment", description = "Few-shot sentiment classifier")
    public GetPromptResult classifySentiment(
            @McpArg(name = "text", description = "Text to classify", required = true)
            String text) {

        return new GetPromptResult("Sentiment", List.of(
                msg(Role.USER, "Classify: I love this product"),
                msg(Role.ASSISTANT, "POSITIVE"),
                msg(Role.USER, "Classify: Delivery was a disaster"),
                msg(Role.ASSISTANT, "NEGATIVE"),
                msg(Role.USER, "Classify: " + text)));
    }

    private static PromptMessage msg(Role role, String text) {
        return new PromptMessage(role, new TextContent(text));
    }
}