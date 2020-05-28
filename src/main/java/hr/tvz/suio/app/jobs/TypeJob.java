package hr.tvz.suio.app.jobs;

import java.util.Arrays;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import hr.tvz.suio.app.dao.TypeDAO;
import hr.tvz.suio.app.model.Type;

public class TypeJob extends QuartzJobBean {

	@Autowired 
	TypeDAO typeDao;

    public TypeJob(TypeDAO typeDao) {
        this.typeDao = typeDao;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        final List<Type> typeList = typeDao.findAll();
     
        if(!typeList.isEmpty()){
        	System.out.println("--------------- Lista grupa --------------------");
            System.out.println("Grupe koje su dostupne za unos opreme su:");
            typeList.forEach(type -> System.out.println(type.getName()));
            System.out.println("------------------------------------------------");
        } else {
            System.out.println("U bazi nema grupa!");
        }                
    }
}
