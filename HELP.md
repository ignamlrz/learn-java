# Help Guide

This help guide on any topic related to the current subject

## Util Commands

The JDK tools and their commands enable developers to handle development tasks such as compiling and running a 
program, packaging source files into a Java Archive (JAR) file, applying security policies to a JAR file, and more.

The Util Commands topic lists and describes the most used Java Development Kit (JDK) tools and his arguments. They’re 
grouped  into the following sections based on the related functions that they perform. Details about the tools and the 
commands that you use to run them can be found inside the [tools guide](./TOOLS.md).

### List packages and modules

- `java [-p | --module-path] <module path> --list-modules`: List observable modules
- `java [-p | --module-path] <module path> --describe-module <module>`: List of packages that contain that module

### List dependencies

- `jdeps --check <module>`: Analyze the module dependencies. It prints the module descriptor, 
the resulting module dependencies after analysis and the graph after transition reduction. It also identifies
any unused qualified exports
- `jdeps --list-deps [-m | --module-name] <module>`: Lists the module dependencies. It also prints any internal 
API packages if referenced. This options transitively analyzes libraries on class path and module path if referenced
- `jdeps --list-reduced-deps [-m | --module-name] <module>`: Same as `--list-deps` with not listing the implied 
reads edges from the module graph.
- `jdeps --print-module-deps [-m | --module-name] <module>`: Same as `--list-reduced-deps` with printing a 
comma-separated list of module dependencies.

> **Note**: Previous jdeps commands can be use with any of the following **combination** of commands. If any of 
> this combination is specified, then only will work with Java SE & JDK modules:
- **Combination 1**: `jdeps <options> <path>`: Can be a pathname to a .class file, a directory, a JAR file
- **Combination 2**: `jdeps <options> [-cp | -classpath | --class-path] <path>`: Specify where to find class files
- **Combination 3**: `jdeps <options> [--module-path] <module path>`: Specify module path

### Compile applications

- `javac -d <directory> [--module-source-path] <module source path> [-m | --module] <module>`: Compile a module
  - `-d <directory>`: Specify where to place generated class files
  - `--module-source-path <module source path>`: Specify where to find input source files 
  for multiple modules
  - `[-m | --module] <module>`: A comma-separated list of modules to compile
    on the operation
> **Example**: `javac -d out\production --module-source-path ./*/src/ --module basic.module,basic.module.utils`

### Built applications

- `jar [-c | --create] [-f | --file] <filename.jar> [-e | --main-class] <mainclass> -C <directory> <files>`: Creation 
of a new jar archive
  - `[-c | --create]`: Create the archive
  - `[-f | --file] <filename.jar>`: The archive file name. When omitted, either stdin or stdout is used based
  on the operation
  - `[-e | --main-class] <mainclass>`: The application entry point for stand-alone applications bundled into a 
  modular, or executable, jar archive
  - `-C <directory>`: Change to the specified directory
> **Example**: `jar --create --file basic.module.jar --main-class modular.HelloWorld -C 
.\out\production\basic.module\ .`

### Run applications

- `java [-cp | -classpath | --class-path] <class search path of directories an zip/jar> <mainclass> [...args]`: A 
separated list of directories, JAR archives, and ZIP archives to search for class files
> **Example**: `java -cp basic.module.jar modular.HelloWorld`

> **Example**: `java -cp .\out\production\basic.module\ modular.HelloWorld`

- `java [-p | --module-path] <module path> -m <module>[/<mainclass>] [...args]`: A separated list of directories, 
each directory is a directory of modules that replace upgradeable modules in the runtime image
> **Example**: `java -p basic.module.jar -m basic.module/modular.HelloWorld`

> **Example**: `java -p .\out\production\ -m basic.module/modular.HelloWorld`

> **Note**: Previous runnable commands can be use with the additional command `--dry-run`, which loads main class but 
> doest not run it. Used for testing module dependencies are satisfied. A successful result is no output

### Info about applications

- `jar [-f | --file] <filename.jar> [-t | --list]`: List the table of content of a jar archive
> **Example**: `jar --file .\basic.module.jar --list`

- `jar [-f | --file] <filename.jar> [-d | --describe-module]`: Print the module descriptor, or automatic module name
> **Example**: `jar --file .\basic.module.jar --describe-module`

- `java [-p | --module-path] <module path> [-d | --describe-module] <module>`: Describe a module
> **Example**: `java --module-path basic.module.jar --describe-module basic.module`

> **Example**: `java --module-path .\out\production\ --describe-module basic.module`

- `jdeps <path>`: Can a 
> **Example**: `jdeps --module-path basic.module.jar --describe-module basic.module`

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
