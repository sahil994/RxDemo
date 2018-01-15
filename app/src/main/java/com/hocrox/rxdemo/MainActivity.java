package com.hocrox.rxdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;


public class MainActivity<T> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* Button button = null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                makeRxObject();

            }
        });
*/

    }

    @Override
    protected void onStart() {
        super.onStart();

        Observable observable = makeRxObject();


        observable.observeOn(AndroidSchedulers.mainThread()).
                doOnNext(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {

                    }
                })
             .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function() {
                    @Override
                    public String apply(Object o) throws Exception {
                        String s = (String) o;
                        o.equals("sahil");

                        return s;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {


                        Toast.makeText(MainActivity.this, "" + o, Toast.LENGTH_LONG).show();


                    }
                });


    }

    private Observable<String> makeRxObject() {




        Observable<String> testingObservable= Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {


                e.onNext("sahil goyal");

                e.setCancellable(new Cancellable() {
                    @Override
                    public void cancel() throws Exception {


                    }
                });


            }


        });

        return testingObservable.filter(new Predicate<String>() {
            @Override
            public boolean test(String s) throws Exception {

                if(s.length()>2){

                    return true;
                }

                return false;
            }
        }).debounce(1000, java.util.concurrent.TimeUnit.MILLISECONDS);

    }


}
