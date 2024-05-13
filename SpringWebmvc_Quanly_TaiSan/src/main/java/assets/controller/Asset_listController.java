package assets.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import assets.dao.Asset_ListDAO;
import assets.dao.AssetsDAO;
import assets.dao.DepartmentDAO;
import assets.dao.LocationDAO;
import assets.entities.Asset_List;
import assets.entities.Assets;
import assets.entities.Department;
import assets.entities.Location;

@Controller
public class Asset_listController {
	@Autowired
	private Asset_ListDAO asset_ListDAO;

	@Autowired
	private DepartmentDAO departmentDAO;

	@Autowired
	private LocationDAO locationDAO;

	@Autowired
	private AssetsDAO assetsDAO;

	@RequestMapping("/home")
	public String home(Model model) {

		return "home";
	}

	@RequestMapping("/listAsset_List")
	public String listAsset_List(Integer page, Model model) {

		/*
		 * String path = request.getServletContext().getRealPath("resoures/images");
		 * File f = new File(path); if(imgFile!=null) { File dest = new
		 * File(f.getAbsoluteFile()+"/"+imgFile.getOriginalFilename()); try {
		 * Files.write(dest.toPath(), imgFile.getBytes(),
		 * StandardOpenOption.CREATE_NEW); aset.setImage(imgFile.getOriginalFilename());
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */
		
		Integer itemPerPage = 3;		
		Integer offset;
		if(page==null)
			offset = 0;
		else
			offset = (page-1)*itemPerPage;
		
		List<Asset_List> list = asset_ListDAO.getAsset_ListsPagination(offset,itemPerPage);
		model.addAttribute("list", list);

		Long totals = asset_ListDAO.getTotalAsset_ListsPagination();
		Integer totalpage = (int) (totals/itemPerPage + (totals%itemPerPage==0?0:1));
		
		List<Integer> listpage = new ArrayList<Integer>();
		for(int i=1;i<=totalpage;i++) 
			listpage.add(i);
			model.addAttribute("listpage", listpage);
			
			return "listAsset_List";
		
		
		/*
		 * List<Asset_List> asset_Lists = asset_ListDAO.getAsset_Lists();
		 * model.addAttribute("list", asset_Lists);
		 * 
		 * return "listAsset_List";
		 */
	}

	



	
	@RequestMapping("/DetailAssets_List")
	public String DetailAssets_List(@RequestParam("assetID") Integer assetID, Model model) {

		Asset_List asset_List = asset_ListDAO.getAsset_ListById(assetID);
		model.addAttribute("a", asset_List);
		return "DetailAssets_List";
	}
	
	
	@RequestMapping("/searchAssets_ListName")
	public String searchAssets_ListName(@RequestParam("assetName")String assetName,Model model  ) {
		List<Asset_List> asset_Lists = asset_ListDAO.getAsset_ListsByName(assetName);
		model.addAttribute("list", asset_Lists);
		
		return "listAsset_List";
	}
	
	
	@RequestMapping("/initAsset_List")
	public String initAsset_List(Model model) {
		List<Department> departments = departmentDAO.getDepartments();
		model.addAttribute("listDepartment", departments);
		
		List<Location> locations = locationDAO.getloLocations();
		model.addAttribute("listLocation", locations);
		
		Asset_List a = new Asset_List();
		model.addAttribute("a", a);
		return "insertAsset_List";
	}
	
	@RequestMapping("/insertAsset_List")
	public String insertAsset_List(@ModelAttribute("a")Asset_List a,@RequestParam("imgUrl") MultipartFile imgFile,HttpServletRequest request, Model model) {
		if (imgFile != null) {
			a.setImage(imgFile.getOriginalFilename());
		}
		boolean bl = asset_ListDAO.insertAsset_List(a);
		if (bl) {
			String path = request.getServletContext().getRealPath("resoures/images");
			File f = new File(path);

			if (imgFile != null) {
				File dest = new File(f.getAbsoluteFile() + "/" + imgFile.getOriginalFilename());
				if (!dest.exists()) {
					try {
						Files.write(dest.toPath(), imgFile.getBytes(), StandardOpenOption.CREATE_NEW);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
				

			List<Asset_List> asset_Lists = asset_ListDAO.getAsset_Lists();
			model.addAttribute("list", asset_Lists);

			return "listAsset_List";
	}else {
		model.addAttribute("a", a);
		model.addAttribute("error", "insert failed!");
		return "insertAsset_List";
	}

}
	@RequestMapping("/deleteAssets_List")
	public String deleteAssets_List(@RequestParam("assetID")Integer assetID,Model model) {
		boolean bl = asset_ListDAO.deleteAssets_List(assetID);
		if(bl) {
			model.addAttribute("succes", "delete successfully!!");
		}else {
			model.addAttribute("err", " delete  failed!!");
		}
		
		List<Asset_List> asset_Lists = asset_ListDAO.getAsset_Lists();
		model.addAttribute("list", asset_Lists);

		return "listAsset_List";
	}
	
	@RequestMapping("/initUpdateAsset_List")
	public String initUpdateAsset_List(@RequestParam("assetID")Integer assetID,Model model) {
		
		List<Department> departments = departmentDAO.getDepartments();
		model.addAttribute("listDepartment", departments);
		
		List<Location> locations = locationDAO.getloLocations();
		model.addAttribute("listLocation", locations);
		
		
		Asset_List asset_List = asset_ListDAO.getAsset_ListById(assetID);
		model.addAttribute("a", asset_List);
		
		return "UpdateAssets_List";
		
	}
	@RequestMapping("/UpdateAssets_List")
	public String UpdateAssets_List(@ModelAttribute("a")Asset_List a,@RequestParam("imgUrl") MultipartFile imgFile,
			HttpServletRequest request,Model model) {
		
		if (imgFile != null) {
			a.setImage(imgFile.getOriginalFilename());
		}
		
		boolean bl = asset_ListDAO.updateAssets_List(a);
		if(bl) {
			String path = request.getServletContext().getRealPath("resoures/images");
			File f = new File(path);

			if (imgFile != null) {
				File dest = new File(f.getAbsoluteFile() + "/" + imgFile.getOriginalFilename());
				if (!dest.exists()) {
					try {
						Files.write(dest.toPath(), imgFile.getBytes(), StandardOpenOption.CREATE_NEW);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
			return"redirect:/listAsset_List";
		}else {
			model.addAttribute("a", a);
			model.addAttribute("err", "update Failed!");
			return"UpdateAssets_List";
		}
	}
	
}