package net.lovholm.testdata.integration

import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class ImplicitSecurityClient(var webClient: WebClient) {


    @Value("\${resource-base}")
    var resourceUri: String? = null


    fun implicitSecret(): String {
        val principal = SecurityContextHolder.getContext()?.authentication?.principal
        val result = webClient.get()
            .uri(resourceUri + "/data")
            .retrieve()
            .bodyToMono(String::class.java)

            .block()



        return result
    }

}