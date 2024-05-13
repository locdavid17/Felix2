package assets.dao;

import java.util.List;

import assets.entities.Handover;
import assets.entities.Pay_Slip;

public interface Pay_SlipDAO {

		public List<Pay_Slip> getPay_Slips();
		public boolean insertPay_Slip(Pay_Slip p);
		public Pay_Slip getPay_SlipById(String Pay_Slip_Id);
		public boolean deletePay_Slip(String Pay_Slip_Id);
}
