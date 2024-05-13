package assets.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import assets.dao.Asset_ListDAO;
import assets.dao.AssetsDAO;
import assets.dao.Pay_SlipDAO;
import assets.entities.Asset_List;
import assets.entities.Assets;
import assets.entities.Handover;
import assets.entities.Pay_Slip;

@Controller
public class Pay_SlipController {
	
	@Autowired
	private Pay_SlipDAO pay_SlipDAO;
	
	@Autowired
	private Asset_ListDAO asset_ListDAO;
	
	@Autowired
	private AssetsDAO assetsDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	
	@RequestMapping("/listPay_Slip")
	public String listPay_Slip(Model model) {
		
		List<assets.entities.Pay_Slip> pay_Slips = pay_SlipDAO.getPay_Slips();
		model.addAttribute("list", pay_Slips);
		
		return "listPay_Slip";
	}
	

	@RequestMapping("/initPay_Slip")
	public String initPay_Slip(Model model) {
		
		List<Asset_List> asset_Lists = asset_ListDAO.getAsset_Lists();
		model.addAttribute("listAsset_List", asset_Lists);
		
		List<Assets> assets = assetsDAO.getAssets();
		model.addAttribute("listAssets", assets);
			
		
		Pay_Slip p = new Pay_Slip();
		model.addAttribute("p", p);
		return"insertPay_Slip";
		
	}

	
	@RequestMapping("/insertPay_Slip")
	public String insertPay_Slip(@ModelAttribute("p")Pay_Slip p,Model model) {
		boolean bl = pay_SlipDAO.insertPay_Slip(p);
		if(bl) {
			model.addAttribute("success", "Trả Tài Sản Thành Công");
			
			List<Pay_Slip> pay_Slips = pay_SlipDAO.getPay_Slips();
			model.addAttribute("p", pay_Slips);
			return "pay_Slips";
		}else {
			model.addAttribute("p", p);
			model.addAttribute("error", "insert failed!");
			return "insertPay_Slip";
		}
	}
	
	@RequestMapping("/deletePay_Slip")
	public String deletePay_Slip(@RequestParam("pay_Slip_Id")String pay_Slip_Id,Model model) {
		boolean bl = pay_SlipDAO.deletePay_Slip(pay_Slip_Id);
		if(bl){
			model.addAttribute("succes", "delete successfully!!");
		}else {
			model.addAttribute("err", " delete  failed!!");
		}
		List<assets.entities.Pay_Slip> pay_Slips = pay_SlipDAO.getPay_Slips();
		model.addAttribute("list", pay_Slips);
		
		return "listPay_Slip";
	}
	
	@RequestMapping("/detailPay_Slip")
	public String detailHandover(@RequestParam("pay_Slip_Id")String pay_Slip_Id,Model model) {
		
		Pay_Slip pay_Slip = pay_SlipDAO.getPay_SlipById(pay_Slip_Id);
		model.addAttribute("p", pay_Slip);
		
		return"detailPay_Slip";
	}
	
	
	

}
