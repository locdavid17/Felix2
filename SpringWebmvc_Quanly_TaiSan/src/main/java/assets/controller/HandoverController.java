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
import assets.dao.HandoverDAO;
import assets.dao.StaffDAO;
import assets.entities.Asset_List;
import assets.entities.Assets;
import assets.entities.Department;
import assets.entities.Handover;
import assets.entities.Staff;

@Controller
public class HandoverController {
	
	@Autowired
	private Asset_ListDAO asset_ListDAO;
	
	@Autowired 
	private HandoverDAO handoverDAO;
	
	@Autowired
	private StaffDAO staffDAO;
	
	@Autowired
	private AssetsDAO assetsDAO;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	@RequestMapping("/listHandover")
	public String listHandover(Model model) {
		
		List<Handover> handovers = handoverDAO.getHandovers();
		model.addAttribute("list", handovers);
		
		return "listHandover";
	}
	
	
	
	@RequestMapping("/initHandover")
	public String insertHandover(Model model) {
		
	List<Asset_List> asset_Lists = asset_ListDAO.getAsset_Lists();
	model.addAttribute("listAset", asset_Lists);
	
	List<Assets> assets = assetsDAO.getAssets();
	model.addAttribute("listAssets", assets);
		
		Handover h = new Handover();
		model.addAttribute("h", h);
		
		return"insertHandover";
		
	}

	
	@RequestMapping("/insertHandover")
	public String insertHandover(@ModelAttribute("h")Handover h,Model model) {
		boolean bl = handoverDAO.insertHandover(h);
		if(bl) {
			model.addAttribute("success", "Mượn Tài Sản Thành Công");
			
			List<Handover> handovers = handoverDAO.getHandovers();
			model.addAttribute("h", handovers);
			return "HanDover";
		}else {
			model.addAttribute("h", h);
			model.addAttribute("error", "insert failed!");
			return "insertHandover";
		}
	}
	
	
	@RequestMapping("/detailHandover")
	public String detailHandover(@RequestParam("handoverID")String handoverID,Model model) {
		
		Handover handover = handoverDAO.getHandoverById(handoverID);
		model.addAttribute("h", handover);
		
		return"detailHandover";
	}
	
	@RequestMapping("/deleteHandover")
	public String deleteHandover(@RequestParam("handoverID")String handoverID,Model model) {
		boolean bl = handoverDAO.deleteHandover(handoverID);
		if(bl){
			model.addAttribute("succes", "delete successfully!!");
		}else {
			model.addAttribute("err", " delete  failed!!");
		}
		List<Handover> handovers = handoverDAO.getHandovers();
		model.addAttribute("list", handovers);

		return "listHandover";
	}
}
