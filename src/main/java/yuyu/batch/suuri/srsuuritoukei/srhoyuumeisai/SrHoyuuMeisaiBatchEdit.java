package yuyu.batch.suuri.srsuuritoukei.srhoyuumeisai;

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
import yuyu.common.biz.bzcommon.GetSisuu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.KeisanGaikaP;
import yuyu.common.hozen.khcommon.KeisanKihrkP;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknOverNnd;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknYendtHnk;
import yuyu.common.hozen.khcommon.KeisanTmHntiSisuuRendouTmttkn;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.KykDairitenByPkBean;
import yuyu.common.suuri.srcommon.SetErrMessageInfoBean;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenAnsyuKihonInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenKykKihonInfoBean;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTmttknInfoBean;
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
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_HosyouKinouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KykKihonTokuteiJitenKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SkeiSoftKbn;
import yuyu.def.classification.C_SonotaTkTokuteiJitenKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SuuriAnnaiFuyouRiyuuKbn;
import yuyu.def.classification.C_SuuriHaraikataKbn;
import yuyu.def.classification.C_SuuriPWaribikitekiyouKbn;
import yuyu.def.classification.C_SuuriRyourituKbn;
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
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_HoyuuMeisaiTy;
import yuyu.def.hozen.result.bean.NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean;
import yuyu.def.suuri.configuration.YuyuSuuriConfig;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 保有明細情報作成
 */
public class SrHoyuuMeisaiBatchEdit {

    private static final int YEAR_5Y  = 5;

    private static final int YEAR_10Y  = 10;

    private static final BizNumber KAIYAKUKOUJYORITU_0005 = BizNumber.valueOf(0.005);

    private static final BizNumber KAIYAKUKOUJYORITU_001 = BizNumber.valueOf(0.01);

    private static final BizNumber KAIYAKUKOUJYORITU_002 = BizNumber.valueOf(0.02);

    private static final BizNumber KAIYAKUKOUJYORITU_0025 = BizNumber.valueOf(0.025);

    private static final BizNumber KAIYAKUKOUJYORITU_004 = BizNumber.valueOf(0.04);

    private static final BizNumber KAIYAKUKOUJYORITU_005 = BizNumber.valueOf(0.05);

    private static final BizNumber YOTEIRIRITU_0005 = BizNumber.valueOf(0.005);

    private static final BizNumber YOTEIRIRITU_0008 = BizNumber.valueOf(0.008);

    private static final BizNumber YOTEIRIRITU_00105 = BizNumber.valueOf(0.0105);

    private static final BizNumber YOTEIRIRITU_0013 = BizNumber.valueOf(0.013);

    private static final BizNumber YOTEIRIRITU_005 = BizNumber.valueOf(0.05);

    @Inject
    private BatchLogger batchLogger;

    Boolean errorFlag;

    BM_SyouhnZokusei bmSyouhnZokusei;

    private BizCurrency nkgns;

    private BizDateYM jikaiPJyuutouYm;

    private String tkIktbriSyuruiKbn;

    private SrTmttknBean tumitateKinBeanRironBase;

    private SrTmttknBean tumitateKinBeanJtnyknBase;

    private SrTmttknBean tumitateKinBeanJtnyknBaseGsc;

    private SrTmttknBean tumitateKinBeanMsukisYmBase;

    private SrTmttknBean tumitateKinBeanMsukisymBaseGsc;

    private SrTmttknBean tumitateKinBeanNkgnsBase;

    private BizCurrency pMsukisymBase;

    private BizCurrency pRironBase;

    private BizCurrency pJtnyknBase;

    private C_Hrkkeiro hrkkeiro;

    private C_Hrkkaisuu hrkkaisuu;

    public SrHoyuuMeisaiBatchEdit() {

        errorFlag = false;
        bmSyouhnZokusei = null;
        nkgns = null;
        jikaiPJyuutouYm = null;
        tkIktbriSyuruiKbn = null;
        tumitateKinBeanRironBase = null;
        tumitateKinBeanJtnyknBase = null;
        tumitateKinBeanJtnyknBaseGsc = null;
        tumitateKinBeanMsukisYmBase = null;
        tumitateKinBeanMsukisymBaseGsc = null;
        tumitateKinBeanNkgnsBase = null;
        pMsukisymBase = null;
        pRironBase = null;
        pJtnyknBase = null;
        hrkkeiro = null;
        hrkkaisuu = null;
    }

    public Boolean editKoumoku(SrHoyuuMeisaiBatchParam pSrHoyuuMeisaiBatchParam, SV_HoyuuMeisai pSvHoyuuMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean, String pSyoricd,
        ZT_HoyuuMeisaiTy pZtHoyuuMeisaiTy, ST_HoyuuMeisaiTyukeiyouItzHzn pStHoyuuMeisaiTyukeiyouItzHzn,
        int pSyouhinZokusei,
        IT_KhSisuurendoTmttkn pItKhSisuurendoTmttkn, List<IT_HokenryouTmttkn> pHokenryouTmttknLst,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst, List<IT_KykSyouhnHnkmae> pItKykSyouhnHnkmaeLst,
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList, Integer pKey) {

        SrHoyuuMeisaiBatchDbAccess srHoyuuMeisaiBatchDbAccess = SWAKInjector.
            getInstance(SrHoyuuMeisaiBatchDbAccess.class);

        bmSyouhnZokusei = srHoyuuMeisaiBatchDbAccess.getSyouhnZokusei(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());

        nkgns = BizCurrency.valueOf(0);
        jikaiPJyuutouYm = null;
        tkIktbriSyuruiKbn = null;
        tumitateKinBeanRironBase = null;
        tumitateKinBeanJtnyknBase = null;
        tumitateKinBeanJtnyknBaseGsc = null;
        tumitateKinBeanMsukisYmBase = null;
        tumitateKinBeanMsukisymBaseGsc = null;
        tumitateKinBeanNkgnsBase = null;
        pMsukisymBase = BizCurrency.valueOf(0);
        pRironBase = BizCurrency.valueOf(0);
        pJtnyknBase = BizCurrency.valueOf(0);
        hrkkeiro = C_Hrkkeiro.BLNK;
        hrkkaisuu = C_Hrkkaisuu.BLNK;

        if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            getHeijyunCommonInfo(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai,
                pTkJitenKeiyakuSyouhinKijyunBean, pSvKiykSyuhnDataLst,
                pHokenryouTmttknLst, pSyouhinZokusei) ;
        }

        editCommonData(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai,
            pTkJitenKeiyakuSyouhinKijyunBean, pSyoricd, pZtHoyuuMeisaiTy, pStHoyuuMeisaiTyukeiyouItzHzn,
            pSyouhinZokusei, pItKhSisuurendoTmttkn);

        editAlmData(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, pTkJitenKeiyakuSyouhinKijyunBean, pZtHoyuuMeisaiTy,
            pStHoyuuMeisaiTyukeiyouItzHzn, pSyouhinZokusei, pItKhSisuurendoTmttkn);

        editHeaderData(pSrHoyuuMeisaiBatchParam, pZtHoyuuMeisaiTy, pStHoyuuMeisaiTyukeiyouItzHzn, pSyouhinZokusei, pKey,
            pTkJitenKeiyakuSyouhinKijyunBean);

        editRayData(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, pTkJitenKeiyakuSyouhinKijyunBean, pZtHoyuuMeisaiTy,
            pStHoyuuMeisaiTyukeiyouItzHzn, pSyouhinZokusei, pItKhSisuurendoTmttkn, pSvKiykSyuhnDataLst,
            pItKykSyouhnHnkmaeLst, pSrGetTokutejitenTmttknInfoBeanList);

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {

            editHoyuuMeisaiItzHznDokujiData(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, pStHoyuuMeisaiTyukeiyouItzHzn);
        }
        return errorFlag;
    }

    public void editCommonData(SrHoyuuMeisaiBatchParam pSrHoyuuMeisaiBatchParam, SV_HoyuuMeisai pSvHoyuuMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean, String pSyoricd,
        ZT_HoyuuMeisaiTy pZtHoyuuMeisaiTy, ST_HoyuuMeisaiTyukeiyouItzHzn pStHoyuuMeisaiTyukeiyouItzHzn,
        int pSyouhinZokusei, IT_KhSisuurendoTmttkn pItKhSisuurendoTmttkn) {

        String toukeikijyKbn = "";

        if (pSvHoyuuMeisai.getSkeikeijyouym().getMonth() >= SrCommonConstants.MONTH_APRIL
            && pSvHoyuuMeisai.getSkeikeijyouym().getMonth() <= SrCommonConstants.MONTH_JUNE) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM().compareTo(BizDateYM.valueOf(
                pSvHoyuuMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_MARCH)) <= 0) {

                toukeikijyKbn = "1";
            }
            else if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM().compareTo(BizDateYM.valueOf(
                pSvHoyuuMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_JULY)) >= 0) {

                toukeikijyKbn = "3";
            }
            else {

                toukeikijyKbn = "0";
            }
        }
        else if (pSvHoyuuMeisai.getSkeikeijyouym().getMonth() >= SrCommonConstants.MONTH_JULY
            && pSvHoyuuMeisai.getSkeikeijyouym().getMonth() <= SrCommonConstants.MONTH_SEPTEMBER) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM().compareTo(BizDateYM.valueOf(
                pSvHoyuuMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_OCTOBER)) >= 0) {

                toukeikijyKbn = "2";
            }
            else if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM().compareTo(BizDateYM.valueOf(
                pSvHoyuuMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_JUNE)) <= 0) {

                toukeikijyKbn = "3";
            }
            else {

                toukeikijyKbn = "0";
            }
        }
        else if (pSvHoyuuMeisai.getSkeikeijyouym().getMonth() >= SrCommonConstants.MONTH_OCTOBER
            && pSvHoyuuMeisai.getSkeikeijyouym().getMonth() <= SrCommonConstants.MONTH_DECEMBER) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM().compareTo(BizDateYM.valueOf(
                pSvHoyuuMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_SEPTEMBER)) <= 0) {

                toukeikijyKbn = "2";
            }
            else if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM().compareTo(BizDateYM.valueOf(
                pSvHoyuuMeisai.getSkeikeijyouym().getNextYear().getYear(), SrCommonConstants.MONTH_JANUARY)) >= 0) {

                toukeikijyKbn = "4";
            }
            else {

                toukeikijyKbn = "0";
            }
        }
        else {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM().compareTo(BizDateYM.valueOf(
                pSvHoyuuMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_APRIL)) >= 0) {

                toukeikijyKbn = "1";

            }
            else if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM().compareTo(BizDateYM.valueOf(
                pSvHoyuuMeisai.getSkeikeijyouym().getPreviousYear().getYear(),
                SrCommonConstants.MONTH_DECEMBER)) <= 0) {

                toukeikijyKbn = "4";
            }
            else {

                toukeikijyKbn = "0";
            }
        }

        String datakanriNo = pSvHoyuuMeisai.getSyono();

        String suuriSyuruiCd = "";
        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(C_SrKbnHenkanKbn.SUURISYURUI,
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1006, C_SrKbnHenkanKbn.SUURISYURUI.getContent(),
                pSvHoyuuMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);
            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);

        }
        else {
            suuriSyuruiCd = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        C_HosyouKinouKbn hosyouKinouKbn = null;
        C_DaiKbn daiKbn = null;
        C_TyuuKbn tyuuKbn = null;
        C_SyouKbn syouKbn = null;
        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        String kbnkeiriyousegmentKbn = "";
        String kbnkeiriyourgnbnskKbn = "";

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            hosyouKinouKbn = C_HosyouKinouKbn.BLNK;

        }
        else {
            hosyouKinouKbn = C_HosyouKinouKbn.SIBOU;
        }

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

        if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {
            String msg = MessageUtil.getMessage(MessageId.ESA1007, SrCommonConstants.MSGHYOUJIMOJIRETU_SEGCD,
                pSvHoyuuMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
        }
        else {
            kbnkeiriyousegmentKbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(0, 2);

            kbnkeiriyourgnbnskKbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(
                syouhinbetuSegmentBean.getSegcd1().getValue().length() - 2,
                syouhinbetuSegmentBean.getSegcd1().getValue().length());
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu())) {

                daiKbn = C_DaiKbn.NNKNTKYK_SISUURENDOU;
                tyuuKbn = C_TyuuKbn.ENKATEIGAKUNNKN;
                syouKbn = C_SyouKbn.ENKATEIGAKUNNKN;
            }
            else {

                daiKbn = C_DaiKbn.KOJINNENKIN_SISUU;
                tyuuKbn = C_TyuuKbn.SITEITUKANNKN;
                syouKbn = C_SyouKbn.SITEITUKANNKN;
            }
            if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20){

                syouKbn = C_SyouKbn.SITEITUKANNKN_20;
            }
        }
        else if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN){

            daiKbn = C_DaiKbn.KOJINNENKIN_SISUU;
            tyuuKbn = C_TyuuKbn.YOTEIRRT_SITEITUKANNKN;
            syouKbn = C_SyouKbn.YOTEIRRT_SITEITUKANNKN;
        }
        else if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

            daiKbn = C_DaiKbn.SITEITUKASYSN;

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                tyuuKbn = C_TyuuKbn.YENDATESYSN_HNK;
                syouKbn = C_SyouKbn.SITEITUKASYSN_19_2GATA_HNK;
            }
            else {

                tyuuKbn = C_TyuuKbn.SITEITUKASYSN;
                syouKbn = C_SyouKbn.SITEITUKASYSN_19_2GATA;
            }

        }
        else if(pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN){
            if (C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {

                daiKbn = C_DaiKbn.SYSN;
                tyuuKbn = C_TyuuKbn.SYSN;
                syouKbn = C_SyouKbn.SENTAKUTUKASYSN_JPY;
            }
            else {

                daiKbn = C_DaiKbn.SITEITUKASYSN;
                tyuuKbn = C_TyuuKbn.SITEITUKASYSN;
                syouKbn = C_SyouKbn.SENTAKUTUKASYSN_USD;
            }

        }
        else {

            daiKbn = C_DaiKbn.SITEITUKASYSN;

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
                tyuuKbn = C_TyuuKbn.YENDATESYSN_HNK;
                syouKbn = C_SyouKbn.SITEITUKASYSN_HNK;
            }
            else {
                tyuuKbn = C_TyuuKbn.SITEITUKASYSN;
                syouKbn = C_SyouKbn.SITEITUKASYSN;
            }
        }

        String sedaiKbn = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SEDAI,
            pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.SEDAI.getContent(),
                pSvHoyuuMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

            batchLogger.warn(msg);
            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);

        }
        else {
            sedaiKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }
        String haraikataKbn = "";
        if (C_Kykjyoutai.ITIJIBARAI.eq((pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai()))) {
            haraikataKbn = C_SuuriHaraikataKbn.ITIJI.getValue();
        }
        else {
            if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {
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
            else if (C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {
                haraikataKbn = C_SuuriHaraikataKbn.HALFY.getValue();
            }
            else if (C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {
                haraikataKbn = C_SuuriHaraikataKbn.NEN.getValue();
            }
        }

        String saimnkkykhyj = "";

        if (C_HknkknsmnKbn.SAIMANKI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn())) {
            saimnkkykhyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            saimnkkykhyj = SrCommonConstants.HYOUJI_NASI;
        }

        String annaiFuyouRiyuuKbn ="";
        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            annaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ITIJI.getValue();
        }
        else {
            annaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ANNAITYUU.getValue();
        }

        String hrkKaisuuKbn = pSvHoyuuMeisai.getHrkkaisuu().getValue();

        if(!C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())){
            hrkKaisuuKbn = hrkkaisuu.getValue();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.HRK_KAISUU, hrkKaisuuKbn);

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KAISUU.getContent(),
                pSvHoyuuMeisai.getSyono(),
                hrkKaisuuKbn);

            batchLogger.warn(msg);
            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);

        }
        else {
            hrkKaisuuKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String hrkKeiroKbn = "";

        if (C_Kykjyoutai.ITIJIBARAI.eq((pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai()))) {

            hrkKeiroKbn = pSvHoyuuMeisai.getHrkkeiro().getValue();
        }
        else {
            hrkKeiroKbn = hrkkeiro.getValue();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.HRK_KEIRO, hrkKeiroKbn);

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KEIRO.getContent(),
                pSvHoyuuMeisai.getSyono(),
                hrkKeiroKbn);

            batchLogger.warn(msg);
            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);

        }
        else {
            hrkKeiroKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String ryourituKbn = "";
        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            ryourituKbn = C_SuuriRyourituKbn.OTHER.getValue();

        }
        else {
            if (C_Hrkkaisuu.NEN.eq(hrkkaisuu) || C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {
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

        long syuKeiyakuP = 0;

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {
            syuKeiyakuP = new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString())
            .longValue();
        }

        long kihonS = 0;

        if (pSyouhinZokusei != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR &&
            pSyouhinZokusei != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            kihonS = new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getKihons().toAdsoluteString()).longValue();
        }

        long sibouS = 0;

        if (pSyouhinZokusei != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR &&
            pSyouhinZokusei != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                sibouS = 0;
            }
            else {

                sibouS = new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getKihons().toAdsoluteString()).longValue();
            }
        }

        BizDate henkouYmd = null;

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null &&
            pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() != null) {
            henkouYmd = pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd();
        }
        else {

            henkouYmd = pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd();
        }

        String todoufukencd =  pSvHoyuuMeisai.getDrtenkanritodoufukencd();
        if (C_TodouhukenKbn.BLNK.getValue().equals(todoufukencd)){
            todoufukencd = C_TodouhukenKbn.OSAKA.getValue();
        }

        String kanyujiDatakanriNo = datakanriNo;

        String misyuuStartYm = "";
        int misyuuKaisuuTkkn = 0;

        if ((pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) &&
            (BizDateUtil.compareYm(jikaiPJyuutouYm, pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM()) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYm(jikaiPJyuutouYm, pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM()) == BizDateUtil.COMPARE_EQUAL )) {
            misyuuStartYm = jikaiPJyuutouYm.toString();
            misyuuKaisuuTkkn = BizDateUtil.calcDifferenceMonths(
                pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM().addMonths(SrCommonConstants.KIKAN_1M), jikaiPJyuutouYm);
        }

        String kykJyoutai = pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai().getValue();

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.KYK_JYOUTAI, kykJyoutai);

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.KYK_JYOUTAI.getContent(),
                pSvHoyuuMeisai.getSyono(),
                kykJyoutai);

            batchLogger.warn(msg);
            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);

        }
        else {
            kykJyoutai = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        C_ALMSoftKbn aLMSoftKbn = null;

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            aLMSoftKbn = C_ALMSoftKbn.BLNK;
        }
        else if (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN){
            aLMSoftKbn = C_ALMSoftKbn.SYSN;
        }
        else {
            aLMSoftKbn = C_ALMSoftKbn.ITIJIBRSYSN;
        }

        C_SkeiSoftKbn skeiSoftKbn = null;

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            skeiSoftKbn = C_SkeiSoftKbn.TANTAI;
        }
        else {
            skeiSoftKbn = C_SkeiSoftKbn.SONOTA;
        }

        String nenkinKaisiNendo = "";

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getMonth() >= SrCommonConstants.MONTH_APRIL) {
                nenkinKaisiNendo = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getYear());
            }
            else {
                nenkinKaisiNendo = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getYear()
                    - SrCommonConstants.YEAR_1Y);
            }
        }

        String nenkingataKbn = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.NENKINGATA,
            pTkJitenKeiyakuSyouhinKijyunBean.getNksyukbn().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.NENKINGATA.getContent(),
                pSvHoyuuMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getNksyukbn().getValue());

            batchLogger.warn(msg);
            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
        }
        else {
            nenkingataKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String nksiharaiKikan = "";

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getNenkinkkn() == SrCommonConstants.NENKINKIKAN_SOUGAKUHOSYOUSYUUSHIN) {

                nksiharaiKikan = SrCommonConstants.DEFAULT_STRING_ZERO_2;
            }
            else {

                nksiharaiKikan = pTkJitenKeiyakuSyouhinKijyunBean.getNenkinkkn().toString();
            }
        }
        else {
            nksiharaiKikan = SrCommonConstants.DEFAULT_STRING_ZERO_2;
        }

        String bosyuKeitaiKbn = "";
        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.BOSYU_KEITAI, pSvHoyuuMeisai.getDrtencd());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                pSvHoyuuMeisai.getSyono(),
                pSvHoyuuMeisai.getDrtencd());

            batchLogger.warn(msg);
            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);

        }
        else {
            bosyuKeitaiKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String sinsaKbn = "";

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            sinsaKbn = SrCommonConstants.SINSAKBN_SONOTA;
        }
        else {
            sinsaKbn = SrCommonConstants.SINSAKBN_KOKUTI;
        }

        String toukeiyouSinsaKbn = "";

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            toukeiyouSinsaKbn = SrCommonConstants.TOUKEIYOUSINSAKBN_MUSENTAKU;
        }
        else {
            toukeiyouSinsaKbn = SrCommonConstants.TOUKEIYOUSINSAKBN_KOKUTISYO;
        }

        String anniskCd = "";

        if (!C_Kykjyoutai.ITIJIBARAI.eq((pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai()))) {
            if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {

                anniskCd = SrCommonConstants.ANNISKCD_CREDITHR;
            }
        }

        long sibouKyuuhukin = 0;

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pSrHoyuuMeisaiBatchParam.getKijyunymd()) <= BizDateUtil.COMPARE_EQUAL) {
                BizDate sbKhkCalckijyunYmd = pSrHoyuuMeisaiBatchParam.getKijyunymd();

                BizDate sjkkkTsyRirituKijyunYmd = null;
                if (BizDateUtil.COMPARE_LESSER == BizDateUtil.compareYmd(pSrHoyuuMeisaiBatchParam.getSyoriYmd(),
                    pSrHoyuuMeisaiBatchParam.getKijyunymd())) {
                    sjkkkTsyRirituKijyunYmd = pSrHoyuuMeisaiBatchParam.getSyoriYmd();
                }
                else {
                    sjkkkTsyRirituKijyunYmd = pSrHoyuuMeisaiBatchParam.getKijyunymd();
                }
                GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector
                    .getInstance(GetSjkkktyouseiyouriritu.class);
                GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector
                    .getInstance(GetSjkkktyouseiyourirituBean.class);
                BizNumber kaiyakuSjkkTyouseiRiritu = BizNumber.valueOf(0);
                BizDateYM tmttkntaisyouym = null;
                BizCurrency teirituTmttkngk = BizCurrency.valueOf(0);
                BizCurrency sisuuTmttkngk = BizCurrency.valueOf(0);

                if (!C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu())) {

                    getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                    getSjkkktyouseiyourirituBean.setKijyunymd(sjkkkTsyRirituKijyunYmd);
                    getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
                    getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
                    getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

                    C_ErrorKbn errorKbn1 = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                    if (C_ErrorKbn.ERROR.eq(errorKbn1)) {
                        String msg = MessageUtil.getMessage(MessageId.ESA1001,
                            "市場価格調整用利率",
                            pSvHoyuuMeisai.getSyono());
                        batchLogger.warn(msg);
                        createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
                    }
                    else {
                        kaiyakuSjkkTyouseiRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                    }

                    KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                    BizDateYM kijunNengetu = keisanWKijunYM.exec(
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pSrHoyuuMeisaiBatchParam.getKijyunymd(),
                        null,
                        null,
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

                    if (BizDateUtil.calcDifferenceMonths(kijunNengetu,
                        pItKhSisuurendoTmttkn.getTmttkntaisyouym()) > SrCommonConstants.KIKAN_12M) {

                        int keikamon = BizDateUtil.calcDifferenceMonths(
                            pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM(),
                            pItKhSisuurendoTmttkn.getTmttkntaisyouym());

                        int keikanensuu = keikamon / SrCommonConstants.KIKAN_12M;

                        tmttkntaisyouym = pItKhSisuurendoTmttkn.getTmttkntaisyouym().addYears(keikanensuu);

                        BizDate tmttkntaisyouymd = BizDate.valueOf(tmttkntaisyouym,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();

                        KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd =
                            SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);
                        C_ErrorKbn errorKbn3 = keisanSisuuRendouNkTmttknOverNnd.exec(
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                            pSvHoyuuMeisai.getTeikishrtkykhukaumu(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                            tmttkntaisyouymd,
                            tmttkntaisyouym,
                            pItKhSisuurendoTmttkn.getTmttkntaisyouym(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                            pItKhSisuurendoTmttkn.getTeiritutmttkngk(),
                            pItKhSisuurendoTmttkn.getSisuurendoutmttkngk());

                        if (errorKbn3.eq(C_ErrorKbn.ERROR)) {
                            String msg = MessageUtil.getMessage(MessageId.ESA1001,
                                "積立金計算：死亡給付金",
                                pSvHoyuuMeisai.getSyono());
                            batchLogger.warn(msg);
                            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
                        }
                        else {

                            teirituTmttkngk = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
                            sisuuTmttkngk = keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk();
                        }
                    }
                    else {

                        tmttkntaisyouym = pItKhSisuurendoTmttkn.getTmttkntaisyouym();
                        teirituTmttkngk = pItKhSisuurendoTmttkn.getTeiritutmttkngk();
                        sisuuTmttkngk = pItKhSisuurendoTmttkn.getSisuurendoutmttkngk();
                    }
                }

                if (!errorFlag) {
                    CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);
                    C_ErrorKbn errorKbn2 = calcHkShrKngk.exec(
                        pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu(),
                        pSvHoyuuMeisai.getHrkkaisuu(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKihons(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        sbKhkCalckijyunYmd,
                        pSvHoyuuMeisai.getSyono(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn(),
                        C_SiinKbn.SP,
                        C_HokenkinsyuruiKbn.SBHOKENKIN,
                        pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou(),
                        kaiyakuSjkkTyouseiRiritu,
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu(),
                        tmttkntaisyouym,
                        teirituTmttkngk,
                        sisuuTmttkngk,
                        pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                        pSvHoyuuMeisai.getSdpdkbn(),
                        pSvHoyuuMeisai.getHrkkeiro());

                    if (C_ErrorKbn.ERROR.eq(errorKbn2)) {

                        String msg = MessageUtil.getMessage(MessageId.ESA1001, "死亡給付金",
                            pSvHoyuuMeisai.getSyono());

                        batchLogger.warn(msg);
                        createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
                    }
                    else {
                        sibouKyuuhukin = new BigDecimal(calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk()
                            .toAdsoluteString()).longValue();
                    }
                }
            }
            else {
                sibouKyuuhukin = new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString())
                .longValue();
            }
        }
        else if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            if (tumitateKinBeanRironBase != null) {
                sibouKyuuhukin = new BigDecimal(tumitateKinBeanRironBase.getKiharaikomiP().toAdsoluteString())
                .longValue();
            }
        }

        String haitouKbn = "";
        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_HAITOU,
            bmSyouhnZokusei.getHaitoukbn().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.SUURI_HAITOU.getContent(),
                pSvHoyuuMeisai.getSyono(),
                bmSyouhnZokusei.getHaitoukbn().getValue());

            batchLogger.warn(msg);
            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);

        }
        else {
            haitouKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);
        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

        int hhknHkNenrei = setHokenNenrei.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHhknseiymd());

        int hhknnen = pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().intValue();

        String hhknnentysihyj = "";
        if (hhknHkNenrei != hhknnen) {

            hhknnentysihyj = SrCommonConstants.HYOUJI_ARI;

        }
        else {

            hhknnentysihyj = SrCommonConstants.HYOUJI_NASI;

        }

        int kyknenAfter = 0;

        int kyknen = setNenrei.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pSvHoyuuMeisai.getKykseiymd());

        if (kyknen <= 99) {

            kyknenAfter = kyknen;
        }

        String kyksyanentysihyj = "";
        int kykHkNenrei = setHokenNenrei.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pSvHoyuuMeisai.getKykseiymd());

        if (kyknen != kykHkNenrei) {

            kyksyanentysihyj = SrCommonConstants.HYOUJI_ARI;

        }
        else {
            kyksyanentysihyj = SrCommonConstants.HYOUJI_NASI;
        }


        pZtHoyuuMeisaiTy.setZtyrecordkbn(SrCommonConstants.RECORDKBN_HOYUUMEISAI);
        pZtHoyuuMeisaiTy.setZtykeijyouym(pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM().toString());
        pZtHoyuuMeisaiTy.setZtykeijyouctrlkbn(SrCommonConstants.KIJYCTRLKBN_SONOTA);
        pZtHoyuuMeisaiTy.setZtyhenkousyoriymd(pSrHoyuuMeisaiBatchParam.getKijyunymd().toString());
        pZtHoyuuMeisaiTy.setZtysuuriyoukouryokukaisiymd(pSrHoyuuMeisaiBatchParam.getKijyunymd().toString());
        pZtHoyuuMeisaiTy.setZtydenymd(pSrHoyuuMeisaiBatchParam.getSyoriYmd().toString());
        pZtHoyuuMeisaiTy.setZtytoukeikeijyoukbn(toukeikijyKbn);
        pZtHoyuuMeisaiTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pZtHoyuuMeisaiTy.setZtybsyym(pSvHoyuuMeisai.getBosyuuym().toString());
        pZtHoyuuMeisaiTy.setZtysyoricd(pSyoricd);
        pZtHoyuuMeisaiTy.setZtydatakanrino(datakanriNo);
        pZtHoyuuMeisaiTy.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        pZtHoyuuMeisaiTy.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
        pZtHoyuuMeisaiTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
        pZtHoyuuMeisaiTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pZtHoyuuMeisaiTy.setZtystdssnskbn(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
        pZtHoyuuMeisaiTy.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
        pZtHoyuuMeisaiTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
        pZtHoyuuMeisaiTy.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
        pZtHoyuuMeisaiTy.setZtykbnkeiriyousegmentkbn(kbnkeiriyousegmentKbn);
        pZtHoyuuMeisaiTy.setZtykbnkeiriyourgnbnskkbn(kbnkeiriyourgnbnskKbn);
        pZtHoyuuMeisaiTy.setZtysuurisyuruicd(suuriSyuruiCd);
        pZtHoyuuMeisaiTy.setZtyhosyoukinoukbn(hosyouKinouKbn.getValue());
        pZtHoyuuMeisaiTy.setZtydaikbn(daiKbn.getValue());
        pZtHoyuuMeisaiTy.setZtytyuukbn(tyuuKbn.getValue());
        pZtHoyuuMeisaiTy.setZtysyoukbn(syouKbn.getValue());
        pZtHoyuuMeisaiTy.setZtysedaikbn(sedaiKbn);
        pZtHoyuuMeisaiTy.setZtyharaikatakbn(haraikataKbn);
        pZtHoyuuMeisaiTy.setZtykykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        pZtHoyuuMeisaiTy.setZtyhknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().toString());
        pZtHoyuuMeisaiTy.setZtyphrkkikn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn().toString());
        pZtHoyuuMeisaiTy.setZtysaimnkkykhyj(saimnkkykhyj);
        pZtHoyuuMeisaiTy.setZtyannaifuyouriyuukbn(annaiFuyouRiyuuKbn);
        pZtHoyuuMeisaiTy.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
        pZtHoyuuMeisaiTy.setZtyhrkkaisuukbn(hrkKaisuuKbn);
        pZtHoyuuMeisaiTy.setZtyhrkkeirokbn(hrkKeiroKbn);
        pZtHoyuuMeisaiTy.setZtysdpdkbn(pSvHoyuuMeisai.getSdpdkbn().getValue());
        pZtHoyuuMeisaiTy.setZtyryouritukbn(ryourituKbn);
        pZtHoyuuMeisaiTy.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());
        pZtHoyuuMeisaiTy.setZtyhihokensyaagev2(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        pZtHoyuuMeisaiTy.setZtykyksyanen(String.valueOf(kyknenAfter));
        pZtHoyuuMeisaiTy.setZtytkbthsyumnryuhyouji(SrCommonConstants.HYOUJI_NASI);
        pZtHoyuuMeisaiTy.setZtysyukeiyakupwaribikikbn(syukeiyakuPWaribikiKbn);
        pZtHoyuuMeisaiTy.setZtytenkanwaribikikbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZtHoyuuMeisaiTy.setZtyyuuhitutnknyuguryurtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZtHoyuuMeisaiTy.setZtysyukeiyakup(syuKeiyakuP);
        pZtHoyuuMeisaiTy.setZtykihons(kihonS);
        pZtHoyuuMeisaiTy.setZtysibous(sibouS);
        if (henkouYmd != null) {
            pZtHoyuuMeisaiTy.setZtyhenkouymd(henkouYmd.toString());

        }
        pZtHoyuuMeisaiTy.setZtyatukaisisyatodouhukencd(todoufukencd);
        pZtHoyuuMeisaiTy.setZtytokuyakuhukasuu(SrCommonConstants.DEFAULT_INT_ZERO);
        pZtHoyuuMeisaiTy.setZtyhrimnentyoumaephrkkkn(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pZtHoyuuMeisaiTy.setZtytokubetuhosyoukikan(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pZtHoyuuMeisaiTy.setZtykousinmanryouage(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pZtHoyuuMeisaiTy.setZtykanyujidatakanrino(kanyujiDatakanriNo);
        pZtHoyuuMeisaiTy.setZtykanyujikykymd(pTkJitenKeiyakuSyouhinKijyunBean.
            getKykymd().toString());
        pZtHoyuuMeisaiTy.setZtykanyuujihihokensyaage(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        pZtHoyuuMeisaiTy.setZtymisyuustartym(misyuuStartYm);
        pZtHoyuuMeisaiTy.setZtymisyuukaisuu(String.valueOf(misyuuKaisuuTkkn));
        pZtHoyuuMeisaiTy.setZtykykjyoutai(kykJyoutai);
        pZtHoyuuMeisaiTy.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
        pZtHoyuuMeisaiTy.setZtysykykhokenhoutekiyouhyj(SrCommonConstants.HYOUJI_ARI);
        pZtHoyuuMeisaiTy.setZtyalmyousohutomeisyoukbn(aLMSoftKbn.getValue());
        pZtHoyuuMeisaiTy.setZtysnkyksoftmeisyoukbn(skeiSoftKbn.getValue());
        pZtHoyuuMeisaiTy.setZtynenkinkaisinendo(nenkinKaisiNendo);
        pZtHoyuuMeisaiTy.setZtynenkingatakbn(nenkingataKbn);
        pZtHoyuuMeisaiTy.setZtynknshry(nksiharaiKikan);
        pZtHoyuuMeisaiTy.setZtysiktsyuknbyugnhsyunshyj(SrCommonConstants.HYOUJI_NASI);
        pZtHoyuuMeisaiTy.setZtypmensugugtganhsyunshyj(SrCommonConstants.HYOUJI_NASI);
        pZtHoyuuMeisaiTy.setZtytkykgyousekihyjszerohyj(SrCommonConstants.HYOUJI_NASI);
        pZtHoyuuMeisaiTy.setZtybosyuukeitaikbn(bosyuKeitaiKbn);
        pZtHoyuuMeisaiTy.setZtyaatukaisosikicd(pSvHoyuuMeisai.getDrtenkanrisosikicd());
        pZtHoyuuMeisaiTy.setZtyaatukaikojincd(pSvHoyuuMeisai.getDaibosyuucd());
        pZtHoyuuMeisaiTy.setZtybsydrtencd(pSvHoyuuMeisai.getDrtencd());
        pZtHoyuuMeisaiTy.setZtycifcd(pSvHoyuuMeisai.getCifcd());
        pZtHoyuuMeisaiTy.setZtysinsakbn(sinsaKbn);
        pZtHoyuuMeisaiTy.setZtytoukeiyousinsakbn(toukeiyouSinsaKbn);
        pZtHoyuuMeisaiTy.setZtyketteikijyunkanwakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZtHoyuuMeisaiTy.setZtysykgycd(pSvHoyuuMeisai.getHhknsykgycd());
        pZtHoyuuMeisaiTy.setZtyanniskcd(anniskCd);
        pZtHoyuuMeisaiTy.setZtydakuhikettikekkacd(pSvHoyuuMeisai.getKetkekkacd().getValue());
        pZtHoyuuMeisaiTy.setZtysiboukyuuhukin(sibouKyuuhukin);
        pZtHoyuuMeisaiTy.setZtyhaitoukbn(haitouKbn);
        pZtHoyuuMeisaiTy.setZtyhhknnentysihyj(hhknnentysihyj);
        pZtHoyuuMeisaiTy.setZtykyksyaagetyouseihyj(kyksyanentysihyj);
        pZtHoyuuMeisaiTy.setZtykituenkbn(SrCommonConstants.KITUENKBN_HUMEI);
        pZtHoyuuMeisaiTy.setZtymusentakukeiyakukbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZtHoyuuMeisaiTy.setZtydakuhikettisyacd(pSvHoyuuMeisai.getPalketsyacd());
        pZtHoyuuMeisaiTy.setZtytargetmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        pZtHoyuuMeisaiTy.setZtyautoswitchmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        pZtHoyuuMeisaiTy.setZtytumitatekinitenarihyj(SrCommonConstants.HYOUJI_NASI);
        pZtHoyuuMeisaiTy.setZtytumitatekinitenkaisuu(SrCommonConstants.DEFAULT_STRING_ZERO_3);


        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyrecordkbn(SrCommonConstants.RECORDKBN_HOYUUMEISAI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykeijyouym(pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM()
                .toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykeijyouctrlkbn(SrCommonConstants.KIJYCTRLKBN_SONOTA);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhenkousyoriymd(pSrHoyuuMeisaiBatchParam.getKijyunymd().toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysuuriyoukouryokukaisiymd(pSrHoyuuMeisaiBatchParam.getKijyunymd()
                .toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtydenymd(pSrHoyuuMeisaiBatchParam.getSyoriYmd().toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytoukeikeijyoukbn(toukeikijyKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtybsyym(pSvHoyuuMeisai.getBosyuuym().toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysyoricd(pSyoricd);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtydatakanrino(datakanriNo);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean
                .getRyouritusdno());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtystdssnskbn(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykbnkeiriyousegmentkbn(kbnkeiriyousegmentKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykbnkeiriyourgnbnskkbn(kbnkeiriyourgnbnskKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysuurisyuruicd(suuriSyuruiCd);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhosyoukinoukbn(hosyouKinouKbn.getValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtydaikbn(daiKbn.getValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytyuukbn(tyuuKbn.getValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysyoukbn(syouKbn.getValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysedaikbn(sedaiKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyharaikatakbn(haraikataKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyphrkkikn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn().toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysaimnkkykhyj(saimnkkykhyj);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyannaifuyouriyuukbn(annaiFuyouRiyuuKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhrkkaisuukbn(hrkKaisuuKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhrkkeirokbn(hrkKeiroKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysdpdkbn(pSvHoyuuMeisai.getSdpdkbn().getValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyryouritukbn(ryourituKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().getValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhihokensyaagev2(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen()
                .toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykyksyanen(String.valueOf(kyknenAfter));
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytkbthsyumnryuhyouji(SrCommonConstants.HYOUJI_NASI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysyukeiyakupwaribikikbn(syukeiyakuPWaribikiKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytenkanwaribikikbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyyuuhitutnknyuguryurtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysyukeiyakup(syuKeiyakuP);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykihons(kihonS);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysibous(sibouS);
            if (henkouYmd != null) {
                pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhenkouymd(henkouYmd.toString());

            }
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyatukaisisyatodouhukencd(todoufukencd);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytokuyakuhukasuu(SrCommonConstants.DEFAULT_INT_ZERO);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhrimnentyoumaephrkkkn(SrCommonConstants.DEFAULT_STRING_ZERO_2);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytokubetuhosyoukikan(SrCommonConstants.DEFAULT_STRING_ZERO_2);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykousinmanryouage(SrCommonConstants.DEFAULT_STRING_ZERO_2);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykanyujidatakanrino(kanyujiDatakanriNo);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykanyujikykymd(pTkJitenKeiyakuSyouhinKijyunBean.
                getKykymd().toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykanyuujihihokensyaage(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen()
                .toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtymisyuustartym(misyuuStartYm);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtymisyuukaisuu(String.valueOf(misyuuKaisuuTkkn));
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykykjyoutai(kykJyoutai);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysykykhokenhoutekiyouhyj(SrCommonConstants.HYOUJI_ARI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyalmyousohutomeisyoukbn(aLMSoftKbn.getValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysnkyksoftmeisyoukbn(skeiSoftKbn.getValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtynenkinkaisinendo(nenkinKaisiNendo);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtynenkingatakbn(nenkingataKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtynknshry(nksiharaiKikan);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysiktsyuknbyugnhsyunshyj(SrCommonConstants.HYOUJI_NASI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtypmensugugtganhsyunshyj(SrCommonConstants.HYOUJI_NASI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytkykgyousekihyjszerohyj(SrCommonConstants.HYOUJI_NASI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtybosyuukeitaikbn(bosyuKeitaiKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyaatukaisosikicd(pSvHoyuuMeisai.getDrtenkanrisosikicd());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyaatukaikojincd(pSvHoyuuMeisai.getDaibosyuucd());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtybsydrtencd(pSvHoyuuMeisai.getDrtencd());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtycifcd(pSvHoyuuMeisai.getCifcd());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysinsakbn(sinsaKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytoukeiyousinsakbn(toukeiyouSinsaKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyketteikijyunkanwakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysykgycd(pSvHoyuuMeisai.getHhknsykgycd());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyanniskcd(anniskCd);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtydakuhikettikekkacd(pSvHoyuuMeisai.getKetkekkacd().getValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysiboukyuuhukin(sibouKyuuhukin);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhaitoukbn(haitouKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhhknnentysihyj(hhknnentysihyj);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykyksyaagetyouseihyj(kyksyanentysihyj);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykituenkbn(SrCommonConstants.KITUENKBN_HUMEI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtymusentakukeiyakukbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtydakuhikettisyacd(pSvHoyuuMeisai.getPalketsyacd());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytargetmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyautoswitchmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytumitatekinitenarihyj(SrCommonConstants.HYOUJI_NASI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytumitatekinitenkaisuu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        }
    }

    public void editAlmData(SrHoyuuMeisaiBatchParam pSrHoyuuMeisaiBatchParam, SV_HoyuuMeisai pSvHoyuuMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean, ZT_HoyuuMeisaiTy pZtHoyuuMeisaiTy,
        ST_HoyuuMeisaiTyukeiyouItzHzn pStHoyuuMeisaiTyukeiyouItzHzn, int pSyouhinZokusei,
        IT_KhSisuurendoTmttkn pItKhSisuurendoTmttkn) {

        String kyKhhknDouhyouji = "";
        if (C_Tdk.HONNIN.eq(pSvHoyuuMeisai.getKkkyktdk())) {

            kyKhhknDouhyouji = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            kyKhhknDouhyouji = SrCommonConstants.HYOUJI_NASI;
        }

        long goukeiKihonS = 0;
        if (pSyouhinZokusei != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR &&
            pSyouhinZokusei != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            goukeiKihonS = new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getKihons().toAdsoluteString()).longValue();
        }

        long goukeiGyousekiHyjSibouS = 0;
        long almyouSibouS = 0;
        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;

            KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd = SWAKInjector
                .getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

            KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk =
                SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

            if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu())) {

                kekkaKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                    pSvHoyuuMeisai.getTeikishrtkykhukaumu(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getBizDateYM(),
                    pItKhSisuurendoTmttkn.getTmttkntaisyouym(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                    pItKhSisuurendoTmttkn.getTeiritutmttkngk(),
                    pItKhSisuurendoTmttkn.getSisuurendoutmttkngk());
            }
            else {

                BizDateYM tmttkncalckijyunym = keisanWKijunYM.exec(
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
                    null,
                    null,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

                BizDateYM tmttknYendthnkym = keisanWKijunYM.exec(
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                    null,
                    null,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                    null);

                kekkaKbn = keisanSisuuRendouNkTmttknYendtHnk.exec(
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
                    tmttkncalckijyunym,
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                    tmttknYendthnkym,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKihons(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());
            }

            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                String msg = MessageUtil.getMessage(
                    MessageId.ESA1001,
                    "死亡Ｓ",
                    pSvHoyuuMeisai.getSyono());

                batchLogger.warn(msg);
                createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
            }
            else {

                if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu())) {

                    goukeiGyousekiHyjSibouS = new BigDecimal(keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei()
                        .toAdsoluteString()).longValue();
                    almyouSibouS = new BigDecimal(keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei().toAdsoluteString())
                    .longValue();
                    nkgns = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
                }
                else {

                    goukeiGyousekiHyjSibouS = new BigDecimal(keisanSisuuRendouNkTmttknYendtHnk.getTumitategk()
                        .toAdsoluteString()).longValue();
                    almyouSibouS = new BigDecimal(keisanSisuuRendouNkTmttknYendtHnk.getTumitategk().toAdsoluteString())
                    .longValue();
                    nkgns = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
                }
            }
        }
        else if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            goukeiGyousekiHyjSibouS = 0;
            almyouSibouS = 0;
        }
        else {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                    goukeiGyousekiHyjSibouS = 0;

                    almyouSibouS = 0;
                }
                else {
                    goukeiGyousekiHyjSibouS = new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getKihons()
                        .toAdsoluteString()).longValue();
                    almyouSibouS = new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getKihons().toAdsoluteString())
                    .longValue();
                }
            }
            else {
                almyouSibouS = new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getKihons().toAdsoluteString())
                .longValue();
            }
        }

        long haraikomip = 0;
        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {
            haraikomip = new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString()).longValue();
        }

        String zennoukaisiYmd  = "";
        String zennouKikan  = "";
        if (C_Kykjyoutai.ZENNOU.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            zennoukaisiYmd = pSvHoyuuMeisai.getZennoukaisiymd().toString();
            zennouKikan = pSvHoyuuMeisai.getZennoukikan().toString();
        }

        String jikaiPJyuutouYmWk = "";

        if (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            if (pSvHoyuuMeisai.getJkipjytym() != null) {
                jikaiPJyuutouYmWk = pSvHoyuuMeisai.getJkipjytym().toString();
            }
        }
        else if (jikaiPJyuutouYm != null) {

            jikaiPJyuutouYmWk = jikaiPJyuutouYm.toString();
        }

        String tantousyaJyoutaiKbn = "";
        String hoyuuSisyaCd2 = "";
        if (C_UmuKbn.NONE.eq(pSvHoyuuMeisai.getDrtenbunumu())) {

            tantousyaJyoutaiKbn = SrCommonConstants.TANTOUSYAJYOUTAIKBN_ATUKAISYA1ZAISEKI;

            hoyuuSisyaCd2 = "0";
        }
        else if (C_UmuKbn.ARI.eq(pSvHoyuuMeisai.getDrtenbunumu())) {

            tantousyaJyoutaiKbn = SrCommonConstants.TANTOUSYAJYOUTAIKBN_ATUKAISYA2ZAISEKI;

            SrHoyuuMeisaiBatchDbAccess srHoyuuMeisaiBatchDbAccess =
                SWAKInjector.getInstance(SrHoyuuMeisaiBatchDbAccess.class);

            KykDairitenByPkBean pKykDairitenByPkBean = srHoyuuMeisaiBatchDbAccess.
                getKykDairitenByPk(pSvHoyuuMeisai.getSyono(), 2);
            hoyuuSisyaCd2 = pKykDairitenByPkBean.getDrtenkanrisosikicd().substring(0, 3);
        }

        String kihonYoteii = "";
        String itijiBaraiKihonYoteii = "";
        String saiteiHosyoui = "";
        String tikIkktBriJyutuTksuWk = "";
        if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            if (tumitateKinBeanJtnyknBase != null) {
                kihonYoteii =  String.valueOf(
                    tumitateKinBeanJtnyknBase.getYoteiriritu().multiply(
                        SrCommonConstants.INT_VALUE_100).multiply(
                            SrCommonConstants.INT_VALUE_1000));
            }

            saiteiHosyoui = String.valueOf(
                pTkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt().multiply(
                    SrCommonConstants.INT_VALUE_100).multiply(
                        SrCommonConstants.INT_VALUE_1000));
        }
        else if (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            kihonYoteii = String.valueOf(
                pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu().multiply(
                    SrCommonConstants.INT_VALUE_100).multiply(
                        SrCommonConstants.INT_VALUE_1000));
        }
        else {
            itijiBaraiKihonYoteii = String.valueOf(
                pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu().multiply(
                    SrCommonConstants.INT_VALUE_100).multiply(
                        SrCommonConstants.INT_VALUE_1000));
        }
        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.getValue().equals(tkIktbriSyuruiKbn) ||
            C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.getValue().equals(tkIktbriSyuruiKbn)) {
            tikIkktBriJyutuTksuWk = tkIktbriSyuruiKbn;
        }

        SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfo.class);

        String hhkdrtkykariHyj = srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
            C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET, pSrHoyuuMeisaiBatchParam.getKijyunymd(),
            pSvHoyuuMeisai.getSyono(), null, null, pSvHoyuuMeisai.getStdrsktkyhkumu(),
            pSvHoyuuMeisai.getStdrsktkyhkymd());

        String kykdrtkykariHyj = srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
            C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET, pSrHoyuuMeisaiBatchParam.getKijyunymd(),
            pSvHoyuuMeisai.getSyono(), null, null, pSvHoyuuMeisai.getKykdrtkykhukaumu(),
            pSvHoyuuMeisai.getKykdrtkykhukaymd(), pSvHoyuuMeisai.getKykdrtkykkaiyakuymd());

        pZtHoyuuMeisaiTy.setZtykyksyhhknsydouituhyouji(kyKhhknDouhyouji);
        pZtHoyuuMeisaiTy.setZtykyksyaskinmeino(pSvHoyuuMeisai.getKyksakuinmeino());
        pZtHoyuuMeisaiTy.setZtygoukeikihons(goukeiKihonS);
        pZtHoyuuMeisaiTy.setZtygoukeigyousekihyjsibous(goukeiGyousekiHyjSibouS);
        pZtHoyuuMeisaiTy.setZtyalmyousibous(almyouSibouS);
        pZtHoyuuMeisaiTy.setZtyharaikomip(haraikomip);
        pZtHoyuuMeisaiTy.setZtyzennoukaisiymd(zennoukaisiYmd);
        pZtHoyuuMeisaiTy.setZtyzennoukikan(zennouKikan);
        pZtHoyuuMeisaiTy.setZtyjikaipjyuutouym(jikaiPJyuutouYmWk);
        pZtHoyuuMeisaiTy.setZtytouduketorihouhoukbn(pSvHoyuuMeisai.getHaitoukinuketorihoukbn().getValue());
        pZtHoyuuMeisaiTy.setZtyaatukaisyakeisyousisyacd(pSvHoyuuMeisai.getDrtenkanrisosikicd().substring(0, 3));
        pZtHoyuuMeisaiTy.setZtyaatukaisyazaisekihyouji(SrCommonConstants.AATUKAISYAZAISEKIHYUOJI_ZAISEKI);
        pZtHoyuuMeisaiTy.setZtyhoyuusisyacd(pSvHoyuuMeisai.getDrtenkanrisosikicd().substring(0, 3));
        pZtHoyuuMeisaiTy.setZtytantousyakbn(SrCommonConstants.TANTOUSYAKBN_SAISINATUKAISYA);
        pZtHoyuuMeisaiTy.setZtytantousyakbnnew(SrCommonConstants.TANTOUSYAKBNNEW_ZAISEKI);
        pZtHoyuuMeisaiTy.setZtytantousyajyoutaikbn(tantousyaJyoutaiKbn);
        pZtHoyuuMeisaiTy.setZtykihonyoteii(kihonYoteii);
        pZtHoyuuMeisaiTy.setZtyitijibaraikihonyoteii(itijiBaraiKihonYoteii);
        pZtHoyuuMeisaiTy.setZtysaiteihosyoui(saiteiHosyoui);
        pZtHoyuuMeisaiTy.setZtyhoyuusisyacd2(hoyuuSisyaCd2);
        pZtHoyuuMeisaiTy.setZtytikikktbrijyututksu(tikIkktBriJyutuTksuWk);
        pZtHoyuuMeisaiTy.setZtysyunyumrtikykjtigngtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZtHoyuuMeisaiTy.setZtyhhkdrtkykarihyj(hhkdrtkykariHyj);
        pZtHoyuuMeisaiTy.setZtykykdrtkykarihyj(kykdrtkykariHyj);
        pZtHoyuuMeisaiTy.setZtypmenkouryokuhasseiymd(SrCommonConstants.DEFAULT_STRING_ZERO_8);


        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykyksyhhknsydouituhyouji(kyKhhknDouhyouji);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykyksyaskinmeino(pSvHoyuuMeisai.getKyksakuinmeino());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtygoukeikihons(goukeiKihonS);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtygoukeigyousekihyjsibous(goukeiGyousekiHyjSibouS);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyalmyousibous(almyouSibouS);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyharaikomip(haraikomip);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyzennoukaisiymd(zennoukaisiYmd);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyzennoukikan(zennouKikan);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyjikaipjyuutouym(jikaiPJyuutouYmWk);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytouduketorihouhoukbn(pSvHoyuuMeisai.getHaitoukinuketorihoukbn()
                .getValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyaatukaisyakeisyousisyacd(pSvHoyuuMeisai.getDrtenkanrisosikicd()
                .substring(0, 3));
            pStHoyuuMeisaiTyukeiyouItzHzn
            .setZtyaatukaisyazaisekihyouji(SrCommonConstants.AATUKAISYAZAISEKIHYUOJI_ZAISEKI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhoyuusisyacd(pSvHoyuuMeisai.getDrtenkanrisosikicd().substring(0, 3));
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytantousyakbn(SrCommonConstants.TANTOUSYAKBN_SAISINATUKAISYA);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytantousyakbnnew(SrCommonConstants.TANTOUSYAKBNNEW_ZAISEKI);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytantousyajyoutaikbn(tantousyaJyoutaiKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykihonyoteii(kihonYoteii);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyitijibaraikihonyoteii(itijiBaraiKihonYoteii);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysaiteihosyoui(saiteiHosyoui);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhoyuusisyacd2(hoyuuSisyaCd2);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytikikktbrijyututksu(tikIkktBriJyutuTksuWk);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysyunyumrtikykjtigngtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyhhkdrtkykarihyj(hhkdrtkykariHyj);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykykdrtkykarihyj(kykdrtkykariHyj);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtypmenkouryokuhasseiymd(SrCommonConstants.DEFAULT_STRING_ZERO_8);
        }
    }

    public void editHeaderData(SrHoyuuMeisaiBatchParam pSrHoyuuMeisaiBatchParam, ZT_HoyuuMeisaiTy pZtHoyuuMeisaiTy,
        ST_HoyuuMeisaiTyukeiyouItzHzn pStHoyuuMeisaiTyukeiyouItzHzn, int pSyouhinZokusei, Integer pKey,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean) {

        String kbnkey = pSrHoyuuMeisaiBatchParam.getHeisoukbn();

        Integer sequenceno = Integer.valueOf(pKey + kbnkey.substring(kbnkey.length() - 1));

        Integer rdwAreaLength = YuyuSuuriConfig.getInstance().getPalrdwarealength();

        Integer commonLength = YuyuSuuriConfig.getInstance().getPalprre601length();

        Integer AlmLength = YuyuSuuriConfig.getInstance().getPalprre603length();

        Integer tkLength = YuyuSuuriConfig.getInstance().getPalprre602length();

        Integer rayLength = YuyuSuuriConfig.getInstance().getPalprre850length();

        Integer yuukourecordLength = rdwAreaLength + commonLength + AlmLength + rayLength +
            tkLength * pZtHoyuuMeisaiTy.getZtytokuyakuhukasuu();


        pZtHoyuuMeisaiTy.setZtysequenceno(sequenceno);
        pZtHoyuuMeisaiTy.setZtyyuukourecordlength(yuukourecordLength);

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysequenceno(sequenceno);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyyuukourecordlength(yuukourecordLength);
        }
    }

    public void editRayData(SrHoyuuMeisaiBatchParam pSrHoyuuMeisaiBatchParam, SV_HoyuuMeisai pSvHoyuuMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean, ZT_HoyuuMeisaiTy pZtHoyuuMeisaiTy,
        ST_HoyuuMeisaiTyukeiyouItzHzn pStHoyuuMeisaiTyukeiyouItzHzn, int pSyouhinZokusei,
        IT_KhSisuurendoTmttkn pItKhSisuurendoTmttkn, List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst,
        List<IT_KykSyouhnHnkmae> pItKykSyouhnHnkmaeLst,
        List<SrGetTokutejitenTmttknInfoBean> pSrGetTokutejitenTmttknInfoBeanList) {

        BizCurrency mvatyouseigow = BizCurrency.valueOf(0);
        BizCurrency mvakeisanjisknnjynbkn = BizCurrency.valueOf(0);
        BizNumber srkaiyakusjkkktyouseirrt = BizNumber.valueOf(0);
        BizNumber mvatyouseikou = BizNumber.valueOf(0);
        BizCurrency enkdtsbujsitihsyukngk = BizCurrency.valueOf(0);
        String kaigomaebaraitkykarihyj = "";
        String pWyendttargetmokuhyouritu = "";
        BizCurrency pYendttargetkijyunkingaku = BizCurrency.valueOf(0);
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);
        SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo = SWAKInjector
            .getInstance(SrGetTokutejitenTokuyakuInfo.class);
        GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);

        BizDate keisanDate = BizDate.valueOf(0);

        if (BizDateUtil.COMPARE_LESSER == BizDateUtil.compareYmd(pSrHoyuuMeisaiBatchParam.getSyoriYmd(),
            pSrHoyuuMeisaiBatchParam.getKijyunymd())) {
            keisanDate = pSrHoyuuMeisaiBatchParam.getSyoriYmd();
        }
        else {
            keisanDate = pSrHoyuuMeisaiBatchParam.getKijyunymd();
        }

        String gaikaKbn = "";
        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pSvHoyuuMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);
            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);

        }
        else {
            gaikaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        BizNumber kawaserate1 = BizNumber.valueOf(0);
        BizDate kwsrateKjYmd1 = BizDate.valueOf(0);

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null
            && !C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {
            errorKbn = getKawaseRate.exec(keisanDate,
                C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.JISSEIRATE,
                C_EigyoubiHoseiKbn.ZENEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1004,
                    String.valueOf(keisanDate),
                    C_KawaserateSyuruiKbn.PM17JIKAWASERATE.getValue(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                    C_Tuukasyu.JPY.getValue(),
                    C_KawasetekiyoKbn.TTM.getValue(),
                    C_KawasetsryKbn.JISSEIRATE.getValue(),
                    C_EigyoubiHoseiKbn.ZENEIGYOUBI.getValue(),
                    C_YouhiKbn.HUYOU.getValue());

                batchLogger.warn(msg);
                createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);

            }
            else {

                kawaserate1 = getKawaseRate.getKawaserate();
                kwsrateKjYmd1 = getKawaseRate.getKwsrateKjYmd();
            }
        }

        BizNumber kawaserate = BizNumber.valueOf(0);
        BizDate kwsrateKjYmd = BizDate.valueOf(0);

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null
            && !C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {
            SrHoyuuMeisaiBatchDbAccess srHoyuuMeisaiBatchDbAccess = SWAKInjector
                .getInstance(SrHoyuuMeisaiBatchDbAccess.class);
            C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.BLNK;
            C_KawasetsryKbn kawasetsryKbn = C_KawasetsryKbn.BLNK;

            NyknJissekiRirekiRstuukasyuRyosyuymdByPKBean nyknJissekiRirekiRstuukasyuRyosyuymdByPKBean =
                srHoyuuMeisaiBatchDbAccess.getNyknJissekiRireki(pSvHoyuuMeisai.getSyono(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), 1);

            if (C_Tuukasyu.JPY.eq(nyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.getRstuukasyu())) {

                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;

                kawasetsryKbn = C_KawasetsryKbn.NYUKINRATE;
            }

            else {

                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;

                kawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
            }

            BizDate kwsrateKijyunYmd = null;

            if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
                (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN &&
                !C_Kykjyoutai.ZENNOU.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai()))) {
                kwsrateKijyunYmd = nyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.getRyosyuymd().addBusinessDays(-1);
            }
            else {
                kwsrateKijyunYmd = nyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.getRyosyuymd();
            }

            errorKbn = getKawaseRate.exec(kwsrateKijyunYmd,
                kawaserateSyuruiKbn,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                kawasetsryKbn,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1004,
                    kwsrateKijyunYmd.toString(),
                    kawaserateSyuruiKbn.getValue(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                    C_Tuukasyu.JPY.getValue(),
                    C_KawasetekiyoKbn.TTM.getValue(),
                    kawasetsryKbn.getValue(),
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                    C_YouhiKbn.HUYOU.getValue());

                batchLogger.warn(msg);
                createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);

            }
            else {

                kawaserate = getKawaseRate.getKawaserate();
                kwsrateKjYmd = getKawaseRate.getKwsrateKjYmd();
            }

            if (!pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().eq(
                nyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.getRstuukasyu())
                && (C_Tuukasyu.AUD.eq(nyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.getRstuukasyu())
                    || C_Tuukasyu.USD.eq(nyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.getRstuukasyu()))) {
                BizNumber crossRate = BizNumber.valueOf(0);
                errorKbn = getKawaseRate.exec(nyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.getRyosyuymd(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                    nyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.getRstuukasyu(),
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    String msg = MessageUtil.getMessage(MessageId.ESA1004,
                        nyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.getRyosyuymd().toString(),
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE.getValue(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                        nyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.getRstuukasyu().getValue(),
                        C_KawasetekiyoKbn.TTM.getValue(),
                        C_KawasetsryKbn.NYUKINRATE.getValue(),
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                        C_YouhiKbn.HUYOU.getValue());

                    batchLogger.warn(msg);
                    createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
                }
                else {

                    crossRate = getKawaseRate.getKawaserate();
                }

                SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean = srSuuriGouseiRateKeisan.exec(
                    nyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.getRyosyuymd(),
                    nyknJissekiRirekiRstuukasyuRyosyuymdByPKBean.getRstuukasyu(), crossRate);

                if (C_ErrorKbn.ERROR.eq(srSuuriGouseiRateKeisanBean.getErrorKbn())) {

                    SetErrMessageInfoBean setErrMessageInfoBean = srSuuriGouseiRateKeisanBean.getErrMessageInfoBean();

                    String msg = MessageUtil.getMessage(
                        MessageId.ESA1004,
                        String.valueOf(setErrMessageInfoBean.getKwsrateKjYmd()),
                        setErrMessageInfoBean.getKawaserateSyuruiKbn().getValue(),
                        setErrMessageInfoBean.getMotoTuukasyu().getValue(),
                        setErrMessageInfoBean.getKansanTuukasyu().getValue(),
                        setErrMessageInfoBean.getKawasetekiyoKbn().getValue(),
                        setErrMessageInfoBean.getKawasetsryKbn().getValue(),
                        setErrMessageInfoBean.getEigyoubiHoseiKbn().getValue(),
                        setErrMessageInfoBean.getYouhiKbn().getValue() + "：合成レート");

                    batchLogger.warn(msg);
                    createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);

                }
                else {
                    kawaserate = srSuuriGouseiRateKeisanBean.getSuuriGouseiRate();
                }
            }
        }

        BizNumber suuriyoukeiyakusjktsritu = BizNumber.valueOf(0);
        BizNumber kaiyakukoujyoritu = BizNumber.valueOf(0);
        BizNumber kaiyakukoujyoritu2 = BizNumber.valueOf(0);
        BizDate mvaKeisanDate = BizDate.valueOf(0);
        BizCurrency sibouS = BizCurrency.valueOf(0);
        BizCurrency goukeiGyousekiHyjSibouS = BizCurrency.valueOf(0);
        BizCurrency almyouSibouS = BizCurrency.valueOf(0);

        if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu()) ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

            BizDateYM kijunNengetu = keisanWKijunYM.exec(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pSrHoyuuMeisaiBatchParam.getKijyunymd(),
                null, null, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

            BizDateYM tmttknTaisyouYm = null;
            BizCurrency teirituTmttkngk = BizCurrency.valueOf(0);
            BizCurrency sisuurendouTmttkngk = BizCurrency.valueOf(0);
            BizNumber tumiTateriritu = BizNumber.valueOf(0);

            if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu()) &&
                    BizDateUtil.calcDifferenceMonths(kijunNengetu,
                        pItKhSisuurendoTmttkn.getTmttkntaisyouym()) > SrCommonConstants.KIKAN_12M) {

                    int keikamon = BizDateUtil.calcDifferenceMonths(
                        kijunNengetu, pItKhSisuurendoTmttkn.getTmttkntaisyouym());

                    int keikanensuu = keikamon / SrCommonConstants.MONTH_DECEMBER;

                    tmttknTaisyouYm = pItKhSisuurendoTmttkn.getTmttkntaisyouym().addYears(keikanensuu);

                    BizDate tmttknTaisyouYmd = BizDate.valueOf(tmttknTaisyouYm,
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();

                    KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd =
                        SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

                    C_ErrorKbn errorKbn1 = keisanSisuuRendouNkTmttknOverNnd.exec(
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                        pSvHoyuuMeisai.getTeikishrtkykhukaumu(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                        tmttknTaisyouYmd,
                        tmttknTaisyouYm,
                        pItKhSisuurendoTmttkn.getTmttkntaisyouym(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                        pItKhSisuurendoTmttkn.getTeiritutmttkngk(),
                        pItKhSisuurendoTmttkn.getSisuurendoutmttkngk());

                    if (errorKbn1.eq(C_ErrorKbn.ERROR)) {
                        String msg = MessageUtil.getMessage(MessageId.ESA1001,
                            "積立金計算：ＭＶＡ調整後Ｗ",
                            pSvHoyuuMeisai.getSyono());
                        batchLogger.warn(msg);
                        createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
                    }
                    else {

                        teirituTmttkngk = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
                        sisuurendouTmttkngk = keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk();
                        tumiTateriritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                    }
                }
                else {

                    tmttknTaisyouYm = pItKhSisuurendoTmttkn.getTmttkntaisyouym();
                    teirituTmttkngk = pItKhSisuurendoTmttkn.getTeiritutmttkngk();
                    sisuurendouTmttkngk = pItKhSisuurendoTmttkn.getSisuurendoutmttkngk();
                    tumiTateriritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                }
            }

            if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu())) {

                tmttknTaisyouYm = null;
                teirituTmttkngk = BizCurrency.valueOf(0);
                sisuurendouTmttkngk = BizCurrency.valueOf(0);
                tumiTateriritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
            }

            GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector
                .getInstance(GetSjkkktyouseiyouriritu.class);
            GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean =
                SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
            BizNumber kaiyakuSjkkkTyouseiRiritu = BizNumber.valueOf(0);

            if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu())) {

                getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                getSjkkktyouseiyourirituBean.setKijyunymd(keisanDate);
                getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
                getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
                getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

                errorKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    String msg = MessageUtil.getMessage(MessageId.ESA1001,
                        "市場価格調整用利率",
                        pSvHoyuuMeisai.getSyono());

                    batchLogger.warn(msg);
                    createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
                }
                else {
                    kaiyakuSjkkkTyouseiRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                }
            }

            if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().compareTo(
                pSrHoyuuMeisaiBatchParam.getKijyunymd()) <= 0) {
                KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
                KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

                keisanWExtBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                keisanWExtBean.setSyouhnsdno(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());
                keisanWExtBean.setRyouritusdno(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
                keisanWExtBean.setYoteiriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu());
                keisanWExtBean.setHrkkaisuu(pSvHoyuuMeisai.getHrkkaisuu());
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
                keisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiyakuSjkkkTyouseiRiritu);
                keisanWExtBean.setTmttkntaisyouym(tmttknTaisyouYm);
                keisanWExtBean.setTeiritutmttkngk(teirituTmttkngk);
                keisanWExtBean.setSisuurendoutmttkngk(sisuurendouTmttkngk);
                keisanWExtBean.setTumitateriritu(tumiTateriritu);
                keisanWExtBean.setYendthnkymd(pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());
                keisanWExtBean.setTeikishrtkykhukaumu(pSvHoyuuMeisai.getTeikishrtkykhukaumu());
                keisanWExtBean.setDai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn());
                keisanWExtBean.setKykJyoutai(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai());

                errorKbn = keisanW.exec(keisanDate, kijunNengetu, keisanWExtBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    String msg = MessageUtil.getMessage(MessageId.ESA1001,
                        "解約返戻金",
                        pSvHoyuuMeisai.getSyono());

                    batchLogger.warn(msg);
                    createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
                }
                else {

                    if (C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu())) {

                        mvatyouseigow = keisanW.getW();
                        mvakeisanjisknnjynbkn = keisanW.getV();
                        srkaiyakusjkkktyouseirrt = kaiyakuSjkkkTyouseiRiritu;
                        mvatyouseikou = keisanW.getMvaTyouseikou();
                        kaiyakukoujyoritu = keisanW.getKaiyakukjritu();

                        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                            sibouS = keisanW.getV();

                            goukeiGyousekiHyjSibouS = keisanW.getV();

                            almyouSibouS = keisanW.getV();
                        }
                    }
                    else {

                        mvatyouseigow = keisanW.getW();
                        mvakeisanjisknnjynbkn = keisanW.getV();
                        srkaiyakusjkkktyouseirrt = kaiyakuSjkkkTyouseiRiritu;
                        suuriyoukeiyakusjktsritu = pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu();
                        mvatyouseikou = keisanW.getMvaTyouseikou();
                        kaiyakukoujyoritu = keisanW.getKaiyakukjritu();
                        mvaKeisanDate = keisanDate;
                    }

                }
            }
            else {
                mvatyouseigow = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
                mvakeisanjisknnjynbkn = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
                srkaiyakusjkkktyouseirrt = kaiyakuSjkkkTyouseiRiritu;
                suuriyoukeiyakusjktsritu = pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu();
                mvatyouseikou = BizNumber.valueOf(SrCommonConstants.MVATYOUSEIKOU_CASCADE);
                mvaKeisanDate = keisanDate;

                if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
                    if (YEAR_5Y == pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().intValue()) {
                        kaiyakukoujyoritu = KAIYAKUKOUJYORITU_0025;
                    }
                    else if (YEAR_10Y == pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().intValue()) {
                        kaiyakukoujyoritu = KAIYAKUKOUJYORITU_005;
                    }
                }
                else if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                    if (YEAR_5Y == pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().intValue()) {
                        if (YOTEIRIRITU_0005.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) <= 0 &&
                            YOTEIRIRITU_0008.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) > 0) {

                            kaiyakukoujyoritu = KAIYAKUKOUJYORITU_0005;
                        }
                        else if (YOTEIRIRITU_0008.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) <= 0 &&
                            YOTEIRIRITU_00105.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) > 0) {

                            kaiyakukoujyoritu = KAIYAKUKOUJYORITU_001;
                        }
                        else if (YOTEIRIRITU_00105.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) <= 0 &&
                            YOTEIRIRITU_0013.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) > 0) {

                            kaiyakukoujyoritu = KAIYAKUKOUJYORITU_002;
                        }
                        else if (YOTEIRIRITU_0013.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) <= 0 &&
                            YOTEIRIRITU_005.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) >= 0) {

                            kaiyakukoujyoritu = KAIYAKUKOUJYORITU_0025;
                        }
                    }
                    else if (YEAR_10Y == pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().intValue()) {
                        if (YOTEIRIRITU_0005.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) <= 0 &&
                            YOTEIRIRITU_0008.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) > 0) {

                            kaiyakukoujyoritu = KAIYAKUKOUJYORITU_001;
                        }
                        else if (YOTEIRIRITU_0008.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) <= 0 &&
                            YOTEIRIRITU_00105.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) > 0) {

                            kaiyakukoujyoritu = KAIYAKUKOUJYORITU_002;
                        }
                        else if (YOTEIRIRITU_00105.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) <= 0 &&
                            YOTEIRIRITU_0013.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) > 0) {

                            kaiyakukoujyoritu = KAIYAKUKOUJYORITU_004;
                        }
                        else if (YOTEIRIRITU_0013.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) <= 0 &&
                            YOTEIRIRITU_005.compareTo(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu()) >= 0) {

                            kaiyakukoujyoritu = KAIYAKUKOUJYORITU_005;
                        }
                    }
                }
            }
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                kaiyakukoujyoritu2 = BizNumber.valueOf(0);
            }
            else {

                kaiyakukoujyoritu2 = kaiyakukoujyoritu;
            }
        }

        BizNumber rendouritu = BizNumber.valueOf(0);
        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            if (!C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {

                rendouritu = pTkJitenKeiyakuSyouhinKijyunBean.getRendouritu();
            }
        }

        if (pSyouhinZokusei != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR &&
            pSyouhinZokusei != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20
            && pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {
            SrGetTokutejitenTokuyakuInfoBean srGetTokutejitenTokuyakuInfoBean = srGetTokutejitenTokuyakuInfo.exec(
                C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK,
                C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET,
                pSrHoyuuMeisaiBatchParam.getKijyunymd(),
                pSvHoyuuMeisai.getSyono(),
                null,
                null,
                null,
                pSvKiykSyuhnDataLst,
                pSvHoyuuMeisai.getYendthnkymd(),
                pItKykSyouhnHnkmaeLst,
                pSvHoyuuMeisai.getInitsbjiyensitihsytkhukaumu(),
                pSvHoyuuMeisai.getInitsbjiyenkasaiteihsygk(),
                null,
                null,
                null,
                null);

            enkdtsbujsitihsyukngk = srGetTokutejitenTokuyakuInfoBean.getInitsbjiyenkasaiteihsygkMae();
        }

        BizNumber kykjiYoteiRiritu = BizNumber.valueOf(0);

        if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
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

            errorKbn = getYoteiriritu.exec(getYoteirirituBean);
            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "契約時予定利率",
                    pSvHoyuuMeisai.getSyono());

                batchLogger.warn(msg);
                createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
            }
            else {
                kykjiYoteiRiritu = getYoteiriritu.getYoteiriritu();
            }
        }

        else if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

            kykjiYoteiRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu();
        }

        BizNumber tumitateRiritu = BizNumber.valueOf(0);
        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            tumitateRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
        }
        else if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            if (tumitateKinBeanJtnyknBase != null) {
                tumitateRiritu = tumitateKinBeanJtnyknBase.getYoteiriritu().subtract(tumitateKinBeanJtnyknBase.getYoteiIjihirituVhirei());
            }
        }
        else if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                tumitateRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
            }
            else {

                if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()
                    .addYears(SrCommonConstants.YEAR_10Y).getRekijyou(), pSrHoyuuMeisaiBatchParam.getKijyunymd())
                    == BizDateUtil.COMPARE_GREATER) {
                    tumitateRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                }
                else {
                    tumitateRiritu = pTkJitenKeiyakuSyouhinKijyunBean.getLoadinghnkgtumitateriritu();
                }
            }
        }

        if (C_UmuKbn.ARI.eq(pSvHoyuuMeisai.getJyudkaigomeharaitkhukaumu())) {

            kaigomaebaraitkykarihyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            kaigomaebaraitkykarihyj = SrCommonConstants.HYOUJI_NASI;
        }

        String sibouhyouKbn = "";
        C_SrKbnHenkanKbn kbnHenkanKbn = null;
        if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            kbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU2;
        }
        else {
            kbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU;
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(kbnHenkanKbn,
            pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                kbnHenkanKbn.getContent(),
                pSvHoyuuMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

            batchLogger.warn(msg);
            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
        }
        else {
            sibouhyouKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizDate getTktjtSntTokuyakuInfokijyunYmd = null;

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
            for (IT_KykSyouhnHnkmae kykSyouhnHnkmae : pItKykSyouhnHnkmaeLst) {
                if(Integer.parseInt(pTkJitenKeiyakuSyouhinKijyunBean.getHenkousikibetukey()) >
                Integer.parseInt(kykSyouhnHnkmae.getHenkousikibetukey())){
                    pWyendttargetmokuhyouritu = String.valueOf(kykSyouhnHnkmae.getTargettkmokuhyouti());

                    break;
                }
            }
        }
        else {
            getTktjtSntTokuyakuInfokijyunYmd = pSrHoyuuMeisaiBatchParam.getKijyunymd();

            SrGetTokutejitenTokuyakuInfoBean srGetTokutejitenTokuyakuInfoBean = srGetTokutejitenTokuyakuInfo.exec(
                C_GetTaisyouSonotaTokuyakuKbn.TARGETTOKUYAKU,
                C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET,
                getTktjtSntTokuyakuInfokijyunYmd,
                pSvHoyuuMeisai.getSyono(),
                null,
                null,
                null,
                pSvKiykSyuhnDataLst,
                pSvHoyuuMeisai.getYendthnkymd(),
                pItKykSyouhnHnkmaeLst,
                null,
                null,
                pSvHoyuuMeisai.getTargettkhkumu(),
                pSvHoyuuMeisai.getTargettkmokuhyouti(),
                pSvHoyuuMeisai.getTargettkykkijyungk(),
                pSvHoyuuMeisai.getTargettkykkykhenkoymd());

            pWyendttargetmokuhyouritu = String.valueOf(srGetTokutejitenTokuyakuInfoBean.getTargettkmokuhyoutiMae());
            pYendttargetkijyunkingaku = srGetTokutejitenTokuyakuInfoBean.getTargettkykkijyungkMae();
        }

        BizNumber sisuurendouRate = BizNumber.valueOf(0);
        String teirituIkouHyouji = SrCommonConstants.HYOUJI_NASI;
        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null &&
                pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() == null) {

                sisuurendouRate = pTkJitenKeiyakuSyouhinKijyunBean.getKykjisisuurendourate();
            }

            if (pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() != null) {

                teirituIkouHyouji = SrCommonConstants.HYOUJI_ARI;
            }
        }

        String sisuuKbn = "";
        if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {
            if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(
                pTkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {
                sisuuKbn = C_Sisuukbn.BLNK.getValue();
            }
            else {
                sisuuKbn = pTkJitenKeiyakuSyouhinKijyunBean.getSisuukbn().getValue();
            }

            srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_SISUU, sisuuKbn);

            if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                String msg = MessageUtil.getMessage(MessageId.ESA1002,
                    C_SrKbnHenkanKbn.SUURI_SISUU.getContent(),
                    pSvHoyuuMeisai.getSyono(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSisuukbn().getValue());

                batchLogger.warn(msg);
                createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
            }
            else {
                sisuuKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
            }
        }

        BizNumber tmttknZoukarituJygn = BizNumber.valueOf(0);
        BizNumber setteiBairitu = BizNumber.valueOf(0);
        BizNumber tykzenoutouYmdSisuu = BizNumber.valueOf(0);

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
            tmttknZoukarituJygn = pTkJitenKeiyakuSyouhinKijyunBean.getTmttknzoukaritujygn();
            setteiBairitu = pTkJitenKeiyakuSyouhinKijyunBean.getSetteibairitu();
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null &&
                pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() == null) {

                tykzenoutouYmdSisuu = pItKhSisuurendoTmttkn.getTmttknhaneisisuu();
            }
        }

        BizNumber kimatuSisuu = BizNumber.valueOf(0);

        if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {
            if (!C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(
                pTkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {
                errorKbn = getSisuu.exec(pTkJitenKeiyakuSyouhinKijyunBean.getSisuukbn(),
                    pSrHoyuuMeisaiBatchParam.getKijyunymd(), C_YouhiKbn.YOU);
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    String msg = MessageUtil.getMessage(MessageId.ESA1001,
                        "指数取得：期末指数",
                        pSvHoyuuMeisai.getSyono());

                    batchLogger.warn(msg);
                    createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
                }
                else {
                    kimatuSisuu = getSisuu.getSisuu();

                    if ((BizDateUtil.compareYmd(pSrHoyuuMeisaiBatchParam.getKijyunymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER ) &&
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() == SrCommonConstants.DAY_16D) {

                        tykzenoutouYmdSisuu = getSisuu.getSisuu();
                    }
                }
            }
        }

        String tuukasyuKbn = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.TUUKA_SYU,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.TUUKA_SYU.getContent(),
                pSvHoyuuMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);
            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
        }
        else {
            tuukasyuKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizCurrency sisuurenTumitatekin = BizCurrency.valueOf(0);
        if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {
            sisuurenTumitatekin = pItKhSisuurendoTmttkn.getSisuurendoutmttkngk();
        }

        BizCurrency nksjitirttumitatekin = BizCurrency.valueOf(0);

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            nksjitirttumitatekin = nkgns;
        }
        else {
            nksjitirttumitatekin = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        }

        BizCurrency gaikadatejyuutoup = BizCurrency.valueOf(0);

        if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            gaikadatejyuutoup = pJtnyknBase;
        }

        BizCurrency kimatutirtTumitatekin = BizCurrency.valueOf(0);

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {
            BizDateYM kimatuTumitatekinKijyunYm = null;
            BizDate kimatuTumitatekinKijyunYmd = null;
            if (BizDateUtil.COMPARE_LESSER == BizDateUtil.compareYmd(pSrHoyuuMeisaiBatchParam.getKijyunymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd())) {
                kimatuTumitatekinKijyunYm = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
                kimatuTumitatekinKijyunYmd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
            }
            else {
                kimatuTumitatekinKijyunYm = pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM();

                if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() == SrCommonConstants.DAY_1D) {
                    kimatuTumitatekinKijyunYm = kimatuTumitatekinKijyunYm.addMonths(SrCommonConstants.MONTH_JANUARY)
                        .getRekijyou();
                }
                kimatuTumitatekinKijyunYmd = BizDate.valueOf(kimatuTumitatekinKijyunYm,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();
            }

            KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd =
                SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

            KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk =
                SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

            if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu())) {

                errorKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                    pSvHoyuuMeisai.getTeikishrtkykhukaumu(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                    kimatuTumitatekinKijyunYmd,
                    kimatuTumitatekinKijyunYm,
                    pItKhSisuurendoTmttkn.getTmttkntaisyouym(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                    pItKhSisuurendoTmttkn.getTeiritutmttkngk(),
                    pItKhSisuurendoTmttkn.getSisuurendoutmttkngk());
            }
            else {

                BizDateYM tmttkncalckijyunymd = keisanWKijunYM.exec(
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                    BizDate.valueOf(pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd().getDay()).getRekijyou(),
                        null,
                        null,
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

                BizDateYM tmttknYendthnkym = keisanWKijunYM.exec(
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                    null,
                    null,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                    null);

                errorKbn = keisanSisuuRendouNkTmttknYendtHnk.exec(
                    BizDate.valueOf(pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd().getDay()).getRekijyou(),
                        tmttkncalckijyunymd,
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                        tmttknYendthnkym,
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKihons(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());

            }
            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "期末定率部分積立金",
                    pSvHoyuuMeisai.getSyono());

                batchLogger.warn(msg);
                createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
            }
            else {

                if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu())) {

                    kimatutirtTumitatekin = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();

                }
                else {
                    kimatutirtTumitatekin = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
                }
            }
        }
        else {
            kimatutirtTumitatekin = BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO);
        }

        BizCurrency sisuurentyokugotmttkn = BizCurrency.valueOf(0);
        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null &&
                pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() == null &&
                !C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pTkJitenKeiyakuSyouhinKijyunBean.
                    getTmttknhaibunjyoutai())) {

                BizDateYM tmttkncalckijyunym = pSrHoyuuMeisaiBatchParam.getKijyunymd().
                    addMonths(SrCommonConstants.KIKAN_1M).getBizDateYM();

                if (pItKhSisuurendoTmttkn.getTmttkntaisyouym().getMonth() == tmttkncalckijyunym.getMonth() &&
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() == SrCommonConstants.DAY_1D &&
                    BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pSrHoyuuMeisaiBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER) {

                    SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfo =
                        SWAKInjector.getInstance(SrGetTokutejitenTmttknInfoBean.class);

                    BizDate tmttkncalckijyunymd = BizDate.valueOf(tmttkncalckijyunym,
                        SrCommonConstants.DAY_1D).getRekijyou();

                    for (SrGetTokutejitenTmttknInfoBean srGetTokutejitenTmttknInfoBean :
                        pSrGetTokutejitenTmttknInfoBeanList) {

                        if (srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd() == null) {

                            continue;

                        }

                        if (BizDateUtil.compareYmd(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd(),
                            tmttkncalckijyunymd) == BizDateUtil.COMPARE_EQUAL &&
                            srGetTokutejitenTmttknInfoBean.getRenno() == SrCommonConstants.RENBAN_1) {

                            srGetTokutejitenTmttknInfo = srGetTokutejitenTmttknInfoBean;

                            break;
                        }

                        if (BizDateUtil.compareYmd(srGetTokutejitenTmttknInfoBean.getTmttknkouryokukaisiymd(),
                            tmttkncalckijyunymd) == BizDateUtil.COMPARE_LESSER) {

                            break;

                        }

                    }

                    if (BizDateUtil.compareYmd(tmttkncalckijyunymd,
                        srGetTokutejitenTmttknInfo.getTmttknkouryokukaisiymd()) == BizDateUtil.COMPARE_EQUAL) {

                        if (srGetTokutejitenTmttknInfo.getSisuurendoutmttkngk() == null ||
                            srGetTokutejitenTmttknInfo.getSisuurendoutmttkngk().compareTo(BizCurrency.valueOf(
                                SrCommonConstants.DEFAULT_INT_ZERO,
                                srGetTokutejitenTmttknInfo.getSisuurendoutmttkngk().getType())) == 0) {

                            sisuurentyokugotmttkn = srGetTokutejitenTmttknInfo.getItenmaesisuurendoutmttkngk();

                        }
                        else {

                            sisuurentyokugotmttkn = srGetTokutejitenTmttknInfo.getSisuurendoutmttkngk();

                        }

                    }
                    else {

                        BizNumber tykzenTmmsHanteiYmdSisuu = pItKhSisuurendoTmttkn.getTmttknhaneisisuu();
                        BizCurrency sisuuRendouTmttkngk = pItKhSisuurendoTmttkn.getSisuurendoutmttkngk();
                        int keikatukisuu = BizDateUtil.calcDifferenceMonths(tmttkncalckijyunym,
                            pItKhSisuurendoTmttkn.getTmttkntaisyouym());
                        int keikanensuu = keikatukisuu / SrCommonConstants.KIKAN_12M - SrCommonConstants.YEAR_1Y;

                        for (int i = 0; i <= keikanensuu; i++) {

                            BizDate tmmshanteiymd = null;

                            if (keikanensuu == i) {

                                if (BizDateUtil.compareYmd(pSrHoyuuMeisaiBatchParam.getSyoriYmd(),
                                    pSrHoyuuMeisaiBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER) {

                                    tmmshanteiymd = pSrHoyuuMeisaiBatchParam.getSyoriYmd();
                                }
                                else {

                                    SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                                    BizDate tmoutouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO,
                                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), C_Hrkkaisuu.NEN,
                                        pItKhSisuurendoTmttkn.getTmttknkouryokukaisiymd().addYears(i));
                                    tmmshanteiymd = tmoutouYmd.addBusinessDays(- SrCommonConstants.DAY_1D);
                                }

                                errorKbn = getSisuu.exec(pTkJitenKeiyakuSyouhinKijyunBean.getSisuukbn(),
                                    tmmshanteiymd, C_YouhiKbn.HUYOU);

                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                    String msg = MessageUtil.getMessage(MessageId.ESA1001,
                                        "指数取得：指数連動部分直後積立金",
                                        pSvHoyuuMeisai.getSyono());

                                    batchLogger.warn(msg);
                                    createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);

                                    break;
                                }

                                KeisanTmHntiSisuuRendouTmttkn keisanTmHntiSisuuRendouTmttkn =
                                    SWAKInjector.getInstance(KeisanTmHntiSisuuRendouTmttkn.class);

                                errorKbn = keisanTmHntiSisuuRendouTmttkn.exec(
                                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(), getSisuu.getSisuu(),
                                    tykzenTmmsHanteiYmdSisuu, pTkJitenKeiyakuSyouhinKijyunBean.getSetteibairitu(),
                                    pTkJitenKeiyakuSyouhinKijyunBean.getTmttknzoukaritujygn(), sisuuRendouTmttkngk,
                                    pTkJitenKeiyakuSyouhinKijyunBean.getRendouritu());

                                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                                    String msg = MessageUtil.getMessage(MessageId.ESA1001,
                                        "積立金計算：指数連動部分直後積立金",
                                        pSvHoyuuMeisai.getSyono());

                                    batchLogger.warn(msg);
                                    createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);

                                    break;
                                }

                                tykzenTmmsHanteiYmdSisuu = getSisuu.getSisuu();
                                sisuurentyokugotmttkn = keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk();
                                sisuuRendouTmttkngk = sisuurentyokugotmttkn;
                            }
                        }

                    }
                }
                else {
                    sisuurentyokugotmttkn = sisuurenTumitatekin;
                }

            }
        }

        BizNumber yoteiRirituRironBase = BizNumber.valueOf(0);
        BizNumber yoteiRirituJtnyknBase = BizNumber.valueOf(0);
        BizCurrency kihrkPJtnyknBase = BizCurrency.valueOf(0);
        BizCurrency syuPTumitateKin = BizCurrency.valueOf(0);
        BizCurrency syuPTumitateKinGsc = BizCurrency.valueOf(0);
        BizCurrency gaikadateNkgns = BizCurrency.valueOf(0);
        BizCurrency gessiTumitateKin = BizCurrency.valueOf(0);
        BizCurrency gaikadateTougetuJuutouP = BizCurrency.valueOf(0);
        BizCurrency kihrkmPMsukisYmbase = BizCurrency.valueOf(0);
        BizCurrency keisanHanteiyouTmttkn = BizCurrency.valueOf(0);
        BizCurrency gtmtV = BizCurrency.valueOf(0);
        BizNumber zettaiSibouRitu = BizNumber.valueOf(0);
        BizNumber soutaiSibouRitu = BizNumber.valueOf(0);
        BizNumber soutaiKaiyakuRitu = BizNumber.valueOf(0);
        BizNumber vHireiLRitu2 = BizNumber.valueOf(0);
        BizNumber pHireiAlpha = BizNumber.valueOf(0);
        BizNumber pHireiBeta = BizNumber.valueOf(0);
        BizNumber pHireiGanma = BizNumber.valueOf(0);
        BizNumber pHireiLWrbkRitu = BizNumber.valueOf(0);
        BizNumber yoteiRirituMsukisYmBase = BizNumber.valueOf(0);
        BizCurrency rrtHnduhknVKisoVKisnyu1 = BizCurrency.valueOf(0);
        BizCurrency tumiTateKin = BizCurrency.valueOf(0);
        BizCurrency kiharaikomiP = BizCurrency.valueOf(0);
        BizCurrency gaikadateSyukeiyakuP = BizCurrency.valueOf(0);

        if (pSyouhinZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            KeisanKihrkP keisanKihrkP = SWAKInjector.getInstance(KeisanKihrkP.class);
            errorKbn = keisanKihrkP.exec(pSvHoyuuMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "既払込Ｐ（実入金ベース）",
                    pSvHoyuuMeisai.getSyono());

                batchLogger.warn(msg);
                createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
            }
            else {
                kihrkPJtnyknBase = keisanKihrkP.getYenKihrkP();
            }
        }

        if ((pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) &&
            C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu()) ) {

            rrtHnduhknVKisoVKisnyu1 = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
        }

        if (tumitateKinBeanJtnyknBase != null) {
            yoteiRirituJtnyknBase = tumitateKinBeanJtnyknBase.getYoteiriritu();
            kihrkPJtnyknBase = tumitateKinBeanJtnyknBase.getKiharaikomiP();
            syuPTumitateKin = tumitateKinBeanJtnyknBase.getTmttKngk();
        }

        if (tumitateKinBeanRironBase != null) {
            yoteiRirituRironBase = tumitateKinBeanRironBase.getYoteiriritu();
            if (BizDateUtil.compareYmd(pSrHoyuuMeisaiBatchParam.getKijyunymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_EQUAL ||
                BizDateUtil.compareYmd(pSrHoyuuMeisaiBatchParam.getKijyunymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_GREATER) {
                tumiTateKin = tumitateKinBeanRironBase.getTmttKngk();
                kiharaikomiP = tumitateKinBeanRironBase.getKiharaikomiP();
            }
            gaikadateSyukeiyakuP = pRironBase;
        }
        if (tumitateKinBeanJtnyknBaseGsc != null) {

            syuPTumitateKinGsc = tumitateKinBeanJtnyknBaseGsc.getTmttKngk();
        }

        if (tumitateKinBeanNkgnsBase != null) {
            gaikadateNkgns = tumitateKinBeanNkgnsBase.getTmttKngk();
        }

        if (tumitateKinBeanMsukisymBaseGsc != null) {
            gessiTumitateKin = tumitateKinBeanMsukisymBaseGsc.getTmttKngk();
        }

        if (tumitateKinBeanMsukisYmBase != null) {
            gaikadateTougetuJuutouP = pMsukisymBase;
            kihrkmPMsukisYmbase = tumitateKinBeanMsukisYmBase.getKiharaikomiP();
            keisanHanteiyouTmttkn = tumitateKinBeanMsukisYmBase.getvTyouseimae();
            gtmtV = tumitateKinBeanMsukisYmBase.getTmttKngk();
            zettaiSibouRitu = tumitateKinBeanMsukisYmBase.getZettaiSibouritu();
            soutaiSibouRitu = tumitateKinBeanMsukisYmBase.getSoutaiSibouritu();
            soutaiKaiyakuRitu = tumitateKinBeanMsukisYmBase.getSoutaiKaiyakuritu();
            vHireiLRitu2 = tumitateKinBeanMsukisYmBase.getYoteiIjihirituVhirei();
            pHireiAlpha = tumitateKinBeanMsukisYmBase.getYoteiSinkeiyakuhiritu();
            pHireiBeta = tumitateKinBeanMsukisYmBase.getYoteiIjihirituPhirei();
            pHireiGanma = tumitateKinBeanMsukisYmBase.getYoteiSyuukinhiritu();
            pHireiLWrbkRitu = tumitateKinBeanMsukisYmBase.getKogakuWaribikiritu();
            yoteiRirituMsukisYmBase = tumitateKinBeanMsukisYmBase.getYoteiriritu();
        }

        String jikaiPJyuutouYmWk2 = "";
        if (jikaiPJyuutouYm != null) {

            jikaiPJyuutouYmWk2 = jikaiPJyuutouYm.toString();
        }

        pZtHoyuuMeisaiTy.setZtygaikakbn(gaikaKbn);
        pZtHoyuuMeisaiTy.setZtykawaserate1(kawaserate1);
        pZtHoyuuMeisaiTy.setZtykawaseratetekiyouymd1(kwsrateKjYmd1.toString());
        pZtHoyuuMeisaiTy.setZtykykjikawaserate(kawaserate);
        pZtHoyuuMeisaiTy.setZtykykjikawaseratetkyuymd(kwsrateKjYmd.toString());
        pZtHoyuuMeisaiTy.setZtymvatyouseigow(new BigDecimal(mvatyouseigow.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtymvakeisanjisknnjynbkn(new BigDecimal(mvakeisanjisknnjynbkn.toAdsoluteString())
        .longValue());
        pZtHoyuuMeisaiTy.setZtykaiyakukoujyoritu(kaiyakukoujyoritu2);
        pZtHoyuuMeisaiTy.setZtyrendouritu(rendouritu);
        pZtHoyuuMeisaiTy.setZtysrkaiyakusjkkktyouseirrt(
            srkaiyakusjkkktyouseirrt);
        pZtHoyuuMeisaiTy.setZtysrkyksjkkktyouseiriritu(suuriyoukeiyakusjktsritu);
        pZtHoyuuMeisaiTy.setZtymvakeisankijyunymd(mvaKeisanDate.toString());
        pZtHoyuuMeisaiTy.setZtymvatyouseikou(mvatyouseikou);
        pZtHoyuuMeisaiTy.setZtyenkdtsbujsitihsyukngk(new BigDecimal(enkdtsbujsitihsyukngk.toAdsoluteString())
        .longValue());
        pZtHoyuuMeisaiTy.setZtykeiyakujiyoteiriritu(kykjiYoteiRiritu);
        pZtHoyuuMeisaiTy.setZtytumitateriritu(tumitateRiritu);
        pZtHoyuuMeisaiTy.setZtykaigomaebaraitkykarihyj(kaigomaebaraitkykarihyj);
        pZtHoyuuMeisaiTy.setZtysibouhyoukbn(sibouhyouKbn);
        pZtHoyuuMeisaiTy.setZtywyendttargetmokuhyouritu(pWyendttargetmokuhyouritu);
        pZtHoyuuMeisaiTy.setZtysisuurendourate(sisuurendouRate.toString());
        pZtHoyuuMeisaiTy.setZtysisuukbn(sisuuKbn);
        pZtHoyuuMeisaiTy.setZtyteirituikouhyouji(teirituIkouHyouji);
        pZtHoyuuMeisaiTy.setZtysrdai1hknkkn(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn()));
        pZtHoyuuMeisaiTy.setZtytmttknzoukaritujygn(tmttknZoukarituJygn);
        pZtHoyuuMeisaiTy.setZtysetteibairitu(setteiBairitu);
        pZtHoyuuMeisaiTy.setZtytykzenoutouymdsisuu(tykzenoutouYmdSisuu);
        pZtHoyuuMeisaiTy.setZtykimatusisuu(kimatuSisuu);
        pZtHoyuuMeisaiTy.setZtytuukasyukbn(tuukasyuKbn);
        pZtHoyuuMeisaiTy.setZtysisuurentumitatekin(new BigDecimal(sisuurenTumitatekin.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtynksjitirttumitatekin(
            new BigDecimal(nksjitirttumitatekin.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtykimatutirttumitatekin(
            new BigDecimal(kimatutirtTumitatekin.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtygaikadatejyuutoup(
            new BigDecimal(gaikadatejyuutoup.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtyyendttargetkijyunkingaku(
            new BigDecimal(pYendttargetkijyunkingaku.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtysisuurentyokugotmttkn(new BigDecimal(sisuurentyokugotmttkn.toAdsoluteString())
        .longValue());
        pZtHoyuuMeisaiTy.setZtyyoteiririturironbase(yoteiRirituRironBase);
        pZtHoyuuMeisaiTy.setZtyyoteiriritujtnyknbase(yoteiRirituJtnyknBase);
        pZtHoyuuMeisaiTy.setZtykihrkmpjtnyknbase(
            new BigDecimal(kihrkPJtnyknBase.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtysyuptumitatekin(
            new BigDecimal(syuPTumitateKin.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtysyuptumitatekingsc(
            new BigDecimal(syuPTumitateKinGsc.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtygaikadatenkgns(
            new BigDecimal(gaikadateNkgns.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtyjikaipjyuutouym2(jikaiPJyuutouYmWk2);
        pZtHoyuuMeisaiTy.setZtygessitumitatekin(
            new BigDecimal(gessiTumitateKin.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtygaikadatetougetujuutoup(
            new BigDecimal(gaikadateTougetuJuutouP.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtykihrkmpmsukisymbase(
            new BigDecimal(kihrkmPMsukisYmbase.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtykeisanhanteiyoutmttkn(
            new BigDecimal(keisanHanteiyouTmttkn.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtygtmtv(
            new BigDecimal(gtmtV.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtyzettaisibouritu(zettaiSibouRitu);
        pZtHoyuuMeisaiTy.setZtysoutaisibouritu(soutaiSibouRitu);
        pZtHoyuuMeisaiTy.setZtysoutaikaiyakuritu(soutaiKaiyakuRitu);
        pZtHoyuuMeisaiTy.setZtyvhireilritu2(vHireiLRitu2);
        pZtHoyuuMeisaiTy.setZtyphireialpha(pHireiAlpha);
        pZtHoyuuMeisaiTy.setZtyphireibeta(pHireiBeta);
        pZtHoyuuMeisaiTy.setZtyphireiganma(pHireiGanma);
        pZtHoyuuMeisaiTy.setZtyphireilwrbkritu(pHireiLWrbkRitu);
        pZtHoyuuMeisaiTy.setZtyyoteiriritumsukisymbase(yoteiRirituMsukisYmBase);
        pZtHoyuuMeisaiTy.setZtyrrthnduhknvkisovkisnyu1(
            new BigDecimal(rrtHnduhknVKisoVKisnyu1.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtytumitatekin(
            new BigDecimal(tumiTateKin.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtykiharaikomip(
            new BigDecimal(kiharaikomiP.toAdsoluteString()).longValue());
        pZtHoyuuMeisaiTy.setZtygaikadatesyukeiyakup(
            new BigDecimal(gaikadateSyukeiyakuP.toAdsoluteString()).longValue());

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
            pZtHoyuuMeisaiTy.setZtysibous(
                new BigDecimal(sibouS.toAdsoluteString()).longValue());
            pZtHoyuuMeisaiTy.setZtygoukeigyousekihyjsibous(
                new BigDecimal(goukeiGyousekiHyjSibouS.toAdsoluteString()).longValue());
            pZtHoyuuMeisaiTy.setZtyalmyousibous(
                new BigDecimal(almyouSibouS.toAdsoluteString()).longValue());
        }

        if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
            (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtygaikakbn(gaikaKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykawaserate1(kawaserate1);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykawaseratetekiyouymd1(kwsrateKjYmd1.toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykykjikawaserate(kawaserate);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykykjikawaseratetkyuymd(kwsrateKjYmd.toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtymvatyouseigow(new BigDecimal(mvatyouseigow.toAdsoluteString())
            .longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtymvakeisanjisknnjynbkn(new BigDecimal(mvakeisanjisknnjynbkn
                .toAdsoluteString())
            .longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykaiyakukoujyoritu(kaiyakukoujyoritu2);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyrendouritu(rendouritu);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysrkaiyakusjkkktyouseirrt(srkaiyakusjkkktyouseirrt
                );
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysrkyksjkkktyouseiriritu(suuriyoukeiyakusjktsritu
                );
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtymvakeisankijyunymd(mvaKeisanDate.toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtymvatyouseikou(mvatyouseikou);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyenkdtsbujsitihsyukngk(new BigDecimal(enkdtsbujsitihsyukngk
                .toAdsoluteString())
            .longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykeiyakujiyoteiriritu(kykjiYoteiRiritu);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytumitateriritu(tumitateRiritu);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykaigomaebaraitkykarihyj(kaigomaebaraitkykarihyj);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysibouhyoukbn(sibouhyouKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtywyendttargetmokuhyouritu(pWyendttargetmokuhyouritu);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysisuurendourate(sisuurendouRate.toString());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysisuukbn(sisuuKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysrdai1hknkkn(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn()));
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyteirituikouhyouji(teirituIkouHyouji);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytmttknzoukaritujygn(tmttknZoukarituJygn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysetteibairitu(setteiBairitu);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytykzenoutouymdsisuu(tykzenoutouYmdSisuu);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykimatusisuu(kimatuSisuu);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytuukasyukbn(tuukasyuKbn);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysisuurentumitatekin(new BigDecimal(sisuurenTumitatekin
                .toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtynksjitirttumitatekin(new BigDecimal(nksjitirttumitatekin
                .toAdsoluteString())
            .longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykimatutirttumitatekin(new BigDecimal(kimatutirtTumitatekin
                .toAdsoluteString())
            .longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtygaikadatejyuutoup(
                new BigDecimal(gaikadatejyuutoup.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyyendttargetkijyunkingaku(
                new BigDecimal(pYendttargetkijyunkingaku.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysisuurentyokugotmttkn(new BigDecimal(sisuurentyokugotmttkn.
                toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyyoteiririturironbase(yoteiRirituRironBase);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyyoteiriritujtnyknbase(yoteiRirituJtnyknBase);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykihrkmpjtnyknbase(
                new BigDecimal(kihrkPJtnyknBase.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysyuptumitatekin(
                new BigDecimal(syuPTumitateKin.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysyuptumitatekingsc(
                new BigDecimal(syuPTumitateKinGsc.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtygaikadatenkgns(
                new BigDecimal(gaikadateNkgns.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyjikaipjyuutouym2(jikaiPJyuutouYmWk2);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtygessitumitatekin(
                new BigDecimal(gessiTumitateKin.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtygaikadatetougetujuutoup(
                new BigDecimal(gaikadateTougetuJuutouP.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykihrkmpmsukisymbase(
                new BigDecimal(kihrkmPMsukisYmbase.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykeisanhanteiyoutmttkn(
                new BigDecimal(keisanHanteiyouTmttkn.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtygtmtv(
                new BigDecimal(gtmtV.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyzettaisibouritu(zettaiSibouRitu);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysoutaisibouritu(soutaiSibouRitu);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysoutaikaiyakuritu(soutaiKaiyakuRitu);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyvhireilritu2(vHireiLRitu2);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyphireialpha(pHireiAlpha);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyphireibeta(pHireiBeta);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyphireiganma(pHireiGanma);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyphireilwrbkritu(pHireiLWrbkRitu);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyyoteiriritumsukisymbase(yoteiRirituMsukisYmBase);
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtyrrthnduhknvkisovkisnyu1(
                new BigDecimal(rrtHnduhknVKisoVKisnyu1.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtytumitatekin(
                new BigDecimal(tumiTateKin.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtykiharaikomip(
                new BigDecimal(kiharaikomiP.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtygaikadatesyukeiyakup(
                new BigDecimal(gaikadateSyukeiyakuP.toAdsoluteString()).longValue());
            pStHoyuuMeisaiTyukeiyouItzHzn.setZtysrkaiyakukoujyoritu(kaiyakukoujyoritu);

            if (pSyouhinZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
                pStHoyuuMeisaiTyukeiyouItzHzn.setZtysibous(
                    new BigDecimal(sibouS.toAdsoluteString()).longValue());
                pStHoyuuMeisaiTyukeiyouItzHzn.setZtygoukeigyousekihyjsibous(
                    new BigDecimal(goukeiGyousekiHyjSibouS.toAdsoluteString()).longValue());
                pStHoyuuMeisaiTyukeiyouItzHzn.setZtyalmyousibous(
                    new BigDecimal(almyouSibouS.toAdsoluteString()).longValue());
            }
        }
    }

    private void createSuuriyouErrJyouhou(SrHoyuuMeisaiBatchParam pSrHoyuuMeisaiBatchParam,
        SV_HoyuuMeisai pSvHoyuuMeisai, String msg) {

        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

        suuriyouErrJyouhou.setSyoriYmd(pSrHoyuuMeisaiBatchParam.getSyoriYmd());
        suuriyouErrJyouhou.setKakutyoujobcd(pSrHoyuuMeisaiBatchParam.getIbKakutyoujobcd());
        suuriyouErrJyouhou.setSyono(pSvHoyuuMeisai.getSyono());
        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

        pSrHoyuuMeisaiBatchParam.setErrorsyorikensuu(pSrHoyuuMeisaiBatchParam.getErrorsyorikensuu() + 1);
        errorFlag = true;
    }

    private void editHoyuuMeisaiItzHznDokujiData(SrHoyuuMeisaiBatchParam pSrHoyuuMeisaiBatchParam,
        SV_HoyuuMeisai pSvHoyuuMeisai,
        ST_HoyuuMeisaiTyukeiyouItzHzn pStHoyuuMeisaiTyukeiyouItzHzn) {

        pStHoyuuMeisaiTyukeiyouItzHzn.setZtysrkijyunym(pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM()
            .toString());
        pStHoyuuMeisaiTyukeiyouItzHzn.setZtysrkakutyoujobcd(pSrHoyuuMeisaiBatchParam.getIbKakutyoujobcd());
        pStHoyuuMeisaiTyukeiyouItzHzn.setZtysrteikishrtkykhukaumu(pSvHoyuuMeisai.getTeikishrtkykhukaumu().getValue());
    }

    private void getHeijyunCommonInfo(
        SrHoyuuMeisaiBatchParam pSrHoyuuMeisaiBatchParam,
        SV_HoyuuMeisai pSvHoyuuMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst,
        List<IT_HokenryouTmttkn> pHokenryouTmttknLst,
        int pSyouhinZokusei) {

        BizDateYM keisanKijyunYmJtnyknBaseGessi = null;
        BizDateYM keisanKijyunYmJtnyknBase = null;
        BizDateYM keisanKijyunYmMsukisymBaseGessi = null;
        BizDateYM keisanKijyunYmMsukisymBase = null;
        BizDateYM keisanKijyunYmRironBase = null;
        BizDateYM keisanKijyunYm = null;
        BizDate keisanKwsratekjymd = null;
        boolean nkgnsZenKeisanFlg = false;

        SrGetTokutejitenAnsyuKihonInfo srGetTokutejitenAnsyuKihonInfo =
            SWAKInjector.getInstance(SrGetTokutejitenAnsyuKihonInfo.class);
        jikaiPJyuutouYm = srGetTokutejitenAnsyuKihonInfo.exec(pSvHoyuuMeisai.getSyono() ,
            pSrHoyuuMeisaiBatchParam.getKijyunymd(), pSvHoyuuMeisai.getJkipjytym(), null);

        SrGetTokutejitenKykKihonInfo srGetTokutejitenKykKihonInfo =
            SWAKInjector.getInstance(SrGetTokutejitenKykKihonInfo.class);

        SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
            C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN, pSvHoyuuMeisai.getSyono(),
            pSrHoyuuMeisaiBatchParam.getKijyunymd(),
            null, pSvKiykSyuhnDataLst, pSvHoyuuMeisai.getTikiktbrisyuruikbn(), pSvHoyuuMeisai.getHrkkeiro(),
            pSvHoyuuMeisai.getHrkkaisuu());

        tkIktbriSyuruiKbn = srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae().getValue();
        hrkkeiro = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();
        hrkkaisuu = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();

        if (pSyouhinZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            if (BizDateUtil.compareYm(jikaiPJyuutouYm,
                pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM()) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYm(jikaiPJyuutouYm,
                    pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {

                keisanKijyunYmJtnyknBase = jikaiPJyuutouYm.addMonths(-SrCommonConstants.KIKAN_1M);
                keisanKijyunYmJtnyknBaseGessi = keisanKijyunYmJtnyknBase.addMonths(-SrCommonConstants.KIKAN_1M);
                keisanKijyunYmMsukisymBase = jikaiPJyuutouYm;
                keisanKijyunYmMsukisymBaseGessi = keisanKijyunYmMsukisymBase.addMonths(-SrCommonConstants.KIKAN_1M);
                keisanKijyunYmRironBase = pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM();
                keisanKijyunYm =  keisanKijyunYmJtnyknBase.addMonths(-SrCommonConstants.KIKAN_1M);
            }
            else {
                if (BizDateUtil.compareYm(pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM()) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYm(pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM()) == BizDateUtil.COMPARE_EQUAL ) {

                    keisanKijyunYmJtnyknBase = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
                    keisanKijyunYmRironBase = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
                    keisanKijyunYm =  pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
                    nkgnsZenKeisanFlg = true;
                }
                else {
                    keisanKijyunYmJtnyknBase = pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM();
                    keisanKijyunYmJtnyknBaseGessi = keisanKijyunYmJtnyknBase.addMonths(-SrCommonConstants.KIKAN_1M);
                    keisanKijyunYmRironBase = pSrHoyuuMeisaiBatchParam.getKijyunymd().getBizDateYM();
                    keisanKijyunYm =  keisanKijyunYmJtnyknBase.addMonths(-SrCommonConstants.KIKAN_1M);
                }
            }

            if (BizDateUtil.compareYmd(pSrHoyuuMeisaiBatchParam.getSyoriYmd(),
                pSrHoyuuMeisaiBatchParam.getKijyunymd()) == BizDateUtil.COMPARE_LESSER) {
                keisanKwsratekjymd = pSrHoyuuMeisaiBatchParam.getSyoriYmd();
            }
            else {
                keisanKwsratekjymd = pSrHoyuuMeisaiBatchParam.getKijyunymd();
            }

            SrSuuriKeisanVHeijyun srSuuriKeisanVHeijyun =
                SWAKInjector.getInstance(SrSuuriKeisanVHeijyun.class);

            C_ErrorKbn errorKbn = srSuuriKeisanVHeijyun.exec(pSvHoyuuMeisai.getSyono() ,
                pTkJitenKeiyakuSyouhinKijyunBean, pSvKiykSyuhnDataLst, pHokenryouTmttknLst,
                keisanKijyunYm, keisanKijyunYmRironBase, pSvHoyuuMeisai.getHrkkaisuu(), pSvHoyuuMeisai.getFstpnyknymd(),
                true, keisanKwsratekjymd, nkgnsZenKeisanFlg, false);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "数理平準払用保険料積立金",
                    pSvHoyuuMeisai.getSyono());

                batchLogger.warn(msg);
                createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
            }
            else {
                List<SrTmttknBean> srTmttknBeanList = srSuuriKeisanVHeijyun.getSrTmttknBeanList();
                for (SrTmttknBean srTmttknBean :srTmttknBeanList) {
                    if (BizDateUtil.compareYm(keisanKijyunYmJtnyknBaseGessi, srTmttknBean.getTumitateYM()) == BizDateUtil.COMPARE_EQUAL) {
                        tumitateKinBeanJtnyknBaseGsc = srTmttknBean;
                    }
                    if (BizDateUtil.compareYm(keisanKijyunYmJtnyknBase, srTmttknBean.getTumitateYM()) == BizDateUtil.COMPARE_EQUAL) {
                        tumitateKinBeanJtnyknBase = srTmttknBean;

                        KeisanGaikaP keisanGaikaP = SWAKInjector.getInstance(KeisanGaikaP.class);

                        errorKbn = keisanGaikaP.execKawaseSitei(
                            tumitateKinBeanJtnyknBase.getHokenryou(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                            tumitateKinBeanJtnyknBase.getKawaserate());

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            String msg = MessageUtil.getMessage(MessageId.ESA1001,
                                "単月外貨入金額計算（実入金ベース）",
                                pSvHoyuuMeisai.getSyono());

                            batchLogger.warn(msg);
                            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
                        }
                        else {
                            pJtnyknBase = keisanGaikaP.getP();
                        }
                    }
                    if (BizDateUtil.compareYm(keisanKijyunYmMsukisymBaseGessi, srTmttknBean.getTumitateYM()) == BizDateUtil.COMPARE_EQUAL) {
                        tumitateKinBeanMsukisymBaseGsc = srTmttknBean;
                    }
                    if (BizDateUtil.compareYm(keisanKijyunYmMsukisymBase, srTmttknBean.getTumitateYM()) == BizDateUtil.COMPARE_EQUAL) {

                        tumitateKinBeanMsukisYmBase = srTmttknBean;

                        KeisanGaikaP keisanGaikaP =
                            SWAKInjector.getInstance(KeisanGaikaP.class);

                        C_ErrorKbn errorKbn1 = keisanGaikaP.execKawaseSitei(
                            tumitateKinBeanMsukisYmBase.getHokenryou(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                            tumitateKinBeanMsukisYmBase.getKawaserate());

                        if (C_ErrorKbn.ERROR.eq(errorKbn1)) {
                            String msg = MessageUtil.getMessage(MessageId.ESA1001,
                                "単月外貨入金額計算（未収開始月ベース）",
                                pSvHoyuuMeisai.getSyono());

                            batchLogger.warn(msg);
                            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
                        }
                        else {
                            pMsukisymBase = keisanGaikaP.getP();
                        }
                    }

                    if (BizDateUtil.compareYm(keisanKijyunYmRironBase, srTmttknBean.getTumitateYM()) == BizDateUtil.COMPARE_EQUAL) {
                        tumitateKinBeanRironBase = srTmttknBean;

                        KeisanGaikaP keisanGaikaP =
                            SWAKInjector.getInstance(KeisanGaikaP.class);

                        C_ErrorKbn errorKbn2 = keisanGaikaP.execKawaseSitei(
                            tumitateKinBeanRironBase.getHokenryou(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                            srTmttknBeanList.get(srTmttknBeanList.size() - 1).getKawaserate());
                        if (C_ErrorKbn.ERROR.eq(errorKbn2)) {

                            String msg = MessageUtil.getMessage(MessageId.ESA1001,
                                "単月外貨入金額計算（理論ベース）",
                                pSvHoyuuMeisai.getSyono());

                            batchLogger.warn(msg);
                            createSuuriyouErrJyouhou(pSrHoyuuMeisaiBatchParam, pSvHoyuuMeisai, msg);
                        }
                        else {
                            pRironBase = keisanGaikaP.getP();
                        }
                    }
                }
                if (srTmttknBeanList.size() > 0 ) {
                    tumitateKinBeanNkgnsBase = srTmttknBeanList.get(srTmttknBeanList.size() - 1);
                }
            }
        }
    }
}
