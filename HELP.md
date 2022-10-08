# Help Guide

This help guide on any topic related to the current subject

The JDK tools and their commands enable developers to handle development tasks such as compiling and running a
program, packaging source files into a Java Archive (JAR) file, applying security policies to a JAR file, and more.

The Util Commands topic lists and describes the most used Java Development Kit (JDK) commands and his arguments.
They’re grouped into the following sections based on the related functions that they perform. Details about the
used commands can be found inside the [tools guide](./TOOLS.md).

## 1. Concurrent Collections

Concurrent collection classes are generally preferable to the synchronized options. These classes have the
following characteristics in commons:

- Operations are thread-safe
- No support for locking the entire collection
- The iterator never throws a ConcurrentModificationException
- Retrieval operations do not entail locking and generally do not block
- Retrieval operations may overlap with update operations, meaning exceptions won't be thrown, but results may not
  be predictable
- Results of aggregate status methods reflect transient states when a collection is undergoing concurrent updates
- In most instances the iterator will not reflect mutations (additions, removals or changes occurring since the
  iterator was created)

---

### ArrayList

**Synchronized Options**

- Vector
- Collections.synchronizedList

**Concurrent collection Classes**

- CopyOnWriteArrayList

**Most significant feature to remember about the Concurrent collection Class**

- Costly if mutations are significant (copy a new list)
- Preferable if number of reads and traversals greatly outnumber updates
- Iterators do not support the mutative remove operation

---

### TreeSet

**Synchronized Options**

- Collections.synchronizedSortedMap

**Concurrent collection Classes**

- ConcurrentSkipListSet

**Most significant feature to remember about the Concurrent collection Class**

- Sorted according to natural order or by specified Comparator during construction
- Ascending key ordered views and their iterators are faster than descending ones
- Bulk operations (puAll, equals, toArray, containsValue, clear) are not guaranteed to be performed atomically and
  may reflect only partial insertions or removals

---

### HashSet

**Synchronized Options**

- Collections.synchronizedSet

**Concurrent collection Classes**

- CopyOnWriteArraySet

**Most significant feature to remember about the Concurrent collection Class**

- Uses an internal CopyOnWriteArrayList for all of its operations
- Best suited for small set sizes
- Best suited where read-only operations vastly outnumber mutative operations
- Iterators do not support the mutative remove operation

---

### HashMap

**Synchronized Options**

- HashTable
- Collections.synchronizedMap

**Concurrent collection Classes**

- ConcurrentHashMap

**Most significant feature to remember about the Concurrent collection Class**

- Same functional specification as HashTable
- Not sorted
- Update operation for a given ket establishes a happens-before relation with any (non-null) retrieval for that key
  reporting the updated value
- For aggregate (putAll, clear) concurrent retrievals may reflect only partial insertions or removals

---

### TreeMap

**Synchronized Options**

- Collections.synchronizedNavigableMap

**Concurrent collection Classes**

- ConcurrentSkipListMap

**Most significant feature to remember about the Concurrent collection Class**

- Does not support null elements
- Sorted according to natural order or by a specified Comparator during construction
- Ascending key ordered views and their iterators are faster than descending ones
- Bulk operations (putAll, equals, toArray, containsValue, clear) are not guaranteed to be performed atomically and
  may reflect only partial insertions and removals

---

### LinedList, Queue/Deque

**Synchronized Options**

- Collections.synchronizedList
- java.util.concurrent.SynchronousQueue

**Concurrent collection Classes**

- ConcurrentSkipListQueue
- ConcurrentSkipListDeque

**Most significant feature to remember about the Concurrent collection Class**

- Unbounded queue based on linked nodes
- The use of null elements is not permitted
- Elements are ordered FIFO
    - Head of queue = element entered first
    - Tail of queue = element entered last
- Bulk operations (addAll, removeAll, retainAll, equals, toArray) are not guaranteed to be performed atomically
- Determining the current number of elements requires traversal

---

### Summary

| Type                                           | Synchronized                           | Concurrent                    |
|------------------------------------------------|----------------------------------------|-------------------------------|
| Thread-Safe                                    | YES                                    | YES                           |
| Governed by a single exclusion lock            | YES                                    | NO                            |
| Safely permits any number of concurrent reads  | YES                                    | YES                           |
| Safely permits anu number of concurrent writes | YES                                    | DEPENDS, not guaranteed       |
| Iterators/Spliterators                         | Fast-Fail traversal                    | Weakly Consistent             |
| Throws ConcurrentModificationException         | YES                                    | NO                            |
| Traversal                                      | Throws ConcurrentModificationException | Exists once upon construction |
| Scalability                                    | Less scalable                          | More scalable                 |

---

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
