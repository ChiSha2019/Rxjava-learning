import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

import java.util.Arrays;
import java.util.List;

public class CreateVsJustVsFrom {
    public static void main(String[] args) {
        Observable<String> myObservable = Observable.create( emitter -> {
            emitter.onNext("A");
            emitter.onNext("B");
            emitter.onNext("C");
            emitter.onComplete();
        });

        myObservable.subscribe(s -> System.out.println(s));

        System.out.println("***** fromArray *****");
        Observable.fromArray(Arrays.asList("a", "b","c","d"))
                .flatMap(s -> {return Observable.fromIterable(s);})
                .filter(s -> {
                    return s.equals("a") || s.equals("b");
                })
                .map(s -> {return s + " :)";})
                .subscribe(s -> {
                    System.out.println(s);
                }, s -> System.out.println("OnError"), new Action() {
                    @Override
                    public void run() throws Exception {
                        System.out.println("OnComplete!!!!");
                    }
                });

        System.out.println("***** fromIterable *****");
        Observable.fromIterable(Arrays.asList("a", "b","c","d"))
                .map(s -> {return s + " :(";})
                .subscribe(
                        //s -> {System.out.println(s);}
                        new Observer<String>() {
                            @Override
                            public void onSubscribe(Disposable disposable) {

                            }

                            @Override
                            public void onNext(String s) {

                            }

                            @Override
                            public void onError(Throwable throwable) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        }
                );
    }
}
