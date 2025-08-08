package regularExpressions

interface State {
    fun on(char: String): State?
    fun canAccept(): Boolean
}