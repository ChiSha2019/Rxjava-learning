import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

import java.util.ArrayList;
import java.util.List;

public class FlatmapVsMap {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("a");
        list.add("c");
        System.out.println("1对1:[b, a, c]-->[b, a, c]");
        //1对1
        Observable.just(list)
                .flatMap(
                        new Function<List<String>, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(List<String> s) throws Exception {
                                System.out.println("map--1----" + s);
                                return Observable.fromArray(s);
                            }
                        })
                .subscribe(s -> {
                    System.out.println(s);
                });
        System.out.println("1对多:[b, a, c]-->b, a, c");
        //1对多
        Observable.just(list)
                .flatMap(
                        new Function<List<String>, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(List<String> s) throws Exception {
                                System.out.println("map--1----" + s);
                                return Observable.fromIterable(s);
                            }
                        })
                .subscribe(s -> {
                    System.out.println(s);
                });

        //1对多
        System.out.println("多对多:a, b, c-->[a, c]");
        Observable.just("a", "b", "c")
                .flatMap(
                        new Function<String, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(String s) throws Exception {
//                                System.out.println("map--1----" + s);
                                if (s.equalsIgnoreCase("b")) return Observable.empty();
                                return Observable.just(s);
                            }
                        })
                .subscribe(s -> {
                    System.out.println(s);
                });

        //1对多
        System.out.println("多对多:a, b, c-->a,b,c,d");
        Observable.just("a", "b", "c")
                .flatMap(
                        new Function<String, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(String s) throws Exception {
//                                System.out.println("map--1----" + s);
                                if (s.equalsIgnoreCase("c")) return Observable.just("c", "d");
                                return Observable.just(s);
                            }
                        })
                .subscribe(s -> {
                    System.out.println(s);
                });
        System.out.println("map 一对一:[b, a, c]-->[b, a, c]");
        Observable.just(list)
                .map(new Function<List<String>, List<String>>() {
                    @Override
                    public List<String> apply(List<String> strings) throws Exception {
                        strings.add("fuckkk");
                        return strings;
                    }
                })
                .subscribe(s -> {
                    System.out.println(s);
                });
    }
}
