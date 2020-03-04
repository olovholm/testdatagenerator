package net.lovholm.testdata.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("personident")
class PersonIdentController {

    @RequestMapping(method = [RequestMethod.GET], path = ["/"])
    fun get() : ResponseEntity<String> {

        return ResponseEntity.ok("OK")
    }

}