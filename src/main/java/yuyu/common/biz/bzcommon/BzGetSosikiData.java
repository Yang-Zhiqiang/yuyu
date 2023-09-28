package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.bean.BeanUtil;

import org.slf4j.Logger;

import yuyu.def.base.detacher.AM_SosikiDetacher;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SosikiYuuksHantKbn;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.db.entity.AM_Sosiki;

/**
 * 業務共通 共通 組織情報取得クラス
 */
public class BzGetSosikiData {

    @Inject
    private static Logger logger;

    @Inject
    private BaseDomManager baseDomManager;

    public BzGetSosikiData() {
        super();
    }

    public BzGetSosikiDataBean exec(String pSosikicd, BizDate pKijyunymd) {

        logger.debug("▽ 組織情報取得 開始");

        BzGetSosikiDataBean getSosikiDataBean = SWAKInjector.getInstance(BzGetSosikiDataBean.class);

        if (BizUtil.isBlank(pSosikicd)) {
            getSosikiDataBean.setSosikimasterumukbn(C_SosikimasterUmuKbn.NONE);
            getSosikiDataBean.setSosikiyuukshantkbn(C_SosikiYuuksHantKbn.HANTEIHUKA);

            logger.debug("△ 組織情報取得 終了");

            return getSosikiDataBean;
        }

        AM_Sosiki sosiki = baseDomManager.getSosiki(pSosikicd);
        sosiki = AM_SosikiDetacher.detachSosikitouched(sosiki);

        if (sosiki == null) {
            getSosikiDataBean.setSosikimasterumukbn(C_SosikimasterUmuKbn.NONE);
            getSosikiDataBean.setSosikiyuukshantkbn(C_SosikiYuuksHantKbn.HANTEIHUKA);
            logger.debug("△ 組織情報取得 終了");

            return getSosikiDataBean;
        }

        BeanUtil.copyProperties(getSosikiDataBean, sosiki);

        getSosikiDataBean.setSosikimasterumukbn(C_SosikimasterUmuKbn.ARI);
        if (pKijyunymd == null) {

            getSosikiDataBean.setSosikiyuukshantkbn(C_SosikiYuuksHantKbn.HANTEIHUKA);
            logger.debug("△ 組織情報取得 終了");

            return getSosikiDataBean;
        }

        BizDateYM sosikisinsetuym = sosiki.getSosikisinsetuym();
        BizDateYM sosikihaisiym = sosiki.getSosikihaisiym();

        if (sosikisinsetuym == null) {
            sosikisinsetuym = BizDateYM.MIN_VALUE;
        }

        if (sosikihaisiym == null) {
            sosikihaisiym = BizDateYM.MAX_VALUE;
        }

        BizDateYM kijyunYm = pKijyunymd.getBizDateYM();

        if ((BizDateUtil.compareYm(sosikisinsetuym, kijyunYm) == BizDateUtil.COMPARE_EQUAL ||
            BizDateUtil.compareYm(sosikisinsetuym, kijyunYm) == BizDateUtil.COMPARE_LESSER)
            && (BizDateUtil.compareYm(kijyunYm, sosikihaisiym) == BizDateUtil.COMPARE_EQUAL ||
            BizDateUtil.compareYm(kijyunYm, sosikihaisiym) == BizDateUtil.COMPARE_LESSER)) {
            getSosikiDataBean.setSosikiyuukshantkbn(C_SosikiYuuksHantKbn.OK);
        }
        else {
            getSosikiDataBean.setSosikiyuukshantkbn(C_SosikiYuuksHantKbn.NG);
        }

        BizDate kouryokukaisiymd = sosiki.getKouryokukaisiymd();

        if (kouryokukaisiymd == null) {
            kouryokukaisiymd = BizDate.MAX_VALUE;
        }
        BizDate kijyunYmd = pKijyunymd;

        if (BizDateUtil.compareYmd(kijyunYmd, kouryokukaisiymd) == BizDateUtil.COMPARE_LESSER) {
            getSosikiDataBean.setKijyunymdjdsosikikihontikucd(sosiki.getSosikikihontikucd());
        }
        else {
            getSosikiDataBean.setKijyunymdjdsosikikihontikucd(sosiki.getHensosikikihontikucd());
        }

        logger.debug("△ 組織情報取得 終了");

        return getSosikiDataBean;
    }

    public BzGetSosikiDataBean exec(String pSosikicd) {

        BizDate kijyunYmd = null;

        BzGetSosikiDataBean getSosikiDataBean = exec(pSosikicd, kijyunYmd);

        return getSosikiDataBean;
    }
}
