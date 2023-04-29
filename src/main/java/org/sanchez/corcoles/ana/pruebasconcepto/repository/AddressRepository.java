package org.sanchez.corcoles.ana.pruebasconcepto.repository;

import org.sanchez.corcoles.ana.pruebasconcepto.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

}
