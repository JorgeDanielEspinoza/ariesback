package com.apirest.ariesbackend.Sales.Sale;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;

import com.apirest.ariesbackend.Sales.Batch.SaleBatch.SaleBatch;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "batch_id", nullable = false)
    private SaleBatch saleBatch;
    @Column (name = "date")
    private LocalDate date;
    @Column (name = "book")
    private Integer idBook;
    @Column (name = "user")
    private Integer idUser;
    @Column (name = "quantity")
    private Integer quantity;
    @Column (name = "subtotal")
    private BigDecimal subtotal;

}
