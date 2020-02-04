
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject


fun main() {
    val observer1 = object : Observer<String> {

        override fun onNext(o: String) {
            println("observer1 onNext $o")
        }

        override fun onError(e: Throwable) {}
        override fun onComplete() {
            println("observer1 onComplete")
        }

        override fun onSubscribe(p0: Disposable) {
            println("observer1 onSubscribe")
        }
    }

    val observer2 = object : Observer<String> {
        override fun onComplete() {
            println("observer2 onComplete")
        }

        override fun onSubscribe(p0: Disposable) {
            println("observer2 onSubscribe")
        }

        override fun onNext(o: String) {
            println("observer2 onNext $o")
        }

        override fun onError(p0: Throwable) {
        }

    }
    val subject = PublishSubject.create<String>()
    // observer1 will receive all onNext and onComplete events
    // observer1 will receive all onNext and onComplete events
    subject.subscribe( observer1)
    subject.onNext("one")
    subject.onNext("two")

    // observer2 will only receive "three" and onComplete
    // observer2 will only receive "three" and onComplete
    subject.subscribe(observer2)
    subject.onNext("three")
    subject.onComplete()
}