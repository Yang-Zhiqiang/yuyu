package yuyu.batch.suuri.srsuuritoukei.srbikinidoumeisai;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
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
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_DaiKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GetTaisyouSonotaTokuyakuKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_HosyouKinouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IdouRecordKbn;
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
import yuyu.def.classification.C_SuuriIdoKbn;
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
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_BikinIdouMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_BikinIdouMeisaiTy;
import yuyu.def.suuri.configuration.YuyuSuuriConfig;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 備金異動明細情報作成
 */
public class SrBikinIdouMeisaiBatchEdit {

    private int recordCtr = 1;

    @Inject
    private BatchLogger batchLogger;

    private Boolean errorFlg;

    private BM_SyouhnZokusei bmSyouhnZokusei = null;

    private static final String DIFFNENDO = "1";

    private static final String DIFFHALFNENDO = "2";

    private static final String DIFF1STQ = "3";

    private static final String DIFF3RDQ = "4";

    private static final String DIFFOTHERQ = "0";

    private BizCurrency initsbjiyenkasaiteihsygk = null;

    private int endttargetmokuhyourituplusrecord = 0;

    private BizCurrency endttargetkijyungkplusrecord = null;

    private BizDateYM jkipjytym = null;

    private BizDateYM jkipjytymplusrecord = null;

    private BizDate hijykouryokukaisiymd = null;

    private String tikikktbrijyututksu = null;

    private String tikikktbrijyututksuplusrecord = null;

    private BizCurrency ptumitatekinjtnyknbase = null;

    private BizCurrency kihrkmpstgkjtnyknbase = null;

    private BizNumber yoteiriritujtnyknbase = null;

    private BizNumber vhireilritujtnyknbase = null;

    private BizCurrency ptumitatekinriroubase = null;

    private BizCurrency kihrkmpstgkriroubase = null;

    private BizCurrency ptumitatekinnkgns = null;

    private BizCurrency gaikadatesyukeiyakup = null;

    private BizCurrency nkgns = null;

    private C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

    private C_Hrkkeiro hrkkeiroplusrecord = C_Hrkkeiro.BLNK;

    private String hhkdrtkykarihyjPlusrecord = null;

    private String kykdrtkykarihyjPlusrecord = null;

    private C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.BLNK;

    private C_Hrkkaisuu hrkkaisuuplusrecord = C_Hrkkaisuu.BLNK;

    public Boolean editKoumoku(SrBikinIdouMeisaiBatchParam pSrBikinIdouMeisaiBatchParam,
        SV_BikinIdouMeisai pBikinIdouMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_BikinIdouMeisaiTy pZtBikinIdouMeisaiTy,
        C_IdouRecordKbn pIdouRecordKbn, BizDate pKouryokuhasseiymd,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn,
        int pSyohnZokusei,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn,
        BizDate pTmttknInfoKijyunYmd,
        List<SV_KiykSyuhnData> pKiykSyuhnDataList,
        List<IT_KykSyouhnHnkmae> pKykSyouhnHnkmaeList,
        List<IT_HokenryouTmttkn> pHokenryouTmttknList) {

        errorFlg = false;

        SrBikinIdouMeisaiBatchDbAccess srBikinIdouMeisaiBatchDbAccess = SWAKInjector.
            getInstance(SrBikinIdouMeisaiBatchDbAccess.class);

        bmSyouhnZokusei = srBikinIdouMeisaiBatchDbAccess.getSyouhnZokusei(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());

        jkipjytym = null;
        hijykouryokukaisiymd = null;
        tikikktbrijyututksu = "0";
        ptumitatekinjtnyknbase = BizCurrency.valueOf(0);
        kihrkmpstgkjtnyknbase = BizCurrency.valueOf(0);
        yoteiriritujtnyknbase = BizNumber.ZERO;
        vhireilritujtnyknbase = BizNumber.ZERO;
        ptumitatekinriroubase = BizCurrency.valueOf(0);
        kihrkmpstgkriroubase = BizCurrency.valueOf(0);
        ptumitatekinnkgns = BizCurrency.valueOf(0);
        gaikadatesyukeiyakup = BizCurrency.valueOf(0);
        hrkkeiro = C_Hrkkeiro.BLNK;
        hrkkaisuu = C_Hrkkaisuu.BLNK;

        if (pSyohnZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN
            || pSyohnZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            getHijyKyoutuuInfo(pSrBikinIdouMeisaiBatchParam,
                pBikinIdouMeisai,
                pTkJitenKeiyakuSyouhinKijyunBean,
                pIdouRecordKbn,
                pKiykSyuhnDataList,
                pHokenryouTmttknList,
                pSyohnZokusei);

        }

        editCommonData(pSrBikinIdouMeisaiBatchParam,
            pBikinIdouMeisai,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pZtBikinIdouMeisaiTy,
            pIdouRecordKbn,
            pIdouMeisaiTyukeiyouItzHzn,
            pSyohnZokusei,
            pKhSisuurendoTmttkn,
            pTmttknInfoKijyunYmd);

        editAlmData(pSrBikinIdouMeisaiBatchParam,
            pBikinIdouMeisai,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pIdouRecordKbn,
            pKouryokuhasseiymd,
            pZtBikinIdouMeisaiTy,
            pIdouMeisaiTyukeiyouItzHzn,
            pSyohnZokusei,
            pKhSisuurendoTmttkn);

        editHeaderData(pSrBikinIdouMeisaiBatchParam,
            pZtBikinIdouMeisaiTy,
            pIdouMeisaiTyukeiyouItzHzn, pSyohnZokusei, pTkJitenKeiyakuSyouhinKijyunBean);

        editRayData(pSrBikinIdouMeisaiBatchParam,
            pBikinIdouMeisai,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pIdouRecordKbn,
            pZtBikinIdouMeisaiTy,
            pKouryokuhasseiymd,
            pIdouMeisaiTyukeiyouItzHzn,
            pSyohnZokusei,
            pKhSisuurendoTmttkn,
            pTmttknInfoKijyunYmd,
            pKiykSyuhnDataList,
            pKykSyouhnHnkmaeList);

        if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {

            editIDDetailData(pSrBikinIdouMeisaiBatchParam, pBikinIdouMeisai, pTmttknInfoKijyunYmd, pIdouMeisaiTyukeiyouItzHzn);
        }

        return errorFlg;

    }

    private void editCommonData(SrBikinIdouMeisaiBatchParam pSrBikinIdouMeisaiBatchParam,
        SV_BikinIdouMeisai pBikinIdouMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        ZT_BikinIdouMeisaiTy pZtBikinIdouMeisaiTy,
        C_IdouRecordKbn pIdouRecordKbn,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn,
        int pSyohnZokusei,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn,
        BizDate pTmttknInfoKijyunYmd) {

        String ztyidourecordkbn = "";
        String ztyhenkousyoriymd = "";
        BizDate ztysuuriyoukouryokukaisiymd = null;
        String ztydenymd = "";
        String ztyidoujiyuucd = "";
        String suuriSyuruiCd = "";
        String sedaiKbn = "";
        String bosyuKeitaiKbn = "";
        String haitouKbn = "";

        if (C_BkncdKbn.KAIYAKU.eq(pBikinIdouMeisai.getBkncdkbn())) {

            ztyidourecordkbn = C_IdouRecordKbn.SINGLERECORD.getValue();

            if(BizDateUtil.compareYmd(pBikinIdouMeisai.getShrsyoriymd(), pBikinIdouMeisai.getKessankijyunymd()) ==
                BizDateUtil.COMPARE_GREATER) {

                ztyhenkousyoriymd = pBikinIdouMeisai.getShrsyoriymd().toString();
            }
            else {
                ztyhenkousyoriymd = pBikinIdouMeisai.getKessankijyunymd().toString();
            }

            if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
                if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() <= pBikinIdouMeisai.getCalckijyunymd().getDay()) {

                    if (pBikinIdouMeisai.getCalckijyunymd().getDay() -
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() >= 15) {

                        ztysuuriyoukouryokukaisiymd =
                            BizDate.valueOf(pBikinIdouMeisai.getCalckijyunymd().getNextMonth().getBizDateYM(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                    else {

                        ztysuuriyoukouryokukaisiymd =
                            BizDate.valueOf(pBikinIdouMeisai.getCalckijyunymd().getBizDateYM(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                }
                else {

                    if (pBikinIdouMeisai.getCalckijyunymd().getDay() -
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() + 30 >= 15) {

                        ztysuuriyoukouryokukaisiymd =
                            BizDate.valueOf(pBikinIdouMeisai.getCalckijyunymd().getBizDateYM(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                    else {

                        ztysuuriyoukouryokukaisiymd =
                            BizDate.valueOf(pBikinIdouMeisai.getCalckijyunymd().getPreviousMonth().getBizDateYM(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                }
            }
            else {
                ztysuuriyoukouryokukaisiymd = hijykouryokukaisiymd;
            }

            ztydenymd = pBikinIdouMeisai.getKessankijyunymd().toString();

            ztyidoujiyuucd = SrCommonConstants.IDOUJIYUCD_KAIYAKU;
        }

        else if (C_BkncdKbn.GENGK.eq(pBikinIdouMeisai.getBkncdkbn())) {

            if (C_IdouRecordKbn.MINUSRECORD.eq(pIdouRecordKbn)) {

                ztyidourecordkbn = C_IdouRecordKbn.MINUSRECORD.getValue();

                ztyidoujiyuucd = SrCommonConstants.IDOUJIYUCD_GENGAKU_MINUS;
            }
            else if (C_IdouRecordKbn.PLUSRECORD.eq(pIdouRecordKbn)) {

                ztyidourecordkbn = C_IdouRecordKbn.PLUSRECORD.getValue();

                ztyidoujiyuucd = SrCommonConstants.IDOUJIYUCD_GENGAKU_PLUS;
            }

            if(BizDateUtil.compareYmd(pBikinIdouMeisai.getShrsyoriymd(), pBikinIdouMeisai.getKessankijyunymd()) ==
                BizDateUtil.COMPARE_GREATER) {

                ztyhenkousyoriymd = pBikinIdouMeisai.getShrsyoriymd().toString();
            }
            else {
                ztyhenkousyoriymd = pBikinIdouMeisai.getKessankijyunymd().toString();
            }

            if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
                if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() <= pBikinIdouMeisai.getCalckijyunymd().getDay()) {

                    if (pBikinIdouMeisai.getCalckijyunymd().getDay() -
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() >= 15) {

                        ztysuuriyoukouryokukaisiymd =
                            BizDate.valueOf(pBikinIdouMeisai.getCalckijyunymd().getNextMonth().getBizDateYM(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                    else {

                        ztysuuriyoukouryokukaisiymd =
                            BizDate.valueOf(pBikinIdouMeisai.getCalckijyunymd().getBizDateYM(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                }
                else {

                    if (pBikinIdouMeisai.getCalckijyunymd().getDay() -
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() + 30 >= 15) {

                        ztysuuriyoukouryokukaisiymd =
                            BizDate.valueOf(pBikinIdouMeisai.getCalckijyunymd().getBizDateYM(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                    else {

                        ztysuuriyoukouryokukaisiymd =
                            BizDate.valueOf(pBikinIdouMeisai.getCalckijyunymd().getPreviousMonth().getBizDateYM(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                }
            }
            else {
                ztysuuriyoukouryokukaisiymd = hijykouryokukaisiymd;
            }

            ztydenymd = pBikinIdouMeisai.getKessankijyunymd().toString();

        }

        else if (C_BkncdKbn.SIBOUUKETUKE.eq(pBikinIdouMeisai.getBkncdkbn())) {

            ztyidourecordkbn = C_IdouRecordKbn.SINGLERECORD.getValue();

            ztyhenkousyoriymd = pBikinIdouMeisai.getKessankijyunymd().toString();

            ztysuuriyoukouryokukaisiymd = pBikinIdouMeisai.getCalckijyunymd();

            ztydenymd = pBikinIdouMeisai.getKessankijyunymd().toString();

            ztyidoujiyuucd = SrCommonConstants.IDOUJIYUCD_SIBOU;
        }

        else if (C_BkncdKbn.SIBOUKARIUKETUKE.eq(pBikinIdouMeisai.getBkncdkbn())) {

            ztyidourecordkbn = C_IdouRecordKbn.SINGLERECORD.getValue();

            ztyhenkousyoriymd = pBikinIdouMeisai.getKessankijyunymd().toString();

            ztysuuriyoukouryokukaisiymd = pBikinIdouMeisai.getCalckijyunymd();

            ztydenymd = pBikinIdouMeisai.getKessankijyunymd().toString();

            ztyidoujiyuucd = SrCommonConstants.IDOUJIYUCD_SIBOU;
        }

        else if (C_BkncdKbn.SIBOUKAIJYO.eq(pBikinIdouMeisai.getBkncdkbn())) {

            ztyidourecordkbn = C_IdouRecordKbn.SINGLERECORD.getValue();

            ztyhenkousyoriymd = pBikinIdouMeisai.getGyoumuKousinTime().toString().substring(0, 8);

            if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
                if (pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() <= pBikinIdouMeisai.getCalckijyunymd().getDay()) {

                    if (pBikinIdouMeisai.getCalckijyunymd().getDay() -
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() >= 15) {

                        ztysuuriyoukouryokukaisiymd =
                            BizDate.valueOf(pBikinIdouMeisai.getCalckijyunymd().getNextMonth().getBizDateYM(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                    else {

                        ztysuuriyoukouryokukaisiymd =
                            BizDate.valueOf(pBikinIdouMeisai.getCalckijyunymd().getBizDateYM(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                }
                else {

                    if (pBikinIdouMeisai.getCalckijyunymd().getDay() -
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay() + 30 >= 15) {

                        ztysuuriyoukouryokukaisiymd =
                            BizDate.valueOf(pBikinIdouMeisai.getCalckijyunymd().getBizDateYM(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                    else {

                        ztysuuriyoukouryokukaisiymd =
                            BizDate.valueOf(pBikinIdouMeisai.getCalckijyunymd().getPreviousMonth().getBizDateYM(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay());
                    }
                }
            }
            else {
                ztysuuriyoukouryokukaisiymd = hijykouryokukaisiymd;
            }

            ztydenymd = pBikinIdouMeisai.getKessankijyunymd().toString();

            ztyidoujiyuucd = SrCommonConstants.IDOUJIYUCD_SIBOUKAIJYO;
        }

        else if (C_BkncdKbn.MENSEKI.eq(pBikinIdouMeisai.getBkncdkbn())) {

            ztyidourecordkbn = C_IdouRecordKbn.SINGLERECORD.getValue();

            ztyhenkousyoriymd = pBikinIdouMeisai.getGyoumuKousinTime().toString().substring(0, 8);

            ztysuuriyoukouryokukaisiymd = pBikinIdouMeisai.getCalckijyunymd();

            ztydenymd = pBikinIdouMeisai.getKessankijyunymd().toString();

            ztyidoujiyuucd = SrCommonConstants.IDOUJIYUCD_MENSEKI;
        }

        String year = ztyhenkousyoriymd.substring(2, 4);
        String from = ztyhenkousyoriymd.substring(0, 4) + SrCommonConstants.FIXEDDAY_NENSYOBI;
        String to = ztyhenkousyoriymd;
        String day = String.format("%03d", BizDateUtil.calcDifferenceDays(BizDate.valueOf(to), BizDate.valueOf(from)));
        String renno = String.format("%02d", pSrBikinIdouMeisaiBatchParam.getKeiyakuMFkoushinCTRrenban());
        String keiyakuMFkoushinCTR = year + day + renno;

        int recordctr = recordCtr;

        recordCtr = recordCtr + 1;

        String toukeikijyKbn = "";

        if (pBikinIdouMeisai.getSkeikeijyouym().getMonth() >= SrCommonConstants.MONTH_APRIL
            && pBikinIdouMeisai.getSkeikeijyouym().getMonth() <= SrCommonConstants.MONTH_JUNE) {

            if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), BizDateYM.valueOf(
                pBikinIdouMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_MARCH)) <= 0) {

                toukeikijyKbn = DIFFNENDO;
            }
            else if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), BizDateYM.
                valueOf(pBikinIdouMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_JULY)) >= 0) {

                toukeikijyKbn = DIFF1STQ;
            }
            else {

                toukeikijyKbn = DIFFOTHERQ;
            }
        }
        else if (pBikinIdouMeisai.getSkeikeijyouym().getMonth() >= SrCommonConstants.MONTH_JULY
            && pBikinIdouMeisai.getSkeikeijyouym().getMonth() <= SrCommonConstants.MONTH_SEPTEMBER) {

            if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), BizDateYM.valueOf(
                pBikinIdouMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_OCTOBER)) >= 0) {

                toukeikijyKbn = DIFFHALFNENDO;
            }
            else if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), BizDateYM.valueOf(
                pBikinIdouMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_JUNE)) <= 0) {

                toukeikijyKbn = DIFF1STQ;
            }
            else {

                toukeikijyKbn = DIFFOTHERQ;
            }
        }
        else if (pBikinIdouMeisai.getSkeikeijyouym().getMonth() >= SrCommonConstants.MONTH_OCTOBER
            && pBikinIdouMeisai.getSkeikeijyouym().getMonth() <= SrCommonConstants.MONTH_DECEMBER) {

            if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), BizDateYM.valueOf(
                pBikinIdouMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_SEPTEMBER)) <= 0) {

                toukeikijyKbn = DIFFHALFNENDO;
            }
            else if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), BizDateYM.valueOf(
                pBikinIdouMeisai.getSkeikeijyouym().getNextYear().getYear(), SrCommonConstants.MONTH_JANUARY)) >= 0) {

                toukeikijyKbn = DIFF3RDQ;
            }
            else {

                toukeikijyKbn = DIFFOTHERQ;
            }
        }
        else {

            if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), BizDateYM.valueOf(
                pBikinIdouMeisai.getSkeikeijyouym().getYear(), SrCommonConstants.MONTH_APRIL)) >= 0) {

                toukeikijyKbn = DIFFNENDO;
            }
            else if (BizDateUtil.compareYm(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(),
                BizDateYM.valueOf(pBikinIdouMeisai.getSkeikeijyouym().getPreviousYear().getYear(),
                    SrCommonConstants.MONTH_DECEMBER)) <= 0) {

                toukeikijyKbn = DIFF3RDQ;
            }
            else {

                toukeikijyKbn = DIFFOTHERQ;
            }
        }

        SrBikinIdouMeisaiBatchDbAccess srBikinIdouMeisaiBatchDbAccess =
            SWAKInjector.getInstance(SrBikinIdouMeisaiBatchDbAccess.class);

        String syoricd = srBikinIdouMeisaiBatchDbAccess.getKinou(pBikinIdouMeisai.getGyoumuKousinKinou()).getSyoricd();

        String shihankibikinKbn = "";

        if (pSrBikinIdouMeisaiBatchParam.getKijyunymd().getMonth() == SrCommonConstants.MONTH_JUNE) {

            shihankibikinKbn = SrBikinIdouMeisaiBatchParam.DAI1SHIHANKI;
        }
        else if (pSrBikinIdouMeisaiBatchParam.getKijyunymd().getMonth() == SrCommonConstants.MONTH_SEPTEMBER) {

            shihankibikinKbn = SrBikinIdouMeisaiBatchParam.HANKI;
        }
        else if (pSrBikinIdouMeisaiBatchParam.getKijyunymd().getMonth() == SrCommonConstants.MONTH_DECEMBER) {

            shihankibikinKbn = SrBikinIdouMeisaiBatchParam.DAI3SHIHANKI;
        }
        else {

            shihankibikinKbn = SrBikinIdouMeisaiBatchParam.ZIGYOUNENDOMATU;
        }

        String datakanriNo = pBikinIdouMeisai.getSyono();

        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        String kbnKeiriyouSegmentKbn = "";
        String kbnKeiriyouRgnbnskKbn = "";

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

        if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1007, SrCommonConstants.MSGHYOUJIMOJIRETU_SEGCD
                , pBikinIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd()
                , pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrBikinIdouMeisaiBatchParam, pBikinIdouMeisai, msg);
        }
        else {

            kbnKeiriyouSegmentKbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(0, 2);
            kbnKeiriyouRgnbnskKbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(2, 4);
        }

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(C_SrKbnHenkanKbn.SUURISYURUI,
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1006, C_SrKbnHenkanKbn.SUURISYURUI.getContent(),
                pBikinIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
            errorFlg = true;
        }
        else {

            suuriSyuruiCd = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SEDAI,
            pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.SEDAI.getContent(),
                pBikinIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
            errorFlg = true;
        }
        else {

            sedaiKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizCurrency sibous = BizCurrency.valueOf(0);
        C_HosyouKinouKbn hosyoukinoukbn;
        C_DaiKbn daiKbn;
        C_TyuuKbn tyuuKbn;
        C_SyouKbn syouKbn;
        BizCurrency kihons = BizCurrency.valueOf(0);
        C_ALMSoftKbn almSoftKbn;
        C_SkeiSoftKbn skeiSoftKbn;
        String nkKaisiNen = "";
        String nknshry = SrCommonConstants.DEFAULT_STRING_ZERO_2;
        String sinsakbn = "";
        String toukeiyousinsakbn = "";
        BizCurrency sbkyuuhukin = BizCurrency.valueOf(0);
        BizDateYM tmttkntaisyouym = null;
        BizCurrency teiritutmttkngk = BizCurrency.valueOf(0);
        BizCurrency sisuurendoutmttkngk = BizCurrency.valueOf(0);
        BizDate ztyhenkouymd = null;
        BizDate tmttkntaisyouymd = null;

        if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyohnZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            hosyoukinoukbn = C_HosyouKinouKbn.BLNK;
            if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                    daiKbn = C_DaiKbn.NNKNTKYK_SISUURENDOU;
                    tyuuKbn = C_TyuuKbn.ENKATEIGAKUNNKN;
                    syouKbn = C_SyouKbn.ENKATEIGAKUNNKN;
                }
                else {
                    daiKbn = C_DaiKbn.KOJINNENKIN_SISUU;
                    tyuuKbn = C_TyuuKbn.SITEITUKANNKN;
                    syouKbn = C_SyouKbn.SITEITUKANNKN;
                }

                if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                    syouKbn = C_SyouKbn.SITEITUKANNKN_20;
                }
            }
            else {
                daiKbn = C_DaiKbn.KOJINNENKIN_SISUU;
                tyuuKbn = C_TyuuKbn.YOTEIRRT_SITEITUKANNKN;
                syouKbn = C_SyouKbn.YOTEIRRT_SITEITUKANNKN;
            }

            almSoftKbn = C_ALMSoftKbn.BLNK;
            skeiSoftKbn = C_SkeiSoftKbn.TANTAI;
            if(pTkJitenKeiyakuSyouhinKijyunBean.getNenkinkkn() == SrCommonConstants.NENKINKIKAN_SOUGAKUHOSYOUSYUUSHIN){

                nknshry = SrCommonConstants.DEFAULT_STRING_ZERO_2;
            }
            else{
                nknshry = pTkJitenKeiyakuSyouhinKijyunBean.getNenkinkkn().toString();
            }
            sinsakbn = SrCommonConstants.SINSAKBN_SONOTA;
            toukeiyousinsakbn = SrCommonConstants.TOUKEIYOUSINSAKBN_MUSENTAKU;

            if (pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getMonth() >= SrCommonConstants.MONTH_APRIL) {

                nkKaisiNen = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getYear());
            }
            else {

                nkKaisiNen = String.valueOf(
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getYear() - SrCommonConstants.YEAR_1Y);
            }

            if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTmttknInfoKijyunYmd) == BizDateUtil.COMPARE_LESSER
                    || BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pTmttknInfoKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {

                    GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu =
                        SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
                    GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean =
                        SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
                    BizNumber suuriyoukaiyakusjktsritu = BizNumber.ZERO;

                    if (C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu())) {

                        suuriyoukaiyakusjktsritu = BizNumber.ZERO;
                    }
                    else{
                        getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                        getSjkkktyouseiyourirituBean.setKijyunymd(pTmttknInfoKijyunYmd);
                        getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
                        getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
                        getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

                        C_ErrorKbn kekkaKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                        if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                            String msg =
                                MessageUtil.getMessage(MessageId.ESA1001, "市場価格調整用利率",pBikinIdouMeisai.getSyono());

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                            suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                            suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                            suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                            errorFlg = true;
                        }

                        else {

                            suuriyoukaiyakusjktsritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                        }
                    }

                    BizDateYM tmpKijunNengetu = null;

                    if (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu())) {
                        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                        tmpKijunNengetu = keisanWKijunYM.exec(
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTmttknInfoKijyunYmd,
                            null,
                            null,
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());
                    }

                    if(C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu()) &&
                        BizDateUtil.calcDifferenceMonths(tmpKijunNengetu,
                            pKhSisuurendoTmttkn.getTmttkntaisyouym()) > SrCommonConstants.KIKAN_12M){

                        int keikanensuWk =  BizDateUtil.calcDifferenceMonths(pTmttknInfoKijyunYmd.getBizDateYM(),
                            pKhSisuurendoTmttkn.getTmttkntaisyouym());
                        int Keikanensuu = keikanensuWk / 12;
                        tmttkntaisyouym = pKhSisuurendoTmttkn.getTmttkntaisyouym().addYears(Keikanensuu);
                        tmttkntaisyouymd = BizDate.valueOf(tmttkntaisyouym, pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();

                        KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd =
                            SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

                        C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                            pBikinIdouMeisai.getTeikishrtkykhukaumu(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                            tmttkntaisyouymd,
                            tmttkntaisyouym,
                            pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                            pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                            pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            String msg =
                                MessageUtil.getMessage(MessageId.ESA1001, "積立金計算：死亡給付金",pBikinIdouMeisai.getSyono());

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                            suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                            suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                            suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                            errorFlg = true;
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

                    if (!errorFlg) {

                        CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

                        C_ErrorKbn kekkaKbn = calcHkShrKngk.exec(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu(),
                            pBikinIdouMeisai.getHrkkaisuu(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKihons(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTmttknInfoKijyunYmd,
                            pBikinIdouMeisai.getSyono(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn(),
                            C_SiinKbn.SP,
                            C_HokenkinsyuruiKbn.SBKYUUHUKIN,
                            pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou(),
                            suuriyoukaiyakusjktsritu,
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
                            pBikinIdouMeisai.getSdpdkbn(),
                            pBikinIdouMeisai.getHrkkeiro());

                        if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                            String msg =
                                MessageUtil.getMessage(MessageId.ESA1001, "死亡給付金",pBikinIdouMeisai.getSyono());

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                            suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                            suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                            suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                            errorFlg = true;
                        }
                        else {

                            sbkyuuhukin = calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk();
                        }
                    }
                }
                else {

                    sbkyuuhukin = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
                }
            }
            else {

                sbkyuuhukin = kihrkmpstgkriroubase;
            }
        }
        else if (pSyohnZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            sibous = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
            hosyoukinoukbn = C_HosyouKinouKbn.SIBOU;
            kihons = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
            almSoftKbn = C_ALMSoftKbn.SYSN;
            skeiSoftKbn = C_SkeiSoftKbn.SONOTA;
            sinsakbn = SrCommonConstants.SINSAKBN_SONOTA;
            toukeiyousinsakbn = SrCommonConstants.TOUKEIYOUSINSAKBN_MUSENTAKU;

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

            sibous = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
            hosyoukinoukbn = C_HosyouKinouKbn.SIBOU;
            daiKbn = C_DaiKbn.SITEITUKASYSN;
            kihons = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
            almSoftKbn = C_ALMSoftKbn.ITIJIBRSYSN;
            skeiSoftKbn = C_SkeiSoftKbn.SONOTA;
            sinsakbn = SrCommonConstants.SINSAKBN_KOKUTI;
            toukeiyousinsakbn = SrCommonConstants.TOUKEIYOUSINSAKBN_KOKUTISYO;

            if(pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19){

                if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                    syouKbn = C_SyouKbn.SITEITUKASYSN_19_2GATA_HNK;
                    sibous = BizCurrency.valueOf(0);
                }
                else {

                    syouKbn = C_SyouKbn.SITEITUKASYSN_19_2GATA;
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

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                tyuuKbn = C_TyuuKbn.YENDATESYSN_HNK;
            }
            else {

                tyuuKbn = C_TyuuKbn.SITEITUKASYSN;
            }
        }

        String todoufukencd =  pBikinIdouMeisai.getDrtenkanritodoufukencd();
        if (C_TodouhukenKbn.BLNK.getValue().equals(todoufukencd)){
            todoufukencd = C_TodouhukenKbn.OSAKA.getValue();
        }

        String kanyujiDatakanriNo = datakanriNo;

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.BOSYU_KEITAI,
            pBikinIdouMeisai.getDrtencd());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                pBikinIdouMeisai.getSyono(), pBikinIdouMeisai.getDrtencd());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
            errorFlg = true;
        }
        else {

            bosyuKeitaiKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_HAITOU,
            bmSyouhnZokusei.getHaitoukbn().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.SUURI_HAITOU.getContent(),
                pBikinIdouMeisai.getSyono(), bmSyouhnZokusei.getHaitoukbn().getContent());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
            errorFlg = true;
        }
        else {

            haitouKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);

        int hhknHkNenrei = setHokenNenrei.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHhknseiymd());

        Integer hhknnen = pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen();

        String hhknnentysihyj = "";
        if (hhknHkNenrei != hhknnen) {

            hhknnentysihyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            hhknnentysihyj = SrCommonConstants.HYOUJI_NASI;
        }

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
        int kykNenTyouseigo;

        int kyknen = setNenrei.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pBikinIdouMeisai.getKykseiymd());

        if(kyknen > 99) {
            kykNenTyouseigo = 0;
        }
        else {
            kykNenTyouseigo = kyknen;
        }

        String kyksyanentysihyj = "";
        int kykHkNenrei = setHokenNenrei.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pBikinIdouMeisai.getKykseiymd());

        if (kyknen != kykHkNenrei) {

            kyksyanentysihyj = SrCommonConstants.HYOUJI_ARI;

        }
        else {
            kyksyanentysihyj = SrCommonConstants.HYOUJI_NASI;
        }

        String saimanki = "";

        if (C_HknkknsmnKbn.SAIMANKI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn())) {

            saimanki = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            saimanki = SrCommonConstants.HYOUJI_NASI;
        }

        BizCurrency keyKykP = BizCurrency.valueOf(0);

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {
            keyKykP = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
        }


        String nkGataKbn = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.NENKINGATA,
            pTkJitenKeiyakuSyouhinKijyunBean.getNksyukbn().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.NENKINGATA.getContent(),
                pBikinIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getNksyukbn().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
            errorFlg = true;
        }
        else {

            nkGataKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String haraikataKbn = "";
        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
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

        String annaiFuyouRiyuuKbn = "";
        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            annaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ITIJI.getValue();
        }
        else {
            annaiFuyouRiyuuKbn = C_SuuriAnnaiFuyouRiyuuKbn.ANNAITYUU.getValue();
        }

        String haraikomiKaisuKbn = "";
        C_Hrkkaisuu wkHrkkaisuu = hrkkaisuu;

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            wkHrkkaisuu = pBikinIdouMeisai.getHrkkaisuu();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.HRK_KAISUU,
            wkHrkkaisuu.getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KAISUU.getContent(),
                pBikinIdouMeisai.getSyono(), wkHrkkaisuu.getValue());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrBikinIdouMeisaiBatchParam, pBikinIdouMeisai, msg);
        }
        else {

            haraikomiKaisuKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        String hrkkeiroKbn = "";
        String hrkKeiro = "";

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            hrkKeiro = pBikinIdouMeisai.getHrkkeiro().toString();
        }
        else {
            hrkKeiro = hrkkeiro.toString();
        }

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.HRK_KEIRO, hrkKeiro);

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.HRK_KEIRO.getContent(),
                pBikinIdouMeisai.getSyono(), hrkKeiro);

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrBikinIdouMeisaiBatchParam, pBikinIdouMeisai, msg);
        }
        else {

            hrkkeiroKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
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

        C_SuuriPWaribikitekiyouKbn syukeiyakupWaribikiKbn;

        if (pSyohnZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            if (pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().compareTo(BizCurrency.valueOf(SrCommonConstants.YEN_15000,
                pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().getType())) < 0) {
                syukeiyakupWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_NONE;
            }
            else if (pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().compareTo(BizCurrency.valueOf(SrCommonConstants.YEN_30000,
                pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().getType())) < 0) {
                syukeiyakupWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_RANK01;
            }
            else {
                syukeiyakupWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_RANK02;
            }
        }
        else {
            syukeiyakupWaribikiKbn = C_SuuriPWaribikitekiyouKbn.PWARISEIDO_NONE;
        }

        String kykjyoutai = "";

        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.KYK_JYOUTAI,
            pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002, C_SrKbnHenkanKbn.KYK_JYOUTAI.getContent(),
                pBikinIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai().getValue());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrBikinIdouMeisaiBatchParam, pBikinIdouMeisai, msg);
        }
        else {

            kykjyoutai = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null
            && pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() != null) {

            ztyhenkouymd = pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd();
        }
        else {
            ztyhenkouymd = pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd();
        }

        String anniskcd = "";

        if (!C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {

            if (C_Hrkkeiro.CREDIT.eq(hrkkeiro)) {

                anniskcd = SrCommonConstants.ANNISKCD_CREDITHR;
            }
        }

        pZtBikinIdouMeisaiTy.setZtyrecordkbn(SrCommonConstants.RECORDKBN_IDOUMEISAI);
        pZtBikinIdouMeisaiTy.setZtyidourecordkbn(ztyidourecordkbn);
        pZtBikinIdouMeisaiTy.setZtykeijyouctrlkbn(SrCommonConstants.KIJYCTRLKBN_BIKINIDOU);
        pZtBikinIdouMeisaiTy.setZtyhenkousyoriymd(ztyhenkousyoriymd);
        pZtBikinIdouMeisaiTy.setZtykykmfksnctr(Integer.valueOf(keiyakuMFkoushinCTR));
        pZtBikinIdouMeisaiTy.setZtyrecordctr(recordctr);
        pZtBikinIdouMeisaiTy.setZtysuuriyoukouryokukaisiymd(ztysuuriyoukouryokukaisiymd.getRekijyou().toString());
        pZtBikinIdouMeisaiTy.setZtydenymd(ztydenymd);
        pZtBikinIdouMeisaiTy.setZtytoukeikeijyoukbn(toukeikijyKbn);
        pZtBikinIdouMeisaiTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pZtBikinIdouMeisaiTy.setZtybsyym(pBikinIdouMeisai.getBosyuuym().toString());
        pZtBikinIdouMeisaiTy.setZtyidoujiyuucd(ztyidoujiyuucd);
        pZtBikinIdouMeisaiTy.setZtysyoricd(syoricd);
        pZtBikinIdouMeisaiTy.setZtysihankibikinkbn(shihankibikinKbn);
        pZtBikinIdouMeisaiTy.setZtydatakanrino(datakanriNo);
        pZtBikinIdouMeisaiTy.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        pZtBikinIdouMeisaiTy.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
        pZtBikinIdouMeisaiTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
        pZtBikinIdouMeisaiTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pZtBikinIdouMeisaiTy.setZtystdssnskbn(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
        pZtBikinIdouMeisaiTy.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
        pZtBikinIdouMeisaiTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
        pZtBikinIdouMeisaiTy.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
        pZtBikinIdouMeisaiTy.setZtykbnkeiriyousegmentkbn(kbnKeiriyouSegmentKbn);
        pZtBikinIdouMeisaiTy.setZtykbnkeiriyourgnbnskkbn(kbnKeiriyouRgnbnskKbn);
        pZtBikinIdouMeisaiTy.setZtysuurisyuruicd(suuriSyuruiCd);
        pZtBikinIdouMeisaiTy.setZtyhosyoukinoukbn(hosyoukinoukbn.getValue());
        pZtBikinIdouMeisaiTy.setZtydaikbn(daiKbn.getValue());
        pZtBikinIdouMeisaiTy.setZtytyuukbn(tyuuKbn.getValue());
        pZtBikinIdouMeisaiTy.setZtysyoukbn(syouKbn.getValue());
        pZtBikinIdouMeisaiTy.setZtysedaikbn(sedaiKbn);
        pZtBikinIdouMeisaiTy.setZtyharaikatakbn(haraikataKbn);
        pZtBikinIdouMeisaiTy.setZtykykymd(pTkJitenKeiyakuSyouhinKijyunBean.
            getKykymd().toString());
        pZtBikinIdouMeisaiTy.setZtyhknkkn(pTkJitenKeiyakuSyouhinKijyunBean.
            getHknkkn().toString());
        pZtBikinIdouMeisaiTy.setZtyphrkkikn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn().toString());
        pZtBikinIdouMeisaiTy.setZtysaimnkkykhyj(saimanki);
        pZtBikinIdouMeisaiTy.setZtyannaifuyouriyuukbn(annaiFuyouRiyuuKbn);
        pZtBikinIdouMeisaiTy.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
        pZtBikinIdouMeisaiTy.setZtyhrkkaisuukbn(haraikomiKaisuKbn);
        pZtBikinIdouMeisaiTy.setZtyhrkkeirokbn(hrkkeiroKbn);
        pZtBikinIdouMeisaiTy.setZtysdpdkbn(pBikinIdouMeisai.getSdpdkbn().getValue());
        pZtBikinIdouMeisaiTy.setZtyryouritukbn(ryourituKbn);
        pZtBikinIdouMeisaiTy.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.
            getHhknsei().getValue());
        pZtBikinIdouMeisaiTy.setZtyhihokensyaagev2(pTkJitenKeiyakuSyouhinKijyunBean.
            getHhknnen().toString());
        pZtBikinIdouMeisaiTy.setZtykyksyanen(String.valueOf(kykNenTyouseigo));
        pZtBikinIdouMeisaiTy.setZtytkbthsyumnryuhyouji(SrCommonConstants.HYOUJI_NASI);
        pZtBikinIdouMeisaiTy.setZtysyukeiyakupwaribikikbn(syukeiyakupWaribikiKbn.getValue());
        pZtBikinIdouMeisaiTy.setZtytenkanwaribikikbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZtBikinIdouMeisaiTy.setZtyyuuhitutnknyuguryurtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZtBikinIdouMeisaiTy.setZtysyukeiyakup(new BigDecimal(keyKykP.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtykihons(new BigDecimal(kihons.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtysibous(new BigDecimal(sibous.toAdsoluteString()).longValue());
        if (ztyhenkouymd != null) {
            pZtBikinIdouMeisaiTy.setZtyhenkouymd(String.valueOf(ztyhenkouymd));
        }
        pZtBikinIdouMeisaiTy.setZtyatukaisisyatodouhukencd(todoufukencd);
        pZtBikinIdouMeisaiTy.setZtytokuyakuhukasuu(SrCommonConstants.DEFAULT_INT_ZERO);
        pZtBikinIdouMeisaiTy.setZtyhrimnentyoumaephrkkkn(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pZtBikinIdouMeisaiTy.setZtytokubetuhosyoukikan(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pZtBikinIdouMeisaiTy.setZtykousinmanryouage(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pZtBikinIdouMeisaiTy.setZtykanyujidatakanrino(kanyujiDatakanriNo);
        pZtBikinIdouMeisaiTy.setZtykanyujikykymd(pTkJitenKeiyakuSyouhinKijyunBean.
            getKykymd().toString());
        pZtBikinIdouMeisaiTy.setZtykanyuujihihokensyaage(pTkJitenKeiyakuSyouhinKijyunBean.
            getHhknnen().toString());
        pZtBikinIdouMeisaiTy.setZtykykjyoutai(kykjyoutai);
        pZtBikinIdouMeisaiTy.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
        pZtBikinIdouMeisaiTy.setZtysykykhokenhoutekiyouhyj(SrCommonConstants.HYOUJI_ARI);
        pZtBikinIdouMeisaiTy.setZtyalmyousohutomeisyoukbn(almSoftKbn.getValue());
        pZtBikinIdouMeisaiTy.setZtysnkyksoftmeisyoukbn(skeiSoftKbn.getValue());
        pZtBikinIdouMeisaiTy.setZtynenkinkaisinendo(nkKaisiNen);
        pZtBikinIdouMeisaiTy.setZtynenkingatakbn(nkGataKbn);
        pZtBikinIdouMeisaiTy.setZtynknshry(nknshry);
        pZtBikinIdouMeisaiTy.setZtysiktsyuknbyugnhsyunshyj(SrCommonConstants.HYOUJI_NASI);
        pZtBikinIdouMeisaiTy.setZtypmensugugtganhsyunshyj(SrCommonConstants.HYOUJI_NASI);
        pZtBikinIdouMeisaiTy.setZtytkykgyousekihyjszerohyj(SrCommonConstants.HYOUJI_NASI);
        pZtBikinIdouMeisaiTy.setZtybosyuukeitaikbn(bosyuKeitaiKbn);
        pZtBikinIdouMeisaiTy.setZtyaatukaisosikicd(pBikinIdouMeisai.getDrtenkanrisosikicd());
        pZtBikinIdouMeisaiTy.setZtyaatukaikojincd(pBikinIdouMeisai.getDaibosyuucd());
        pZtBikinIdouMeisaiTy.setZtybsydrtencd(pBikinIdouMeisai.getDrtencd());
        pZtBikinIdouMeisaiTy.setZtycifcd(pBikinIdouMeisai.getCifcd());
        pZtBikinIdouMeisaiTy.setZtysinsakbn(sinsakbn);
        pZtBikinIdouMeisaiTy.setZtytoukeiyousinsakbn(toukeiyousinsakbn);
        pZtBikinIdouMeisaiTy.setZtyketteikijyunkanwakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZtBikinIdouMeisaiTy.setZtysykgycd(pBikinIdouMeisai.getHhknsykgycd());
        pZtBikinIdouMeisaiTy.setZtyanniskcd(anniskcd);
        pZtBikinIdouMeisaiTy.setZtydakuhikettikekkacd(pBikinIdouMeisai.getKetkekkacd().getValue());
        pZtBikinIdouMeisaiTy.setZtysiboukyuuhukin(new BigDecimal(sbkyuuhukin.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtyhaitoukbn(haitouKbn);
        pZtBikinIdouMeisaiTy.setZtyhhknnentysihyj(hhknnentysihyj);
        pZtBikinIdouMeisaiTy.setZtykyksyaagetyouseihyj(kyksyanentysihyj);
        pZtBikinIdouMeisaiTy.setZtykituenkbn(SrCommonConstants.KITUENKBN_HUMEI);
        pZtBikinIdouMeisaiTy.setZtymusentakukeiyakukbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZtBikinIdouMeisaiTy.setZtydakuhikettisyacd(pBikinIdouMeisai.getPalketsyacd());
        pZtBikinIdouMeisaiTy.setZtytargetmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        pZtBikinIdouMeisaiTy.setZtyautoswitchmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        pZtBikinIdouMeisaiTy.setZtytumitatekinitenarihyj(SrCommonConstants.HYOUJI_NASI);
        pZtBikinIdouMeisaiTy.setZtytumitatekinitenkaisuu(SrCommonConstants.DEFAULT_STRING_ZERO_3);

        if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {

            pIdouMeisaiTyukeiyouItzHzn.setZtyrecordkbn(SrCommonConstants.RECORDKBN_IDOUMEISAI);
            pIdouMeisaiTyukeiyouItzHzn.setZtyidourecordkbn(ztyidourecordkbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtykeijyouctrlkbn(SrCommonConstants.KIJYCTRLKBN_BIKINIDOU);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhenkousyoriymd(ztyhenkousyoriymd);
            pIdouMeisaiTyukeiyouItzHzn.setZtykykmfksnctr(Integer.valueOf(keiyakuMFkoushinCTR));
            pIdouMeisaiTyukeiyouItzHzn.setZtyrecordctr(recordctr);
            pIdouMeisaiTyukeiyouItzHzn.setZtysuuriyoukouryokukaisiymd(ztysuuriyoukouryokukaisiymd.getRekijyou().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtydenymd(ztydenymd);
            pIdouMeisaiTyukeiyouItzHzn.setZtytoukeikeijyoukbn(toukeikijyKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
            pIdouMeisaiTyukeiyouItzHzn.setZtybsyym(pBikinIdouMeisai.getBosyuuym().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtyidoujiyuucd(ztyidoujiyuucd);
            pIdouMeisaiTyukeiyouItzHzn.setZtysyoricd(syoricd);
            pIdouMeisaiTyukeiyouItzHzn.setZtysihankibikinkbn(shihankibikinKbn);
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
            pIdouMeisaiTyukeiyouItzHzn.setZtyhosyoukinoukbn(hosyoukinoukbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtydaikbn(daiKbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtytyuukbn(tyuuKbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysyoukbn(syouKbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysedaikbn(sedaiKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyharaikatakbn(haraikataKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtykykymd(pTkJitenKeiyakuSyouhinKijyunBean.
                getKykymd().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtyhknkkn(pTkJitenKeiyakuSyouhinKijyunBean.
                getHknkkn().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtyphrkkikn(pTkJitenKeiyakuSyouhinKijyunBean.getHrkkkn().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtysaimnkkykhyj(saimanki);
            pIdouMeisaiTyukeiyouItzHzn.setZtyannaifuyouriyuukbn(annaiFuyouRiyuuKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhrkkaisuukbn(haraikomiKaisuKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhrkkeirokbn(hrkkeiroKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtysdpdkbn(pBikinIdouMeisai.getSdpdkbn().getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyryouritukbn(ryourituKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.
                getHhknsei().getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyhihokensyaagev2(pTkJitenKeiyakuSyouhinKijyunBean.
                getHhknnen().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtykyksyanen(String.valueOf(kykNenTyouseigo));
            pIdouMeisaiTyukeiyouItzHzn.setZtytkbthsyumnryuhyouji(SrCommonConstants.HYOUJI_NASI);
            pIdouMeisaiTyukeiyouItzHzn.setZtysyukeiyakupwaribikikbn(syukeiyakupWaribikiKbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtytenkanwaribikikbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pIdouMeisaiTyukeiyouItzHzn.setZtyyuuhitutnknyuguryurtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pIdouMeisaiTyukeiyouItzHzn.setZtysyukeiyakup(new BigDecimal(keyKykP.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtykihons(new BigDecimal(kihons.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysibous(new BigDecimal(sibous.toAdsoluteString()).longValue());
            if (ztyhenkouymd != null) {
                pIdouMeisaiTyukeiyouItzHzn.setZtyhenkouymd(String.valueOf(ztyhenkouymd));
            }
            pIdouMeisaiTyukeiyouItzHzn.setZtyatukaisisyatodouhukencd(todoufukencd);
            pIdouMeisaiTyukeiyouItzHzn.setZtytokuyakuhukasuu(SrCommonConstants.DEFAULT_INT_ZERO);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhrimnentyoumaephrkkkn(SrCommonConstants.DEFAULT_STRING_ZERO_2);
            pIdouMeisaiTyukeiyouItzHzn.setZtytokubetuhosyoukikan(SrCommonConstants.DEFAULT_STRING_ZERO_2);
            pIdouMeisaiTyukeiyouItzHzn.setZtykousinmanryouage(SrCommonConstants.DEFAULT_STRING_ZERO_2);
            pIdouMeisaiTyukeiyouItzHzn.setZtykanyujidatakanrino(kanyujiDatakanriNo);
            pIdouMeisaiTyukeiyouItzHzn.setZtykanyujikykymd(pTkJitenKeiyakuSyouhinKijyunBean.
                getKykymd().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtykanyuujihihokensyaage(pTkJitenKeiyakuSyouhinKijyunBean.
                getHhknnen().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtykykjyoutai(kykjyoutai);
            pIdouMeisaiTyukeiyouItzHzn.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
            pIdouMeisaiTyukeiyouItzHzn.setZtysykykhokenhoutekiyouhyj(SrCommonConstants.HYOUJI_ARI);
            pIdouMeisaiTyukeiyouItzHzn.setZtyalmyousohutomeisyoukbn(almSoftKbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysnkyksoftmeisyoukbn(skeiSoftKbn.getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtynenkinkaisinendo(nkKaisiNen);
            pIdouMeisaiTyukeiyouItzHzn.setZtynenkingatakbn(nkGataKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtynknshry(nknshry);
            pIdouMeisaiTyukeiyouItzHzn.setZtysiktsyuknbyugnhsyunshyj(SrCommonConstants.HYOUJI_NASI);
            pIdouMeisaiTyukeiyouItzHzn.setZtypmensugugtganhsyunshyj(SrCommonConstants.HYOUJI_NASI);
            pIdouMeisaiTyukeiyouItzHzn.setZtytkykgyousekihyjszerohyj(SrCommonConstants.HYOUJI_NASI);
            pIdouMeisaiTyukeiyouItzHzn.setZtybosyuukeitaikbn(bosyuKeitaiKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyaatukaisosikicd(pBikinIdouMeisai.getDrtenkanrisosikicd());
            pIdouMeisaiTyukeiyouItzHzn.setZtyaatukaikojincd(pBikinIdouMeisai.getDaibosyuucd());
            pIdouMeisaiTyukeiyouItzHzn.setZtybsydrtencd(pBikinIdouMeisai.getDrtencd());
            pIdouMeisaiTyukeiyouItzHzn.setZtycifcd(pBikinIdouMeisai.getCifcd());
            pIdouMeisaiTyukeiyouItzHzn.setZtysinsakbn(sinsakbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtytoukeiyousinsakbn(toukeiyousinsakbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyketteikijyunkanwakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pIdouMeisaiTyukeiyouItzHzn.setZtysykgycd(pBikinIdouMeisai.getHhknsykgycd());
            pIdouMeisaiTyukeiyouItzHzn.setZtyanniskcd(anniskcd);
            pIdouMeisaiTyukeiyouItzHzn.setZtydakuhikettikekkacd(pBikinIdouMeisai.getKetkekkacd().getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysiboukyuuhukin(new BigDecimal(sbkyuuhukin.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyhaitoukbn(haitouKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhhknnentysihyj(hhknnentysihyj);
            pIdouMeisaiTyukeiyouItzHzn.setZtykyksyaagetyouseihyj(kyksyanentysihyj);
            pIdouMeisaiTyukeiyouItzHzn.setZtykituenkbn(SrCommonConstants.KITUENKBN_HUMEI);
            pIdouMeisaiTyukeiyouItzHzn.setZtymusentakukeiyakukbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pIdouMeisaiTyukeiyouItzHzn.setZtydakuhikettisyacd(pBikinIdouMeisai.getPalketsyacd());
            pIdouMeisaiTyukeiyouItzHzn.setZtytargetmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
            pIdouMeisaiTyukeiyouItzHzn.setZtyautoswitchmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
            pIdouMeisaiTyukeiyouItzHzn.setZtytumitatekinitenarihyj(SrCommonConstants.HYOUJI_NASI);
            pIdouMeisaiTyukeiyouItzHzn.setZtytumitatekinitenkaisuu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        }
    }

    private void editAlmData(SrBikinIdouMeisaiBatchParam pSrBikinIdouMeisaiBatchParam,
        SV_BikinIdouMeisai pBikinIdouMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        C_IdouRecordKbn pIdouRecordKbn,
        BizDate pKouryokuhasseiymd,
        ZT_BikinIdouMeisaiTy pZtBikinIdouMeisaiTy,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn,
        int pSyohnZokusei,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn) {

        String kyKhhknDouhyouji = "";
        if (C_Tdk.HONNIN.eq(pBikinIdouMeisai.getKkkyktdk())) {

            kyKhhknDouhyouji = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            kyKhhknDouhyouji = SrCommonConstants.HYOUJI_NASI;
        }

        String tantousyaJyoutaiKbn = "";
        String hoyuuSisyaCd2 = "";
        if (C_UmuKbn.NONE.eq(pBikinIdouMeisai.getDrtenbunumu())) {

            tantousyaJyoutaiKbn = SrCommonConstants.TANTOUSYAJYOUTAIKBN_ATUKAISYA1ZAISEKI;

            hoyuuSisyaCd2 = "0";
        }
        else if(C_UmuKbn.ARI.eq(pBikinIdouMeisai.getDrtenbunumu())) {

            tantousyaJyoutaiKbn = SrCommonConstants.TANTOUSYAJYOUTAIKBN_ATUKAISYA2ZAISEKI;

            SrBikinIdouMeisaiBatchDbAccess srBikinIdouMeisaiBatchDbAccess =
                SWAKInjector.getInstance(SrBikinIdouMeisaiBatchDbAccess.class);

            KykDairitenByPkBean pKykDairitenByPkBean = srBikinIdouMeisaiBatchDbAccess.
                getKykDairitenByPk(pBikinIdouMeisai.getSyono(), 2);
            hoyuuSisyaCd2 = pKykDairitenByPkBean.getDrtenkanrisosikicd().substring(0, 3);
        }

        KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd =
            SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);
        BizCurrency totalKihons = BizCurrency.valueOf(0);
        BizCurrency totalGskhjSbs = BizCurrency.valueOf(0);
        BizCurrency almSibous = BizCurrency.valueOf(0);

        if (pSyohnZokusei != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR &&
            pSyohnZokusei != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            totalKihons = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
        }

        if ((pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20)
            && pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {

            C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                pBikinIdouMeisai.getTeikishrtkykhukaumu(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getBizDateYM(),
                pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001, "合計業績表示死亡Ｓ、ＡＬＭ用死亡Ｓ",
                    pBikinIdouMeisai.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                errorFlg = true;
            }
            else {

                totalGskhjSbs = keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei();
                almSibous = keisanSisuuRendouNkTmttknOverNnd.getTmttkngkkei();
            }
        }
        else if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR
            && pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
            KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk = SWAKInjector
                .getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

            BizDateYM kisnKijyunymAtoYm =
                keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
                    null,null,pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

            BizDateYM YendthnkymAtoYm =
                keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                    null,null,pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), null);

            C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknYendtHnk.exec(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
                kisnKijyunymAtoYm,
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                YendthnkymAtoYm,
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKihons(),
                pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001, "合計業績表示死亡Ｓ、ＡＬＭ用死亡Ｓ",
                    pBikinIdouMeisai.getSyono());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                errorFlg = true;
            }
            else {
                totalGskhjSbs = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
                almSibous = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
                nkgns = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
            }
        }
        else if (pSyohnZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            totalGskhjSbs = BizCurrency.valueOf(0);
            almSibous = BizCurrency.valueOf(0);
        }
        else {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                    totalGskhjSbs = BizCurrency.valueOf(0);
                    almSibous = BizCurrency.valueOf(0);
                }
                else {

                    totalGskhjSbs = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                    almSibous = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
                }
            }
            else {

                almSibous = pTkJitenKeiyakuSyouhinKijyunBean.getKihons();
            }
        }

        BizCurrency shrP = BizCurrency.valueOf(0);

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {

            shrP = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
        }

        String zennouKaisiYmd = "";
        String zennouKikan = "";

        if (C_Kykjyoutai.ZENNOU.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            zennouKaisiYmd = pBikinIdouMeisai.getZennoukaisiymd().toString();
            zennouKikan = pBikinIdouMeisai.getZennoukikan();
        }

        BizDateYM jkipjytYm = jkipjytym;

        BizNumber kihonyoteii = BizNumber.ZERO;

        if (pSyohnZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            kihonyoteii = yoteiriritujtnyknbase.multiply(SrCommonConstants.INT_VALUE_100).multiply(SrCommonConstants.INT_VALUE_1000);
        }
        else if (pSyohnZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
            kihonyoteii = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu().multiply(SrCommonConstants.INT_VALUE_100)
                .multiply(SrCommonConstants.INT_VALUE_1000);
        }

        BizNumber itijibaraikihonyoteii = BizNumber.ZERO;

        if (C_Kykjyoutai.ITIJIBARAI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai())) {
            itijibaraikihonyoteii = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu().multiply(
                SrCommonConstants.INT_VALUE_100).multiply(SrCommonConstants.INT_VALUE_1000);
        }

        BizNumber saiteihosyoui = BizNumber.ZERO;

        if (pSyohnZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            saiteihosyoui = pTkJitenKeiyakuSyouhinKijyunBean.getYoteirrthendohosyurrt().multiply(
                SrCommonConstants.INT_VALUE_100).multiply(SrCommonConstants.INT_VALUE_1000);
        }

        String tikiKktbriJyututksu = "0";

        if (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.getValue().equals(tikikktbrijyututksu) ||
            C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.getValue().equals(tikikktbrijyututksu)) {
            tikiKktbriJyututksu = tikikktbrijyututksu;
        }

        SrGetTokutejitenTokuyakuInfo srGetTokutejitenTokuyakuInfo =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfo.class);
        String hhkdrtkykariHyj = "";

        if (C_IdouRecordKbn.MINUSRECORD.eq(pIdouRecordKbn)) {

            hhkdrtkykariHyj = srGetTokutejitenTokuyakuInfo.execHhkDirTkyk(
                C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET,
                null,
                pBikinIdouMeisai.getSyono(),
                pBikinIdouMeisai.getHenkousikibetukey(),
                pKouryokuhasseiymd,
                pBikinIdouMeisai.getStdrsktkyhkumu(),
                pBikinIdouMeisai.getStdrsktkyhkymd());

            hhkdrtkykarihyjPlusrecord = hhkdrtkykariHyj;
        }
        else if (C_IdouRecordKbn.PLUSRECORD.eq(pIdouRecordKbn)) {

            hhkdrtkykariHyj = hhkdrtkykarihyjPlusrecord;

        }
        else {

            if (C_UmuKbn.ARI.eq(pBikinIdouMeisai.getStdrsktkyhkumu())) {

                hhkdrtkykariHyj = SrCommonConstants.HYOUJI_ARI;
            }
            else {
                hhkdrtkykariHyj = SrCommonConstants.HYOUJI_NASI;
            }
        }

        String kykdrtkykariHyj = "";

        if (C_IdouRecordKbn.MINUSRECORD.eq(pIdouRecordKbn)) {

            kykdrtkykariHyj = srGetTokutejitenTokuyakuInfo.execKykDirTkyk(
                C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET,
                null,
                pBikinIdouMeisai.getSyono(),
                pBikinIdouMeisai.getHenkousikibetukey(),
                pKouryokuhasseiymd,
                pBikinIdouMeisai.getKykdrtkykhukaumu(),
                pBikinIdouMeisai.getKykdrtkykhukaymd(),
                pBikinIdouMeisai.getKykdrtkykkaiyakuymd());

            kykdrtkykarihyjPlusrecord = kykdrtkykariHyj;
        }
        else if (C_IdouRecordKbn.PLUSRECORD.eq(pIdouRecordKbn)) {

            kykdrtkykariHyj = kykdrtkykarihyjPlusrecord;
        }
        else {

            if (C_UmuKbn.ARI.eq(pBikinIdouMeisai.getKykdrtkykhukaumu())) {

                kykdrtkykariHyj = SrCommonConstants.HYOUJI_ARI;
            }
            else {

                kykdrtkykariHyj = SrCommonConstants.HYOUJI_NASI;
            }
        }

        pZtBikinIdouMeisaiTy.setZtykyksyhhknsydouituhyouji(kyKhhknDouhyouji);
        pZtBikinIdouMeisaiTy.setZtykyksyaskinmeino(pBikinIdouMeisai.getKyksakuinmeino());
        pZtBikinIdouMeisaiTy.setZtygoukeikihons(new BigDecimal(totalKihons.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtygoukeigyousekihyjsibous(new BigDecimal(totalGskhjSbs.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtyalmyousibous(new BigDecimal(almSibous.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtyharaikomip(new BigDecimal(shrP.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtyzennoukaisiymd(zennouKaisiYmd);
        pZtBikinIdouMeisaiTy.setZtyzennoukikan(zennouKikan);
        if (jkipjytYm == null) {
            pZtBikinIdouMeisaiTy.setZtyjikaipjyuutouym("");
        }
        else {
            pZtBikinIdouMeisaiTy.setZtyjikaipjyuutouym(jkipjytYm.toString());
        }

        pZtBikinIdouMeisaiTy.setZtytouduketorihouhoukbn(pBikinIdouMeisai.getHaitoukinuketorihoukbn().getValue());
        pZtBikinIdouMeisaiTy.setZtyaatukaisyakeisyousisyacd(pBikinIdouMeisai.getDrtenkanrisosikicd().substring(0, 3));
        pZtBikinIdouMeisaiTy.setZtyaatukaisyazaisekihyouji(SrCommonConstants.AATUKAISYAZAISEKIHYUOJI_ZAISEKI);
        pZtBikinIdouMeisaiTy.setZtyhoyuusisyacd(pBikinIdouMeisai.getDrtenkanrisosikicd().substring(0, 3));
        pZtBikinIdouMeisaiTy.setZtytantousyakbn(SrCommonConstants.TANTOUSYAKBN_SAISINATUKAISYA);
        pZtBikinIdouMeisaiTy.setZtytantousyakbnnew(SrCommonConstants.TANTOUSYAKBNNEW_ZAISEKI);
        pZtBikinIdouMeisaiTy.setZtytantousyajyoutaikbn(tantousyaJyoutaiKbn);
        pZtBikinIdouMeisaiTy.setZtykihonyoteii(kihonyoteii.toString());
        pZtBikinIdouMeisaiTy.setZtyitijibaraikihonyoteii(itijibaraikihonyoteii.toString());
        pZtBikinIdouMeisaiTy.setZtysaiteihosyoui(saiteihosyoui.toString());
        pZtBikinIdouMeisaiTy.setZtyhoyuusisyacd2(hoyuuSisyaCd2);
        pZtBikinIdouMeisaiTy.setZtytikikktbrijyututksu(tikiKktbriJyututksu);
        pZtBikinIdouMeisaiTy.setZtysyunyumrtikykjtigngtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZtBikinIdouMeisaiTy.setZtyhhkdrtkykarihyj(hhkdrtkykariHyj);
        pZtBikinIdouMeisaiTy.setZtykykdrtkykarihyj(kykdrtkykariHyj);
        pZtBikinIdouMeisaiTy.setZtypmenkouryokuhasseiymd(SrCommonConstants.DEFAULT_STRING_ZERO_8);

        if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {

            pIdouMeisaiTyukeiyouItzHzn.setZtykyksyhhknsydouituhyouji(kyKhhknDouhyouji);
            pIdouMeisaiTyukeiyouItzHzn.setZtykyksyaskinmeino(pBikinIdouMeisai.getKyksakuinmeino());
            pIdouMeisaiTyukeiyouItzHzn.setZtygoukeikihons(new BigDecimal(totalKihons.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtygoukeigyousekihyjsibous(new BigDecimal(totalGskhjSbs.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyalmyousibous(new BigDecimal(almSibous.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyharaikomip(new BigDecimal(shrP.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyzennoukaisiymd(zennouKaisiYmd.toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtyzennoukikan(zennouKikan);
            if (jkipjytYm == null) {
                pIdouMeisaiTyukeiyouItzHzn.setZtyjikaipjyuutouym("");
            }
            else {
                pIdouMeisaiTyukeiyouItzHzn.setZtyjikaipjyuutouym(jkipjytYm.toString());
            }
            pIdouMeisaiTyukeiyouItzHzn.setZtytouduketorihouhoukbn(pBikinIdouMeisai.getHaitoukinuketorihoukbn().getValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyaatukaisyakeisyousisyacd(pBikinIdouMeisai.getDrtenkanrisosikicd().substring(0, 3));
            pIdouMeisaiTyukeiyouItzHzn.setZtyaatukaisyazaisekihyouji(SrCommonConstants.AATUKAISYAZAISEKIHYUOJI_ZAISEKI);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhoyuusisyacd(pBikinIdouMeisai.getDrtenkanrisosikicd().substring(0, 3));
            pIdouMeisaiTyukeiyouItzHzn.setZtytantousyakbn(SrCommonConstants.TANTOUSYAKBN_SAISINATUKAISYA);
            pIdouMeisaiTyukeiyouItzHzn.setZtytantousyakbnnew(SrCommonConstants.TANTOUSYAKBNNEW_ZAISEKI);
            pIdouMeisaiTyukeiyouItzHzn.setZtytantousyajyoutaikbn(tantousyaJyoutaiKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtykihonyoteii(kihonyoteii.toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtyitijibaraikihonyoteii(itijibaraikihonyoteii.toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtysaiteihosyoui(saiteihosyoui.toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtyhoyuusisyacd2(hoyuuSisyaCd2);
            pIdouMeisaiTyukeiyouItzHzn.setZtytikikktbrijyututksu(tikiKktbriJyututksu);
            pIdouMeisaiTyukeiyouItzHzn.setZtysyunyumrtikykjtigngtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pIdouMeisaiTyukeiyouItzHzn.setZtyhhkdrtkykarihyj(hhkdrtkykariHyj);
            pIdouMeisaiTyukeiyouItzHzn.setZtykykdrtkykarihyj(kykdrtkykariHyj);
            pIdouMeisaiTyukeiyouItzHzn.setZtypmenkouryokuhasseiymd(SrCommonConstants.DEFAULT_STRING_ZERO_8);
        }
    }

    private void editHeaderData(SrBikinIdouMeisaiBatchParam pSrBikinIdouMeisaiBatchParam,
        ZT_BikinIdouMeisaiTy pZtBikinIdouMeisaiTy,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn,
        int pSyohnZokusei,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean) {

        Integer key = pSrBikinIdouMeisaiBatchParam.getShiKensu();
        pSrBikinIdouMeisaiBatchParam.setShiKensu(pSrBikinIdouMeisaiBatchParam.getShiKensu() + 1);

        YuyuSuuriConfig yuyuSuuriConfig = YuyuSuuriConfig.getInstance();

        Integer rdwAreaLength = yuyuSuuriConfig.getPalrdwarealength();

        Integer commonLength = yuyuSuuriConfig.getPalprre601length();

        Integer AlmLength = yuyuSuuriConfig.getPalprre603length();

        Integer tkLength = yuyuSuuriConfig.getPalprre602length();

        Integer rayLength = yuyuSuuriConfig.getPalprre850length();

        Integer yuukourecordLength = rdwAreaLength + commonLength + AlmLength + rayLength +
            tkLength * pZtBikinIdouMeisaiTy.getZtytokuyakuhukasuu();

        pZtBikinIdouMeisaiTy.setZtysequenceno(key);
        pZtBikinIdouMeisaiTy.setZtyyuukourecordlength(yuukourecordLength);

        if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {

            pIdouMeisaiTyukeiyouItzHzn.setZtysequenceno(key);
            pIdouMeisaiTyukeiyouItzHzn.setZtyyuukourecordlength(yuukourecordLength);
        }
    }

    private void editRayData(SrBikinIdouMeisaiBatchParam pSrBikinIdouMeisaiBatchParam,
        SV_BikinIdouMeisai pBikinIdouMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        C_IdouRecordKbn pIdouRecordKbn,
        ZT_BikinIdouMeisaiTy pZtBikinIdouMeisaiTy,
        BizDate pKouryokuhasseiymd,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn,
        int pSyohnZokusei,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn,
        BizDate pTmttknInfoKijyunYmd,
        List<SV_KiykSyuhnData> pKiykSyuhnDataList,
        List<IT_KykSyouhnHnkmae>pKykSyouhnHnkmaeList) {

        BizDate keisanDate = null;
        if (!C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu()) ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {
            keisanDate = pBikinIdouMeisai.getCalckijyunymd();
        }

        String gaikaKbn = "";
        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pBikinIdouMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
            errorFlg = true;
        }
        else {
            gaikaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }


        SrBikinIdouMeisaiBatchDbAccess srBikinIdouMeisaiBatchDbAccess =
            SWAKInjector.getInstance(SrBikinIdouMeisaiBatchDbAccess.class);
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.BLNK;
        C_KawasetsryKbn cawasetsryKbn = C_KawasetsryKbn.BLNK;
        BizNumber kawaserate = BizNumber.ZERO;
        BizDate kwsrateKjYmd = BizDate.valueOf(0);

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null &&
            !C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {
            IT_NyknJissekiRireki nyknJissekiRireki = srBikinIdouMeisaiBatchDbAccess.getNyknJissekiRireki(
                pBikinIdouMeisai.getSyono(), pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM(), 1);

            if(C_Tuukasyu.JPY.eq(nyknJissekiRireki.getRstuukasyu())) {

                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
                cawasetsryKbn = C_KawasetsryKbn.NYUKINRATE;
            }
            else {
                kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
                cawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
            }

            BizDate kykKwsratekjYmd;
            if (pSyohnZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN ||
                (pSyohnZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN &&
                !C_Kykjyoutai.ZENNOU.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai()))) {
                kykKwsratekjYmd = nyknJissekiRireki.getRyosyuymd().addBusinessDays(-1);
            }
            else {
                kykKwsratekjYmd = nyknJissekiRireki.getRyosyuymd();
            }

            C_ErrorKbn errorKbn = getKawaseRate.exec(kykKwsratekjYmd,
                kawaserateSyuruiKbn,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                C_Tuukasyu.JPY,
                C_KawasetekiyoKbn.TTM,
                cawasetsryKbn,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1004,
                    kykKwsratekjYmd.toString(),
                    kawaserateSyuruiKbn.getValue(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                    C_Tuukasyu.JPY.getValue(),
                    C_KawasetekiyoKbn.TTM.getValue(),
                    cawasetsryKbn.getValue(),
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                    C_YouhiKbn.HUYOU.getValue());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                errorFlg = true;
            }
            else {

                kawaserate = getKawaseRate.getKawaserate();
                kwsrateKjYmd = getKawaseRate.getKwsrateKjYmd();
            }

            C_Tuukasyu rsTuukasyu = nyknJissekiRireki.getRstuukasyu();

            if (!pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().eq(rsTuukasyu)
                && (C_Tuukasyu.AUD.eq(rsTuukasyu) || C_Tuukasyu.USD.eq(rsTuukasyu))) {

                BizNumber crossRate = BizNumber.ZERO;

                errorKbn = getKawaseRate.exec(nyknJissekiRireki.getRyosyuymd(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                    rsTuukasyu,
                    C_KawasetekiyoKbn.TTM,
                    C_KawasetsryKbn.NYUKINRATE,
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                    C_YouhiKbn.HUYOU);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    String msg = MessageUtil.getMessage(MessageId.ESA1004,
                        nyknJissekiRireki.getRyosyuymd().toString(),
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE.getValue(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                        rsTuukasyu.getValue(),
                        C_KawasetekiyoKbn.TTM.getValue(),
                        C_KawasetsryKbn.NYUKINRATE.getValue(),
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                        C_YouhiKbn.HUYOU.getValue());

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                    suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                    errorFlg = true;
                }
                else {

                    crossRate = getKawaseRate.getKawaserate();
                }

                SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);

                SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean =
                    srSuuriGouseiRateKeisan.exec(nyknJissekiRireki.getRyosyuymd(), rsTuukasyu, crossRate);

                if (C_ErrorKbn.ERROR.eq(srSuuriGouseiRateKeisanBean.getErrorKbn())) {

                    SetErrMessageInfoBean errMessageInfoBean = srSuuriGouseiRateKeisanBean.getErrMessageInfoBean();

                    String msg = MessageUtil.getMessage(MessageId.ESA1004,
                        errMessageInfoBean.getKwsrateKjYmd().toString(),
                        errMessageInfoBean.getKawaserateSyuruiKbn().getValue(),
                        errMessageInfoBean.getMotoTuukasyu().getValue(),
                        errMessageInfoBean.getKansanTuukasyu().getValue(),
                        errMessageInfoBean.getKawasetekiyoKbn().getValue(),
                        errMessageInfoBean.getKawasetsryKbn().getValue(),
                        errMessageInfoBean.getEigyoubiHoseiKbn().getValue(),
                        errMessageInfoBean.getYouhiKbn().getValue() + "：合成レート");

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                    suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                    errorFlg = true;
                }
                else {

                    kawaserate = srSuuriGouseiRateKeisanBean.getSuuriGouseiRate();
                }
            }
        }

        BizCurrency mvatyouseigow = BizCurrency.valueOf(0);
        BizCurrency mvakeisanjisknnjynbkn = BizCurrency.valueOf(0);
        BizNumber suuriyoukaiyakusjktsritu = BizNumber.valueOf(0);
        BizNumber mvatyouseikou = BizNumber.valueOf(0);
        BizNumber suuriyoukeiyakusjktsritu = BizNumber.valueOf(0);
        BizDate mvaKeisanKijunYmd = BizDate.valueOf(0);
        BizCurrency kykkjmmvatyouseigow = BizCurrency.valueOf(0);
        BizCurrency sibous = BizCurrency.valueOf(0);
        BizCurrency totalGskhjSbs = BizCurrency.valueOf(0);
        BizCurrency almSibous = BizCurrency.valueOf(0);

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

        if (!C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu()) ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

            if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                keisanDate) == BizDateUtil.COMPARE_LESSER
                || BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    keisanDate) == BizDateUtil.COMPARE_EQUAL) {

                BizDateYM kaiyakuhrKisnKijyunYM =
                    keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), keisanDate,
                        null, null, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

                BizDateYM tmttkntaisyouym = null;
                BizCurrency teiritutmttkngk = BizCurrency.valueOf(0);
                BizCurrency sisuurendoutmttkngk = BizCurrency.valueOf(0);
                BizNumber keisanTumitateriritu = BizNumber.ZERO;
                BizNumber kaiyakusjktsritu = BizNumber.ZERO;
                BizDate tmttkntaisyouymd = null;

                if ((pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) &&
                    (C_UmuKbn.ARI.eq(bmSyouhnZokusei.getMvatekiumu()))) {

                    if(BizDateUtil.calcDifferenceMonths(pTmttknInfoKijyunYmd.getBizDateYM(),
                        pKhSisuurendoTmttkn.getTmttkntaisyouym()) > SrCommonConstants.KIKAN_12M){

                        int keikanensuWk =  BizDateUtil.calcDifferenceMonths(pTmttknInfoKijyunYmd.getBizDateYM(),
                            pKhSisuurendoTmttkn.getTmttkntaisyouym());
                        int Keikanensuu = keikanensuWk / 12;
                        tmttkntaisyouym = pKhSisuurendoTmttkn.getTmttkntaisyouym().addYears(Keikanensuu);
                        tmttkntaisyouymd = BizDate.valueOf(tmttkntaisyouym, pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();

                        KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd =
                            SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

                        C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
                            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                            pBikinIdouMeisai.getTeikishrtkykhukaumu(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                            tmttkntaisyouymd,
                            tmttkntaisyouym,
                            pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                            pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                            pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            String msg =
                                MessageUtil.getMessage(MessageId.ESA1001, "積立金計算：ＭＶＡ調整後Ｗ",pBikinIdouMeisai.getSyono());

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                            suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                            suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                            suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                            errorFlg = true;
                        }
                        else {
                            teiritutmttkngk = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
                            sisuurendoutmttkngk = keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk();
                            keisanTumitateriritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                        }
                    }
                    else {
                        tmttkntaisyouym = pKhSisuurendoTmttkn.getTmttkntaisyouym();
                        teiritutmttkngk = pKhSisuurendoTmttkn.getTeiritutmttkngk();
                        sisuurendoutmttkngk = pKhSisuurendoTmttkn.getSisuurendoutmttkngk();
                        keisanTumitateriritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                    }
                }
                else if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                    (C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu()))) {
                    keisanTumitateriritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
                }

                GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu =
                    SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
                GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean =
                    SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);

                if (C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu())) {

                    suuriyoukaiyakusjktsritu = BizNumber.ZERO;
                }
                else {

                    getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                    getSjkkktyouseiyourirituBean.setKijyunymd(keisanDate);
                    getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
                    getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
                    getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

                    C_ErrorKbn kekkaKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                    if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                        String msg =
                            MessageUtil.getMessage(MessageId.ESA1001, "市場価格調整用利率",pBikinIdouMeisai.getSyono());

                        batchLogger.warn(msg);

                        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                        suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                        suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                        suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                        pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                        errorFlg = true;
                    }
                    else {

                        kaiyakusjktsritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
                    }
                }
                KeisanW keisanW= SWAKInjector.getInstance(KeisanW.class);

                KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

                keisanWExtBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
                keisanWExtBean.setSyouhnsdno(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());
                keisanWExtBean.setRyouritusdno(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
                keisanWExtBean.setYoteiriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu());
                keisanWExtBean.setHrkkaisuu(pBikinIdouMeisai.getHrkkaisuu());
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
                keisanWExtBean.setKaiyakusjkkktyouseiriritu(kaiyakusjktsritu);
                keisanWExtBean.setTmttkntaisyouym(tmttkntaisyouym);
                keisanWExtBean.setTeiritutmttkngk(teiritutmttkngk);
                keisanWExtBean.setSisuurendoutmttkngk(sisuurendoutmttkngk);
                keisanWExtBean.setTumitateriritu(keisanTumitateriritu);
                keisanWExtBean.setYendthnkymd(pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());
                keisanWExtBean.setTeikishrtkykhukaumu(pBikinIdouMeisai.getTeikishrtkykhukaumu());
                keisanWExtBean.setDai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn());
                keisanWExtBean.setKykJyoutai(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai());

                C_ErrorKbn kekkaKbn = keisanW.exec(keisanDate, kaiyakuhrKisnKijyunYM, keisanWExtBean);

                if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                    String msg =
                        MessageUtil.getMessage(MessageId.ESA1001, "解約返戻金",pBikinIdouMeisai.getSyono());

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                    errorFlg = true;
                }
                else {

                    if (C_UmuKbn.NONE.eq(bmSyouhnZokusei.getMvatekiumu())) {

                        mvatyouseigow = keisanW.getW();
                        mvakeisanjisknnjynbkn = keisanW.getV();
                        suuriyoukaiyakusjktsritu = kaiyakusjktsritu;
                        suuriyoukeiyakusjktsritu = BizNumber.ZERO;
                        mvatyouseikou = keisanW.getMvaTyouseikou();
                        mvaKeisanKijunYmd = BizDate.valueOf(0);

                        if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                            kykkjmmvatyouseigow = BizCurrency.valueOf(0);
                            sibous = keisanW.getV();
                            totalGskhjSbs = keisanW.getV();
                            almSibous = keisanW.getV();
                        }
                        else {

                            kykkjmmvatyouseigow = keisanW.getKaiyakukjMaeW();
                        }
                    }
                    else{
                        mvatyouseigow = keisanW.getW();
                        mvakeisanjisknnjynbkn = keisanW.getV();
                        suuriyoukaiyakusjktsritu = kaiyakusjktsritu;
                        suuriyoukeiyakusjktsritu = pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu();
                        mvatyouseikou = keisanW.getMvaTyouseikou();
                        mvaKeisanKijunYmd = keisanDate;
                        kykkjmmvatyouseigow = keisanW.getKaiyakukjMaeW();
                    }
                }
            }
            else {
                mvatyouseigow = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
                mvakeisanjisknnjynbkn = pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou();
                suuriyoukaiyakusjktsritu = pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu();
                suuriyoukeiyakusjktsritu = pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu();
                mvatyouseikou = BizNumber.valueOf(SrCommonConstants.MVATYOUSEIKOU_CASCADE);
                mvaKeisanKijunYmd = keisanDate;
                kykkjmmvatyouseigow = mvatyouseigow;
            }
        }

        BizNumber rendouritu = BizNumber.ZERO;

        if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (!C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {

                rendouritu = pTkJitenKeiyakuSyouhinKijyunBean.getRendouritu();
            }

        }
        SrGetTokutejitenTokuyakuInfo getTokutejitenTokuyakuInfo =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfo.class);
        BizCurrency enkdtsbujsitihsyukngk = BizCurrency.valueOf(0);
        String kaigomaebaraitkykarihyj = "";
        String shiharaituukaKbn = "";

        if (pSyohnZokusei != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR &&
            pSyohnZokusei != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {

                if (C_IdouRecordKbn.MINUSRECORD.eq(pIdouRecordKbn)) {

                    SrGetTokutejitenTokuyakuInfoBean getTokutejitenTokuyakuInfoBean =
                        getTokutejitenTokuyakuInfo.exec(C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK,
                            C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET,
                            null,
                            pBikinIdouMeisai.getSyono(),
                            C_SuuriIdoKbn.GENGAKU,
                            pBikinIdouMeisai.getHenkousikibetukey(),
                            pKouryokuhasseiymd,
                            pKiykSyuhnDataList,
                            pBikinIdouMeisai.getYendthnkymd(),
                            pKykSyouhnHnkmaeList,
                            pBikinIdouMeisai.getInitsbjiyensitihsytkhukaumu(),
                            pBikinIdouMeisai.getInitsbjiyenkasaiteihsygk(),
                            null, null, null, null);

                    enkdtsbujsitihsyukngk = getTokutejitenTokuyakuInfoBean.getInitsbjiyenkasaiteihsygkMae();
                    initsbjiyenkasaiteihsygk = getTokutejitenTokuyakuInfoBean.getInitsbjiyenkasaiteihsygkAto();
                }
                else if (C_IdouRecordKbn.PLUSRECORD.eq(pIdouRecordKbn)) {
                    enkdtsbujsitihsyukngk = initsbjiyenkasaiteihsygk;
                } else {

                    if (C_UmuKbn.ARI.eq(pBikinIdouMeisai.getInitsbjiyensitihsytkhukaumu())) {

                        enkdtsbujsitihsyukngk = pBikinIdouMeisai.getInitsbjiyenkasaiteihsygk();
                    }
                }
            }
        }

        if (C_UmuKbn.ARI.eq(pBikinIdouMeisai.getJyudkaigomeharaitkhukaumu())) {

            kaigomaebaraitkykarihyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            kaigomaebaraitkykarihyj = SrCommonConstants.HYOUJI_NASI;
        }

        if (pBikinIdouMeisai.getShrtuukasyu() == null || pBikinIdouMeisai.getShrtuukasyu().eq(C_Tuukasyu.BLNK)) {

            shiharaituukaKbn = SrCommonConstants.DEFAULT_STRING_ZERO_1;
        }
        else {

            srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA,
                pBikinIdouMeisai.getShrtuukasyu().getValue());

            if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                String msg = MessageUtil.getMessage(MessageId.ESA1002,
                    C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA.getContent(),
                    pBikinIdouMeisai.getSyono(),
                    pBikinIdouMeisai.getShrtuukasyu().getValue());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                errorFlg = true;
            }
            else {
                shiharaituukaKbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
            }
        }

        BizCurrency enkdtsbujsitihsyucost = BizCurrency.valueOf(0);
        String enkdtsbujsitihsyuarihyj = "";

        if (C_BkncdKbn.SIBOUUKETUKE.eq(pBikinIdouMeisai.getBkncdkbn()) ||
            C_BkncdKbn.SIBOUKARIUKETUKE.eq(pBikinIdouMeisai.getBkncdkbn())) {

            if (!pBikinIdouMeisai.getSitihsyutkyumaeyenhknkngk().isZeroOrOptional()) {

                enkdtsbujsitihsyucost = pBikinIdouMeisai.getInitsbjiyenkasaiteihsygk().
                    subtract(pBikinIdouMeisai.getSitihsyutkyumaeyenhknkngk());

                enkdtsbujsitihsyuarihyj = "1";
            }
            else {

                enkdtsbujsitihsyucost = BizCurrency.valueOf(0);

                enkdtsbujsitihsyuarihyj = "0";
            }
        }

        Integer endttargetmokuhyouritu = 0;
        BizCurrency endttargetkijyunkingaku = BizCurrency.valueOf(0);


        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
            endttargetmokuhyouritu = pKykSyouhnHnkmaeList.get(0).getTargettkmokuhyouti();
        }
        else {
            if (C_IdouRecordKbn.MINUSRECORD.eq(pIdouRecordKbn)) {

                SrGetTokutejitenTokuyakuInfoBean getTokutejitenTokuyakuInfoBean =
                    getTokutejitenTokuyakuInfo.exec(C_GetTaisyouSonotaTokuyakuKbn.TARGETTOKUYAKU,
                        C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET,
                        null,
                        pBikinIdouMeisai.getSyono(),
                        C_SuuriIdoKbn.GENGAKU,
                        pBikinIdouMeisai.getHenkousikibetukey(),
                        pKouryokuhasseiymd,
                        pKiykSyuhnDataList,
                        pBikinIdouMeisai.getYendthnkymd(),
                        pKykSyouhnHnkmaeList,
                        null,
                        null,
                        pBikinIdouMeisai.getTargettkhkumu(),
                        pBikinIdouMeisai.getTargettkmokuhyouti(),
                        pBikinIdouMeisai.getTargettkykkijyungk(),
                        pBikinIdouMeisai.getTargettkykkykhenkoymd());

                endttargetmokuhyouritu = getTokutejitenTokuyakuInfoBean.getTargettkmokuhyoutiMae();
                endttargetmokuhyourituplusrecord = getTokutejitenTokuyakuInfoBean.getTargettkmokuhyoutiAto();
                endttargetkijyunkingaku = getTokutejitenTokuyakuInfoBean.getTargettkykkijyungkMae();
                endttargetkijyungkplusrecord = getTokutejitenTokuyakuInfoBean.getTargettkykkijyungkAto();
            }
            else if (C_IdouRecordKbn.PLUSRECORD.eq(pIdouRecordKbn)) {

                endttargetmokuhyouritu = endttargetmokuhyourituplusrecord;
                endttargetkijyunkingaku = endttargetkijyungkplusrecord;
            } else {

                if (C_UmuKbn.ARI.eq(pBikinIdouMeisai.getTargettkhkumu())) {

                    endttargetmokuhyouritu = pBikinIdouMeisai.getTargettkmokuhyouti();
                    endttargetkijyunkingaku = pBikinIdouMeisai.getTargettkykkijyungk();
                }
            }
        }

        BizNumber kykYoteiriritu = BizNumber.ZERO;

        if (pSyohnZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
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

            C_ErrorKbn kekkaKbn = getYoteiriritu.exec(getYoteirirituBean);

            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {
                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "契約時予定利率",
                    pBikinIdouMeisai.getSyono());

                batchLogger.warn(msg);

                createSuuriyouErrJyouhou(pSrBikinIdouMeisaiBatchParam, pBikinIdouMeisai, msg);
            }
            else {
                kykYoteiriritu = getYoteiriritu.getYoteiriritu();
            }
        }
        else if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

                kykYoteiriritu = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu();
            }
        }
        else {
            kykYoteiriritu = pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu();
        }

        String sibouhyoukbn = "";

        C_SrKbnHenkanKbn srKbnHenkanKbn = null;

        if (pSyohnZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU2;
        }
        else {
            srKbnHenkanKbn = C_SrKbnHenkanKbn.SUURI_SIBOUHYOU;
        }

        srSuuriKbnHenkanBean =
            srSuuriKbnHenkanSet.exec(srKbnHenkanKbn, pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                srKbnHenkanKbn.getContent(),
                pBikinIdouMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
            errorFlg = true;
        }
        else {
            sibouhyoukbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        BizNumber tumitateriritu = BizNumber.ZERO;
        BizNumber sisuurendourate = BizNumber.ZERO;
        String ztyteirituikouhyouji = SrCommonConstants.HYOUJI_NASI;
        BizNumber tmttknzoukaritujygn = BizNumber.ZERO;
        BizNumber setteibairitu = BizNumber.ZERO;
        String sisuukbn = "";
        BizNumber tykzenoutouYmdSisuu = BizNumber.valueOf(0);
        BizNumber kimatuSisuu = BizNumber.valueOf(0);
        BizCurrency sisuurentumitatekin = BizCurrency.valueOf(0);
        BizCurrency nksjitirttumitatekin = BizCurrency.valueOf(0);
        BizCurrency kimatutirttumitatekin = BizCurrency.valueOf(0);
        BizCurrency sisuurentyokugotmttkn = BizCurrency.valueOf(0);

        if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

            tmttknzoukaritujygn = pTkJitenKeiyakuSyouhinKijyunBean.getTmttknzoukaritujygn();
            setteibairitu = pTkJitenKeiyakuSyouhinKijyunBean.getSetteibairitu();
        }

        if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

            BizDateYM tmttknKisnKijyunYM = null;
            BizDate tmttknKisnKijyunYMD = null;

            if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null &&
                    pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() == null) {

                    sisuurendourate = pTkJitenKeiyakuSyouhinKijyunBean.getKykjisisuurendourate();

                    if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pTmttknInfoKijyunYmd) == BizDateUtil.COMPARE_LESSER
                        || BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTmttknInfoKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {

                        tykzenoutouYmdSisuu = pKhSisuurendoTmttkn.getTmttknhaneisisuu();
                        kimatuSisuu = pKhSisuurendoTmttkn.getTmttknhaneisisuu();
                    }
                }

                if(pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() != null){

                    ztyteirituikouhyouji = SrCommonConstants.HYOUJI_ARI;
                }
            }

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {

                if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                    sisuurentumitatekin = pKhSisuurendoTmttkn.getSisuurendoutmttkngk();
                    sisuurentyokugotmttkn = pKhSisuurendoTmttkn.getSisuurendoutmttkngk();

                    KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd = SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

                    C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                        pBikinIdouMeisai.getTeikishrtkykhukaumu(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getBizDateYM(),
                        pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                        pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                        pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        String msg = MessageUtil.getMessage(MessageId.ESA1001, "年金開始時定率部分積立金",
                            pBikinIdouMeisai.getSyono());

                        batchLogger.warn(msg);

                        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                        suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                        suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                        suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                        pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                        errorFlg = true;
                    }
                    else {

                        nksjitirttumitatekin =keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
                    }

                    if (BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pTmttknInfoKijyunYmd) == BizDateUtil.COMPARE_LESSER
                        || BizDateUtil.compareYmd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTmttknInfoKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {

                        tmttknKisnKijyunYM =
                            keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), pTmttknInfoKijyunYmd,
                                null, null, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());
                        tmttknKisnKijyunYMD = pTmttknInfoKijyunYmd;
                    }
                    else {

                        tmttknKisnKijyunYM = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
                        tmttknKisnKijyunYMD = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
                    }
                    KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd2 =
                        SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

                    errorKbn = keisanSisuuRendouNkTmttknOverNnd2.exec(
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                        pBikinIdouMeisai.getTeikishrtkykhukaumu(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                        tmttknKisnKijyunYMD,
                        tmttknKisnKijyunYM,
                        pKhSisuurendoTmttkn.getTmttkntaisyouym(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
                        pKhSisuurendoTmttkn.getTeiritutmttkngk(),
                        pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        String msg = MessageUtil.getMessage(MessageId.ESA1001, "期末定率部分積立金",
                            pBikinIdouMeisai.getSyono());

                        batchLogger.warn(msg);

                        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                        suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                        suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                        suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                        pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                        errorFlg = true;
                    }
                    else {

                        kimatutirttumitatekin =keisanSisuuRendouNkTmttknOverNnd2.getTeiritutmttkngk();
                    }

                    if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(
                        pTkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {
                        sisuukbn = C_Sisuukbn.BLNK.getValue();
                    }
                    else {
                        sisuukbn = pTkJitenKeiyakuSyouhinKijyunBean.getSisuukbn().getValue();
                    }

                    srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_SISUU, sisuukbn);

                    if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

                        String msg = MessageUtil.getMessage(MessageId.ESA1002,
                            C_SrKbnHenkanKbn.SUURI_SISUU.getContent(),
                            pBikinIdouMeisai.getSyono(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getSisuukbn().getValue());

                        batchLogger.warn(msg);

                        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
                        suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                        suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                        suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                        pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                        errorFlg = true;
                    }
                    else {
                        sisuukbn = srSuuriKbnHenkanBean.getHenkanAtoKbn();
                    }
                }

            }
            else {

                if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

                    nksjitirttumitatekin = nkgns;
                }

                if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                    BizDateYM kisnKijyunymAtoYm =
                        keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                            pTmttknInfoKijyunYmd,
                            null, null, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

                    BizDateYM YendthnkymAtoYm =
                        keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                            null, null, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

                    KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk = SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

                    C_ErrorKbn errorKbn = keisanSisuuRendouNkTmttknYendtHnk.exec(pTmttknInfoKijyunYmd,
                        kisnKijyunymAtoYm,
                        pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                        YendthnkymAtoYm,
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKihons(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        String msg = MessageUtil.getMessage(MessageId.ESA1001, "期末定率部分積立金",
                            pBikinIdouMeisai.getSyono());

                        batchLogger.warn(msg);

                        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                        suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
                        suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
                        suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
                        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                        pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
                        errorFlg = true;
                    }
                    else {
                        kimatutirttumitatekin = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
                    }
                }
            }

            if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
                (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {

                tumitateriritu = pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu();
            }
        }

        else if (pSyohnZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            tumitateriritu = yoteiriritujtnyknbase.subtract(vhireilritujtnyknbase);
        }

        BizNumber kwsRate2 = BizNumber.ZERO;
        BizDate kwsrateTekiyouYmd2 = BizDate.valueOf(0);

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null &&
            !C_Tuukasyu.JPY.eq(pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu())) {

            kwsrateTekiyouYmd2 = pBikinIdouMeisai.getShrkwsratekjnymd();
            kwsRate2 = pBikinIdouMeisai.getShrkwsrate();
        }

        BizNumber yoteiRirituJtnyknbase = yoteiriritujtnyknbase;

        BizCurrency kihrkmpJtnyknbase = BizCurrency.valueOf(0);
        KeisanKihrkP keisanKihrkP = SWAKInjector.getInstance(KeisanKihrkP.class);
        if (pSyohnZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            C_ErrorKbn errorKbn = keisanKihrkP.exec(pBikinIdouMeisai.getSyono()
                , pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001, "既払込Ｐ（実入金ベース）",
                    pBikinIdouMeisai.getSyono());

                batchLogger.warn(msg);

                createSuuriyouErrJyouhou(pSrBikinIdouMeisaiBatchParam, pBikinIdouMeisai, msg);
            }
        }
        else {

            kihrkmpJtnyknbase = kihrkmpstgkjtnyknbase;
        }

        BizCurrency syuptumitatekin = ptumitatekinjtnyknbase;

        BizCurrency gaikadatenkgns = ptumitatekinnkgns;

        BizDateYM jikaipjyuutouym2 = jkipjytym;
        if (pSyohnZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            jikaipjyuutouym2 = pBikinIdouMeisai.getJkipjytym();
        }

        BizCurrency tumitatekin = ptumitatekinriroubase;

        BizCurrency kiharaikomip = kihrkmpstgkriroubase;
        if (pSyohnZokusei == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {

            kiharaikomip = keisanKihrkP.getKihrkP();
        }

        BizCurrency gaikaDateSyukeiyakup = gaikadatesyukeiyakup;

        long rrthnduhknvkisovkisnyu1 = 0L;

        if ((pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
            rrthnduhknvkisovkisnyu1 =
                new BigDecimal(pTkJitenKeiyakuSyouhinKijyunBean.getKihons().toAdsoluteString()).longValue();
        }

        String tuukasyu = "";
        srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.TUUKA_SYU, pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.TUUKA_SYU.getContent(),
                pBikinIdouMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            createSuuriyouErrJyouhou(pSrBikinIdouMeisaiBatchParam, pBikinIdouMeisai, msg);

        }
        else {
            tuukasyu = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        pZtBikinIdouMeisaiTy.setZtygaikakbn(gaikaKbn);
        pZtBikinIdouMeisaiTy.setZtykawaserate2(kwsRate2);
        pZtBikinIdouMeisaiTy.setZtykawaseratetekiyouymd2(kwsrateTekiyouYmd2.toString());
        pZtBikinIdouMeisaiTy.setZtykykjikawaserate(kawaserate);
        pZtBikinIdouMeisaiTy.setZtykykjikawaseratetkyuymd(kwsrateKjYmd.toString());
        pZtBikinIdouMeisaiTy.setZtymvatyouseigow(new BigDecimal(mvatyouseigow.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtymvakeisanjisknnjynbkn(new BigDecimal(mvakeisanjisknnjynbkn.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtyrendouritu(rendouritu);
        pZtBikinIdouMeisaiTy.setZtysrkaiyakusjkkktyouseirrt(
            suuriyoukaiyakusjktsritu);
        pZtBikinIdouMeisaiTy.setZtysrkyksjkkktyouseiriritu(
            suuriyoukeiyakusjktsritu);
        if (mvaKeisanKijunYmd != null) {

            pZtBikinIdouMeisaiTy.setZtymvakeisankijyunymd(mvaKeisanKijunYmd.toString());
        }
        pZtBikinIdouMeisaiTy.setZtymvatyouseikou(mvatyouseikou);
        pZtBikinIdouMeisaiTy.setZtyenkdtsbujsitihsyukngk(new BigDecimal(enkdtsbujsitihsyukngk.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtyenkdtsbujsitihsyucost(new BigDecimal(enkdtsbujsitihsyucost.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtyenkdtsbujsitihsyuarihyj(enkdtsbujsitihsyuarihyj);
        pZtBikinIdouMeisaiTy.setZtykeiyakujiyoteiriritu(kykYoteiriritu);
        pZtBikinIdouMeisaiTy.setZtytumitateriritu(tumitateriritu);
        pZtBikinIdouMeisaiTy.setZtykaigomaebaraitkykarihyj(kaigomaebaraitkykarihyj);
        pZtBikinIdouMeisaiTy.setZtysibouhyoukbn(sibouhyoukbn);
        pZtBikinIdouMeisaiTy.setZtynyuukintuukakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pZtBikinIdouMeisaiTy.setZtysiharaituukakbn(shiharaituukaKbn);
        pZtBikinIdouMeisaiTy.setZtywyendttargetmokuhyouritu(String.valueOf(endttargetmokuhyouritu));
        pZtBikinIdouMeisaiTy.setZtysisuurendourate(sisuurendourate.toString());
        pZtBikinIdouMeisaiTy.setZtysisuukbn(sisuukbn);
        pZtBikinIdouMeisaiTy.setZtyteirituikouhyouji(ztyteirituikouhyouji);
        pZtBikinIdouMeisaiTy.setZtysrdai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn().toString());
        pZtBikinIdouMeisaiTy.setZtytmttknzoukaritujygn(tmttknzoukaritujygn);
        pZtBikinIdouMeisaiTy.setZtysetteibairitu(setteibairitu);
        pZtBikinIdouMeisaiTy.setZtytykzenoutouymdsisuu(tykzenoutouYmdSisuu);
        pZtBikinIdouMeisaiTy.setZtykimatusisuu(kimatuSisuu);
        pZtBikinIdouMeisaiTy.setZtytuukasyukbn(tuukasyu);
        pZtBikinIdouMeisaiTy.setZtysisuurentumitatekin(new BigDecimal(sisuurentumitatekin.toAdsoluteString()).longValue());
        if (nksjitirttumitatekin != null) {

            pZtBikinIdouMeisaiTy.setZtynksjitirttumitatekin(new BigDecimal(nksjitirttumitatekin.toAdsoluteString()).longValue());
        }
        pZtBikinIdouMeisaiTy.setZtykimatutirttumitatekin(new BigDecimal(kimatutirttumitatekin.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtyyendttargetkijyunkingaku(new BigDecimal(endttargetkijyunkingaku.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtysisuurentyokugotmttkn(new BigDecimal(sisuurentyokugotmttkn.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtyyoteiriritujtnyknbase(yoteiRirituJtnyknbase);
        pZtBikinIdouMeisaiTy.setZtykihrkmpjtnyknbase(new BigDecimal(kihrkmpJtnyknbase.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtysyuptumitatekin(new BigDecimal(syuptumitatekin.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtygaikadatenkgns(new BigDecimal(gaikadatenkgns.toAdsoluteString()).longValue());
        if (jikaipjyuutouym2 == null) {
            pZtBikinIdouMeisaiTy.setZtyjikaipjyuutouym2("");
        }
        else {
            pZtBikinIdouMeisaiTy.setZtyjikaipjyuutouym2(jikaipjyuutouym2.toString());
        }
        pZtBikinIdouMeisaiTy.setZtyrrthnduhknvkisovkisnyu1(rrthnduhknvkisovkisnyu1);
        pZtBikinIdouMeisaiTy.setZtytumitatekin(new BigDecimal(tumitatekin.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtykiharaikomip(new BigDecimal(kiharaikomip.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtygaikadatesyukeiyakup(new BigDecimal(gaikaDateSyukeiyakup.toAdsoluteString()).longValue());
        pZtBikinIdouMeisaiTy.setZtykykkjmmvatyouseigow(new BigDecimal(kykkjmmvatyouseigow.toAdsoluteString()).longValue());

        if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

            pZtBikinIdouMeisaiTy.setZtysibous(new BigDecimal(sibous.toAdsoluteString()).longValue());
            pZtBikinIdouMeisaiTy.setZtygoukeigyousekihyjsibous(new BigDecimal(totalGskhjSbs.toAdsoluteString()).longValue());
            pZtBikinIdouMeisaiTy.setZtyalmyousibous(new BigDecimal(almSibous.toAdsoluteString()).longValue());
        }

        if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            pSyohnZokusei == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null)) {

            pIdouMeisaiTyukeiyouItzHzn.setZtygaikakbn(gaikaKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtykawaserate2(kwsRate2);
            pIdouMeisaiTyukeiyouItzHzn.setZtykawaseratetekiyouymd2(kwsrateTekiyouYmd2.toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtykykjikawaserate(kawaserate);
            pIdouMeisaiTyukeiyouItzHzn.setZtykykjikawaseratetkyuymd(kwsrateKjYmd.toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtymvatyouseigow(new BigDecimal(mvatyouseigow.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtymvakeisanjisknnjynbkn(new BigDecimal(mvakeisanjisknnjynbkn.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyrendouritu(rendouritu);
            pIdouMeisaiTyukeiyouItzHzn.setZtysrkaiyakusjkkktyouseirrt(
                suuriyoukaiyakusjktsritu);
            pIdouMeisaiTyukeiyouItzHzn.setZtysrkyksjkkktyouseiriritu(
                suuriyoukeiyakusjktsritu);
            if (mvaKeisanKijunYmd != null) {

                pIdouMeisaiTyukeiyouItzHzn.setZtymvakeisankijyunymd(mvaKeisanKijunYmd.toString());
            }
            pIdouMeisaiTyukeiyouItzHzn.setZtymvatyouseikou(mvatyouseikou);
            pIdouMeisaiTyukeiyouItzHzn.setZtyenkdtsbujsitihsyukngk(new BigDecimal(enkdtsbujsitihsyukngk.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyenkdtsbujsitihsyucost(new BigDecimal(enkdtsbujsitihsyucost.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyenkdtsbujsitihsyuarihyj(enkdtsbujsitihsyuarihyj);
            pIdouMeisaiTyukeiyouItzHzn.setZtykeiyakujiyoteiriritu(kykYoteiriritu);
            pIdouMeisaiTyukeiyouItzHzn.setZtytumitateriritu(tumitateriritu);
            pIdouMeisaiTyukeiyouItzHzn.setZtykaigomaebaraitkykarihyj(kaigomaebaraitkykarihyj);
            pIdouMeisaiTyukeiyouItzHzn.setZtysibouhyoukbn(sibouhyoukbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtynyuukintuukakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
            pIdouMeisaiTyukeiyouItzHzn.setZtysiharaituukakbn(shiharaituukaKbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtywyendttargetmokuhyouritu(String.valueOf(endttargetmokuhyouritu));
            pIdouMeisaiTyukeiyouItzHzn.setZtysisuurendourate(sisuurendourate.toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtysisuukbn(sisuukbn);
            pIdouMeisaiTyukeiyouItzHzn.setZtyteirituikouhyouji(ztyteirituikouhyouji);
            pIdouMeisaiTyukeiyouItzHzn.setZtysrdai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn().toString());
            pIdouMeisaiTyukeiyouItzHzn.setZtytmttknzoukaritujygn(tmttknzoukaritujygn);
            pIdouMeisaiTyukeiyouItzHzn.setZtysetteibairitu(setteibairitu);
            pIdouMeisaiTyukeiyouItzHzn.setZtytykzenoutouymdsisuu(tykzenoutouYmdSisuu);
            pIdouMeisaiTyukeiyouItzHzn.setZtykimatusisuu(kimatuSisuu);
            pIdouMeisaiTyukeiyouItzHzn.setZtytuukasyukbn(tuukasyu);
            pIdouMeisaiTyukeiyouItzHzn.setZtysisuurentumitatekin(new BigDecimal(sisuurentumitatekin.toAdsoluteString()).longValue());
            if (nksjitirttumitatekin != null) {

                pIdouMeisaiTyukeiyouItzHzn.setZtynksjitirttumitatekin(new BigDecimal(nksjitirttumitatekin.toAdsoluteString()).longValue());
            }
            pIdouMeisaiTyukeiyouItzHzn.setZtykimatutirttumitatekin(new BigDecimal(kimatutirttumitatekin.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyyendttargetkijyunkingaku(new BigDecimal(endttargetkijyunkingaku.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysisuurentyokugotmttkn(new BigDecimal(sisuurentyokugotmttkn.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtyyoteiriritujtnyknbase(yoteiRirituJtnyknbase);
            pIdouMeisaiTyukeiyouItzHzn.setZtykihrkmpjtnyknbase(new BigDecimal(kihrkmpJtnyknbase.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtysyuptumitatekin(new BigDecimal(syuptumitatekin.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtygaikadatenkgns(new BigDecimal(gaikadatenkgns.toAdsoluteString()).longValue());
            if (jikaipjyuutouym2 == null) {
                pIdouMeisaiTyukeiyouItzHzn.setZtyjikaipjyuutouym2("");
            }
            else {
                pIdouMeisaiTyukeiyouItzHzn.setZtyjikaipjyuutouym2(jikaipjyuutouym2.toString());
            }
            pIdouMeisaiTyukeiyouItzHzn.setZtyrrthnduhknvkisovkisnyu1(rrthnduhknvkisovkisnyu1);
            pIdouMeisaiTyukeiyouItzHzn.setZtytumitatekin(new BigDecimal(tumitatekin.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtykiharaikomip(new BigDecimal(kiharaikomip.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtygaikadatesyukeiyakup(new BigDecimal(gaikaDateSyukeiyakup.toAdsoluteString()).longValue());
            pIdouMeisaiTyukeiyouItzHzn.setZtykykkjmmvatyouseigow(new BigDecimal(kykkjmmvatyouseigow.toAdsoluteString()).longValue());

            if (pSyohnZokusei == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {

                pIdouMeisaiTyukeiyouItzHzn.setZtysibous(new BigDecimal(sibous.toAdsoluteString()).longValue());
                pIdouMeisaiTyukeiyouItzHzn.setZtygoukeigyousekihyjsibous(new BigDecimal(totalGskhjSbs.toAdsoluteString()).longValue());
                pIdouMeisaiTyukeiyouItzHzn.setZtyalmyousibous(new BigDecimal(almSibous.toAdsoluteString()).longValue());
            }
        }
    }

    private void editIDDetailData(SrBikinIdouMeisaiBatchParam pSrBikinIdouMeisaiBatchParam,
        SV_BikinIdouMeisai pBikinIdouMeisai,
        BizDate pTmttkinInfoSyutokuKijyunYmd,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn) {

        pIdouMeisaiTyukeiyouItzHzn.setZtysrkijyunym(pSrBikinIdouMeisaiBatchParam.getKijyunymd().getBizDateYM().toString());
        pIdouMeisaiTyukeiyouItzHzn.setZtysrkakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
        pIdouMeisaiTyukeiyouItzHzn.setZtysrkouryokuhasseiymd(pBikinIdouMeisai.getCalckijyunymd().toString());
        pIdouMeisaiTyukeiyouItzHzn.setZtysrhenkousikibetukey(pBikinIdouMeisai.getHenkousikibetukey());
        pIdouMeisaiTyukeiyouItzHzn.setZtysrteikishrtkykhukaumu(pBikinIdouMeisai.getTeikishrtkykhukaumu().toString());
    }

    private void getHijyKyoutuuInfo(SrBikinIdouMeisaiBatchParam pSrBikinIdouMeisaiBatchParam,
        SV_BikinIdouMeisai pBikinIdouMeisai,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        C_IdouRecordKbn pIdouRecordKbn,
        List<SV_KiykSyuhnData> pKiykSyuhnDataList,
        List<IT_HokenryouTmttkn> pHokenryouTmttknList,
        int pSyohnZokusei) {

        jkipjytym = null;
        hijykouryokukaisiymd = null;
        tikikktbrijyututksu = "0";
        ptumitatekinjtnyknbase = BizCurrency.valueOf(0);
        kihrkmpstgkjtnyknbase = BizCurrency.valueOf(0);
        yoteiriritujtnyknbase = BizNumber.ZERO;
        vhireilritujtnyknbase = BizNumber.ZERO;
        ptumitatekinriroubase = BizCurrency.valueOf(0);
        kihrkmpstgkriroubase = BizCurrency.valueOf(0);
        ptumitatekinnkgns = BizCurrency.valueOf(0);
        gaikadatesyukeiyakup = BizCurrency.valueOf(0);

        BizDateYM keisanKijyunymJtnyknbase = null;
        BizDateYM keisanKijyunymRiroubase = null;
        BizDate idoubetuKijyunYmd = BizDate.valueOf(0);
        BizDate sisanKawaserateKijyunYmd = null;
        boolean nkgnsSisanFlg = false;
        List<SrTmttknBean> srTmttknBeanList = new ArrayList<>();

        if (C_BkncdKbn.KAIYAKU.eq(pBikinIdouMeisai.getBkncdkbn())
            || C_BkncdKbn.GENGK.eq(pBikinIdouMeisai.getBkncdkbn())) {

            idoubetuKijyunYmd = pBikinIdouMeisai.getCalckijyunymd();
        }
        else if (C_BkncdKbn.SIBOUKAIJYO.eq(pBikinIdouMeisai.getBkncdkbn())) {

            idoubetuKijyunYmd = pBikinIdouMeisai.getCalckijyunymd();
        }
        else if (C_BkncdKbn.SIBOUUKETUKE.eq(pBikinIdouMeisai.getBkncdkbn())
            || C_BkncdKbn.SIBOUKARIUKETUKE.eq(pBikinIdouMeisai.getBkncdkbn())
            || C_BkncdKbn.MENSEKI.eq(pBikinIdouMeisai.getBkncdkbn())) {

            idoubetuKijyunYmd = pBikinIdouMeisai.getCalckijyunymd();
        }

        SrGetTokutejitenAnsyuKihonInfo srGetTokutejitenAnsyuKihonInfo = SWAKInjector.
            getInstance(SrGetTokutejitenAnsyuKihonInfo.class);

        if (C_IdouRecordKbn.MINUSRECORD.eq(pIdouRecordKbn)) {

            BizDateYM jkipjytYm = srGetTokutejitenAnsyuKihonInfo.exec(pBikinIdouMeisai.getSyono(),
                null, pBikinIdouMeisai.getJkipjytym(), pBikinIdouMeisai.getHenkousikibetukey());

            jkipjytym = jkipjytYm;

            jkipjytymplusrecord = jkipjytYm;
        }
        else if (C_IdouRecordKbn.PLUSRECORD.eq(pIdouRecordKbn)) {
            jkipjytym = jkipjytymplusrecord;
        }
        else {

            if (C_BkncdKbn.KAIYAKU.eq(pBikinIdouMeisai.getBkncdkbn())) {

                jkipjytym = srGetTokutejitenAnsyuKihonInfo.exec(pBikinIdouMeisai.getSyono(),
                    null, pBikinIdouMeisai.getJkipjytym(), pBikinIdouMeisai.getHenkousikibetukey());
            }
            else if (C_BkncdKbn.SIBOUKAIJYO.eq(pBikinIdouMeisai.getBkncdkbn())) {

                jkipjytym = srGetTokutejitenAnsyuKihonInfo.exec(pBikinIdouMeisai.getSyono(),
                    BizDate.valueOf(pBikinIdouMeisai.getGyoumuKousinTime().substring(0, 8)),
                    pBikinIdouMeisai.getJkipjytym(), null);
            }
            else {

                jkipjytym = idoubetuKijyunYmd.getBizDateYM().addMonths(SrCommonConstants.KIKAN_1M);
            }
        }

        if (C_BkncdKbn.KAIYAKU.eq(pBikinIdouMeisai.getBkncdkbn()) ||
            C_BkncdKbn.GENGK.eq(pBikinIdouMeisai.getBkncdkbn()) ||
            C_BkncdKbn.SIBOUKAIJYO.eq(pBikinIdouMeisai.getBkncdkbn())) {

            if (BizDateUtil.compareYm(idoubetuKijyunYmd.getBizDateYM(), jkipjytym) == BizDateUtil.COMPARE_LESSER) {

                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                BizDate outouYmd = setOutoubi.exec(
                    C_TykzentykgoKbn.TYKGO,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    C_Hrkkaisuu.TUKI,
                    idoubetuKijyunYmd);

                hijykouryokukaisiymd = outouYmd;

                if (BizDateUtil.compareYmd(pBikinIdouMeisai.getKessankijyunymd(), hijykouryokukaisiymd) == BizDateUtil.COMPARE_LESSER) {

                    sisanKawaserateKijyunYmd = pBikinIdouMeisai.getKessankijyunymd();
                }
                else {

                    sisanKawaserateKijyunYmd = outouYmd;
                }
            }
            else {

                hijykouryokukaisiymd = jkipjytym.getBizDate(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();

                sisanKawaserateKijyunYmd = jkipjytym.getBizDate(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getDay()).getRekijyou();
            }
        }
        else if (C_BkncdKbn.SIBOUUKETUKE.eq(pBikinIdouMeisai.getBkncdkbn())
            || C_BkncdKbn.SIBOUKARIUKETUKE.eq(pBikinIdouMeisai.getBkncdkbn())
            || C_BkncdKbn.MENSEKI.eq(pBikinIdouMeisai.getBkncdkbn())) {

            hijykouryokukaisiymd = idoubetuKijyunYmd;

            sisanKawaserateKijyunYmd = idoubetuKijyunYmd;
        }

        if (BizDateUtil.compareYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd(),
            sisanKawaserateKijyunYmd) == BizDateUtil.COMPARE_LESSER) {

            sisanKawaserateKijyunYmd = pSrBikinIdouMeisaiBatchParam.getSyoriYmd();
        }

        if (C_IdouRecordKbn.MINUSRECORD.eq(pIdouRecordKbn)) {
            SrGetTokutejitenKykKihonInfo srGetTokutejitenKykKihonInfo =
                SWAKInjector.getInstance(SrGetTokutejitenKykKihonInfo.class);

            SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
                C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN,
                pBikinIdouMeisai.getSyono(),
                hijykouryokukaisiymd,
                pBikinIdouMeisai.getHenkousikibetukey(),
                pKiykSyuhnDataList,
                pBikinIdouMeisai.getTikiktbrisyuruikbn(),
                pBikinIdouMeisai.getHrkkeiro(),
                pBikinIdouMeisai.getHrkkaisuu());

            tikikktbrijyututksu = srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae().toString();
            tikikktbrijyututksuplusrecord = srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae().toString();
            hrkkeiro = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();
            hrkkeiroplusrecord = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();
            hrkkaisuu = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
            hrkkaisuuplusrecord = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
        }
        else if (C_IdouRecordKbn.PLUSRECORD.eq(pIdouRecordKbn)) {

            tikikktbrijyututksu = tikikktbrijyututksuplusrecord;
            hrkkeiro = hrkkeiroplusrecord;
            hrkkaisuu = hrkkaisuuplusrecord;
        }
        else {
            SrGetTokutejitenKykKihonInfo srGetTokutejitenKykKihonInfo =
                SWAKInjector.getInstance(SrGetTokutejitenKykKihonInfo.class);

            SrGetTokutejitenKykKihonInfoBean srGetTokutejitenKykKihonInfoBean = srGetTokutejitenKykKihonInfo.exec(
                C_KykKihonTokuteiJitenKbn.HRIHN_KIJYUNBIJITEN,
                pBikinIdouMeisai.getSyono(),
                hijykouryokukaisiymd,
                null,
                pKiykSyuhnDataList,
                pBikinIdouMeisai.getTikiktbrisyuruikbn(),
                pBikinIdouMeisai.getHrkkeiro(),
                pBikinIdouMeisai.getHrkkaisuu());

            tikikktbrijyututksu = srGetTokutejitenKykKihonInfoBean.getTikiktbrisyuruiKbnMae().toString();
            hrkkeiro = srGetTokutejitenKykKihonInfoBean.getHrkkeiroMae();
            hrkkaisuu = srGetTokutejitenKykKihonInfoBean.getHrkkaisuuMae();
        }

        if (pSyohnZokusei == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
            if (C_BkncdKbn.KAIYAKU.eq(pBikinIdouMeisai.getBkncdkbn()) ||
                C_BkncdKbn.GENGK.eq(pBikinIdouMeisai.getBkncdkbn()) ||
                C_BkncdKbn.SIBOUKAIJYO.eq(pBikinIdouMeisai.getBkncdkbn())) {

                keisanKijyunymJtnyknbase = hijykouryokukaisiymd.getBizDateYM().addMonths(-SrCommonConstants.KIKAN_1M);
                keisanKijyunymRiroubase = hijykouryokukaisiymd.getBizDateYM().addMonths(-SrCommonConstants.KIKAN_1M);
            }
            else if (C_BkncdKbn.SIBOUUKETUKE.eq(pBikinIdouMeisai.getBkncdkbn())
                || C_BkncdKbn.SIBOUKARIUKETUKE.eq(pBikinIdouMeisai.getBkncdkbn())
                || C_BkncdKbn.MENSEKI.eq(pBikinIdouMeisai.getBkncdkbn())) {

                if (BizDateUtil.compareYmd(hijykouryokukaisiymd,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

                    keisanKijyunymJtnyknbase = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
                    keisanKijyunymRiroubase = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().getBizDateYM();
                    nkgnsSisanFlg = true;
                }
                else {

                    keisanKijyunymJtnyknbase = hijykouryokukaisiymd.getBizDateYM();
                    keisanKijyunymRiroubase = hijykouryokukaisiymd.getBizDateYM();
                }
            }

            SrSuuriKeisanVHeijyun srSuuriKeisanVHeijyun =
                SWAKInjector.getInstance(SrSuuriKeisanVHeijyun.class);

            C_ErrorKbn errorKbn = srSuuriKeisanVHeijyun.exec(
                pBikinIdouMeisai.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean,
                pKiykSyuhnDataList,
                pHokenryouTmttknList,
                keisanKijyunymJtnyknbase,
                keisanKijyunymRiroubase,
                pBikinIdouMeisai.getHrkkaisuu(),
                pBikinIdouMeisai.getFstpnyknymd(),
                true,
                sisanKawaserateKijyunYmd,
                nkgnsSisanFlg,
                false);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001,
                    "平準払用保険料積立金",
                    pBikinIdouMeisai.getSyono());

                batchLogger.warn(msg);

                createSuuriyouErrJyouhou(pSrBikinIdouMeisaiBatchParam, pBikinIdouMeisai, msg);
            }
            else {
                srTmttknBeanList = srSuuriKeisanVHeijyun.getSrTmttknBeanList();

                for (SrTmttknBean srTmttknBean : srTmttknBeanList) {
                    if (BizDateUtil.compareYm(keisanKijyunymJtnyknbase, srTmttknBean.getTumitateYM()) == BizDateUtil.COMPARE_EQUAL) {
                        ptumitatekinjtnyknbase = srTmttknBean.getTmttKngk();

                        kihrkmpstgkjtnyknbase = srTmttknBean.getKiharaikomiP();

                        yoteiriritujtnyknbase = srTmttknBean.getYoteiriritu();

                        vhireilritujtnyknbase = srTmttknBean.getYoteiIjihirituVhirei();

                    }
                    if (BizDateUtil.compareYm(keisanKijyunymRiroubase, srTmttknBean.getTumitateYM()) == BizDateUtil.COMPARE_EQUAL) {

                        if (nkgnsSisanFlg) {

                            ptumitatekinriroubase = BizCurrency.valueOf(0);

                            kihrkmpstgkriroubase = BizCurrency.valueOf(0);
                        }
                        else {
                            ptumitatekinriroubase = srTmttknBean.getTmttKngk();

                            kihrkmpstgkriroubase = srTmttknBean.getKiharaikomiP();
                        }
                    }
                }
                if (srTmttknBeanList.size() > 0) {
                    ptumitatekinnkgns = srTmttknBeanList.get(srTmttknBeanList.size() - 1).getTmttKngk();
                }

                KeisanGaikaP keisanGaikaP = SWAKInjector.getInstance(KeisanGaikaP.class);
                errorKbn = keisanGaikaP.execKawaseSitei(
                    pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                    srTmttknBeanList.get(srTmttknBeanList.size() - 1).getKawaserate());

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                    String msg = MessageUtil.getMessage(MessageId.ESA1001, "外貨建主契約Ｐ", pBikinIdouMeisai.getSyono());

                    batchLogger.warn(msg);

                    createSuuriyouErrJyouhou(pSrBikinIdouMeisaiBatchParam, pBikinIdouMeisai, msg);

                }
                else {
                    gaikadatesyukeiyakup = keisanGaikaP.getP();
                }
            }
        }
    }

    private void createSuuriyouErrJyouhou(SrBikinIdouMeisaiBatchParam pSrBikinIdouMeisaiBatchParam,
        SV_BikinIdouMeisai pBikinIdouMeisai, String pMsg) {

        ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

        suuriyouErrJyouhou.setSyoriYmd(pSrBikinIdouMeisaiBatchParam.getSyoriYmd());
        suuriyouErrJyouhou.setKakutyoujobcd(pSrBikinIdouMeisaiBatchParam.getIbKakutyoujobcd());
        suuriyouErrJyouhou.setSyono(pBikinIdouMeisai.getSyono());
        suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(pMsg);
        suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

        pSrBikinIdouMeisaiBatchParam.setErrorCount(pSrBikinIdouMeisaiBatchParam.getErrorCount() + 1);
        errorFlg = true;
    }
}