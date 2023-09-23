package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.ObjectUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.dba4gettkjitenzennouinfo.GetTkJitenZennouInfoDao;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Zennou;

/**
 * 契約保全 契約保全共通 特定時点前納情報取得
 */
public class GetTkJitenZennouInfo {

    @Inject
    private static Logger logger;

    @Inject
    private GetTkJitenZennouInfoDao getTkJitenZennouInfoDao;

    public IT_Zennou exec(C_ZennouSeisanKbn pZennouSeisanKbn, BizDate pZennouHanteiKijyunYmd, IT_Zennou pZennou) {

        logger.debug("▽ 特定時点前納情報取得 開始");

        IT_Zennou zennouOut = ObjectUtil.deepCopy(pZennou);
        IT_AnsyuKihon ansyuKihon = pZennou.getAnsyuKihon();

        if (C_ZennouSeisanKbn.SEISANZUMI.eq(pZennouSeisanKbn)) {
            if (!IKhozenCommonConstants.KINOUID_GENGAKU.equals(pZennou.getGyoumuKousinKinou())) {
                logger.debug("△ 特定時点前納情報取得 終了");
                return zennouOut;
            }

            IT_Zennou zennouBefore = pZennou;
            IT_Zennou  zennouAfter = getTkJitenZennouInfoDao.getZennou(ansyuKihon,
                zennouBefore.getZennoukaisiymd(),
                zennouBefore.getRenno() + 1);

            if (zennouAfter == null) {
                logger.debug("△ 特定時点前納情報取得 終了");
                return zennouOut;
            }

            zennouOut.setZennounyuukinkgk(zennouBefore.getZennounyuukinkgk().subtract(zennouAfter.getZennounyuukinkgk()));
            zennouOut.setZennoujihrkp(zennouBefore.getZennoujihrkp().subtract(zennouAfter.getZennoujihrkp()));

            logger.debug("△ 特定時点前納情報取得 終了");
            return zennouOut;
        }

        if (pZennou.getRenno() == 1) {
            logger.debug("△ 特定時点前納情報取得 終了");
            return zennouOut;
        }

        IT_Zennou zennouAfter = pZennou;
        for (int i = 0; i < pZennou.getRenno(); i++) {
            IT_Zennou  zennouBefore = getTkJitenZennouInfoDao.getZennou(ansyuKihon,
                zennouAfter.getZennoukaisiymd(),
                zennouAfter.getRenno() - 1);

            if (zennouBefore == null) {
                logger.debug("△ 特定時点前納情報取得 終了");
                return zennouOut;
            }

            if ((zennouBefore.getZennouseisandenymd() != null &&
                ((BizDateUtil.compareYmd(zennouBefore.getZennouseisandenymd(),
                    pZennouHanteiKijyunYmd) == BizDateUtil.COMPARE_EQUAL) ||
                    (BizDateUtil.compareYmd(zennouBefore.getZennouseisandenymd(),
                        pZennouHanteiKijyunYmd) == BizDateUtil.COMPARE_LESSER))) ||
                        (zennouBefore.getZennouseisandenymd() == null &&
                        ((BizDateUtil.compareYmd(zennouBefore.getZennouseisansyoriymd(),
                            pZennouHanteiKijyunYmd) == BizDateUtil.COMPARE_EQUAL) ||
                            (BizDateUtil.compareYmd(zennouBefore.getZennouseisansyoriymd(),
                                pZennouHanteiKijyunYmd) == BizDateUtil.COMPARE_LESSER)))) {
                zennouOut.setZennounyuukinkgk(zennouAfter.getZennounyuukinkgk());
                zennouOut.setZennoujihrkp(zennouAfter.getZennoujihrkp());

                logger.debug("△ 特定時点前納情報取得 終了");
                return zennouOut;
            }
            else if (zennouBefore.getRenno() == 1 ) {
                zennouOut.setZennounyuukinkgk(zennouBefore.getZennounyuukinkgk());
                zennouOut.setZennoujihrkp(zennouBefore.getZennoujihrkp());

                logger.debug("△ 特定時点前納情報取得 終了");
                return zennouOut;
            }
            else {
                zennouAfter = zennouBefore;
            }
        }

        logger.debug("△ 特定時点前納情報取得 終了");
        return zennouOut;
    }

}
