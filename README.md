# benchmark

 - module5-JMH-practice - домашние задания для модуля5 JVA-076

### StringConcat
Сравнение объединения строк "+", StringBuilder, StringBuffer, StringJoiner и Stream#collect  

```
Название ОС:                      Майкрософт Windows 10 Корпоративная
Процессор(ы):                     Число процессоров - 1.
                                  [01]: Intel64 Family 6 Model 142 Stepping 12 GenuineIntel ~1609 МГц
OpenJDK Runtime Environment AdoptOpenJDK-11.0.11+9 (build 11.0.11+9)

Benchmark                   Mode  Cnt    Score   Error  Units
StringConcat.streamCollect  avgt   25   14,068 ± 0,140  us/op
StringConcat.stringBuffer   avgt   25   16,820 ± 0,135  us/op
StringConcat.stringBuilder  avgt   25    9,869 ± 0,330  us/op
StringConcat.stringConcat   avgt   25  580,805 ± 2,011  us/op
StringConcat.stringJoiner   avgt   25   15,618 ± 0,322  us/op
```

---
### Ссылки
 - [https://github.com/openjdk/jmh](https://github.com/openjdk/jmh)  
 - [Хабр. Сбер. Как замерять и повышать производительность Java-кода: личный пример с JMH](https://habr.com/ru/companies/sberbank/articles/814299/)  