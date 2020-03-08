package net.lovholm.testdata.dto

enum class Kjønn {
    KVINNE, MANN;

    companion object {
        fun randomKjonn(): Kjønn {
            return MANN
        }
    }
}