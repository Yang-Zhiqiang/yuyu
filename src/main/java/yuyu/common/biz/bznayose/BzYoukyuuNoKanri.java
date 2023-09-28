package yuyu.common.biz.bznayose;

import javax.inject.Inject;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import org.slf4j.Logger;

/**
 * 業務共通 名寄せ 要求通番発番
 */
public class BzYoukyuuNoKanri {

    @Inject
    private static Logger logger;

    public BzYoukyuuNoKanri() {
        super();
    }

    public BzYoukyuuNoKanriBean exec(BzYoukyuuNoKanriBean pBzYoukyuuNoKanriBean) {

        logger.debug("▽ 要求通番発番 開始");

        BzSaibanNayose bzSaibanNayose = SWAKInjector.getInstance(BzSaibanNayose.class);

        String youkyuuNo = bzSaibanNayose.exec();

        pBzYoukyuuNoKanriBean.setYoukyuuNo(youkyuuNo);

        logger.debug("△ 要求通番発番 終了");

        return pBzYoukyuuNoKanriBean;
    }
}
