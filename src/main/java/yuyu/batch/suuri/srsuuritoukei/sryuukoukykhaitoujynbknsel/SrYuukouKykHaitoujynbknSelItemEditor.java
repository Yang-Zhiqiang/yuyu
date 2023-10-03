package yuyu.batch.suuri.srsuuritoukei.sryuukoukykhaitoujynbknsel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateMD;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.haitou.GetDRiritu;
import yuyu.common.hozen.haitou.KeisanDCommon;
import yuyu.common.hozen.haitou.KeisanDGanrikin;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfoBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KykKihonTokuteiJitenKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SrHaitoukinSyuukeiPtnKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriAnnaiFuyouRiyuuKbn;
import yuyu.def.classification.C_SuuriHaraikataKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknKarid;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 有効契約配当準備金データ抽出項目編集
 */
public class SrYuukouKykHaitoujynbknSelItemEditor {

    private static final String SEISIKIWARIATENENDOHYJ_ARI = "1";

    private static final String SEISIKIWARIATENENDOHYJ_NONE = "0";

    private static final String ZENNENDKURIKOSID = "前年度繰越Ｄ";

    private static final String TNDMATUTUMITATED = "当年度末積立Ｄ";

    private static final String ZNNNDKRKSKRWRATDRUIGK = "前年度繰越仮割当Ｄ累計額";

    private static final String TNDMATUKRKSKRWRATDRUIGK = "当年度末仮割当Ｄ累計額";

    private static final String DAIHYOUYOTEIRIRITU = "代表予定利率";

    private static final String KEISANDGANRIKIN = "配当元利金計算(";

    private static final String KEISANWRMDS = "割戻し計算(";

    private static final String KAKKO_RIGHT = ")";

    @Inject
    private BatchLogger batchLogger;

    private boolean errorFlag;

    private SyouhinbetuSegmentBean syouhinbetuSegmentBean;

    private BizCurrency hsys;

    private String hrkkaisuu;

    private String hrkkeiro;

    private C_SuuriAnnaiFuyouRiyuuKbn suuriAnnaiFuyouRiyuuKbn;

    private BizDateYM mankitouraiym;

    private String syukeiyakusyuruicd;

    private BizDateY kyknendo;

    private BizNumber daihyouyoteiriritu;

    private C_SuuriHaraikataKbn suuriHaraikataKbn;

    private C_SrHaitoukinSyuukeiPtnKbn srHaitoukinSyuukeiPtnKbn;

    public SrYuukouKykHaitoujynbknSelItemEditor() {

        errorFlag = false;
        syouhinbetuSegmentBean = null;
        hsys = null;
        hrkkaisuu = null;
        hrkkeiro = null;
        suuriAnnaiFuyouRiyuuKbn = null;
        mankitouraiym = null;
        syukeiyakusyuruicd = null;
        daihyouyoteiriritu = null;
        suuriHaraikataKbn = null;
        srHaitoukinSyuukeiPtnKbn = null;
    }

    public boolean editKoumokuTmttd(
        SrYuukouKykHaitoujynbknSelBatchParam pBatchParam,
        SV_HoyuuMeisai pHoyuuMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        int pSyohinHanteiKbn,
        List<SV_KiykSyuhnData> pKiykSyuhnDataLst,
        List<IT_KhTumitateDKanri> pKhTumitateDKanriLst,
        List<IT_KhHaitouKanri> pKhHaitouKanriLst,
        ST_YuukoukykHtjynbknTmttd pYuukoukykHtjynbknTmttd) {

        BizCurrency zennendoKurikosiD = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizDate zenJigyouNendoMatuymd = null;
        IT_KhTumitateDKanri khTumitateDKanriZen = null;
        IT_KhTumitateDKanri khTumitateDKanriTou = null;

        if (pBatchParam.getKijyunymd().getMonth() <= SrCommonConstants.MONTH_MARCH) {

            zenJigyouNendoMatuymd = BizDate.valueOf(String.valueOf(pBatchParam.getKijyunymd().getBizDateY()
                .addYears(-SrCommonConstants.YEAR_1Y)) + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }
        else {

            zenJigyouNendoMatuymd = BizDate.valueOf(String.valueOf(pBatchParam.getKijyunymd().getBizDateY())
                + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }

        for (IT_KhTumitateDKanri tumitateDKanri : pKhTumitateDKanriLst) {

            if (BizDateUtil.compareYmd(tumitateDKanri.getTumitatedtumitateymd(), zenJigyouNendoMatuymd) == BizDateUtil.COMPARE_LESSER
                || BizDateUtil.compareYmd(tumitateDKanri.getTumitatedtumitateymd(), zenJigyouNendoMatuymd) == BizDateUtil.COMPARE_EQUAL) {

                khTumitateDKanriZen = tumitateDKanri;

                break;
            }
        }

        if (khTumitateDKanriZen != null) {

            if (khTumitateDKanriZen.getTumitated().compareTo(BizCurrency.valueOf(
                SrCommonConstants.DEFAULT_INT_ZERO, khTumitateDKanriZen.getTumitated().getType())) != 0) {

                if (BizDateUtil.compareYmd(pKhTumitateDKanriLst.get(0).getTumitatedtumitateymd(), zenJigyouNendoMatuymd)
                    == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(pKhTumitateDKanriLst.get(0).getTumitatedtumitateymd(), zenJigyouNendoMatuymd)
                    == BizDateUtil.COMPARE_EQUAL) {

                    zennendoKurikosiD = keisanDGanrikin(
                        khTumitateDKanriZen.getTumitated(),
                        khTumitateDKanriZen.getTumitatedtumitateymd(),
                        zenJigyouNendoMatuymd,
                        ZENNENDKURIKOSID,
                        pHoyuuMeisai.getSyono(),
                        pBatchParam);
                }
                else {

                    khTumitateDKanriTou = pKhTumitateDKanriLst.get(0);

                    if (C_TumitateDSakuseiKbn.ITIBUHIKIDASI.eq(khTumitateDKanriTou.getTumitatedskskbn()) ||
                        C_TumitateDSakuseiKbn.RISOKUKURIIRE.eq(khTumitateDKanriTou.getTumitatedskskbn())) {

                        zennendoKurikosiD = calcWrmdsKngk(khTumitateDKanriTou.getTumitated(), zenJigyouNendoMatuymd,
                            khTumitateDKanriTou.getTumitatedtumitateymd(), ZENNENDKURIKOSID, pHoyuuMeisai.getSyono(),
                            pBatchParam);
                    }
                    else if (C_TumitateDSakuseiKbn.ZENHIKIDASI.eq(khTumitateDKanriTou.getTumitatedskskbn())) {

                        zennendoKurikosiD = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                    }
                    else if (C_TumitateDSakuseiKbn.SEISIKI.eq(khTumitateDKanriTou.getTumitatedskskbn())) {

                        IT_KhTumitateDKanri khTumitateDKanri = pKhTumitateDKanriLst.get(1);

                        zennendoKurikosiD = calcWrmdsKngk(khTumitateDKanri.getTumitated(), zenJigyouNendoMatuymd,
                            khTumitateDKanri.getTumitatedtumitateymd(), ZENNENDKURIKOSID, pHoyuuMeisai.getSyono(),
                            pBatchParam);
                    }
                    else if (C_TumitateDSakuseiKbn.YENDTHNKSEISIKI.eq(khTumitateDKanriTou.getTumitatedskskbn())) {

                        if (BizDateUtil.compareYmd(zenJigyouNendoMatuymd, pKhTumitateDKanriLst.get(1)
                            .getTumitatedtumitateymd()) == BizDateUtil.COMPARE_LESSER &&
                            C_TumitateDSakuseiKbn.SEISIKI.eq(pKhTumitateDKanriLst.get(1).getTumitatedskskbn())) {

                            IT_KhTumitateDKanri khTumitateDKanri = pKhTumitateDKanriLst.get(2);

                            for (int i = 2; i < pKhTumitateDKanriLst.size(); i++){

                                if (C_TumitateDSakuseiKbn.RISOKUKURIIRE.eq(pKhTumitateDKanriLst.get(i).getTumitatedskskbn())){

                                    khTumitateDKanri = pKhTumitateDKanriLst.get(i);

                                    break;
                                }
                            }

                            zennendoKurikosiD = calcWrmdsKngk(
                                khTumitateDKanri.getTumitated(),
                                zenJigyouNendoMatuymd,
                                khTumitateDKanri.getTumitatedtumitateymd(),
                                ZENNENDKURIKOSID,
                                pHoyuuMeisai.getSyono(),
                                pBatchParam);
                        }
                        else {

                            IT_KhTumitateDKanri khTumitateDKanri = null;

                            for (int i = 1; i < pKhTumitateDKanriLst.size(); i++){

                                if (zenJigyouNendoMatuymd.compareTo(pKhTumitateDKanriLst.get(i)
                                    .getTumitatedtumitateymd()) == BizDateUtil.COMPARE_LESSER ){

                                    khTumitateDKanri = pKhTumitateDKanriLst.get(i);

                                    break;
                                }
                            }

                            if (khTumitateDKanri != null){

                                zennendoKurikosiD = calcWrmdsKngk(
                                    pKhTumitateDKanriLst.get(1).getTumitated(),
                                    zenJigyouNendoMatuymd,
                                    pKhTumitateDKanriLst.get(1).getTumitatedtumitateymd(),
                                    ZENNENDKURIKOSID,
                                    pHoyuuMeisai.getSyono(),
                                    pBatchParam);

                            }
                            else{

                                BizCurrency tounendoD = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                                for (int i = 0; i < pKhHaitouKanriLst.size(); i++){

                                    if (C_HaitoukinsksKbn.YENDTHNKSEISIKI.eq(pKhHaitouKanriLst.get(i).getHaitoukinskskbn())){

                                        tounendoD = pKhHaitouKanriLst.get(i).getTounendod();

                                        break;
                                    }
                                }

                                zennendoKurikosiD = calcWrmdsKngk(
                                    pKhTumitateDKanriLst.get(0).getTumitated().subtract(tounendoD),
                                    zenJigyouNendoMatuymd,
                                    pKhTumitateDKanriLst.get(0).getTumitatedtumitateymd(),
                                    ZENNENDKURIKOSID,
                                    pHoyuuMeisai.getSyono(),
                                    pBatchParam);

                            }
                        }
                    }
                }
            }
        }

        BizCurrency tounendoD = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (BizDateUtil.compareYmd(zenJigyouNendoMatuymd, pKhTumitateDKanriLst.get(0)
            .getTumitatedtumitateymd()) == BizDateUtil.COMPARE_LESSER){

            if(C_TumitateDSakuseiKbn.SEISIKI.eq(pKhTumitateDKanriLst.get(0).getTumitatedskskbn())) {

                for (int i = 0; i < pKhHaitouKanriLst.size(); i++){

                    if (C_HaitoukinsksKbn.SEISIKI.eq(pKhHaitouKanriLst.get(i).getHaitoukinskskbn())){

                        tounendoD = pKhHaitouKanriLst.get(i).getTounendod();

                        break;
                    }
                }
            }
            else if(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI.eq(pKhTumitateDKanriLst.get(0).getTumitatedskskbn())) {

                boolean seisikiWariateFlg = false;

                if (pKhTumitateDKanriLst.size() > 1 &&
                    BizDateUtil.compareYmd(zenJigyouNendoMatuymd, pKhTumitateDKanriLst.get(1)
                        .getTumitatedtumitateymd()) == BizDateUtil.COMPARE_LESSER &&
                        C_TumitateDSakuseiKbn.SEISIKI.eq(pKhTumitateDKanriLst.get(1).getTumitatedskskbn())){

                    seisikiWariateFlg = true;
                }

                for (IT_KhHaitouKanri haitouKanri : pKhHaitouKanriLst) {

                    if (BizDateUtil.compareYmd(zenJigyouNendoMatuymd, haitouKanri
                        .getKariwariatedshrymd()) == BizDateUtil.COMPARE_LESSER &&
                        (C_HaitoukinsksKbn.SEISIKI.eq(haitouKanri.getHaitoukinskskbn()) ||
                            C_HaitoukinsksKbn.YENDTHNKSEISIKI.eq(haitouKanri.getHaitoukinskskbn()))){

                        tounendoD = tounendoD.add(haitouKanri.getTounendod());

                        if (!seisikiWariateFlg){

                            break;
                        }
                    }
                }
            }
        }

        BizCurrency tndmatuTumitated = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (pKhTumitateDKanriLst.get(0).getTumitated().compareTo(BizCurrency.valueOf(
            SrCommonConstants.DEFAULT_INT_ZERO, pKhTumitateDKanriLst.get(0).getTumitated().getType())) != 0) {

            tndmatuTumitated = keisanDGanrikin(
                pKhTumitateDKanriLst.get(0).getTumitated(),
                pKhTumitateDKanriLst.get(0).getTumitatedtumitateymd(),
                pBatchParam.getKijyunymd(),
                TNDMATUTUMITATED,
                pHoyuuMeisai.getSyono(),
                pBatchParam);
        }

        BizCurrency tumitateRisoku = tndmatuTumitated.subtract(tounendoD).subtract(zennendoKurikosiD);

        pYuukoukykHtjynbknTmttd.setSyoriYmd(pBatchParam.getSyoriYmd());
        pYuukoukykHtjynbknTmttd.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
        pYuukoukykHtjynbknTmttd.setSyono(pHoyuuMeisai.getSyono());
        pYuukoukykHtjynbknTmttd.setHknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        pYuukoukykHtjynbknTmttd.setHaraikomikaisukbn(hrkkaisuu);
        pYuukoukykHtjynbknTmttd.setHrkkeirokbn(hrkkeiro);
        pYuukoukykHtjynbknTmttd.setAnnaihuyouriyuukbn(suuriAnnaiFuyouRiyuuKbn.getValue());
        pYuukoukykHtjynbknTmttd.setZennendkurikosid(zennendoKurikosiD);
        pYuukoukykHtjynbknTmttd.setTounendod(tounendoD);
        pYuukoukykHtjynbknTmttd.setTndmatutumitated(tndmatuTumitated);
        pYuukoukykHtjynbknTmttd.setTumitaterisoku(tumitateRisoku);
        pYuukoukykHtjynbknTmttd.setHsys(hsys);
        pYuukoukykHtjynbknTmttd.setSrkijyunym(String.valueOf(pBatchParam.getKijyunymd().getBizDateYM()));
        if (syouhinbetuSegmentBean != null) {

            pYuukoukykHtjynbknTmttd.setKbnkeiriyousegmentkbn(syouhinbetuSegmentBean.getSegcd1().getValue()
                .substring(0, 2));
            pYuukoukykHtjynbknTmttd.setKbnkeiriyourgnbnskkbn(syouhinbetuSegmentBean.getSegcd1().getValue()
                .substring(2, 4));
        }
        pYuukoukykHtjynbknTmttd.setMankitouraiym(mankitouraiym);
        pYuukoukykHtjynbknTmttd.setSyukeiyakusyuruicd(syukeiyakusyuruicd);
        pYuukoukykHtjynbknTmttd.setKyknendo(String.valueOf(kyknendo));
        pYuukoukykHtjynbknTmttd.setDaihyouyoteiriritu(daihyouyoteiriritu);
        if (suuriHaraikataKbn != null) {
            pYuukoukykHtjynbknTmttd.setHaraikatakbn(suuriHaraikataKbn.getValue());
        }
        pYuukoukykHtjynbknTmttd.setSrhaitoukinsyuukeiptnkbn(srHaitoukinSyuukeiPtnKbn);

        return errorFlag;
    }

    public boolean editKoumokuKarid(
        SrYuukouKykHaitoujynbknSelBatchParam pBatchParam,
        SV_HoyuuMeisai pHoyuuMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        int pSyohinHanteiKbn,
        List<SV_KiykSyuhnData> pKiykSyuhnDataLst,
        List<IT_KhHaitouKanri> pKhHaitouKanriLst,
        ST_YuukoukykHtjynbknKarid pYuukoukykHtjynbknKarid) {

        BizDate[] kariwariatedshrymd = getKariwariatedshrymd(pKhHaitouKanriLst, pKiykSyuhnDataLst);

        String seisikiWariateNendoHyj = "";

        BizDate kijyunymd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            kijyunymd = pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd();
        }

        BizDateY kijyunY = kijyunymd.getBizDateY();

        if (kijyunymd.getMonth() <= SrCommonConstants.MONTH_MARCH) {

            kijyunY = kijyunymd.getBizDateY().addYears(-SrCommonConstants.YEAR_1Y);
        }

        BizDate zenJigyouNendoMatuymd = null;
        if (pBatchParam.getKijyunymd().getMonth() <= SrCommonConstants.MONTH_MARCH) {

            zenJigyouNendoMatuymd = BizDate.valueOf(String.valueOf(pBatchParam.getKijyunymd().getBizDateY()
                .addYears(-SrCommonConstants.YEAR_1Y)) + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }
        else {

            zenJigyouNendoMatuymd = BizDate.valueOf(String.valueOf(pBatchParam.getKijyunymd().getBizDateY())
                + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }

        BizDateY haitounendo = pKhHaitouKanriLst.get(0).getHaitounendo();

        if ((haitounendo.getYear() - kijyunY.getYear()) % 5 == 0) {

            if (haitounendo.getYear() == zenJigyouNendoMatuymd.getYear()){

                seisikiWariateNendoHyj = SEISIKIWARIATENENDOHYJ_ARI;

            }
            else{

                seisikiWariateNendoHyj = SEISIKIWARIATENENDOHYJ_NONE;
            }

        }
        else {

            seisikiWariateNendoHyj = SEISIKIWARIATENENDOHYJ_NONE;
        }

        IT_KhHaitouKanri khHaitouKanriZen = null;
        BizDate kariwariatedshrymdZen = null;
        IT_KhHaitouKanri khHaitouKanriTou = null;
        BizCurrency znnndKrksKrwratdRuigk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        for (int i = 0 ; i < pKhHaitouKanriLst.size(); i++) {

            if (BizDateUtil.compareYmd(kariwariatedshrymd[i], zenJigyouNendoMatuymd) == BizDateUtil.COMPARE_LESSER
                || BizDateUtil.compareYmd(kariwariatedshrymd[i], zenJigyouNendoMatuymd) == BizDateUtil.COMPARE_EQUAL) {

                khHaitouKanriZen = pKhHaitouKanriLst.get(i);

                kariwariatedshrymdZen = kariwariatedshrymd[i];

                break;
            }
        }

        if (khHaitouKanriZen != null) {

            if (khHaitouKanriZen.getKariwariatedruigk().compareTo(BizCurrency.valueOf(
                SrCommonConstants.DEFAULT_INT_ZERO, khHaitouKanriZen.getKariwariatedruigk().getType())) != 0) {

                if (BizDateUtil.compareYmd(kariwariatedshrymd[0], zenJigyouNendoMatuymd) == BizDateUtil.COMPARE_LESSER
                    || BizDateUtil.compareYmd(kariwariatedshrymd[0], zenJigyouNendoMatuymd) == BizDateUtil.COMPARE_EQUAL) {

                    znnndKrksKrwratdRuigk = keisanDGanrikin(
                        khHaitouKanriZen.getKariwariatedruigk(),
                        kariwariatedshrymdZen,
                        zenJigyouNendoMatuymd,
                        ZNNNDKRKSKRWRATDRUIGK,
                        pHoyuuMeisai.getSyono(),
                        pBatchParam);
                }
                else {

                    khHaitouKanriTou = pKhHaitouKanriLst.get(0);

                    if (C_HaitoukinsksKbn.SEISIKI.eq(khHaitouKanriTou.getHaitoukinskskbn())) {

                        znnndKrksKrwratdRuigk = calcWrmdsKngk(
                            pKhHaitouKanriLst.get(1).getKariwariatedruigk()
                            .subtract(pKhHaitouKanriLst.get(1).getTounendod()),
                            zenJigyouNendoMatuymd,
                            pKhHaitouKanriLst.get(1).getKariwariatedshrymd(),
                            ZNNNDKRKSKRWRATDRUIGK,
                            pHoyuuMeisai.getSyono(),
                            pBatchParam);
                    }
                    if (C_HaitoukinsksKbn.KARIWARIATE1.eq(khHaitouKanriTou.getHaitoukinskskbn()) ||
                        C_HaitoukinsksKbn.KARIWARIATE2.eq(khHaitouKanriTou.getHaitoukinskskbn()) ||
                        C_HaitoukinsksKbn.KARIWARIATE3.eq(khHaitouKanriTou.getHaitoukinskskbn()) ||
                        C_HaitoukinsksKbn.KARIWARIATE4.eq(khHaitouKanriTou.getHaitoukinskskbn())) {

                        znnndKrksKrwratdRuigk = calcWrmdsKngk(
                            khHaitouKanriTou.getKariwariatedruigk().subtract(khHaitouKanriTou.getTounendod()),
                            zenJigyouNendoMatuymd,
                            khHaitouKanriTou.getKariwariatedshrymd(),
                            ZNNNDKRKSKRWRATDRUIGK,
                            pHoyuuMeisai.getSyono(),
                            pBatchParam);
                    }
                    else if (C_HaitoukinsksKbn.KARIDSIHARAI.eq(khHaitouKanriTou.getHaitoukinskskbn())) {

                        znnndKrksKrwratdRuigk = calcWrmdsKngk(
                            khHaitouKanriTou.getKariwariatedruigk(),
                            zenJigyouNendoMatuymd,
                            kariwariatedshrymd[0],
                            ZNNNDKRKSKRWRATDRUIGK,
                            pHoyuuMeisai.getSyono(),
                            pBatchParam);
                    }
                    else if (C_HaitoukinsksKbn.YENDTHNKSEISIKI.eq(khHaitouKanriTou.getHaitoukinskskbn())) {

                        C_UmuKbn seisikiWariateFlg = C_UmuKbn.NONE;
                        C_UmuKbn kariwariateFlg = C_UmuKbn.NONE;
                        C_UmuKbn karidSiharaiFlg = C_UmuKbn.NONE;

                        if (BizDateUtil
                            .compareYmd(zenJigyouNendoMatuymd, kariwariatedshrymd[2]) == BizDateUtil.COMPARE_LESSER) {

                            if (C_HaitoukinsksKbn.SEISIKI.eq(pKhHaitouKanriLst.get(2).getHaitoukinskskbn())) {

                                seisikiWariateFlg = C_UmuKbn.ARI;
                            }
                            else if (C_HaitoukinsksKbn.KARIDSIHARAI.eq(pKhHaitouKanriLst.get(2).getHaitoukinskskbn())) {

                                karidSiharaiFlg = C_UmuKbn.ARI;
                            }
                            else if (C_HaitoukinsksKbn.KARIWARIATE1.eq(pKhHaitouKanriLst.get(2).getHaitoukinskskbn()) ||
                                C_HaitoukinsksKbn.KARIWARIATE2.eq(pKhHaitouKanriLst.get(2).getHaitoukinskskbn()) ||
                                C_HaitoukinsksKbn.KARIWARIATE3.eq(pKhHaitouKanriLst.get(2).getHaitoukinskskbn()) ||
                                C_HaitoukinsksKbn.KARIWARIATE4.eq(pKhHaitouKanriLst.get(2).getHaitoukinskskbn())) {

                                kariwariateFlg = C_UmuKbn.ARI;
                            }
                        }

                        if (C_UmuKbn.ARI.eq(seisikiWariateFlg)) {

                            znnndKrksKrwratdRuigk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
                        }
                        else if (C_UmuKbn.ARI.eq(karidSiharaiFlg)) {

                            znnndKrksKrwratdRuigk = calcWrmdsKngk(
                                pKhHaitouKanriLst.get(2).getKariwariatedruigk(),
                                zenJigyouNendoMatuymd,
                                kariwariatedshrymd[2],
                                ZNNNDKRKSKRWRATDRUIGK,
                                pHoyuuMeisai.getSyono(),
                                pBatchParam);
                        }
                        else if (C_UmuKbn.ARI.eq(kariwariateFlg)) {

                            znnndKrksKrwratdRuigk = calcWrmdsKngk(
                                pKhHaitouKanriLst.get(2).getKariwariatedruigk()
                                .subtract(pKhHaitouKanriLst.get(2).getTounendod()),
                                zenJigyouNendoMatuymd,
                                pKhHaitouKanriLst.get(2).getKariwariatedshrymd(),
                                ZNNNDKRKSKRWRATDRUIGK,
                                pHoyuuMeisai.getSyono(),
                                pBatchParam);
                        }
                        else {

                            znnndKrksKrwratdRuigk = calcWrmdsKngk(
                                pKhHaitouKanriLst.get(1).getKariwariatedruigk()
                                .subtract(pKhHaitouKanriLst.get(1).getTounendod()),
                                zenJigyouNendoMatuymd,
                                pKhHaitouKanriLst.get(1).getKariwariatedshrymd(),
                                ZNNNDKRKSKRWRATDRUIGK,
                                pHoyuuMeisai.getSyono(),
                                pBatchParam);
                        }
                    }
                }
            }
        }

        BizCurrency tounendoKariwariateD = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (SEISIKIWARIATENENDOHYJ_NONE.equals(seisikiWariateNendoHyj)) {

            if (BizDateUtil.compareYmd(zenJigyouNendoMatuymd, kariwariatedshrymd[0]) == BizDateUtil.COMPARE_LESSER) {

                if (!C_HaitoukinsksKbn.KARIDSIHARAI.eq(pKhHaitouKanriLst.get(0).getHaitoukinskskbn())) {

                    tounendoKariwariateD = pKhHaitouKanriLst.get(0).getTounendod();
                }
            }
        }
        else {

            if (C_HaitoukinsksKbn.SEISIKI.eq(pKhHaitouKanriLst.get(0).getHaitoukinskskbn())) {

                tounendoKariwariateD = (pKhHaitouKanriLst.get(1).getKariwariatedruigk().subtract(pKhHaitouKanriLst
                    .get(1).getTounendod())).multiply(-1);
            }
            else {

                tounendoKariwariateD = pKhHaitouKanriLst.get(1).getKariwariatedruigk()
                    .subtract(pKhHaitouKanriLst.get(1).getTounendod());

                if (pKhHaitouKanriLst.size() > 2 &&
                    BizDateUtil.compareYmd(zenJigyouNendoMatuymd, kariwariatedshrymd[2]) == BizDateUtil.COMPARE_LESSER) {

                    if (C_HaitoukinsksKbn.KARIWARIATE1.eq(pKhHaitouKanriLst.get(2).getHaitoukinskskbn()) ||
                        C_HaitoukinsksKbn.KARIWARIATE2.eq(pKhHaitouKanriLst.get(2).getHaitoukinskskbn()) ||
                        C_HaitoukinsksKbn.KARIWARIATE3.eq(pKhHaitouKanriLst.get(2).getHaitoukinskskbn()) ||
                        C_HaitoukinsksKbn.KARIWARIATE4.eq(pKhHaitouKanriLst.get(2).getHaitoukinskskbn())) {

                        tounendoKariwariateD = (tounendoKariwariateD.subtract(pKhHaitouKanriLst.get(2).getTounendod()))
                            .multiply(-1);
                    }
                    else if (C_HaitoukinsksKbn.KARIDSIHARAI.eq(pKhHaitouKanriLst.get(2).getHaitoukinskskbn())) {

                        tounendoKariwariateD = tounendoKariwariateD.multiply(-1);
                    }
                }
                else{

                    tounendoKariwariateD = tounendoKariwariateD.multiply(-1);
                }
            }
        }

        BizCurrency tndmatuKrkskrwratdRuigk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        if (SEISIKIWARIATENENDOHYJ_NONE.equals(seisikiWariateNendoHyj)) {

            tndmatuKrkskrwratdRuigk = keisanDGanrikin(
                pKhHaitouKanriLst.get(0).getKariwariatedruigk(),
                kariwariatedshrymd[0],
                pBatchParam.getKijyunymd(),
                TNDMATUKRKSKRWRATDRUIGK,
                pHoyuuMeisai.getSyono(),
                pBatchParam);
        }

        BizCurrency kariwariatedRisoku = tndmatuKrkskrwratdRuigk.subtract(tounendoKariwariateD).subtract(
            znnndKrksKrwratdRuigk);

        pYuukoukykHtjynbknKarid.setSyoriYmd(pBatchParam.getSyoriYmd());
        pYuukoukykHtjynbknKarid.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
        pYuukoukykHtjynbknKarid.setSyono(pHoyuuMeisai.getSyono());
        pYuukoukykHtjynbknKarid.setHknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        pYuukoukykHtjynbknKarid.setHaraikomikaisukbn(hrkkaisuu);
        pYuukoukykHtjynbknKarid.setHrkkeirokbn(hrkkeiro);
        pYuukoukykHtjynbknKarid.setAnnaihuyouriyuukbn(suuriAnnaiFuyouRiyuuKbn.getValue());
        pYuukoukykHtjynbknKarid.setZnnndkrkskrwratdruigk(znnndKrksKrwratdRuigk);
        pYuukoukykHtjynbknKarid.setTounendokariwariated(tounendoKariwariateD);
        pYuukoukykHtjynbknKarid.setTndmatukrkskrwratdruigk(tndmatuKrkskrwratdRuigk);
        pYuukoukykHtjynbknKarid.setKariwariatedrisoku(kariwariatedRisoku);
        pYuukoukykHtjynbknKarid.setHsys(hsys);
        pYuukoukykHtjynbknKarid.setSrkijyunym(String.valueOf(pBatchParam.getKijyunymd().getBizDateYM()));
        if (syouhinbetuSegmentBean != null) {

            pYuukoukykHtjynbknKarid.setKbnkeiriyousegmentkbn(syouhinbetuSegmentBean.getSegcd1().getValue()
                .substring(0, 2));
            pYuukoukykHtjynbknKarid.setKbnkeiriyourgnbnskkbn(syouhinbetuSegmentBean.getSegcd1().getValue()
                .substring(2, 4));
        }
        pYuukoukykHtjynbknKarid.setSeisikiwariatenendohyj(seisikiWariateNendoHyj);
        pYuukoukykHtjynbknKarid.setMankitouraiym(mankitouraiym);
        pYuukoukykHtjynbknKarid.setSyukeiyakusyuruicd(syukeiyakusyuruicd);
        pYuukoukykHtjynbknKarid.setKyknendo(String.valueOf(kyknendo));
        pYuukoukykHtjynbknKarid.setDaihyouyoteiriritu(daihyouyoteiriritu);
        if (suuriHaraikataKbn != null) {
            pYuukoukykHtjynbknKarid.setHaraikatakbn(suuriHaraikataKbn.getValue());
        }
        pYuukoukykHtjynbknKarid.setSrhaitoukinsyuukeiptnkbn(srHaitoukinSyuukeiPtnKbn);

        return errorFlag;
    }

    public void editKoumoku(
        SrYuukouKykHaitoujynbknSelBatchParam pBatchParam,
        SV_HoyuuMeisai pHoyuuMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        int pSyohinHanteiKbn,
        List<SV_KiykSyuhnData> pKiykSyuhnDataLst) {

        hsys = null;
        syouhinbetuSegmentBean = null;
        hrkkaisuu = null;
        hrkkeiro = null;
        suuriAnnaiFuyouRiyuuKbn = null;
        mankitouraiym = null;
        syukeiyakusyuruicd = null;
        kyknendo = null;
        daihyouyoteiriritu = null;
        suuriHaraikataKbn = null;
        srHaitoukinSyuukeiPtnKbn = null;

        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SyouhinbetuSegmentBean wkSyouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

        if (C_ErrorKbn.ERROR.eq(wkSyouhinbetuSegmentBean.getErrorKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1007, SrCommonConstants.MSGHYOUJIMOJIRETU_SEGCD,
                pHoyuuMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pHoyuuMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pBatchParam.setErrorSyoriKensuu(pBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {

            syouhinbetuSegmentBean = wkSyouhinbetuSegmentBean;
        }

        C_Hrkkeiro wkHrkkeiro = pHoyuuMeisai.getHrkkeiro();
        C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn = pHoyuuMeisai.getTikiktbrisyuruikbn();
        C_Hrkkaisuu wkHrkkaisuu = pHoyuuMeisai.getHrkkaisuu();

        if (!C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            SrGetTokutejitenKykKihonInfo srGetTokutejitenKykKihonInfo = SWAKInjector
                .getInstance(SrGetTokutejitenKykKihonInfo.class);
            SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
                C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN,
                pHoyuuMeisai.getSyono(),
                pBatchParam.getKijyunymd(),
                null,
                pKiykSyuhnDataLst,
                pHoyuuMeisai.getTikiktbrisyuruikbn(),
                pHoyuuMeisai.getHrkkeiro(),
                pHoyuuMeisai.getHrkkaisuu());
            tkiktbrisyuruiKbn = srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae();
            wkHrkkeiro = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();
            wkHrkkaisuu = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                hsys = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
            }
            else {

                hsys = pTkJitenKeiyakuSyouhinKijyunBean.getKihons().convCurrencyType(
                    BizCurrencyTypes.YEN,
                    BizNumber.valueOf(SrCommonConstants.INT_VALUE_100));
            }
        }

        else if (pSyohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            if (C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {

                hsys = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
            }
            else {

                hsys = pTkJitenKeiyakuSyouhinKijyunBean.getKihons().convCurrencyType(
                    BizCurrencyTypes.YEN,
                    BizNumber.valueOf(SrCommonConstants.INT_VALUE_100));
            }
        }
        else if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                hsys = BizCurrency.valueOf(0);
            }
            else {

                hsys = BizCurrency.valueOf(0);
            }
        }
        else if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            hsys = BizCurrency.valueOf(0);
        }

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.HRK_KAISUU, wkHrkkaisuu.getValue());
        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KAISUU.getContent(),
                pHoyuuMeisai.getSyono(), wkHrkkaisuu.getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pHoyuuMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pBatchParam.setErrorSyoriKensuu(pBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {

            hrkkaisuu = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.HRK_KEIRO, wkHrkkeiro.getValue());
        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KEIRO.getContent(),
                pHoyuuMeisai.getSyono(), wkHrkkeiro.getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pHoyuuMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pBatchParam.setErrorSyoriKensuu(pBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {

            hrkkeiro = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            suuriAnnaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ITIJI;
        }
        else {

            suuriAnnaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ANNAITYUU;
        }

        if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            mankitouraiym = pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getBizDateYM();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(C_SrKbnHenkanKbn.SYOKEIYAKU,
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());
        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1006, C_SrKbnHenkanKbn.SYOKEIYAKU.getContent(),
                pHoyuuMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pHoyuuMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pBatchParam.setErrorSyoriKensuu(pBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {

            syukeiyakusyuruicd = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getMonth() <= SrCommonConstants.MONTH_MARCH) {

            kyknendo = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateY().addYears(-SrCommonConstants.YEAR_1Y);
        }
        else {

            kyknendo = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateY();
        }

        if (pSyohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);
            getYoteirirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            getYoteirirituBean.setKijyunymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            getYoteirirituBean.setSknnkaisiymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            getYoteirirituBean.setKykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            getYoteirirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
            getYoteirirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());
            getYoteirirituBean.setSitihsyuriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt());
            getYoteirirituBean.setTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            C_ErrorKbn errorKbn = getYoteiriritu.exec(getYoteirirituBean);
            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001, DAIHYOUYOTEIRIRITU, pHoyuuMeisai.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pHoyuuMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pBatchParam.setErrorSyoriKensuu(pBatchParam.getErrorSyoriKensuu() + 1);
                errorFlag = true;
            }
            else {

                daihyouyoteiriritu = getYoteiriritu.getYoteiriritu().multiply(SrCommonConstants.INT_VALUE_100);
            }
        }
        else if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            if (pSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

                daihyouyoteiriritu = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu().multiply(
                    SrCommonConstants.INT_VALUE_100);
            }
        }
        else {

            daihyouyoteiriritu = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu().multiply(
                SrCommonConstants.INT_VALUE_100);
        }

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            suuriHaraikataKbn = C_SuuriHaraikataKbn.ITIJI;
        }
        else {

            if (C_Hrkkaisuu.TUKI.eq(wkHrkkaisuu)) {

                if (C_Hrkkeiro.HURIKAE.eq(wkHrkkeiro)) {

                    suuriHaraikataKbn = C_SuuriHaraikataKbn.TIZUKI;
                }
                else if (C_Hrkkeiro.KOUHURI.eq(wkHrkkeiro)) {

                    suuriHaraikataKbn = C_SuuriHaraikataKbn.BANKZUKI;
                }
                else if (C_Hrkkeiro.CREDIT.eq(wkHrkkeiro)) {

                    suuriHaraikataKbn = C_SuuriHaraikataKbn.CREDIT;
                }
            }

            else if (C_Hrkkaisuu.HALFY.eq(wkHrkkaisuu)) {

                suuriHaraikataKbn = C_SuuriHaraikataKbn.HALFY;
            }

            else if (C_Hrkkaisuu.NEN.eq(wkHrkkaisuu)) {

                suuriHaraikataKbn = C_SuuriHaraikataKbn.NEN;
            }
        }

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            srHaitoukinSyuukeiPtnKbn = C_SrHaitoukinSyuukeiPtnKbn.ITIJI;
        }
        else if (C_Kykjyoutai.HARAIMAN.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            srHaitoukinSyuukeiPtnKbn = C_SrHaitoukinSyuukeiPtnKbn.HARAIMAN;
        }
        else if (C_Kykjyoutai.HARAIZUMI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            srHaitoukinSyuukeiPtnKbn = C_SrHaitoukinSyuukeiPtnKbn.HARAIZUMI;
        }
        else if (C_Kykjyoutai.ENTYOU.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            srHaitoukinSyuukeiPtnKbn = C_SrHaitoukinSyuukeiPtnKbn.ENTYOU;
        }
        else if (C_Kykjyoutai.PMEN.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            srHaitoukinSyuukeiPtnKbn = C_SrHaitoukinSyuukeiPtnKbn.SYGIPMEN;
        }
        else {

            if (C_Hrkkaisuu.NEN.eq(wkHrkkaisuu)) {

                srHaitoukinSyuukeiPtnKbn = C_SrHaitoukinSyuukeiPtnKbn.NENBARAI;
            }
            else if (C_Hrkkaisuu.HALFY.eq(wkHrkkaisuu)) {

                srHaitoukinSyuukeiPtnKbn = C_SrHaitoukinSyuukeiPtnKbn.HANNENBARAI;
            }
            else {

                if (C_Hrkkeiro.DANTAI.eq(wkHrkkeiro)) {

                    srHaitoukinSyuukeiPtnKbn = C_SrHaitoukinSyuukeiPtnKbn.DANTUKI;
                }
                else {

                    srHaitoukinSyuukeiPtnKbn = C_SrHaitoukinSyuukeiPtnKbn.TIZUKI;
                }
            }
        }
    }

    private BizCurrency keisanDGanrikin(
        BizCurrency pRuigk,
        BizDate pCalckijyunfromymd,
        BizDate pCalckijyuntoymd,
        String pKoumoku,
        String pSyono,
        SrYuukouKykHaitoujynbknSelBatchParam pBatchParam) {

        KeisanDGanrikin keisanDGanrikin = SWAKInjector.getInstance(KeisanDGanrikin.class);
        C_ErrorKbn errorKbn = keisanDGanrikin.exec(pRuigk, pCalckijyunfromymd, pCalckijyuntoymd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1001, KEISANDGANRIKIN + pKoumoku + KAKKO_RIGHT, pSyono);

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSyono);
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pBatchParam.setErrorSyoriKensuu(pBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;

            return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }

        return keisanDGanrikin.getDGanrikin();

    }

    private BizCurrency calcWrmdsKngk(
        BizCurrency pWrmdsBfGk,
        BizDate pCalckijyunfromymd,
        BizDate pCalckijyuntoymd,
        String pKoumoku,
        String pSyono,
        SrYuukouKykHaitoujynbknSelBatchParam pBatchParam) {

        if (pWrmdsBfGk.compareTo(BizCurrency.valueOf(
            SrCommonConstants.DEFAULT_INT_ZERO, pWrmdsBfGk.getType())) == 0) {

            return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }

        GetDRiritu getDRiritu = SWAKInjector.getInstance(GetDRiritu.class);
        List<BizNumber> dRirituLst = new ArrayList<BizNumber>();

        C_ErrorKbn errorKbn = getDRiritu.exec(pCalckijyunfromymd, pCalckijyuntoymd);
        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1001, KEISANWRMDS + pKoumoku + KAKKO_RIGHT, pSyono);

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSyono);
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pBatchParam.setErrorSyoriKensuu(pBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;

            return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }

        BizNumber dRiritu = getDRiritu.getDRiritu();
        dRirituLst.add(dRiritu);

        KeisanDCommon keisanDCommon = SWAKInjector.getInstance(KeisanDCommon.class);
        BizCurrency wrmdsAfGk = keisanDCommon.calcWrmdsKngk(pWrmdsBfGk, dRirituLst);

        return wrmdsAfGk;
    }


    private BizDate[] getKariwariatedshrymd(List<IT_KhHaitouKanri> pKhHaitouKanriLst, List<SV_KiykSyuhnData> pKiykSyuhnDataLst){

        BizDate[] haitoYmd = new BizDate[pKhHaitouKanriLst.size()];

        for(int i = 0; i < pKhHaitouKanriLst.size(); i++){

            if (C_HaitoukinsksKbn.KARIDSIHARAI.eq(pKhHaitouKanriLst.get(i).getHaitoukinskskbn())){

                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector
                    .getInstance(SrGetTokutejitenSyohnInfo.class);

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    pKhHaitouKanriLst.get(i).getSyono(),
                    pKhHaitouKanriLst.get(i).getKariwariatedshrymd(),
                    "",
                    pKiykSyuhnDataLst).getTkJitenKeiyakuSyouhinKijyunBeanAto();

                BizDateMD outouMd = null;

                if (tkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null){

                    outouMd = tkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd().getBizDateMD();
                }

                else{
                    outouMd = tkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateMD();
                }

                BizDateY haitoYear = null;

                if (outouMd.getMonth() <= SrCommonConstants.MONTH_MARCH){

                    haitoYear = pKhHaitouKanriLst.get(i).getHaitounendo().addYears(SrCommonConstants.YEAR_1Y);
                }
                else{

                    haitoYear = pKhHaitouKanriLst.get(i).getHaitounendo();

                }

                haitoYmd[i] = BizDate.valueOf(haitoYear, outouMd).getRekijyou();

            }
            else{

                haitoYmd[i] = pKhHaitouKanriLst.get(i).getKariwariatedshrymd();
            }
        }

        return haitoYmd;
    }
}