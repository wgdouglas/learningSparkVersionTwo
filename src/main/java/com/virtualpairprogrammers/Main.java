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

        JavaRDD<Integer> originalIntegersRdd = spackContext.parallelize(inputData);

        // This is used to map values into a functions desired value
        //You'll use the java approach which should not be used consistently in Spark Java Development
        JavaRDD<IntegerWithSquareRoot> squareRootRDD = originalIntegersRdd.map( value -> new IntegerWithSquareRoot(value));

        spackContext.close();

    }
}
