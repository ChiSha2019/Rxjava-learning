/*fun main() {
    val getterSetter = GetterSetter()
    println("age = ${getterSetter.age}")
    println("name = ${getterSetter.name}")
}*/
class GetterSetter{
    var age :Int = 10
    set(value){
        field = value
    }
    get() = if(field > 10) field else 2

    var name : String = "hello"
    get() = field + "hahahaha"
}