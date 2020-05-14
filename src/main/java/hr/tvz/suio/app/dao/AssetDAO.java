package hr.tvz.suio.app.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import hr.tvz.suio.app.model.Asset;

@Transactional
public interface AssetDAO extends JpaRepository<Asset, Long>{
	AssetDTO findById(Integer id);
	Optional<AssetDTO> findBySerialNumber(String serialNumber);
	@Modifying
	@Query("update Asset e set e.name = ?1, e.serialNumber = ?2, e.productNumber = ?3, e.typeId = ?4, e.dateOfPurchase = ?5, e.inventoryNumber = ?6, e.status = ?7, e.dateOfDisposal = ?8 where e.id = ?9")
	void updateAssetById(String name, String serial_number, String productNumber, Integer typeId, Date dateOfPurchase, String inventoryNumber, String status, Date dateOfDisposal, Long id);
}
