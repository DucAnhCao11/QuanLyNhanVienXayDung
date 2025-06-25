package com.example.quan_ly_nhan_vien.configurations;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.quan_ly_nhan_vien.repositories.InvalidatedTokenRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TokenCleanupTask {
    private static final Logger log = LoggerFactory.getLogger(TokenCleanupTask.class);
    private final InvalidatedTokenRepository tokenRepository;

    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void cleanup() {
        Date now = new Date();
        log.info("Schedule of function is runing");
        tokenRepository.deleteByExpiryTimeBefore(now);
    }
}
