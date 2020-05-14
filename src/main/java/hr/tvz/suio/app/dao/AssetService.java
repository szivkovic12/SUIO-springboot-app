package hr.tvz.suio.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hr.tvz.suio.app.model.Asset;

public interface AssetService {
	List<AssetDTO> getAll();
	Optional<Asset> findAssetById(Long id);
	Optional<AssetDTO> findAssetBySerialNumber(String serialNumber);
	void updateAsset(Long id, AssetDTO asset);
	void addNewAsset(Asset asset);
	void deleteAsset(Long id);
}
