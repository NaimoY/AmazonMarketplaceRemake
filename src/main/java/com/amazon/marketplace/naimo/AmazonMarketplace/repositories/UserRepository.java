package com.amazon.marketplace.naimo.AmazonMarketplace.repositories;

import com.amazon.marketplace.naimo.AmazonMarketplace.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
//an interface doesn't contain method implementations
public interface UserRepository extends JpaRepository<User, Integer> {
}
