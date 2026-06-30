package org.example.finmark_feedback_micro.repo;

import org.example.finmark_feedback_micro.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Long> {

    List<Feedback> findByServiceCategory(String serviceCategory);

    List<Feedback> findByPriority(String priority);

    List<Feedback> findByClientName(String clientName);
}
