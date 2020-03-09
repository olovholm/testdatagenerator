package net.lovholm.testdata.controller

import net.lovholm.testdata.integration.ImplicitSecurityClient
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class ServiceUserTestService {

    companion object {
        val LOG = LoggerFactory.getLogger(ServiceUserTestService.javaClass)
    }
    
    @Autowired
    lateinit var implicitSecurityClient: ImplicitSecurityClient


    @Scheduled(fixedRate = 20000)
    fun gjørKallMotSikretTjenesteMedWebClient() : ResponseEntity<String> {
        LOG.info("Test")
        val implicitSecret = implicitSecurityClient.implicitSecret()
        return ResponseEntity.ok("OK:  $implicitSecret")
    }

}