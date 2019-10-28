import com.simplyti.service.api.builder.ApiBuilder;
import com.simplyti.service.api.builder.ApiProvider;

import java.security.SecureRandom;
import java.util.Random;

public class RandomApi implements ApiProvider {

    private final SecureRandom rnd = new SecureRandom();

    @Override
    public void build(ApiBuilder builder) {
        builder.when()
            .get("/random/{size}")
            .withResponseBodyType(ValueList.class)
            .thenFuture(ctx -> ctx.sync(() -> randNumbers(Long.parseLong(ctx.pathParam("size")))));
    }

    private ValueList randNumbers(long n) {
        ValueList list = new ValueList();
        for(int i = 0; i < n; i++) {
            list.add(rnd.nextLong());
        }
        return list;
    }
}
