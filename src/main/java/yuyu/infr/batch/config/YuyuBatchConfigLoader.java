package yuyu.infr.batch.config;

import java.util.List;

import javax.inject.Singleton;

import jp.co.slcs.swak.batch.config.BatchDefLoader;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.util.Lazy;
import yuyu.def.db.dao.AM_BatchDao;
import yuyu.def.db.entity.AM_Batch;

import com.google.common.base.Supplier;

/**
 * Yuyuバッチコンフィグローダー
 */
@Singleton
public class YuyuBatchConfigLoader implements BatchDefLoader {

    private Lazy<List<AM_Batch>> batchDefList = new Lazy<>(
        new Supplier<List<AM_Batch>>() {
            @Override
            public List<AM_Batch> get() {
                return SWAKInjector.getInstance(AM_BatchDao.class).selectAll();
            }
        }
    );

    @Override
    public List<AM_Batch> load() {
        return batchDefList.get();
    }

}
