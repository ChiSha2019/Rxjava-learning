import io.reactivex.Observable
import io.reactivex.Single

fun main() {
    Observable.fromIterable(listOf('a', 'b', 'c', 'd', 'e', 'f'))
        //.filter { it < 'd' }
        .filter{it > 'f'}
        .defaultIfEmpty('l')
        .subscribe({ println(it)},{})
}