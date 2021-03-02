package io.pivotal.pal.tracker

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EnvController(
    @Value("\${port:NOT SET}")
    private val port: String,
    @Value("\${memory.limit:NOT SET}")
    private val memoryLimit: String,
    @Value("\${cf.instance.index:NOT SET}")
    private val cfIndex: String,
    @Value("\${cf.instance.addr:NOT SET}")
    private val cfAddress: String ) {

    @GetMapping("/env")
    fun getEnv(): Map<String, String> {
        return mapOf(
            "PORT" to port,
            "MEMORY_LIMIT" to memoryLimit,
            "CF_INSTANCE_INDEX" to cfIndex,
            "CF_INSTANCE_ADDR" to cfAddress
        )
    }
}