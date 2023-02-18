package io.github.solclient.webapi.v1;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.solclient.webapi.OnlinePlayer;
import io.github.solclient.webapi.OnlineRepository;

@RestController
@RequestMapping("/v1/online")
public class OnlineController {

	private final OnlineRepository repository;

	public OnlineController(OnlineRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/get/{uuids}")
	public List<ZonedDateTime> getById(@PathVariable List<UUID> uuids) {
		return uuids.stream().map(repository::findById)
				.map((optional) -> optional.map(OnlinePlayer::getCreation).orElse(null)).toList();
	}

	@GetMapping("/log_in/{uuid}")
	public void logIn(@PathVariable UUID uuid) {
		repository.findById(uuid).ifPresentOrElse((player) -> {
			player.setCreation(ZonedDateTime.now());
			repository.save(player);
		}, () -> repository.save(new OnlinePlayer(uuid, ZonedDateTime.now())));
	}

	@GetMapping("/log_out/{uuid}")
	public void logOut(@PathVariable UUID uuid) {
		repository.deleteById(uuid);
	}

}
