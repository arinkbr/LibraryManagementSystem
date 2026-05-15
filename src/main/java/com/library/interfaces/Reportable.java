package com.library.interfaces;

import com.library.domain.Item;
import com.library.domain.User;
import java.util.List;
import java.util.Map;

public interface Reportable {
    /**
     * Generates a report grouping items by their status
     * @param user The user generating the report
     * @return A map containing item statuses and their corresponding items
     */
    Map<Item.Status, List<Item>> generateReport(User user);
}
