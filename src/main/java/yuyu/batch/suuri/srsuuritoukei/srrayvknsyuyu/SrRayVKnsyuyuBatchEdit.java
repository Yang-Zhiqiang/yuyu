package yuyu.batch.suuri.srsuuritoukei.srrayvknsyuyu;

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
import yuyu.def.db.entity.ZT_RayVKnsyuyuTy;

/**
 * 数理 数理統計 ＲＡＹＶ検証用情報作成項目編集クラス
 */
public class SrRayVKnsyuyuBatchEdit {

    private static final int KINOUID_TMTTKNHANEI = 0;

    private static final int KINOUID_TMTTKNITEN = 1;

    private static final int KINOUID_YENDTHNK = 2;

    public void editKoumoku(SrRayVKnsyuyuBatchParam pBatchParam,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_RayVKnsyuyuTy pRayVKnsyuyuTy,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst) {

        editHeaderData(pBatchParam, pRayVKnsyuyuTy);

        editHoyuuMeisaiKoumoku(pHoyuuMeisaiTyukeiyouItzHzn, pTkJitenKeiyakuSyouhinKijyunBean, pRayVKnsyuyuTy);

        editRayVKoumoku(pBatchParam,
            pHoyuuMeisaiTyukeiyouItzHzn, pTkJitenKeiyakuSyouhinKijyunBean, pRayVKnsyuyuTy,
            pSvKiykSyuhnDataLst);
    }


    private void editHeaderData(SrRayVKnsyuyuBatchParam pBatchParam,
        ZT_RayVKnsyuyuTy pRayVKnsyuyuTy) {

        pRayVKnsyuyuTy.setZtysequenceno(pBatchParam.getSyoriKensuu());
        pBatchParam.setSyoriKensuu(pBatchParam.getSyoriKensuu() + 1);
    }

    private void editHoyuuMeisaiKoumoku(ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_RayVKnsyuyuTy pRayVKnsyuyuTy) {

        pRayVKnsyuyuTy.setZtykeijyouym(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeijyouym());
        pRayVKnsyuyuTy.setZtyraysystemhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtyraysystemhyj());
        pRayVKnsyuyuTy.setZtydatakanrino(pHoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());
        pRayVKnsyuyuTy.setZtyhknsyukigou(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknsyukigou());
        pRayVKnsyuyuTy.setZtyhknsyuruikigousedaikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknsyuruikigousedaikbn());
        pRayVKnsyuyuTy.setZtysotodasipmenkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasipmenkbn());
        pRayVKnsyuyuTy.setZtysotodasimanagehyouji(pHoyuuMeisaiTyukeiyouItzHzn.getZtysotodasimanagehyouji());
        pRayVKnsyuyuTy.setZtysrdai1hknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrdai1hknkkn());
        pRayVKnsyuyuTy.setZtytuukasyukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtytuukasyukbn());
        pRayVKnsyuyuTy.setZtykbnkeiriyousegmentkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykbnkeiriyousegmentkbn());
        pRayVKnsyuyuTy.setZtykbnkeiriyourgnbnskkbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykbnkeiriyourgnbnskkbn());
        pRayVKnsyuyuTy.setZtysuurisyuruicd(pHoyuuMeisaiTyukeiyouItzHzn.getZtysuurisyuruicd());
        pRayVKnsyuyuTy.setZtykykymd(pHoyuuMeisaiTyukeiyouItzHzn.getZtykykymd());
        pRayVKnsyuyuTy.setZtyhknkkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhknkkn());
        pRayVKnsyuyuTy.setZtyphrkkikn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyphrkkikn());
        pRayVKnsyuyuTy.setZtysaimnkkykhyj(pHoyuuMeisaiTyukeiyouItzHzn.getZtysaimnkkykhyj());
        pRayVKnsyuyuTy.setZtyannaifuyouriyuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyannaifuyouriyuukbn());
        pRayVKnsyuyuTy.setZtyhhknseikbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhhknseikbn());
        pRayVKnsyuyuTy.setZtyhihokensyaagev2(pHoyuuMeisaiTyukeiyouItzHzn.getZtyhihokensyaagev2());
        pRayVKnsyuyuTy.setZtykuriagekurisagekbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykuriagekurisagekbn());
        pRayVKnsyuyuTy.setZtykeiyakujiyoteiriritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtykeiyakujiyoteiriritu());
        pRayVKnsyuyuTy.setZtysrkaiyakusjkkktyouseirrt(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrkaiyakusjkkktyouseirrt());
        pRayVKnsyuyuTy.setZtysrkyksjkkktyouseiriritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrkyksjkkktyouseiriritu());
        pRayVKnsyuyuTy.setZtymvatyouseikou(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseikou());
        pRayVKnsyuyuTy.setZtysisuurendourate(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurendourate());
        pRayVKnsyuyuTy.setZtysisuukbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuukbn());
        pRayVKnsyuyuTy.setZtygaikakbn(pHoyuuMeisaiTyukeiyouItzHzn.getZtygaikakbn());
        pRayVKnsyuyuTy.setZtykimatukawaserate(BizNumber.valueOf(pHoyuuMeisaiTyukeiyouItzHzn.getZtykawaserate1()));
        pRayVKnsyuyuTy.setZtykaiyakukoujyoritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtysrkaiyakukoujyoritu());
        pRayVKnsyuyuTy.setZtytumitateriritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtytumitateriritu());
        pRayVKnsyuyuTy.setZtysknnkaisiymd(convertFromBizDate(pTkJitenKeiyakuSyouhinKijyunBean.getSknnkaisiymd()));
        pRayVKnsyuyuTy.setZtyrendouritu(pHoyuuMeisaiTyukeiyouItzHzn.getZtyrendouritu());
        pRayVKnsyuyuTy.setZtysyukeiyakup(pHoyuuMeisaiTyukeiyouItzHzn.getZtysyukeiyakup());
        pRayVKnsyuyuTy.setZtymvatyouseigow(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvatyouseigow());
        pRayVKnsyuyuTy.setZtymvakeisanjisknnjynbkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtymvakeisanjisknnjynbkn());
        pRayVKnsyuyuTy.setZtykmtsisuurentumitatekn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentumitatekin());
        pRayVKnsyuyuTy.setZtykmttirttmtttumitatekn(pHoyuuMeisaiTyukeiyouItzHzn.getZtykimatutirttumitatekin());
        pRayVKnsyuyuTy.setZtykmtsisuurentyokugotmttkn(pHoyuuMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());
    }

    private void editRayVKoumoku(SrRayVKnsyuyuBatchParam pBatchParam,
        ST_HoyuuMeisaiTyukeiyouItzHzn pHoyuuMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_RayVKnsyuyuTy pRayVKnsyuyuTy,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst) {

        BizDate tumitateknKijyunymd;

        int syoriTaisyouKbn = KINOUID_TMTTKNHANEI;

        SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

        KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk =
            SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

        SrRayVKnsyuyuBatchDbAccess batchDbAccess =
            SWAKInjector.getInstance(SrRayVKnsyuyuBatchDbAccess.class);

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

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymd(convertFromBizDate(sisuubbncalckijyunymdLst.get(0)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekin(convertFromBizCurrency(sisuubbntumitatekinLst.get(0)));
        pRayVKnsyuyuTy.setZtytoukisisuu(changeNullToZero(toukisisuuLst.get(0)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymd(convertFromBizDate(toukisisuukijyunymdLst.get(0)));
        pRayVKnsyuyuTy.setZtyzenkisisuu(changeNullToZero(zenkisisuuLst.get(0)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymd(convertFromBizDate(zenkisisuukijyunymdLst.get(0)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritu(changeNullToZero(tmttknzoukarituLst.get(0)));
        pRayVKnsyuyuTy.setZtytoukitumimasikin(convertFromBizCurrency(toukitumimasikinLst.get(0)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx2(convertFromBizDate(sisuubbncalckijyunymdLst.get(1)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx2(convertFromBizCurrency(sisuubbntumitatekinLst.get(1)));
        pRayVKnsyuyuTy.setZtytoukisisuux2(changeNullToZero(toukisisuuLst.get(1)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx2(convertFromBizDate(toukisisuukijyunymdLst.get(1)));
        pRayVKnsyuyuTy.setZtyzenkisisuux2(changeNullToZero(zenkisisuuLst.get(1)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx2(convertFromBizDate(zenkisisuukijyunymdLst.get(1)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux2(changeNullToZero(tmttknzoukarituLst.get(1)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx2(convertFromBizCurrency(toukitumimasikinLst.get(1)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx3(convertFromBizDate(sisuubbncalckijyunymdLst.get(2)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx3(convertFromBizCurrency(sisuubbntumitatekinLst.get(2)));
        pRayVKnsyuyuTy.setZtytoukisisuux3(changeNullToZero(toukisisuuLst.get(2)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx3(convertFromBizDate(toukisisuukijyunymdLst.get(2)));
        pRayVKnsyuyuTy.setZtyzenkisisuux3(changeNullToZero(zenkisisuuLst.get(2)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx3(convertFromBizDate(zenkisisuukijyunymdLst.get(2)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux3(changeNullToZero(tmttknzoukarituLst.get(2)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx3(convertFromBizCurrency(toukitumimasikinLst.get(2)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx4(convertFromBizDate(sisuubbncalckijyunymdLst.get(3)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx4(convertFromBizCurrency(sisuubbntumitatekinLst.get(3)));
        pRayVKnsyuyuTy.setZtytoukisisuux4(changeNullToZero(toukisisuuLst.get(3)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx4(convertFromBizDate(toukisisuukijyunymdLst.get(3)));
        pRayVKnsyuyuTy.setZtyzenkisisuux4(changeNullToZero(zenkisisuuLst.get(3)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx4(convertFromBizDate(zenkisisuukijyunymdLst.get(3)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux4(changeNullToZero(tmttknzoukarituLst.get(3)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx4(convertFromBizCurrency(toukitumimasikinLst.get(3)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx5(convertFromBizDate(sisuubbncalckijyunymdLst.get(4)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx5(convertFromBizCurrency(sisuubbntumitatekinLst.get(4)));
        pRayVKnsyuyuTy.setZtytoukisisuux5(changeNullToZero(toukisisuuLst.get(4)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx5(convertFromBizDate(toukisisuukijyunymdLst.get(4)));
        pRayVKnsyuyuTy.setZtyzenkisisuux5(changeNullToZero(zenkisisuuLst.get(4)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx5(convertFromBizDate(zenkisisuukijyunymdLst.get(4)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux5(changeNullToZero(tmttknzoukarituLst.get(4)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx5(convertFromBizCurrency(toukitumimasikinLst.get(4)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx6(convertFromBizDate(sisuubbncalckijyunymdLst.get(5)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx6(convertFromBizCurrency(sisuubbntumitatekinLst.get(5)));
        pRayVKnsyuyuTy.setZtytoukisisuux6(changeNullToZero(toukisisuuLst.get(5)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx6(convertFromBizDate(toukisisuukijyunymdLst.get(5)));
        pRayVKnsyuyuTy.setZtyzenkisisuux6(changeNullToZero(zenkisisuuLst.get(5)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx6(convertFromBizDate(zenkisisuukijyunymdLst.get(5)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux6(changeNullToZero(tmttknzoukarituLst.get(5)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx6(convertFromBizCurrency(toukitumimasikinLst.get(5)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx7(convertFromBizDate(sisuubbncalckijyunymdLst.get(6)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx7(convertFromBizCurrency(sisuubbntumitatekinLst.get(6)));
        pRayVKnsyuyuTy.setZtytoukisisuux7(changeNullToZero(toukisisuuLst.get(6)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx7(convertFromBizDate(toukisisuukijyunymdLst.get(6)));
        pRayVKnsyuyuTy.setZtyzenkisisuux7(changeNullToZero(zenkisisuuLst.get(6)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx7(convertFromBizDate(zenkisisuukijyunymdLst.get(6)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux7(changeNullToZero(tmttknzoukarituLst.get(6)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx7(convertFromBizCurrency(toukitumimasikinLst.get(6)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx8(convertFromBizDate(sisuubbncalckijyunymdLst.get(7)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx8(convertFromBizCurrency(sisuubbntumitatekinLst.get(7)));
        pRayVKnsyuyuTy.setZtytoukisisuux8(changeNullToZero(toukisisuuLst.get(7)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx8(convertFromBizDate(toukisisuukijyunymdLst.get(7)));
        pRayVKnsyuyuTy.setZtyzenkisisuux8(changeNullToZero(zenkisisuuLst.get(7)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx8(convertFromBizDate(zenkisisuukijyunymdLst.get(7)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux8(changeNullToZero(tmttknzoukarituLst.get(7)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx8(convertFromBizCurrency(toukitumimasikinLst.get(7)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx9(convertFromBizDate(sisuubbncalckijyunymdLst.get(8)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx9(convertFromBizCurrency(sisuubbntumitatekinLst.get(8)));
        pRayVKnsyuyuTy.setZtytoukisisuux9(changeNullToZero(toukisisuuLst.get(8)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx9(convertFromBizDate(toukisisuukijyunymdLst.get(8)));
        pRayVKnsyuyuTy.setZtyzenkisisuux9(changeNullToZero(zenkisisuuLst.get(8)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx9(convertFromBizDate(zenkisisuukijyunymdLst.get(8)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux9(changeNullToZero(tmttknzoukarituLst.get(8)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx9(convertFromBizCurrency(toukitumimasikinLst.get(8)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx10(convertFromBizDate(sisuubbncalckijyunymdLst.get(9)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx10(convertFromBizCurrency(sisuubbntumitatekinLst.get(9)));
        pRayVKnsyuyuTy.setZtytoukisisuux10(changeNullToZero(toukisisuuLst.get(9)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx10(convertFromBizDate(toukisisuukijyunymdLst.get(9)));
        pRayVKnsyuyuTy.setZtyzenkisisuux10(changeNullToZero(zenkisisuuLst.get(9)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx10(convertFromBizDate(zenkisisuukijyunymdLst.get(9)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux10(changeNullToZero(tmttknzoukarituLst.get(9)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx10(convertFromBizCurrency(toukitumimasikinLst.get(9)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx11(convertFromBizDate(sisuubbncalckijyunymdLst.get(10)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx11(convertFromBizCurrency(sisuubbntumitatekinLst.get(10)));
        pRayVKnsyuyuTy.setZtytoukisisuux11(changeNullToZero(toukisisuuLst.get(10)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx11(convertFromBizDate(toukisisuukijyunymdLst.get(10)));
        pRayVKnsyuyuTy.setZtyzenkisisuux11(changeNullToZero(zenkisisuuLst.get(10)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx11(convertFromBizDate(zenkisisuukijyunymdLst.get(10)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux11(changeNullToZero(tmttknzoukarituLst.get(10)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx11(convertFromBizCurrency(toukitumimasikinLst.get(10)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx12(convertFromBizDate(sisuubbncalckijyunymdLst.get(11)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx12(convertFromBizCurrency(sisuubbntumitatekinLst.get(11)));
        pRayVKnsyuyuTy.setZtytoukisisuux12(changeNullToZero(toukisisuuLst.get(11)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx12(convertFromBizDate(toukisisuukijyunymdLst.get(11)));
        pRayVKnsyuyuTy.setZtyzenkisisuux12(changeNullToZero(zenkisisuuLst.get(11)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx12(convertFromBizDate(zenkisisuukijyunymdLst.get(11)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux12(changeNullToZero(tmttknzoukarituLst.get(11)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx12(convertFromBizCurrency(toukitumimasikinLst.get(11)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx13(convertFromBizDate(sisuubbncalckijyunymdLst.get(12)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx13(convertFromBizCurrency(sisuubbntumitatekinLst.get(12)));
        pRayVKnsyuyuTy.setZtytoukisisuux13(changeNullToZero(toukisisuuLst.get(12)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx13(convertFromBizDate(toukisisuukijyunymdLst.get(12)));
        pRayVKnsyuyuTy.setZtyzenkisisuux13(changeNullToZero(zenkisisuuLst.get(12)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx13(convertFromBizDate(zenkisisuukijyunymdLst.get(12)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux13(changeNullToZero(tmttknzoukarituLst.get(12)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx13(convertFromBizCurrency(toukitumimasikinLst.get(12)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx14(convertFromBizDate(sisuubbncalckijyunymdLst.get(13)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx14(convertFromBizCurrency(sisuubbntumitatekinLst.get(13)));
        pRayVKnsyuyuTy.setZtytoukisisuux14(changeNullToZero(toukisisuuLst.get(13)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx14(convertFromBizDate(toukisisuukijyunymdLst.get(13)));
        pRayVKnsyuyuTy.setZtyzenkisisuux14(changeNullToZero(zenkisisuuLst.get(13)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx14(convertFromBizDate(zenkisisuukijyunymdLst.get(13)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux14(changeNullToZero(tmttknzoukarituLst.get(13)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx14(convertFromBizCurrency(toukitumimasikinLst.get(13)));

        pRayVKnsyuyuTy.setZtysisuubbncalckijyunymdx15(convertFromBizDate(sisuubbncalckijyunymdLst.get(14)));
        pRayVKnsyuyuTy.setZtysisuubbntumitatekinx15(convertFromBizCurrency(sisuubbntumitatekinLst.get(14)));
        pRayVKnsyuyuTy.setZtytoukisisuux15(changeNullToZero(toukisisuuLst.get(14)));
        pRayVKnsyuyuTy.setZtytoukisisuukijyunymdx15(convertFromBizDate(toukisisuukijyunymdLst.get(14)));
        pRayVKnsyuyuTy.setZtyzenkisisuux15(changeNullToZero(zenkisisuuLst.get(14)));
        pRayVKnsyuyuTy.setZtyzenkisisuukijyunymdx15(convertFromBizDate(zenkisisuukijyunymdLst.get(14)));
        pRayVKnsyuyuTy.setZtytmttknzoukaritux15(changeNullToZero(tmttknzoukarituLst.get(14)));
        pRayVKnsyuyuTy.setZtytoukitumimasikinx15(convertFromBizCurrency(toukitumimasikinLst.get(14)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymd(convertFromBizDate(teiritucalckijyunymdLst.get(0)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekin(convertFromBizCurrency(teiritutumitatekinLst.get(0)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx2(convertFromBizDate(teiritucalckijyunymdLst.get(1)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx2(convertFromBizCurrency(teiritutumitatekinLst.get(1)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx3(convertFromBizDate(teiritucalckijyunymdLst.get(2)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx3(convertFromBizCurrency(teiritutumitatekinLst.get(2)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx4(convertFromBizDate(teiritucalckijyunymdLst.get(3)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx4(convertFromBizCurrency(teiritutumitatekinLst.get(3)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx5(convertFromBizDate(teiritucalckijyunymdLst.get(4)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx5(convertFromBizCurrency(teiritutumitatekinLst.get(4)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx6(convertFromBizDate(teiritucalckijyunymdLst.get(5)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx6(convertFromBizCurrency(teiritutumitatekinLst.get(5)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx7(convertFromBizDate(teiritucalckijyunymdLst.get(6)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx7(convertFromBizCurrency(teiritutumitatekinLst.get(6)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx8(convertFromBizDate(teiritucalckijyunymdLst.get(7)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx8(convertFromBizCurrency(teiritutumitatekinLst.get(7)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx9(convertFromBizDate(teiritucalckijyunymdLst.get(8)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx9(convertFromBizCurrency(teiritutumitatekinLst.get(8)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx10(convertFromBizDate(teiritucalckijyunymdLst.get(9)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx10(convertFromBizCurrency(teiritutumitatekinLst.get(9)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx11(convertFromBizDate(teiritucalckijyunymdLst.get(10)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx11(convertFromBizCurrency(teiritutumitatekinLst.get(10)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx12(convertFromBizDate(teiritucalckijyunymdLst.get(11)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx12(convertFromBizCurrency(teiritutumitatekinLst.get(11)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx13(convertFromBizDate(teiritucalckijyunymdLst.get(12)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx13(convertFromBizCurrency(teiritutumitatekinLst.get(12)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx14(convertFromBizDate(teiritucalckijyunymdLst.get(13)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx14(convertFromBizCurrency(teiritutumitatekinLst.get(13)));

        pRayVKnsyuyuTy.setZtyteiritucalckijyunymdx15(convertFromBizDate(teiritucalckijyunymdLst.get(14)));
        pRayVKnsyuyuTy.setZtyteiritutumitatekinx15(convertFromBizCurrency(teiritutumitatekinLst.get(14)));

        pRayVKnsyuyuTy.setZtygengakujicalckijyunymd(convertFromBizDate(gengakuCalckijyunymd));
        pRayVKnsyuyuTy.setZtygengakujisisuutmttkn(convertFromBizCurrency(gengakuSisuubbntumitatekin));
        pRayVKnsyuyuTy.setZtygengakujiteiritutmttkn(convertFromBizCurrency(gengakuTeiritutumitatekin));
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
