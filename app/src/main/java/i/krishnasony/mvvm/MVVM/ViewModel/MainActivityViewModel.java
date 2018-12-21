package i.krishnasony.mvvm.MVVM.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import i.krishnasony.mvvm.ApiService.ApiInterface;
import i.krishnasony.mvvm.MVVM.Model.Results;
import i.krishnasony.mvvm.MVVM.Model.SongList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityViewModel extends ViewModel {
    String BASE_URL ="https://soundcast.back4app.io";
    private MutableLiveData<List<Results>> songList;
    //we will call this method to get the data
    public LiveData<List<Results>> getSongs() {
        //if the list is null
        if (songList == null) {
            songList = new MutableLiveData<List<Results>>();
            //we will load it asynchronously from server in this method
            loadSongs();
        }

        return songList;
        }

    private void loadSongs() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        retrofit.create(ApiInterface.class).getSonglist().enqueue(new Callback<SongList>() {
            @Override
            public void onResponse(Call<SongList> call, Response<SongList> response) {
                songList.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<SongList> call, Throwable t) {
            t.getLocalizedMessage();
            }
        });

    }

}
