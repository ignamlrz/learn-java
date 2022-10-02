# Help Guide

This help guide on any topic related to the current subject

The JDK tools and their commands enable developers to handle development tasks such as compiling and running a 
program, packaging source files into a Java Archive (JAR) file, applying security policies to a JAR file, and more.

The Util Commands topic lists and describes the most used Java Development Kit (JDK) commands and his arguments. 
They’re grouped  into the following sections based on the related functions that they perform. Details about the
used commands can be found inside the [tools guide](./TOOLS.md).

## 1. Compilation

---

#### javac -d \<directory> --module-source-path \<module source path> [-m | --module] \<module>
Compile a module: 
- `-d <directory>`: Specify where to place generated class files
- `--module-source-path <module source path>`: Specify where to find input source files 
for multiple modules
- `[-m | --module] <module>`: A comma-separated list of modules to compile
  on the operation

```shell
# Will compile all projects, because app dependes on all projects (core and utils)
javac -d out/production --module-source-path=./*/src/ -m advanced.module.app
```

> 📘 Info
>
> If you take a look on **advanced.module.utils**/_base.sample.interfaces.Countable.class_, you will see that not contain 
> any relationship with packages of **advanced.module.core**, because here is using static values of these packages.
> 
> Also, is transpiled to text, and we could execute without specify **advanced.module.core** module on class-path or 
> module-path

## 2. Build Java Archives (JAR)

---

#### jar [-c | --create] [-f | --file] <filename.jar> [-e | --main-class] \<mainclass> \[-C \<directory> \[\<files>]]: 
Creation of a new Java Archive (JAR) from modular compiled files:
  - `[-c | --create]`: Specify we want to create a JAR
  - `[-f | --file] <filename.jar>`: The archive file name. When omitted, either stdin or stdout is used based on the 
    operation
  - `[-e | --main-class] <mainclass>`: The application entry point for stand-alone applications bundled into a 
    modular, or executable, jar archive
  - `-C <directory>`: Change to the specified directory

```shell
jar -c -f out/app.jar -p out/production -e org.app.entity.BaseEntity -C out/production/advanced.module.app/ .
jar -c -f out/utils.jar -p out/production -e base.sample.interfaces.Countable -C out/production/advanced.module.utils/ .
```

## 3. Run applications

---

#### java [-cp | -classpath | --class-path] <class search path of directories an zip/jar> \<mainclass> [...args]
Run app, where is passed with a classpath (expecting a list of directories, JAR archives, and ZIP archives)

```shell
# Should return same thing
java -cp out/production/advanced.module.utils base.sample.interfaces.Countable
java -cp out/utils.jar base.sample.interfaces.Countable
```

---

#### java [-p | --module-path] \<module path> -m \<module>/\[\<main class>] [...args]
A separated list of directories, each directory is a directory of modules that replace upgradeable modules in the 
runtime image

```shell
java -p out/production -m advanced.module.app/org.app.entity.BaseEntity
```

> 📘 Info
>
> Previous runnable commands can be use with the additional command `--dry-run`, which loads main class but doest 
> not run it. Used for testing module dependencies are satisfied. A successful result is no output

## 4. Info about applications

---

#### java --list-modules
List observable modules

```shell
java -p out/production --list-modules
```

---

#### java --describe-module <module>
List of packages that contain that module

```shell
java -p out/app.jar:out/utils.jar --describe-module advanced.module.app
java -p out/production/ --describe-module advanced.module.app
```

---

#### jar [-f | --file] \<filename.jar> [-d | --describe-module]
Print the module descriptor, or automatic module name

```shell
jar -f out/app.jar --describe-module
```

---

#### jar [-f | --file] \<filename.jar> [-t | --list]
List the table of content of a jar archive

```shell
jar --file out/app.jar -t
```

## 5. Info about dependencies

---

#### jdeps [-s | -summary]
Print dependency summary only

```shell
jdeps -s out/production/advanced.module.core
```

---

#### jdeps [-v | -verbose]
Print all class level dependencies

```shell
jdeps -v out/production/advanced.module.core
```

---

#### jdeps --list-deps
Lists the module dependencies. It also prints any internal API packages if referenced. This options transitively
analyzes libraries on class path and module path if referenced

```shell
jdeps --list-deps --module-path out/production out/production/advanced.module.app
```

---

#### jdeps --list-reduced-deps
Same as `--list-deps` with not listing the implied reads edges from the module graph

```shell
jdeps --list-reduced-deps --module-path out/production -m  advanced.module.app
```

---

#### jdeps --print-module-deps
Same as `--list-reduced-deps` with printing a comma-separated list of modules dependencies


```shell
jdeps --print-module-deps --module-path out/production -m advanced.module.app
```

---

#### jdeps --check \<module\>[,<module-name>]
Analyze the module dependencies. It prints the module descriptor,
the resulting module dependencies after analysis and the graph after transition reduction. It also identifies
any unused qualified exports

```shell
jdeps --module-path out/production -m advanced.module.app
```

---

> 📘 Note
>
> `jdeps` not contain the option `-p` as other commands (`java`, `javac`, `jar`) because here the options
refer to package (`-p` | `-package` | `--package`). Still, it contains the `--module-option`, which works same as other
commands

# Additional sites
- [Readme](./README.md): Advisory document about this project.
- [Tools](./TOOLS.md): A set of tools and commands reference topic lists and describes the
  Java Development Kit (JDK) tools
- [License](./LICENSE): License about this project
# Websites
- [Java SE Language Specification](https://docs.oracle.com/javase/specs/jls/se11/html/index.html): _The Java
  Virtual Machine Specification_, Java SE 11 Edition
- [Java API Specification](https://docs.oracle.com/en/java/javase/11/docs/api/index.html): _Java® Platform, Standard
  Edition & Java Development Kit_, Version 11 API Specification
