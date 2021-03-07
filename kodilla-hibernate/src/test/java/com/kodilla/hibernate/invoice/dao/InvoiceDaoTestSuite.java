package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Item  item1 = new Item( BigDecimal.valueOf(10), 5, BigDecimal.valueOf(50));
        Item  item2 = new Item( BigDecimal.valueOf(20), 3, BigDecimal.valueOf(60));
        Product product1 = new Product("Product1");
        Product product2 = new Product("Product2");
        item1.setProduct(product1);
        item2.setProduct(product2);
        Invoice invoice = new Invoice("3");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

       // Then
        assertNotEquals(0,id);

        //Clean up
//        invoiceDao.deleteById(id);
    }
}
