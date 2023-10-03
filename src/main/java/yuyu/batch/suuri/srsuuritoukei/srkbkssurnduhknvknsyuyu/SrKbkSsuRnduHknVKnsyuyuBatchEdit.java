package yuyu.batch.suuri.srsuuritoukei.srkbkssurnduhknvknsyuyu;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknYendtHnk;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenSisuurendoTmttknInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTmttknInfoBean;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_SrKbkSsuRnduHknVKnsyuyuTy;

/**
 * 数理 数理統計 株価指数連動保険Ｖ検証用情報作成項目編集クラス
 */
public class SrKbkSsuRnduHknVKnsyuyuBatchEdit {

    private static final int KINOUID_TMTTKNHANEI = 0;

    private static final int KINOUID_TMTTKNITEN = 1;

    private static final int KINOUID_YENDTHNK = 2;

    public void editKoumoku(SrKbkSsuRnduHknVKnsyuyuBatchParam pBatchParam,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_SrKbkSsuRnduHknVKnsyuyuTy pSrKbkSsuRnduHknVKnsyuyuTy,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst) {

        editHeaderData(pBatchParam, pSrKbkSsuRnduHknVKnsyuyuTy);

        editHoyuuMeisaiKoumoku(pHoyuuMeisaiTyukeiyouItzHzn, pTkJitenKeiyakuSyouhinKijyunBean, pSrKbkSsuRnduHknVKnsyuyuTy);

        editKbkSsuRnduHknVKoumoku(pBatchParam,
            pHoyuuMeisaiTyukeiyouItzHzn, pTkJitenKeiyakuSyouhinKijyunBean, pSrKbkSsuRnduHknVKnsyuyuTy,
            pSvKiykSyuhnDataLst);
    }


    private void editHeaderData(SrKbkSsuRnduHknVKnsyuyuBatchParam pBatchParam,
        ZT_SrKbkSsuRnduHknVKnsyuyuTy pSrKbkSsuRnduHknVKnsyuyuTy) {

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysequenceno(pBatchParam.getSyoriKensuu());
        pBatchParam.setSyoriKensuu(pBatchParam.getSyoriKensuu() + 1);
    }

    private void editHoyuuMeisaiKoumoku(ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_SrKbkSsuRnduHknVKnsyuyuTy pSrKbkSsuRnduHknVKnsyuyuTy) {

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtykeijyouym(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouym());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyraysystemhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyraysystemhyj());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtydatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyhknsyukigou(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknsyukigou());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyhknsyuruikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknsyuruikigousedaikbn());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysotodasipmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasipmenkbn());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysotodasimanagehyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasimanagehyouji());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtykbnkeiriyousegmentkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykbnkeiriyousegmentkbn());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtykbnkeiriyourgnbnskkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykbnkeiriyourgnbnskkbn());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysuurisyuruicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuurisyuruicd());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtykykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyhknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknkkn());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyphrkkikn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyphrkkikn());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysaimnkkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaimnkkykhyj());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyannaifuyouriyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyannaifuyouriyuukbn());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyhhknseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknseikbn());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyhihokensyaagev2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhihokensyaagev2());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtykuriagekurisagekbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykuriagekurisagekbn());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtykeiyakujiyoteiriritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeiyakujiyoteiriritu());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysrkaiyakusjkkktyouseirrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrkaiyakusjkkktyouseirrt());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysrkyksjkkktyouseiriritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrkyksjkkktyouseiriritu());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtymvatyouseikou(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseikou());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuurendourate(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurendourate());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuukbn());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtygaikakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikakbn());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtykimatukawaserate(BizNumber.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate1()));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtykaiyakukoujyoritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrkaiyakukoujyoritu());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytumitateriritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytumitateriritu());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysknnkaisiymd(convertFromBizDate(pTkJitenKeiyakuSyouhinKijyunBean.getSknnkaisiymd()));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyrendouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrendouritu());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyukeiyakup());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtymvatyouseigow(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseigow());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtymvakeisanjisknnjynbkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvakeisanjisknnjynbkn());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtykmtsisuurentumitatekn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentumitatekin());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtykmttirttmtttumitatekn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykimatutirttumitatekin());
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtykmtsisuurentyokugotmttkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());
    }

    private void editKbkSsuRnduHknVKoumoku(SrKbkSsuRnduHknVKnsyuyuBatchParam pBatchParam,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_SrKbkSsuRnduHknVKnsyuyuTy pSrKbkSsuRnduHknVKnsyuyuTy,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst) {

        BizDate tumitateknKijyunymd;

        int syoriTaisyouKbn = KINOUID_TMTTKNHANEI;

        SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

        KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk =
            SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

        SrKbkSsuRnduHknVKnsyuyuBatchDbAccess batchDbAccess =
            SWAKInjector.getInstance(SrKbkSsuRnduHknVKnsyuyuBatchDbAccess.class);

        List<SrGetTokutejitenTmttknInfoBean> khSisuurendoTmttknLst =
            new ArrayList<SrGetTokutejitenTmttknInfoBean>();

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            tumitateknKijyunymd = pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd();

            syoriTaisyouKbn = KINOUID_YENDTHNK;
        }
        else {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() != null) {

                tumitateknKijyunymd = pBatchParam.getKijyunymd();

                syoriTaisyouKbn = KINOUID_TMTTKNITEN;
            }
            else {

                if (BizDateUtil.compareYmd(pBatchParam.getKijyunymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

                    tumitateknKijyunymd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();

                    syoriTaisyouKbn = KINOUID_TMTTKNHANEI;
                }
                else {

                    tumitateknKijyunymd = pBatchParam.getKijyunymd();

                    syoriTaisyouKbn = KINOUID_TMTTKNHANEI;
                }
            }

            SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
                SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

            khSisuurendoTmttknLst =
                srGetTokutejitenSisuurendoTmttknInfo.exec(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                    tumitateknKijyunymd, null, pSvKiykSyuhnDataLst);
        }

        List<BizDate> sisuubbncalckijyunymdLst = new ArrayList<>();
        List<BizCurrency> sisuubbntumitatekinLst = new ArrayList<>();
        List<BizNumber> toukisisuuLst = new ArrayList<>();
        List<BizDate> toukisisuukijyunymdLst = new ArrayList<>();
        List<BizNumber> zenkisisuuLst = new ArrayList<>();
        List<BizDate> zenkisisuukijyunymdLst = new ArrayList<>();
        List<BizNumber> tmttknzoukarituLst = new ArrayList<>();
        List<BizCurrency> toukitumimasikinLst = new ArrayList<>();
        List<BizDate> teiritucalckijyunymdLst = new ArrayList<>();
        List<BizCurrency> teiritutumitatekinLst = new ArrayList<>();

        for (int index = 0; index < 15; index++) {
            sisuubbncalckijyunymdLst.add(null);
            sisuubbntumitatekinLst.add(null);
            toukisisuuLst.add(null);
            toukisisuukijyunymdLst.add(null);
            zenkisisuuLst.add(null);
            zenkisisuukijyunymdLst.add(null);
            tmttknzoukarituLst.add(null);
            toukitumimasikinLst.add(null);
            teiritucalckijyunymdLst.add(null);
            teiritutumitatekinLst.add(null);
        }

        int nensuuCount = 0;
        BizCurrency maeSisuurendoutmttkngk = null;
        BizDate gengakuCalckijyunymd = null;
        BizCurrency gengakuSisuubbntumitatekin = null;
        BizCurrency gengakuTeiritutumitatekin = null;
        BizDate tmttkNitenYmd = pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd();
        int keikaNensuu = 0;
        BizDate yendtHnkYmd = null;
        SV_KiykSyuhnData gengakuSyuhnData = null;
        boolean yendthnkGengkinfoSetFlg = false;

        if (KINOUID_TMTTKNHANEI == syoriTaisyouKbn) {

            for (int i = khSisuurendoTmttknLst.size() - 1; i >= 0; i--) {
                SrGetTokutejitenTmttknInfoBean khSisuurendoTmttkn = khSisuurendoTmttknLst.get(i);

                if (khSisuurendoTmttkn.getTmttknkouryokukaisiymd() == null) {

                    continue;
                }

                if ((khSisuurendoTmttkn.getRenno() == SrCommonConstants.RENBAN_1) &&
                    ((BizDateUtil.compareYmd(pBatchParam.getKijyunymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) ||
                        (BizDateUtil.compareYmd(khSisuurendoTmttkn.getTmttknkouryokukaisiymd(),
                            pBatchParam.getKijyunymd()) <= BizDateUtil.COMPARE_EQUAL))) {

                    if (nensuuCount > 0 &&
                        BizDateUtil.compareYmd(teiritucalckijyunymdLst.get(nensuuCount - 1),
                            khSisuurendoTmttkn.getTmttknkouryokukaisiymd()) == BizDateUtil.COMPARE_EQUAL) {
                        nensuuCount = nensuuCount - 1;
                    }
                    sisuubbncalckijyunymdLst.set(nensuuCount, khSisuurendoTmttkn.getTmttknkouryokukaisiymd());
                    sisuubbntumitatekinLst.set(nensuuCount, khSisuurendoTmttkn.getSisuurendoutmttkngk());
                    toukisisuuLst.set(nensuuCount, khSisuurendoTmttkn.getTmttknhaneisisuu());
                    toukisisuukijyunymdLst.set(nensuuCount, khSisuurendoTmttkn.getTmttknhaneitmmshanteiymd());
                    teiritucalckijyunymdLst.set(nensuuCount, khSisuurendoTmttkn.getTmttknkouryokukaisiymd());
                    teiritutumitatekinLst.set(nensuuCount, khSisuurendoTmttkn.getTeiritutmttkngk());

                    if (BizDateUtil.compareYmd(pBatchParam.getKijyunymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {
                        break;
                    }

                    if (BizDateUtil.compareYm(khSisuurendoTmttkn.getTmttkntaisyouym(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM()) != BizDateUtil.COMPARE_EQUAL) {
                        zenkisisuuLst.set(nensuuCount, toukisisuuLst.get(nensuuCount - 1));
                        zenkisisuukijyunymdLst.set(nensuuCount, toukisisuukijyunymdLst.get(nensuuCount - 1));
                        tmttknzoukarituLst.set(nensuuCount, khSisuurendoTmttkn.getTmttknzoukaritu());
                        toukitumimasikinLst.set(nensuuCount, khSisuurendoTmttkn.getSisuurendoutmttkngk().subtract(maeSisuurendoutmttkngk));
                    }

                    nensuuCount++;
                }

                if (BizDateUtil.compareYmd(khSisuurendoTmttkn.getTmttknkouryokukaisiymd(),
                    pBatchParam.getKijyunymd()) <= BizDateUtil.COMPARE_EQUAL) {
                    maeSisuurendoutmttkngk = khSisuurendoTmttkn.getSisuurendoutmttkngk();

                    if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(khSisuurendoTmttkn.getGyoumuKousinKinou())) {
                        gengakuCalckijyunymd = khSisuurendoTmttkn.getTmttknkouryokukaisiymd();
                        gengakuSisuubbntumitatekin = khSisuurendoTmttkn.getSisuurendoutmttkngk();
                        gengakuTeiritutumitatekin = khSisuurendoTmttkn.getTeiritutmttkngk();
                    }
                }
            }
        }

        if (KINOUID_TMTTKNITEN == syoriTaisyouKbn) {

            for (int i = khSisuurendoTmttknLst.size() - 1; i >= 0; i--) {
                SrGetTokutejitenTmttknInfoBean khSisuurendoTmttkn = khSisuurendoTmttknLst.get(i);

                if (khSisuurendoTmttkn.getTmttknkouryokukaisiymd() == null) {

                    continue;
                }

                if ((khSisuurendoTmttkn.getRenno() == SrCommonConstants.RENBAN_1) &&
                    (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd(),
                        khSisuurendoTmttkn.getTmttknkouryokukaisiymd()) <= BizDateUtil.COMPARE_EQUAL) &&
                        (BizDateUtil.compareYmd(khSisuurendoTmttkn.getTmttknkouryokukaisiymd(),
                            pBatchParam.getKijyunymd()) <= BizDateUtil.COMPARE_EQUAL)) {

                    if (nensuuCount > 0 &&
                        BizDateUtil.compareYmd(teiritucalckijyunymdLst.get(nensuuCount - 1),
                            khSisuurendoTmttkn.getTmttknkouryokukaisiymd()) == BizDateUtil.COMPARE_EQUAL) {
                        nensuuCount = nensuuCount - 1;
                        tmttkNitenYmd = tmttkNitenYmd.addYears(-SrCommonConstants.YEAR_1Y).getRekijyou();
                    }
                    sisuubbncalckijyunymdLst.set(nensuuCount, null);
                    sisuubbntumitatekinLst.set(nensuuCount, null);
                    toukisisuuLst.set(nensuuCount, null);
                    toukisisuukijyunymdLst.set(nensuuCount, null);
                    zenkisisuuLst.set(nensuuCount, null);
                    zenkisisuukijyunymdLst.set(nensuuCount, null);
                    tmttknzoukarituLst.set(nensuuCount, null);
                    toukitumimasikinLst.set(nensuuCount, null);

                    teiritucalckijyunymdLst.set(nensuuCount, tmttkNitenYmd);
                    teiritutumitatekinLst.set(nensuuCount, khSisuurendoTmttkn.getTeiritutmttkngk());

                    tmttkNitenYmd = tmttkNitenYmd.addYears(SrCommonConstants.YEAR_1Y).getRekijyou();

                    nensuuCount++;
                }

                if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(khSisuurendoTmttkn.getGyoumuKousinKinou()) &&
                    BizDateUtil.compareYmd(khSisuurendoTmttkn.getTmttknkouryokukaisiymd(),
                        pBatchParam.getKijyunymd()) <= BizDateUtil.COMPARE_EQUAL) {

                    gengakuCalckijyunymd = khSisuurendoTmttkn.getTmttknkouryokukaisiymd();
                    gengakuSisuubbntumitatekin = khSisuurendoTmttkn.getSisuurendoutmttkngk();
                    gengakuTeiritutumitatekin = khSisuurendoTmttkn.getTeiritutmttkngk();
                }
            }
        }

        if (KINOUID_YENDTHNK == syoriTaisyouKbn) {


            List<SV_KiykSyuhnData> kiykSyuhnDataLst = batchDbAccess.getKiykSyuhnLst(
                pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(), C_SyutkKbn.SYU);

            for (int i = 0; i < kiykSyuhnDataLst.size(); i++) {

                SV_KiykSyuhnData kiykSyuhnData = kiykSyuhnDataLst.get(i);

                if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(kiykSyuhnData.getGyoumuKousinKinou()) &&
                    BizDateUtil.compareYmd(kiykSyuhnData.getKouryokuhasseiymd(), pBatchParam.getKijyunymd()) <=
                    BizDateUtil.COMPARE_EQUAL) {

                    gengakuSyuhnData = kiykSyuhnData;

                    break;
                }
            }


            int keikamon = BizDateUtil.calcDifferenceMonths(pBatchParam.getKijyunymd().getBizDateYM(),
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd().getBizDateYM());

            keikaNensuu = keikamon / SrCommonConstants.KIKAN_12M;

            BizDateYM yendtHnkCalckijyunYm = null;

            BizDateYM yendtHnkYm = null;

            for (int i = 0; i <= keikaNensuu; i++) {

                yendtHnkYmd = pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd().addYears(i).getRekijyou();

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                    yendtHnkYmd,
                    "",
                    kiykSyuhnDataLst).getTkJitenKeiyakuSyouhinKijyunBeanAto();


                if (i == 0) {

                    sisuubbncalckijyunymdLst.set(nensuuCount, null);
                    sisuubbntumitatekinLst.set(nensuuCount, null);
                    toukisisuuLst.set(nensuuCount, null);
                    toukisisuukijyunymdLst.set(nensuuCount, null);
                    zenkisisuuLst.set(nensuuCount, null);
                    zenkisisuukijyunymdLst.set(nensuuCount, null);
                    tmttknzoukarituLst.set(nensuuCount, null);
                    toukitumimasikinLst.set(nensuuCount, null);

                    teiritucalckijyunymdLst.set(nensuuCount, yendtHnkYmd);
                    teiritutumitatekinLst.set(nensuuCount, tkJitenKeiyakuSyouhinKijyunBean.getKihons());

                    nensuuCount++;
                }

                if (i > 0) {

                    yendtHnkCalckijyunYm = keisanWKijunYM.exec(
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                        yendtHnkYmd,
                        null,
                        null,
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

                    yendtHnkYm = keisanWKijunYM.exec(
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                        null,
                        null,
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                        null);

                    keisanSisuuRendouNkTmttknYendtHnk.exec(
                        yendtHnkYmd,
                        yendtHnkCalckijyunYm,
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                        yendtHnkYm,
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                        tkJitenKeiyakuSyouhinKijyunBean.getKihons(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());

                    sisuubbncalckijyunymdLst.set(nensuuCount, null);
                    sisuubbntumitatekinLst.set(nensuuCount, null);
                    toukisisuuLst.set(nensuuCount, null);
                    toukisisuukijyunymdLst.set(nensuuCount, null);
                    zenkisisuuLst.set(nensuuCount, null);
                    zenkisisuukijyunymdLst.set(nensuuCount, null);
                    tmttknzoukarituLst.set(nensuuCount, null);
                    toukitumimasikinLst.set(nensuuCount, null);

                    teiritucalckijyunymdLst.set(nensuuCount, yendtHnkYmd);
                    teiritutumitatekinLst.set(nensuuCount, keisanSisuuRendouNkTmttknYendtHnk.getTumitategk());

                    nensuuCount++;
                }


                if (yendthnkGengkinfoSetFlg) {

                    continue;
                }

                if (gengakuSyuhnData == null) {

                    continue;
                }

                if (gengakuSyuhnData.getKouryokuhasseiymd() != null &&
                    (BizDateUtil.compareYmd(yendtHnkYmd, gengakuSyuhnData.getKouryokuhasseiymd()) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(yendtHnkYmd, gengakuSyuhnData.getKouryokuhasseiymd()) == BizDateUtil.COMPARE_EQUAL)) {

                    if (i == 0) {

                        gengakuCalckijyunymd = gengakuSyuhnData.getKouryokuhasseiymd();
                        gengakuSisuubbntumitatekin = null;
                        gengakuTeiritutumitatekin = gengakuSyuhnData.getKihons();
                    }

                    if (i > 0) {

                        keisanSisuuRendouNkTmttknYendtHnk.exec(
                            yendtHnkYmd,
                            yendtHnkCalckijyunYm,
                            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                            yendtHnkYm,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                            gengakuSyuhnData.getKihons(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());

                        gengakuCalckijyunymd = gengakuSyuhnData.getKouryokuhasseiymd();
                        gengakuSisuubbntumitatekin = null;
                        gengakuTeiritutumitatekin = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
                    }
                }

                if (gengakuSyuhnData.getKouryokuhasseiymd() != null &&
                    (BizDateUtil.compareYmd(yendtHnkYmd, gengakuSyuhnData.getKouryokuhasseiymd()) == BizDateUtil.COMPARE_GREATER)) {

                    yendthnkGengkinfoSetFlg = true;
                }
            }
        }

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymd(convertFromBizDate(sisuubbncalckijyunymdLst.get(0)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekin(convertFromBizCurrency(sisuubbntumitatekinLst.get(0)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuu(changeNullToZero(toukisisuuLst.get(0)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymd(convertFromBizDate(toukisisuukijyunymdLst.get(0)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuu(changeNullToZero(zenkisisuuLst.get(0)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymd(convertFromBizDate(zenkisisuukijyunymdLst.get(0)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritu(changeNullToZero(tmttknzoukarituLst.get(0)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikin(convertFromBizCurrency(toukitumimasikinLst.get(0)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx2(convertFromBizDate(sisuubbncalckijyunymdLst.get(1)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx2(convertFromBizCurrency(sisuubbntumitatekinLst.get(1)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux2(changeNullToZero(toukisisuuLst.get(1)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx2(convertFromBizDate(toukisisuukijyunymdLst.get(1)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux2(changeNullToZero(zenkisisuuLst.get(1)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx2(convertFromBizDate(zenkisisuukijyunymdLst.get(1)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux2(changeNullToZero(tmttknzoukarituLst.get(1)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx2(convertFromBizCurrency(toukitumimasikinLst.get(1)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx3(convertFromBizDate(sisuubbncalckijyunymdLst.get(2)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx3(convertFromBizCurrency(sisuubbntumitatekinLst.get(2)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux3(changeNullToZero(toukisisuuLst.get(2)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx3(convertFromBizDate(toukisisuukijyunymdLst.get(2)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux3(changeNullToZero(zenkisisuuLst.get(2)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx3(convertFromBizDate(zenkisisuukijyunymdLst.get(2)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux3(changeNullToZero(tmttknzoukarituLst.get(2)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx3(convertFromBizCurrency(toukitumimasikinLst.get(2)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx4(convertFromBizDate(sisuubbncalckijyunymdLst.get(3)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx4(convertFromBizCurrency(sisuubbntumitatekinLst.get(3)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux4(changeNullToZero(toukisisuuLst.get(3)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx4(convertFromBizDate(toukisisuukijyunymdLst.get(3)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux4(changeNullToZero(zenkisisuuLst.get(3)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx4(convertFromBizDate(zenkisisuukijyunymdLst.get(3)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux4(changeNullToZero(tmttknzoukarituLst.get(3)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx4(convertFromBizCurrency(toukitumimasikinLst.get(3)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx5(convertFromBizDate(sisuubbncalckijyunymdLst.get(4)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx5(convertFromBizCurrency(sisuubbntumitatekinLst.get(4)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux5(changeNullToZero(toukisisuuLst.get(4)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx5(convertFromBizDate(toukisisuukijyunymdLst.get(4)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux5(changeNullToZero(zenkisisuuLst.get(4)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx5(convertFromBizDate(zenkisisuukijyunymdLst.get(4)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux5(changeNullToZero(tmttknzoukarituLst.get(4)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx5(convertFromBizCurrency(toukitumimasikinLst.get(4)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx6(convertFromBizDate(sisuubbncalckijyunymdLst.get(5)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx6(convertFromBizCurrency(sisuubbntumitatekinLst.get(5)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux6(changeNullToZero(toukisisuuLst.get(5)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx6(convertFromBizDate(toukisisuukijyunymdLst.get(5)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux6(changeNullToZero(zenkisisuuLst.get(5)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx6(convertFromBizDate(zenkisisuukijyunymdLst.get(5)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux6(changeNullToZero(tmttknzoukarituLst.get(5)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx6(convertFromBizCurrency(toukitumimasikinLst.get(5)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx7(convertFromBizDate(sisuubbncalckijyunymdLst.get(6)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx7(convertFromBizCurrency(sisuubbntumitatekinLst.get(6)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux7(changeNullToZero(toukisisuuLst.get(6)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx7(convertFromBizDate(toukisisuukijyunymdLst.get(6)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux7(changeNullToZero(zenkisisuuLst.get(6)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx7(convertFromBizDate(zenkisisuukijyunymdLst.get(6)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux7(changeNullToZero(tmttknzoukarituLst.get(6)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx7(convertFromBizCurrency(toukitumimasikinLst.get(6)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx8(convertFromBizDate(sisuubbncalckijyunymdLst.get(7)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx8(convertFromBizCurrency(sisuubbntumitatekinLst.get(7)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux8(changeNullToZero(toukisisuuLst.get(7)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx8(convertFromBizDate(toukisisuukijyunymdLst.get(7)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux8(changeNullToZero(zenkisisuuLst.get(7)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx8(convertFromBizDate(zenkisisuukijyunymdLst.get(7)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux8(changeNullToZero(tmttknzoukarituLst.get(7)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx8(convertFromBizCurrency(toukitumimasikinLst.get(7)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx9(convertFromBizDate(sisuubbncalckijyunymdLst.get(8)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx9(convertFromBizCurrency(sisuubbntumitatekinLst.get(8)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux9(changeNullToZero(toukisisuuLst.get(8)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx9(convertFromBizDate(toukisisuukijyunymdLst.get(8)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux9(changeNullToZero(zenkisisuuLst.get(8)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx9(convertFromBizDate(zenkisisuukijyunymdLst.get(8)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux9(changeNullToZero(tmttknzoukarituLst.get(8)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx9(convertFromBizCurrency(toukitumimasikinLst.get(8)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx10(convertFromBizDate(sisuubbncalckijyunymdLst.get(9)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx10(convertFromBizCurrency(sisuubbntumitatekinLst.get(9)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux10(changeNullToZero(toukisisuuLst.get(9)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx10(convertFromBizDate(toukisisuukijyunymdLst.get(9)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux10(changeNullToZero(zenkisisuuLst.get(9)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx10(convertFromBizDate(zenkisisuukijyunymdLst.get(9)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux10(changeNullToZero(tmttknzoukarituLst.get(9)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx10(convertFromBizCurrency(toukitumimasikinLst.get(9)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx11(convertFromBizDate(sisuubbncalckijyunymdLst.get(10)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx11(convertFromBizCurrency(sisuubbntumitatekinLst.get(10)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux11(changeNullToZero(toukisisuuLst.get(10)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx11(convertFromBizDate(toukisisuukijyunymdLst.get(10)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux11(changeNullToZero(zenkisisuuLst.get(10)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx11(convertFromBizDate(zenkisisuukijyunymdLst.get(10)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux11(changeNullToZero(tmttknzoukarituLst.get(10)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx11(convertFromBizCurrency(toukitumimasikinLst.get(10)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx12(convertFromBizDate(sisuubbncalckijyunymdLst.get(11)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx12(convertFromBizCurrency(sisuubbntumitatekinLst.get(11)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux12(changeNullToZero(toukisisuuLst.get(11)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx12(convertFromBizDate(toukisisuukijyunymdLst.get(11)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux12(changeNullToZero(zenkisisuuLst.get(11)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx12(convertFromBizDate(zenkisisuukijyunymdLst.get(11)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux12(changeNullToZero(tmttknzoukarituLst.get(11)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx12(convertFromBizCurrency(toukitumimasikinLst.get(11)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx13(convertFromBizDate(sisuubbncalckijyunymdLst.get(12)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx13(convertFromBizCurrency(sisuubbntumitatekinLst.get(12)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux13(changeNullToZero(toukisisuuLst.get(12)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx13(convertFromBizDate(toukisisuukijyunymdLst.get(12)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux13(changeNullToZero(zenkisisuuLst.get(12)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx13(convertFromBizDate(zenkisisuukijyunymdLst.get(12)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux13(changeNullToZero(tmttknzoukarituLst.get(12)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx13(convertFromBizCurrency(toukitumimasikinLst.get(12)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx14(convertFromBizDate(sisuubbncalckijyunymdLst.get(13)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx14(convertFromBizCurrency(sisuubbntumitatekinLst.get(13)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux14(changeNullToZero(toukisisuuLst.get(13)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx14(convertFromBizDate(toukisisuukijyunymdLst.get(13)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux14(changeNullToZero(zenkisisuuLst.get(13)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx14(convertFromBizDate(zenkisisuukijyunymdLst.get(13)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux14(changeNullToZero(tmttknzoukarituLst.get(13)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx14(convertFromBizCurrency(toukitumimasikinLst.get(13)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbncalckijyunymdx15(convertFromBizDate(sisuubbncalckijyunymdLst.get(14)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtysisuubbntumitatekinx15(convertFromBizCurrency(sisuubbntumitatekinLst.get(14)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuux15(changeNullToZero(toukisisuuLst.get(14)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukisisuukijyunymdx15(convertFromBizDate(toukisisuukijyunymdLst.get(14)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuux15(changeNullToZero(zenkisisuuLst.get(14)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyzenkisisuukijyunymdx15(convertFromBizDate(zenkisisuukijyunymdLst.get(14)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytmttknzoukaritux15(changeNullToZero(tmttknzoukarituLst.get(14)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtytoukitumimasikinx15(convertFromBizCurrency(toukitumimasikinLst.get(14)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymd(convertFromBizDate(teiritucalckijyunymdLst.get(0)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekin(convertFromBizCurrency(teiritutumitatekinLst.get(0)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx2(convertFromBizDate(teiritucalckijyunymdLst.get(1)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx2(convertFromBizCurrency(teiritutumitatekinLst.get(1)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx3(convertFromBizDate(teiritucalckijyunymdLst.get(2)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx3(convertFromBizCurrency(teiritutumitatekinLst.get(2)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx4(convertFromBizDate(teiritucalckijyunymdLst.get(3)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx4(convertFromBizCurrency(teiritutumitatekinLst.get(3)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx5(convertFromBizDate(teiritucalckijyunymdLst.get(4)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx5(convertFromBizCurrency(teiritutumitatekinLst.get(4)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx6(convertFromBizDate(teiritucalckijyunymdLst.get(5)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx6(convertFromBizCurrency(teiritutumitatekinLst.get(5)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx7(convertFromBizDate(teiritucalckijyunymdLst.get(6)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx7(convertFromBizCurrency(teiritutumitatekinLst.get(6)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx8(convertFromBizDate(teiritucalckijyunymdLst.get(7)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx8(convertFromBizCurrency(teiritutumitatekinLst.get(7)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx9(convertFromBizDate(teiritucalckijyunymdLst.get(8)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx9(convertFromBizCurrency(teiritutumitatekinLst.get(8)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx10(convertFromBizDate(teiritucalckijyunymdLst.get(9)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx10(convertFromBizCurrency(teiritutumitatekinLst.get(9)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx11(convertFromBizDate(teiritucalckijyunymdLst.get(10)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx11(convertFromBizCurrency(teiritutumitatekinLst.get(10)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx12(convertFromBizDate(teiritucalckijyunymdLst.get(11)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx12(convertFromBizCurrency(teiritutumitatekinLst.get(11)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx13(convertFromBizDate(teiritucalckijyunymdLst.get(12)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx13(convertFromBizCurrency(teiritutumitatekinLst.get(12)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx14(convertFromBizDate(teiritucalckijyunymdLst.get(13)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx14(convertFromBizCurrency(teiritutumitatekinLst.get(13)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritucalckijyunymdx15(convertFromBizDate(teiritucalckijyunymdLst.get(14)));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtyteiritutumitatekinx15(convertFromBizCurrency(teiritutumitatekinLst.get(14)));

        pSrKbkSsuRnduHknVKnsyuyuTy.setZtygengakujicalckijyunymd(convertFromBizDate(gengakuCalckijyunymd));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtygengakujisisuutmttkn(convertFromBizCurrency(gengakuSisuubbntumitatekin));
        pSrKbkSsuRnduHknVKnsyuyuTy.setZtygengakujiteiritutmttkn(convertFromBizCurrency(gengakuTeiritutumitatekin));
    }


    private String convertFromBizDate(BizDate pDate) {
        if (pDate == null) {
            return "";
        }

        return pDate.toString();
    }

    private long convertFromBizCurrency(BizCurrency pCurrency) {
        if (pCurrency == null) {
            return 0;
        }

        return Long.parseLong(pCurrency.toAdsoluteString());
    }

    private BizNumber changeNullToZero(BizNumber pNumber) {
        if (pNumber == null) {
            return BizNumber.valueOf(0);
        }

        return pNumber;
    }

}
