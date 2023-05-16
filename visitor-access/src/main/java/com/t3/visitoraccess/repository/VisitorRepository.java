package com.t3.visitoraccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.servlet.function.RequestPredicates.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Long>{
    
}
