/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.util;

import java.util.List;

import model.BaseModel;

/**
 *
 * @author spdue4cb
 * @param <E>
 */
public interface BaseRepository<E extends BaseModel> {
    E create(E entity);
    E find(Integer entityId);
    E find(E entity);
    E update(E entity);
    void delete(E entity);
    List<E> findAll();
}
