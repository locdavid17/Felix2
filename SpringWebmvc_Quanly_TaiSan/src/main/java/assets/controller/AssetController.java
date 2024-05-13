package assets.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

@Controller
public class AssetController {
	@Autowired
	private Asset_ListDAO asset_ListDAO;

	@Autowired
	private DepartmentDAO departmentDAO;

	@Autowired
	private LocationDAO locationDAO;

	@Autowired
	private AssetsDAO assetsDAO;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	@RequestMapping("/listAssets")
	public String listAssets(Integer page,Model model) {
		Integer itemPerPage = 3;		
		Integer offset;
		if(page==null)
			offset = 0;
		else
			offset = (page-1)*itemPerPage;
		
		List<Assets> list = assetsDAO.getAssetsPagination(offset,itemPerPage);
		model.addAttribute("list", list);

		Long totals = assetsDAO.getTotalAssetsPagination();
		Integer totalpage = (int) (totals/itemPerPage + (totals%itemPerPage==0?0:1));
		
		List<Integer> listpage = new ArrayList<Integer>();
		for(int i=1;i<=totalpage;i++) 
			listpage.add(i);
			model.addAttribute("listpage", listpage);
			
			return "listAssets";
		
		
		
			/*
			 * List<Assets> assets = assetsDAO.getAssets(); model.addAttribute("list",
			 * assets);
			 * 
			 * return "listAssets";
			 */
	}
	
	
	
	
	@RequestMapping("/initAssets")
	public String initAssets(Model model) {
		List<Asset_List> asset_Lists = asset_ListDAO.getAsset_Lists();
		model.addAttribute("listAset", asset_Lists);

		Assets a = new Assets();
		model.addAttribute("a", a);
		return "insertAssets";

	}

	@RequestMapping("/insertAssets")
	public String insertAssets(@ModelAttribute("a") Assets a, @RequestParam("imgUrl") MultipartFile imgFile,
			HttpServletRequest request, Model model) {
			
		
				if (imgFile != null) {
					a.setImage(imgFile.getOriginalFilename());
				}
				boolean bl = assetsDAO.insertAssets(a);
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
					List<Assets> assets = assetsDAO.getAssets();
					model.addAttribute("a", assets);
					return "redirect:/listAssets";
				} else {
					model.addAttribute("p", a);
					model.addAttribute("error", "insert failed!");
					return "insertAssets";

				}
			}
	
			
	
		
	

	@RequestMapping("/detailAssets")
	public String detailAssets(@RequestParam("asetId")Integer asetId,Model model) {
		Assets assets = assetsDAO.assetsById(asetId);
		model.addAttribute("a", assets);
		return "detailAssets";
	}
	
	
	
	@RequestMapping("/deleteAssets")
	public String deleteAssets(@RequestParam("asetId")Integer asetId,Model model) {
		boolean bl = assetsDAO.deleteAssets(asetId);
		if(bl) {
			model.addAttribute("succes", "delete successfully!!");
		}else {
			model.addAttribute("err", " delete  failed!!");
		}
		
		List<Assets> assets = assetsDAO.getAssets();
		model.addAttribute("list", assets);

		return "listAssets";
	}
	
	@RequestMapping("/initUpdateAssets")
	public String initUpdateAssets(@RequestParam("asetId")Integer asetId,Model model) {
		List<Asset_List> asset_Lists = asset_ListDAO.getAsset_Lists();
		model.addAttribute("listAset", asset_Lists);
		
		Assets assets = assetsDAO.assetsById(asetId);
		model.addAttribute("a", assets);
		
		return "UpdateAssets";
		
	}
	@RequestMapping("/UpdateAssets")
	public String UpdateAssets(@ModelAttribute("a")Assets a,@RequestParam("imgUrl") MultipartFile imgFile,
			HttpServletRequest request,Model model) {
		if (imgFile != null) {
			a.setImage(imgFile.getOriginalFilename());
		}
		
		boolean bl = assetsDAO.updateAssets(a);
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
			return"redirect:/listAssets";
		}else {
			model.addAttribute("a", a);
			model.addAttribute("err", "update Failed!");
			return"UpdateAssets";
		}
	}
	
	@RequestMapping("/searchAssetsName")
	public String searchAssetsName(@RequestParam("asetName")String asetName,Model model  ) {
		List<Assets> assets = assetsDAO.getAssetsByName(asetName);
		model.addAttribute("list", assets);
		
		return "listAssets";
	}
}
