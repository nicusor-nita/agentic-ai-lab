package com.nitan.agenticai.tools;

import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.charset.StandardCharsets;

@Component
public class GitTools {

    @McpTool(
        name = "git_log",
            description = """
        Retrieves the latest commits from the local Git repository.
        """
    )
    public String gitLog() {
        try {
            Process process = new ProcessBuilder(
                    "git", "log", "-5",
                    "--pretty=format:%h | %an | %s"
            )
                    .directory(new File("."))
                    .redirectErrorStream(true)
                    .start();

            String output = new String(
                    process.getInputStream().readAllBytes(),
                    StandardCharsets.UTF_8
            );

            int exitCode = process.waitFor();

            if (exitCode != 0) {
                return "Git command failed: " + output;
            }

            return output.isBlank() ? "No commits found." : output;

        } catch (Exception e) {
            return "Failed to execute git log: " + e.getMessage();
        }
    }
}