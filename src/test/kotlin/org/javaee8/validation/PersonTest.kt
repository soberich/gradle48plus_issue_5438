package org.javaee8.validation

import org.hibernate.validator.HibernateValidator
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import java.time.LocalDate
import javax.validation.Validation
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object PersonTest : Spek ({
    describe("tests executable validation of permission patterns`") {
        val validator = Validation.byProvider(HibernateValidator::class.java)
                        .configure().messageInterpolator(ParameterMessageInterpolator())
                        .buildValidatorFactory().validator.forExecutables()
        on("supplying wrong argument to constructor") {
            val validationResult = validator.validateConstructorParameters(Person::class.java.getDeclaredConstructor(LocalDate::class.java), arrayOf<Any?>(null))
            it("should return a non empty list of constraint violations") {
                assertNotNull(validationResult)
                assertTrue( ! validationResult.isEmpty(), "Violations present")
            }
        }
    }
})