package com.apirest.ariesbackend.Sales.Sale;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SaleDTO {
    private Integer id;
    private LocalDate date;
    private Integer idBook;
    private Integer idUser;
    private Integer quantity;
    private BigDecimal subtotal;
    private Integer batchId;

}
