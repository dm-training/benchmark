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
import java.io.IOException;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

/**
 * Сравнение объединения строк "+", StringBuilder, StringBuffer и StringJoiner
 */
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 100, timeUnit = TimeUnit.MILLISECONDS)
public class StringConcat {
    private static final int STR_ARRAY_SIZE = 1000;
    private static final String STR = "string-concat|";

    private String[] strArr = new String[STR_ARRAY_SIZE];

    @Setup(Level.Invocation)
    public void setup() {
        //System.out.println("fill str array");
        for (int i = 0; i < STR_ARRAY_SIZE; ++i) {
            strArr[i] = STR;
        }
    }

    @Benchmark
    public String stringConcat() {
        String result = "";
        for (int i = 0; i < STR_ARRAY_SIZE; i++) {
            result += strArr[i];
        }
        //System.out.println("stringConcat: " + result);
        return result;
    }

    @Benchmark
    public String stringBuilder() {
        StringBuilder result = new StringBuilder(STR_ARRAY_SIZE * STR.length());
        for (int i = 0; i < STR_ARRAY_SIZE; i++) {
            result.append(strArr[i]);
        }
        //System.out.println("stringBuilder: " + result);
        return result.toString();
    }

    @Benchmark
    public String stringBuffer() {
        StringBuffer result = new StringBuffer(STR_ARRAY_SIZE * STR.length());
        for (int i = 0; i < STR_ARRAY_SIZE; i++) {
            result.append(strArr[i]);
        }
        //System.out.println("stringBuffer: " + result);
        return result.toString();
    }

    @Benchmark
    public String stringJoiner() {
        StringJoiner result = new StringJoiner("");
        for (int i = 0; i < STR_ARRAY_SIZE; i++) {
            result.add(strArr[i]);
        }
        //System.out.println("stringJoiner: " + result);
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}
