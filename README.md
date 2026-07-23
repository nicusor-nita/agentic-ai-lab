### Observability stack for your AI applications

run docker compose up -d
Go to http://localhost:300 and sign up, then follow the flow to create a new organization and a new project. 
Once you have created the project, you will be redirected to the project dashboard. 
From there, you can create API keys e.g.

LANGFUSE_SECRET_KEY="sk-lf-ef4b6ba8-531c-4e81-89c9-c3af4759b44b"
LANGFUSE_PUBLIC_KEY="pk-lf-b7a8c533-3bea-4129-bc25-955217f4deb3"

run echo -n 'pk-lf-b7a8c533-3bea-4129-bc25-955217f4deb3:sk-lf-ef4b6ba8-531c-4e81-89c9 -c3af4759b44b' | base64

The result should replace the value of LANGFUSE_AUTH_HEADER in the .env file and value of the 
property langfuse.authorizationHeader in your java project's application.yml file.

Go to http://localhost:9091 , login as minio/miniosecret and create a bucket named "langfuse".

docker compose down
docker compose up -d

You should be good to go.
