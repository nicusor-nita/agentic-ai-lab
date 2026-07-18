### 05-09

# Langfuse tracing with OpenTelemetry
This example shows how to capture LLM call traces using OpenTelemetry and ship them to Langfuse for observability.

# Prerequisites
- Ollama installed and running
- qwen2.5 model pulled locally
- langfuse installed and configured (see 05-07)
- observability stack running


The manual instrumentation in this test (ObservableChatModel, TracingToolExecutor)
sends traces via the orange path only: App → OTel Collector → Langfuse — no OTel
Java agent required. See docs/observability-stack.html for the full diagram.

If you want to see the full stack in action, attach the OTel Java agent to the
process when running the test, for auto-instrumentation.

-javaagent:/Users/nicusor.nita/.m2/repository/io/opentelemetry/javaagent/opentelemetry-javaagent/2.27.0/opentelemetry-javaagent-2.27.0.jar
-Dotel.exporter.otlp.endpoint=http://localhost:4318
-Dotel.service.name=ai-series  
-Dotel.metrics.exporter=otlp
-Dotel.instrumentation.runtime-metrics.enabled=true
-Dotel.instrumentation.jvm-metrics.enabled=true
-Dotel.metrics.jvm.enabled=true

Note: adjust the -javaagent path to your local Maven repo location, and the
otlp.endpoint if your OTel Collector isn't running on localhost:4318.