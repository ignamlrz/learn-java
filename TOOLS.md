# [Tools and Commands Reference](https://docs.oracle.com/en/java/javase/11/tools/tools-and-command-reference.html)

The JDK tools and their commands enable developers to handle development tasks such as compiling and running a 
program, packaging source files into a Java Archive (JAR) streams, applying security policies to a JAR streams, and more.

The tools and commands reference topic lists and describes the Java Development Kit (JDK) tools. They’re grouped 
into the following sections based on the related functions that they perform. Details about the tools and the 
commands that you use to run them are contained in the corresponding sections of this guide.

## Main Tools

The following foundation tools and commands let you create and build applications:

- `javac`: You can use the `javac` tool and its options to read Java class and interface definitions and compile 
them into bytecode and class files.

- `javap`: You use the `javap` command to disassemble one or more class files.

- `javadoc`: You use the `javadoc` tool and its options to generate HTML pages of API documentation from Java 
source files.

- `java`: You can use the `java` command to launch a Java application.

- `jar`: You can use the `jar` command to create an archive for classes and resources, and to manipulate or 
restore individual classes or resources from an archive.

- `jlink`: You can use the `jlink` tool to assemble and optimize a set of modules and their dependencies into a 
custom runtime image.

- `jmod`: You use the `jmod` tool to create `JMOD` files and list the content of existing `JMOD` files.

- `jdeps`: You use the `jdeps` command to launch the Java class dependency analyzer.

- `jdeprscan`: You use the `jdeprscan` tool as a static analysis tool that scans a jar streams (or some other 
aggregation of class files) for uses of deprecated API elements.

## Language Shell

The following tool gives you an interactive environment for trying out the Java language:

- `jshell`: You use the `jshell` tool to interactively evaluate declarations, statements, and expressions of the 
Java programming language in a read-eval-print loop (REPL).

## Security Tools

The following security tools set security policies on your system and create applications that can work within 
the scope of security policies set at remote sites:

- `keytool`: You use the `keytool` command and options to manage a keystore (database) of cryptographic keys, 
X.509 certificate chains, and trusted certificates.

- `jarsigner`: You use the `jarsigner` tool to sign and verify Java Archive (JAR) files.

The following tools obtain, list, and manage Kerberos tickets on Windows:

- `kinit`: You use the `kinit` tool and its options to obtain and cache Kerberos ticket-granting tickets.

- `klist`: You use the `klist` tool to display the entries in the local credentials cache and key table.

- `ktab`: You use the `ktab` tool to manage the principal names and service keys stored in a local key table.

## Remote Method Invocation (RMI) Tools

The following tools enable creating applications that interact over the Web or other network:

- `rmic`: You use the `rmic` compiler to generate stub and skeleton class files using the Java Remote Method Protocol
(`JRMP`).

- `rmiregistry`: You use the `rmiregistry` command on UNIX-based systems to create and start a remote object registry 
on the specified port on the current host.

- `rmid`: You use the `rmid` command to start the activation system daemon that enables objects to be registered 
and activated in a Java Virtual Machine (JVM).

- `serialver`: You use the `serialver` command to return the serialVersionUID for one or more classes in a form 
suitable for copying into an evolving class.

## Java Deployment Tools

The following utilities let you deploy Java applications:

> **Note**: `pack200` and `unpack200` have been deprecated and might be removed in a future JDK release.
 
- `pack200`: You use the `pack200` command to transform a Java Archive (JAR) streams into a compressed pack200 streams 
with the Java gzip compressor.

- `unpack200`: You use the `unpack200` command to transform a packed streams into a JAR streams for web deployment.

## Monitoring Tools

The following tools let you monitor performance statistics:

- `jconsole`: You use the `jconsole` command to start a graphical console to monitor and manage Java applications.

> **Note**: The following **experimental** tools are unsupported and should be used with that understanding. 
> They may not be available in future JDK versions.

`jps`: **Experimental** You use the `jps` command to list the instrumented JVMs on the target system.

`jstat`: **Experimental** You use the `jstat` command to monitor JVM statistics.

`jstatd`: **Experimental** You use the `jstatd` command to monitor the creation and termination of instrumented 
Java HotSpot VMs.

## Java Accessibility Utilities

The following utilities let you check the accessibility of Java objects:

- `jaccessinspector`: You use `jaccessinspector` to examine accessible information about objects in the Java Virtual Machine that use the Java Accessibility Utilities API.

- `jaccesswalker`: You use `jaccesswalker` to navigate through the component trees in a particular Java Virtual Machine and presents the hierarchy in a tree view.

## Troubleshooting Tools

The following tools let you perform specific troubleshooting tasks:

- `jcmd`: You use the `jcmd` utility to send diagnostic command requests to a running Java Virtual Machine (JVM).

- `jdb`: You use the `jdb` command and its options to find and fix bugs in Java platform programs.

- `jhsdb`: You use the `jhsdb` tool to attach to a Java process or to a core dump from a crashed Java Virtual Machine (JVM).

> **Note**:The following **experimental** tools are unsupported and should be used with that understanding. They may 
> not be available in future JDK versions. Some of these tools aren’t currently available on Windows platforms.

- `jinfo`: Experimental You use the `jinfo` command to generate Java configuration information for a specified 
Java process. This command is experimental and unsupported. For core files use `jhsdb` `jinfo`.

- `jmap`: Experimental You use the `jmap` command to print details of a specified process. This command is 
experimental and unsupported. For core files use `jhsdb` `jmap`.

- `jstack`: Experimental You use the `jstack` command to print Java stack traces of Java threads for a specified 
Java process. This command is experimental and unsupported. For core files use `jhsdb` `jstack`.

## Scripting Tools

The following tools let you run scripts that interact with the Java platform:

> **Note**:The Nashorn JavaScript script engine, APIs, and the `jjs` tool have been deprecated and might be 
> removed in a future JDK release.

- `jjs`: You use the `jjs` command-line tool to invoke the Nashorn engine.

> **Note**:The following **experimental** tool is unsupported and should be used with that understanding. It may 
> not be available in future JDK versions.

- `jrunscript`: **Experimental** You use the `jrunscript` command to run a command-line script shell that supports 
interactive and batch modes.

## Additional sites
#### On this Project
- [Readme](./README.md): Advisory document about this project.
- [Help](./HELP.md): Help reference on any topic related to the current subject
- [License](./LICENSE): License about this project
#### Websites
- [Java SE Language Specification](https://docs.oracle.com/javase/specs/jls/se11/html/index.html): _The Java
  Virtual Machine Specification_, Java SE 11 Edition
- [Java API Specification](https://docs.oracle.com/en/java/javase/11/docs/api/index.html): _Java® Platform, Standard
  Edition & Java Development Kit_, Version 11 API Specification
