package com.zikan.ReviewApplicationMsProject.review;

import java.util.List;

public interface ReviewService {

   boolean addReview(Long companyId, Review review);

   List<Review> getAllReviews(Long companyId);

   Review getReview(Long reviewId);

   boolean updateReview(Long reviewsId, Review review);

   boolean deleteReview(Long reviewId);
}
