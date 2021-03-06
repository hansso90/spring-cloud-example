package nl.lemkes.boot.cloud.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient


@SpringBootApplication
@EnableDiscoveryClient
class RibbonTimeApplication

fun main(args: Array<String>) {
    SpringApplication.run(RibbonTimeApplication::class.java, *args)
}

