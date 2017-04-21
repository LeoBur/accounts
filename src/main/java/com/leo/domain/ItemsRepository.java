package com.leo.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:leandro.burgos@globant.com>Leandro Burgos</a>
 */
@Repository
@Transactional
public interface ItemsRepository extends CrudRepository<Item, Long> {
}
