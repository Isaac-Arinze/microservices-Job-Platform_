package com.zikan.ReviewApplicationMsProject.review.impi;

import com.zikan.ReviewApplicationMsProject.review.Review;
import com.zikan.ReviewApplicationMsProject.review.ReviewRepository;
import com.zikan.ReviewApplicationMsProject.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;


    public reviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {

        if(companyId != null){
             review.setCompanyId(companyId);
             reviewRepository.save(review);
             return true;
          }
          else {
              return false;
          }
    }
    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =  reviewRepository.findByCompanyId(companyId);
        return reviews;
    }
    @Override
    public Review getReview(Long reviewId) {

        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Long reviewsId, Review updatedReview) {
        Review review = reviewRepository.findById(reviewsId).orElse(null);

        if (review != null){

            review.setCompanyId(updatedReview.getCompanyId());
            review.setDescription(updatedReview.getDescription());
            review.setTitle(updatedReview.getTitle());
            review.setRating(updatedReview.getRating());
            reviewRepository.save(review);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long reviewId) {

        Review review = reviewRepository.findById(reviewId).orElse(null);

        if (review != null){
            reviewRepository.delete(review);
            return true;
        }
        else {
            return false;
        }
    }
}

