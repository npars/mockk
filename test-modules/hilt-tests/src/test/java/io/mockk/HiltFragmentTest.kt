package io.mockk

import org.junit.Assert.assertTrue
import org.junit.Test

class HiltFragmentTest {
    @Test
    fun mockkAndroidEntryPoint() {
        val sut = mockk<HiltFragment> {
            every { theMethod() } returns true
        }
        assertTrue(sut.theMethod())
    }

    @Test
    fun spykAndroidEntryPoint() {
        val sut = spyk(HiltFragment()) {
            every { theMethod() } returns true
        }
        assertTrue(sut.theMethod())
    }
}
