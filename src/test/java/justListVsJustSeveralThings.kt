import io.reactivex.Observable

fun main(){
    Observable.just("a","b","c").subscribe { s -> println(s) }
    //val list = listOf<String>("a","b","c")
    Observable.just(listOf<String>("a","b","c")).subscribe{s -> print(s)}
}