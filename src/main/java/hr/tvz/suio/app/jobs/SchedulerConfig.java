package hr.tvz.suio.app.jobs;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    private static final String EMPLOYEE_PRINT_JOB = "employeeJob";
    private static final String EMPLOYEE_PRINT_TRIGGER = "studentPrintTrigger";
    
    @Bean
    public JobDetail studentPrintJobDetail() {
        return JobBuilder.newJob(EmployeeJob.class).withIdentity(EMPLOYEE_PRINT_JOB)
                .storeDurably().build();
    }

    @Bean
    public SimpleTrigger studentPrintTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(10).repeatForever();

        return TriggerBuilder.newTrigger().forJob(studentPrintJobDetail())
                .withIdentity(EMPLOYEE_PRINT_TRIGGER).withSchedule(scheduleBuilder).build();
    }
    
}
