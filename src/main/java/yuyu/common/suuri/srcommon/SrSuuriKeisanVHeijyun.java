package yuyu.common.suuri.srcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanVHeijyun;
import yuyu.common.hozen.khcommon.KeisanVHeijyunBean;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.SV_KiykSyuhnData;

/**
 * 数理 数理共通 数理平準払用保険料積立金計算
 */

public class SrSuuriKeisanVHeijyun {

    private List<SrTmttknBean> srTmttknBeanList;

    @Inject
    private static Logger logger;

    public C_ErrorKbn exec(String pSyono, TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        List<SV_KiykSyuhnData> pKiykSyuhnDataLst, List<IT_HokenryouTmttkn> pHokenryouTmttknLst,
        BizDateYM pKijyunymdfrom, BizDateYM pKijyunymdto, C_Hrkkaisuu pHrkkaisuu, BizDate pFstpryosyu,
        Boolean pNkgnsCalcymFlg,BizDate pKwsratekjymd,Boolean pNkgnsZenKeisanFlg,Boolean pIdouSeiHenkouHsFlg) {

        logger.debug("▽ 数理平準払用保険料積立金計算 開始");

        srTmttknBeanList = new ArrayList<>();

        SrTmttknBean srTmttknBean = null;

        BizDateYM tmttknTaisyouYm = null;

        BizCurrency calckaisiYmjitenv = BizCurrency.valueOf(0);

        BizCurrency calckaisiYmjitensump = BizCurrency.valueOf(0);

        C_UmuKbn kijunnikouGengkumu = C_UmuKbn.NONE;

        C_UmuKbn kijunnikouSeihenkouumu = C_UmuKbn.NONE;

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = pTkJitenKeiyakuSyouhinKijyunBean;

        int calckikanTukikansan = BizDateUtil.calcDifferenceMonths(pKijyunymdto, pKijyunymdfrom)
            + SrCommonConstants.KIKAN_1M;

        if (pHokenryouTmttknLst.size() != 0) {

            for (int i = 0; i < pHokenryouTmttknLst.size(); i++) {

                if (BizDateUtil.compareYm(pKijyunymdfrom, pHokenryouTmttknLst.get(i).getTmttkntaisyouym())
                    == BizDateUtil.COMPARE_LESSER) {

                    if (IKhozenCommonConstants.KINOUID_GENGAKU
                        .equals(pHokenryouTmttknLst.get(i).getGyoumuKousinKinou())) {

                        kijunnikouGengkumu = C_UmuKbn.ARI;
                    }
                    else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI
                        .equals(pHokenryouTmttknLst.get(i).getGyoumuKousinKinou())) {

                        kijunnikouSeihenkouumu = C_UmuKbn.ARI;
                    }
                    else {
                        continue;
                    }
                }
                else {

                    if (C_UmuKbn.NONE.eq(kijunnikouGengkumu)) {

                        tmttknTaisyouYm = pHokenryouTmttknLst.get(i).getTmttkntaisyouym();
                        calckaisiYmjitenv = pHokenryouTmttknLst.get(i).getPtmttkngk();
                        calckaisiYmjitensump = pHokenryouTmttknLst.get(i).getKihrkmpstgk();
                    }

                    break;
                }
            }
        }

        for (int i = 0; i < calckikanTukikansan; i++) {

            BizDateYM calckpKijyunymd = pKijyunymdfrom.addMonths(i).addMonths(SrCommonConstants.KIKAN_1M);

            TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanAto = null;

            KeisanVHeijyun keisanVHeijyun = SWAKInjector.getInstance(KeisanVHeijyun.class);
            KeisanVHeijyunBean keisanVHeijyunBean = SWAKInjector.getInstance(KeisanVHeijyunBean.class);

            C_Hhknsei hhknsei = pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei();

            if (!pIdouSeiHenkouHsFlg && C_UmuKbn.ARI.eq(kijunnikouSeihenkouumu)) {

                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                    SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

                tkJitenKeiyakuSyouhinKijyunBeanAto = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO, pSyono, calckpKijyunymd.addMonths(-2).getLastDay(),
                    "", pKiykSyuhnDataLst).getTkJitenKeiyakuSyouhinKijyunBeanAto();
                hhknsei = tkJitenKeiyakuSyouhinKijyunBeanAto.getHhknsei();

                if (hhknsei == null) {
                    hhknsei = pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei();
                }
            }

            keisanVHeijyunBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            keisanVHeijyunBean.setRyouritusdno(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
            keisanVHeijyunBean.setCalckijyunYm(calckpKijyunymd);
            keisanVHeijyunBean.setKykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            keisanVHeijyunBean.setHokenryou(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou());
            keisanVHeijyunBean.setKyktuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());
            keisanVHeijyunBean.setHhknsei(hhknsei);
            keisanVHeijyunBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());
            keisanVHeijyunBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
            keisanVHeijyunBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
            keisanVHeijyunBean.setHrkkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn());
            keisanVHeijyunBean.setHrkkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkknsmnKbn());
            keisanVHeijyunBean.setHrkkaisuu(pHrkkaisuu);
            keisanVHeijyunBean.setFstpryosyu(pFstpryosyu);
            keisanVHeijyunBean.setSitihsyuriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt());
            keisanVHeijyunBean.setTmttkntaisyouym(tmttknTaisyouYm);
            keisanVHeijyunBean.setCalckaisiYmjitenv(calckaisiYmjitenv);
            keisanVHeijyunBean.setCalckaisiYmjitensump(calckaisiYmjitensump);
            keisanVHeijyunBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.JISSEKI);
            keisanVHeijyunBean.setSisansyoriYmd(null);
            keisanVHeijyunBean.setSisanyoteiriritu(null);
            keisanVHeijyunBean.setSisankawaserate(null);

            C_ErrorKbn keisanVHeijyunErrorKbn = keisanVHeijyun.exec(keisanVHeijyunBean);

            if (C_ErrorKbn.ERROR.eq(keisanVHeijyunErrorKbn)) {

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 数理平準払用保険料積立金計算 終了");

                return errorKbn;
            }

            srTmttknBean = SWAKInjector.getInstance(SrTmttknBean.class);
            srTmttknBean.setTumitateYM(keisanVHeijyun.getTumitateYM().addMonths(-SrCommonConstants.KIKAN_1M));
            srTmttknBean.setTmttKngk(keisanVHeijyun.getV());
            srTmttknBean.setvTyouseimae(keisanVHeijyun.getVTyouseimae());
            srTmttknBean.setKiharaikomiP(keisanVHeijyun.getKiharaikomiP());
            srTmttknBean.setYoteiSinkeiyakuhiritu(keisanVHeijyun.getYoteiSinkeiyakuhiritu());
            srTmttknBean.setYoteiIjihirituPhirei(keisanVHeijyun.getYoteiIjihirituPhirei());
            srTmttknBean.setYoteiIjihirituVhirei(keisanVHeijyun.getYoteiIjihirituVhirei());
            srTmttknBean.setYoteiSyuukinhiritu(keisanVHeijyun.getYoteiSyuukinhiritu());
            srTmttknBean.setKogakuWaribikiritu(keisanVHeijyun.getKogakuWaribikiritu());
            srTmttknBean.setZettaiSibouritu(keisanVHeijyun.getZettaiSibouritu());
            srTmttknBean.setSoutaiSibouritu(keisanVHeijyun.getSoutaiSibouritu());
            srTmttknBean.setSoutaiKaiyakuritu(keisanVHeijyun.getSoutaiKaiyakuritu());
            srTmttknBean.setYoteiriritu(keisanVHeijyun.getYoteiriritu());
            srTmttknBean.setKawaserate(keisanVHeijyun.getKawaserate());
            srTmttknBean.setHokenryou(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou());

            tmttknTaisyouYm = keisanVHeijyun.getTumitateYM();
            calckaisiYmjitenv = keisanVHeijyun.getV();
            calckaisiYmjitensump = keisanVHeijyun.getKiharaikomiP();

            srTmttknBeanList.add(srTmttknBean);

            if (BizDateUtil.compareYm(srTmttknBean.getTumitateYM(), pKijyunymdto)
                == BizDateUtil.COMPARE_GREATER
                || BizDateUtil.compareYm(srTmttknBean.getTumitateYM(), pKijyunymdto)
                == BizDateUtil.COMPARE_EQUAL) {

                break;
            }
        }

        if (pNkgnsCalcymFlg) {

            BizDate sisansyoriYmd = null;

            if (pNkgnsZenKeisanFlg) {
                sisansyoriYmd = tkJitenKeiyakuSyouhinKijyunBean.getKykymd();
                tmttknTaisyouYm = null;
                calckaisiYmjitenv = BizCurrency.valueOf(0);
                calckaisiYmjitensump = BizCurrency.valueOf(0);
            }
            else {
                sisansyoriYmd = BizDate.valueOf(tmttknTaisyouYm,SrCommonConstants.DAY_1D);
            }

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

            C_ErrorKbn kawaseRateErrorKbn = getKawaseRate.exec(pKwsratekjymd, C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                tkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(), C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.NYUKINRATE, C_EigyoubiHoseiKbn.BLNK, C_YouhiKbn.YOU);

            if (C_ErrorKbn.ERROR.eq(kawaseRateErrorKbn)) {

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 数理平準払用保険料積立金計算 終了");

                return errorKbn;
            }

            BizNumber kawaserate = getKawaseRate.getKawaserate();

            KeisanVHeijyun keisanVHeijyun = SWAKInjector.getInstance(KeisanVHeijyun.class);
            KeisanVHeijyunBean keisanVHeijyunBean = SWAKInjector.getInstance(KeisanVHeijyunBean.class);

            keisanVHeijyunBean.setSyouhncd(tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            keisanVHeijyunBean.setRyouritusdno(tkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
            keisanVHeijyunBean.setCalckijyunYm(tkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getBizDateYM());
            keisanVHeijyunBean.setKykymd(tkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            keisanVHeijyunBean.setHokenryou(tkJitenKeiyakuSyouhinKijyunBean.getHokenryou());
            keisanVHeijyunBean.setKyktuukasyu(tkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());
            keisanVHeijyunBean.setHhknsei(tkJitenKeiyakuSyouhinKijyunBean.getHhknsei());
            keisanVHeijyunBean.setHhknnen(tkJitenKeiyakuSyouhinKijyunBean.getHhknnen());
            keisanVHeijyunBean.setHknkkn(tkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
            keisanVHeijyunBean.setHknkknsmnkbn(tkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
            keisanVHeijyunBean.setHrkkkn(tkJitenKeiyakuSyouhinKijyunBean.getHrkkkn());
            keisanVHeijyunBean.setHrkkknsmnkbn(tkJitenKeiyakuSyouhinKijyunBean.getHrkkknsmnKbn());
            keisanVHeijyunBean.setHrkkaisuu(pHrkkaisuu);
            keisanVHeijyunBean.setFstpryosyu(pFstpryosyu);
            keisanVHeijyunBean.setSitihsyuriritu(tkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt());
            keisanVHeijyunBean.setTmttkntaisyouym(tmttknTaisyouYm);
            keisanVHeijyunBean.setCalckaisiYmjitenv(calckaisiYmjitenv);
            keisanVHeijyunBean.setCalckaisiYmjitensump(calckaisiYmjitensump);
            keisanVHeijyunBean.setSisansyuruikbn(C_KhSisanSyuruiKbn.SISAN);
            keisanVHeijyunBean.setSisansyoriYmd(sisansyoriYmd);
            keisanVHeijyunBean.setSisanyoteiriritu(tkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt());
            keisanVHeijyunBean.setSisankawaserate(kawaserate);

            C_ErrorKbn keisanVHeijyunErrorKbn = keisanVHeijyun.exec(keisanVHeijyunBean);

            if (C_ErrorKbn.ERROR.eq(keisanVHeijyunErrorKbn)) {

                errorKbn = C_ErrorKbn.ERROR;

                logger.debug("△ 数理平準払用保険料積立金計算 終了");

                return errorKbn;
            }

            srTmttknBean = SWAKInjector.getInstance(SrTmttknBean.class);
            srTmttknBean.setTumitateYM(keisanVHeijyun.getTumitateYM());
            srTmttknBean.setTmttKngk(keisanVHeijyun.getV());
            srTmttknBean.setvTyouseimae(keisanVHeijyun.getVTyouseimae());
            srTmttknBean.setKiharaikomiP(keisanVHeijyun.getKiharaikomiP());
            srTmttknBean.setYoteiSinkeiyakuhiritu(keisanVHeijyun.getYoteiSinkeiyakuhiritu());
            srTmttknBean.setYoteiIjihirituPhirei(keisanVHeijyun.getYoteiIjihirituPhirei());
            srTmttknBean.setYoteiIjihirituVhirei(keisanVHeijyun.getYoteiIjihirituVhirei());
            srTmttknBean.setYoteiSyuukinhiritu(keisanVHeijyun.getYoteiSyuukinhiritu());
            srTmttknBean.setKogakuWaribikiritu(keisanVHeijyun.getKogakuWaribikiritu());
            srTmttknBean.setZettaiSibouritu(keisanVHeijyun.getZettaiSibouritu());
            srTmttknBean.setSoutaiSibouritu(keisanVHeijyun.getSoutaiSibouritu());
            srTmttknBean.setSoutaiKaiyakuritu(keisanVHeijyun.getSoutaiKaiyakuritu());
            srTmttknBean.setYoteiriritu(keisanVHeijyun.getYoteiriritu());
            srTmttknBean.setKawaserate(keisanVHeijyun.getKawaserate());
            srTmttknBean.setHokenryou(tkJitenKeiyakuSyouhinKijyunBean.getHokenryou());

            srTmttknBeanList.add(srTmttknBean);
        }

        logger.debug("△ 数理平準払用保険料積立金計算 終了");

        return errorKbn;

    }

    public List<SrTmttknBean> getSrTmttknBeanList() {

        return srTmttknBeanList;

    }
}
