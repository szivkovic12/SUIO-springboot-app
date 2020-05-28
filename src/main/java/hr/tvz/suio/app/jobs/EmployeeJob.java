package hr.tvz.suio.app.jobs;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import hr.tvz.suio.app.dao.EmployeeDAO;
import hr.tvz.suio.app.model.Employee;

public class EmployeeJob extends QuartzJobBean{

   
    @Autowired 
    EmployeeDAO employeeDao;

    public EmployeeJob(EmployeeDAO employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        final List<Employee> employeeList = employeeDao.findAll();
        int lista= employeeList.size();
     
        if(!employeeList.isEmpty()){
        	System.out.println("------------------------------");
            System.out.println("Ukupan broj upisanih zaposlenika: " + lista);
            System.out.println("------------------------------");
        } else {
            System.out.println("Trenutno nema upisanih zaposlenika");
        }
                
    }
}
