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

        Integer mappingResult = myRdd.reduce((value1, value2) -> value1 + value2);

        System.out.println(mappingResult);

        spackContext.close();

    }
}
