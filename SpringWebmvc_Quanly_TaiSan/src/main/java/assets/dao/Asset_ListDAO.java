package assets.dao;

import java.util.List;

import assets.entities.Asset_List;
import assets.entities.Assets;

public interface Asset_ListDAO {

		public List<Asset_List> getAsset_Lists();
		public Asset_List getAsset_ListById(Integer assetID);
		public List<Asset_List> getAsset_ListsByName(String name);
		public boolean insertAsset_List(Asset_List a);
		public boolean deleteAssets_List(Integer assetID);
		public boolean updateAssets_List(Asset_List a);
		public List<Asset_List> getAsset_ListsPagination(Integer offset, Integer maxResult);
		public Long getTotalAsset_ListsPagination();
}
