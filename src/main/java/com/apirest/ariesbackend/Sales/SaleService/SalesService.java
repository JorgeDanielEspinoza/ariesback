package com.apirest.ariesbackend.Sales.SaleService;

import java.util.List;

import com.apirest.ariesbackend.Sales.Batch.SaleBatch.SaleBatch;
import com.apirest.ariesbackend.Sales.Sale.Sale;
import com.apirest.ariesbackend.Sales.Sale.SaleDTO;

public interface SalesService {
    List<Sale> findAllVentas();

    Sale findVentaById(Integer id);

    Sale createVenta(Sale venta);

    SaleBatch createSaleBatch(List<Sale> ventas);

    Sale updateVenta(Integer id, Sale venta);

    void deleteVenta(Integer id);

    void deleteVentas(List<Integer> ids);

    List<SaleDTO> findVentasByUserId(Integer userId);
}