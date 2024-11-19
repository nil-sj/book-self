package com.bookself.bookself_api.services;

import com.bookself.bookself_api.models.ReadingProgress;
import com.bookself.bookself_api.models.User;
import com.bookself.bookself_api.repositories.ReadingProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class ReadingProgressService {
    private final ReadingProgressRepository readingProgressRepository;

    public ReadingProgressService(ReadingProgressRepository readingProgressRepository) {
        this.readingProgressRepository = readingProgressRepository;
    }

    public ReadingProgress saveOrUpdateReadingProgress(ReadingProgress readingProgress) {
        readingProgress.updateProgressPercentage();
        return readingProgressRepository.save(readingProgress);
    }

    public List<ReadingProgress> getAllProgressByUser(User user){
        return readingProgressRepository.findByUser(user);
    }

    public void deleteProgress(Long id){
        readingProgressRepository.deleteById(id);
    }
}
