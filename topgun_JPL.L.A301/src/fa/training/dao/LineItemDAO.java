package fa.training.dao;

import java.util.List;

import fa.training.entities.LineItem;

public interface LineItemDAO {
    void addLineItem(LineItem lineItem);
    void updateLineItem(LineItem lineItem);
    void deleteLineItem(int orderId, int productId);
    List<LineItem> getLineItemsByOrderId(int orderId);
}