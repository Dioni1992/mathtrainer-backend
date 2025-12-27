package com.mathtrainer.api.service;

import com.mathtrainer.api.model.ExerciseType;
import com.mathtrainer.api.model.User;
import com.mathtrainer.api.model.UserProgress;
import com.mathtrainer.api.repository.UserProgressRepository;
import org.springframework.stereotype.Service;

@Service
public class UserProgressService {

    private final UserProgressRepository repo;

    public UserProgressService(UserProgressRepository repo) {
        this.repo = repo;
    }

    public UserProgress getOrCreate(User user, ExerciseType type) {
        return repo.findByUserAndType(user, type).orElseGet(() -> {
            var p = new UserProgress();
            p.setUser(user);
            p.setType(type);
            p.setCorrectCount(0);
            p.setWrongCount(0);
            return repo.save(p);
        });
    }

    public UserProgress save(UserProgress progress) {
        return repo.save(progress);
    }
}
