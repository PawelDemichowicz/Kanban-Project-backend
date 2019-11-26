package com.project.travelbackend.repositories;

import com.project.travelbackend.domains.Issue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface IssueRepository extends CrudRepository<Issue,Long> {

    @Override
    List<Issue> findAll();
}
