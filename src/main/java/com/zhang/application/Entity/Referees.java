package com.zhang.application.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Referees {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer applicantId;
  private Integer staffIdCadId;
  private Integer status;

  @Override
  public String toString() {
    return "Referees{" +
            "id=" + id +
            ", applicantId=" + applicantId +
            ", staffIdCadId=" + staffIdCadId +
            ", status=" + status +
            '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getApplicantId() {
    return applicantId;
  }

  public void setApplicantId(Integer applicantId) {
    this.applicantId = applicantId;
  }

  public Integer getStaffIdCadId() {
    return staffIdCadId;
  }

  public void setStaffIdCadId(Integer staffIdCadId) {
    this.staffIdCadId = staffIdCadId;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
