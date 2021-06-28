package br.com.wa.services;

import br.com.wa.domain.user.DataBaseSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public DataBaseSequence getNextSequence(String sequenceName) {
        var query = new Query(Criteria.where("id").is(sequenceName));
        var update = new Update().inc("sequenceValue", 1);
        var counter = mongoOperations
                .findAndModify(query,
                        update, options().returnNew(true).upsert(true),
                        DataBaseSequence.class);
        return counter;
    }
}
