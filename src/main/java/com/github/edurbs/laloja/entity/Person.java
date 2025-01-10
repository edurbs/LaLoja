package com.github.edurbs.laloja.entity;

import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.EmbeddedParameters;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.NumberFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "PERSON")
@Entity
public class Person {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;
    @Column(name = "PERSON_TYPE", nullable = false)
    @NotNull(message = "O tipo de pessoa deve ser informado")
    private String personType;
    @Column(name = "DOC_ID", length = 19)
    private String docId;
    @NotBlank(message = "O nome deve ser informado")
    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;
    @Column(name = "INTERNAL_CODE")
    private String internalCode;
    @Email(message = "O email deve ser válido")
    @Column(name = "EMAIL")
    private String email;
    @Pattern(message = "Deve ser um telefone válido no formato  99 91234 1234", regexp = "^([1-9]{2}) ([0-9])?([0-9]{4}) ([0-9]{4})$")
    @Column(name = "PHONE", length = 14)
    private String phone;
    @Pattern(message = "Deve ser um telefone válido no formato  99 91234 1234", regexp = "^([1-9]{2}) ([0-9])?([0-9]{4}) ([0-9]{4})$")
    @Column(name = "CELL_PHONE", length = 14)
    private String cellPhone;
    @PastOrPresent(message = "A data deve estar no passado ou no dia de hoje.")
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;
    @EmbeddedParameters(nullAllowed = false)
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipCode", column = @Column(name = "ADDRESS_ZIP_CODE", length = 9)),
            @AttributeOverride(name = "street", column = @Column(name = "ADDRESS_STREET")),
            @AttributeOverride(name = "number", column = @Column(name = "ADDRESS_NUMBER_", length = 50)),
            @AttributeOverride(name = "complement", column = @Column(name = "ADDRESS_COMPLEMENT")),
            @AttributeOverride(name = "neighborhood", column = @Column(name = "ADDRESS_NEIGHBORHOOD")),
            @AttributeOverride(name = "city", column = @Column(name = "ADDRESS_CITY")),
            @AttributeOverride(name = "state", column = @Column(name = "ADDRESS_STATE"))
    })
    private Address address;
    @NumberFormat(pattern = "#,##0.##", decimalSeparator = ",", groupingSeparator = ".")
    @PositiveOrZero(message = "O limite de crédito deve ser positivo ou zero")
    @Column(name = "CREDIT_LIMIT", nullable = false, precision = 19, scale = 2)
    @NotNull
    private BigDecimal creditLimit;
    @NumberFormat(pattern = "#,##0.##", decimalSeparator = ",", groupingSeparator = ".")
    @Column(name = "DEBIT_BALANCE", precision = 19, scale = 2)
    private BigDecimal debitBalance;
    @Column(name = "NOTES")
    @Lob
    private String notes;
    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;
    @DeletedDate
    @Column(name = "DELETED_DATE")
    private OffsetDateTime deletedDate;
    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;
    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private OffsetDateTime lastModifiedDate;
    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;
    @CreatedDate
    @Column(name = "CREATED_DATE")
    private OffsetDateTime createdDate;

    public BigDecimal getDebitBalance() {
        return debitBalance;
    }

    public void setDebitBalance(BigDecimal debitBalance) {
        this.debitBalance = debitBalance;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonType getPersonType() {
        return personType == null ? null : PersonType.fromId(personType);
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType == null ? null : personType.getId();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public OffsetDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
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