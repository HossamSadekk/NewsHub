package com.example.common.extension

inline fun <reified T : Any> Any.cast(): T {
    return this as T
}
val Any.classTag: String get() = this.javaClass.canonicalName.orEmpty()

val Any.methodTag get() = classTag + object : Any() {}.javaClass.enclosingMethod?.name

fun Any.hashCodeAsString(): String {
    return hashCode().toString()
}
