package net.lovholm.testdata.controller

import org.springframework.boot.SpringApplication.run
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class Testdatagenerator

    fun main(args: Array<String>) {
        run(Testdatagenerator::class.java, *args)
    }
