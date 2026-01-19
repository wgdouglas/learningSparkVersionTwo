# Apache Spark for Java Developers  🌟

## Objectives to learn
1. [ ] Use functional style Java to define complex data processing jobs
2. [ ] Learn the differences between the RDD and DataFrame APIs
3. [ ] Use an SQL style syntax to produce reports against Big Data sets
4. [ ] Use Machine Learning Algorithms with Big Data and SparkML
5. [ ] Connect Spark to Apache Kafka to process Streams of Big Data
6. [ ] See how Structured Streaming can be used to build pipelines with Kafka

### Requirements
Java 8 is required for the course. Spark does not currently support Java9+, and you need Java 8 for the functional Lambda syntax
Previous knowledge of Java is assumed, but anything above the basics is explained
Some previous SQL will be useful for part of the course, but if you've never used it before this will be a good first experience

### Brief Overview of what's in the repo

- As you are new to Data Science and want to find out about how massive datasets are processed in parallel, then the Java API for spark is a great way to get started, fast.
- All the fundamentals you need to understand the main operations you can perform in Spark Core, SparkSQL and DataFrames are covered in detail, with easy to follow examples. You'll be able to follow along with all the examples, and run them on your own local development computer.
- Included with the repo's practice is a module covering SparkML, an exciting addition to Spark that allows you to apply Machine Learning models to your Big Data!
    - No mathematical experience is necessary!
    - And finally, there's a full module covering Spark Streaming, where you will get hands-on experience of integrating Spark with Apache Kafka to handle real-time big data streams.
        - We use both the DStream and the Structured Streaming APIs.
- Optionally, if you have an AWS account, you'll see how to deploy your work to a live EMR (Elastic Map Reduce) hardware cluster.
    - If you're not familiar with AWS you can skip this portion in the repo, but it's still worthwhile to read through.
- This repo goes deep into the internals of Spark, you'll find out how it optimizes it's execution plans.
    - We'll be comparing the performance of RDDs vs SparkSQL, and learn about the major performance pitfalls which could save a lot of money for live projects.
- Throughout the course, you'll be getting some great practice with Java Lambdas - a great way to learn functional-style Java if you're new to it.