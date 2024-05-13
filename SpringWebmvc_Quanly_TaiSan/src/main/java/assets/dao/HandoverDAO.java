package assets.dao;

import java.util.List;


import assets.entities.Handover;

public interface HandoverDAO {
	public List<Handover> getHandovers();
	public boolean insertHandover(Handover h);
	public Handover getHandoverById(String handoverID);
	public boolean deleteHandover(String handoverID);
	
	
}
