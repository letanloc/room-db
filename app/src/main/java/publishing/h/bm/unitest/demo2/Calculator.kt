package publishing.h.bm.unitest.demo2

class Calculator {

    fun timesTwo(input: Int): Int {
        if (input > Int.MAX_VALUE / 2 || input < Int.MIN_VALUE) {
            return -1
        }
        return input * 2
    }
}