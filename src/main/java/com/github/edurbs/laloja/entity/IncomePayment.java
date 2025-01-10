package com.github.edurbs.laloja.entity;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.NumberFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "INCOME_PAYMENTS", indexes = {
        @Index(name = "IDX_INCOME_PAYMENTS_FINANCIAL_ACCOUNT", columnList = "FINANCIAL_ACCOUNT_ID"),
        @Index(name = "IDX_INCOME_PAYMENTS_INCOME", columnList = "INCOME_ID")
})
@Entity
public class IncomePayment {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    @Temporal(TemporalType.DATE)
    @Column(name = "PAYMENT_DATE", nullable = false)
    @NotNull
    private Date paymentDate;
    @JoinColumn(name = "INCOME_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Income income;
    @Positive(message = "Valor total do pagamento deve ser informado")
    @NotNull
    @NumberFormat(pattern = "#,##0.##", decimalSeparator = ",", groupingSeparator = ".")
    @Column(name = "TOTAL", nullable = false, precision = 19, scale = 2)
    private BigDecimal total;
    @InstanceName
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "FINANCIAL_ACCOUNT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private FinancialAccount financialAccount;
    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;
    @DeletedDate
    @Column(name = "DELETED_DATE")
    private OffsetDateTime deletedDate;

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public FinancialAccount getFinancialAccount() {
        return financialAccount;
    }

    public void setFinancialAccount(FinancialAccount financialAccount) {
        this.financialAccount = financialAccount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public OffsetDateTime getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(OffsetDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}