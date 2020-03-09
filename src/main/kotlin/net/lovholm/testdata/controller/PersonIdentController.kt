package net.lovholm.testdata.controller

import io.swagger.v3.oas.annotations.Operation
import net.lovholm.testdata.domain.FoedselsnummerGenerator
import net.lovholm.testdata.dto.GenererFødselsnummerRequestDto
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("personident")
class PersonIdentController {

    @RequestMapping(method = [RequestMethod.POST], path = ["/fodselsnummer"],
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        produces = arrayOf(MediaType.TEXT_PLAIN_VALUE) )
    @Operation(description = "Generer syntetiske FNR/DNR")
    fun genererFødselsnummer(@org.springframework.web.bind.annotation.RequestBody request: GenererFødselsnummerRequestDto) : ResponseEntity<String> {
        val generatedResult = FoedselsnummerGenerator(request.kjønn, request.identType, request.fodselsdato).generate()
        return ResponseEntity.ok(generatedResult)
    }

}