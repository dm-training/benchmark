package com.luxoft.trainings.jmh.practice;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import java.io.IOException;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Сравнение объединения строк "+", StringBuilder, StringBuffer, StringJoiner и Stream#collect
 */
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class StringConcat {
    private static final int STR_ARRAY_SIZE = 1000;
    private static final String STR = "string-concat|";

    private String[] strArr = new String[STR_ARRAY_SIZE];

    @Setup
    public void setup() {
        //System.out.println("fill str array");
        for (int i = 0; i < STR_ARRAY_SIZE; ++i) {
            strArr[i] = STR;
        }
    }

    @Benchmark
    public void stringConcat(Blackhole bh) {
        String result = "";
        for (int i = 0; i < STR_ARRAY_SIZE; i++) {
            result += strArr[i];
        }
        //System.out.println("stringConcat: " + result);
        bh.consume(result);
    }

    @Benchmark
    public void stringBuilder(Blackhole bh) {
        StringBuilder result = new StringBuilder(STR_ARRAY_SIZE * STR.length());
        for (int i = 0; i < STR_ARRAY_SIZE; i++) {
            result.append(strArr[i]);
        }
        //System.out.println("stringBuilder: " + result);
        bh.consume(result.toString());
    }

    @Benchmark
    public void stringBuffer(Blackhole bh) {
        StringBuffer result = new StringBuffer(STR_ARRAY_SIZE * STR.length());
        for (int i = 0; i < STR_ARRAY_SIZE; i++) {
            result.append(strArr[i]);
        }
        //System.out.println("stringBuffer: " + result);
        bh.consume(result.toString());
    }

    @Benchmark
    public void stringJoiner(Blackhole bh) {
        StringJoiner result = new StringJoiner("");
        for (int i = 0; i < STR_ARRAY_SIZE; i++) {
            result.add(strArr[i]);
        }
        //System.out.println("stringJoiner: " + result);
        bh.consume(result.toString());
    }

    @Benchmark
    public void streamCollect(Blackhole bh) {
        String result = Stream.of(strArr)
                .collect(Collectors.joining());
        //System.out.println("streamCollect: " + result);
        bh.consume(result);
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}
