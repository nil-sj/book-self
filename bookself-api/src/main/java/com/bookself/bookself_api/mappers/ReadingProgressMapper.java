package com.bookself.bookself_api.mappers;

import com.bookself.bookself_api.dto.ReadingProgressDto;
import com.bookself.bookself_api.models.ReadingProgress;

public class ReadingProgressMapper {

    // Convert ReadingProgressEntity to ReadingProgressDto
    public static ReadingProgressDto toDto(ReadingProgress readingProgress){
        if(readingProgress == null){
            return null;
        }
        ReadingProgressDto dto = new ReadingProgressDto();
        dto.setId(readingProgress.getId());
        dto.setUserId(readingProgress.getUser() .getId());
        dto.setBookId(readingProgress.getBook().getId());
        dto.setPagesRead(readingProgress.getPagesRead());
        dto.setTotalPages(readingProgress.getTotalPages());
        dto.setProgressPercentage(readingProgress.getProgressPercentage());
        dto.setStartedDate(readingProgress.getStartedDate());
        dto.setUpdatedDate(readingProgress.getUpdatedDate());
        dto.setReadingStatus(readingProgress.getReadingStatus());
        return dto;
    }

    // Convert ReadingProgressDto to ReadingProgressEntity
    public static ReadingProgress toEntity(ReadingProgressDto dto){
        if(dto == null){
            return null;
        }
        ReadingProgress readingProgress = new ReadingProgress();
        readingProgress.setId(dto.getId());
        readingProgress.setPagesRead(dto.getTotalPages());
        readingProgress.setProgressPercentage(dto.getProgressPercentage());
        readingProgress.setStartedDate(dto.getStartedDate());
        readingProgress.setUpdatedDate(dto.getUpdatedDate());
        readingProgress.setReadingStatus(dto.getReadingStatus());
        return readingProgress;
    }
}
