package yuyu.common.suuri.srcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_HoyuuCheckKekkaKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.hozen.result.bean.HoyuKykSyouhnsBySyonoSyutkkbnBean;
import yuyu.def.hozen.result.bean.HoyuuKhTtdkRirekiByPkBean;

/**
 * 数理統計 数理共通 保有契約判定
 */
public class SrHoyuuKeiyakuCheck {

    @Inject
    private static Logger logger;

    public SrHoyuuKeiyakuCheck() {
        super();
    }

    public C_HoyuuCheckKekkaKbn exec(BizDate pKijyunYmd, String pSyono, BizDateYM pSkeikeijyouYm,
        HoyuKykSyouhnsBySyonoSyutkkbnBean pHoyuKykSyouhnsBySyonoSyutkkbn, HoyuuKhTtdkRirekiByPkBean pHoyuuKhTtdkRirekiByPk,
        List<IT_KhBikinkanri> pKhBikinkanriLst, List<JT_SiBikinkanri> pSiBikinkanriLst) {

        logger.debug("▽ 保有契約判定 開始");

        BizDate kijyunYmd = pKijyunYmd;

        BizDate nendoksnbi = null;

        if (pKijyunYmd.getMonth() >= SrCommonConstants.MONTH_APRIL) {

            nendoksnbi = BizDate.valueOf(String.valueOf(pKijyunYmd.getYear()) + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }
        else {

            nendoksnbi = BizDate.valueOf(String.valueOf((pKijyunYmd.getYear() - 1)) +
                SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }

        C_HoyuuCheckKekkaKbn hoyuuCheckKekkaKbn = C_HoyuuCheckKekkaKbn.HOYUUTAISYOU;

        if (BizDateUtil.compareYm(pSkeikeijyouYm, kijyunYmd.getBizDateYM()) == BizDateUtil.COMPARE_GREATER) {

            hoyuuCheckKekkaKbn = C_HoyuuCheckKekkaKbn.HOYUUTAISYOUGAI;

            logger.debug("△ 保有契約判定 終了");

            return hoyuuCheckKekkaKbn;
        }

        if (C_SyutkKbn.SYU.eq(pHoyuKykSyouhnsBySyonoSyutkkbn.getSyutkkbn()) &&
            C_YuukousyoumetuKbn.SYOUMETU.eq(pHoyuKykSyouhnsBySyonoSyutkkbn.getYuukousyoumetukbn()) &&
            BizDateUtil.compareYmd(pHoyuKykSyouhnsBySyonoSyutkkbn.getSyoumetuymd(), kijyunYmd) != BizDateUtil.COMPARE_GREATER &&
            BizDateUtil.compareYmd(pHoyuuKhTtdkRirekiByPk.getSyoriymd(), kijyunYmd) != BizDateUtil.COMPARE_GREATER) {

            hoyuuCheckKekkaKbn = C_HoyuuCheckKekkaKbn.HOYUUTAISYOUGAI;

            logger.debug("△ 保有契約判定 終了");

            return hoyuuCheckKekkaKbn;
        }

        if (C_Syoumetujiyuu.KYKTORIKESI.eq(pHoyuKykSyouhnsBySyonoSyutkkbn.getSyoumetujiyuu()) ||
            C_Syoumetujiyuu.CLGOFF.eq(pHoyuKykSyouhnsBySyonoSyutkkbn.getSyoumetujiyuu()) ||
            C_Syoumetujiyuu.MUKOU.eq(pHoyuKykSyouhnsBySyonoSyutkkbn.getSyoumetujiyuu()) ){

            if (C_SyutkKbn.SYU.eq(pHoyuKykSyouhnsBySyonoSyutkkbn.getSyutkkbn()) &&
                C_YuukousyoumetuKbn.SYOUMETU.eq(pHoyuKykSyouhnsBySyonoSyutkkbn.getYuukousyoumetukbn()) &&
                BizDateUtil.compareYmd(pHoyuKykSyouhnsBySyonoSyutkkbn.getSyoumetuymd(), kijyunYmd) == BizDateUtil.COMPARE_GREATER &&
                BizDateUtil.compareYmd(pHoyuuKhTtdkRirekiByPk.getSyoriymd(), kijyunYmd) != BizDateUtil.COMPARE_GREATER) {

                hoyuuCheckKekkaKbn = C_HoyuuCheckKekkaKbn.HOYUUTAISYOUGAI;

                logger.debug("△ 保有契約判定 終了");

                return hoyuuCheckKekkaKbn;
            }
        }

        Boolean flg = SrDateUtil.isKessanTuki(kijyunYmd);

        BizDate htKijyunYmd = null;

        if (flg) {

            htKijyunYmd = kijyunYmd;
        }
        else {

            htKijyunYmd = nendoksnbi;
        }

        if (pKhBikinkanriLst != null && pKhBikinkanriLst.size() != 0) {

            for (IT_KhBikinkanri khBikinkanri : pKhBikinkanriLst) {

                if (BizDateUtil.compareYmd(htKijyunYmd, khBikinkanri.getKessankijyunymd()) == BizDateUtil.COMPARE_EQUAL
                    && !C_BknrigiKbn.DEL.eq(khBikinkanri.getBknrigikbn())
                    && C_BkncdKbn.KAIYAKU.eq(khBikinkanri.getBkncdkbn())) {

                    hoyuuCheckKekkaKbn = C_HoyuuCheckKekkaKbn.HOYUUTAISYOUGAI;

                    logger.debug("△ 保有契約判定 終了");

                    return hoyuuCheckKekkaKbn;
                }
            }
        }

        if (pSiBikinkanriLst != null && pSiBikinkanriLst.size() != 0) {

            for (JT_SiBikinkanri siBikinkanri : pSiBikinkanriLst) {

                if (BizDateUtil.compareYmd(htKijyunYmd, siBikinkanri.getKessankijyunymd()) == BizDateUtil.COMPARE_EQUAL
                    && !C_BknrigiKbn.DEL.eq(siBikinkanri.getBknrigikbn()) &&
                    (C_BkncdKbn.SIBOUUKETUKE.eq(siBikinkanri.getBkncdkbn()) ||
                        C_BkncdKbn.SIBOUKARIUKETUKE.eq(siBikinkanri.getBkncdkbn()) ||
                        C_BkncdKbn.SIBOUKAIJYO.eq(siBikinkanri.getBkncdkbn()) ||
                        C_BkncdKbn.MENSEKI.eq(siBikinkanri.getBkncdkbn()))) {

                    hoyuuCheckKekkaKbn = C_HoyuuCheckKekkaKbn.HOYUUTAISYOUGAI;

                    logger.debug("△ 保有契約判定 終了");

                    return hoyuuCheckKekkaKbn;
                }
            }
        }

        logger.debug("△ 保有契約判定 終了");

        return hoyuuCheckKekkaKbn;
    }
}
