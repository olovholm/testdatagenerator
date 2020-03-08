package net.lovholm.testdata.domain

import net.lovholm.testdata.dto.IdentType
import net.lovholm.testdata.dto.Kjønn
import org.slf4j.LoggerFactory
import java.time.LocalDate
import java.util.*

class FoedselsnummerGenerator(
    val kjønn: Kjønn,
    val identType: IdentType,
    val fødselsdato: LocalDate) {

    fun generate(): String {
        var day = String.format("%02d", fødselsdato.dayOfMonth)
        val month = String.format("%02d", fødselsdato.monthValue)
        val year = Integer.toString(fødselsdato.year).substring(2)

        if (identType == IdentType.DNR) {
            day = (day.toInt() + 40).toString()
        }

        val fullYear = fødselsdato.year

        val birthNumber = getBirthNumber(kjønn)
        if (betweenExclusive(fullYear, 1854, 1899)) {
            if (!betweenExclusive(birthNumber, 500, 749)) return generate()
        } else if (betweenExclusive(fullYear, 1900, 1999)) {
            if (!betweenExclusive(birthNumber, 0, 499)) return generate()
        } else if (betweenExclusive(fullYear, 1940, 1999)) {
            if (!betweenExclusive(birthNumber, 900, 999)) return generate()
        } else if (betweenExclusive(fullYear, 2000, 2039)) {
            if (!betweenExclusive(birthNumber, 500, 999)) return generate()
        } else {
            LOG.info("Kunne ikke identifisere fødselsnummerserie")
        }
        val withoutControlDigits = day + month + year + birthNumber
        val d1 = getDigit(withoutControlDigits, 0)
        val d2 = getDigit(withoutControlDigits, 1)
        val m1 = getDigit(withoutControlDigits, 2)
        val m2 = getDigit(withoutControlDigits, 3)
        val y1 = getDigit(withoutControlDigits, 4)
        val y2 = getDigit(withoutControlDigits, 5)
        val i1 = getDigit(withoutControlDigits, 6)
        val i2 = getDigit(withoutControlDigits, 7)
        val i3 = getDigit(withoutControlDigits, 8)
        var control1 =
            11 - (3 * d1 + 7 * d2 + 6 * m1 + 1 * m2 + 8 * y1 + 9 * y2 + 4 * i1 + 5 * i2 + 2 * i3) % 11
        if (control1 == 11) {
            control1 = 0
        }
        var control2 =
            11 - (5 * d1 + 4 * d2 + 3 * m1 + 2 * m2 + 7 * y1 + 6 * y2 + 5 * i1 + 4 * i2 + 3 * i3 + 2 * control1) % 11
        if (control2 == 11) {
            control2 = 0
        }
        return if (control1 == 10 || control2 == 10) { //Invalid number. Get a new one
            generate()
        } else withoutControlDigits + control1 + control2
    }


    companion object {
        private val LOG = LoggerFactory.getLogger(FoedselsnummerGenerator::class.java)
        private fun getDigit(text: String, index: Int): Int {
            return text.substring(index, index + 1).toInt()
        }

        private fun betweenExclusive(x: Int, min: Int, max: Int): Boolean {
            return x > min && x < max
        }

        private fun getBirthNumber(kjønn: Kjønn): Int {
            val random = Random()
            when(kjønn) {
                Kjønn.KVINNE -> return 100 + random.nextInt(900 / 2) * 2
                Kjønn.MANN -> return 100 + random.nextInt(900 / 2) * 2 + 1
            }
        }
    }

}