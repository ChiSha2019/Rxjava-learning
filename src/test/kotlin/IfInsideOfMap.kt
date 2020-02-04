import io.reactivex.Observable
import io.reactivex.Single

fun main() {
    Observable.fromIterable(listOf('a', 'b', 'c', 'd', 'e', 'f'))
        .map {
            if(it >'a') {
                println(" greater than a --")
                if ( it < 'e') {
                    println(" less than e --")
                    it
                }
                it
            }
        }
        .subscribe({ println(it)},{})
}