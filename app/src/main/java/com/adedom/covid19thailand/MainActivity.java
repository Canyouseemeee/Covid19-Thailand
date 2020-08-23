package com.adedom.covid19thailand;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private TextView mTvDate;
    private TextView mTvConfirmed;
    private TextView mTvNewConfirmed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvDate = (TextView) findViewById(R.id.textView);
        mTvConfirmed = (TextView) findViewById(R.id.textView2);
        mTvNewConfirmed = (TextView) findViewById(R.id.textView3);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid19.th-stat.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Covid19Api api = retrofit.create(Covid19Api.class);

        api.fetchCovid19()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<CovidResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(CovidResponse covidResponse) {
                        mTvDate.setText(covidResponse.getUpdateDate());
                        mTvConfirmed.setText(covidResponse.getConfirmed() + "");
                        mTvNewConfirmed.setText(covidResponse.getNewConfirmed() + "");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}