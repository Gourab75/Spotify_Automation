package Automation.Spotify_Automation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Api {
	public String userid = "smedjan" ;
public String token = "Bearer BQAmZHr5fA5nUY5V0NGNgmUmYZiEzJXGaH0AOTYhnGWhjHLKbVudzb6mfcagERgmf-PMhDY53WJS24QCvidS88meocXKf9CFglHzwIJyf90Mdvx64Kxjid37aBqg0PK2SK391Udt2fs127VryiuHcNQO-FTjCgL-hQO26tFnDLAVz_Fwzk_2y6QzCKD33XM64rG1DXGlFx14jZngiI7MfEZtm9oBah5UDurPfeG4_5Gnp5lnaw6KyGZppSbBVPPOILsgiv3yDeI";
//Get Current User's Profile
@Test
public void get() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me");
	response.prettyPrint();
	String userId=response.path("id");
	
	
	System.out.println("--------------------------------------------------------");
	System.out.println("user id :"+ userId);
	response.then().statusCode(200);
			
}

//Get User's Profile
@Test
public void getperticularuser() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/users/smedjan");
	response.prettyPrint();
	response.then().statusCode(200);

}

//Get Current User's Playlists
@Test
public void getcurrentuserplaylists() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/playlists?limit=10&offset=5");
	response.prettyPrint();
	response.then().statusCode(200);
}

//Get Playlist Cover Image
@Test
public void getplaylistcoverimage() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/images");
	response.prettyPrint();
	response.then().statusCode(200);
}

//Get Playlist Items
@Test
public void getplaylistitems() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks?market=ES&fields=items(added_by.id%2Ctrack(name%2Chref%2Calbum(name%2Chref)))&limit=10&offset=5");
	response.prettyPrint();
	response.then().statusCode(200);
}

//Get Playlist

@Test
public void getplaylist() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n");
	response.prettyPrint();
	response.then().statusCode(200);
	System.out.println("--------------------------------------------------");
	String name = response.path("owner.display_name");
	System.out.println("display name :"+ name);
}

//Get User's Playlists
@Test
public void getuserplaylists() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/users/smedjan/playlists?limit=10&offset=5");
	response.prettyPrint();
	response.then().statusCode(200);
}

//Add Items to Playlist
@Test
public void postuserplaylists() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.post("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks?uris=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M");
	response.prettyPrint();
	//response.then().statusCode(200);
}
//Create Playlist
@Test
public void postcreateplaylist() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.post("https://api.spotify.com/v1/users/smedjan/playlists");
	response.prettyPrint();
}
//Add Custom Playlist Cover Image
@Test
public void putcustomplaylistcoverimage() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/images");
	response.prettyPrint();
}
//Update Playlist Items
@Test
public void putupdateplaylistitem() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
	response.prettyPrint();
}
//Change Playlist Details
@Test
public void putchnageplaylistdetails() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n");
	response.prettyPrint();
}
//Remove Playlist Items
@Test
public void deleteplaylistitems() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.delete("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
	response.prettyPrint();
}
// Get Track’s Audio Analysis
@Test
public void gettrackaudioanalysis() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/audio-analysis/11dFghVXANMlKmJXsNCbNl");
	response.prettyPrint();
}
//Get Tracks’ Audio Features ids
@Test
public void gettrackaudiofeaturesids() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/audio-features?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	response.prettyPrint();
}
//Get Track’s Audio Features id
@Test
public void gettrackaudiofeaturesid() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl");
	response.prettyPrint();
}
//Get Several Tracks
@Test
public void getseveraltracks() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	response.prettyPrint();
}
//Get Track
@Test
public void gettrack() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl?market=ES");
	response.prettyPrint();
}
//Get Several Shows
@Test
public void getseveralshows() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/shows?market=ES&ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
	response.prettyPrint();
}
//Get Show Episodes
@Test
public void getshowepisode() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ/episodes?market=ES&limit=10&offset=5");
	response.prettyPrint();
}
//Get Show
@Test
public void getshow() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ?market=ES");
	response.prettyPrint();
}
//Search for Item
@Test
public void getsearchforitem() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/search?q=remaster%2520track%3ADoxy%2520artist%3AMiles%2520Davis&type=track%2Cartist&market=ES&limit=10&offset=5");
	response.prettyPrint();
}
//Get the User's Queue
@Test
public void getusersqueue() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/player/queue");
	response.prettyPrint();
}
//Get Recently Played Tracks
@Test
public void getrecentlyplayedtracks() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/player/recently-played?limit=10&after=1484811043508");
	response.prettyPrint();
}
//Get Playback State
@Test
public void getplaybackstate() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/player?market=ES");
	response.prettyPrint();
}
//Get Available Devices
@Test
public void getavailabledevice() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/player/devices");
	response.prettyPrint();
}
//Get Currently Playing Track
@Test
public void getcurrentplayingtrack() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/player/currently-playing?market=ES");
	response.prettyPrint();
}
//Skip To Next
@Test
public void postskiptonext() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.post("https://api.spotify.com/v1/me/player/next?device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
//Skip To Previous
@Test
public void postskiptoprevious() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.post("https://api.spotify.com/v1/me/player/previous?device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
//Add Item to Playback Queue
@Test
public void postadditemtoplaybackqueue() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.post("https://api.spotify.com/v1/me/player/queue?uri=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
//Pause Playback
@Test
public void putpauseplayback() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/me/player/pause?device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
//Start/Resume Playback
@Test
public void putstartresumeplayback() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/me/player/play?device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
//Set Repeat Mode
@Test
public void putsetrepeatmode() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/me/player/repeat?state=context&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
//Seek To Position
@Test
public void putseektoposition() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/me/player/seek?position_ms=25000&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
//Toggle Playback Shuffle
@Test
public void puttoggelplaybackshuffle() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/me/player/shuffle?state=true&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
//Transfer Playback
@Test
public void puttransferplayback() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/me/player");
	response.prettyPrint();
}
//Set Playback Volume
@Test
public void putsetplaybackvolume() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/me/player/volume?volume_percent=50&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
//GetAlbum Tracks
@Test
public void getalbumtrack() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks?market=ES&limit=10&offset=5");
	response.prettyPrint();
}
//GetAlbum 
@Test
public void getalbum() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy?market=ES");
	response.prettyPrint();
}
//Get several Album 
@Test
public void getseveralalbum() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc&market=ES");
	response.prettyPrint();
}
//Get Artist’s Albums 
@Test
public void getartistalbum() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/albums?include_groups=single%2Cappears_on&market=ES&limit=10&offset=5");
	response.prettyPrint();
}
//Get Artist’s Related Artists 
@Test
public void getartistrelatedartists() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/related-artists");
	response.prettyPrint();
}
//Get Artist’s Top Tracks 
@Test
public void getartisttoptrack() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks?market=ES");
	response.prettyPrint();
}
//Get Artist
@Test
public void getartist() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg");
	response.prettyPrint();
}
//Get Several Artists
@Test
public void getseveralartist() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/artists?ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
	response.prettyPrint();
}
//Get Audiobook Chapters
@Test
public void getaudiobookchapters() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/audiobooks/38bS44xjbVVZ3No3ByF1dJ/chapters?market=ES&limit=10&offset=5");
	response.prettyPrint();
}
//Get an Audiobook
@Test
public void getaudiobook() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/audiobooks/38bS44xjbVVZ3No3ByF1dJ?market=ES");
	response.prettyPrint();
}
//Get several Audiobook
@Test
public void getseveralaudiobook() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/audiobooks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B&market=ES");
	response.prettyPrint();
}
//Get Available Genre Seeds
@Test
public void getavailablegenreseeds() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
	response.prettyPrint();
}
//Get Several Browse Categories
@Test
public void getseveralbrowsecataguries() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/browse/categories?country=SE&locale=sv_SE&limit=10&offset=5");
	response.prettyPrint();
}
//Get Several Browse Category
@Test
public void getseveralbrowsecatagury() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/browse/categories/dinner?country=SE&locale=sv_SE");
	response.prettyPrint();
}
//Get Category's Playlists
@Test
public void getcategoryplaylist() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/browse/categories/dinner/playlists?country=SE&limit=10&offset=5");
	response.prettyPrint();
}
//Get Featured Playlists
@Test
public void getfeaturedplaylist() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/browse/featured-playlists?country=SE&locale=sv_SE&timestamp=2014-10-23T09%3A00%3A00.000Z&limit=10&offset=5");
	response.prettyPrint();
}
//Get New Releases
@Test
public void getnewrelease() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/browse/new-releases?country=SE&limit=10&offset=5");
	response.prettyPrint();
}
//Get Recommendations
@Test
public void getrecommendation() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/recommendations?limit=10&market=ES&seed_artists=4NHQUGzhtTLFvgF5SZesLK&seed_genres=classical%2Ccountry&seed_tracks=0c6xIDDpzE81m2q797ordA");
	response.prettyPrint();
}
//Get chapter
@Test
public void getchapter() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/chapters/38bS44xjbVVZ3No3ByF1dJ?market=ES");
	response.prettyPrint();
}
//Get several chapter
@Test
public void getseveralchapter() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/chapters?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B&market=ES");
	response.prettyPrint();
}
//Get episode
@Test
public void getepisode() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ?market=ES");
	response.prettyPrint();
}
//Get several episode
@Test
public void getseveralepisode() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf&market=ES");
	response.prettyPrint();
}
//Check If User Follows Artists or Users
@Test
public void getifuserfollowartistorusers() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/following/contains?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
	response.prettyPrint();
}
//Get Followed Artists
@Test
public void getfollowedartist() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/following?type=artist&after=0I2XqVXqHScXjHhk6AYYRe&limit=10");
	response.prettyPrint();
}
//Check if Users Follow Playlist
@Test
public void getifuserfollowedartist() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers/contains?ids=jmperezperez%2Cthelinmichael%2Cwizzler");
	response.prettyPrint();
}
//Follow Artists or Users
@Test
public void putfollowartistoruser() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/me/following?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
	response.prettyPrint();
}
//Follow Playlist
@Test
public void putfollowplaylist() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
	response.prettyPrint();
}
//Unfollow Artists or Users
@Test
public void deleteartistoruser() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.delete("https://api.spotify.com/v1/me/following?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
	response.prettyPrint();
}
//Unfollow Playlist
@Test
public void deleteunfollowplaylist() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.delete("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
	response.prettyPrint();
}
//Get Available Markets
@Test
public void getavailablemarket() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/markets");
	response.prettyPrint();
}
//Get User’s Top Items
@Test
public void getuserstopitems() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/top/artists?time_range=medium_term&limit=10&offset=5");
	response.prettyPrint();
}

//Check User’s Saved Albums
@Test
public void getuserssavedalbum() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/albums/contains?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
	response.prettyPrint();
}
//Check User’s Saved Audiobooks
@Test
public void getuserssavedaudiobook() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/audiobooks/contains?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	response.prettyPrint();
}
//Check User’s Saved Episodes
@Test
public void getuserssavedepisods() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/episodes/contains?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");
	response.prettyPrint();
}
//Check User’s Saved Shows
@Test
public void getuserssavedshow() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/shows/contains?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
	response.prettyPrint();
}
//Check User’s Saved Tracks
@Test
public void getuserssavedtrack() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/tracks/contains?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	response.prettyPrint();
}
//Get User’s Saved Albums
@Test
public void getuserssavedalbums() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/albums?limit=10&offset=5&market=ES");
	response.prettyPrint();
}
//Get User’s Saved Audiobooks
@Test
public void getuserssavedaudiobooks() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/audiobooks?limit=10&offset=5");
	response.prettyPrint();
}
//Get User’s Saved Episodes
@Test
public void getuserssavedepisode() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/episodes?market=ES&limit=10&offset=5");
	response.prettyPrint();
}
//Get User’s Saved Shows
@Test
public void getuserssavedshows() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/shows?limit=10&offset=5");
	response.prettyPrint();
}
//Get User’s Saved Tracks
@Test
public void getuserssavedtracks() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.get("https://api.spotify.com/v1/me/tracks?market=ES&limit=10&offset=5");
	response.prettyPrint();
}
//Save Albums for Current User
@Test
public void putsavealbumforcurrentusers() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/me/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
	response.prettyPrint();
}
//Save Audiobooks for Current User
@Test
public void putaudiobookforcurrentusers() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/me/audiobooks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	response.prettyPrint();
}
//Save Episodes for Current User
@Test
public void putepisodsforcurrentuser() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/me/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");
	response.prettyPrint();
}
//Save Shows for Current User
@Test
public void putsaveshowsforcurrentuser() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/me/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
	response.prettyPrint();
}
//Save Tracks for Current User
@Test
public void putsavetrackforcurrentuser() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.put("https://api.spotify.com/v1/me/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	response.prettyPrint();
}
//Remove Users’ Saved Albums
@Test
public void deleteuserssavedalbums() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.delete("https://api.spotify.com/v1/me/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
	response.prettyPrint();
}
//Remove User's Saved Audiobooks
@Test
public void deleteuserssaveaudiobooks() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.delete("https://api.spotify.com/v1/me/audiobooks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	response.prettyPrint();
}
//Remove User’s Saved Episodes
@Test
public void deleteuserssavedepisodes() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.delete("https://api.spotify.com/v1/me/episodes?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	response.prettyPrint();
}
//Remove User's Saved Shows
@Test
public void deleteuserssavedshows() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.delete("https://api.spotify.com/v1/me/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ&market=ES");
	response.prettyPrint();
}
//Remove User’s Saved Tracks
@Test
public void deleteuserssavedtracks() {
	Response response = given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when()
			.delete("https://api.spotify.com/v1/me/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	response.prettyPrint();
}
}