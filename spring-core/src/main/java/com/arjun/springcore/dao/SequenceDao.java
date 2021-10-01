package com.arjun.springcore.dao;

import com.arjun.springcore.pojo.Sequence;

/**
 * The getSequence() method loads a POJO or Sequence object from a database table by its ID,
 * while the getNextValue() method retrieves the next value of a particular database sequence.
 */
public interface SequenceDao {
    public Sequence getSequence(String sequenceId);

    public int getNextValue(String sequenceId);
}
