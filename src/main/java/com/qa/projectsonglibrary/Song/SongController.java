package com.qa.projectsonglibrary.Song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class SongController {
    @Autowired
    SongService songService;

    //Home Page
    @GetMapping(path="/")
    public String index(){
        return "" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <title>Index Page</title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <h1>Index Page</h1>\n" +
                "    <p>\n" +
                "      The following instructions outline how to use this Spring application:\n" +
                "    </p>\n" +
                "    <h3>Instructions</h3>\n" +
                "    <p>The server port is set to 8080</p>\n" +
                "    <p>Therefore, to access the application you will need to use the format:</p>\n" +
                "    <p>localhost:8080/{insert desired path}</p>\n" +
                "\n" +
                "    <h3>View all songs</h3>\n" +
                "    <p>\n" +
                "      To view the full list of songs use the url:\n" +
                "      <a href=\"http://localhost:8080/songs\">click here</a>\n" +
                "    </p>\n" +
                "\n" +
                "    <h3>Find Songs</h3>\n" +
                "    <h4>Find Songs By ID</h4>\n" +
                "    <p>\n" +
                "      Use the following url format to find songs by their their id:\n" +
                "      <a href=\"http://localhost:8080/song/{id}\"\n" +
                "        >http://localhost:8080/song/{id}</a\n" +
                "      >\n" +
                "    </p>\n" +
                "    <p>Replace {id} with the ID number linked to the song you'd like to find</p>\n" +
                "\n" +
                "    <h4>Find Songs By Title</h4>\n" +
                "    <p>\n" +
                "      Use the following url format to find songs by their title:\n" +
                "      <a href=\"http://localhost:8080/songtitle/{title}\"\n" +
                "        >http://localhost:8080/songtitle/{title}</a\n" +
                "      >\n" +
                "    </p>\n" +
                "    <p>Replace {title} with the title of the song you would like to find</p>\n" +
                "\n" +
                "    <h4>Find Songs By Artist</h4>\n" +
                "    <p>\n" +
                "      Use the following url format to find songs by their artist:\n" +
                "      <a href=\"http://localhost:8080/songartist/{artist}\"\n" +
                "        >http://localhost:8080/songartist/{artist}</a\n" +
                "      >\n" +
                "    </p>\n" +
                "    <p>Replace {artist} with the artist of the song you would like to find</p>\n" +
                "\n" +
                "    <h4>Find Songs By Song Length</h4>\n" +
                "    <h5>Less Than</h5>\n" +
                "    <p>\n" +
                "      Use the following url format to find songs whose lengths are below a\n" +
                "      certain number:\n" +
                "      <a href=\"http://localhost:8080/songlengthless/{length}\"\n" +
                "        >http://localhost:8080/songlengthless/{length}</a\n" +
                "      >\n" +
                "    </p>\n" +
                "    <p>\n" +
                "      Replace {length} with the maximum number of minutes you'd like to filter\n" +
                "      out\n" +
                "    </p>\n" +
                "\n" +
                "    <h5>Greater Than</h5>\n" +
                "    <p>\n" +
                "      Use the following url format to find songs whose lengths are above a\n" +
                "      certain number:\n" +
                "      <a href=\"http://localhost:8080/songlengthgreater/{length}\"\n" +
                "        >http://localhost:8080/songlengthgreater/{length}</a\n" +
                "      >\n" +
                "    </p>\n" +
                "    <p>\n" +
                "      Replace {length} with the minimum number of minutes you'd like to filter\n" +
                "      out\n" +
                "    </p>\n" +
                "\n" +
                "    <h3>Add Songs</h3>\n" +
                "    <p>\n" +
                "      You can add songs via Postman by completing the following instructions:\n" +
                "    </p>\n" +
                "    <ol>\n" +
                "      <li>\n" +
                "        Select the POST method and enter the following url:\n" +
                "        <a href=\"http://localhost:8080/newsong\"\n" +
                "          >http://localhost:8080/newsong</a\n" +
                "        >\n" +
                "      </li>\n" +
                "      <li>Select the Body tab, then raw JSON</li>\n" +
                "      <li>\n" +
                "        Enter the following JSON format: { \"id\": 1, \"title\": \"Song_Name\",\n" +
                "        \"artist\": \"Song_Artist\", \"length\": 2.0 }\n" +
                "      </li>\n" +
                "    </ol>\n" +
                "    <p>Please note that the ID is an integer and the song length is a float</p>\n" +
                "\n" +
                "    <p>JSON Format:</p>\n" +
                "\n" +
                "    <h3>Delete Songs</h3>\n" +
                "    <p>\n" +
                "      You can delete songs via Postman by completing the following instructions\n" +
                "    </p>\n" +
                "    <ol>\n" +
                "      <li>\n" +
                "        Select the DELETE method and enter the following url:\n" +
                "        <a href=\"http://localhost:8080/deletesong/{id}\"\n" +
                "          >http://localhost:8080/deletesong/{id}</a\n" +
                "        >\n" +
                "      </li>\n" +
                "      <li>\n" +
                "        Replace {id} with the ID No linked to the song you'd like to delete\n" +
                "      </li>\n" +
                "    </ol>\n" +
                "  </body>\n" +
                "</html>\n";
    }

    @GetMapping("/songs")//retrieves all songs
    private List<Song> getAllSongs(){
        return songService.getAllSongs();
    }

    @GetMapping("/song/{id}")//retrieves details of a specific songs by id
    private Song getSongById(@PathVariable("id") int id){
        return songService.getSongById(id);
    }

    @GetMapping("/songtitle/{title}")//retrieves details of a specific song by title
    private List<Song> getSongByTitle(@PathVariable("title") String title){
        return songService.getSongByTitle(title);
    }

    @GetMapping("/songartist/{artist}")//retrieves details of a specific song by artist
    private List<Song> getSongByArtist(@PathVariable("artist") String artist){
        return songService.getSongByArtist(artist);
    }

    @GetMapping("/songlengthless/{length}")//retrieves details of songs less than a certain length
    private List<Song> getSongByLengthLessThan(@PathVariable("length") float length){
        return  songService.getSongByLengthLessThan(length);
    }

    @GetMapping("/songlengthgreater/{length}")//retrieves details of songs greater than a certain length
    private List<Song> getSongByLengthGreaterThan(@PathVariable("length") float length){
        return  songService.getSongByLengthGreaterThan(length);
    }

    @PostMapping("/newsong")
    private String saveSong(@RequestBody Song song){
        songService.saveOrUpdate(song);
        return "Saved! "+ song.toString();
    }

    @DeleteMapping("/deletesong/{id}")
    private String deleteSong(@PathVariable("id") int id){
        songService.delete(id);
        return "Deleted! ID: "+id;
    }

}
