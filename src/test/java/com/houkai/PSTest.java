package com.houkai;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * 1. Warmup
 *    预热，由于JVM中对于特定代码会存在优化（本地化），预热对于测试结果很重要
 * 2. Mesurement
 *    总共执行多少次测试
 * 3. Timeout
 * 4. Threads
 *    线程数，由fork指定
 * 5. Benchmark mode
 *    基准测试的模式
 * 6. Benchmark
 *    测试哪一段代码
 *    @Warmup(iterations = 1, time = 3) //默认5次,每次10秒
 *     @Fork(5)//用多少个线程执行
 *     @BenchmarkMode(Mode.Throughput)//基准测试模式,通用Throughput
 *     @Measurement(iterations = 1, time = 3)//整个测试测多少遍,调这个方法要调多少次
 */
public class PSTest {
    @Benchmark
    public void testForEach() {
        PS.foreach();
    }
}

/*
# JMH version: 1.21
# VM version: JDK 1.8.0_231, Java HotSpot(TM) 64-Bit Server VM, 25.231-b11
# VM invoker: E:\java\JDK8\jre\bin\java.exe
# VM options: -Dfile.encoding=UTF-8
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.houkai.PSTest.testForEach

# Run progress: 0.00% complete, ETA 00:08:20
# Fork: 1 of 5
# Warmup Iteration   1: 0.571 ops/s
# Warmup Iteration   2: 0.494 ops/s
# Warmup Iteration   3: 0.364 ops/s
# Warmup Iteration   4: 0.546 ops/s
# Warmup Iteration   5: 0.665 ops/s
Iteration   1: 0.691 ops/s
Iteration   2: 0.660 ops/s
Iteration   3: 0.724 ops/s
Iteration   4: 0.727 ops/s
Iteration   5: 0.690 ops/s

# Run progress: 20.00% complete, ETA 00:07:15
# Fork: 2 of 5
# Warmup Iteration   1: 0.646 ops/s
# Warmup Iteration   2: 0.685 ops/s
# Warmup Iteration   3: 0.643 ops/s
# Warmup Iteration   4: 0.600 ops/s
# Warmup Iteration   5: 0.588 ops/s
Iteration   1: 0.579 ops/s
Iteration   2: 0.682 ops/s
Iteration   3: 0.600 ops/s
Iteration   4: 0.531 ops/s
Iteration   5: 0.641 ops/s

# Run progress: 40.00% complete, ETA 00:05:23
# Fork: 3 of 5
# Warmup Iteration   1: 0.697 ops/s
# Warmup Iteration   2: 0.657 ops/s
# Warmup Iteration   3: 0.604 ops/s
# Warmup Iteration   4: 0.651 ops/s
# Warmup Iteration   5: 0.706 ops/s
Iteration   1: 0.669 ops/s
Iteration   2: 0.682 ops/s
Iteration   3: 0.673 ops/s
Iteration   4: 0.595 ops/s
Iteration   5: 0.646 ops/s

# Run progress: 60.00% complete, ETA 00:03:35
# Fork: 4 of 5
# Warmup Iteration   1: 0.550 ops/s
# Warmup Iteration   2: 0.698 ops/s
# Warmup Iteration   3: 0.679 ops/s
# Warmup Iteration   4: 0.597 ops/s
# Warmup Iteration   5: 0.633 ops/s
Iteration   1: 0.732 ops/s
Iteration   2: 0.699 ops/s
Iteration   3: 0.531 ops/s
Iteration   4: 0.509 ops/s
Iteration   5: 0.565 ops/s

# Run progress: 80.00% complete, ETA 00:01:47
# Fork: 5 of 5
# Warmup Iteration   1: 0.564 ops/s
# Warmup Iteration   2: 0.558 ops/s
# Warmup Iteration   3: 0.538 ops/s
# Warmup Iteration   4: 0.560 ops/s
# Warmup Iteration   5: 0.568 ops/s
Iteration   1: 0.557 ops/s
Iteration   2: 0.556 ops/s
Iteration   3: 0.633 ops/s
Iteration   4: 0.631 ops/s
Iteration   5: 0.549 ops/s


Result "com.houkai.PSTest.testForEach":
0.630 ±(99.9%) 0.051 ops/s [Average]
(min, avg, max) = (0.509, 0.630, 0.732), stdev = 0.068
CI (99.9%): [0.579, 0.681] (assumes normal distribution)


# Run complete. Total time: 00:09:01

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark            Mode  Cnt  Score   Error  Units
PSTest.testForEach  thrpt   25  0.630 ± 0.051  ops/s
*/
