## Benchmark Final and Non-Finale Inline Variables

## How to use :

Run **BenchmarkTest** as **JUnit** Test

## Expected Result

|Benchmark                                   |Mode   |Cnt |Score   |Error  |Units
---------------------------------------------|------ |----|--------|-------|-----
|BenchmarkTest.benchmark_final_variable      |avgt   |10  |244,934    |27,719  |ms/op
|BenchmarkTest.benchmark_non_final_variable  |avgt   |10  |386,145    |35,478  |ms/op

This very basic benchmark demonstrates a gain of performance of **36%** when accessing a final inline variable rather than a non final variable 

**Gain of 36%** = (1-(244/386))*100

**NB:** **Error** column is an average of the measurement time error. 
