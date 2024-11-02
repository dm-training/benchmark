package com.luxoft.trainings.jmh.practice;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Сравнение алгоритмов сортировки.
 */
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class SortingAlgorithm {
    /** Порядок элементов в массиве. */
    public enum SrcArrayType {
        /** Случайный. */
        RANDOM,
        /** Возрастающий. */
        ASC,
        /** Убывающий. */
        DESC};

    /** Числа в массиве от 0 до NUMBER_BOUND. */
    private static final int NUMBER_BOUND = 100_000;

    /** Размер массива. */
    //@Param({"7"})
    @Param({"100", "500", "1000", "5000"})
    private int srcArraySize;

    @Param({"RANDOM", "ASC", "DESC"})
    private SrcArrayType srcArrayType;

    private Integer[] srcArray;

    private Integer[] sortedArray;

    @Setup
    public void setup() {
        //srcArray = new Integer[srcArraySize];
        //final Random random = new Random();
        //Arrays.setAll(srcArray, (x) -> random.nextInt(NUMBER_BOUND));
        srcArray = new Random().ints(srcArraySize, 0, NUMBER_BOUND)
                .boxed().toArray(Integer[]::new);
        sortedArray = new Integer[srcArraySize];

        switch (srcArrayType) {
            case RANDOM:
                break;
            case ASC:
                Arrays.sort(srcArray);
                break;
            case DESC:
                Arrays.sort(srcArray, Comparator.reverseOrder());
                break;
        }
        System.out.printf("\nsrcArrayType: %s\nsrcArraySize: %d\nsrcArray: %s\n",
                srcArrayType, srcArraySize, srcArraySize < 10 ? Arrays.toString(srcArray) : "");
    }

    @Benchmark
    public void bubbleSort(Blackhole bh) {
        System.arraycopy(srcArray, 0, sortedArray, 0, srcArray.length);
        bubbleSort(sortedArray);
        //System.out.printf("bubbleSort: %s\n", Arrays.toString(sortedArr));
        bh.consume(sortedArray);
    }

    @Benchmark
    public void quickSort(Blackhole bh) {
        System.arraycopy(srcArray, 0, sortedArray, 0, srcArray.length);
        quickSort(sortedArray);
        //System.out.printf("quickSort: %s\n", Arrays.toString(sortedArr));
        bh.consume(sortedArray);
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        boolean swap;
        for (int i = 1; i < arr.length; i++) {
            swap = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int a, int b) {
        if (a < b) {
            int i = a, j = b;
            T x = arr[(i + j) / 2];

            do {
                while (arr[i].compareTo(x) < 0) i++;
                while (x.compareTo(arr[j]) < 0) j--;

                if ( i <= j) {
                    T tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    i++;
                    j--;
                }

            } while (i <= j);

            quickSort(arr, a, j);
            quickSort(arr, i, b);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SortingAlgorithm.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
