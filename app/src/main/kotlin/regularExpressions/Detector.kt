package regularExpressions

interface Detector {
    fun accepts(input: String): Boolean
}