package publishing.h.bm.unitest.demo4

import android.os.Handler
import android.os.HandlerThread

/// change d
class DbThread(threarName: String) : HandlerThread(threarName) {
    private lateinit var handle: Handler

    override fun onLooperPrepared() {
        super.onLooperPrepared()
        handle = Handler(looper)
    }

    fun postTask(task: Runnable) {
        handle.post(task)
    }
}