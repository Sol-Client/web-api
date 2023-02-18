package io.github.solclient.webapi;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlineRepository extends JpaRepository<OnlinePlayer, UUID> {

	void deleteByCreationLessThan(ZonedDateTime date);

}
