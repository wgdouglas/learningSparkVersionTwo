package com.virtualpairprogrammers;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

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
        //This is the view of Tuples in Java/Scala with Spark Java Development which is extensively used
        JavaRDD<Tuple2<Integer, Double>> squareRootRDD = originalIntegersRdd.map( value -> new Tuple2<>(value, Math.sqrt(value)) );

        // This is where you'll use Tuples with the Object `Tuple2<>` which allows you to
        // bypass Java Object class creation for grouping values like in a list
        Tuple2<Integer, Double> groupedValueTuple = new Tuple2<> ( 9 , 3.0);// the 3.0 is a Double b/c it's a square root

        spackContext.close();

    }
}
