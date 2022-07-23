package br.com.gmtbtec.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Table("Piloto")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Piloto implements Serializable {

    @PrimaryKey
    private UUID id;

    @Indexed(value="email")
    private String email;

    private LocalDateTime dateOfCreate;

}
