package net.lovholm.testdata

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
open class Testdatagenerator {

}


fun main(args: Array<String>) {
    SpringApplication.run(Testdatagenerator::class.java, *args)
}




