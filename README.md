# benchmark

 - module5-JMH-practice - домашние задания для модуля5 JVA-076

### StringConcat
Сравнение объединения строк "+", StringBuilder, StringBuffer, StringJoiner и Stream#collect  

```
Название ОС:       Windows 10
Процессор(ы):      Intel(R) Core(TM) i5-10210U CPU @ 1.60GHz
Java:              OpenJDK Runtime Environment AdoptOpenJDK-11.0.11+9
JMH:               1.37

Benchmark                   Mode  Cnt    Score   Error  Units
StringConcat.streamCollect  avgt   25   14,068 ± 0,140  us/op
StringConcat.stringBuffer   avgt   25   16,820 ± 0,135  us/op
StringConcat.stringBuilder  avgt   25    9,869 ± 0,330  us/op
StringConcat.stringConcat   avgt   25  580,805 ± 2,011  us/op
StringConcat.stringJoiner   avgt   25   15,618 ± 0,322  us/op
```

### SortingAlgorithm
Сравнение алгоритмов сортировки 

```
Название ОС:       Windows 10
Процессор(ы):      Intel(R) Core(TM) i5-10210U CPU @ 1.60GHz
Java:              OpenJDK Runtime Environment AdoptOpenJDK-11.0.11+9
JMH:               1.37

Benchmark                    (srcArraySize)  (srcArrayType)  Mode  Cnt      Score      Error  Units
SortingAlgorithm.bubbleSort             100          RANDOM  avgt   25     11,862 ±    0,439  us/op
SortingAlgorithm.bubbleSort             100             ASC  avgt   25      0,072 ±    0,001  us/op
SortingAlgorithm.bubbleSort             100            DESC  avgt   25     13,637 ±    1,374  us/op
SortingAlgorithm.bubbleSort             500          RANDOM  avgt   25    389,661 ±   20,567  us/op
SortingAlgorithm.bubbleSort             500             ASC  avgt   25      0,287 ±    0,005  us/op
SortingAlgorithm.bubbleSort             500            DESC  avgt   25    395,570 ±   11,393  us/op
SortingAlgorithm.bubbleSort            1000          RANDOM  avgt   25   2271,426 ±   20,236  us/op
SortingAlgorithm.bubbleSort            1000             ASC  avgt   25      0,578 ±    0,027  us/op
SortingAlgorithm.bubbleSort            1000            DESC  avgt   25   2366,841 ±    6,752  us/op
SortingAlgorithm.bubbleSort            5000          RANDOM  avgt   25  78656,159 ± 7335,809  us/op
SortingAlgorithm.bubbleSort            5000             ASC  avgt   25      4,788 ±    0,067  us/op
SortingAlgorithm.bubbleSort            5000            DESC  avgt   25  67644,585 ± 3343,745  us/op
SortingAlgorithm.quickSort              100          RANDOM  avgt   25      2,411 ±    0,084  us/op
SortingAlgorithm.quickSort              100             ASC  avgt   25      1,151 ±    0,017  us/op
SortingAlgorithm.quickSort              100            DESC  avgt   25      1,642 ±    0,036  us/op
SortingAlgorithm.quickSort              500          RANDOM  avgt   25     16,131 ±    0,613  us/op
SortingAlgorithm.quickSort              500             ASC  avgt   25      6,145 ±    0,095  us/op
SortingAlgorithm.quickSort              500            DESC  avgt   25     10,150 ±    0,119  us/op
SortingAlgorithm.quickSort             1000          RANDOM  avgt   25     61,663 ±    1,646  us/op
SortingAlgorithm.quickSort             1000             ASC  avgt   25     13,298 ±    0,061  us/op
SortingAlgorithm.quickSort             1000            DESC  avgt   25     21,986 ±    0,733  us/op
SortingAlgorithm.quickSort             5000          RANDOM  avgt   25    504,681 ±    7,913  us/op
SortingAlgorithm.quickSort             5000             ASC  avgt   25     94,225 ±    7,093  us/op
SortingAlgorithm.quickSort             5000            DESC  avgt   25    128,572 ±    8,812  us/op

```

---
### Ссылки
 - [https://github.com/openjdk/jmh](https://github.com/openjdk/jmh)  
 - [https://jenkov.com/tutorials/java-performance/jmh.html](https://jenkov.com/tutorials/java-performance/jmh.html)  
 - [Хабр. Сбер. Как замерять и повышать производительность Java-кода: личный пример с JMH](https://habr.com/ru/companies/sberbank/articles/814299/)  