package com.vote.VoteAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "vote")
public class Vote {

    @Column
    private Long reviewId;

    @Column
    private int portReview;

    @Column
    private boolean vote;

    @Column
    private Long userId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    public Vote() {
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Vote(Long reviewId, boolean vote, int portReview) {
        this.reviewId = reviewId;
        this.portReview = portReview;
        this.vote = vote;
    }

    public int getPortReview() {
        return portReview;
    }

    public void setPortReview(int portReview) {
        this.portReview = portReview;
    }
}
