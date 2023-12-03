package com.example.OneNote.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Note {
        private UUID id;
        private String title;
        private String content;
        private LocalDateTime creationTime;

    }
