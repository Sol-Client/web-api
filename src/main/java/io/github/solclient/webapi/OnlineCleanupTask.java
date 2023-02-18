package io.github.solclient.webapi;

import java.time.ZonedDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OnlineCleanupTask {

	private final OnlineRepository repository;

	public OnlineCleanupTask(OnlineRepository repository) {
		this.repository = repository;
	}

	@Scheduled(cron = "0 * * * * *")
	public void cleanup() {
		repository.deleteByCreationLessThan(ZonedDateTime.now().minusMinutes(30));
	}

}
