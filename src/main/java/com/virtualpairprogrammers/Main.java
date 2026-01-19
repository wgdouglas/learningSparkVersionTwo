package com.virtualpairprogrammers;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> inputData = new ArrayList<>();
        inputData.add(35);
        inputData.add(12);
        inputData.add(90);
        inputData.add(20);

        Logger.getLogger("org.apache").setLevel(Level.WARN);

        SparkConf sparConfiguration = new SparkConf().setAppName("startingSparkReview").setMaster("local[*]");

        JavaSparkContext spackContext = new JavaSparkContext(sparConfiguration);

        JavaRDD<Integer>myRdd = spackContext.parallelize(inputData);

        // This is used to reduce two values into one
        Integer reducingResult = myRdd.reduce((value1, value2) -> value1 + value2);

        // This is used to map values into a functions desired value
        JavaRDD<Double> squareRootRDD = myRdd.map( value -> Math.sqrt(value ));

        squareRootRDD.foreach(value -> System.out.println(value + "Version 1 values"));//version 1 of using this mapping output function

        System.out.println("Version 2 mapping values below:");
        // This is a fix to stop the serialization error due to your local computer's
        // chip core & uses Java `.forEach()` to iterate over instead of Sparks `.foreach()
        squareRootRDD.collect().forEach(System.out::println);
        System.out.println("End of Version 2 mapping values");

        System.out.println( "reducingResult: " + reducingResult);

        // Find how many elements are in squareRootRdd?
        System.out.println("find number of elements in squareRootRdd: " + squareRootRDD.count());

        // Find an interim count of values & store them into a Rdd to do
        // transformations to it as an RDD: Use only .map() and .reduce() (imagine .count() cannot be used)
        JavaRDD<Long> singleIntegerRdd = squareRootRDD.map(value -> 1L);
        Long interimCountRdd= singleIntegerRdd.reduce((value1, value2) -> value1 + value2);
        System.out.println("Interim Count RDD: "+ interimCountRdd);

        spackContext.close();

    }
}
