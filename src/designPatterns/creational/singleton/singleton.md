1. Singleton
   What it is

Ensures that a class has only one instance and provides a global way to access it.

When to use it

Use it for shared resources like:

configuration
logger
cache
connection manager
Bad design

Different parts of the app create their own logger/config object.