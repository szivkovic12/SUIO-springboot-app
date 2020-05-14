package hr.tvz.suio.app.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.Context;
import hr.tvz.suio.app.model.Asset;

@Service
public class AssetServiceImpl implements AssetService{
	@Autowired
	AssetDAO assetDAO;
	
	@Override
	public List<AssetDTO> getAll() {
		return assetDAO.findAll().stream().map(this::mapAssetToDTO).collect(Collectors.toList());
	}
	
	@Override
	public Optional<AssetDTO> findAssetBySerialNumber(String serialNumber) {
		return assetDAO.findBySerialNumber(serialNumber);
	}

	private AssetDTO mapAssetToDTO(Asset asset) {
		return new AssetDTO(
				asset.getName(), 
				asset.getSerialNumber(), 
				asset.getProductNumber(),
				asset.getTypeId(),
				asset.getDateOfPurchase(),
				asset.getInventoryNumber(), 
				asset.getStatus(), 
				asset.getDateOfDisposal());
	}

	@Override
	public void updateAsset(Long id, AssetDTO asset) {
		assetDAO.updateAssetById(asset.getName(), asset.getSerialNumber(), asset.getProductNumber(), asset.getTypeId(), asset.getDateOfPurchase(), asset.getInventoryNumber(), asset.getStatus(), asset.getDateOfDisposal(), id);
	}

	@Override
	public Optional<Asset> findAssetById(Long id) {
		return assetDAO.findById(id);
	}

	@Override
	public void addNewAsset(Asset asset) {
		assetDAO.save(asset);
	}

	@Override
	public void deleteAsset(Long id) {
		assetDAO.deleteById(id);
		
	}
}
