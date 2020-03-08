package net.lovholm.testdata.domain

import net.lovholm.testdata.dto.IdentType
import net.lovholm.testdata.dto.Kjønn
import org.junit.Assert
import org.junit.Test
import java.time.LocalDate

class FoedselsnummerGeneratorTest {

    @Test
    fun `Første siffer i DNR har offset på 4`() {
        val fødselsnummer = FoedselsnummerGenerator(Kjønn.KVINNE, IdentType.DNR, LocalDate.of(2020, 1, 20)).generate()
        Assert.assertEquals("DNR har ikke offset på 4", '6', fødselsnummer[0])
    }

    @Test
    fun `Kvinner skal ha oddetall i 9 personnummersiffer`() {
        val fødselsnummer = FoedselsnummerGenerator(Kjønn.KVINNE, IdentType.FNR, LocalDate.of(2020, 1, 1)).generate()
        Assert.assertTrue("Niende siffer i var ikke oddetall for kvinne",fødselsnummer.get(8).toInt() % 2 == 0)

    }

    @Test
    fun `Menn skal ha oddetall i 9 personnummersiffer`() {
        val fødselsnummer = FoedselsnummerGenerator(Kjønn.MANN, IdentType.FNR, LocalDate.of(2020, 1, 1)).generate()
        Assert.assertTrue("Niende siffer i var ikke oddetall for mann",fødselsnummer.get(8).toInt() % 2 != 0)

    }



}