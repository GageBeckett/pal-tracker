package io.pivotal.pal.tracker

class EnvController(private val str1: String, private val str2: String, private val str3: String, private val str4: String ) {

    val env: Map<String, String> = mapOf(
        "PORT" to str1,
        "MEMORY_LIMIT" to str2,
        "CF_INSTANCE_INDEX" to str3,
        "CF_INSTANCE_ADDR" to str4
    )
}