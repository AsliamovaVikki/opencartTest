package org.opencart.utils;

import java.util.Comparator;
import java.util.List;

public class Utils {
  public static <T> boolean isSortedAscending(List<T> list, Comparator<T> comparator) {
    for (int i = 0; i < list.size() - 1; i++) {
      if (comparator.compare(list.get(i), list.get(i + 1)) > 0) {
        return false;
      }
    }
    return true;
  }
}
