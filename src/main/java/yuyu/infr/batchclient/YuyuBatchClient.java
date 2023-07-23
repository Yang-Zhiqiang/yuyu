package yuyu.infr.batchclient;

import jp.co.slcs.swak.batch.client.AbstractBatchClient;
import yuyu.def.base.configuration.YuyuBaseConfig;

public class YuyuBatchClient extends AbstractBatchClient {

    @Override
    protected String getHost() {
        return YuyuBaseConfig.getInstance().getBatchHost();
    }

    @Override
    protected int getPort() {
        return YuyuBaseConfig.getInstance().getBatchPort();
    }

}
