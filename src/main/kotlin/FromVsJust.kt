import io.reactivex.Observable

//from gives you each item in the list, Just gives you the list
fun main(){
    val list1 = listOf<Int>(1,2,3,4)
    useFrom(list1)
    useJust(list1)
}

fun useJust(list: List<Int>){
    Observable.just(list)
        .subscribe{println(it)}
}

fun useFrom(list: List<Int>){
    Observable.fromIterable(list)
        .subscribe{ println(it)}
}