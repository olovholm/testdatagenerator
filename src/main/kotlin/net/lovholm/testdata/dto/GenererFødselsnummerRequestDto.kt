package net.lovholm.testdata.dto

import com.fasterxml.jackson.annotation.JsonFormat
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema
data class GenererFødselsnummerRequestDto(
    val identType: IdentType,
    val kjønn: Kjønn,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    var fodselsdato: LocalDate
)