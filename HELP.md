# Help Guide

This help guide on any topic related to the current subject

## Util Commands

The JDK tools and their commands enable developers to handle development tasks such as compiling and running a 
program, packaging source files into a Java Archive (JAR) file, applying security policies to a JAR file, and more.

The tools and commands reference topic lists and describes the Java Development Kit (JDK) tools. They’re grouped 
into the following sections based on the related functions that they perform. Details about the tools and the 
commands that you use to run them are contained in the corresponding sections of this guide.

### Main Tools

The following foundation tools and commands let you create and build applications:

- `java --list-modules`: List observable modules
- `java --describe-module <module>`: List of packages that contain that module
- `jdeps --list-deps -m <module>`: Lists the module dependencies. It also prints any internal API packages if 
referenced. This options transitively analyzes libraries on class path and module path if referenced
- `jdeps --list-reduced-deps -m <module>`: Same as `--list-deps` with not listing the implied reads edges from 
the module graph.
- `jdeps --print-module-deps -m <module>`: Same as `--list-reduced-deps` with printing a comma-separated list of
module dependendies.

## Additional sites
- [Readme](./README.md): Advisory document about this project.
- [Tools](./TOOLS.md): A set of tools and commands reference topic lists and describes the
  Java Development Kit (JDK) tools
- [License](./LICENSE): License about this project
#### Websites
- [Java SE Language Specification](https://docs.oracle.com/javase/specs/jls/se11/html/index.html): _The Java
  Virtual Machine Specification_, Java SE 11 Edition
- [Java API Specification](https://docs.oracle.com/en/java/javase/11/docs/api/index.html): _Java® Platform, Standard
  Edition & Java Development Kit_, Version 11 API Specification
