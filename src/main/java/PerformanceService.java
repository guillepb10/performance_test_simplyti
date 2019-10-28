import com.simplyti.service.DefaultService;
import com.simplyti.service.builder.di.guice.GuiceService;
import io.netty.util.concurrent.Future;

public class PerformanceService  {

    private DefaultService service;

    public PerformanceService() {
        this.service = GuiceService.builder()
                                .insecuredPort(8080)
                                .withModule(new PerformanceServiceModule())
                            .build();
    }

    private Future<DefaultService> start() {
        return service.start();
    }

    public static final void main(String ...args) {
        PerformanceService service = new PerformanceService();
        service.start();
    }

}

