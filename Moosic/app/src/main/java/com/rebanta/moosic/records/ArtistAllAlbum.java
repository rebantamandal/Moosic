package com.rebanta.moosic.records;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record ArtistAllAlbum(
        @SerializedName("success") boolean success,
        @SerializedName("data") Data data
) {
    public record Data(
            @SerializedName("total") int total,
            @SerializedName("albums") List<AlbumsSearch.Data.Results> albums
    ){}
}
