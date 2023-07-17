package io.mockk

import org.junit.Assert.assertTrue
import org.junit.Test

class HiltParentJavaFragmentTest {
    @Test
    fun mockkAndroidEntryPoint() {
        val sut = mockk<TestFragment> {
            every { theMethod() } returns true
        }
        assertTrue(sut.theMethod())
    }

    @Test
    fun spykAndroidEntryPoint() {
        val sut = spyk(TestFragment()) {
            every { theMethod() } returns true
        }
        assertTrue(sut.theMethod())
    }

    private class TestFragment: HiltParentJavaFragment()
}