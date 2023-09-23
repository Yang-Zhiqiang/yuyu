package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.classification.C_ZennouKessanHoyuuHanteiKekkaKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.JT_SiBikinkanri;

/**
 * 契約保全 契約保全共通 前納決算保有契約判定
 */
public class HanteiZennouKessanHoyuuKyk {

    @Inject
    private static Logger logger;

    private BizDate calckijyunymd;

    public HanteiZennouKessanHoyuuKyk() {
        super();
    }

    public BizDate getCalckijyunymd() {
        return calckijyunymd;
    }

    public C_ZennouKessanHoyuuHanteiKekkaKbn exec(BizDate pKijyunYmd, String pSyono, BizDateYM pSkeikeijyouYm,
        IT_KykSyouhn pKykSyouhn, IT_KhTtdkRireki pKhTtdkRireki, List<IT_KhBikinkanri> pKhBikinkanriLst,
        List<JT_SiBikinkanri> pSiBikinkanriLst) {

        logger.debug("▽ 前納決算保有契約判定 開始");

        BizDate kijyunYmd = pKijyunYmd;

        C_ZennouKessanHoyuuHanteiKekkaKbn hoyuuCheckKekkaKbn = C_ZennouKessanHoyuuHanteiKekkaKbn.HOYUUTAISYOU;
        calckijyunymd = pKijyunYmd;

        if (BizDateUtil.compareYm(pSkeikeijyouYm, kijyunYmd.getBizDateYM()) == BizDateUtil.COMPARE_GREATER) {

            hoyuuCheckKekkaKbn = C_ZennouKessanHoyuuHanteiKekkaKbn.HOYUUTAISYOUGAI;

            logger.debug("△ 前納決算保有契約判定 終了");

            return hoyuuCheckKekkaKbn;
        }

        BizDate htKijyunYmd = kijyunYmd;

        for (IT_KhBikinkanri khBikinkanri : pKhBikinkanriLst) {

            if (BizDateUtil.compareYmd(khBikinkanri.getKessankijyunymd(), htKijyunYmd) == BizDateUtil.COMPARE_EQUAL &&
                !C_BknrigiKbn.DEL.eq(khBikinkanri.getBknrigikbn())  &&
                C_BkncdKbn.KAIYAKU.eq(khBikinkanri.getBkncdkbn())) {

                hoyuuCheckKekkaKbn = C_ZennouKessanHoyuuHanteiKekkaKbn.BIKINTAISYOU;
                calckijyunymd = khBikinkanri.getBknkktymd();

                logger.debug("△ 前納決算保有契約判定 終了");

                return hoyuuCheckKekkaKbn;
            }
        }

        for (JT_SiBikinkanri siBikinkanri : pSiBikinkanriLst) {

            if (BizDateUtil.compareYmd(siBikinkanri.getKessankijyunymd(), htKijyunYmd) == BizDateUtil.COMPARE_EQUAL  &&
                !C_BknrigiKbn.DEL.eq(siBikinkanri.getBknrigikbn()) &&
                (C_BkncdKbn.SIBOUUKETUKE.eq(siBikinkanri.getBkncdkbn()) ||
                    C_BkncdKbn.SIBOUKARIUKETUKE.eq(siBikinkanri.getBkncdkbn()) ||
                    C_BkncdKbn.SIBOUKAIJYO.eq(siBikinkanri.getBkncdkbn()) ||
                    C_BkncdKbn.MENSEKI.eq(siBikinkanri.getBkncdkbn()))) {

                hoyuuCheckKekkaKbn = C_ZennouKessanHoyuuHanteiKekkaKbn.BIKINTAISYOU;
                calckijyunymd = siBikinkanri.getBknkktymd();

                logger.debug("△ 前納決算保有契約判定 終了");

                return hoyuuCheckKekkaKbn;
            }
        }

        if (C_YuukousyoumetuKbn.SYOUMETU.eq(pKykSyouhn.getYuukousyoumetukbn()) &&
            BizDateUtil.compareYmd(pKykSyouhn.getSyoumetuymd(), kijyunYmd) != BizDateUtil.COMPARE_GREATER &&
            BizDateUtil.compareYmd(pKhTtdkRireki.getSyoriYmd(), kijyunYmd) != BizDateUtil.COMPARE_GREATER) {

            hoyuuCheckKekkaKbn = C_ZennouKessanHoyuuHanteiKekkaKbn.SYOUMETUTAISYOU;

            logger.debug("△ 前納決算保有契約判定 終了");

            return hoyuuCheckKekkaKbn;
        }

        if (C_Syoumetujiyuu.KYKTORIKESI.eq(pKykSyouhn.getSyoumetujiyuu()) ||
            C_Syoumetujiyuu.CLGOFF.eq(pKykSyouhn.getSyoumetujiyuu()) ||
            C_Syoumetujiyuu.MUKOU.eq(pKykSyouhn.getSyoumetujiyuu()) ) {

            if (C_YuukousyoumetuKbn.SYOUMETU.eq(pKykSyouhn.getYuukousyoumetukbn()) &&
                BizDateUtil.compareYmd(pKykSyouhn.getSyoumetuymd(), kijyunYmd) == BizDateUtil.COMPARE_GREATER &&
                BizDateUtil.compareYmd(pKhTtdkRireki.getSyoriYmd(), kijyunYmd) != BizDateUtil.COMPARE_GREATER) {

                hoyuuCheckKekkaKbn = C_ZennouKessanHoyuuHanteiKekkaKbn.SYOUMETUTAISYOU;

                logger.debug("△ 前納決算保有契約判定 終了");

                return hoyuuCheckKekkaKbn;
            }
        }

        logger.debug("△ 前納決算保有契約判定 終了");

        return hoyuuCheckKekkaKbn;
    }
}
