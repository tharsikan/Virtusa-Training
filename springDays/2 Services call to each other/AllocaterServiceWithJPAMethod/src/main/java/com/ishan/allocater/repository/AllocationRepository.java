package com.ishan.allocater.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ishan.allocater.model.Allocation;

public interface AllocationRepository extends JpaRepository<Allocation, Integer> {

	public List<Allocation> findAllocationsByEmpid(Integer id);
}
