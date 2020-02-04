import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main() {
    Observable.just("A","B","c")
        .toList()
        .subscribe({println(it)},{println("onError")})
}