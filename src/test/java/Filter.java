import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filter {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        Observable.just(list)
/*                .flatMap(s -> {return Observable.fromIterable(s);})
                .filter(s -> {return s > 3;})*/
/*                .map(s -> {s.add(11); return s;})
                .flatMapIterable(it -> {return it;})
                .filter(s -> {return s > 3;})
                .map(s -> {return s + 10;})*/
                .subscribe(s ->{System.out.println(s);});
    }
}
