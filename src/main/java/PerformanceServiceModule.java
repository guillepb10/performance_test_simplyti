import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.simplyti.service.api.builder.ApiProvider;
import com.simplyti.service.serializer.json.JacksonModule;

public class PerformanceServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder.newSetBinder(binder(), ApiProvider.class).addBinding().to(RandomApi.class);
        install(new JacksonModule());
    }
}
