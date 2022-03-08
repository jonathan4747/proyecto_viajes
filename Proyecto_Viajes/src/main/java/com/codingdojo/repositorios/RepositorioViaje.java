package com.codingdojo.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.codingdojo.modelos.Viaje;
@Repository
public interface RepositorioViaje extends CrudRepository<Viaje , Long> {
	List<Viaje> findAll();
	
	@SuppressWarnings("unchecked")
	Viaje save( Viaje nuevoViaje );
	
	//Econtrar el id
	Viaje findById(long id);
	
	@Transactional
	Long deleteById( long id );
	
	@Transactional
	@Modifying
	@Query(value="UPDATE viajes "+ "SET nombregasto = :nombregasto, vendedor = :vendedor, monto = :monto, descripcion = :descripcion " +
			"WHERE id = :id", nativeQuery = true )
	void actualizaviaje(@Param("nombregasto")String nombregasto,@Param("vendedor") String vendedor,@Param("monto") long monto,
			            @Param("descripcion")String descripcion, @Param("id")long id);

	
}
