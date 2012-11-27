package net.lessy.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Empty iterator
 * @author Hans Lesmeister
 */
public class EmptyIterator<T> implements Iterator<T> {

   public boolean hasNext() {
      return false;
   }

   public T next() {
      throw new NoSuchElementException("Iterator is empty");
   }

   public void remove() {
      throw new NoSuchElementException("Iterator is empty");
   }
}
