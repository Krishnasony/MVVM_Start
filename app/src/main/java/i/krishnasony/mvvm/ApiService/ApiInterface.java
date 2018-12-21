package i.krishnasony.mvvm.ApiService;

import java.util.List;

import i.krishnasony.mvvm.MVVM.Model.Results;
import i.krishnasony.mvvm.MVVM.Model.SongList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {


    @Headers({
            "X-Parse-Application-Id: VSPdpDKRMND382hqIRFIaiVLgbkhM0E1rL32l1SQ",
            "X-Parse-REST-API-Key: E4ZeObhQv3XoHaQ3Q6baHGgbDPOkuO9jPlY9gzgA"}
    )
    @GET("/classes/songs_library")
    Call<SongList> getSonglist();

}
