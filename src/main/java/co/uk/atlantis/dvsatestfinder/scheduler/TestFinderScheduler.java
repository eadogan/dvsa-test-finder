package co.uk.atlantis.dvsatestfinder.scheduler;

import co.uk.atlantis.dvsatestfinder.service.FindAvailableTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestFinderScheduler {

    private FindAvailableTestService findAvailableTestService;

    public TestFinderScheduler(FindAvailableTestService findAvailableTestService) {
        this.findAvailableTestService = findAvailableTestService;
    }

    // every 5 mins run
    @Scheduled(cron = "${cron.available-date.checker}")
    public void runChecker(){
        log.info("Cron Job: Available Test Service Started");
        System.out.println(findAvailableTestService.findAvailableTestDate());
        log.info("Cron Job: Available Test Service Ended");
    }

}
