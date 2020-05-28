package hr.tvz.suio.app.jobs;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hr.tvz.suio.app.model.Asset;

@Configuration
public class SchedulerConfig {
	
	 	  private static final String EMPLOYEE_PRINT_JOB = "employeeJob";
	    private static final String EMPLOYEE_PRINT_TRIGGER = "employeePrintTrigger";
	    
	    private static final String ASSET_JOB = "assetJob";
	    private static final String ASSET_PRINT_TRIGGER = "assetPrintTriggers";
	    
	    private static final String TYPE_PRINT_JOB = "typeJob";
	    private static final String TYPE_PRINT_TRIGGER = "typePrintTrigger";  
	    
      @Bean
      public JobDetail employeePrintJobDetail() {
          return JobBuilder.newJob(EmployeeJob.class).withIdentity(EMPLOYEE_PRINT_JOB)
	                 .storeDurably().build();
	    }
	    @Bean
	    public SimpleTrigger employeePrintTrigger() {
	        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
	                .withIntervalInSeconds(10).repeatForever();

	        return TriggerBuilder.newTrigger().forJob(employeePrintJobDetail())
	                .withIdentity(EMPLOYEE_PRINT_TRIGGER).withSchedule(scheduleBuilder).build();
	    }
	    @Bean
	    public JobDetail assetPrintJob() {
	    	return JobBuilder.newJob(AssetJob.class).withIdentity(ASSET_PRINT_TRIGGER).storeDurably().build();
	    }   
	    @Bean
	    public SimpleTrigger assetPrintTrigger() {
	    	SimpleScheduleBuilder assetBuilder = SimpleScheduleBuilder.simpleSchedule()
	    			.withIntervalInSeconds(20).repeatForever();
	    	return TriggerBuilder.newTrigger().forJob(assetPrintJob())
	    			.withIdentity(ASSET_PRINT_TRIGGER).withSchedule(assetBuilder).build();	
	    }    
      @Bean
      public JobDetail typePrintJobDetail() {
          return JobBuilder.newJob(TypeJob.class).withIdentity(TYPE_PRINT_JOB)
                  .storeDurably().build();
      }
      public SimpleTrigger typePrintTrigger() {
          SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                  .withIntervalInSeconds(10).repeatForever();

          return TriggerBuilder.newTrigger().forJob(typePrintJobDetail())
                  .withIdentity(TYPE_PRINT_TRIGGER).withSchedule(scheduleBuilder).build();
      }
}
