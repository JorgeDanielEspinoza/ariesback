package com.apirest.ariesbackend.Sales.Batch.SaleBatch;

import java.util.List;

import com.apirest.ariesbackend.Sales.Sale.Sale;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sale_batches")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "saleBatch", cascade = CascadeType.ALL)
    private List<Sale> sales;

    // Otras propiedades comunes del lote, si las hay
}