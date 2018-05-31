
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener()
public class MyServletContextListener implements ServletContextListener{

   @Override
   public void contextInitialized(ServletContextEvent contextEvent) {
        /* Do Startup stuff. */
	   
	   launchTask(8,"08:00:00");	   
	   launchTask(10,"10:00:00");	   
	   launchTask(12,"12:00:00");	   
	   launchTask(14,"14:00:00");	   
	   launchTask(16,"16:00:00");
   }

   private void launchTask(int heure,String h) {
	// TODO Auto-generated method stub
	   LocalDateTime localNow = LocalDateTime.now();
       ZoneId currentZone = ZoneId.of("Africa/Algiers");
       ZonedDateTime zonedNow = ZonedDateTime.of(localNow, currentZone);
       ZonedDateTime zonedNext5 ;
       System.out.println(zonedNow);
       zonedNext5 = zonedNow.withHour(heure).withMinute(0).withSecond(0);
       if(zonedNow.compareTo(zonedNext5) > 0)
           zonedNext5 = zonedNext5.plusDays(1);
       System.out.println(zonedNext5+"zone next 5");

       Duration duration = Duration.between(zonedNow, zonedNext5);
       long initalDelay = duration.getSeconds();

       ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);            
       scheduler.scheduleAtFixedRate(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Model.Contact.Notifier(h);
		}
    	   
       }, initalDelay,24*60*60, TimeUnit.SECONDS);
       
}

//protected void eb3tNotifTa3Sa3aHedi(String h) {
	// TODO Auto-generated method stub
	
	//nroho lela bdd wnchoufo les notif programmés f sa3a lflanya f nhar lflani wnb3tohom
//}

@Override
   public void contextDestroyed(ServletContextEvent contextEvent) {
        /* Do Shutdown stuff. */
   }

}