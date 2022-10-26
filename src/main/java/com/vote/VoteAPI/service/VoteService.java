package com.vote.VoteAPI.service;

import com.vote.VoteAPI.model.Vote;
import com.vote.VoteAPI.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
@Service
public class VoteService {
    @Autowired
    private VoteRepository repository;

    public Vote updateVoteReview (Vote vote) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8081/reviews/" + vote.getReviewId()))
                .build();

        HttpResponse response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        var code = response.statusCode();
        if(code == 200){
            return repository.save(vote);
        }else {
            return (Vote) response.body();
        }
    }

    public List<Vote> getAllVotes(){
        return (List<Vote>) repository.findAllVotes();
    }
}