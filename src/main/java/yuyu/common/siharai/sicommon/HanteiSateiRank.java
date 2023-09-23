package yuyu.common.siharai.sicommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiYokenBean;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SKNaiyouChkkekkaKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 保険金給付金支払 保険金給付金支払共通 査定ランク判定
 */
public class HanteiSateiRank {

    @Inject
    private static Logger logger;

    @Inject
    private KinouMode kinouMode;

    public HanteiSateiRank() {
        super();

    }

    public HanteiSateiRankKekkaBean exec(HanteiSateiRankBean pHanteiSateiRankBean) {

        logger.debug("▽ 査定ランク判定 開始");

        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = SWAKInjector.getInstance(HanteiSateiRankKekkaBean.class);
        hanteiSateiRankKekkaBean.setSateiRankuHanteiKekka(true);
        hanteiSateiRankKekkaBean.setSateiYouhiKbn(C_SateiYouhiKbn.BLNK);
        hanteiSateiRankKekkaBean.setSateiSanjikaisouUmuKbn(C_UmuKbn.NONE);

        if (BizUtil.isBlank(pHanteiSateiRankBean.getSyono())) {
            hanteiSateiRankKekkaBean.setSateiRankuHanteiKekka(false);
        }
        if (pHanteiSateiRankBean.getSeikyuuSyubetu() == null) {
            hanteiSateiRankKekkaBean.setSateiRankuHanteiKekka(false);
        }
        if (pHanteiSateiRankBean.getSateiYouhiKbn() == null) {
            hanteiSateiRankKekkaBean.setSateiRankuHanteiKekka(false);
        }
        if (pHanteiSateiRankBean.getSKNaiyouChkkekkaKbn() == null) {
            hanteiSateiRankKekkaBean.setSateiRankuHanteiKekka(false);
        }
        if (pHanteiSateiRankBean.getSaisateikbn() == null) {
            hanteiSateiRankKekkaBean.setSateiRankuHanteiKekka(false);
        }

        if (!hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka()) {
            logger.debug("△ 査定ランク判定 終了");

            return hanteiSateiRankKekkaBean;
        }

        BizDate sysDate = BizDate.getSysDate();

        C_SateiYouhiKbn sateiYouhiKbn = C_SateiYouhiKbn.YOU;
        BizCurrency tuuSanS = BizCurrency.valueOf(0);

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue()) ||
            (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue()))) {

            BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector
                .getInstance(BzSakuinTsnSyoukaiYokenBean.class);

            bzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI);
            bzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.HUYOU);
            bzSakuinTsnSyoukaiYokenBean.setSkintaisyoukykkbn(C_SakuintaisyoukykKbn.BLNK);
            bzSakuinTsnSyoukaiYokenBean.setSkintsghuho2kyknokbn(C_Huho2kyknoKbn.BLNK);
            bzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.HUYOU);
            bzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.YOU);
            bzSakuinTsnSyoukaiYokenBean.setTsntsghuho2kyknokbn(C_Huho2kyknoKbn.BLNK);
            bzSakuinTsnSyoukaiYokenBean.setTsnkijyunymd(sysDate);
            bzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.HUYOU);
            bzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.HUYOU);
            bzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.HUYOU);
            bzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
            bzSakuinTsnSyoukaiYokenBean.setHuho2kykno(pHanteiSateiRankBean.getSyono());
            bzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.HHKN);


            BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
            BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = bzSakuinTsnSyoukaiMq
                .exec(bzSakuinTsnSyoukaiYokenBean);

            if (C_MQSyorikekkaKbn.SEIJYOU.eq(bzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn())
                && C_PalSyoukaiJissiumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn())
                && C_MQSyoukaiErrorKbn.SYOUKAIOK.eq(bzSakuinTsnSyoukaiKekkaBean.getTsngksyoukaierrkbn())) {
                tuuSanS = bzSakuinTsnSyoukaiKekkaBean.getTsnsibous();
            }
            else {
                hanteiSateiRankKekkaBean.setSateiRankuHanteiKekka(false);
                hanteiSateiRankKekkaBean.setSateiYouhiKbn(sateiYouhiKbn);
                hanteiSateiRankKekkaBean.setSateiSanjikaisouUmuKbn(C_UmuKbn.ARI);

                logger.debug("△ 査定ランク判定 終了");
                return hanteiSateiRankKekkaBean;
            }
        }
        C_UmuKbn sateiSanjikaiUmKabunn = C_UmuKbn.NONE;
        if (tuuSanS.compareTo(YuyuSiharaiConfig.getInstance().getSatei3YouhiGk()) > 0) {
            sateiSanjikaiUmKabunn = C_UmuKbn.ARI;
            sateiYouhiKbn = pHanteiSateiRankBean.getSateiYouhiKbn();
        }
        else {
            if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue()) &&
                (pHanteiSateiRankBean.getSaisateikbn().eq(C_SaisateiKbn.SAISATEI))) {
                sateiSanjikaiUmKabunn = C_UmuKbn.ARI;
            }

            if (C_SeikyuuSyubetu.KOUSG.eq(pHanteiSateiRankBean.getSeikyuuSyubetu())) {
                sateiYouhiKbn = C_SateiYouhiKbn.YOU;
            }
            else {
                if (!C_SateiYouhiKbn.YOU.eq(pHanteiSateiRankBean.getSateiYouhiKbn()) &&
                    !C_SKNaiyouChkkekkaKbn.ERROR.eq(pHanteiSateiRankBean.getSKNaiyouChkkekkaKbn()) &&
                    !C_SKNaiyouChkkekkaKbn.TOKUNIN.eq(pHanteiSateiRankBean.getSKNaiyouChkkekkaKbn())) {
                    sateiYouhiKbn = C_SateiYouhiKbn.HUYOU;
                }
            }
        }

        hanteiSateiRankKekkaBean.setSateiRankuHanteiKekka(true);
        hanteiSateiRankKekkaBean.setSateiYouhiKbn(sateiYouhiKbn);
        hanteiSateiRankKekkaBean.setSateiSanjikaisouUmuKbn(sateiSanjikaiUmKabunn);

        logger.debug("△ 査定ランク判定 終了");

        return hanteiSateiRankKekkaBean;

    }

}
