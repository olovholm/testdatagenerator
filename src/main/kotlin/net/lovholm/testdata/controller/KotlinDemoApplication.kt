package net.lovholm.testdata.controller

import org.springframework.boot.SpringApplication.run
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class KotlinDemoApplication

    fun main(args: Array<String>) {
        run(KotlinDemoApplication::class.java, *args)
    }
