### 05-08

# Langfuse tool description management
Using langfuse prompts management capabilities to manage and version tool descriptions

# Prerequisites
- Ollama installed and running
- qwen2.5 model pulled locally
- langchain installed and configured

# SETUP
You should have an instance of langfuse running;
You should have created a project in langfuse to manage your prompts, and create a prompt for the assistant.
Then you should generate the sk and pk keys and run
echo -n "pk-lf-xxxxxxxx:sk-lf-xxxxxxxx" | base64
The value should be used in as langfuse.authorizationHeader in application.yml

Finally you should have tool descriptions in langfuse:
tools/getExchangeRate
and
tools/getWeather

