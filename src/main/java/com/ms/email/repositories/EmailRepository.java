package com.ms.email.repositories;


import com.ms.email.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {

}
