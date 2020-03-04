package net.lovholm.testdata

import org.springframework.boot.SpringApplication.run
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class Testdatagenerator

    fun main(args: Array<String>) {
        run(Testdatagenerator::class.java, *args)
    }
