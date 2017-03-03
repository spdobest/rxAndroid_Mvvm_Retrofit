package spinc.mvvmretrofitrxandroid.dagger.component;

 
import javax.inject.Singleton;
 
import dagger.Component;
import spinc.mvvmretrofitrxandroid.dagger.model.Vehicle;
import spinc.mvvmretrofitrxandroid.dagger.module.VehicleModule;

/**
 * Created by kerry on 14/02/15.
 */
 
@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {
 
    Vehicle provideVehicle();
 
}