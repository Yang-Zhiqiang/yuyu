package yuyu.batch.suuri.srsuuritoukei.sridoumeisai;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanGaikaP;
import yuyu.common.hozen.khcommon.KeisanKihrkP;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknOverNnd;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknYendtHnk;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.KykDairitenByPkBean;
import yuyu.common.suuri.srcommon.SetErrMessageInfoBean;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrDateUtil;
import yuyu.common.suuri.srcommon.SrGetTokutejitenAnsyuKihonInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfoBean;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTokuyakuInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTokuyakuInfoBean;
import yuyu.common.suuri.srcommon.SrSuuriGouseiRateKeisan;
import yuyu.common.suuri.srcommon.SrSuuriGouseiRateKeisanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.common.suuri.srcommon.SrSuuriKeisanVHeijyun;
import yuyu.common.suuri.srcommon.SrTmttknBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ALMSoftKbn;
import yuyu.def.classification.C_DaiKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GetTaisyouSonotaTokuyakuKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_HosyouKinouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IdouRecordKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_KykKihonTokuteiJitenKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SkeiSoftKbn;
import yuyu.def.classification.C_SonotaTkTokuteiJitenKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriAnnaiFuyouRiyuuKbn;
import yuyu.def.classification.C_SuuriHaraikataKbn;
import yuyu.def.classification.C_SuuriIdoKbn;
import yuyu.def.classification.C_SuuriPWaribikitekiyouKbn;
import yuyu.def.classification.C_SuuriRyourituKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyouKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_TyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_PMinyuuSyoumetuInfo;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_IdouMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_IdouMeisaiTy;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;
import yuyu.def.suuri.configuration.YuyuSuuriConfig;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 異動明細情報作成
 */
public class SrIdouMeisaiBatchEdit {

    private int rdCTR = 1;

    private Boolean errorFlag;

    private BM_SyouhnZokusei bmSyouhnZokusei;

    @Inject
    private BatchLogger batchLogger;

    private static final String DIFFNENDO = "1";

    private static final String DIFFHALFNENDO = "2";

    private static final String DIFF1STQ = "3";

    private static final String DIFF3RDQ = "4";

    private static final String DIFFOTHERQ = "0";

    private static final String INITSBJIYENKASAITEIHSYGK = "initsbjiyenkasaiteihsygk";

    private static final String TARGETTKMOKUHYOUTI = "targettkmokuhyouti";

    private static final String TARGETTKYKKIJYUNGK = "targettkykkijyungk";

    private static final String ITKYKSONOTATKYK = "IT_KykSonotaTkyk";
    private final String ZNKIDOUTSKBN_JIGYOUNENDOMATU = "1";

    private final String ZNKIDOUTSKBN_HANKIKSN = "2";

    private final String ZNKIDOUTSKBN_1QKSN = "3";

    private final String ZNKIDOUTSKBN_3QKSN = "4";

    private final String SIHARAITUUKAKBN_YEN = "1";

    private BizCurrency initsbjiyenkasaiteihsygk = null;

    private int endttargetmokuhyourituplusrecord = 0;

    private BizCurrency endttargetkijyungkplusrecord = null;

    private BizDate denYmdPlusRecord = null;

    private BizDateYM jkipjytym;

    private BizDateYM jkipjytymPlusRecord;

    private BizDate heijyunKouryokukaisiYmd;

    private String tikikktbrijyututksu;

    private String tikikktbrijyututksuPlusRecord;

    private BizCurrency pTumitatekinNykn;

    private BizCurrency kihrkmpstgkNykn;

    private BizNumber yoteirirituNykn;

    private BizNumber vhireilrituNykn;

    private BizCurrency pTumitatekinRiron;

    private BizCurrency kihrkmpstgkRiron;

    private BizCurrency pTumitatekinNenkin;

    private BizCurrency gaikadateSyukeiyakuP;

    private BizDate idoubetuKijyunYmd;

    private BizCurrency nkgns;

    private Boolean zenkiIdouTeiseiKbnSetFlag;

    private C_Hrkkeiro hrkkeiro;

    private C_Hrkkeiro hrkkeiroPlusRecord;

    private String hhkdrtkykarihyjPlusRecord;

    private String kykdrtkykarihyjPlusRecord;

    private C_Hrkkaisuu hrkkaiSuu;

    private C_Hrkkaisuu hrkkaiSuuPlusRecordn;

    public Boolean editKoumoku(SrIdouMeisaiBatchParam pSrIdouMeisaiBatchParam, SV_IdouMeisai pIdouMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean, ZT_IdouMeisaiTy pZTIdouMeisaiTy,
        C_SuuriIdoKbn pCSuuriIdoKbn, C_IdouRecordKbn pCIdouRecordKbn, BizDate pKouryokuhasseiymd,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn, int pSyouhinZokusei,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn, BizDate pTmttkinInfoSyutokuKijyunYmd,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst, List<IT_KykSyouhnHnkmae> pKykSyouhnHnkmaeLst,
        List<IT_HokenryouTmttkn> pHokenryouTmttknLst, String pNaibuRcdKbn,
        BizDate pNbHoseiSyoriYmd, String pNbHoseiHenkSkbtkey) {

        errorFlag = false;

        SrIdouMeisaiBatchDbAccess srIdouMeisaiBatchDbAccess = SWAKInjector.
            getInstance(SrIdouMeisaiBatchDbAccess.class);

        bmSyouhnZokusei = srIdouMeisaiBatchDbAccess.getSyouhnZokusei(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());

        jkipjytym = null;
        heijyunKouryokukaisiYmd = null;
        tikikktbrijyututksu = "0";
        pTumitatekinNykn = BizCurrency.valueOf(0);
        kihrkmpstgkNykn = BizCurrency.valueOf(0);
        yoteirirituNykn = BizNumber.ZERO;
        vhireilrituNykn = BizNumber.ZERO;
        pTumitatekinRiron = BizCurrency.valueOf(0);
        kihrkmpstgkRiron = BizCurrency.valueOf(0);
        pTumitatekinNenkin = BizCurrency.valueOf(0);
        gaikadateSyukeiyakuP = BizCurrency.valueOf(0);
        zenkiIdouTeiseiKbnSetFlag = false;
        hrkkeiro = null;
        hrkkaiSuu = C_Hrkkaisuu.BLNK;

        if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ) {

            setHanteiZenkiIdouTeiseiKbn(pSrIdouMeisaiBatchParam,
                pIdouMeisai,
                pTkJitenKeiyakuSyouhinKijyunBean,
                pCSuuriIdoKbn);
        }

        if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN){
            getHeijyunKytInfo(pSrIdouMeisaiBatchParam,
                pIdouMeisai,
                pTkJitenKeiyakuSyouhinKijyunBean,
                pCSuuriIdoKbn,
                pCIdouRecordKbn,
                pSvKiykSyuhnDataLst,
                pHokenryouTmttknLst,
                pKouryokuhasseiymd,
                pSyouhinZokusei);
        }

        editCommonData(
            pSrIdouMeisaiBatchParam,
            pIdouMeisai,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pZTIdouMeisaiTy,
            pCSuuriIdoKbn,
            pCIdouRecordKbn,
            pKouryokuhasseiymd,
            pIdouMeisaiTyukeiyouItzHzn,
            pSyouhinZokusei,
            pKhSisuurendoTmttkn,
            pTmttkinInfoSyutokuKijyunYmd,
            pSvKiykSyuhnDataLst,
            pNaibuRcdKbn,
            pNbHoseiSyoriYmd);

        editAlmData(
            pSrIdouMeisaiBatchParam,
            pIdouMeisai,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pCSuuriIdoKbn,
            pCIdouRecordKbn,
            pKouryokuhasseiymd,
            pZTIdouMeisaiTy,
            pIdouMeisaiTyukeiyouItzHzn,
            pSyouhinZokusei,
            pKhSisuurendoTmttkn,
            pSvKiykSyuhnDataLst);

        editHeaderData(
            pSrIdouMeisaiBatchParam,
            pZTIdouMeisaiTy,
            pIdouMeisaiTyukeiyouItzHzn,
            pSyouhinZokusei,
            pTkJitenKeiyakuSyouhinKijyunBean);

        editRayData(
            pSrIdouMeisaiBatchParam,
            pIdouMeisai,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pCSuuriIdoKbn,
            pCIdouRecordKbn,
            pZTIdouMeisaiTy,
            pKouryokuhasseiymd,
            pIdouMeisaiTyukeiyouItzHzn,
            pSyouhinZokusei,
            pKhSisuurendoTmttkn,
            pTmttkinInfoSyutokuKijyunYmd,
            pSvKiykSyuhnDataLst,
            pKykSyouhnHnkmaeLst,
            pNaibuRcdKbn,
            pNbHoseiSyoriYmd,
            pNbHoseiHenkSkbtkey);

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {

            editIdouMeisaiTyukeiyouItzHznData(
                pSrIdouMeisaiBatchParam,
                pIdouMeisai,
                pTmttkinInfoSyutokuKijyunYmd,
                pIdouMeisaiTyukeiyouItzHzn,
                pNaibuRcdKbn,
                pNbHoseiHenkSkbtkey);

        }
        return errorFlag;
    }

    private void editCommonData(SrIdouMeisaiBatchParam pSrIdouMeisaiBatchParam, SV_IdouMeisai pIdouMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean, ZT_IdouMeisaiTy pZTIdouMeisaiTy,
        C_SuuriIdoKbn pCSuuriIdoKbn, C_IdouRecordKbn pCIdouRecordKbn,
        BizDate pKouryokuhasseiymd, ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn, int pSyouhinZokusei,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn, BizDate pTmttkinInfoSyutokuKijyunYmd,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst,
        String pNaibuRcdKbn, BizDate pNbHoseiSyoriYmd) {

        String syoriymd = pIdouMeisai.getSyoriYmd().toString();
        String year = syoriymd.substring(2, 4);
        String from = syoriymd.substring(0, 4) + SrCommonConstants.FIXEDDAY_NENSYOBI;
        String to = syoriymd;
        String day = String.format("%03d", BizDateUtil.calcDifferenceDays(BizDate.valueOf(to), BizDate.valueOf(from)));
        String renno = String.format("%02d", pSrIdouMeisaiBatchParam.getKeiyakuMFkoushinCTRrenban());
        String keiyakuMFkoushinCTR = year + day + renno;

        if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pNaibuRcdKbn) ||
            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(pNaibuRcdKbn) ||
            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pNaibuRcdKbn) ||
            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(pNaibuRcdKbn) ||
            SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(pNaibuRcdKbn) ||
            SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITSRECORD.equals(pNaibuRcdKbn)) {

            if (pNbHoseiSyoriYmd != null) {
                year = pNbHoseiSyoriYmd.getBizDateY().toString().substring(2, 4);
                from = pNbHoseiSyoriYmd.getBizDateY().toString() + SrCommonConstants.FIXEDDAY_NENSYOBI;
                to = pNbHoseiSyoriYmd.toString();
            }

            day = String.format("%03d", BizDateUtil.calcDifferenceDays(BizDate.valueOf(to), BizDate.valueOf(from)));
            keiyakuMFkoushinCTR = year + day + renno;
        }

        int wkdCTR = rdCTR;
        rdCTR++;

        BizDate taisyouymd = null;
        BizDate kouryokukaisiymd = null;
        BizDate denymd = BizDate.MIN_VALUE;
        String idoujiyuucd = "";
        BizCurrency sibous = BizCurrency.valueOf(0);
        String suuriSyuruiCd = "";
        String sedaiKbn = "";
        String bosyuKeitaiKbn = "";
        String haitouKbn = "";
        String hhknnentysihyj = "";
        String kyksyaagetyouseihyj = "";
        BizCurrency shukeiyakushiharaikingaku = BizCurrency.valueOf(0);
        C_HosyouKinouKbn hosyouKinouKbn = C_HosyouKinouKbn.BLNK;
        C_DaiKbn  daiKbn = C_DaiKbn.BLNK;
        C_TyuuKbn tyuuKbn = C_TyuuKbn.BLNK;
        C_SyouKbn syouKbn = C_SyouKbn.BLNK;
        String saimankiKykHyouji = "";
        BizCurrency syuP = BizCurrency.valueOf(0);
        BizCurrency kihonS = BizCurrency.valueOf(0);
        C_ALMSoftKbn aLMSoftKbn = C_ALMSoftKbn.BLNK;
        C_SkeiSoftKbn skeiSoftKbn = null;
        Integer nenkinKaisiNendo = null;
        String nenkingataKbn = "";
        String nkShrKkn = null;
        String sinsaKbn = "";
        String toukeiyouSinsaKbn = "";
        BizCurrency sibouKyuuhukin = BizCurrency.valueOf(0);

        if (C_SuuriIdoKbn.KAIYAKU.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.GENGAKU.eq(pCSuuriIdoKbn)) {

            if (pIdouMeisai.getSyoruiukeymd() != null) {

                taisyouymd = pIdouMeisai.getSyoruiukeymd();
            }
        }

        if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn) && C_SyoriKbn.SEIBETUHENKOU.eq(pIdouMeisai.getSyorikbn())) {

            if (pIdouMeisai.getSyoriYmd() != null) {

                taisyouymd = pIdouMeisai.getSyoriYmd();
            }
        }

        if (C_SuuriIdoKbn.KAIJO.eq(pCSuuriIdoKbn)) {

            if (pIdouMeisai.getKouryokuhasseiymd() != null) {

                taisyouymd = pIdouMeisai.getKouryokuhasseiymd();
            }
        }

        if (C_SuuriIdoKbn.SBKAIJO.eq(pCSuuriIdoKbn)) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd() != null) {

                taisyouymd = pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd();
            }
        }

        if (C_SuuriIdoKbn.KAIYAKU.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.GENGAKU.eq(pCSuuriIdoKbn)
            || C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn) ||
            (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn) && C_SyoriKbn.SEIBETUHENKOU.eq(pIdouMeisai.getSyorikbn()))
            || C_SuuriIdoKbn.KAIJO.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.SBKAIJO.eq(pCSuuriIdoKbn)) {

            if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

                if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() <= taisyouymd.getDay()) {

                    if (taisyouymd.getDay() - pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() >= 15) {

                        kouryokukaisiymd = BizDate.valueOf(taisyouymd.getNextMonth().getBizDateYM(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                    else {

                        kouryokukaisiymd = BizDate.valueOf(taisyouymd.getBizDateYM(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                }
                else {

                    if (taisyouymd.getDay() + 30 - pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() >= 15) {

                        kouryokukaisiymd = BizDate.valueOf(taisyouymd.getBizDateYM(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                    else {

                        kouryokukaisiymd = BizDate.valueOf(taisyouymd.getPreviousMonth().getBizDateYM(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                }
            }
            else {

                kouryokukaisiymd = heijyunKouryokukaisiYmd;
            }
        }
        else if (C_SuuriIdoKbn.KYKTORIKESI.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.CLGOFF.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.MUKOU.eq(pCSuuriIdoKbn)) {

            kouryokukaisiymd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
        }
        else if (C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.YENDTHENKOU.eq(pCSuuriIdoKbn)||
            C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.SISUUTUMIMASI.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.TEIRITUITEN.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.TEIRITUITENTRKS.eq(pCSuuriIdoKbn)) {

            kouryokukaisiymd = pKouryokuhasseiymd;
        }
        else if (C_SuuriIdoKbn.PMINYUUSYOUMETU.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.HARAIKATAHNK.eq(pCSuuriIdoKbn)) {

            kouryokukaisiymd = heijyunKouryokukaisiYmd;
        }

        else {

            kouryokukaisiymd = pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd();
        }

        SrIdouMeisaiBatchDbAccess srIdouMeisaiBatchDbAccess = SWAKInjector.getInstance(SrIdouMeisaiBatchDbAccess.class);

        if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn) ||
            (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn) && C_SyoriKbn.SEIBETUHENKOU.eq(pIdouMeisai.getSyorikbn()))
            || C_SuuriIdoKbn.MENSEKI.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.GENGAKU.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.PMINYUUSYOUMETU.eq(pCSuuriIdoKbn)) {

            if (pIdouMeisai.getTyakkinymd() != null) {

                denymd = pIdouMeisai.getTyakkinymd();
            }
            else {

                if (pIdouMeisai.getSyoriYmd() != null) {

                    denymd = pIdouMeisai.getSyoriYmd();
                }
            }
        }
        else if (C_SuuriIdoKbn.SBMUKOU_SHRNASI.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.MUKOU.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.SISUUTUMIMASI.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.TEIRITUITEN.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.TEIRITUITENTRKS.eq(pCSuuriIdoKbn)||C_SuuriIdoKbn.HARAIKATAHNK.eq(pCSuuriIdoKbn)) {

            if (pIdouMeisai.getSyoriYmd() != null) {

                denymd = pIdouMeisai.getSyoriYmd();
            }

            if (C_SuuriIdoKbn.SISUUTUMIMASI.eq(pCSuuriIdoKbn)) {
                if (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITSRECORD.equals(pNaibuRcdKbn)) {
                    denymd = pNbHoseiSyoriYmd;
                }
            }

            if (C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(pCSuuriIdoKbn)) {
                if (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(pNaibuRcdKbn)) {
                    denymd = pNbHoseiSyoriYmd;
                }
            }
        }
        else if (C_SuuriIdoKbn.YENDTHENKOU.eq(pCSuuriIdoKbn)) {
            if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                BT_DenpyoData denpyoData = srIdouMeisaiBatchDbAccess.getDenpyoDataDenYmd(pIdouMeisai.getSyono(), pIdouMeisai.getSyoriYmd());

                if (denpyoData != null) {

                    denymd = denpyoData.getDenymd();

                    denYmdPlusRecord = denpyoData.getDenymd();
                }
                else {

                    denymd = BizDate.MIN_VALUE;

                    denYmdPlusRecord = BizDate.MIN_VALUE;
                }
            }
            else if (C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)) {
                denymd = denYmdPlusRecord;
            }
        }
        else if (C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(pCSuuriIdoKbn)) {

            denymd = pIdouMeisai.getSyoriYmd();

            if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pNaibuRcdKbn) ||
                SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(pNaibuRcdKbn)   ||
                SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pNaibuRcdKbn) ||
                SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(pNaibuRcdKbn) ) {
                denymd = pNbHoseiSyoriYmd;
            }
        }

        else {

            if (pIdouMeisai.getTyakkinymd() != null) {

                denymd = pIdouMeisai.getTyakkinymd();
            }
        }

        String toukeikijyKbn = "";

        if (pIdouMeisai.getSkeikeijyouym().getMonth() >= SrCommonConstants.MONTH_APRIL
            && pIdouMeisai.getSkeikeijyouym().getMonth() <= SrCommonConstants.MONTH_JUNE) {

            if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), BizDateYM.valueOf(
                pIdouMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_MARCH)) <= 0) {

                toukeikijyKbn = DIFFNENDO;
            }
            else if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), BizDateYM.
                valueOf(pIdouMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_JULY)) >= 0) {

                toukeikijyKbn = DIFF1STQ;
            }
            else {

                toukeikijyKbn = DIFFOTHERQ;
            }
        }
        else if (pIdouMeisai.getSkeikeijyouym().getMonth() >= SrCommonConstants.MONTH_JULY
            && pIdouMeisai.getSkeikeijyouym().getMonth() <= SrCommonConstants.MONTH_SEPTEMBER) {

            if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), BizDateYM.valueOf(
                pIdouMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_OCTOBER)) >= 0) {

                toukeikijyKbn = DIFFHALFNENDO;
            }
            else if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(),
                BizDateYM.valueOf(
                    pIdouMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_JUNE)) <= 0) {

                toukeikijyKbn = DIFF1STQ;
            }
            else {

                toukeikijyKbn = DIFFOTHERQ;
            }
        }
        else if (pIdouMeisai.getSkeikeijyouym().getMonth() >= SrCommonConstants.MONTH_OCTOBER
            && pIdouMeisai.getSkeikeijyouym().getMonth() <= SrCommonConstants.MONTH_DECEMBER) {

            if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), BizDateYM.valueOf(
                pIdouMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_SEPTEMBER)) <= 0) {

                toukeikijyKbn = DIFFHALFNENDO;
            }

            else if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(),
                BizDateYM.valueOf(pIdouMeisai.getSkeikeijyouym().getNextYear().getYear(),
                    SrCommonConstants.MONTH_JANUARY)) >= 0) {

                toukeikijyKbn = DIFF3RDQ;
            }
            else {

                toukeikijyKbn = DIFFOTHERQ;
            }
        }
        else {

            if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), BizDateYM.valueOf(
                pIdouMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_APRIL)) >= 0) {

                toukeikijyKbn = DIFFNENDO;
            }
            else if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(),
                BizDateYM.valueOf(pIdouMeisai.getSkeikeijyouym().getPreviousYear().getYear(),
                    SrCommonConstants.MONTH_DECEMBER)) <= 0) {

                toukeikijyKbn = DIFF3RDQ;
            }
            else {

                toukeikijyKbn = DIFFOTHERQ;
            }
        }

        AS_Kinou kinou = srIdouMeisaiBatchDbAccess.getKinou(pIdouMeisai.getGyoumuKousinKinou());

        String syoricd = kinou.getSyoricd();

        if (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(pNaibuRcdKbn)) {
            syoricd = srIdouMeisaiBatchDbAccess.getKinou(IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI).getSyoricd();
        }

        if (C_SuuriIdoKbn.KAIYAKU.eq(pCSuuriIdoKbn)) {

            idoujiyuucd = SrCommonConstants.IDOUJIYUCD_KAIYAKU;
        }
        else if (C_SuuriIdoKbn.GENGAKU.eq(pCSuuriIdoKbn)) {

            if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_GENGAKU_MINUS;
            }
            else {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_GENGAKU_PLUS;
            }
        }
        else if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn) ||
            (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn) &&
                C_SyoriKbn.SEIBETUHENKOU.eq(pIdouMeisai.getSyorikbn()))) {

            if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_SEINENGAPPISEI_MINUS;
            }
            else {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_SEINENGAPPISEI_PLUS;
            }
        }
        else if (C_SuuriIdoKbn.KAIJO.eq(pCSuuriIdoKbn)) {

            idoujiyuucd = SrCommonConstants.IDOUJIYUCD_SEIZONKAIJYO;
        }
        else if (C_SuuriIdoKbn.SBKAIJO.eq(pCSuuriIdoKbn)) {

            idoujiyuucd = SrCommonConstants.IDOUJIYUCD_SIBOUKAIJYO;
        }
        else if (C_SuuriIdoKbn.MENSEKI.eq(pCSuuriIdoKbn)) {

            idoujiyuucd = SrCommonConstants.IDOUJIYUCD_MENSEKI;
        }
        else if (C_SuuriIdoKbn.SBMUKOU_KIHRKPSHR.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.SBMUKOU_SHRNASI.eq(pCSuuriIdoKbn)) {

            idoujiyuucd = SrCommonConstants.IDOUJIYUCD_SIBOUMUKOU;
        }
        else if (C_SuuriIdoKbn.SIBOU.eq(pCSuuriIdoKbn)) {

            idoujiyuucd = SrCommonConstants.IDOUJIYUCD_SIBOU;
        }
        else if (C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(pCSuuriIdoKbn)) {

            if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_MINUS;
            }
            else {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_PLUS;
            }
        }
        else if (C_SuuriIdoKbn.YENDTHENKOU.eq(pCSuuriIdoKbn)) {

            if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

                if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                    idoujiyuucd = SrCommonConstants.IDOUJIYUCD_YENDTNNKNHENKOU_MINUS;
                }
                else {

                    idoujiyuucd = SrCommonConstants.IDOUJIYUCD_YENDTNNKNHENKOU_PLUS;
                }
            }
            else {

                if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                    idoujiyuucd = SrCommonConstants.IDOUJIYUCD_YENDTSYSNHENKOU_MINUS;
                }
                else {

                    idoujiyuucd = SrCommonConstants.IDOUJIYUCD_YENDTSYSNHENKOU_PLUS;
                }
            }
        }
        else if (C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pCSuuriIdoKbn)) {

            if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

                if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                    idoujiyuucd = SrCommonConstants.IDOUJIYUCD_YENDTNNKNHENKOUTRKS_MINUS;
                }
                else {

                    idoujiyuucd = SrCommonConstants.IDOUJIYUCD_YENDTNNKNHENKOUTRKS_PLUS;
                }
            }
            else {

                if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                    idoujiyuucd = SrCommonConstants.IDOUJIYUCD_YENDTSYSNHENKOUTRKS_MINUS;
                }
                else {

                    idoujiyuucd = SrCommonConstants.IDOUJIYUCD_YENDTSYSNHENKOUTRKS_PLUS;
                }
            }
        }
        else if (C_SuuriIdoKbn.SISUUTUMIMASI.eq(pCSuuriIdoKbn)) {

            if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_MINUS;
            }
            else {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_PLUS;
            }
        }
        else if (C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(pCSuuriIdoKbn)) {

            if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_MINUS;
            }
            else {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_PLUS;
            }
        }
        else if (C_SuuriIdoKbn.TEIRITUITEN.eq(pCSuuriIdoKbn)) {

            if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_TEIRITUITEN_MINUS;
            }
            else {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_TEIRITUITEN_PLUS;
            }
        }
        else if (C_SuuriIdoKbn.TEIRITUITENTRKS.eq(pCSuuriIdoKbn)) {

            if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_TEIRITUITENTRKS_MINUS;
            }
            else {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_TEIRITUITENTRKS_PLUS;
            }
        }
        else if (C_SuuriIdoKbn.PMINYUUSYOUMETU.eq(pCSuuriIdoKbn)) {

            idoujiyuucd = SrCommonConstants.IDOUJIYUCD_PMINYUUSYOUMETU;
        }
        else if (C_SuuriIdoKbn.HARAIKATAHNK.eq(pCSuuriIdoKbn)) {

            if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_HRHN_MINUS;
            }
            else {

                idoujiyuucd = SrCommonConstants.IDOUJIYUCD_HRHN_PLUS;
            }
        }
        else {

            idoujiyuucd = SrCommonConstants.IDOUJIYUCD_SINKEIYAKUTORIKESI;
        }

        String datakanriNo = pIdouMeisai.getSyono();

        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        String kbnKeiriyouSegmentKbn = "";
        String kbnKeiriyouRgnbnskKbn = "";

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

        if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {
            String msg = MessageUtil.getMessage(MessageId.ESA1007, SrCommonConstants.MSGHYOUJIMOJIRETU_SEGCD,
                pIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {
            kbnKeiriyouSegmentKbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(0, 2);

            kbnKeiriyouRgnbnskKbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(
                syouhinbetuSegmentBean.getSegcd1().getValue().length() - 2,
                syouhinbetuSegmentBean.getSegcd1().getValue().length());
        }

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(
            C_SrKbnHenkanKbn.SUURISYURUI,
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1006, C_SrKbnHenkanKbn.SUURISYURUI.getContent(),
                pIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {

            suuriSyuruiCd = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SEDAI,
            pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.SEDAI.getContent(),
                pIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {

            sedaiKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ) {

            sibous = BizCurrency.valueOf(0);
        }
        else {

            if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                sibous = BizCurrency.valueOf(0);
            }
            else {

                sibous = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
            }
        }

        String todoufukencd =  pIdouMeisai.getDrtenkanritodoufukencd();
        if (C_TodouhukenKbn.BLNK.getValue().equals(todoufukencd)){
            todoufukencd = C_TodouhukenKbn.OSAKA.getValue();
        }

        String kanyujiDatakanriNo = datakanriNo;

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.BOSYU_KEITAI,
            pIdouMeisai.getDrtencd());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                pIdouMeisai.getSyono(), pIdouMeisai.getDrtencd());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {

            bosyuKeitaiKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_HAITOU,
            bmSyouhnZokusei.getHaitoukbn().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.SUURI_HAITOU.getContent(),
                pIdouMeisai.getSyono(), bmSyouhnZokusei.getHaitoukbn().getContent());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {

            haitouKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);

        int hhknHkNenrei = setHokenNenrei.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHhknseiymd());

        if (pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen() != hhknHkNenrei) {

            hhknnentysihyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            hhknnentysihyj = SrCommonConstants.HYOUJI_NASI;
        }

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

        int kyknenAfter = 0;

        int kyknen = setNenrei.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pIdouMeisai.getKykseiymd());

        if (kyknen > 99) {

            kyknenAfter = 0;
        }

        else {

            kyknenAfter = kyknen;
        }

        int kyknenhkn = setHokenNenrei.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pIdouMeisai.getKykseiymd());

        if (kyknen != kyknenhkn) {

            kyksyaagetyouseihyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            kyksyaagetyouseihyj = SrCommonConstants.HYOUJI_NASI;
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            hosyouKinouKbn = C_HosyouKinouKbn.BLNK;
        }
        else {
            hosyouKinouKbn = C_HosyouKinouKbn.SIBOU;
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
                daiKbn = C_DaiKbn.NNKNTKYK_SISUURENDOU;
            }
            else {
                daiKbn = C_DaiKbn.KOJINNENKIN_SISUU;
            }
        }
        else if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            daiKbn = C_DaiKbn.KOJINNENKIN_SISUU;
        }
        else if (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN){
            if (C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {
                daiKbn = C_DaiKbn.SYSN;
            }
            else {
                daiKbn = C_DaiKbn.SITEITUKASYSN;
            }
        }
        else {
            daiKbn = C_DaiKbn.SITEITUKASYSN;
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
                tyuuKbn = C_TyuuKbn.ENKATEIGAKUNNKN;
            }
            else {
                tyuuKbn = C_TyuuKbn.SITEITUKANNKN;
            }
        }
        else if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            tyuuKbn = C_TyuuKbn.YOTEIRRT_SITEITUKANNKN;
        }
        else if (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN){
            if (C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {
                tyuuKbn = C_TyuuKbn.SYSN;
            }
            else {
                tyuuKbn = C_TyuuKbn.SITEITUKASYSN;
            }
        }
        else {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
                tyuuKbn = C_TyuuKbn.YENDATESYSN_HNK;
            }
            else {
                tyuuKbn = C_TyuuKbn.SITEITUKASYSN;
            }
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
                syouKbn = C_SyouKbn.ENKATEIGAKUNNKN;
            }
            else {
                syouKbn = C_SyouKbn.SITEITUKANNKN;
            }
        }
        else if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            syouKbn = C_SyouKbn.YOTEIRRT_SITEITUKANNKN;
        }
        else if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
                syouKbn = C_SyouKbn.SITEITUKASYSN_19_2GATA_HNK;
            }
            else {
                syouKbn = C_SyouKbn.SITEITUKASYSN_19_2GATA;
            }
        }
        else if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            syouKbn = C_SyouKbn.SITEITUKANNKN_20;
        }
        else if (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN){
            if (C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {
                syouKbn = C_SyouKbn.SENTAKUTUKASYSN_JPY;
            }
            else {
                syouKbn = C_SyouKbn.SENTAKUTUKASYSN_USD;
            }
        }
        else {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
                syouKbn = C_SyouKbn.SITEITUKASYSN_HNK;
            }
            else {
                syouKbn = C_SyouKbn.SITEITUKASYSN;
            }
        }

        if (C_HknkknsmnKbn.SAIMANKI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn())) {
            saimankiKykHyouji = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            saimankiKykHyouji = SrCommonConstants.HYOUJI_NASI;
        }

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            syuP = BizCurrency.valueOf(0);
        }
        else {
            syuP = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            kihonS = BizCurrency.valueOf(0);
        }
        else {
            kihonS = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            aLMSoftKbn = C_ALMSoftKbn.BLNK;
        }
        else if (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            aLMSoftKbn = C_ALMSoftKbn.SYSN;
        }
        else {
            aLMSoftKbn = C_ALMSoftKbn.ITIJIBRSYSN;
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            skeiSoftKbn = C_SkeiSoftKbn.TANTAI;
        }
        else {
            skeiSoftKbn = C_SkeiSoftKbn.SONOTA;
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getMonth() >= SrCommonConstants.MONTH_APRIL) {
                nenkinKaisiNendo = pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getYear();
            }
            else{
                nenkinKaisiNendo = pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getYear()
                    - Integer.valueOf(SrCommonConstants.YEAR_1Y);
            }
        }
        else {
            nenkinKaisiNendo = 0;
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.NENKINGATA,
            pTkJitenKeiyakuSyouhinKijyunBean.getNksyukbn().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.NENKINGATA.getContent(),
                pIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getNksyukbn().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;
        }
        else {
            nenkingataKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            if (SrCommonConstants.NENKINKIKAN_SOUGAKUHOSYOUSYUUSHIN == pTkJitenKeiyakuSyouhinKijyunBean.getNenkinkkn()) {
                nkShrKkn = SrCommonConstants.DEFAULT_STRING_ZERO_2;
            }
            else {
                nkShrKkn = pTkJitenKeiyakuSyouhinKijyunBean.getNenkinkkn().toString();
            }
        }
        else {
            nkShrKkn = SrCommonConstants.DEFAULT_STRING_ZERO_2;
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            sinsaKbn = SrCommonConstants.SINSAKBN_SONOTA;
        }
        else {
            sinsaKbn = SrCommonConstants.SINSAKBN_KOKUTI;
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            toukeiyouSinsaKbn = SrCommonConstants.TOUKEIYOUSINSAKBN_MUSENTAKU;
        }
        else {
            toukeiyouSinsaKbn = SrCommonConstants.TOUKEIYOUSINSAKBN_KOKUTISYO;
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), pTmttkinInfoSyutokuKijyunYmd) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), pTmttkinInfoSyutokuKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {

                BizNumber kaiyakusjkkktyouseiriritu = BizNumber.ZERO;
                BizDateYM tmttkntaisyouym = null;
                BizCurrency teiritutmttkngk = BizCurrency.valueOf(0);
                BizCurrency sisuurendoutmttkngk = BizCurrency.valueOf(0);

                if ((C_SuuriIdoKbn.MUKOU.eq(pCSuuriIdoKbn)) && (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {

                    sibouKyuuhukin = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                }
                else {
                    if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu())) {
                        GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
                        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);

                        getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                        getSjkkktyouseiyourirituBean.setKijyunymd(pTmttkinInfoSyutokuKijyunYmd);
                        getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
                        getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
                        getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

                        C_ErrorKbn errorKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            String msg = MessageUtil.getMessage(MessageId.ESA1001, "市場価格調整用利率", pIdouMeisai.getSyono());

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

                            errorFlag = true;
                        }
                        else {
                            kaiyakusjkkktyouseiriritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();

                        }
                    }

                    BizDateYM tmpKijunNengetu = null;


                    if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu())) {

                        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                        tmpKijunNengetu = keisanWKijunYM.exec(
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTmttkinInfoSyutokuKijyunYmd,
                            null,
                            null,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());
                    }

                    if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu())
                        && BizDateUtil.calcDifferenceMonths(tmpKijunNengetu,
                            pKhSisuurendoTmttkn.getTmttkntaisyouym()) > SrCommonConstants.KIKAN_12M) {

                        Integer keikamonGetukansan = BizDateUtil.calcDifferenceMonths(
                            pTmttkinInfoSyutokuKijyunYmd.getBizDateYM(), pKhSisuurendoTmttkn.getTmttkntaisyouym());

                        Integer keikanensuu = keikamonGetukansan / SrCommonConstants.KIKAN_12M;

                        tmttkntaisyouym = pKhSisuurendoTmttkn.getTmttkntaisyouym().addYears(keikanensuu);

                        BizDate tmttkntaisyouYmd = BizDate.valueOf(tmttkntaisyouym, pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();

                        KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd = SWAKInjector
                            .getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

                        C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                            pIdouMeisai.getTeikishrtkykhukaumu(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                            tmttkntaisyouYmd,
                            tmttkntaisyouym,
                            pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                            pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                            pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            String msg = MessageUtil.getMessage(MessageId.ESA1001, "積立金計算：死亡給付金", pIdouMeisai.getSyono());

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

                            errorFlag = true;
                        }
                        else {
                            teiritutmttkngk = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
                            sisuurendoutmttkngk = keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk();
                        }
                    }
                    else {
                        if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu())) {
                            tmttkntaisyouym = pKhSisuurendoTmttkn.getTmttkntaisyouym();
                            teiritutmttkngk = pKhSisuurendoTmttkn.getTeiritutmttkngk();
                            sisuurendoutmttkngk = pKhSisuurendoTmttkn.getSisuurendoutmttkngk();
                        }
                    }

                    if (!errorFlag) {
                        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

                        C_ErrorKbn calcHkShrKngkResultKbn = calcHkShrKngk.exec(
                            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu(),
                            pIdouMeisai.getHrkkaisuu(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKihons(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTmttkinInfoSyutokuKijyunYmd,
                            pIdouMeisai.getSyono(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn(),
                            C_SiinKbn.SP,
                            C_HokenkinsyuruiKbn.SBKYUUHUKIN,
                            pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou(),
                            kaiyakusjkkktyouseiriritu,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu(),
                            tmttkntaisyouym,
                            teiritutmttkngk,
                            sisuurendoutmttkngk,
                            pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                            null,
                            null,
                            null,
                            null,
                            null,
                            null,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                            pIdouMeisai.getSdpdkbn(),
                            pIdouMeisai.getHrkkeiro());

                        if (C_ErrorKbn.ERROR.eq(calcHkShrKngkResultKbn)) {

                            String msg = MessageUtil.getMessage(MessageId.ESA1001, "死亡給付金", pIdouMeisai.getSyono());

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

                            errorFlag = true;
                        }
                        else {
                            sibouKyuuhukin = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();
                        }
                    }
                }
            }
            else {
                sibouKyuuhukin = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();

            }
        }
        else if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN)  {
            sibouKyuuhukin = kihrkmpstgkRiron;
        }
        else {
            sibouKyuuhukin = BizCurrency.valueOf(0);
        }

        if ((C_SuuriIdoKbn.GENGAKU.eq(pCSuuriIdoKbn) && C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) ||
            C_SuuriIdoKbn.KAIYAKU.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.KAIJO.eq(pCSuuriIdoKbn)||
            C_SuuriIdoKbn.SBKAIJO.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.SIBOU.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.PMINYUUSYOUMETU.eq(pCSuuriIdoKbn)) {

            BizNumber kawaserate = BizNumber.valueOf(0);

            BT_DenpyoData denpyoData =
                srIdouMeisaiBatchDbAccess.getDenpyoDataDenYenkagk(pIdouMeisai.getSyono(), pIdouMeisai.getSyoriYmd());

            if (denpyoData != null) {

                shukeiyakushiharaikingaku = denpyoData.getDenyenkagk();
            }
            else {
                shukeiyakushiharaikingaku = BizCurrency.valueOf(0);
            }

            if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  &&
                C_SuuriIdoKbn.GENGAKU.eq(pCSuuriIdoKbn))  {
                if (denpyoData == null) {

                    IT_Azukarikin azukarikin = srIdouMeisaiBatchDbAccess.getAzukarikin(
                        pIdouMeisai.getSyono(),
                        pIdouMeisai.getHenkousikibetukey(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

                    if (azukarikin != null) {
                        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                        C_ErrorKbn errorKbn = getKawaseRate.exec(
                            pIdouMeisai.getSyoruiukeymd(),
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.JISSEIRATE,
                            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            String msg = MessageUtil.getMessage(MessageId.ESA1004,
                                String.valueOf(pIdouMeisai.getSyoruiukeymd()),
                                C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                                C_Tuukasyu.JPY.getValue(),
                                C_KawasetekiyoKbn.TTM.getValue(),
                                C_KawasetsryKbn.JISSEIRATE.getValue(),
                                C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                                C_YouhiKbn.HUYOU.getValue());

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
                            errorFlag = true;
                        }
                        else {

                            kawaserate = getKawaseRate.getKawaserate();
                        }

                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                        shukeiyakushiharaikingaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                            azukarikin.getAzukarikingk(),
                            kawaserate,
                            C_HasuusyoriKbn.SUTE);

                    }
                    else {
                        shukeiyakushiharaikingaku = BizCurrency.valueOf(0);
                    }
                }
            }
            else if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  &&
                C_SuuriIdoKbn.PMINYUUSYOUMETU.eq(pCSuuriIdoKbn))  {

                if (denpyoData == null) {

                    IT_PMinyuuSyoumetuInfo pminyuusyoumetu = srIdouMeisaiBatchDbAccess.getPMinyuuSyoumetuInfo(
                        pIdouMeisai.getSyono());

                    if (pminyuusyoumetu != null) {
                        shukeiyakushiharaikingaku = pminyuusyoumetu.getKaiyakuhryen();
                    }
                }
            }

        }
        else {
            shukeiyakushiharaikingaku = BizCurrency.valueOf(0);
        }

        BizDate mokuhrtHenkNbHoseiSyoriYmd = null;

        mokuhrtHenkNbHoseiSyoriYmd = pIdouMeisai.getSyoriYmd();

        if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pNaibuRcdKbn) ||
            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(pNaibuRcdKbn) ||
            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pNaibuRcdKbn) ||
            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(pNaibuRcdKbn) ||
            SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(pNaibuRcdKbn) ||
            SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITSRECORD.equals(pNaibuRcdKbn)) {

            mokuhrtHenkNbHoseiSyoriYmd = pNbHoseiSyoriYmd;
        }

        String haraikataKbn = "";
        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            haraikataKbn = C_SuuriHaraikataKbn.ITIJI.getValue();
        }
        else {
            if (C_Hrkkaisuu.TUKI.eq(hrkkaiSuu)){
                if (C_Hrkkeiro.HURIKAE.eq(hrkkeiro)) {
                    haraikataKbn = C_SuuriHaraikataKbn.TIZUKI.getValue();
                }
                else if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {
                    haraikataKbn = C_SuuriHaraikataKbn.BANKZUKI.getValue();
                }
                else if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
                    haraikataKbn = C_SuuriHaraikataKbn.CREDIT.getValue();
                }
            }
            else if (C_Hrkkaisuu.HALFY.eq(hrkkaiSuu)) {
                haraikataKbn = C_SuuriHaraikataKbn.HALFY.getValue();
            }
            else if (C_Hrkkaisuu.NEN.eq(hrkkaiSuu)) {
                haraikataKbn = C_SuuriHaraikataKbn.NEN.getValue();
            }
        }

        String annaiFuyouRiyuuKbn = "";
        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            annaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ITIJI.getValue();
        }
        else {
            annaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ANNAITYUU.getValue();
        }

        String hrkKaisuuKbn = "";
        String hrkkaisuu = hrkkaiSuu.getValue();

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            hrkkaisuu = pIdouMeisai.getHrkkaisuu().getValue();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.HRK_KAISUU,
            hrkkaisuu);

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KAISUU.getContent(),
                pIdouMeisai.getSyono(), hrkkaisuu);

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;

        }
        else {
            hrkKaisuuKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String hrkKeiroKbn = "";

        if(C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())){

            hrkKeiroKbn = pIdouMeisai.getHrkkeiro().getValue();
        }
        else{

            hrkKeiroKbn = hrkkeiro.getValue();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.HRK_KEIRO,
            hrkKeiroKbn);

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KEIRO.getContent(),
                pIdouMeisai.getSyono(),
                hrkKeiroKbn);

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;

        }
        else {
            hrkKeiroKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String ryourituKbn = "";
        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            ryourituKbn = C_SuuriRyourituKbn.OTHER.getValue();

        }
        else {
            if (C_Hrkkaisuu.NEN.eq(hrkkaiSuu) || C_Hrkkaisuu.HALFY.eq(hrkkaiSuu)) {
                ryourituKbn = C_SuuriRyourituKbn.OTHER.getValue();
            }
            else {
                if (C_Hrkkeiro.HURIKAE.eq(hrkkeiro)) {
                    ryourituKbn = C_SuuriRyourituKbn.OTHER.getValue();
                }
                else if (C_Hrkkeiro.KOUHURI.eq(hrkkeiro)) {
                    ryourituKbn = C_SuuriRyourituKbn.KOUHURI.getValue();
                }
                else if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {
                    ryourituKbn = C_SuuriRyourituKbn.CREDIT.getValue();
                }
            }
        }

        String syukeiyakuPWaribikiKbn = "";

        if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().compareTo(BizCurrency.valueOf(SrCommonConstants.YEN_15000,
                pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().getType())) < 0) {
                syukeiyakuPWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_NONE.getValue();
            }
            else if (pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().compareTo(BizCurrency.valueOf(SrCommonConstants.YEN_30000,
                pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().getType())) < 0) {
                syukeiyakuPWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_RANK01.getValue();
            }
            else {
                syukeiyakuPWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_RANK02.getValue();
            }
        }
        else {
            syukeiyakuPWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_NONE.getValue();
        }

        String kykJyoutai = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.KYK_JYOUTAI,
            pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.KYK_JYOUTAI.getContent(),
                pIdouMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

            errorFlag = true;

        }
        else {
            kykJyoutai = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        String wkZnkidoutskbn = "";

        if (zenkiIdouTeiseiKbnSetFlag) {

            if (SrCommonConstants.MONTH_MARCH == pSrIdouMeisaiBatchParam.getKijyunymd().getMonth()) {
                wkZnkidoutskbn = ZNKIDOUTSKBN_JIGYOUNENDOMATU;
            } else if (SrCommonConstants.MONTH_SEPTEMBER == pSrIdouMeisaiBatchParam.getKijyunymd().getMonth()) {
                wkZnkidoutskbn = ZNKIDOUTSKBN_HANKIKSN;
            } else if (SrCommonConstants.MONTH_JUNE == pSrIdouMeisaiBatchParam.getKijyunymd().getMonth()) {
                wkZnkidoutskbn = ZNKIDOUTSKBN_1QKSN;
            } else if (SrCommonConstants.MONTH_DECEMBER == pSrIdouMeisaiBatchParam.getKijyunymd().getMonth()) {
                wkZnkidoutskbn = ZNKIDOUTSKBN_3QKSN;
            }
        }

        BizDate henkouymd = null;
        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null
            && pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() != null) {
            henkouymd = pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd();
        }
        else {
            henkouymd = pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd();
        }

        String anniskcd = "";
        if(C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())){

            anniskcd = "";

        }
        else if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {

            anniskcd = SrCommonConstants.ANNISKCD_CREDITHR;
        }

        pZTIdouMeisaiTy.setZtyrecordkbn(SrCommonConstants.RECORDKBN_IDOUMEISAI);
        pZTIdouMeisaiTy.setZtyidourecordkbn(pCIdouRecordKbn.getValue());
        pZTIdouMeisaiTy.setZtykeijyouctrlkbn(SrCommonConstants.KIJYCTRLKBN_SONOTA);
        if (mokuhrtHenkNbHoseiSyoriYmd != null) {
            pZTIdouMeisaiTy.setZtyhenkousyoriymd(mokuhrtHenkNbHoseiSyoriYmd.toString());
        }
        pZTIdouMeisaiTy.setZtykykmfksnctr(Integer.valueOf(keiyakuMFkoushinCTR));
        pZTIdouMeisaiTy.setZtyrecordctr(wkdCTR);
        pZTIdouMeisaiTy.setZtysuuriyoukouryokukaisiymd(kouryokukaisiymd.getRekijyou().toString());
        pZTIdouMeisaiTy.setZtydenymd(denymd.toString());
        pZTIdouMeisaiTy.setZtytoukeikeijyoukbn(toukeikijyKbn);
        pZTIdouMeisaiTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pZTIdouMeisaiTy.setZtyzenkiidouteiseikbn(wkZnkidoutskbn);
        pZTIdouMeisaiTy.setZtybsyym(pIdouMeisai.getBosyuuym().toString());
        pZTIdouMeisaiTy.setZtyidoujiyuucd(idoujiyuucd);
        pZTIdouMeisaiTy.setZtysyoricd(syoricd);
        pZTIdouMeisaiTy.setZtydatakanrino(datakanriNo);
        pZTIdouMeisaiTy.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        pZTIdouMeisaiTy.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
        pZTIdouMeisaiTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
        pZTIdouMeisaiTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pZTIdouMeisaiTy.setZtystdssnskbn(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
        pZTIdouMeisaiTy.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
        pZTIdouMeisaiTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
        pZTIdouMeisaiTy.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
        pZTIdouMeisaiTy.setZtykbnkeiriyousegmentkbn(kbnKeiriyouSegmentKbn);
        pZTIdouMeisaiTy.setZtykbnkeiriyourgnbnskkbn(kbnKeiriyouRgnbnskKbn);
        pZTIdouMeisaiTy.setZtysuurisyuruicd(suuriSyuruiCd);
        pZTIdouMeisaiTy.setZtyhosyoukinoukbn(hosyouKinouKbn.getValue());
        pZTIdouMeisaiTy.setZtydaikbn(daiKbn.getValue());
        pZTIdouMeisaiTy.setZtytyuukbn(tyuuKbn.getValue());
        pZTIdouMeisaiTy.setZtysyoukbn(syouKbn.getValue());
        pZTIdouMeisaiTy.setZtysedaikbn(sedaiKbn);
        pZTIdouMeisaiTy.setZtyharaikatakbn(haraikataKbn);
        pZTIdouMeisaiTy.setZtykykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        pZTIdouMeisaiTy.setZtyhknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().toString());
        pZTIdouMeisaiTy.setZtyphrkkikn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn().toString());
        pZTIdouMeisaiTy.setZtysaimnkkykhyj(saimankiKykHyouji);
        pZTIdouMeisaiTy.setZtyannaifuyouriyuukbn(annaiFuyouRiyuuKbn);
        pZTIdouMeisaiTy.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
        pZTIdouMeisaiTy.setZtyhrkkaisuukbn(hrkKaisuuKbn);
        pZTIdouMeisaiTy.setZtyhrkkeirokbn(hrkKeiroKbn);
        pZTIdouMeisaiTy.setZtysdpdkbn(pIdouMeisai.getSdpdkbn().getValue());
        pZTIdouMeisaiTy.setZtyryouritukbn(ryourituKbn);
        pZTIdouMeisaiTy.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());
        pZTIdouMeisaiTy.setZtyhihokensyaagev2(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        pZTIdouMeisaiTy.setZtykyksyanen(String.valueOf(kyknenAfter));
        pZTIdouMeisaiTy.setZtytkbthsyumnryuhyouji(SrCommonConstants.HYOUJI_NASI);
        pZTIdouMeisaiTy.setZtysyukeiyakupwaribikikbn(syukeiyakuPWaribikiKbn);
        pZTIdouMeisaiTy.setZtytenkanwaribikikbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZTIdouMeisaiTy.setZtyyuuhitutnknyuguryurtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZTIdouMeisaiTy.setZtysyukeiyakup(new BigDecimal(syuP.toAdsoluteString()).longValue());
        pZTIdouMeisaiTy.setZtykihons(new BigDecimal(kihonS.toAdsoluteString()).longValue());
        pZTIdouMeisaiTy.setZtysibous(new BigDecimal(sibous.toAdsoluteString()).longValue());
        if (henkouymd != null) {
            pZTIdouMeisaiTy.setZtyhenkouymd(henkouymd.toString());
        }
        pZTIdouMeisaiTy.setZtysyukeiyakusiharaikingaku(new BigDecimal(shukeiyakushiharaikingaku.toAdsoluteString()).longValue());
        pZTIdouMeisaiTy.setZtyatukaisisyatodouhukencd(todoufukencd);
        pZTIdouMeisaiTy.setZtytokuyakuhukasuu(SrCommonConstants.DEFAULT_INT_ZERO);
        pZTIdouMeisaiTy.setZtyhrimnentyoumaephrkkkn(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pZTIdouMeisaiTy.setZtytokubetuhosyoukikan(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pZTIdouMeisaiTy.setZtykousinmanryouage(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pZTIdouMeisaiTy.setZtykanyujidatakanrino(kanyujiDatakanriNo);
        pZTIdouMeisaiTy.setZtykanyujikykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        pZTIdouMeisaiTy.setZtykanyuujihihokensyaage(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        pZTIdouMeisaiTy.setZtykykjyoutai(kykJyoutai);
        pZTIdouMeisaiTy.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
        pZTIdouMeisaiTy.setZtysykykhokenhoutekiyouhyj(SrCommonConstants.HYOUJI_ARI);
        pZTIdouMeisaiTy.setZtyalmyousohutomeisyoukbn(aLMSoftKbn.getValue());
        pZTIdouMeisaiTy.setZtysnkyksoftmeisyoukbn(skeiSoftKbn.getValue());
        pZTIdouMeisaiTy.setZtynenkinkaisinendo(String.valueOf(nenkinKaisiNendo));
        pZTIdouMeisaiTy.setZtynenkingatakbn(nenkingataKbn);
        pZTIdouMeisaiTy.setZtynknshry(nkShrKkn);
        pZTIdouMeisaiTy.setZtysiktsyuknbyugnhsyunshyj(SrCommonConstants.HYOUJI_NASI);
        pZTIdouMeisaiTy.setZtypmensugugtganhsyunshyj(SrCommonConstants.HYOUJI_NASI);
        pZTIdouMeisaiTy.setZtytkykgyousekihyjszerohyj(SrCommonConstants.HYOUJI_NASI);
        pZTIdouMeisaiTy.setZtybosyuukeitaikbn(bosyuKeitaiKbn);
        pZTIdouMeisaiTy.setZtyaatukaisosikicd(pIdouMeisai.getDrtenkanrisosikicd());
        pZTIdouMeisaiTy.setZtyaatukaikojincd(pIdouMeisai.getDaibosyuucd());
        pZTIdouMeisaiTy.setZtybsydrtencd(pIdouMeisai.getDrtencd());
        pZTIdouMeisaiTy.setZtycifcd(pIdouMeisai.getCifcd());
        pZTIdouMeisaiTy.setZtysinsakbn(sinsaKbn);
        pZTIdouMeisaiTy.setZtytoukeiyousinsakbn(toukeiyouSinsaKbn);
        pZTIdouMeisaiTy.setZtyketteikijyunkanwakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZTIdouMeisaiTy.setZtysykgycd(pIdouMeisai.getHhknsykgycd());
        pZTIdouMeisaiTy.setZtyanniskcd(anniskcd);
        pZTIdouMeisaiTy.setZtydakuhikettikekkacd(pIdouMeisai.getKetkekkacd().getValue());
        pZTIdouMeisaiTy.setZtysiboukyuuhukin(new BigDecimal(sibouKyuuhukin.toAdsoluteString()).longValue());
        pZTIdouMeisaiTy.setZtyhaitoukbn(haitouKbn);
        pZTIdouMeisaiTy.setZtyhhknnentysihyj(hhknnentysihyj);
        pZTIdouMeisaiTy.setZtykyksyaagetyouseihyj(kyksyaagetyouseihyj);
        pZTIdouMeisaiTy.setZtykituenkbn(SrCommonConstants.KITUENKBN_HUMEI);
        pZTIdouMeisaiTy.setZtymusentakukeiyakukbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZTIdouMeisaiTy.setZtydakuhikettisyacd(pIdouMeisai.getPalketsyacd());
        pZTIdouMeisaiTy.setZtytargetmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        pZTIdouMeisaiTy.setZtyautoswitchmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        pZTIdouMeisaiTy.setZtytumitatekinitenarihyj(SrCommonConstants.HYOUJI_NASI);
        pZTIdouMeisaiTy.setZtytumitatekinitenkaisuu(SrCommonConstants.DEFAULT_STRING_ZERO_3);

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {

            pIdouMeisaiTyukeiyouItzHzn.setZtyrecordkbn(SrCommonConstants.RECORDKBN_IDOUMEISAI);
            pIdouMeisaiTyukeiyouItzHzn.setZtyidourecordkbn(pCIdouRecordKbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtykeijyouctrlkbn(SrCommonConstants.KIJYCTRLKBN_SONOTA);
            if (mokuhrtHenkNbHoseiSyoriYmd != null) {
                pIdouMeisaiTyukeiyouItzHzn.setZtyhenkousyoriymd(mokuhrtHenkNbHoseiSyoriYmd.toString());
            }
            pIdouMeisaiTyukeiyouItzHzn.setZtykykmfksnctr(Integer.valueOf(keiyakuMFkoushinCTR));
            pIdouMeisaiTyukeiyouItzHzn.setZtyrecordctr(wkdCTR);
            pIdouMeisaiTyukeiyouItzHzn.setZtysuuriyoukouryokukaisiymd(kouryokukaisiymd.getRekijyou().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtydenymd(denymd.toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtytoukeikeijyoukbn(toukeikijyKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
            pIdouMeisaiTyukeiyouItzHzn.setZtyzenkiidouteiseikbn(wkZnkidoutskbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtybsyym(pIdouMeisai.getBosyuuym().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtyidoujiyuucd(idoujiyuucd);
            pIdouMeisaiTyukeiyouItzHzn.setZtysyoricd(syoricd);
            pIdouMeisaiTyukeiyouItzHzn.setZtydatakanrino(datakanriNo);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            pIdouMeisaiTyukeiyouItzHzn.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
            pIdouMeisaiTyukeiyouItzHzn.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
            pIdouMeisaiTyukeiyouItzHzn.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
            pIdouMeisaiTyukeiyouItzHzn.setZtystdssnskbn(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
            pIdouMeisaiTyukeiyouItzHzn.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
            pIdouMeisaiTyukeiyouItzHzn.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
            pIdouMeisaiTyukeiyouItzHzn.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
            pIdouMeisaiTyukeiyouItzHzn.setZtykbnkeiriyousegmentkbn(kbnKeiriyouSegmentKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtykbnkeiriyourgnbnskkbn(kbnKeiriyouRgnbnskKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtysuurisyuruicd(suuriSyuruiCd);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhosyoukinoukbn(hosyouKinouKbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtydaikbn(daiKbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtytyuukbn(tyuuKbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysyoukbn(syouKbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysedaikbn(sedaiKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyharaikatakbn(haraikataKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtykykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtyhknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtyphrkkikn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtysaimnkkykhyj(saimankiKykHyouji);
            pIdouMeisaiTyukeiyouItzHzn.setZtyannaifuyouriyuukbn(annaiFuyouRiyuuKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhrkkaisuukbn(hrkKaisuuKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhrkkeirokbn(hrkKeiroKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtysdpdkbn(pIdouMeisai.getSdpdkbn().getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyryouritukbn(ryourituKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyhihokensyaagev2(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtykyksyanen(String.valueOf(kyknenAfter));
            pIdouMeisaiTyukeiyouItzHzn.setZtytkbthsyumnryuhyouji(SrCommonConstants.HYOUJI_NASI);
            pIdouMeisaiTyukeiyouItzHzn.setZtysyukeiyakupwaribikikbn(syukeiyakuPWaribikiKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtytenkanwaribikikbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pIdouMeisaiTyukeiyouItzHzn.setZtyyuuhitutnknyuguryurtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pIdouMeisaiTyukeiyouItzHzn.setZtysyukeiyakup(new BigDecimal(syuP.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtykihons(new BigDecimal(kihonS.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysibous(new BigDecimal(sibous.toAdsoluteString()).longValue());
            if (henkouymd != null) {
                pIdouMeisaiTyukeiyouItzHzn.setZtyhenkouymd(String.valueOf(henkouymd));
            }
            pIdouMeisaiTyukeiyouItzHzn.setZtysyukeiyakusiharaikingaku(new BigDecimal(shukeiyakushiharaikingaku.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyatukaisisyatodouhukencd(todoufukencd);
            pIdouMeisaiTyukeiyouItzHzn.setZtytokuyakuhukasuu(SrCommonConstants.DEFAULT_INT_ZERO);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhrimnentyoumaephrkkkn(SrCommonConstants.DEFAULT_STRING_ZERO_2);
            pIdouMeisaiTyukeiyouItzHzn.setZtytokubetuhosyoukikan(SrCommonConstants.DEFAULT_STRING_ZERO_2);
            pIdouMeisaiTyukeiyouItzHzn.setZtykousinmanryouage(SrCommonConstants.DEFAULT_STRING_ZERO_2);
            pIdouMeisaiTyukeiyouItzHzn.setZtykanyujidatakanrino(kanyujiDatakanriNo);
            pIdouMeisaiTyukeiyouItzHzn.setZtykanyujikykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtykanyuujihihokensyaage(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtykykjyoutai(kykJyoutai);
            pIdouMeisaiTyukeiyouItzHzn.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
            pIdouMeisaiTyukeiyouItzHzn.setZtysykykhokenhoutekiyouhyj(SrCommonConstants.HYOUJI_ARI);
            pIdouMeisaiTyukeiyouItzHzn.setZtyalmyousohutomeisyoukbn(aLMSoftKbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysnkyksoftmeisyoukbn(skeiSoftKbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtynenkinkaisinendo(String.valueOf(nenkinKaisiNendo));
            pIdouMeisaiTyukeiyouItzHzn.setZtynenkingatakbn(nenkingataKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtynknshry(nkShrKkn);
            pIdouMeisaiTyukeiyouItzHzn.setZtysiktsyuknbyugnhsyunshyj(SrCommonConstants.HYOUJI_NASI);
            pIdouMeisaiTyukeiyouItzHzn.setZtypmensugugtganhsyunshyj(SrCommonConstants.HYOUJI_NASI);
            pIdouMeisaiTyukeiyouItzHzn.setZtytkykgyousekihyjszerohyj(SrCommonConstants.HYOUJI_NASI);
            pIdouMeisaiTyukeiyouItzHzn.setZtybosyuukeitaikbn(bosyuKeitaiKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyaatukaisosikicd(pIdouMeisai.getDrtenkanrisosikicd());
            pIdouMeisaiTyukeiyouItzHzn.setZtyaatukaikojincd(pIdouMeisai.getDaibosyuucd());
            pIdouMeisaiTyukeiyouItzHzn.setZtybsydrtencd(pIdouMeisai.getDrtencd());
            pIdouMeisaiTyukeiyouItzHzn.setZtycifcd(pIdouMeisai.getCifcd());
            pIdouMeisaiTyukeiyouItzHzn.setZtysinsakbn(sinsaKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtytoukeiyousinsakbn(toukeiyouSinsaKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyketteikijyunkanwakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pIdouMeisaiTyukeiyouItzHzn.setZtysykgycd(pIdouMeisai.getHhknsykgycd());
            pIdouMeisaiTyukeiyouItzHzn.setZtyanniskcd(anniskcd);
            pIdouMeisaiTyukeiyouItzHzn.setZtydakuhikettikekkacd(pIdouMeisai.getKetkekkacd().getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysiboukyuuhukin(new BigDecimal(sibouKyuuhukin.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyhaitoukbn(haitouKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhhknnentysihyj(hhknnentysihyj);
            pIdouMeisaiTyukeiyouItzHzn.setZtykyksyaagetyouseihyj(kyksyaagetyouseihyj);
            pIdouMeisaiTyukeiyouItzHzn.setZtykituenkbn(SrCommonConstants.KITUENKBN_HUMEI);
            pIdouMeisaiTyukeiyouItzHzn.setZtymusentakukeiyakukbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pIdouMeisaiTyukeiyouItzHzn.setZtydakuhikettisyacd(pIdouMeisai.getPalketsyacd());
            pIdouMeisaiTyukeiyouItzHzn.setZtytargetmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
            pIdouMeisaiTyukeiyouItzHzn.setZtyautoswitchmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
            pIdouMeisaiTyukeiyouItzHzn.setZtytumitatekinitenarihyj(SrCommonConstants.HYOUJI_NASI);
            pIdouMeisaiTyukeiyouItzHzn.setZtytumitatekinitenkaisuu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        }
    }


    private void editAlmData(SrIdouMeisaiBatchParam pSrIdouMeisaiBatchParam, SV_IdouMeisai pIdouMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean, C_SuuriIdoKbn pSuuriIdoKbn,
        C_IdouRecordKbn pCIdouRecordKbn, BizDate pKouryokuhasseiymd,ZT_IdouMeisaiTy pZTIdouMeisaiTy,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn, int pSyouhinZokusei,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn, List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst) {

        String kyKhhknDouhyouji = "";

        if (C_Tdk.HONNIN.eq(pIdouMeisai.getKkkyktdk())) {

            kyKhhknDouhyouji = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            kyKhhknDouhyouji = SrCommonConstants.HYOUJI_NASI;
        }

        String tantousyaJyoutaiKbn = "";
        String hoyuuSisyaCd2 = "";
        if (C_UmuKbn.NONE.eq(pIdouMeisai.getDrtenbunumu())) {

            tantousyaJyoutaiKbn = SrCommonConstants.TANTOUSYAJYOUTAIKBN_ATUKAISYA1ZAISEKI;

            hoyuuSisyaCd2 = "0";
        }
        else if(C_UmuKbn.ARI.eq(pIdouMeisai.getDrtenbunumu())) {

            tantousyaJyoutaiKbn = SrCommonConstants.TANTOUSYAJYOUTAIKBN_ATUKAISYA2ZAISEKI;

            SrIdouMeisaiBatchDbAccess srIdouMeisaiBatchDbAccess =
                SWAKInjector.getInstance(SrIdouMeisaiBatchDbAccess.class);

            KykDairitenByPkBean pKykDairitenByPkBean = srIdouMeisaiBatchDbAccess.
                getKykDairitenByPk(pIdouMeisai.getSyono(), 2);
            hoyuuSisyaCd2 = pKykDairitenByPkBean.getDrtenkanrisosikicd().substring(0, 3);
        }

        BizCurrency goukeiKihonS = null;

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            goukeiKihonS = BizCurrency.valueOf(0);
        }
        else {
            goukeiKihonS = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
        }

        BizCurrency goukeiGyousekiHyjSibouS = BizCurrency.valueOf(0);
        BizCurrency almyouSibouS = BizCurrency.valueOf(0);

        if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR  ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {

            KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd =
                SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

            C_ErrorKbn keisanSisuuRendouNkTmttknResult = keisanSisuuRendouNkTmttknOverNnd.exec(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                pIdouMeisai.getTeikishrtkykhukaumu(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getBizDateYM(),
                pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

            if (C_ErrorKbn.ERROR.eq(keisanSisuuRendouNkTmttknResult)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001, "合計業績表示死亡Ｓ、ＡＬＭ用死亡Ｓ", pIdouMeisai.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

                errorFlag = true;
            }
            else {
                goukeiGyousekiHyjSibouS = keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei();
                almyouSibouS = keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei();
            }
        }
        else if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            nkgns = BizCurrency.valueOf(0);
            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
            KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk = SWAKInjector
                .getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

            BizDateYM calckijyunymYen = keisanWKijunYM.exec(
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
                null,
                null,
                pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

            BizDateYM yendthnkymYen = keisanWKijunYM.exec(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                null,
                null,
                pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                null);

            C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknYendtHnk.exec(
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
                calckijyunymYen,
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                yendthnkymYen,
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKihons(),
                pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001, "合計業績表示死亡Ｓ、ＡＬＭ用死亡Ｓ", pIdouMeisai.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

                errorFlag = true;
            }
            else {
                goukeiGyousekiHyjSibouS = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
                almyouSibouS = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
                nkgns = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
            }
        }

        else if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            goukeiGyousekiHyjSibouS = BizCurrency.valueOf(0);
            almyouSibouS = BizCurrency.valueOf(0);
        }
        else {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                    goukeiGyousekiHyjSibouS = BizCurrency.valueOf(0);
                    almyouSibouS = BizCurrency.valueOf(0);
                }
                else {

                    goukeiGyousekiHyjSibouS = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                    almyouSibouS = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                }
            }
            else{
                goukeiGyousekiHyjSibouS = BizCurrency.valueOf(0);
                almyouSibouS = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
            }
        }

        BizCurrency haraikomiP = null;

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            haraikomiP = BizCurrency.valueOf(0);
        }
        else {

            haraikomiP = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
        }

        String zennoukaisiYmd  = "";
        String zennouKikan  = "";
        if (!C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            if (C_Kykjyoutai.ZENNOU.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
                zennoukaisiYmd = String.valueOf(pIdouMeisai.getZennoukaisiymd());
                zennouKikan = pIdouMeisai.getZennoukikan();
            }
        }

        String kihonYoteii = "";
        String itijiBaraiKihonYoteii = "";
        String saiteiHosyoui = "";
        String tikIkktBriJyutuTksuWk = "";
        if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            kihonYoteii =  String.valueOf(
                yoteirirituNykn.multiply(SrCommonConstants.INT_VALUE_100).multiply(SrCommonConstants.INT_VALUE_1000));

            saiteiHosyoui = String.valueOf(
                pTkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt().multiply(
                    SrCommonConstants.INT_VALUE_100).multiply(SrCommonConstants.INT_VALUE_1000));
        }
        else if (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            kihonYoteii = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()
                .multiply(SrCommonConstants.INT_VALUE_100).multiply(SrCommonConstants.INT_VALUE_1000));
        }

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            itijiBaraiKihonYoteii = String.valueOf(
                pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu().multiply(
                    SrCommonConstants.INT_VALUE_100).multiply(SrCommonConstants.INT_VALUE_1000));

        }

        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(C_TkiktbrisyuruiKbn.valueOf(tikikktbrijyututksu)) ||
            C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(C_TkiktbrisyuruiKbn.valueOf(tikikktbrijyututksu))) {
            tikIkktBriJyutuTksuWk = tikikktbrijyututksu;

        }

        SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo = SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfo.class);
        String hhkdrtkykarihyj = "";

        if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

            hhkdrtkykarihyj = srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
                C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET,
                null,
                pIdouMeisai.getSyono(),
                pIdouMeisai.getHenkousikibetukey(),
                pKouryokuhasseiymd,
                pIdouMeisai.getStdrsktkyhkumu(),
                pIdouMeisai.getStdrsktkyhkymd());

            hhkdrtkykarihyjPlusRecord = hhkdrtkykarihyj;

        }
        else if (C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)) {

            hhkdrtkykarihyj = hhkdrtkykarihyjPlusRecord;
        }
        else {

            if (C_SuuriIdoKbn.MUKOU.eq(pSuuriIdoKbn)) {

                hhkdrtkykarihyj = srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
                    C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET,
                    pTkJitenKeiyakuSyouhinKijyunBean.getSknnkaisiymd(),
                    pIdouMeisai.getSyono(),
                    null,
                    null,
                    pIdouMeisai.getStdrsktkyhkumu(),
                    pIdouMeisai.getStdrsktkyhkymd());
            }
            else {

                if (C_UmuKbn.ARI.eq(pIdouMeisai.getStdrsktkyhkumu())) {

                    hhkdrtkykarihyj = SrCommonConstants.HYOUJI_ARI;
                }
                else {

                    hhkdrtkykarihyj = SrCommonConstants.HYOUJI_NASI;
                }
            }
        }

        String kykdrtkykarihyj = "";
        if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

            kykdrtkykarihyj = srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET,
                null,
                pIdouMeisai.getSyono(),
                pIdouMeisai.getHenkousikibetukey(),
                pKouryokuhasseiymd,
                pIdouMeisai.getKykdrtkykhukaumu(),
                pIdouMeisai.getKykdrtkykhukaymd(),
                pIdouMeisai.getKykdrtkykkaiyakuymd());

            kykdrtkykarihyjPlusRecord = kykdrtkykarihyj;

        }
        else if (C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)) {

            kykdrtkykarihyj = kykdrtkykarihyjPlusRecord;
        }
        else {

            if (C_SuuriIdoKbn.MUKOU.eq(pSuuriIdoKbn)) {

                kykdrtkykarihyj = srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                    C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET,
                    pTkJitenKeiyakuSyouhinKijyunBean.getSknnkaisiymd(),
                    pIdouMeisai.getSyono(),
                    null,
                    null,
                    pIdouMeisai.getKykdrtkykhukaumu(),
                    pIdouMeisai.getKykdrtkykhukaymd(),
                    pIdouMeisai.getKykdrtkykkaiyakuymd());
            }
            else {

                if (C_UmuKbn.ARI.eq(pIdouMeisai.getKykdrtkykhukaumu())) {

                    kykdrtkykarihyj = SrCommonConstants.HYOUJI_ARI;
                }
                else {

                    kykdrtkykarihyj = SrCommonConstants.HYOUJI_NASI;
                }
            }
        }

        pZTIdouMeisaiTy.setZtykyksyhhknsydouituhyouji(kyKhhknDouhyouji);
        pZTIdouMeisaiTy.setZtykyksyaskinmeino(pIdouMeisai.getKyksakuinmeino());
        pZTIdouMeisaiTy.setZtygoukeikihons(new BigDecimal(goukeiKihonS.toAdsoluteString()).longValue());
        pZTIdouMeisaiTy.setZtygoukeigyousekihyjsibous(new BigDecimal(goukeiGyousekiHyjSibouS.toAdsoluteString()).longValue());
        pZTIdouMeisaiTy.setZtyalmyousibous(new BigDecimal(almyouSibouS.toAdsoluteString()).longValue());
        pZTIdouMeisaiTy.setZtyharaikomip(new BigDecimal(haraikomiP.toAdsoluteString()).longValue());
        pZTIdouMeisaiTy.setZtyzennoukaisiymd(zennoukaisiYmd);
        pZTIdouMeisaiTy.setZtyzennoukikan(zennouKikan);
        if (jkipjytym == null) {
            pZTIdouMeisaiTy.setZtyjikaipjyuutouym("");
        }
        else {
            pZTIdouMeisaiTy.setZtyjikaipjyuutouym(String.valueOf(jkipjytym));
        }
        pZTIdouMeisaiTy.setZtytouduketorihouhoukbn(pIdouMeisai.getHaitoukinuketorihoukbn().getValue());
        pZTIdouMeisaiTy.setZtyaatukaisyakeisyousisyacd(pIdouMeisai.getDrtenkanrisosikicd().substring(0, 3));
        pZTIdouMeisaiTy.setZtyaatukaisyazaisekihyouji(SrCommonConstants.AATUKAISYAZAISEKIHYUOJI_ZAISEKI);
        pZTIdouMeisaiTy.setZtyhoyuusisyacd(pIdouMeisai.getDrtenkanrisosikicd().substring(0, 3));
        pZTIdouMeisaiTy.setZtytantousyakbn(SrCommonConstants.TANTOUSYAKBN_SAISINATUKAISYA);
        pZTIdouMeisaiTy.setZtytantousyakbnnew(SrCommonConstants.TANTOUSYAKBNNEW_ZAISEKI);
        pZTIdouMeisaiTy.setZtytantousyajyoutaikbn(tantousyaJyoutaiKbn);
        pZTIdouMeisaiTy.setZtykihonyoteii(kihonYoteii);
        pZTIdouMeisaiTy.setZtyitijibaraikihonyoteii(itijiBaraiKihonYoteii);
        pZTIdouMeisaiTy.setZtysaiteihosyoui(saiteiHosyoui);
        pZTIdouMeisaiTy.setZtyhoyuusisyacd2(hoyuuSisyaCd2);
        pZTIdouMeisaiTy.setZtytikikktbrijyututksu(tikIkktBriJyutuTksuWk);
        pZTIdouMeisaiTy.setZtysyunyumrtikykjtigngtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZTIdouMeisaiTy.setZtyhhkdrtkykarihyj(hhkdrtkykarihyj);
        pZTIdouMeisaiTy.setZtykykdrtkykarihyj(kykdrtkykarihyj);
        pZTIdouMeisaiTy.setZtypmenkouryokuhasseiymd(SrCommonConstants.DEFAULT_STRING_ZERO_8);

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {
            pIdouMeisaiTyukeiyouItzHzn.setZtykyksyhhknsydouituhyouji(kyKhhknDouhyouji);
            pIdouMeisaiTyukeiyouItzHzn.setZtykyksyaskinmeino(pIdouMeisai.getKyksakuinmeino());
            pIdouMeisaiTyukeiyouItzHzn.setZtygoukeikihons(new BigDecimal(goukeiKihonS.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtygoukeigyousekihyjsibous(new BigDecimal(goukeiGyousekiHyjSibouS.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyalmyousibous(new BigDecimal(almyouSibouS.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyharaikomip(new BigDecimal(haraikomiP.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyzennoukaisiymd(zennoukaisiYmd);
            pIdouMeisaiTyukeiyouItzHzn.setZtyzennoukikan(zennouKikan);
            if (jkipjytym == null) {
                pIdouMeisaiTyukeiyouItzHzn.setZtyjikaipjyuutouym("");
            }
            else {
                pIdouMeisaiTyukeiyouItzHzn.setZtyjikaipjyuutouym(String.valueOf(jkipjytym));
            }
            pIdouMeisaiTyukeiyouItzHzn.setZtytouduketorihouhoukbn(pIdouMeisai.getHaitoukinuketorihoukbn().getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyaatukaisyakeisyousisyacd(pIdouMeisai.getDrtenkanrisosikicd().substring(0, 3));
            pIdouMeisaiTyukeiyouItzHzn.setZtyaatukaisyazaisekihyouji(SrCommonConstants.AATUKAISYAZAISEKIHYUOJI_ZAISEKI);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhoyuusisyacd(pIdouMeisai.getDrtenkanrisosikicd().substring(0, 3));
            pIdouMeisaiTyukeiyouItzHzn.setZtytantousyakbn(SrCommonConstants.TANTOUSYAKBN_SAISINATUKAISYA);
            pIdouMeisaiTyukeiyouItzHzn.setZtytantousyakbnnew(SrCommonConstants.TANTOUSYAKBNNEW_ZAISEKI);
            pIdouMeisaiTyukeiyouItzHzn.setZtytantousyajyoutaikbn(tantousyaJyoutaiKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtykihonyoteii(kihonYoteii);
            pIdouMeisaiTyukeiyouItzHzn.setZtyitijibaraikihonyoteii(itijiBaraiKihonYoteii);
            pIdouMeisaiTyukeiyouItzHzn.setZtysaiteihosyoui(saiteiHosyoui);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhoyuusisyacd2(hoyuuSisyaCd2);
            pIdouMeisaiTyukeiyouItzHzn.setZtytikikktbrijyututksu(tikIkktBriJyutuTksuWk);
            pIdouMeisaiTyukeiyouItzHzn.setZtysyunyumrtikykjtigngtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhhkdrtkykarihyj(hhkdrtkykarihyj);
            pIdouMeisaiTyukeiyouItzHzn.setZtykykdrtkykarihyj(kykdrtkykarihyj);
            pIdouMeisaiTyukeiyouItzHzn.setZtypmenkouryokuhasseiymd(SrCommonConstants.DEFAULT_STRING_ZERO_8);

        }
    }

    private void editHeaderData(SrIdouMeisaiBatchParam pSrIdouMeisaiBatchParam, ZT_IdouMeisaiTy pZTIdouMeisaiTy,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn, int pSyouhinZokusei,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean) {

        Integer key = pSrIdouMeisaiBatchParam.getShiKensubangou();
        pSrIdouMeisaiBatchParam.setShiKensubangou(pSrIdouMeisaiBatchParam.getShiKensubangou() + 1);

        YuyuSuuriConfig yuyuSuuriConfig = YuyuSuuriConfig.getInstance();

        Integer rdwAreaLength = yuyuSuuriConfig.getPalrdwarealength();

        Integer commonLength = yuyuSuuriConfig.getPalprre601length();

        Integer AlmLength = yuyuSuuriConfig.getPalprre603length();

        Integer tkLength = yuyuSuuriConfig.getPalprre602length();

        Integer rayLength = yuyuSuuriConfig.getPalprre850length();

        Integer yuukourecordLength = rdwAreaLength + commonLength + AlmLength + rayLength +
            tkLength * pZTIdouMeisaiTy.getZtytokuyakuhukasuu();

        pZTIdouMeisaiTy.setZtysequenceno(key);
        pZTIdouMeisaiTy.setZtyyuukourecordlength(yuukourecordLength);

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {

            pIdouMeisaiTyukeiyouItzHzn.setZtysequenceno(key);
            pIdouMeisaiTyukeiyouItzHzn.setZtyyuukourecordlength(yuukourecordLength);
        }
    }

    private void editRayData(SrIdouMeisaiBatchParam pSrIdouMeisaiBatchParam, SV_IdouMeisai pIdouMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean, C_SuuriIdoKbn pSuuriIdoKbn,
        C_IdouRecordKbn pCIdouRecordKbn, ZT_IdouMeisaiTy pIdouMeisaiTy, BizDate pKouryokuhasseiymd,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn, int pSyouhinZokusei,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn, BizDate pTmttkinInfoSyutokuKijyunYmd,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst, List<IT_KykSyouhnHnkmae> pKykSyouhnHnkmaeLst,
        String pNaibuRcdKbn, BizDate pNbHoseiSyoriYmd, String pNbHoseiHenkSkbtkey) {

        BizDate keisanDate = null;

        if (C_SuuriIdoKbn.KAIYAKU.eq(pSuuriIdoKbn) ||
            C_SuuriIdoKbn.GENGAKU.eq(pSuuriIdoKbn)) {

            keisanDate = pIdouMeisai.getSyoruiukeymd();
        }
        else if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn) ||
            (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn) &&
                C_SyoriKbn.SEIBETUHENKOU.eq(pIdouMeisai.getSyorikbn()))) {

            keisanDate = pIdouMeisai.getSyoriYmd();
        }
        else if (C_SuuriIdoKbn.KYKTORIKESI.eq(pSuuriIdoKbn) ||
            C_SuuriIdoKbn.CLGOFF.eq(pSuuriIdoKbn) ||
            C_SuuriIdoKbn.MUKOU.eq(pSuuriIdoKbn)) {

            if (BizDateUtil.compareYmd(pIdouMeisai.getSyoriYmd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {
                keisanDate = pSrIdouMeisaiBatchParam.getKijyunymd();
            }
            else {
                keisanDate = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
            }
        }
        else if (C_SuuriIdoKbn.KAIJO.eq(pSuuriIdoKbn)) {

            keisanDate = pIdouMeisai.getKouryokuhasseiymd();
        }
        else if (C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(pSuuriIdoKbn) ||
            C_SuuriIdoKbn.SISUUTUMIMASI.eq(pSuuriIdoKbn) ||
            C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(pSuuriIdoKbn) ||
            C_SuuriIdoKbn.TEIRITUITEN.eq(pSuuriIdoKbn) ||
            C_SuuriIdoKbn.TEIRITUITENTRKS.eq(pSuuriIdoKbn)) {

            keisanDate = pKouryokuhasseiymd;
        }
        else if(C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn)) {

            if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                keisanDate = pKouryokuhasseiymd.addDays(-SrCommonConstants.DAY_1D);
            }
            else {
                keisanDate = BizDate.MIN_VALUE;
            }
        }
        else if(C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn)) {

            if (C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)) {

                keisanDate = pKouryokuhasseiymd.addDays(-SrCommonConstants.DAY_1D);
            }
            else {
                keisanDate = BizDate.MIN_VALUE;
            }
        }
        else if(C_SuuriIdoKbn.PMINYUUSYOUMETU.eq(pSuuriIdoKbn)) {

            keisanDate = BizDate.MIN_VALUE;
        }
        else {

            keisanDate = pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd();
        }

        SrIdouMeisaiBatchDbAccess srIdouMeisaiBatchDbAccess = SWAKInjector.
            getInstance(SrIdouMeisaiBatchDbAccess.class);

        IT_NyknJissekiRireki nyknJissekiRireki = srIdouMeisaiBatchDbAccess.getNyknJissekiRireki(
            pIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), 1);

        String gaikaKbn = "";
        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pIdouMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {
            gaikaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizDate kawasereTokijunbi = null;
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.BLNK;
        C_KawasetekiyoKbn kawasetekiyoKbn = C_KawasetekiyoKbn.BLNK;
        C_KawasetsryKbn cawasetsryKbn = C_KawasetsryKbn.BLNK;
        C_EigyoubiHoseiKbn eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.BLNK;
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        BizNumber kawaserate = BizNumber.valueOf(0);
        BizDate kwsrateKjYmd = BizDate.valueOf(0);
        BizNumber crossRate = BizNumber.valueOf(0);

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null ||
            C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {

            kawaserate = BizNumber.valueOf(0);
            kwsrateKjYmd = BizDate.valueOf(0);
        }
        else {
            if (C_Tuukasyu.JPY.eq(nyknJissekiRireki.getRstuukasyu())) {

                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;

                cawasetsryKbn = C_KawasetsryKbn.NYUKINRATE;
            }

            else {

                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;

                cawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
            }

            BizDate kykjikwsratekijyunymd = null;
            if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
                (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN &&
                !C_Kykjyoutai.ZENNOU.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai()))) {

                kykjikwsratekijyunymd = nyknJissekiRireki.getRyosyuymd().addBusinessDays(-1);
            }
            else {

                kykjikwsratekijyunymd = nyknJissekiRireki.getRyosyuymd();
            }

            C_ErrorKbn errorKbn = getKawaseRate.exec(kykjikwsratekijyunymd,
                kawaserateSyuruiKbn,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                cawasetsryKbn,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);



            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1004,
                    String.valueOf(kykjikwsratekijyunymd),
                    kawaserateSyuruiKbn.getValue(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                    C_Tuukasyu.JPY.getValue(),
                    C_KawasetekiyoKbn.TTM.getValue(),
                    cawasetsryKbn.getValue(),
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                    C_YouhiKbn.HUYOU.getValue());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
                errorFlag = true;
            }
            else {

                kawaserate = getKawaseRate.getKawaserate();
                kwsrateKjYmd = getKawaseRate.getKwsrateKjYmd();
            }

            if (!pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().eq(nyknJissekiRireki.getRstuukasyu()) &&
                (C_Tuukasyu.AUD.eq(nyknJissekiRireki.getRstuukasyu()) ||
                    C_Tuukasyu.USD.eq(nyknJissekiRireki.getRstuukasyu()))) {

                errorKbn = getKawaseRate.exec(nyknJissekiRireki.getRyosyuymd(), C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(), nyknJissekiRireki.getRstuukasyu(),
                    C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE, C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    String msg = MessageUtil.getMessage(MessageId.ESA1004,
                        String.valueOf(nyknJissekiRireki.getRyosyuymd()),
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE.getValue(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                        nyknJissekiRireki.getRstuukasyu().getValue(),
                        C_KawasetekiyoKbn.TTM.getValue(),
                        C_KawasetsryKbn.NYUKINRATE.getValue(),
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                        C_YouhiKbn.HUYOU.getValue());

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                    suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
                    errorFlag = true;
                }
                else {

                    crossRate = getKawaseRate.getKawaserate();
                }

                SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);
                SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean = srSuuriGouseiRateKeisan.exec(nyknJissekiRireki.getRyosyuymd(),
                    nyknJissekiRireki.getRstuukasyu(), crossRate);

                if (C_ErrorKbn.ERROR.eq(srSuuriGouseiRateKeisanBean.getErrorKbn())) {

                    SetErrMessageInfoBean setErrMessageInfoBean = srSuuriGouseiRateKeisanBean.getErrMessageInfoBean();

                    String msg = MessageUtil.getMessage(MessageId.ESA1004,
                        String.valueOf(setErrMessageInfoBean.getKwsrateKjYmd()),
                        setErrMessageInfoBean.getKawaserateSyuruiKbn().getValue(),
                        setErrMessageInfoBean.getMotoTuukasyu().getValue(),
                        setErrMessageInfoBean.getKansanTuukasyu().getValue(),
                        setErrMessageInfoBean.getKawasetekiyoKbn().getValue(),
                        setErrMessageInfoBean.getKawasetsryKbn().getValue(),
                        setErrMessageInfoBean.getEigyoubiHoseiKbn().getValue(),
                        setErrMessageInfoBean.getYouhiKbn().getValue() + "：合成レート");

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                    suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
                    errorFlag = true;
                }
                else {

                    kawaserate = srSuuriGouseiRateKeisanBean.getSuuriGouseiRate();
                }
            }
        }

        BizNumber kawaserate2 = BizNumber.valueOf(0);
        BizDate kwsrateKjYmd2 = BizDate.valueOf(0);

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null ||
            C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {
            kawaserate2 = BizNumber.valueOf(0);
            kwsrateKjYmd2 = BizDate.valueOf(0);
        }
        else {

            if ((C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn) &&
                !C_SyoriKbn.SEIBETUHENKOU.eq(pIdouMeisai.getSyorikbn())) ||
                C_SuuriIdoKbn.KYKTORIKESI.eq(pSuuriIdoKbn) ||
                C_SuuriIdoKbn.CLGOFF.eq(pSuuriIdoKbn) ||
                C_SuuriIdoKbn.MUKOU.eq(pSuuriIdoKbn) ||
                C_SuuriIdoKbn.SBMUKOU_KIHRKPSHR.eq(pSuuriIdoKbn) ||
                C_SuuriIdoKbn.SBMUKOU_SHRNASI.eq(pSuuriIdoKbn) ) {

                kwsrateKjYmd2 = kwsrateKjYmd;
                kawaserate2 = kawaserate;

                if (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN ){

                    if ((C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn) &&
                        !C_SyoriKbn.SEIBETUHENKOU.eq(pIdouMeisai.getSyorikbn())) ||
                        C_SuuriIdoKbn.SBMUKOU_KIHRKPSHR.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.SBMUKOU_SHRNASI.eq(pSuuriIdoKbn)) {

                        if (C_Tuukasyu.JPY.eq(nyknJissekiRireki.getRstuukasyu())) {

                            kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;

                            cawasetsryKbn = C_KawasetsryKbn.NYUKINRATE;
                        }

                        else {

                            kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;

                            cawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
                        }

                        C_ErrorKbn errorKbn = getKawaseRate.exec(nyknJissekiRireki.getRyosyuymd().addBusinessDays(-1),
                            kawaserateSyuruiKbn,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            cawasetsryKbn,
                            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            String msg = MessageUtil.getMessage(MessageId.ESA1004,
                                String.valueOf(nyknJissekiRireki.getRyosyuymd().addBusinessDays(-1)),
                                kawaserateSyuruiKbn.getValue(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                                C_Tuukasyu.JPY.getValue(),
                                C_KawasetekiyoKbn.TTM.getValue(),
                                cawasetsryKbn.getValue(),
                                C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                                C_YouhiKbn.HUYOU.getValue());

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
                            errorFlag = true;
                        }
                        else {

                            kawaserate2 = getKawaseRate.getKawaserate();
                            kwsrateKjYmd2 = getKawaseRate.getKwsrateKjYmd();
                        }
                    }
                }

            } else {
                if ((C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn) && C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)) ||
                    (C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn) && C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn))) {
                    kawaserate2 = BizNumber.valueOf(0);
                    kwsrateKjYmd2 = BizDate.valueOf(0);
                }
                else {
                    if (C_SyoriKbn.SBMENSEKI_SHRNASI.eq(pIdouMeisai.getSyorikbn())) {
                        kawasereTokijunbi = pIdouMeisai.getSyoriYmd();
                        eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.BLNK;
                    } else if (C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(pSuuriIdoKbn)){
                        kawasereTokijunbi = pKouryokuhasseiymd;
                        eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                    } else if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn) &&
                        C_SyoriKbn.SEIBETUHENKOU.eq(pIdouMeisai.getSyorikbn())){
                        kawasereTokijunbi = pIdouMeisai.getSyoriYmd();
                        eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                    } else if (C_SuuriIdoKbn.SIBOU.eq(pSuuriIdoKbn)){
                        if (pIdouMeisai.getHubikanryouymd() != null) {
                            kawasereTokijunbi = pIdouMeisai.getHubikanryouymd();
                            eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                        } else {
                            kawasereTokijunbi = pIdouMeisai.getSyoruiukeymd();
                            eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                        }
                    }
                    else if (C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn)) {

                        if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                            kawasereTokijunbi = pKouryokuhasseiymd.addDays(-SrCommonConstants.DAY_1D);
                            eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                        }
                    }
                    else if (C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn)) {

                        if (C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)) {

                            kawasereTokijunbi = pKouryokuhasseiymd.addDays(-SrCommonConstants.DAY_1D);
                            eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                        }
                    }
                    else if (C_SuuriIdoKbn.SISUUTUMIMASI.eq(pSuuriIdoKbn)
                        || C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(pSuuriIdoKbn)
                        || C_SuuriIdoKbn.TEIRITUITEN.eq(pSuuriIdoKbn)
                        || C_SuuriIdoKbn.TEIRITUITENTRKS.eq(pSuuriIdoKbn)) {

                        kawasereTokijunbi = pKouryokuhasseiymd;
                        eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.ZENEIGYOUBI;
                    }
                    else if (C_SuuriIdoKbn.PMINYUUSYOUMETU.eq(pSuuriIdoKbn)) {

                        kawasereTokijunbi = pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd();
                        eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                    }
                    else if (C_SuuriIdoKbn.HARAIKATAHNK.eq(pSuuriIdoKbn)) {

                        kawasereTokijunbi = pIdouMeisai.getSyoriYmd();
                        eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                    }
                    else {
                        kawasereTokijunbi = pIdouMeisai.getSyoruiukeymd();
                        eigyoubiHoseiKbn = C_EigyoubiHoseiKbn.YOKUEIGYOUBI;
                    }
                    kawasetekiyoKbn = C_KawasetekiyoKbn.TTM;

                    if (C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn)) {
                        kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
                        cawasetsryKbn = C_KawasetsryKbn.SYUKKINRATE;
                    }
                    else if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn) &&
                        C_SyoriKbn.SEIBETUHENKOU.eq(pIdouMeisai.getSyorikbn())) {
                        kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
                        cawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
                    }
                    else if (C_SuuriIdoKbn.SISUUTUMIMASI.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.TEIRITUITEN.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.TEIRITUITENTRKS.eq(pSuuriIdoKbn)) {
                        kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
                        cawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
                    }
                    else if (C_SuuriIdoKbn.PMINYUUSYOUMETU.eq(pSuuriIdoKbn)) {
                        kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
                        cawasetsryKbn = C_KawasetsryKbn.SYUKKINRATE;
                    }
                    else if (C_SuuriIdoKbn.HARAIKATAHNK.eq(pSuuriIdoKbn)) {
                        kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
                        cawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
                    }
                    else {

                        if (C_Tuukasyu.JPY.eq(pIdouMeisai.getShrtuukasyu())) {
                            kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
                            cawasetsryKbn = C_KawasetsryKbn.SYUKKINRATE;
                        }
                        else {
                            kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
                            cawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
                        }
                    }

                    C_ErrorKbn errorKbn = getKawaseRate.exec(kawasereTokijunbi,
                        kawaserateSyuruiKbn,
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        kawasetekiyoKbn,
                        cawasetsryKbn,
                        eigyoubiHoseiKbn,
                        C_YouhiKbn.HUYOU);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        String msg = MessageUtil.getMessage(MessageId.ESA1004,
                            String.valueOf(kawasereTokijunbi),
                            kawaserateSyuruiKbn.getValue(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                            C_Tuukasyu.JPY.getValue(),
                            kawasetekiyoKbn.getValue(),
                            cawasetsryKbn.getValue(),
                            eigyoubiHoseiKbn.getValue(),
                            C_YouhiKbn.HUYOU.getValue());

                        batchLogger.warn(msg);

                        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                        suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                        suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                        suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                        pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
                        errorFlag = true;
                    }
                    else {

                        kawaserate2 = getKawaseRate.getKawaserate();
                        kwsrateKjYmd2 =  getKawaseRate.getKwsrateKjYmd();
                    }
                }
            }
        }

        BizCurrency mvatyouseigow = BizCurrency.valueOf(0);
        BizCurrency mvakeisanjisknnjynbkn = BizCurrency.valueOf(0);
        BizNumber suuriyoukaiyakusjktsritu = BizNumber.valueOf(0);
        BizNumber srkykSjkkktyouseiriRitu = BizNumber.valueOf(0);
        BizNumber mvatyouseikou = BizNumber.valueOf(0);
        BizDate mvaKeisanKijyunYmd = BizDate.MIN_VALUE;
        BizCurrency msyuPTusshkgKaiykHnrikn = BizCurrency.valueOf(0);
        BizCurrency kykkjmMvatyouseigow = BizCurrency.valueOf(0);
        BizCurrency sibous = BizCurrency.valueOf(0);
        BizCurrency goukeigyousekihyjsibous = BizCurrency.valueOf(0);
        BizCurrency almyousibous = BizCurrency.valueOf(0);

        if (C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu()) &&
            pSyouhinZokusei != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR &&
            pSyouhinZokusei != SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

            mvatyouseigow = BizCurrency.valueOf(0);
            mvakeisanjisknnjynbkn = BizCurrency.valueOf(0);
            suuriyoukaiyakusjktsritu = BizNumber.valueOf(0);
            srkykSjkkktyouseiriRitu = BizNumber.valueOf(0);
            mvatyouseikou = BizNumber.valueOf(0);
            mvaKeisanKijyunYmd = BizDate.MIN_VALUE;
            msyuPTusshkgKaiykHnrikn = BizCurrency.valueOf(0);
            kykkjmMvatyouseigow = BizCurrency.valueOf(0);
        }
        else {
            if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) &&
                ((C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn) && C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)) ||
                    (C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn) && C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)))) {
                mvatyouseigow = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                mvakeisanjisknnjynbkn = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                suuriyoukaiyakusjktsritu = BizNumber.valueOf(0);
                srkykSjkkktyouseiriRitu = BizNumber.valueOf(0);
                mvatyouseikou = BizNumber.valueOf(0);
                mvaKeisanKijyunYmd = BizDate.MIN_VALUE;
                msyuPTusshkgKaiykHnrikn = BizCurrency.valueOf(0);

                if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                    kykkjmMvatyouseigow = BizCurrency.valueOf(0);
                    sibous = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                    goukeigyousekihyjsibous = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                    almyousibous = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                }
                else {

                    kykkjmMvatyouseigow = mvatyouseigow;
                }
            }
            else if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) &&
                (C_SuuriIdoKbn.MUKOU.eq(pSuuriIdoKbn)) &&
                (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {
                mvatyouseigow = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                mvakeisanjisknnjynbkn = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                suuriyoukaiyakusjktsritu = BizNumber.valueOf(0);
                srkykSjkkktyouseiriRitu = BizNumber.valueOf(0);
                mvatyouseikou = BizNumber.valueOf(0);
                mvaKeisanKijyunYmd = BizDate.MIN_VALUE;
                msyuPTusshkgKaiykHnrikn = BizCurrency.valueOf(0);

                if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                    kykkjmMvatyouseigow = BizCurrency.valueOf(0);
                    sibous = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                    goukeigyousekihyjsibous = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                    almyousibous = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                }
                else {

                    kykkjmMvatyouseigow = mvatyouseigow;
                }
            }
            else if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), keisanDate) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), keisanDate) == BizDateUtil.COMPARE_EQUAL) {

                KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                BizDateYM kijunnengetuYm = keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), keisanDate,
                    null, null, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

                BizDateYM tmttknTaisyouYm = BizDateYM.MIN_VALUE;
                BizCurrency teirituTmttknGk = BizCurrency.valueOf(0);
                BizCurrency sisuurendouTmttknGk = BizCurrency.valueOf(0);
                BizNumber tumitateRiritu = BizNumber.valueOf(0);

                if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
                    (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu()))) {

                    if (BizDateUtil.calcDifferenceMonths(pTmttkinInfoSyutokuKijyunYmd.getBizDateYM(),
                        pKhSisuurendoTmttkn.getTmttkntaisyouym()) > SrCommonConstants.KIKAN_12M) {

                        Integer keikamonGetukansan = BizDateUtil.calcDifferenceMonths(
                            pTmttkinInfoSyutokuKijyunYmd.getBizDateYM(), pKhSisuurendoTmttkn.getTmttkntaisyouym());

                        Integer keikanensuu = keikamonGetukansan / SrCommonConstants.KIKAN_12M;

                        tmttknTaisyouYm = pKhSisuurendoTmttkn.getTmttkntaisyouym().addYears(keikanensuu);

                        BizDate tmttknTaisyouYmd = BizDate.valueOf(tmttknTaisyouYm, pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();

                        KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd = SWAKInjector
                            .getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

                        C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                            pIdouMeisai.getTeikishrtkykhukaumu(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                            tmttknTaisyouYmd,
                            tmttknTaisyouYm,
                            pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                            pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                            pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            String msg = MessageUtil.getMessage(MessageId.ESA1001, "積立金計算：ＭＶＡ調整後Ｗ", pIdouMeisai.getSyono());

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

                            errorFlag = true;
                        }
                        else {
                            teirituTmttknGk = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
                            sisuurendouTmttknGk = keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk();
                            tumitateRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                        }
                    }
                    else {
                        tmttknTaisyouYm = pKhSisuurendoTmttkn.getTmttkntaisyouym();
                        teirituTmttknGk = pKhSisuurendoTmttkn.getTeiritutmttkngk();
                        sisuurendouTmttknGk = pKhSisuurendoTmttkn.getSisuurendoutmttkngk();
                        tumitateRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                    }
                }
                else if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                    C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu())) {

                    tmttknTaisyouYm = BizDateYM.MIN_VALUE;
                    teirituTmttknGk = BizCurrency.valueOf(0);
                    sisuurendouTmttknGk = BizCurrency.valueOf(0);
                    tumitateRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                }
                else {
                    tmttknTaisyouYm = BizDateYM.MIN_VALUE;
                    teirituTmttknGk = BizCurrency.valueOf(0);
                    sisuurendouTmttknGk = BizCurrency.valueOf(0);
                    tumitateRiritu = BizNumber.valueOf(0);
                }

                BizNumber kaiyakusjkkktyouseiriritu = BizNumber.valueOf(0);

                if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu())) {

                    GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
                    GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);

                    getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                    getSjkkktyouseiyourirituBean.setKijyunymd(keisanDate);
                    getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
                    getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
                    getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

                    C_ErrorKbn errorKbn =getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        String msg = MessageUtil.getMessage(MessageId.ESA1001, "市場価格調整用利率", pIdouMeisai.getSyono());

                        batchLogger.warn(msg);

                        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                        suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                        suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                        suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                        pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

                        errorFlag = true;
                    }
                    else {
                        kaiyakusjkkktyouseiriritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                    }
                }

                KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

                KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

                keisanWExtBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                keisanWExtBean.setSyouhnsdno(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());
                keisanWExtBean.setRyouritusdno(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
                keisanWExtBean.setYoteiriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu());
                keisanWExtBean.setHrkkaisuu(pIdouMeisai.getHrkkaisuu());
                keisanWExtBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
                keisanWExtBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
                keisanWExtBean.setHrkkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn());
                keisanWExtBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());
                keisanWExtBean.setHhknsei(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei());
                keisanWExtBean.setKihons(pTkJitenKeiyakuSyouhinKijyunBean.getKihons());
                keisanWExtBean.setHokenryou(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou());
                keisanWExtBean.setKykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
                keisanWExtBean.setTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());
                keisanWExtBean.setKyksjkkktyouseiriritu(pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu());
                keisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiyakusjkkktyouseiriritu);
                keisanWExtBean.setTmttkntaisyouym(tmttknTaisyouYm);
                keisanWExtBean.setTeiritutmttkngk(teirituTmttknGk);
                keisanWExtBean.setSisuurendoutmttkngk(sisuurendouTmttknGk);
                keisanWExtBean.setTumitateriritu(tumitateRiritu);
                keisanWExtBean.setYendthnkymd(pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());
                keisanWExtBean.setTeikishrtkykhukaumu(pIdouMeisai.getTeikishrtkykhukaumu());
                keisanWExtBean.setDai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn());
                keisanWExtBean.setKykJyoutai(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai());

                C_ErrorKbn errorKbn = keisanW.exec(keisanDate, kijunnengetuYm, keisanWExtBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    String msg = MessageUtil.getMessage(MessageId.ESA1001, "解約返戻金", pIdouMeisai.getSyono());

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                    suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
                    errorFlag = true;
                }
                else {
                    if (C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu())) {

                        mvatyouseigow = keisanW.getW();
                        mvakeisanjisknnjynbkn = keisanW.getV();
                        suuriyoukaiyakusjktsritu = kaiyakusjkkktyouseiriritu;
                        srkykSjkkktyouseiriRitu = BizNumber.ZERO;
                        mvatyouseikou = keisanW.getMvaTyouseikou();
                        mvaKeisanKijyunYmd = BizDate.MIN_VALUE;
                        msyuPTusshkgKaiykHnrikn = BizCurrency.valueOf(0);

                        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                            kykkjmMvatyouseigow = BizCurrency.valueOf(0);
                            sibous = keisanW.getV();
                            goukeigyousekihyjsibous = keisanW.getV();
                            almyousibous = keisanW.getV();
                        }
                        else {

                            kykkjmMvatyouseigow = mvatyouseigow;
                        }
                    }
                    else {

                        mvatyouseigow = keisanW.getW();
                        mvakeisanjisknnjynbkn = keisanW.getV();
                        suuriyoukaiyakusjktsritu = kaiyakusjkkktyouseiriritu;
                        srkykSjkkktyouseiriRitu = pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu();
                        mvatyouseikou = keisanW.getMvaTyouseikou();
                        mvaKeisanKijyunYmd = keisanDate;

                        if ((C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn) && C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) ||
                            (C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn) && C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn))) {
                            msyuPTusshkgKaiykHnrikn = keisanW.getW();
                        }
                        else {
                            msyuPTusshkgKaiykHnrikn = BizCurrency.valueOf(0);
                        }

                        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
                            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                            kykkjmMvatyouseigow = keisanW.getKaiyakukjMaeW();
                        }
                        else {

                            kykkjmMvatyouseigow = mvatyouseigow;
                        }
                    }
                }
            }
            else {
                mvatyouseigow = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
                mvakeisanjisknnjynbkn = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
                suuriyoukaiyakusjktsritu = pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu();
                srkykSjkkktyouseiriRitu = pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu();
                mvatyouseikou = BizNumber.valueOf(SrCommonConstants.MVATYOUSEIKOU_CASCADE);
                mvaKeisanKijyunYmd = keisanDate;
                msyuPTusshkgKaiykHnrikn = BizCurrency.valueOf(0);
                kykkjmMvatyouseigow = mvatyouseigow;
            }
        }

        BizCurrency enkdtsbujsitihsyukngk = BizCurrency.valueOf(0);
        String kaigomaebaraitkykarihyj = "";
        String shiharaituukaKbn = "";
        BizNumber rendouRitu = BizNumber.valueOf(0);

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {

                rendouRitu = BizNumber.valueOf(0);
            }
            else {

                rendouRitu = pTkJitenKeiyakuSyouhinKijyunBean.getRendouritu();
            }
        }
        else {
            rendouRitu = BizNumber.valueOf(0);
        }


        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            enkdtsbujsitihsyukngk = BizCurrency.valueOf(0);
        }
        else {

            if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pNaibuRcdKbn) ||
                SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(pNaibuRcdKbn) ||
                SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pNaibuRcdKbn) ||
                SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(pNaibuRcdKbn) ||
                (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pNaibuRcdKbn) &&
                    C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(pSuuriIdoKbn)) ||
                    (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD_TMMSGO.equals(pNaibuRcdKbn) &&
                        C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(pSuuriIdoKbn))) {

                if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {
                    enkdtsbujsitihsyukngk = pIdouMeisai.getInitsbjiyenkasaiteihsygk();
                    initsbjiyenkasaiteihsygk = pIdouMeisai.getInitsbjiyenkasaiteihsygk();

                    List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean>
                    kykHkHkRrkLst = srIdouMeisaiBatchDbAccess.getKhHenkouRirekis(
                        pIdouMeisai.getSyono(),
                        pNbHoseiHenkSkbtkey,
                        ITKYKSONOTATKYK,
                        INITSBJIYENKASAITEIHSYGK);

                    if (kykHkHkRrkLst.size() > 0) {
                        if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pNaibuRcdKbn) ||
                            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pNaibuRcdKbn) ||
                            SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pNaibuRcdKbn) ||
                            SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD_TMMSGO.equals(pNaibuRcdKbn)) {
                            enkdtsbujsitihsyukngk = BizCurrency.valueOf(
                                new BigDecimal(kykHkHkRrkLst.get(0).getBfrnaiyouoriginal()).longValue());
                            initsbjiyenkasaiteihsygk = BizCurrency.valueOf(
                                new BigDecimal(kykHkHkRrkLst.get(0).getBfrnaiyouoriginal()).longValue());
                        }

                        else if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(pNaibuRcdKbn) ||
                            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(pNaibuRcdKbn)) {
                            enkdtsbujsitihsyukngk = BizCurrency.valueOf(
                                new BigDecimal(kykHkHkRrkLst.get(0).getNewnaiyouoriginal()).longValue());
                            initsbjiyenkasaiteihsygk = BizCurrency.valueOf(
                                new BigDecimal(kykHkHkRrkLst.get(0).getNewnaiyouoriginal()).longValue());
                        }
                    }
                }

                else if (C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)) {
                    enkdtsbujsitihsyukngk = initsbjiyenkasaiteihsygk;
                }
            }
            else if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null &&
                !C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn) &&
                !C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn)) {

                enkdtsbujsitihsyukngk = BizCurrency.valueOf(0);
            }
            else {

                if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                    SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo = SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfo.class);

                    SrGetTokutejitenTokuyakuInfoBean srGetTokutejitenTokuyakuInfoBean = srGetTokutejitenTokuyakuInfo.exec(
                        C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK,
                        C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET,
                        null,
                        pIdouMeisai.getSyono(),
                        pSuuriIdoKbn,
                        pIdouMeisai.getHenkousikibetukey(),
                        pKouryokuhasseiymd,
                        pSvKiykSyuhnDataLst,
                        pIdouMeisai.getYendthnkymd(),
                        pKykSyouhnHnkmaeLst,
                        pIdouMeisai.getInitsbjiyensitihsytkhukaumu(),
                        pIdouMeisai.getInitsbjiyenkasaiteihsygk(),
                        null,
                        null,
                        null,
                        null);

                    enkdtsbujsitihsyukngk = srGetTokutejitenTokuyakuInfoBean.getInitsbjiyenkasaiteihsygkMae();

                    initsbjiyenkasaiteihsygk = srGetTokutejitenTokuyakuInfoBean.getInitsbjiyenkasaiteihsygkAto();
                }
                else if (C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)) {

                    enkdtsbujsitihsyukngk = initsbjiyenkasaiteihsygk;
                }
                else {

                    if (C_SuuriIdoKbn.MUKOU.eq(pSuuriIdoKbn)) {

                        SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo = SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfo.class);

                        SrGetTokutejitenTokuyakuInfoBean srGetTokutejitenTokuyakuInfoBean = srGetTokutejitenTokuyakuInfo.exec(
                            C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK,
                            C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET,
                            pTkJitenKeiyakuSyouhinKijyunBean.getSknnkaisiymd(),
                            pIdouMeisai.getSyono(),
                            null,
                            null,
                            null,
                            pSvKiykSyuhnDataLst,
                            pIdouMeisai.getYendthnkymd(),
                            pKykSyouhnHnkmaeLst,
                            pIdouMeisai.getInitsbjiyensitihsytkhukaumu(),
                            pIdouMeisai.getInitsbjiyenkasaiteihsygk(),
                            null,
                            null,
                            null,
                            null);

                        enkdtsbujsitihsyukngk = srGetTokutejitenTokuyakuInfoBean.getInitsbjiyenkasaiteihsygkMae();
                    }
                    else {

                        if (C_UmuKbn.ARI.eq(pIdouMeisai.getInitsbjiyensitihsytkhukaumu())) {

                            enkdtsbujsitihsyukngk = pIdouMeisai.getInitsbjiyenkasaiteihsygk();
                        }
                        else {
                            enkdtsbujsitihsyukngk = BizCurrency.valueOf(0);
                        }
                    }
                }
            }
        }

        if (C_UmuKbn.ARI.eq(pIdouMeisai.getJyudkaigomeharaitkhukaumu())) {

            kaigomaebaraitkykarihyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            kaigomaebaraitkykarihyj = SrCommonConstants.HYOUJI_NASI;
        }

        if (pIdouMeisai.getShrtuukasyu() == null || pIdouMeisai.getShrtuukasyu().eq(C_Tuukasyu.BLNK)) {

            if ((pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  ||
                pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) &&
                C_SuuriIdoKbn.PMINYUUSYOUMETU.eq(pSuuriIdoKbn)) {

                shiharaituukaKbn = SIHARAITUUKAKBN_YEN;
            }
            else {

                shiharaituukaKbn = SrCommonConstants.DEFAULT_STRING_ZERO_1;
            }
        }
        else {

            srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA,
                pIdouMeisai.getShrtuukasyu().getValue());

            if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                String msg = MessageUtil.getMessage(MessageId.ESA1002,
                    C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA.getContent(),
                    pIdouMeisai.getSyono(),
                    pIdouMeisai.getShrtuukasyu().getValue());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
                errorFlag = true;
            }
            else {
                shiharaituukaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
            }
        }

        BizCurrency enkdtsbujsitihsyucost = BizCurrency.valueOf(0);
        String enkdtsbujsitihsyuarihyj = "";

        if (C_SuuriIdoKbn.SIBOU.eq(pSuuriIdoKbn)) {

            if (!pIdouMeisai.getSitihsyutkyumaeyenhknkngk().isZeroOrOptional()) {

                enkdtsbujsitihsyucost = pIdouMeisai.getInitsbjiyenkasaiteihsygk().
                    subtract(pIdouMeisai.getSitihsyutkyumaeyenhknkngk());

                enkdtsbujsitihsyuarihyj = "1";
            }
            else {

                enkdtsbujsitihsyucost = BizCurrency.valueOf(0);

                enkdtsbujsitihsyuarihyj = "0";
            }
        }

        Integer endttargetmokuhyouritu = 0;
        BizCurrency endttargetkijyunkingaku = BizCurrency.valueOf(0);

        if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pNaibuRcdKbn) ||
            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(pNaibuRcdKbn) ||
            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pNaibuRcdKbn) ||
            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(pNaibuRcdKbn) ||
            (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pNaibuRcdKbn) &&
                C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(pSuuriIdoKbn)) ||
                (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD_TMMSGO.equals(pNaibuRcdKbn) &&
                    C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(pSuuriIdoKbn))) {

            if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                endttargetmokuhyouritu = pIdouMeisai.getTargettkmokuhyouti();
                endttargetmokuhyourituplusrecord = pIdouMeisai.getTargettkmokuhyouti();

                endttargetkijyunkingaku = pIdouMeisai.getTargettkykkijyungk();
                endttargetkijyungkplusrecord = pIdouMeisai.getTargettkykkijyungk();

                List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean>
                kykHkHkRrkLstKgk = srIdouMeisaiBatchDbAccess.getKhHenkouRirekis(
                    pIdouMeisai.getSyono(),
                    pIdouMeisai.getHenkousikibetukey(),
                    ITKYKSONOTATKYK,
                    TARGETTKMOKUHYOUTI);

                if (kykHkHkRrkLstKgk.size() > 0) {
                    if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pNaibuRcdKbn) ||
                        SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pNaibuRcdKbn)) {
                        endttargetmokuhyouritu = new BigDecimal(kykHkHkRrkLstKgk.get(0).getNewnaiyouoriginal()).intValue();
                        endttargetmokuhyourituplusrecord = new BigDecimal(kykHkHkRrkLstKgk.get(0).getBfrnaiyouoriginal()).intValue();
                    }

                    else if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(pNaibuRcdKbn) ||
                        SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(pNaibuRcdKbn) ||
                        SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pNaibuRcdKbn) ||
                        SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD_TMMSGO.equals(pNaibuRcdKbn)) {
                        endttargetmokuhyouritu = new BigDecimal(kykHkHkRrkLstKgk.get(0).getBfrnaiyouoriginal()).intValue();
                        endttargetmokuhyourituplusrecord = new BigDecimal(kykHkHkRrkLstKgk.get(0).getNewnaiyouoriginal()).intValue();
                    }
                }

                List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean>
                kykHkHkRrkLst = srIdouMeisaiBatchDbAccess.getKhHenkouRirekis(
                    pIdouMeisai.getSyono(),
                    pNbHoseiHenkSkbtkey,
                    ITKYKSONOTATKYK,
                    TARGETTKYKKIJYUNGK);

                if (kykHkHkRrkLst.size() > 0) {
                    if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pNaibuRcdKbn) ||
                        SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pNaibuRcdKbn) ||
                        SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pNaibuRcdKbn) ||
                        SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD_TMMSGO.equals(pNaibuRcdKbn)) {
                        endttargetkijyunkingaku = BizCurrency.valueOf(
                            new BigDecimal(kykHkHkRrkLst.get(0).getBfrnaiyouoriginal()).longValue());
                        endttargetkijyungkplusrecord = BizCurrency.valueOf(
                            new BigDecimal(kykHkHkRrkLst.get(0).getBfrnaiyouoriginal()).longValue());
                    }

                    else if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(pNaibuRcdKbn) ||
                        SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(pNaibuRcdKbn)) {
                        endttargetkijyunkingaku = BizCurrency.valueOf(
                            new BigDecimal(kykHkHkRrkLst.get(0).getNewnaiyouoriginal()).longValue());
                        endttargetkijyungkplusrecord = BizCurrency.valueOf(
                            new BigDecimal(kykHkHkRrkLst.get(0).getNewnaiyouoriginal()).longValue());
                    }
                }
            }

            else if (C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)) {
                endttargetmokuhyouritu = endttargetmokuhyourituplusrecord;
                endttargetkijyunkingaku = endttargetkijyungkplusrecord;
            }
        }
        else if (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(pNaibuRcdKbn)  ||
            SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITSRECORD.equals(pNaibuRcdKbn) ||
            (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pNaibuRcdKbn) &&
                (C_SuuriIdoKbn.SISUUTUMIMASI.eq(pSuuriIdoKbn) || C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(pSuuriIdoKbn)))) {

            if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                endttargetmokuhyouritu = pIdouMeisai.getTargettkmokuhyouti();
                endttargetmokuhyourituplusrecord = pIdouMeisai.getTargettkmokuhyouti();

                endttargetkijyunkingaku = pIdouMeisai.getTargettkykkijyungk();
                endttargetkijyungkplusrecord = pIdouMeisai.getTargettkykkijyungk();

                List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> targetTokuyakuBefaAftMokuhyoutiDescList =
                    srIdouMeisaiBatchDbAccess.getTargetTokuyakuBefaAftMokuhyoutiDescList(pIdouMeisai.getSyono());

                for (KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean targetTokuyakuBefaAftMokuhyoutiDesc :
                    targetTokuyakuBefaAftMokuhyoutiDescList) {

                    List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuBefaAftKykhenkoYmdList =
                        srIdouMeisaiBatchDbAccess.getTargetTokuyakuBefaAftKykhenkoYmdList(pIdouMeisai.getSyono(),
                            targetTokuyakuBefaAftMokuhyoutiDesc.getHenkousikibetukey());

                    if (BizDateUtil.compareYmd(pIdouMeisai.getSyoriYmd(),
                        BizDate.valueOf(targetTokuyakuBefaAftKykhenkoYmdList.get(0).getNewnaiyouoriginal())) == BizDateUtil.COMPARE_LESSER) {

                        endttargetmokuhyouritu =  new BigDecimal(targetTokuyakuBefaAftMokuhyoutiDesc.getBfrnaiyouoriginal()).intValue() ;

                        endttargetmokuhyourituplusrecord = new BigDecimal(targetTokuyakuBefaAftMokuhyoutiDesc.getBfrnaiyouoriginal()).intValue() ;
                    }
                    else {
                        break;
                    }
                }

                List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean>
                kykHkHkRrkLst = srIdouMeisaiBatchDbAccess.getKhHenkouRirekis(
                    pIdouMeisai.getSyono(),
                    pNbHoseiHenkSkbtkey,
                    ITKYKSONOTATKYK,
                    TARGETTKYKKIJYUNGK);

                if (kykHkHkRrkLst.size() > 0) {
                    if (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(pNaibuRcdKbn) ||
                        SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pNaibuRcdKbn)) {
                        endttargetkijyunkingaku = BizCurrency.valueOf(new BigDecimal(kykHkHkRrkLst.get(0).getBfrnaiyouoriginal()));
                        endttargetkijyungkplusrecord = BizCurrency.valueOf(new BigDecimal(kykHkHkRrkLst.get(0).getBfrnaiyouoriginal()));
                    }
                    else if (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITSRECORD.equals(pNaibuRcdKbn)) {
                        endttargetkijyunkingaku = BizCurrency.valueOf(new BigDecimal(kykHkHkRrkLst.get(0).getNewnaiyouoriginal()));
                        endttargetkijyungkplusrecord = BizCurrency.valueOf(new BigDecimal(kykHkHkRrkLst.get(0).getNewnaiyouoriginal()));
                    }
                }
            }
            else if (C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)){

                endttargetmokuhyouritu =  endttargetmokuhyourituplusrecord ;
                endttargetkijyunkingaku = endttargetkijyungkplusrecord;
            }
        }
        else if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null &&
            !C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn) &&
            !C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn)) {

            endttargetmokuhyouritu = pKykSyouhnHnkmaeLst.get(0).getTargettkmokuhyouti();
            endttargetkijyunkingaku = BizCurrency.valueOf(0);
        }
        else {

            if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

                SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo = SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfo.class);

                SrGetTokutejitenTokuyakuInfoBean  srGetTokutejitenTokuyakuInfoBean = srGetTokutejitenTokuyakuInfo.exec(
                    C_GetTaisyouSonotaTokuyakuKbn.TARGETTOKUYAKU,
                    C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET,
                    null,
                    pIdouMeisai.getSyono(),
                    pSuuriIdoKbn,
                    pIdouMeisai.getHenkousikibetukey(),
                    pKouryokuhasseiymd,
                    pSvKiykSyuhnDataLst,
                    pIdouMeisai.getYendthnkymd(),
                    pKykSyouhnHnkmaeLst,
                    null,
                    null,
                    pIdouMeisai.getTargettkhkumu(),
                    pIdouMeisai.getTargettkmokuhyouti(),
                    pIdouMeisai.getTargettkykkijyungk(),
                    pIdouMeisai.getTargettkykkykhenkoymd());

                endttargetmokuhyouritu = srGetTokutejitenTokuyakuInfoBean.getTargettkmokuhyoutiMae();
                endttargetmokuhyourituplusrecord = srGetTokutejitenTokuyakuInfoBean.getTargettkmokuhyoutiAto();

                endttargetkijyunkingaku = srGetTokutejitenTokuyakuInfoBean.getTargettkykkijyungkMae();
                endttargetkijyungkplusrecord = srGetTokutejitenTokuyakuInfoBean.getTargettkykkijyungkAto();
            }
            else if (C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)) {

                endttargetmokuhyouritu = endttargetmokuhyourituplusrecord;
                endttargetkijyunkingaku = endttargetkijyungkplusrecord;
            }
            else {

                if (C_SuuriIdoKbn.MUKOU.eq(pSuuriIdoKbn)) {

                    SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo = SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfo.class);

                    SrGetTokutejitenTokuyakuInfoBean srGetTokutejitenTokuyakuInfoBean = srGetTokutejitenTokuyakuInfo.exec(
                        C_GetTaisyouSonotaTokuyakuKbn.TARGETTOKUYAKU,
                        C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET,
                        pTkJitenKeiyakuSyouhinKijyunBean.getSknnkaisiymd(),
                        pIdouMeisai.getSyono(),
                        null,
                        null,
                        null,
                        pSvKiykSyuhnDataLst,
                        pIdouMeisai.getYendthnkymd(),
                        pKykSyouhnHnkmaeLst,
                        null,
                        null,
                        pIdouMeisai.getTargettkhkumu(),
                        pIdouMeisai.getTargettkmokuhyouti(),
                        pIdouMeisai.getTargettkykkijyungk(),
                        pIdouMeisai.getTargettkykkykhenkoymd());

                    endttargetmokuhyouritu = srGetTokutejitenTokuyakuInfoBean.getTargettkmokuhyoutiMae();
                    endttargetkijyunkingaku = srGetTokutejitenTokuyakuInfoBean.getTargettkykkijyungkMae();
                }
                else {

                    if (C_UmuKbn.ARI.eq(pIdouMeisai.getTargettkhkumu())) {

                        endttargetmokuhyouritu = pIdouMeisai.getTargettkmokuhyouti();
                        endttargetkijyunkingaku = pIdouMeisai.getTargettkykkijyungk();
                    }
                    else {

                        endttargetmokuhyouritu = 0;
                        endttargetkijyunkingaku = BizCurrency.valueOf(0);
                    }
                }
            }
        }

        BizNumber kykjiYoteiRiritu = BizNumber.valueOf(0);

        if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ) {
            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);
            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);
            getYoteirirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            getYoteirirituBean.setKijyunymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            getYoteirirituBean.setSknnkaisiymd(pTkJitenKeiyakuSyouhinKijyunBean.getSknnkaisiymd());
            getYoteirirituBean.setKykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
            getYoteirirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
            getYoteirirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());
            getYoteirirituBean.setSitihsyuriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt());
            getYoteirirituBean.setTuukasyu(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            C_ErrorKbn errorKbn = getYoteiriritu.exec(getYoteirirituBean);
            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "契約時予定利率",
                    pIdouMeisai.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
                errorFlag = true;
            }
            else {
                kykjiYoteiRiritu = getYoteiriritu.getYoteiriritu();
            }

        } else if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
            if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

                kykjiYoteiRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu();
            }
            else {

                kykjiYoteiRiritu = BizNumber.valueOf(0);
            }
        }
        else {

            kykjiYoteiRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu();
        }

        BizNumber tumitateRiritu = BizNumber.valueOf(0);
        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {

            tumitateRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
        }
        else if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            tumitateRiritu = yoteirirituNykn.subtract(vhireilrituNykn);
        }
        else {

            tumitateRiritu = BizNumber.valueOf(0);
        }

        String sibouhyouKbn = "";
        C_SrKbnHenkanKbn srKbnHenkanKbn = C_SrKbnHenkanKbn.BLNK;

        if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU2;
        }
        else {
            srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU;
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(srKbnHenkanKbn,
            pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, srKbnHenkanKbn.getContent(),
                pIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {

            sibouhyouKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizNumber sisuurendouRate = BizNumber.valueOf(0);

        if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() != null) {

                sisuurendouRate = BizNumber.valueOf(0);
            }
            else {

                sisuurendouRate = pTkJitenKeiyakuSyouhinKijyunBean.getKykjisisuurendourate();
            }
        }
        else {

            sisuurendouRate = BizNumber.valueOf(0);
        }

        String  sisuuKbn  = "";

        if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {
            if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.equals(
                pTkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {
                sisuuKbn = C_Sisuukbn.BLNK.getValue();
            }
            else {
                sisuuKbn = pTkJitenKeiyakuSyouhinKijyunBean.getSisuukbn().getValue();
            }

            srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_SISUU, sisuuKbn);

            if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.SUURI_SISUU.getContent(),
                    pIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getSisuukbn().getValue());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
                errorFlag = true;
            }
            else {

                sisuuKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
            }
        }
        else {

            sisuuKbn = "";
        }

        String teirituikouHyouji = "";

        if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() != null) {

            teirituikouHyouji = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            teirituikouHyouji = SrCommonConstants.HYOUJI_NASI;
        }

        BizNumber tmttknzoukaritujygn = BizNumber.valueOf(0);

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

            tmttknzoukaritujygn = pTkJitenKeiyakuSyouhinKijyunBean.getTmttknzoukaritujygn();
        }
        else {

            tmttknzoukaritujygn = BizNumber.valueOf(0);
        }

        BizNumber setteibairitu = BizNumber.valueOf(0);

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

            setteibairitu = pTkJitenKeiyakuSyouhinKijyunBean.getSetteibairitu();
        }
        else {

            setteibairitu = BizNumber.valueOf(0);
        }

        BizNumber tykzenoutouYmdSisuu = BizNumber.valueOf(0);
        BizNumber kimatuSisuu = BizNumber.valueOf(0);

        if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() != null) {

                tykzenoutouYmdSisuu = BizNumber.valueOf(0);
                kimatuSisuu = BizNumber.valueOf(0);
            }
            else {
                if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), pTmttkinInfoSyutokuKijyunYmd) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), pTmttkinInfoSyutokuKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {

                    tykzenoutouYmdSisuu = pKhSisuurendoTmttkn.getTmttknhaneisisuu();
                    kimatuSisuu = pKhSisuurendoTmttkn.getTmttknhaneisisuu();
                }
                else {
                    tykzenoutouYmdSisuu = BizNumber.valueOf(0);
                    kimatuSisuu = BizNumber.valueOf(0);
                }
            }
        }
        else {
            tykzenoutouYmdSisuu = BizNumber.valueOf(0);
            kimatuSisuu = BizNumber.valueOf(0);
        }

        BizCurrency sisuurenTumitatekin = BizCurrency.valueOf(0);
        BizCurrency sisuurentyokugotmttkn = BizCurrency.valueOf(0);

        if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {

            sisuurenTumitatekin = pKhSisuurendoTmttkn.getSisuurendoutmttkngk();
            sisuurentyokugotmttkn = pKhSisuurendoTmttkn.getSisuurendoutmttkngk();
        }
        else {

            sisuurenTumitatekin = BizCurrency.valueOf(0);
            sisuurentyokugotmttkn = BizCurrency.valueOf(0);
        }

        BizCurrency nksjitirtTumitatekin = BizCurrency.valueOf(0);

        if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {

            KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd = SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

            C_ErrorKbn keisanSisuuRendouNkTmttknOverNndResult = keisanSisuuRendouNkTmttknOverNnd.exec(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                pIdouMeisai.getTeikishrtkykhukaumu(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getBizDateYM(),
                pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

            if (C_ErrorKbn.ERROR.eq(keisanSisuuRendouNkTmttknOverNndResult)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001, "年金開始時定率部分積立金", pIdouMeisai.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

                errorFlag = true;
            }
            else {
                nksjitirtTumitatekin = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
            }
        }
        else if(pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            nksjitirtTumitatekin = nkgns;
        }
        else {

            nksjitirtTumitatekin = BizCurrency.valueOf(0);
        }

        BizCurrency kimatutirttumitatekin = BizCurrency.valueOf(0);

        if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {

            BizDateYM tumitatekinCalcKijyunYm = BizDateYM.MIN_VALUE;
            BizDate tumitatekinCalcKijyunYmd = BizDate.MIN_VALUE;

            if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), pTmttkinInfoSyutokuKijyunYmd) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), pTmttkinInfoSyutokuKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {

                KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                tumitatekinCalcKijyunYm = keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTmttkinInfoSyutokuKijyunYmd, null, null, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

                tumitatekinCalcKijyunYmd = pTmttkinInfoSyutokuKijyunYmd;
            }
            else {
                tumitatekinCalcKijyunYm = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
                tumitatekinCalcKijyunYmd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();

            }

            KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd = SWAKInjector
                .getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

            C_ErrorKbn result = keisanSisuuRendouNkTmttknOverNnd.exec(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                pIdouMeisai.getTeikishrtkykhukaumu(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                tumitatekinCalcKijyunYmd,
                tumitatekinCalcKijyunYm,
                pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

            if (C_ErrorKbn.ERROR.eq(result)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001, "期末定率部分積立金", pIdouMeisai.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

                errorFlag = true;
            }
            else {
                kimatutirttumitatekin = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
            }
        }
        else if((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            if (C_SuuriIdoKbn.MUKOU.eq(pSuuriIdoKbn)) {

                kimatutirttumitatekin = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
            }
            else {
                KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
                KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk = SWAKInjector
                    .getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

                BizDateYM calckijyunymYen = keisanWKijunYM.exec(
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                    pTmttkinInfoSyutokuKijyunYmd,
                    null,
                    null,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

                BizDateYM yendthnkymYen = keisanWKijunYM.exec(
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                    null,
                    null,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                    null);

                C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknYendtHnk.exec(
                    pTmttkinInfoSyutokuKijyunYmd,
                    calckijyunymYen,
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                    yendthnkymYen,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKihons(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    String msg = MessageUtil.getMessage(MessageId.ESA1001, "期末定率部分積立金", pIdouMeisai.getSyono());

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

                    errorFlag = true;
                }
                else {
                    kimatutirttumitatekin = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
                }
            }
        }
        else {

            kimatutirttumitatekin = BizCurrency.valueOf(0);
        }

        BizCurrency rrthnduhknvKisovKisnyu1 = BizCurrency.valueOf(0);

        if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            rrthnduhknvKisovKisnyu1 = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
        }

        BizCurrency kihrkPJtnyknBase = kihrkmpstgkNykn;
        BizCurrency keisanKihrkP = kihrkmpstgkRiron;
        BizDateYM jkipjytYm2 = jkipjytym;

        if (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            KeisanKihrkP keisanKihrkPcalc = SWAKInjector.getInstance(KeisanKihrkP.class);
            C_ErrorKbn errorKbn = keisanKihrkPcalc.exec(pIdouMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "既払込Ｐ（実入金ベース）",
                    pIdouMeisai.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
                errorFlag = true;
            }
            else {
                kihrkPJtnyknBase = BizCurrency.valueOf(0);
            }

            jkipjytYm2 = pIdouMeisai.getJkipjytym();
            keisanKihrkP = keisanKihrkPcalc.getKihrkP();
        }

        String tuukasyuKbn = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.TUUKA_SYU,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.TUUKA_SYU.getContent(),
                pIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);
            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);
            errorFlag = true;
        }
        else {
            tuukasyuKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        pIdouMeisaiTy.setZtymsyuptusshkgkaiykhnrikn(new BigDecimal(msyuPTusshkgKaiykHnrikn.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtygaikakbn(gaikaKbn);
        pIdouMeisaiTy.setZtykawaserate2(kawaserate2);
        pIdouMeisaiTy.setZtykawaseratetekiyouymd2(kwsrateKjYmd2.toString());
        pIdouMeisaiTy.setZtykykjikawaserate(kawaserate);
        pIdouMeisaiTy.setZtykykjikawaseratetkyuymd(kwsrateKjYmd.toString());
        pIdouMeisaiTy.setZtymvatyouseigow(new BigDecimal(mvatyouseigow.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtymvakeisanjisknnjynbkn(new BigDecimal(mvakeisanjisknnjynbkn.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtyrendouritu(rendouRitu);
        pIdouMeisaiTy.setZtysrkaiyakusjkkktyouseirrt(suuriyoukaiyakusjktsritu);
        pIdouMeisaiTy.setZtysrkyksjkkktyouseiriritu(srkykSjkkktyouseiriRitu);
        pIdouMeisaiTy.setZtymvakeisankijyunymd(String.valueOf(mvaKeisanKijyunYmd));
        pIdouMeisaiTy.setZtymvatyouseikou(mvatyouseikou);
        pIdouMeisaiTy.setZtyenkdtsbujsitihsyukngk(new BigDecimal(enkdtsbujsitihsyukngk.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtyenkdtsbujsitihsyucost(new BigDecimal(enkdtsbujsitihsyucost.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtyenkdtsbujsitihsyuarihyj(enkdtsbujsitihsyuarihyj);
        pIdouMeisaiTy.setZtykeiyakujiyoteiriritu(kykjiYoteiRiritu);
        pIdouMeisaiTy.setZtytumitateriritu(tumitateRiritu);
        pIdouMeisaiTy.setZtykaigomaebaraitkykarihyj(kaigomaebaraitkykarihyj);
        pIdouMeisaiTy.setZtysibouhyoukbn(sibouhyouKbn);
        pIdouMeisaiTy.setZtynyuukintuukakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pIdouMeisaiTy.setZtysiharaituukakbn(shiharaituukaKbn);
        pIdouMeisaiTy.setZtywyendttargetmokuhyouritu(String.valueOf(endttargetmokuhyouritu));
        pIdouMeisaiTy.setZtysisuurendourate(String.valueOf(sisuurendouRate));
        pIdouMeisaiTy.setZtysisuukbn(sisuuKbn);
        pIdouMeisaiTy.setZtyteirituikouhyouji(teirituikouHyouji);
        pIdouMeisaiTy.setZtysrdai1hknkkn(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn()));
        pIdouMeisaiTy.setZtytmttknzoukaritujygn(tmttknzoukaritujygn);
        pIdouMeisaiTy.setZtysetteibairitu(setteibairitu);
        pIdouMeisaiTy.setZtytykzenoutouymdsisuu(tykzenoutouYmdSisuu);
        pIdouMeisaiTy.setZtykimatusisuu(kimatuSisuu);
        pIdouMeisaiTy.setZtytuukasyukbn(tuukasyuKbn);
        pIdouMeisaiTy.setZtysisuurentumitatekin(new BigDecimal(sisuurenTumitatekin.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtynksjitirttumitatekin(new BigDecimal(nksjitirtTumitatekin.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtykimatutirttumitatekin(new BigDecimal(kimatutirttumitatekin.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtyyendttargetkijyunkingaku(new BigDecimal(endttargetkijyunkingaku.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtysisuurentyokugotmttkn(new BigDecimal(sisuurentyokugotmttkn.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtyyoteiriritujtnyknbase(yoteirirituNykn);
        pIdouMeisaiTy.setZtykihrkmpjtnyknbase(new BigDecimal(kihrkPJtnyknBase.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtysyuptumitatekin(new BigDecimal(pTumitatekinNykn.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtygaikadatenkgns(new BigDecimal(pTumitatekinNenkin.toAdsoluteString()).longValue());
        if (jkipjytYm2 == null) {
            pIdouMeisaiTy.setZtyjikaipjyuutouym2("");
        }
        else {
            pIdouMeisaiTy.setZtyjikaipjyuutouym2(String.valueOf(jkipjytYm2));
        }
        pIdouMeisaiTy.setZtyrrthnduhknvkisovkisnyu1(new BigDecimal(rrthnduhknvKisovKisnyu1.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtytumitatekin(new BigDecimal(pTumitatekinRiron.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtykiharaikomip(new BigDecimal(keisanKihrkP.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtygaikadatesyukeiyakup(new BigDecimal(gaikadateSyukeiyakuP.toAdsoluteString()).longValue());
        pIdouMeisaiTy.setZtykykkjmmvatyouseigow(new BigDecimal(kykkjmMvatyouseigow.toAdsoluteString()).longValue());
        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            pIdouMeisaiTy.setZtysibous(new BigDecimal(sibous.toAdsoluteString()).longValue());
            pIdouMeisaiTy.setZtygoukeigyousekihyjsibous(new BigDecimal(goukeigyousekihyjsibous.toAdsoluteString()).longValue());
            pIdouMeisaiTy.setZtyalmyousibous(new BigDecimal(almyousibous.toAdsoluteString()).longValue());
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {

            pIdouMeisaiTyukeiyouItzHzn.setZtymsyuptusshkgkaiykhnrikn(new BigDecimal(msyuPTusshkgKaiykHnrikn.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtygaikakbn(gaikaKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtykawaserate2(kawaserate2);
            pIdouMeisaiTyukeiyouItzHzn.setZtykawaseratetekiyouymd2(kwsrateKjYmd2.toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtykykjikawaserate(kawaserate);
            pIdouMeisaiTyukeiyouItzHzn.setZtykykjikawaseratetkyuymd(kwsrateKjYmd.toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtymvatyouseigow(new BigDecimal(mvatyouseigow.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtymvakeisanjisknnjynbkn(new BigDecimal(mvakeisanjisknnjynbkn.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyrendouritu(rendouRitu);
            pIdouMeisaiTyukeiyouItzHzn.setZtysrkaiyakusjkkktyouseirrt(suuriyoukaiyakusjktsritu);
            pIdouMeisaiTyukeiyouItzHzn.setZtysrkyksjkkktyouseiriritu(srkykSjkkktyouseiriRitu);
            pIdouMeisaiTyukeiyouItzHzn.setZtymvakeisankijyunymd(String.valueOf(mvaKeisanKijyunYmd));
            pIdouMeisaiTyukeiyouItzHzn.setZtymvatyouseikou(mvatyouseikou);
            pIdouMeisaiTyukeiyouItzHzn.setZtyenkdtsbujsitihsyukngk(new BigDecimal(enkdtsbujsitihsyukngk.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyenkdtsbujsitihsyucost(new BigDecimal(enkdtsbujsitihsyucost.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyenkdtsbujsitihsyuarihyj(enkdtsbujsitihsyuarihyj);
            pIdouMeisaiTyukeiyouItzHzn.setZtykeiyakujiyoteiriritu(kykjiYoteiRiritu);
            pIdouMeisaiTyukeiyouItzHzn.setZtytumitateriritu(tumitateRiritu);
            pIdouMeisaiTyukeiyouItzHzn.setZtykaigomaebaraitkykarihyj(kaigomaebaraitkykarihyj);
            pIdouMeisaiTyukeiyouItzHzn.setZtysibouhyoukbn(sibouhyouKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtynyuukintuukakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pIdouMeisaiTyukeiyouItzHzn.setZtysiharaituukakbn(shiharaituukaKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtywyendttargetmokuhyouritu(String.valueOf(endttargetmokuhyouritu));
            pIdouMeisaiTyukeiyouItzHzn.setZtysisuurendourate(String.valueOf(sisuurendouRate));
            pIdouMeisaiTyukeiyouItzHzn.setZtysisuukbn(sisuuKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyteirituikouhyouji(teirituikouHyouji);
            pIdouMeisaiTyukeiyouItzHzn.setZtysrdai1hknkkn(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean
                .getDai1hknkkn()));
            pIdouMeisaiTyukeiyouItzHzn.setZtytmttknzoukaritujygn(tmttknzoukaritujygn);
            pIdouMeisaiTyukeiyouItzHzn.setZtysetteibairitu(setteibairitu);
            pIdouMeisaiTyukeiyouItzHzn.setZtytykzenoutouymdsisuu(tykzenoutouYmdSisuu);
            pIdouMeisaiTyukeiyouItzHzn.setZtykimatusisuu(kimatuSisuu);
            pIdouMeisaiTyukeiyouItzHzn.setZtytuukasyukbn(tuukasyuKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtysisuurentumitatekin(new BigDecimal(sisuurenTumitatekin.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtynksjitirttumitatekin(new BigDecimal(nksjitirtTumitatekin.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtykimatutirttumitatekin(new BigDecimal(kimatutirttumitatekin.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyyendttargetkijyunkingaku(new BigDecimal(endttargetkijyunkingaku.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysisuurentyokugotmttkn(new BigDecimal(sisuurentyokugotmttkn.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyyoteiriritujtnyknbase(yoteirirituNykn);
            pIdouMeisaiTyukeiyouItzHzn.setZtykihrkmpjtnyknbase(new BigDecimal(kihrkPJtnyknBase.toAdsoluteString())
            .longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysyuptumitatekin(new BigDecimal(pTumitatekinNykn.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtygaikadatenkgns(new BigDecimal(pTumitatekinNenkin.toAdsoluteString()).longValue());
            if (jkipjytYm2 == null) {
                pIdouMeisaiTyukeiyouItzHzn.setZtyjikaipjyuutouym2("");
            }
            else {
                pIdouMeisaiTyukeiyouItzHzn.setZtyjikaipjyuutouym2(String.valueOf(jkipjytYm2));
            }
            pIdouMeisaiTyukeiyouItzHzn.setZtyrrthnduhknvkisovkisnyu1(new BigDecimal(rrthnduhknvKisovKisnyu1.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtytumitatekin(new BigDecimal(pTumitatekinRiron.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtykiharaikomip(new BigDecimal(keisanKihrkP.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtygaikadatesyukeiyakup(new BigDecimal(gaikadateSyukeiyakuP.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtykykkjmmvatyouseigow(new BigDecimal(kykkjmMvatyouseigow.toAdsoluteString()).longValue());
            if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                pIdouMeisaiTyukeiyouItzHzn.setZtysibous(new BigDecimal(sibous.toAdsoluteString()).longValue());
                pIdouMeisaiTyukeiyouItzHzn.setZtygoukeigyousekihyjsibous(new BigDecimal(goukeigyousekihyjsibous.toAdsoluteString()).longValue());
                pIdouMeisaiTyukeiyouItzHzn.setZtyalmyousibous(new BigDecimal(almyousibous.toAdsoluteString()).longValue());
            }
        }
    }

    private void editIdouMeisaiTyukeiyouItzHznData(SrIdouMeisaiBatchParam pSrIdouMeisaiBatchParam, SV_IdouMeisai pIdouMeisai,
        BizDate pTmttkinInfoSyutokuKijyunYmd, ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn,
        String pNaibuRcdKbn, String pNbHoseiHenkSkbtkey) {

        String ztysrhoseirecordhanbetukbn = pNaibuRcdKbn;
        String ztysrhoseihenkousikibetukey = pNbHoseiHenkSkbtkey;

        pIdouMeisaiTyukeiyouItzHzn.setZtysrkijyunym(String.valueOf(pSrIdouMeisaiBatchParam.getKijyunymd().getBizDateYM()));
        pIdouMeisaiTyukeiyouItzHzn.setZtysrkakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
        pIdouMeisaiTyukeiyouItzHzn.setZtysrkouryokuhasseiymd(pTmttkinInfoSyutokuKijyunYmd.toString());
        pIdouMeisaiTyukeiyouItzHzn.setZtysrhenkousikibetukey(pIdouMeisai.getHenkousikibetukey());
        pIdouMeisaiTyukeiyouItzHzn.setZtysrhoseirecordhanbetukbn(ztysrhoseirecordhanbetukbn);
        pIdouMeisaiTyukeiyouItzHzn.setZtysrhoseihenkousikibetukey(ztysrhoseihenkousikibetukey);
        pIdouMeisaiTyukeiyouItzHzn.setZtysrteikishrtkykhukaumu(pIdouMeisai.getTeikishrtkykhukaumu().getValue());

    }

    private void getHeijyunKytInfo(SrIdouMeisaiBatchParam pSrIdouMeisaiBatchParam, SV_IdouMeisai pIdouMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        C_SuuriIdoKbn pCSuuriIdoKbn, C_IdouRecordKbn pCIdouRecordKbn,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst, List<IT_HokenryouTmttkn> pHokenryouTmttknLst,
        BizDate pKouryokuhasseiymd, int pSyouhinZokusei) {

        jkipjytym = null;
        heijyunKouryokukaisiYmd = null;
        tikikktbrijyututksu = "0";
        hrkkeiro = null;
        pTumitatekinNykn = BizCurrency.valueOf(0);
        kihrkmpstgkNykn = BizCurrency.valueOf(0);
        yoteirirituNykn = BizNumber.ZERO;
        vhireilrituNykn = BizNumber.ZERO;
        pTumitatekinRiron = BizCurrency.valueOf(0);
        kihrkmpstgkRiron = BizCurrency.valueOf(0);
        pTumitatekinNenkin = BizCurrency.valueOf(0);
        gaikadateSyukeiyakuP = BizCurrency.valueOf(0);
        idoubetuKijyunYmd = null;

        BizDateYM calckijyunymNykn = null;
        BizDateYM calckijyunymRiron = null;
        BizDate sisanKawaserateKijyunYmd = null;
        boolean nkgnsSisanFlg = false ;
        boolean kykymdmaeIdouFlg = false;
        boolean idouSeiHenkouHsFlg = false;

        if (C_SuuriIdoKbn.KAIYAKU.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.GENGAKU.eq(pCSuuriIdoKbn)) {

            idoubetuKijyunYmd = pIdouMeisai.getSyoruiukeymd();
        }
        else if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn)) {

            idoubetuKijyunYmd = pIdouMeisai.getSyoriYmd();
        }
        else if (C_SuuriIdoKbn.KYKTORIKESI.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.CLGOFF.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.MUKOU.eq(pCSuuriIdoKbn)){

            idoubetuKijyunYmd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
        }
        else if (C_SuuriIdoKbn.KAIJO.eq(pCSuuriIdoKbn)) {

            idoubetuKijyunYmd = pIdouMeisai.getKouryokuhasseiymd();
        }
        else if (C_SuuriIdoKbn.SBKAIJO.eq(pCSuuriIdoKbn)) {
            idoubetuKijyunYmd = pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd();
        }
        else if (C_SuuriIdoKbn.SIBOU.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.MENSEKI.eq(pCSuuriIdoKbn)
            || C_SuuriIdoKbn.SBMUKOU_KIHRKPSHR.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.SBMUKOU_SHRNASI.eq(pCSuuriIdoKbn) ) {

            idoubetuKijyunYmd = pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetuymd();
        }

        else if (C_SuuriIdoKbn.HARAIKATAHNK.eq(pCSuuriIdoKbn)) {

            idoubetuKijyunYmd = pKouryokuhasseiymd;
        }

        SrGetTokutejitenAnsyuKihonInfo srGetTokutejitenAnsyuKihonInfo =
            SWAKInjector.getInstance(SrGetTokutejitenAnsyuKihonInfo.class);

        if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

            BizDateYM retJkipjytym = srGetTokutejitenAnsyuKihonInfo.exec(
                pIdouMeisai.getSyono(),
                null,
                pIdouMeisai.getJkipjytym(),
                pIdouMeisai.getHenkousikibetukey());

            jkipjytym = retJkipjytym;
            jkipjytymPlusRecord = retJkipjytym;

        }
        else if (C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)) {

            jkipjytym = jkipjytymPlusRecord;
        }
        else {
            if (C_SuuriIdoKbn.KAIYAKU.eq(pCSuuriIdoKbn) ||
                C_SuuriIdoKbn.KAIJO.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.SBKAIJO.eq(pCSuuriIdoKbn) ||
                C_SuuriIdoKbn.PMINYUUSYOUMETU.eq(pCSuuriIdoKbn)) {
                jkipjytym= srGetTokutejitenAnsyuKihonInfo.exec(
                    pIdouMeisai.getSyono(),
                    null,
                    pIdouMeisai.getJkipjytym(),
                    pIdouMeisai.getHenkousikibetukey());
            }
            else {
                jkipjytym = idoubetuKijyunYmd.getBizDateYM().addMonths(SrCommonConstants.KIKAN_1M);
            }
        }


        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

        if (C_SuuriIdoKbn.KAIYAKU.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.GENGAKU.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.KAIJO.eq(pCSuuriIdoKbn)
            || C_SuuriIdoKbn.SBKAIJO.eq(pCSuuriIdoKbn)) {

            if (BizDateUtil.compareYm(idoubetuKijyunYmd.getBizDateYM(), jkipjytym) ==  BizDateUtil.COMPARE_LESSER) {

                BizDate tykgoKeiyakuoutoubi = setOutoubi.exec(
                    C_TykzentykgoKbn.TYKGO,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    C_Hrkkaisuu.TUKI,
                    idoubetuKijyunYmd);

                heijyunKouryokukaisiYmd = tykgoKeiyakuoutoubi;

                if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn)) {
                    sisanKawaserateKijyunYmd = pIdouMeisai.getSyoriYmd();
                }
                else if (C_SuuriIdoKbn.GENGAKU.eq(pCSuuriIdoKbn)) {
                    if (zenkiIdouTeiseiKbnSetFlag) {
                        if (BizDateUtil.compareYmd(pSrIdouMeisaiBatchParam.getKijyunymd(), heijyunKouryokukaisiYmd) == BizDateUtil.COMPARE_LESSER) {
                            sisanKawaserateKijyunYmd = pSrIdouMeisaiBatchParam.getKijyunymd();
                        }
                        else {
                            sisanKawaserateKijyunYmd = heijyunKouryokukaisiYmd;
                        }
                    }
                    else {
                        if (BizDateUtil.compareYmd(pIdouMeisai.getSyoriYmd(), heijyunKouryokukaisiYmd) == BizDateUtil.COMPARE_LESSER) {
                            sisanKawaserateKijyunYmd = pIdouMeisai.getSyoriYmd();
                        }
                        else {
                            sisanKawaserateKijyunYmd = heijyunKouryokukaisiYmd;
                        }
                    }
                }
                else {
                    if (BizDateUtil.compareYmd(pIdouMeisai.getSyoriYmd(),
                        heijyunKouryokukaisiYmd) ==  BizDateUtil.COMPARE_LESSER) {
                        sisanKawaserateKijyunYmd = pIdouMeisai.getSyoriYmd();
                    }
                    else {
                        sisanKawaserateKijyunYmd = heijyunKouryokukaisiYmd;
                    }
                }
            }
            else {
                heijyunKouryokukaisiYmd = BizDate.valueOf(jkipjytym,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();
                sisanKawaserateKijyunYmd = BizDate.valueOf(jkipjytym,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();
            }
        }
        else if (C_SuuriIdoKbn.KYKTORIKESI.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.CLGOFF.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.MUKOU.eq(pCSuuriIdoKbn)){
            heijyunKouryokukaisiYmd = idoubetuKijyunYmd;
            sisanKawaserateKijyunYmd = pIdouMeisai.getFstpnyknymd().addBusinessDays(-1);
        }
        else if (C_SuuriIdoKbn.SIBOU.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.MENSEKI.eq(pCSuuriIdoKbn)
            || C_SuuriIdoKbn.SBMUKOU_KIHRKPSHR.eq(pCSuuriIdoKbn) ||
            C_SuuriIdoKbn.SBMUKOU_SHRNASI.eq(pCSuuriIdoKbn) ) {

            heijyunKouryokukaisiYmd = idoubetuKijyunYmd;
            sisanKawaserateKijyunYmd = idoubetuKijyunYmd;
        }
        else if (C_SuuriIdoKbn.PMINYUUSYOUMETU.eq(pCSuuriIdoKbn) ) {

            heijyunKouryokukaisiYmd = BizDate.valueOf(jkipjytym,
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();
            sisanKawaserateKijyunYmd = BizDate.valueOf(jkipjytym,
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();
        }

        else if (C_SuuriIdoKbn.HARAIKATAHNK.eq(pCSuuriIdoKbn)) {

            heijyunKouryokukaisiYmd = idoubetuKijyunYmd;

            if (BizDateUtil.compareYmd(pIdouMeisai.getSyoriYmd(),
                heijyunKouryokukaisiYmd) == BizDateUtil.COMPARE_LESSER) {

                sisanKawaserateKijyunYmd = pIdouMeisai.getSyoriYmd();

            }
            else {
                sisanKawaserateKijyunYmd = heijyunKouryokukaisiYmd;
            }
        }

        SrGetTokutejitenKykKihonInfo srGetTokutejitenKykKihonInfo =
            SWAKInjector.getInstance(SrGetTokutejitenKykKihonInfo.class);

        if (C_IdouRecordKbn.MINUSRECORD.eq(pCIdouRecordKbn)) {

            if (C_SuuriIdoKbn.GENGAKU.eq(pCSuuriIdoKbn) || (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn))) {

                SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(

                    C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN,
                    pIdouMeisai.getSyono(),
                    heijyunKouryokukaisiYmd,
                    pIdouMeisai.getHenkousikibetukey(),
                    pSvKiykSyuhnDataLst,
                    pIdouMeisai.getTikiktbrisyuruikbn(),
                    pIdouMeisai.getHrkkeiro(),
                    pIdouMeisai.getHrkkaisuu());

                tikikktbrijyututksu = srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae().getValue();
                tikikktbrijyututksuPlusRecord = srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae().getValue();
                hrkkeiro = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();
                hrkkeiroPlusRecord = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();
                hrkkaiSuu = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
                hrkkaiSuuPlusRecordn = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
            }

            else if(C_SuuriIdoKbn.HARAIKATAHNK.eq(pCSuuriIdoKbn)){

                C_KykKihonTokuteiJitenKbn kykKihonTokuteiJitenKbn = null;

                if (C_SyoriKbn.KAISUUHENKOU.eq(pIdouMeisai.getSyorikbn())
                    || (C_SyoriKbn.KAISUUHENKOU_KOUZAHENKOU.eq(pIdouMeisai.getSyorikbn()))) {

                    kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNNASI_KAISUUHNARI;
                }
                else if (C_SyoriKbn.CRECAHENNYUU.eq(pIdouMeisai.getSyorikbn())
                    || (C_SyoriKbn.YOHURIHENNYUU.eq(pIdouMeisai.getSyorikbn()))) {
                    if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_TEIKIIKKATUHNNASI;
                    }
                    else if (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN){
                        kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_KAISUUHNNASI;
                    }
                }
                else if (C_SyoriKbn.TIKIKTSYURUIHENKOU_CRECAHENNYUU.eq(pIdouMeisai.getSyorikbn())
                    || (C_SyoriKbn.TIKIKTSYURUIHENKOU_YOHURIHENNYUU.eq(pIdouMeisai.getSyorikbn()))) {
                    kykKihonTokuteiJitenKbn = C_KykKihonTokuteiJitenKbn.HRIHN_KEIROHNARI_TEIKIIKKATUHNARI;
                }
                SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(

                    kykKihonTokuteiJitenKbn,
                    pIdouMeisai.getSyono(),
                    heijyunKouryokukaisiYmd,
                    pIdouMeisai.getHenkousikibetukey(),
                    pSvKiykSyuhnDataLst,
                    pIdouMeisai.getTikiktbrisyuruikbn(),
                    pIdouMeisai.getHrkkeiro(),
                    pIdouMeisai.getHrkkaisuu());

                tikikktbrijyututksu = srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae().getValue();
                tikikktbrijyututksuPlusRecord = srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnAto().getValue();
                hrkkeiro = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();
                hrkkeiroPlusRecord = srGetTokutejitenKykKihonInfoBean.getHrkkeiroAto();
                hrkkaiSuu = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
                hrkkaiSuuPlusRecordn = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuAto();
            }

        } else if (C_IdouRecordKbn.PLUSRECORD.eq(pCIdouRecordKbn)) {
            tikikktbrijyututksu = tikikktbrijyututksuPlusRecord;
            hrkkeiro = hrkkeiroPlusRecord;
            hrkkaiSuu = hrkkaiSuuPlusRecordn;
        }
        else {

            SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(

                C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN,
                pIdouMeisai.getSyono(),
                heijyunKouryokukaisiYmd,
                null,
                pSvKiykSyuhnDataLst,
                pIdouMeisai.getTikiktbrisyuruikbn(),
                pIdouMeisai.getHrkkeiro(),
                pIdouMeisai.getHrkkaisuu());


            tikikktbrijyututksu = srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae().getValue();
            hrkkeiro = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();
            hrkkaiSuu = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
        }

        if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            if (C_SuuriIdoKbn.KAIYAKU.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.GENGAKU.eq(pCSuuriIdoKbn) ||
                C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.KAIJO.eq(pCSuuriIdoKbn)
                || C_SuuriIdoKbn.SBKAIJO.eq(pCSuuriIdoKbn)) {
                calckijyunymNykn = heijyunKouryokukaisiYmd.getBizDateYM().addMonths(-SrCommonConstants.KIKAN_1M);
                calckijyunymRiron = heijyunKouryokukaisiYmd.getBizDateYM().addMonths(-SrCommonConstants.KIKAN_1M);
            }
            else if (C_SuuriIdoKbn.KYKTORIKESI.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.CLGOFF.eq(pCSuuriIdoKbn) ||
                C_SuuriIdoKbn.MUKOU.eq(pCSuuriIdoKbn)) {

                calckijyunymNykn = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
                calckijyunymRiron = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
                nkgnsSisanFlg = true ;

                if (BizDateUtil.compareYmd(pIdouMeisai.getSyoriYmd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) ==  BizDateUtil.COMPARE_LESSER) {
                    kykymdmaeIdouFlg = true;
                }
            }
            else if (C_SuuriIdoKbn.SIBOU.eq(pCSuuriIdoKbn) ||
                C_SuuriIdoKbn.MENSEKI.eq(pCSuuriIdoKbn)
                || C_SuuriIdoKbn.SBMUKOU_KIHRKPSHR.eq(pCSuuriIdoKbn) ||
                C_SuuriIdoKbn.SBMUKOU_SHRNASI.eq(pCSuuriIdoKbn) ) {

                if (BizDateUtil.compareYmd(heijyunKouryokukaisiYmd,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) ==  BizDateUtil.COMPARE_LESSER) {
                    calckijyunymNykn = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
                    calckijyunymRiron = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
                    nkgnsSisanFlg = true ;
                    kykymdmaeIdouFlg = true;
                }
                else {

                    calckijyunymNykn = heijyunKouryokukaisiYmd.getBizDateYM();
                    calckijyunymRiron = heijyunKouryokukaisiYmd.getBizDateYM();

                }
            }
            else if (C_SuuriIdoKbn.PMINYUUSYOUMETU.eq(pCSuuriIdoKbn)) {

                calckijyunymNykn = heijyunKouryokukaisiYmd.getBizDateYM().addMonths(-SrCommonConstants.KIKAN_1M);
                calckijyunymRiron = heijyunKouryokukaisiYmd.getBizDateYM().addMonths(-SrCommonConstants.KIKAN_1M);
            }

            else if (C_SuuriIdoKbn.HARAIKATAHNK.eq(pCSuuriIdoKbn)) {

                if (BizDateUtil.compareYmd(pIdouMeisai.getSyoriYmd(), heijyunKouryokukaisiYmd) == BizDateUtil.COMPARE_LESSER) {

                    calckijyunymNykn = pIdouMeisai.getSyoriYmd().getBizDateYM();
                    calckijyunymRiron = pIdouMeisai.getSyoriYmd().getBizDateYM();
                }
                else{
                    calckijyunymNykn = heijyunKouryokukaisiYmd.getBizDateYM().addMonths(-SrCommonConstants.KIKAN_1M);
                    calckijyunymRiron = heijyunKouryokukaisiYmd.getBizDateYM().addMonths(-SrCommonConstants.KIKAN_1M);
                }
            }

            if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pCSuuriIdoKbn) &&
                !C_SyoriKbn.SEIBETUHENKOU.eq(pIdouMeisai.getSyorikbn())){

                idouSeiHenkouHsFlg = true;
            }

            SrSuuriKeisanVHeijyun srSuuriKeisanVHeijyun = SWAKInjector.getInstance(SrSuuriKeisanVHeijyun.class);

            C_ErrorKbn errorKbn = srSuuriKeisanVHeijyun.exec(
                pIdouMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean,
                pSvKiykSyuhnDataLst,
                pHokenryouTmttknLst,
                calckijyunymNykn,
                calckijyunymRiron,
                pIdouMeisai.getHrkkaisuu(),
                pIdouMeisai.getFstpnyknymd(),
                true,
                sisanKawaserateKijyunYmd,
                nkgnsSisanFlg,
                idouSeiHenkouHsFlg);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                String msg = MessageUtil.getMessage(MessageId.ESA1001, "平準払用保険料積立金", pIdouMeisai.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

                errorFlag = true;
            }
            else {

                List<SrTmttknBean> srTmttknBeanLst = srSuuriKeisanVHeijyun.getSrTmttknBeanList();

                for (SrTmttknBean srTmttknBean : srTmttknBeanLst) {

                    if (BizDateUtil.compareYm(calckijyunymNykn, srTmttknBean.getTumitateYM()) == BizDateUtil.COMPARE_EQUAL) {

                        kihrkmpstgkNykn = srTmttknBean.getKiharaikomiP();
                        yoteirirituNykn = srTmttknBean.getYoteiriritu();
                        vhireilrituNykn = srTmttknBean.getYoteiIjihirituVhirei();

                        if (kykymdmaeIdouFlg) {
                            if (C_SuuriIdoKbn.SIBOU.eq(pCSuuriIdoKbn)) {
                                pTumitatekinNykn = srTmttknBean.getTmttKngk();
                            }
                            else {
                                pTumitatekinNykn = srTmttknBean.getKiharaikomiP();
                            }
                        }
                        else {
                            if (C_SuuriIdoKbn.KYKTORIKESI.eq(pCSuuriIdoKbn) || C_SuuriIdoKbn.CLGOFF.eq(pCSuuriIdoKbn) ||
                                C_SuuriIdoKbn.MUKOU.eq(pCSuuriIdoKbn)) {
                                pTumitatekinNykn = srTmttknBean.getKiharaikomiP();
                            }
                            else {
                                pTumitatekinNykn = srTmttknBean.getTmttKngk();
                            }
                        }
                    }

                    if (BizDateUtil.compareYm(calckijyunymRiron, srTmttknBean.getTumitateYM()) == BizDateUtil.COMPARE_EQUAL) {

                        if (nkgnsSisanFlg) {
                            if (!C_SuuriIdoKbn.SIBOU.eq(pCSuuriIdoKbn)) {
                                pTumitatekinRiron = srTmttknBean.getKiharaikomiP();
                                kihrkmpstgkRiron = srTmttknBean.getKiharaikomiP();
                            }
                        }
                        else {
                            pTumitatekinRiron = srTmttknBean.getTmttKngk();
                            kihrkmpstgkRiron = srTmttknBean.getKiharaikomiP();
                        }
                    }
                }

                BizNumber lastKawaserate = null;

                if (srTmttknBeanLst.size() > 0) {
                    pTumitatekinNenkin = srTmttknBeanLst.get(srTmttknBeanLst.size() - 1).getTmttKngk();
                    lastKawaserate = srTmttknBeanLst.get(srTmttknBeanLst.size() - 1).getKawaserate();
                }

                KeisanGaikaP keisanGaikaP = SWAKInjector.getInstance(KeisanGaikaP.class);
                errorKbn = keisanGaikaP.execKawaseSitei(
                    pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                    lastKawaserate);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    String msg = MessageUtil.getMessage(MessageId.ESA1001, "外貨建主契約Ｐ", pIdouMeisai.getSyono());

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pSrIdouMeisaiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrIdouMeisaiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pIdouMeisai.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrIdouMeisaiBatchParam.setErrorSyoriKensuu(pSrIdouMeisaiBatchParam.getErrorSyoriKensuu() + 1);

                    errorFlag = true;
                }
                else {
                    gaikadateSyukeiyakuP = keisanGaikaP.getP();
                }
            }
        }
    }

    private void setHanteiZenkiIdouTeiseiKbn(SrIdouMeisaiBatchParam pSrIdouMeisaiBatchParam, SV_IdouMeisai pIdouMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        C_SuuriIdoKbn pSuuriIdoKbn) {

        zenkiIdouTeiseiKbnSetFlag = false;

        C_KessanKbn kessanTuujyouKbn = null;

        if (SrDateUtil.isKessanTuki(pSrIdouMeisaiBatchParam.getKijyunymd())) {

            kessanTuujyouKbn = C_KessanKbn.KESSAN;

        }
        else {
            kessanTuujyouKbn = C_KessanKbn.TUUJYOU;
        }

        SrIdouMeisaiBatchDbAccess srIdouMeisaiBatchDbAccess = SWAKInjector.getInstance(SrIdouMeisaiBatchDbAccess.class);

        if (C_KessanKbn.KESSAN.eq(kessanTuujyouKbn) && C_SuuriIdoKbn.GENGAKU.eq(pSuuriIdoKbn) &&
            (BizDateUtil.compareYmd(pIdouMeisai.getSyoruiukeymd(), pSrIdouMeisaiBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(pIdouMeisai.getSyoruiukeymd(), pSrIdouMeisaiBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_EQUAL) &&
            BizDateUtil.compareYmd(pSrIdouMeisaiBatchParam.getKijyunymd(), pIdouMeisai.getSyoriYmd()) == BizDateUtil.COMPARE_LESSER) {

            IT_Azukarikin wkAzukarikin = srIdouMeisaiBatchDbAccess.getAzukarikin(
                pIdouMeisai.getSyono(),
                pIdouMeisai.getHenkousikibetukey(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            if (wkAzukarikin != null) {
                zenkiIdouTeiseiKbnSetFlag = true;
            }
        }
    }
}