package br.com.wa.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "db_sequences")
@NoArgsConstructor
@AllArgsConstructor
public class DataBaseSequence {

    @Id
    private String id;
    private int sequenceValue;

}
