package com.example.enums.runner;

import com.example.enums.service.EnumDemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Runs all enum demos automatically on application startup.
 * Check the console output to see every edge case in action.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class EnumDemoRunner implements CommandLineRunner {

    private final EnumDemoService service;

    @Override
    public void run(String... args) throws Exception {
        log.info("");
        log.info("╔══════════════════════════════════════════════════════╗");
        log.info("║   Spring Data JPA  –  Enum Edge Cases Demo           ║");
        log.info("╚══════════════════════════════════════════════════════╝");
        log.info("");

        service.demoStringEnum();
        log.info("");

        service.demoOrdinalDanger();
        log.info("");

        service.demoCustomConverter();
        log.info("");

        service.demoNullEnum();
        log.info("");

        service.demoElementCollection();
        log.info("");

        service.demoQueries();
        log.info("");

        service.demoJacksonSerialization();
        log.info("");

        log.info("╔══════════════════════════════════════════════════════╗");
        log.info("║  All enum demos completed successfully! ✅            ║");
        log.info("╚══════════════════════════════════════════════════════╝");
    }
}
