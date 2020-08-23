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
    private TextView mTvConfirmed;
    private TextView mTvNewConfirmed;
    private TextView mTvRecovered;
    private TextView mTvHospitalized;
    private TextView mTvDeaths;
    private TextView mTvNewRecovered;
    private TextView mTvNewHospitalized;
    private TextView mTvNewDeaths;
    private TextView mTvUpdateDate;
    private TextView mTvSource;
    private TextView mTvDevBy;
    private TextView mTvSeverBy;
    private TextView mTvStatus;
    private TextView mTvdate;
    private TextView mTvupdate_time;
    private TextView mTvbuy;
    private TextView mTvsell;
    private TextView mTvbuy2;
    private TextView mTvsell2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvStatus= (TextView) findViewById(R.id.textView);
        mTvdate= (TextView) findViewById(R.id.textView2);
        mTvupdate_time= (TextView) findViewById(R.id.textView3);
        mTvbuy= (TextView) findViewById(R.id.textView4);
        mTvsell= (TextView) findViewById(R.id.textView5);
        mTvbuy2= (TextView) findViewById(R.id.textView6);
        mTvsell2= (TextView) findViewById(R.id.textView7);



//        mTvConfirmed = (TextView) findViewById(R.id.textView);
//        mTvRecovered = (TextView) findViewById(R.id.textView2);
//        mTvHospitalized = (TextView) findViewById(R.id.textView3);
//        mTvDeaths = (TextView) findViewById(R.id.textView4);
//        mTvNewConfirmed = (TextView) findViewById(R.id.textView5);
//        mTvNewRecovered = (TextView) findViewById(R.id.textView6);
//        mTvNewHospitalized = (TextView) findViewById(R.id.textView7);
//        mTvNewDeaths = (TextView) findViewById(R.id.textView8);
//        mTvUpdateDate = (TextView) findViewById(R.id.textView9);
//        mTvSource = (TextView) findViewById(R.id.textView10);
//        mTvDevBy = (TextView) findViewById(R.id.textView11);
//        mTvSeverBy = (TextView) findViewById(R.id.textView12);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://thai-gold-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Gold api = retrofit.create(Gold.class);

        api.fetchGold()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<GoldResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(GoldResponse goldresponse) {
                        mTvStatus.setText(goldresponse.getStatus() + "");
                        mTvdate.setText(goldresponse.getObjectResponse().getDate() + "");
                        mTvupdate_time.setText(goldresponse.getObjectResponse().getUpdate_time() + "");
                        mTvbuy.setText(goldresponse.getObjectResponse().getObjectPrice().getObjectGold().getBuy() + "");
                        mTvsell.setText(goldresponse.getObjectResponse().getObjectPrice().getObjectGold().getSell() + "");
                        mTvbuy2.setText(goldresponse.getObjectResponse().getObjectPrice().getObjectGoldBar().getBuy() + "");
                        mTvsell2.setText(goldresponse.getObjectResponse().getObjectPrice().getObjectGoldBar().getSell() + "");


//                        mTvRecovered.setText(covidResponse.getRecovered() + "");
//                        mTvHospitalized.setText(covidResponse.getHospitalized() + "");
//                        mTvDeaths.setText(covidResponse.getDeaths() + "");
//                        mTvNewConfirmed.setText(covidResponse.getNewConfirmed() + "");
//                        mTvNewRecovered.setText(covidResponse.getNewRecovered() + "");
//                        mTvNewHospitalized.setText(covidResponse.getNewHospitalized() + "");
//                        mTvNewDeaths.setText(covidResponse.getNewDeaths() + "");
//                        mTvUpdateDate.setText(covidResponse.getUpdateDate() + "");
//                        mTvSource.setText(covidResponse.getSource() + "");
//                        mTvDevBy.setText(covidResponse.getDevby() + "");
//                        mTvSeverBy.setText(covidResponse.getSeverBy() + "");

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