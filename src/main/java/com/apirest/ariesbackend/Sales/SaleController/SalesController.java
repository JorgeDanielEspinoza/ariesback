package com.apirest.ariesbackend.Sales.SaleController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.apirest.ariesbackend.Sales.Batch.SaleBatch.SaleBatch;
import com.apirest.ariesbackend.Sales.Sale.Sale;
import com.apirest.ariesbackend.Sales.Sale.SaleDTO;
import com.apirest.ariesbackend.Sales.SaleService.SalesService;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin
public class SalesController {

    private final SalesService salesService;


    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAllVentas() {
        List<Sale> ventas = salesService.findAllVentas();
        return ResponseEntity.ok(ventas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getVentaById(@PathVariable Integer id) {
        Sale venta = salesService.findVentaById(id);
        return ResponseEntity.ok(venta);
    }

    @PostMapping
    public ResponseEntity<Sale> createVenta(@RequestBody Sale venta) {
        Sale nuevaVenta = salesService.createVenta(venta);
        return ResponseEntity.ok(nuevaVenta);
    }

    @PostMapping("/batch")
    public ResponseEntity<SaleBatch> createSaleBatch(@RequestBody List<Sale> sales) {
        SaleBatch newBatch = salesService.createSaleBatch(sales);
        return ResponseEntity.ok(newBatch);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> updateVenta(@PathVariable Integer id, @RequestBody Sale venta) {
        Sale ventaActualizada = salesService.updateVenta(id, venta);
        return ResponseEntity.ok(ventaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Integer id) {
        salesService.deleteVenta(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/batch")
    public ResponseEntity<Void> deleteVentas(@RequestBody List<Integer> ids) {
        salesService.deleteVentas(ids);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<SaleDTO>> getVentasByUserId(@PathVariable Integer idUser) {
        List<SaleDTO> ventas = salesService.findVentasByUserId(idUser);
        return ResponseEntity.ok(ventas);
    }
}
