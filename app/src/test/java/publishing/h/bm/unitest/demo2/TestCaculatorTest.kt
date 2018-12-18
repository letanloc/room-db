package publishing.h.bm.unitest.demo2

import android.os.Bundle
import android.widget.TextView
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito
import org.mockito.internal.stubbing.answers.ThrowsException

class TestCaculatorTest {
    lateinit var activity: TestCaculator;

    @Before
    fun setUp() {
        activity = TestCaculator()
        activity.caculator = Calculator()
    }

    @Test
    fun updateNumber() {
        var value = activity.extraxNumberFromTextView()

    }
}