package hr.tvz.suio.app.dao;

import java.util.Date;
import lombok.Data;

@Data
public class AssetDTO {
	Long id;
	private String name;
	private String serialNumber;
	private String productNumber;
	private Integer typeId;
	private Date dateOfPurchase;
	private String inventoryNumber;
	private String status;
	private Date dateOfDisposal;
	
	public AssetDTO(Long id, String name, String serialNumber, String productNumber, Integer typeId, Date dateOfPurchase,
			String inventoryNumber, String status, Date dateOfDisposal) {
		this.id=id;
		this.name=name;
		this.serialNumber=serialNumber;
		this.productNumber=productNumber; 
		this.typeId=typeId;
		this.dateOfPurchase=dateOfPurchase;
		this.inventoryNumber=inventoryNumber;
		this.status=status;
		this.dateOfDisposal=dateOfDisposal;
	}
}
