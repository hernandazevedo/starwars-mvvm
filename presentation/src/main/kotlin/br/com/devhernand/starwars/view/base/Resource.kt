package br.com.devhernand.starwars.view.base

class Resource<out T>(val status: Status,
val data: T?,
val throwable: Throwable?) {
    companion object {
        val HASHCODE_MULTIPLIER = 31
        val ZERO = 0
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(throwable: Throwable): Resource<T> {
            return Resource(Status.ERROR, null, throwable)
        }
    }
    override fun equals(other: Any?): Boolean {

        other as Resource<*>
        return if (this === other) {
            true
        } else !(javaClass != other.javaClass ||
                status != other.status ||
                data != other.data ||
                throwable != other.throwable)
    }
    override fun hashCode(): Int {
        var result = status.hashCode()
        result = HASHCODE_MULTIPLIER * result + (data?.hashCode() ?: ZERO)
        result = HASHCODE_MULTIPLIER * result + (throwable?.hashCode() ?: ZERO)
        return result
    }

    override fun toString(): String {
        return "Resource(status=$status, data=$data, throwable=$throwable)"
    }

}

enum class Status {
    SUCCESS,
    ERROR
}
