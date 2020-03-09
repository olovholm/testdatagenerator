package net.lovholm.testdata

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableWebSecurity
@EnableScheduling
open class Testdatagenerator {

}


fun main(args: Array<String>) {
    SpringApplication.run(Testdatagenerator::class.java, *args)
}




