package hr.tvz.suio.app.jobs;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import hr.tvz.suio.app.dao.AssetDAO;
import hr.tvz.suio.app.model.Asset;

public class AssetJob extends QuartzJobBean{
    @Autowired 
    AssetDAO assetDao;

    public AssetJob(AssetDAO assetDao) {
        this.assetDao = assetDao;
    }

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
        final List<Asset> assetList = assetDao.findAll();
        String format = "%-40s%s%n";
        if(!assetList.isEmpty()){
        	System.out.println("Trenutni proizvodi");
        	
        	assetList.forEach(asset -> System.out.printf(format,
        			"Ime produkta:" + asset.getName(), "Serijski Broj:" + asset.getSerialNumber() + System.lineSeparator()
        			));
            System.out.println("------------------------------");
        } else {
            System.out.println("Nema proizvoda");
        }
	}
}
