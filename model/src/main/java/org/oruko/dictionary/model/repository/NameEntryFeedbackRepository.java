package org.oruko.dictionary.model.repository;

import org.oruko.dictionary.model.NameEntryFeedback;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Repository for {@link org.oruko.dictionary.model.NameEntryFeedback}
 *
 * Created by Dadepo Aderemi.
 */
@Transactional
public interface NameEntryFeedbackRepository extends CrudRepository<NameEntryFeedback, Long> {
    List<NameEntryFeedback> findByName(String name, Sort sort);
    List<NameEntryFeedback> findAll(Sort sort);

}
