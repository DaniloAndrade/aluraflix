package github.com.daniloandrade

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("github.com.daniloandrade")
		.start()
}

