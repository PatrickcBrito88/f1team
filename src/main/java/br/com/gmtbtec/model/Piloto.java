package br.com.gmtbtec.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Piloto {

    @PrimaryKey
    private UUID id;

}
