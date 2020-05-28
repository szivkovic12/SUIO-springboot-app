package hr.tvz.suio.app.web;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import hr.tvz.suio.app.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.suio.app.dao.*;

@RestController
@RequestMapping("assets")
@CrossOrigin(origins = "http://localhost:4200")
public class AssetRestController {
	
	@Autowired
	AssetService assetService;

    @GetMapping
    public List<AssetDTO> getAssets(){
        return assetService.getAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
	public void saveAsset(@RequestBody Asset asset) {
    	assetService.addNewAsset(asset);
	}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
	public void update(@PathVariable Long id, @RequestBody AssetDTO asset) {
    	assetService.updateAsset(id, asset);
	}
    @GetMapping("/{id}")
	public Optional<Asset> findOne(@PathVariable Long id) {
    	return assetService.findAssetById(id);
	}
    @GetMapping("/serialNumber/{serialNumber}")
	public Optional<AssetDTO> findOne(@PathVariable String serialNumber) {
    	return assetService.findAssetBySerialNumber(serialNumber);
	}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
	public void deleteAsset(@PathVariable Long id) {
    	assetService.deleteAsset(id);
	}
}
