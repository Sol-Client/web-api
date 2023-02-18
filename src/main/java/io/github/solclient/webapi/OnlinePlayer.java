package io.github.solclient.webapi;

import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OnlinePlayer {

	private @Id UUID uuid;
	private ZonedDateTime creation;

	public OnlinePlayer() {
	}

	public OnlinePlayer(UUID uuid, ZonedDateTime creation) {
		this.uuid = uuid;
		this.creation = creation;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public ZonedDateTime getCreation() {
		return creation;
	}

	public void setCreation(ZonedDateTime creation) {
		this.creation = creation;
	}

}
