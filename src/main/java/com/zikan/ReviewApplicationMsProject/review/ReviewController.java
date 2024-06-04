package com.zikan.ReviewApplicationMsProject.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private  final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @PostMapping
    public ResponseEntity <String> addReviews (@RequestParam Long companyId, @RequestBody Review review){

        boolean isReviewSaved = reviewService.addReview(companyId, review);

        if(isReviewSaved) {

            return new ResponseEntity<>("Review has been successfully added", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Review has been successfully added", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }


    @GetMapping("/{reviewId}")
    public  ResponseEntity <Review> getReview (@PathVariable Long reviewId){

        return new ResponseEntity<>(reviewService.getReview(reviewId), HttpStatus.OK);

    }

    @PutMapping("{reviewsId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewsId,
                                               @RequestBody Review review){

        boolean isReviewUpdated = reviewService.updateReview(reviewsId, review);

        if(isReviewUpdated) {
            return new ResponseEntity<>("Review successfully updated", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Review not found and updated", HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("{reviewId}")
    public ResponseEntity <String> deleteReview (@PathVariable Long reviewId){

        boolean isDeleted = reviewService.deleteReview(reviewId);
        if (isDeleted){
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Review not deleted", HttpStatus.NOT_FOUND);
        }
    }
}
