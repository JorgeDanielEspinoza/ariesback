package com.apirest.ariesbackend.Sales.SaleService;

import com.apirest.ariesbackend.Sales.Batch.SaleBatchRepository.SaleBatchRepository;
import com.apirest.ariesbackend.Sales.Sale.Sale;
import com.apirest.ariesbackend.Sales.Sale.SaleDTO;
import com.apirest.ariesbackend.Sales.SaleRepository.SaleRepository;
import com.apirest.ariesbackend.Sales.Batch.SaleBatch.SaleBatch;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesServiceImpl implements SalesService{

    private final SaleRepository saleRepository;
    private final SaleBatchRepository saleBatchRepository;

    public SalesServiceImpl(SaleRepository saleRepository, SaleBatchRepository saleBatchRepository) {
        this.saleRepository = saleRepository;
        this.saleBatchRepository = saleBatchRepository;
    }


    @Override
    public List<Sale> findAllVentas() {
        return saleRepository.findAll();
    }

    @Override
    public Sale findVentaById(Integer id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    @Override
    public Sale createVenta(Sale venta) {
        return saleRepository.save(venta);
    }

    @Override
    public SaleBatch createSaleBatch(List<Sale> sales) {
        SaleBatch batch = new SaleBatch();
        batch.setSales(sales);
        sales.forEach(sale -> sale.setSaleBatch(batch));
        return saleBatchRepository.save(batch);
    }

    @Override
    public Sale updateVenta(Integer id, Sale sale) {
        Sale existingSale = findVentaById(id);
        existingSale.setDate(sale.getDate());
        existingSale.setIdBook(sale.getIdBook());
        existingSale.setIdUser(sale.getIdUser());
        existingSale.setQuantity(sale.getQuantity());
        existingSale.setSubtotal(sale.getSubtotal());
        return saleRepository.save(existingSale);
    }

    @Override
    public void deleteVenta(Integer id) {
        saleRepository.deleteById(id);
    }

    @Override
    public void deleteVentas(List<Integer> ids) {
        saleRepository.deleteAllById(ids);
    }

    @Override
    public List<SaleDTO> findVentasByUserId(Integer userId) {
        List<Sale> ventas = saleRepository.findByIdUser(userId);
        return ventas.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private SaleDTO convertToDto(Sale sale) {
        SaleDTO dto = new SaleDTO();
        dto.setId(sale.getId());
        dto.setDate(sale.getDate());
        dto.setIdBook(sale.getIdBook());
        dto.setIdUser(sale.getIdUser());
        dto.setQuantity(sale.getQuantity());
        dto.setSubtotal(sale.getSubtotal());
        dto.setBatchId(sale.getSaleBatch() != null ? sale.getSaleBatch().getId() : null);
        return dto;
    }
}
