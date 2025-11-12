package com.james.repository;

import com.james.Module.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<ContactMessage,Integer > {
}
