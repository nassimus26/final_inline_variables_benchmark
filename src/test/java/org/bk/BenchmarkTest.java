package org.bk;

import benchmark.Data;
import benchmark.DataWithFinal;
import benchmark.DataWithNonFinal;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.openjdk.jmh.runner.options.VerboseMode;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class BenchmarkTest {

    @Benchmark
    public void benchmark_final_variable(){
        processString(new DataWithFinal());
    }

    @Benchmark
    public void benchmark_non_final_variable(){
        processString(new DataWithNonFinal());
    }

    private void processString(Data data){
        for (long i=0; i<100_000_000;i++)
            if (data.getName().isEmpty());
    }
    /**
     * Benchmark run with Junit
     * @throws Exception
     */
    @Test
    public void benchmark() throws Exception {
        Options opt = initBench();
        runBench(opt);
    }

    private Options initBench() {
        return new OptionsBuilder()
                .include(org.openjdk.jmh.annotations.Benchmark.class.getSimpleName() + ".*")
                .mode(Mode.AverageTime)
                .verbosity(VerboseMode.NORMAL)
                .timeUnit(TimeUnit.MILLISECONDS)
                .warmupTime(TimeValue.milliseconds(10))
                .measurementTime(TimeValue.milliseconds(10))
                .threads(1)
                .warmupIterations(5)
                .measurementIterations(10)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .forks(0)
                .build();
    }

    /**
     * @param opt
     * @return
     * @throws RunnerException
     */
    private Collection<RunResult> runBench(Options opt) throws RunnerException {
        return new Runner(opt).run();
    }
}