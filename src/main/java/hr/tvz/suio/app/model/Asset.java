package hr.tvz.suio.app.model;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	asdfasdf
	@Column(name="SERIAL_NUMBER")
	private String serialNumber;
	
	@Column(name="PRODUCT_NUMBER")
	private String productNumber;
	
	@Column(name="TYPE_ID")
	private Integer typeId;
	
	@Column(name="DATE_OF_PURCHASE")
	private Date dateOfPurchase;
	
	@Column(name="INVENTORY_NUMBER")
	private String inventoryNumber;
	
	private String status;
	
	@Column(name="DATE_OF_DISPOSAL")
	private Date dateOfDisposal;
	
    public Asset(Long id, String name, String serialNumber, String productNumber, Integer typeId, Date dateOfPurchase, String inventoryNumber, String status, Date dateOfDisposal) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.productNumber = productNumber;
        this.typeId = typeId;
        this.dateOfPurchase = dateOfPurchase;
        this.inventoryNumber = inventoryNumber;
        this.status = status;
        this.dateOfDisposal = dateOfDisposal;
    }
    public Asset(String name, String serialNumber, String productNumber, Integer typeId, Date dateOfPurchase, String inventoryNumber, String status, Date dateOfDisposal) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.productNumber = productNumber;
        this.typeId = typeId;
        this.dateOfPurchase = dateOfPurchase;
        this.inventoryNumber = inventoryNumber;
        this.status = status;
        this.dateOfDisposal = dateOfDisposal;
    }
}
