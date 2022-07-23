package br.com.gmtbtec.repository;

import br.com.gmtbtec.model.Piloto;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public class PilotoRepository {


    public interface PersonCassandraRepository extends CrudRepository<Piloto, UUID> {

    }
}
