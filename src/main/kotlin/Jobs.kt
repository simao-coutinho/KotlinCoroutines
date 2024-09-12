package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job1 = launch {
            println("Job1 launched")
            //delay(3000)

            val job2 = launch {
                println("Job2 launched")
                delay(3000)
                println("Job2 is finished")
            }

            val job3 = launch {
                println("Job3 launched")
                delay(3000)
                println("Job3 is finished")
            }

            job2.invokeOnCompletion { println("Job2 completed") }
            job3.invokeOnCompletion { println("Job3 completed") }
            println("Job1 finished")
        }

        job1.invokeOnCompletion { println("Job1 completed") }
        delay(500)
        println("Job1 will be canceled")
        job1.cancel()
    }
}