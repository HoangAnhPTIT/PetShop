package com.example.demo.Entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "voucher")
@Getter @Setter @RequiredArgsConstructor
public class VoucherEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "name")
    private String name;

    @Column(name = "effective_date")
    private Timestamp effectiveDate;

    @Column(name = "exprired_date")
    private Timestamp expriredDate;

    @Column(name = "value_percent")
    private float valuePercent;

    @Column(name = "max_value")
    private float maxValue;

    @Column(name = "quantity")
    private int quantity;
    
    @OneToMany(mappedBy = "voucherEntity")
    private Set<UserVoucher> userVouchers;
}
