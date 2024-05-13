package assets.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import assets.entities.Asset_List;
import assets.entities.Assets;

public interface AssetsDAO {
		public List<Assets> getAssets();
		public boolean insertAssets(Assets a);
		public Assets assetsById(Integer asetId);
		public boolean deleteAssets(Integer asetId);
		public boolean updateAssets(Assets a);
		public List<Assets> getAssetsByName(String name);
		public List<Assets> getAssetsPagination(Integer offset, Integer maxResult);
		public Long getTotalAssetsPagination();

}
