package spinc.mvvmretrofitrxandroid.dagger.module;

 
import javax.inject.Singleton;
 
import dagger.Module;
import dagger.Provides;
import spinc.mvvmretrofitrxandroid.dagger.model.Motor;
import spinc.mvvmretrofitrxandroid.dagger.model.Vehicle;

/**
 * Created by kerry on 14/02/15.
 */
 
@Module
public class VehicleModule {
 
    @Provides @Singleton
    Motor provideMotor(){
        return new Motor();
    }
 
    @Provides @Singleton
    Vehicle provideVehicle(){
        return new Vehicle(new Motor());
    }
}