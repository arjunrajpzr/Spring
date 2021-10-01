package com.arjun.springcore.dao;

import com.arjun.springcore.pojo.Sequence;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * In a production application, you would implement this DAO interface to use a data-access technology.
 * But to simplify this example, you’ll implement a DAO with hard-coded values in a Map to store
 * the sequence instances and values.
 */

/**
 * Observe how the SequenceDaoImpl class is decorated with the @Component("sequenceDao") annotation.
 * This marks the class so Spring can create POJOs from it.
 * The value inside the @Component annotation defines the bean instance ID, in this case sequenceDao.
 * If no bean value name is provided in the @Component annotation,
 * by default the bean name is assigned as the uncapitalized nonqualified class name.
 * For example, for the SequenceDaoImpl class, the default bean name would be sequenceDaoImpl.
 */
@Component("sequenceDao")
public class SequenceDaoImpl implements SequenceDao {

    private final Map<String, Sequence> sequences = new HashMap<>();
    private final Map<String, AtomicInteger> values = new HashMap<>();

    public SequenceDaoImpl() {
        sequences.put("IT", new Sequence("IT", "30", "A"));
        values.put("IT", new AtomicInteger(10000));
    }

    @Override
    public Sequence getSequence(String sequenceId) {
        return sequences.get(sequenceId);
    }

    @Override
    public int getNextValue(String sequenceId) {
        AtomicInteger value = values.get(sequenceId);
        return value.getAndIncrement();
    }


}
