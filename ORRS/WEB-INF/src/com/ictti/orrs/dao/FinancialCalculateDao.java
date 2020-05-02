package com.ictti.orrs.dao;

import java.util.List;

import com.ictti.orrs.business.entity.FinancialCalculate;

public interface FinancialCalculateDao {
	//For Admin Financial  Caluclate Insert
	void saveFinancialOutcome(FinancialCalculate myFinancial);

	List<FinancialCalculate> getAllFinancialAmountList();

	FinancialCalculate geFinancialProfilebyId(int parseInt);

	void saveUpdateFinancialOutcome(FinancialCalculate myFinancial);
	

}
