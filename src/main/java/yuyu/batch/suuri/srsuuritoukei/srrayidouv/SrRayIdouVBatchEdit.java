package yuyu.batch.suuri.srsuuritoukei.srrayidouv;

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
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.kaikei.BzSegmentCdSyutoku;
import yuyu.common.biz.kaikei.SyouhinbetuSegmentBean;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknOverNnd;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknYendtHnk;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.KhSisuurendoTmttknBean;
import yuyu.common.suuri.srcommon.SetErrMessageInfoBean;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenSisuurendoTmttknInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTmttknInfoBean;
import yuyu.common.suuri.srcommon.SrSuuriGouseiRateKeisan;
import yuyu.common.suuri.srcommon.SrSuuriGouseiRateKeisanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ALMSoftKbn;
import yuyu.def.classification.C_DaiKbn;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HosyouKinouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_IdouRecordKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SkeiSoftKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SyouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_SnkiykGtjSirt;
import yuyu.def.db.entity.ZT_RayIdouVTy;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 ＲＡＹ異動Ｖ情報作成バッチ機能の項目編集クラス
 */
public class SrRayIdouVBatchEdit {

    private static final String ITKHSISUURENDOTMTTKN = "IT_KhSisuurendoTmttkn";

    private static final String SISUURENDOUTMTTKNGK = "sisuurendoutmttkngk";

    @Inject
    private BatchLogger batchLogger;

    private Boolean errorFlag;

    public SrRayIdouVBatchEdit() {

        errorFlag = false;
    }

    public boolean editKoumoku(
        SrRayIdouVBatchParam pSrRayIdouVBatchParam,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SV_SnkiykGtjSirt pSnkiykGtjSirt,
        IT_KykKihon pKykKihon,
        BM_SyouhnZokusei pSyouhnZokusei,
        IT_KykDairiten pKykDairiten,
        IT_NyknJissekiRireki pNyknJissekiRireki,
        IT_ItekiToukeiInfo pItekiToukeiInfo,
        ZT_RayIdouVTy pRayIdouVTy,
        boolean pIdolBknEditKoumokuFlag) {

        editHeaderData(
            pSrRayIdouVBatchParam,
            pRayIdouVTy);

        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = getTmttknInfo(
            pIdouMeisaiTyukeiyouItzHzn,
            pSvKiykSyuhnDataLst,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pSnkiykGtjSirt,
            pIdolBknEditKoumokuFlag);

        if (pIdolBknEditKoumokuFlag) {

            editIdouMeisai(pIdouMeisaiTyukeiyouItzHzn,pRayIdouVTy);
        }
        else {
            editSkeiKoumoku(pSrRayIdouVBatchParam , pTkJitenKeiyakuSyouhinKijyunBean ,
                pSnkiykGtjSirt , pKykKihon , pSyouhnZokusei , pKykDairiten , pNyknJissekiRireki , pItekiToukeiInfo,
                khSisuurendoTmttkn , pRayIdouVTy) ;
        }

        editRayIdouVTyData(pSrRayIdouVBatchParam , pIdouMeisaiTyukeiyouItzHzn,
            pTkJitenKeiyakuSyouhinKijyunBean , pSnkiykGtjSirt , khSisuurendoTmttkn ,
            pRayIdouVTy,pIdolBknEditKoumokuFlag);

        return errorFlag;
    }

    private void editHeaderData(
        SrRayIdouVBatchParam pSrRayIdouVBatchParam,
        ZT_RayIdouVTy pRayIdouVTy) {

        Integer keyKoumoku = pSrRayIdouVBatchParam.getSyoriCount();
        pSrRayIdouVBatchParam.setSyoriCount(pSrRayIdouVBatchParam.getSyoriCount() + 1);

        pRayIdouVTy.setZtysequenceno(keyKoumoku);

    }

    private IT_KhSisuurendoTmttkn getTmttknInfo(
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SV_SnkiykGtjSirt pSnkiykGtjSirt,
        boolean pIdolBknEditKoumokuFlag) {

        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;

        SrRayIdouVBatchDbAccess batchDbAccess =
            SWAKInjector.getInstance(SrRayIdouVBatchDbAccess.class);

        if (pIdolBknEditKoumokuFlag) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
                return khSisuurendoTmttkn;
            }

            if (BizDateUtil.compareYmd(BizDate.valueOf(pIdouMeisaiTyukeiyouItzHzn.getZtysrkouryokuhasseiymd()),
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

                List<IT_KhSisuurendoTmttkn> pKhSisuurendoTmttknLst =
                    batchDbAccess.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(
                        pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                        pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());
                khSisuurendoTmttkn = pKhSisuurendoTmttknLst.get(0);

            }
            else {

                if (pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_GENGAKU_MINUS) ||
                    pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_GENGAKU_PLUS) ||
                    pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_MINUS) ||
                    pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_PLUS) ||
                    pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_MINUS) ||
                    pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_PLUS) ||
                    pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_TEIRITUITEN_MINUS) ||
                    pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_TEIRITUITEN_PLUS) ||
                    pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_TEIRITUITENTRKS_MINUS) ||
                    pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_TEIRITUITENTRKS_PLUS)) {

                    SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
                        SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                    List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst =
                        srGetTokutejitenSisuurendoTmttknInfo.exec(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino(), null,
                            pIdouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey(), pSvKiykSyuhnDataLst);

                    KhSisuurendoTmttknBean khSisuurendoTmttknBean =
                        srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                            null, pIdouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey(),
                            srGetTokutejitenTmttknInfoBeanLst);

                    if (pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_GENGAKU_MINUS)||
                        pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_MINUS) ||
                        pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_MINUS) ||
                        pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_TEIRITUITENTRKS_MINUS) ||
                        pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_TEIRITUITENTRKS_PLUS)) {
                        khSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();

                        if (pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_MINUS)) {
                            if (khSisuurendoTmttkn.getItenmaesisuurendoutmttkngk() != null &&
                                khSisuurendoTmttkn.getItenmaesisuurendoutmttkngk().compareTo(
                                    BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO, khSisuurendoTmttkn.getItenmaesisuurendoutmttkngk().getType())) != 0) {
                                khSisuurendoTmttkn.setTeiritutmttkngk(khSisuurendoTmttkn.getItenmaeteiritutmttkngk());
                                khSisuurendoTmttkn.setSisuurendoutmttkngk(khSisuurendoTmttkn.getItenmaesisuurendoutmttkngk());
                            }
                        }
                        else if (pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_TEIRITUITENTRKS_PLUS)) {
                            khSisuurendoTmttkn.setTeiritutmttkngk(khSisuurendoTmttkn.getItenmaeteiritutmttkngk());
                            khSisuurendoTmttkn.setSisuurendoutmttkngk(khSisuurendoTmttkn.getItenmaesisuurendoutmttkngk());
                        }
                    }
                    else if (pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_GENGAKU_PLUS)||
                        pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_PLUS) ||
                        pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_PLUS) ||
                        pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_TEIRITUITEN_MINUS) ||
                        pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_TEIRITUITEN_PLUS)) {

                        khSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

                        if (pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_PLUS)) {
                            if (khSisuurendoTmttkn.getItenmaesisuurendoutmttkngk() != null &&
                                khSisuurendoTmttkn.getItenmaesisuurendoutmttkngk().compareTo(
                                    BizCurrency.valueOf(SrCommonConstants.DEFAULT_INT_ZERO, khSisuurendoTmttkn.getItenmaesisuurendoutmttkngk().getType())) != 0) {
                                khSisuurendoTmttkn.setTeiritutmttkngk(khSisuurendoTmttkn.getItenmaeteiritutmttkngk());
                                khSisuurendoTmttkn.setSisuurendoutmttkngk(khSisuurendoTmttkn.getItenmaesisuurendoutmttkngk());
                            }
                        }
                        else if (pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_TEIRITUITEN_MINUS)) {
                            khSisuurendoTmttkn.setTeiritutmttkngk(khSisuurendoTmttkn.getItenmaeteiritutmttkngk());
                            khSisuurendoTmttkn.setSisuurendoutmttkngk(khSisuurendoTmttkn.getItenmaesisuurendoutmttkngk());
                        }
                    }
                }
                else if (pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SEINENGAPPISEI_MINUS) ||
                    pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SEINENGAPPISEI_PLUS) ||
                    pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_MINUS) ||
                    pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_PLUS)){

                    SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
                        SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                    List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst =
                        srGetTokutejitenSisuurendoTmttknInfo.exec(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            null, pIdouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey(), pSvKiykSyuhnDataLst);

                    KhSisuurendoTmttknBean khSisuurendoTmttknBean =
                        srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                            BizDate.valueOf(pIdouMeisaiTyukeiyouItzHzn.getZtysrkouryokuhasseiymd()),
                            pIdouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey(),
                            srGetTokutejitenTmttknInfoBeanLst);

                    khSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();
                }
                else {
                    if ((pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SINKEIYAKUTORIKESI) &&
                        pTkJitenKeiyakuSyouhinKijyunBean.getSyoumetujiyuu().equals(C_Syoumetujiyuu.MUKOU))) {

                        List<IT_KhSisuurendoTmttkn> pKhSisuurendoTmttknLst =
                            batchDbAccess.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(
                                pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

                        khSisuurendoTmttkn = pKhSisuurendoTmttknLst.get(0);
                    }
                    else {

                        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
                            SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                        List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst =
                            srGetTokutejitenSisuurendoTmttknInfo.exec(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                                BizDate.valueOf(pIdouMeisaiTyukeiyouItzHzn.getZtysrkouryokuhasseiymd()), null, pSvKiykSyuhnDataLst);

                        KhSisuurendoTmttknBean khSisuurendoTmttknBean =
                            srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                                BizDate.valueOf(pIdouMeisaiTyukeiyouItzHzn.getZtysrkouryokuhasseiymd()),
                                null,
                                srGetTokutejitenTmttknInfoBeanLst);

                        khSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();
                    }
                }

                if((SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                    SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_MINUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                    (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                        SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_PLUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                        (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                            SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_PLUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                            (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                                SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_MINUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                                (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                                    SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_PLUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                                    (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                                        SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_MINUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                                        (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                                            SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_PLUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd()))) {

                    SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
                        SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                    List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst =
                        srGetTokutejitenSisuurendoTmttknInfo.exec(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            null, pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseihenkousikibetukey(), pSvKiykSyuhnDataLst);

                    KhSisuurendoTmttknBean khSisuurendoTmttknBean =
                        srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                            null,
                            pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseihenkousikibetukey(),
                            srGetTokutejitenTmttknInfoBeanLst);

                    khSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();
                }

                if((SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                    SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_PLUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                    (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                        SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_MINUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                        (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                            SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_MINUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd()))) {

                    SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
                        SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                    List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst =
                        srGetTokutejitenSisuurendoTmttknInfo.exec(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            null, pIdouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey(), pSvKiykSyuhnDataLst);

                    KhSisuurendoTmttknBean khSisuurendoTmttknBean =
                        srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                            null,
                            pIdouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey(),
                            srGetTokutejitenTmttknInfoBeanLst);

                    khSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

                    List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst =
                        batchDbAccess.getKhHenkouRirekis(
                            pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseihenkousikibetukey(),
                            ITKHSISUURENDOTMTTKN,
                            SISUURENDOUTMTTKNGK);

                    if(khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.size() > 0) {
                        khSisuurendoTmttkn.setSisuurendoutmttkngk(
                            BizCurrency.valueOf(new BigDecimal(khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(0).getBfrnaiyouoriginal()),
                                khSisuurendoTmttkn.getSisuurendoutmttkngk().getType())
                            );
                    }
                }

                if((SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITSRECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                    SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_MINUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                    (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                        SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_MINUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                        (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                            SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_PLUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd()))) {

                    SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
                        SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                    List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst =
                        srGetTokutejitenSisuurendoTmttknInfo.exec(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            null, pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseihenkousikibetukey(), pSvKiykSyuhnDataLst);

                    KhSisuurendoTmttknBean khSisuurendoTmttknBean =
                        srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                            null,
                            pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseihenkousikibetukey(),
                            srGetTokutejitenTmttknInfoBeanLst);

                    khSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();
                }

                if((SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITSRECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                    SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_PLUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd()))) {

                    SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
                        SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                    List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst =
                        srGetTokutejitenSisuurendoTmttknInfo.exec(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            null, pIdouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey(), pSvKiykSyuhnDataLst);

                    KhSisuurendoTmttknBean khSisuurendoTmttknBean =
                        srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                            null,
                            pIdouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey(),
                            srGetTokutejitenTmttknInfoBeanLst);

                    khSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

                    List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst =
                        batchDbAccess.getKhHenkouRirekis(
                            pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseihenkousikibetukey(),
                            ITKHSISUURENDOTMTTKN,
                            SISUURENDOUTMTTKNGK);

                    if(khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.size() > 0) {
                        khSisuurendoTmttkn.setSisuurendoutmttkngk(
                            BizCurrency.valueOf(new BigDecimal(khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(0).getNewnaiyouoriginal()),
                                khSisuurendoTmttkn.getSisuurendoutmttkngk().getType())
                            );
                    }
                }

                if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) ||
                    SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) ||
                    (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD_TMMSGO.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                        SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_MINUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                        (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD_TMMSGO.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                            SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_PLUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd()))) {
                    SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo =
                        SWAKInjector.getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                    List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst =
                        srGetTokutejitenSisuurendoTmttknInfo.exec(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            null, pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseihenkousikibetukey(), pSvKiykSyuhnDataLst);

                    KhSisuurendoTmttknBean khSisuurendoTmttknBean =
                        srGetTokutejitenSisuurendoTmttknInfo.getSisuurendoTmttknInfo(
                            BizDate.valueOf(pIdouMeisaiTyukeiyouItzHzn.getZtyhenkousyoriymd()),
                            pIdouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey(),
                            srGetTokutejitenTmttknInfoBeanLst);

                    khSisuurendoTmttkn = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

                    if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) ||
                        (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD_TMMSGO.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                            SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_MINUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                            (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD_TMMSGO.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                                SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_PLUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd()))) {
                        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst =
                            batchDbAccess.getKhHenkouRirekis(
                                pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                                pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseihenkousikibetukey(),
                                ITKHSISUURENDOTMTTKN,
                                SISUURENDOUTMTTKNGK);

                        if(khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.size() > 0) {
                            khSisuurendoTmttkn.setSisuurendoutmttkngk(
                                BizCurrency.valueOf(new BigDecimal(khHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBeanLst.get(0).getBfrnaiyouoriginal()),
                                    khSisuurendoTmttkn.getSisuurendoutmttkngk().getType())
                                );
                        }
                    }
                }
            }
        }
        else {

            List<IT_KhSisuurendoTmttkn> pKhSisuurendoTmttknLst =
                batchDbAccess.getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(
                    pSnkiykGtjSirt.getSyono(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd());

            khSisuurendoTmttkn = pKhSisuurendoTmttknLst.get(0);

        }

        return khSisuurendoTmttkn;
    }

    private void editIdouMeisai(
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn,
        ZT_RayIdouVTy pRayIdouVTy) {

        pRayIdouVTy.setZtyrecordkbn(pIdouMeisaiTyukeiyouItzHzn.getZtyrecordkbn());
        pRayIdouVTy.setZtynenkinkaisigohyouji(pIdouMeisaiTyukeiyouItzHzn.getZtynenkinkaisigohyouji());
        pRayIdouVTy.setZtynksgokurikosidhyj(pIdouMeisaiTyukeiyouItzHzn.getZtynksgokurikosidhyj());
        pRayIdouVTy.setZtykeijyouym(pIdouMeisaiTyukeiyouItzHzn.getZtykeijyouym());
        pRayIdouVTy.setZtyidojiyukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyidojiyukbn());
        pRayIdouVTy.setZtyzougenkbn(pIdouMeisaiTyukeiyouItzHzn.getZtyzougenkbn());
        pRayIdouVTy.setZtyidourecordkbn(pIdouMeisaiTyukeiyouItzHzn.getZtyidourecordkbn());
        pRayIdouVTy.setZtykeijyouctrlkbn(pIdouMeisaiTyukeiyouItzHzn.getZtykeijyouctrlkbn());
        pRayIdouVTy.setZtyhenkousyoriymd(pIdouMeisaiTyukeiyouItzHzn.getZtyhenkousyoriymd());
        pRayIdouVTy.setZtykykmfksnctr(pIdouMeisaiTyukeiyouItzHzn.getZtykykmfksnctr());
        pRayIdouVTy.setZtyrecordctr(pIdouMeisaiTyukeiyouItzHzn.getZtyrecordctr());
        pRayIdouVTy.setZtysuuriyoukouryokukaisiymd(pIdouMeisaiTyukeiyouItzHzn
            .getZtysuuriyoukouryokukaisiymd());
        pRayIdouVTy.setZtydenymd(pIdouMeisaiTyukeiyouItzHzn.getZtydenymd());
        pRayIdouVTy.setZtybluekeizokuhyouji(pIdouMeisaiTyukeiyouItzHzn.getZtybluekeizokuhyouji());
        pRayIdouVTy.setZtysuuriyouyobin1x2(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x2());
        pRayIdouVTy.setZtytoukeikeijyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtytoukeikeijyoukbn());
        pRayIdouVTy.setZtyraysystemhyj(pIdouMeisaiTyukeiyouItzHzn.getZtyraysystemhyj());
        pRayIdouVTy.setZtyzenkiidouteiseikbn(pIdouMeisaiTyukeiyouItzHzn.getZtyzenkiidouteiseikbn());
        pRayIdouVTy.setZtybsyym(pIdouMeisaiTyukeiyouItzHzn.getZtybsyym());
        pRayIdouVTy.setZtytenkangokeiyakubosyuuym(pIdouMeisaiTyukeiyouItzHzn
            .getZtytenkangokeiyakubosyuuym());
        pRayIdouVTy.setZtyidoujiyuucd(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd());
        pRayIdouVTy.setZtysyoricd(pIdouMeisaiTyukeiyouItzHzn.getZtysyoricd());
        pRayIdouVTy.setZtysekininteiseihyouji(pIdouMeisaiTyukeiyouItzHzn.getZtysekininteiseihyouji());
        pRayIdouVTy.setZtysuuriyouyobin8(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8());
        pRayIdouVTy.setZtysihankibikinkbn(pIdouMeisaiTyukeiyouItzHzn.getZtysihankibikinkbn());
        pRayIdouVTy.setZtysuuriyouyobin1x3(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x3());
        pRayIdouVTy.setZtydatakanrino(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino());
        pRayIdouVTy.setZtyhknsyukigou(pIdouMeisaiTyukeiyouItzHzn.getZtyhknsyukigou());
        pRayIdouVTy.setZtyhknsyuruikigousedaikbn(pIdouMeisaiTyukeiyouItzHzn
            .getZtyhknsyuruikigousedaikbn());
        pRayIdouVTy.setZtysotodasipmenkbn(pIdouMeisaiTyukeiyouItzHzn.getZtysotodasipmenkbn());
        pRayIdouVTy.setZtystdssytikbn(pIdouMeisaiTyukeiyouItzHzn.getZtystdssytikbn());
        pRayIdouVTy.setZtystdssnskbn(pIdouMeisaiTyukeiyouItzHzn.getZtystdssnskbn());
        pRayIdouVTy
        .setZtysotodasimanagehyouji(pIdouMeisaiTyukeiyouItzHzn.getZtysotodasimanagehyouji());
        pRayIdouVTy.setZtysotodasiphkbnmnoshyouji(pIdouMeisaiTyukeiyouItzHzn
            .getZtysotodasiphkbnmnoshyouji());
        pRayIdouVTy.setZtystdsstkjytkyuhyj(pIdouMeisaiTyukeiyouItzHzn.getZtystdsstkjytkyuhyj());
        pRayIdouVTy.setZtykbnkeiriyousegmentkbn(pIdouMeisaiTyukeiyouItzHzn
            .getZtykbnkeiriyousegmentkbn());
        pRayIdouVTy.setZtykbnkeiriyourgnbnskkbn(pIdouMeisaiTyukeiyouItzHzn
            .getZtykbnkeiriyourgnbnskkbn());
        pRayIdouVTy.setZtysuurisyuruicd(pIdouMeisaiTyukeiyouItzHzn.getZtysuurisyuruicd());
        pRayIdouVTy.setZtyhosyoukinoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyhosyoukinoukbn());
        pRayIdouVTy.setZtydaikbn(pIdouMeisaiTyukeiyouItzHzn.getZtydaikbn());
        pRayIdouVTy.setZtytyuukbn(pIdouMeisaiTyukeiyouItzHzn.getZtytyuukbn());
        pRayIdouVTy.setZtysyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysyoukbn());
        pRayIdouVTy.setZtysedaikbn(pIdouMeisaiTyukeiyouItzHzn.getZtysedaikbn());
        pRayIdouVTy.setZtyharaikatakbn(pIdouMeisaiTyukeiyouItzHzn.getZtyharaikatakbn());
        pRayIdouVTy.setZtykykymd(pIdouMeisaiTyukeiyouItzHzn.getZtykykymd());
        pRayIdouVTy.setZtyhknkkn(pIdouMeisaiTyukeiyouItzHzn.getZtyhknkkn());
        pRayIdouVTy.setZtyphrkkikn(pIdouMeisaiTyukeiyouItzHzn.getZtyphrkkikn());
        pRayIdouVTy.setZtysaimnkkykhyj(pIdouMeisaiTyukeiyouItzHzn.getZtysaimnkkykhyj());
        pRayIdouVTy.setZtyannaifuyouriyuukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyannaifuyouriyuukbn());
        pRayIdouVTy.setZtytksyuannaikykkbn(pIdouMeisaiTyukeiyouItzHzn.getZtytksyuannaikykkbn());
        pRayIdouVTy.setZtyhrkkaisuukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyhrkkaisuukbn());
        pRayIdouVTy.setZtyhrkkeirokbn(pIdouMeisaiTyukeiyouItzHzn.getZtyhrkkeirokbn());
        pRayIdouVTy.setZtysdpdkbn(pIdouMeisaiTyukeiyouItzHzn.getZtysdpdkbn());
        pRayIdouVTy.setZtyryouritukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyryouritukbn());
        pRayIdouVTy.setZtyao3tyou3sibousdatehyouji(pIdouMeisaiTyukeiyouItzHzn
            .getZtyao3tyou3sibousdatehyouji());
        pRayIdouVTy.setZtyhhknseikbn(pIdouMeisaiTyukeiyouItzHzn.getZtyhhknseikbn());
        pRayIdouVTy.setZtyhihokensyaagev2(pIdouMeisaiTyukeiyouItzHzn.getZtyhihokensyaagev2());
        pRayIdouVTy.setZtykyksyanen(pIdouMeisaiTyukeiyouItzHzn.getZtykyksyanen());
        pRayIdouVTy.setZtydai2hhknnen(pIdouMeisaiTyukeiyouItzHzn.getZtydai2hhknnen());
        pRayIdouVTy.setZtytkbthsyumnryuhyouji(pIdouMeisaiTyukeiyouItzHzn.getZtytkbthsyumnryuhyouji());
        pRayIdouVTy.setZtysyukeiyakupwaribikikbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtysyukeiyakupwaribikikbn());
        pRayIdouVTy.setZtytenkanwaribikikbn(pIdouMeisaiTyukeiyouItzHzn.getZtytenkanwaribikikbn());
        pRayIdouVTy.setZtyyuuhitutnknyuguryurtkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyyuuhitutnknyuguryurtkbn());
        pRayIdouVTy.setZtysyukeiyakup(pIdouMeisaiTyukeiyouItzHzn.getZtysyukeiyakup());
        pRayIdouVTy.setZtytokujyoup(pIdouMeisaiTyukeiyouItzHzn.getZtytokujyoup());
        pRayIdouVTy.setZtysiteizukisyukeiyakup(pIdouMeisaiTyukeiyouItzHzn.
            getZtysiteizukisyukeiyakup());
        pRayIdouVTy.setZtykihons(pIdouMeisaiTyukeiyouItzHzn.getZtykihons());
        pRayIdouVTy.setZtysibous(pIdouMeisaiTyukeiyouItzHzn.getZtysibous());
        pRayIdouVTy.setZtyhenkougokihons(pIdouMeisaiTyukeiyouItzHzn.getZtyhenkougokihons());
        pRayIdouVTy.setZtyhenkougosibous(pIdouMeisaiTyukeiyouItzHzn.getZtyhenkougosibous());
        pRayIdouVTy.setZtyhenkouymd(pIdouMeisaiTyukeiyouItzHzn.getZtyhenkouymd());
        pRayIdouVTy.setZtyentyoukikan(pIdouMeisaiTyukeiyouItzHzn.getZtyentyoukikan());
        pRayIdouVTy.setZtyseizonkyuuhukinsiteimd(pIdouMeisaiTyukeiyouItzHzn.
            getZtyseizonkyuuhukinsiteimd());
        pRayIdouVTy.setZtysyukeiyakusiharaikingaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtysyukeiyakusiharaikingaku());
        pRayIdouVTy.setZtyatukaisisyatodouhukencd(pIdouMeisaiTyukeiyouItzHzn.
            getZtyatukaisisyatodouhukencd());
        pRayIdouVTy.setZtytokuyakuhukasuu(pIdouMeisaiTyukeiyouItzHzn.getZtytokuyakuhukasuu());
        pRayIdouVTy.setZtydi2hknkknikoujihisyaage(pIdouMeisaiTyukeiyouItzHzn.
            getZtydi2hknkknikoujihisyaage());
        pRayIdouVTy.setZtyhrimnentyoumaephrkkkn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhrimnentyoumaephrkkkn());
        pRayIdouVTy.setZtytokubetuhosyoukikan(pIdouMeisaiTyukeiyouItzHzn.getZtytokubetuhosyoukikan());
        pRayIdouVTy.setZtykousinmanryouage(pIdouMeisaiTyukeiyouItzHzn.getZtykousinmanryouage());
        pRayIdouVTy.setZtyknkuzusnzyrttekitkarihyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtyknkuzusnzyrttekitkarihyj());
        pRayIdouVTy.setZtykuriagekurisagekbn(pIdouMeisaiTyukeiyouItzHzn.getZtykuriagekurisagekbn());
        pRayIdouVTy.setZtyhrizmjhknsyukigousdkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhrizmjhknsyukigousdkbn());
        pRayIdouVTy.setZtykrsgjhknsyukigousdkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtykrsgjhknsyukigousdkbn());
        pRayIdouVTy.setZtysotodasisyouhinkaiteikbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtysotodasisyouhinkaiteikbn());
        pRayIdouVTy.setZtyyobiv4(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv4());
        pRayIdouVTy.setZtygoukeitenkans(pIdouMeisaiTyukeiyouItzHzn.getZtygoukeitenkans());
        pRayIdouVTy.setZtygoukeipbubuntenkans(pIdouMeisaiTyukeiyouItzHzn.getZtygoukeipbubuntenkans());
        pRayIdouVTy.setZtytenkanteikisyuruikigou(pIdouMeisaiTyukeiyouItzHzn.
            getZtytenkanteikisyuruikigou());
        pRayIdouVTy.setZtytenkanteikikigousedaikbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtytenkanteikikigousedaikbn());
        pRayIdouVTy.setZtytnkntiksotodasikusnkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtytnkntiksotodasikusnkbn());
        pRayIdouVTy.setZtytnkntikstdspmenkbn(pIdouMeisaiTyukeiyouItzHzn.getZtytnkntikstdspmenkbn());
        pRayIdouVTy.setZtytenkanteikikigouyobi(pIdouMeisaiTyukeiyouItzHzn.
            getZtytenkanteikikigouyobi());
        pRayIdouVTy.setZtytenkanteikikikan(pIdouMeisaiTyukeiyouItzHzn.getZtytenkanteikikikan());
        pRayIdouVTy.setZtygoukeitenkanteikis(pIdouMeisaiTyukeiyouItzHzn.getZtygoukeitenkanteikis());
        pRayIdouVTy.setZtytnknteikinkshrkkn(pIdouMeisaiTyukeiyouItzHzn.getZtytnknteikinkshrkkn());
        pRayIdouVTy.setZtytenkansiharaikingaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtytenkansiharaikingaku());
        pRayIdouVTy.setZtytnkntikshrkngk(pIdouMeisaiTyukeiyouItzHzn.getZtytnkntikshrkngk());
        pRayIdouVTy.setZtytenkankaisuu(pIdouMeisaiTyukeiyouItzHzn.getZtytenkankaisuu());
        pRayIdouVTy.setZtygoukeitenkankakaku(pIdouMeisaiTyukeiyouItzHzn.getZtygoukeitenkankakaku());
        pRayIdouVTy.setZtytnknkhnbbnjyuturt(pIdouMeisaiTyukeiyouItzHzn.getZtytnknkhnbbnjyuturt());
        pRayIdouVTy.setZtywnasigoukeitenkanteikis(pIdouMeisaiTyukeiyouItzHzn.
            getZtywnasigoukeitenkanteikis());
        pRayIdouVTy.setZtytnknteikikousinmnryouage(pIdouMeisaiTyukeiyouItzHzn.
            getZtytnknteikikousinmnryouage());
        pRayIdouVTy.setZtyyobiv5(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv5());
        pRayIdouVTy.setZtykanyujidatakanrino(pIdouMeisaiTyukeiyouItzHzn.getZtykanyujidatakanrino());
        pRayIdouVTy.setZtykanyujikykymd(pIdouMeisaiTyukeiyouItzHzn.getZtykanyujikykymd());
        pRayIdouVTy.setZtykanyuujihihokensyaage(pIdouMeisaiTyukeiyouItzHzn.
            getZtykanyuujihihokensyaage());
        pRayIdouVTy.setZtykanyuujitenkanhyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtykanyuujitenkanhyouji());
        pRayIdouVTy.setZtyhsyuikktminaosikaisu(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhsyuikktminaosikaisu());
        pRayIdouVTy.setZtysknnjynbknsisnrt(pIdouMeisaiTyukeiyouItzHzn.getZtysknnjynbknsisnrt());
        pRayIdouVTy.setZtytkjykbn(pIdouMeisaiTyukeiyouItzHzn.getZtytkjykbn());
        pRayIdouVTy.setZtysakugenkikan(pIdouMeisaiTyukeiyouItzHzn.getZtysakugenkikan());
        pRayIdouVTy.setZtyryoumasihyouten(pIdouMeisaiTyukeiyouItzHzn.getZtyryoumasihyouten());
        pRayIdouVTy.setZtysykyktkjyuryumsratehyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtysykyktkjyuryumsratehyj());
        pRayIdouVTy.setZtysykyktkjyuryumsrate(pIdouMeisaiTyukeiyouItzHzn.getZtysykyktkjyuryumsrate());
        pRayIdouVTy.setZtydai2tokujyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtydai2tokujyoukbn());
        pRayIdouVTy.setZtydai2sakugenkikan(pIdouMeisaiTyukeiyouItzHzn.getZtydai2sakugenkikan());
        pRayIdouVTy.setZtydai2ryoumasihyouten(pIdouMeisaiTyukeiyouItzHzn.getZtydai2ryoumasihyouten());
        pRayIdouVTy.setZtytokuteibuijyoukenhyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtytokuteibuijyoukenhyouji());
        pRayIdouVTy.setZtytokuteibuino1(pIdouMeisaiTyukeiyouItzHzn.getZtytokuteibuino1());
        pRayIdouVTy.setZtyhtnpkkn1(pIdouMeisaiTyukeiyouItzHzn.getZtyhtnpkkn1());
        pRayIdouVTy.setZtytokuteibuino2(pIdouMeisaiTyukeiyouItzHzn.getZtytokuteibuino2());
        pRayIdouVTy.setZtyhtnpkkn2(pIdouMeisaiTyukeiyouItzHzn.getZtyhtnpkkn2());
        pRayIdouVTy.setZtymhituiryuyutktbijyknhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtymhituiryuyutktbijyknhyj());
        pRayIdouVTy.setZtymuhaitouiryouyoutktbino1(pIdouMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyoutktbino1());
        pRayIdouVTy.setZtymuhaitouiryouyouhtnpkkn1(pIdouMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyouhtnpkkn1());
        pRayIdouVTy.setZtymuhaitouiryouyoutktbino2(pIdouMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyoutktbino2());
        pRayIdouVTy.setZtymuhaitouiryouyouhtnpkkn2(pIdouMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyouhtnpkkn2());
        pRayIdouVTy.setZtysiteizukipwarimasihyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtysiteizukipwarimasihyouji());
        pRayIdouVTy.setZtypwarimasisiteim1(pIdouMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim1());
        pRayIdouVTy.setZtypwarimasisiteim2(pIdouMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim2());
        pRayIdouVTy.setZtysiteimsykykpbairitu(pIdouMeisaiTyukeiyouItzHzn.getZtysiteimsykykpbairitu());
        pRayIdouVTy.setZtysaisyuusiteiym(pIdouMeisaiTyukeiyouItzHzn.getZtysaisyuusiteiym());
        pRayIdouVTy.setZtysykykkitmttvkeisanym(pIdouMeisaiTyukeiyouItzHzn.
            getZtysykykkitmttvkeisanym());
        pRayIdouVTy.setZtysykykkitmttsknnjynbkngk(pIdouMeisaiTyukeiyouItzHzn.
            getZtysykykkitmttsknnjynbkngk());
        pRayIdouVTy.setZtydftumitatekingaku(pIdouMeisaiTyukeiyouItzHzn.getZtydftumitatekingaku());
        pRayIdouVTy.setZtydftumimasikin(pIdouMeisaiTyukeiyouItzHzn.getZtydftumimasikin());
        pRayIdouVTy.setZtyvbubundftenkankakaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtyvbubundftenkankakaku());
        pRayIdouVTy.setZtydpbubundftenkankakaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtydpbubundftenkankakaku());
        pRayIdouVTy.setZtydftmttkngkitjbrbbn(pIdouMeisaiTyukeiyouItzHzn.getZtydftmttkngkitjbrbbn());
        pRayIdouVTy.setZtyhendous(pIdouMeisaiTyukeiyouItzHzn.getZtyhendous());
        pRayIdouVTy.setZtyhengakujigyounendomatucv(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhengakujigyounendomatucv());
        pRayIdouVTy.setZtyitibuitijibarais(pIdouMeisaiTyukeiyouItzHzn.getZtyitibuitijibarais());
        pRayIdouVTy.setZtyitibuitijibaraip(pIdouMeisaiTyukeiyouItzHzn.getZtyitibuitijibaraip());
        pRayIdouVTy.setZtyitibitjbrshrkngk(pIdouMeisaiTyukeiyouItzHzn.getZtyitibitjbrshrkngk());
        pRayIdouVTy.setZtygoukeicv(pIdouMeisaiTyukeiyouItzHzn.getZtygoukeicv());
        pRayIdouVTy.setZtyminasicv(pIdouMeisaiTyukeiyouItzHzn.getZtyminasicv());
        pRayIdouVTy.setZtyloanfund(pIdouMeisaiTyukeiyouItzHzn.getZtyloanfund());
        pRayIdouVTy.setZtysaiteihosyougaku(pIdouMeisaiTyukeiyouItzHzn.getZtysaiteihosyougaku());
        pRayIdouVTy.setZtyhngksitihsyuyusykykp(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhngksitihsyuyusykykp());
        pRayIdouVTy.setZtyhijynbrivasbujsitihsyugk(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhijynbrivasbujsitihsyugk());
        pRayIdouVTy.setZtyhijynbrivamnkjsitihsyugk(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhijynbrivamnkjsitihsyugk());
        pRayIdouVTy.setZtysiinkbn(pIdouMeisaiTyukeiyouItzHzn.getZtysiinkbn());
        pRayIdouVTy.setZtymudkaimasikihons(pIdouMeisaiTyukeiyouItzHzn.getZtymudkaimasikihons());
        pRayIdouVTy.setZtykaimasiymd(pIdouMeisaiTyukeiyouItzHzn.getZtykaimasiymd());
        pRayIdouVTy.setZtykaimasikikan(pIdouMeisaiTyukeiyouItzHzn.getZtykaimasikikan());
        pRayIdouVTy.setZtyhikitugikaimasis(pIdouMeisaiTyukeiyouItzHzn.getZtyhikitugikaimasis());
        pRayIdouVTy.setZtymudkaimasisiharaikingaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtymudkaimasisiharaikingaku());
        pRayIdouVTy.setZtyszoukouryokukaisiymdx1(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszoukouryokukaisiymdx1());
        pRayIdouVTy.setZtyszouhokensyuruikigoux1(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszouhokensyuruikigoux1());
        pRayIdouVTy.setZtyszoukigousedaikbnx1(pIdouMeisaiTyukeiyouItzHzn.getZtyszoukigousedaikbnx1());
        pRayIdouVTy.setZtyszoukikanx1(pIdouMeisaiTyukeiyouItzHzn.getZtyszoukikanx1());
        pRayIdouVTy.setZtyszouhihokensyaagex1(pIdouMeisaiTyukeiyouItzHzn.getZtyszouhihokensyaagex1());
        pRayIdouVTy.setZtyszoudai2hihknsyaagex1(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszoudai2hihknsyaagex1());
        pRayIdouVTy.setZtyzoukasx1(pIdouMeisaiTyukeiyouItzHzn.getZtyzoukasx1());
        pRayIdouVTy.setZtyzennendozoukasx1(pIdouMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx1());
        pRayIdouVTy.setZtyszousiharaikingakux1(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszousiharaikingakux1());
        pRayIdouVTy.setZtyszoukouryokukaisiymdx2(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszoukouryokukaisiymdx2());
        pRayIdouVTy.setZtyszouhokensyuruikigoux2(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszouhokensyuruikigoux2());
        pRayIdouVTy.setZtyszoukigousedaikbnx2(pIdouMeisaiTyukeiyouItzHzn.getZtyszoukigousedaikbnx2());
        pRayIdouVTy.setZtyszoukikanx2(pIdouMeisaiTyukeiyouItzHzn.getZtyszoukikanx2());
        pRayIdouVTy.setZtyszouhihokensyaagex2(pIdouMeisaiTyukeiyouItzHzn.getZtyszouhihokensyaagex2());
        pRayIdouVTy.setZtyszoudai2hihknsyaagex2(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszoudai2hihknsyaagex2());
        pRayIdouVTy.setZtyzoukasx2(pIdouMeisaiTyukeiyouItzHzn.getZtyzoukasx2());
        pRayIdouVTy.setZtyzennendozoukasx2(pIdouMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx2());
        pRayIdouVTy.setZtyszousiharaikingakux2(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszousiharaikingakux2());
        pRayIdouVTy.setZtysuuriyouyobin1x5(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x5());
        pRayIdouVTy.setZtysuuriyouyobin1x6(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x6());
        pRayIdouVTy.setZtyhrimngkizktkykpmenhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhrimngkizktkykpmenhyj());
        pRayIdouVTy.setZtymisyuustartym(pIdouMeisaiTyukeiyouItzHzn.getZtymisyuustartym());
        pRayIdouVTy.setZtymisyuukaisuu(pIdouMeisaiTyukeiyouItzHzn.getZtymisyuukaisuu());
        pRayIdouVTy.setZtyitjbrtkykkousnuktkarhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtyitjbrtkykkousnuktkarhyj());
        pRayIdouVTy.setZtygyousekihyoujis(pIdouMeisaiTyukeiyouItzHzn.getZtygyousekihyoujis());
        pRayIdouVTy.setZtysykykgyusekihyjs(pIdouMeisaiTyukeiyouItzHzn.getZtysykykgyusekihyjs());
        pRayIdouVTy.setZtytenkangyousekihyoujis(pIdouMeisaiTyukeiyouItzHzn.
            getZtytenkangyousekihyoujis());
        pRayIdouVTy.setZtytnknteikigyousekihyjs(pIdouMeisaiTyukeiyouItzHzn.
            getZtytnknteikigyousekihyjs());
        pRayIdouVTy.setZtytnkndpbbngyuskhyjs(pIdouMeisaiTyukeiyouItzHzn.getZtytnkndpbbngyuskhyjs());
        pRayIdouVTy.setZtykykjyoutai(pIdouMeisaiTyukeiyouItzHzn.getZtykykjyoutai());
        pRayIdouVTy.setZtypmenhukakbn(pIdouMeisaiTyukeiyouItzHzn.getZtypmenhukakbn());
        pRayIdouVTy.setZtykousinkbn(pIdouMeisaiTyukeiyouItzHzn.getZtykousinkbn());
        pRayIdouVTy.setZtymankiyoteikbn(pIdouMeisaiTyukeiyouItzHzn.getZtymankiyoteikbn());
        pRayIdouVTy.setZtysykyktikmnkyoteikbn(pIdouMeisaiTyukeiyouItzHzn.getZtysykyktikmnkyoteikbn());
        pRayIdouVTy.setZtytnknsykykkhnmnkytikbn(pIdouMeisaiTyukeiyouItzHzn
            .getZtytnknsykykkhnmnkytikbn());
        pRayIdouVTy.setZtytnknsykyktikmnkytikbn(pIdouMeisaiTyukeiyouItzHzn
            .getZtytnknsykyktikmnkytikbn());
        pRayIdouVTy.setZtytenkanteikimankiyoteikbn(pIdouMeisaiTyukeiyouItzHzn
            .getZtytenkanteikimankiyoteikbn());
        pRayIdouVTy.setZtyszoumankiyoteikbnx1(pIdouMeisaiTyukeiyouItzHzn.getZtyszoumankiyoteikbnx1());
        pRayIdouVTy.setZtyszoumankiyoteikbnx2(pIdouMeisaiTyukeiyouItzHzn.getZtyszoumankiyoteikbnx2());
        pRayIdouVTy
        .setZtyvestingmankiyoteikbn(pIdouMeisaiTyukeiyouItzHzn.getZtyvestingmankiyoteikbn());
        pRayIdouVTy.setZtyvkeisanhyouji(pIdouMeisaiTyukeiyouItzHzn.getZtyvkeisanhyouji());
        pRayIdouVTy.setZtytoukisinkeiyakuhyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtytoukisinkeiyakuhyouji());
        pRayIdouVTy.setZtysykykhokenhoutekiyouhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtysykykhokenhoutekiyouhyj());
        pRayIdouVTy.setZtytokuteijyoutaihushrhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtytokuteijyoutaihushrhyj());
        pRayIdouVTy.setZtyytirrthndsysnmnskaisuu(pIdouMeisaiTyukeiyouItzHzn.
            getZtyytirrthndsysnmnskaisuu());
        pRayIdouVTy.setZtysuuriyouyobin3(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin3());
        pRayIdouVTy.setZtysuuriyouyobin11(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin11());
        pRayIdouVTy.setZtywnasigoukeitenkankakaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtywnasigoukeitenkankakaku());
        pRayIdouVTy.setZtyyobin11(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11());
        pRayIdouVTy.setZtyyobin11x2(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x2());
        pRayIdouVTy.setZtyyobin11x3(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x3());
        pRayIdouVTy.setZtytukibaraikansantokujyoup(pIdouMeisaiTyukeiyouItzHzn.
            getZtytukibaraikansantokujyoup());
        pRayIdouVTy.setZtytnkngkykkssnkijyuym(pIdouMeisaiTyukeiyouItzHzn.getZtytnkngkykkssnkijyuym());
        pRayIdouVTy.setZtysaiteihosyouhyouji(pIdouMeisaiTyukeiyouItzHzn.getZtysaiteihosyouhyouji());
        pRayIdouVTy.setZtysuuriyouyobin8x2(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8x2());
        pRayIdouVTy.setZtysuuriyouyobin14(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin14());
        pRayIdouVTy.setZtyhrimngtkykphrkkaisuukbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhrimngtkykphrkkaisuukbn());
        pRayIdouVTy.setZtyhrimngtkykphrkkirkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhrimngtkykphrkkirkbn());
        pRayIdouVTy.setZtyhrimngtkykpryurtkbn(pIdouMeisaiTyukeiyouItzHzn.getZtyhrimngtkykpryurtkbn());
        pRayIdouVTy.setZtyyobiv13(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv13());
        pRayIdouVTy.setZtyidoujisaiteihosyoukngk(pIdouMeisaiTyukeiyouItzHzn.
            getZtyidoujisaiteihosyoukngk());
        pRayIdouVTy.setZtyidoujisaiteihosyoucost(pIdouMeisaiTyukeiyouItzHzn.
            getZtyidoujisaiteihosyoucost());
        pRayIdouVTy.setZtysinhokenfundtumitatekin(pIdouMeisaiTyukeiyouItzHzn.
            getZtysinhokenfundtumitatekin());
        pRayIdouVTy.setZtymsyuptusshkgkaiykhnrikn(pIdouMeisaiTyukeiyouItzHzn.
            getZtymsyuptusshkgkaiykhnrikn());
        pRayIdouVTy.setZtyrrthndugtnkgetumatuv(pIdouMeisaiTyukeiyouItzHzn.
            getZtyrrthndugtnkgetumatuv());
        pRayIdouVTy.setZtyrrthndnksaiteihosyonkgns(pIdouMeisaiTyukeiyouItzHzn.
            getZtyrrthndnksaiteihosyonkgns());
        pRayIdouVTy.setZtyrrthendougatanksibous(pIdouMeisaiTyukeiyouItzHzn.
            getZtyrrthendougatanksibous());
        pRayIdouVTy.setZtyalmyousohutomeisyoukbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyalmyousohutomeisyoukbn());
        pRayIdouVTy.setZtysnkyksoftmeisyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysnkyksoftmeisyoukbn());
        pRayIdouVTy.setZtysoftmeisyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysoftmeisyoukbn());
        pRayIdouVTy.setZtykykjitokujyouarihyj(pIdouMeisaiTyukeiyouItzHzn.getZtykykjitokujyouarihyj());
        pRayIdouVTy.setZtybnkttnknkbn(pIdouMeisaiTyukeiyouItzHzn.getZtybnkttnknkbn());
        pRayIdouVTy.setZtytenkanminaosikbn(pIdouMeisaiTyukeiyouItzHzn.getZtytenkanminaosikbn());
        pRayIdouVTy.setZtysoujikeitenkankbn(pIdouMeisaiTyukeiyouItzHzn.getZtysoujikeitenkankbn());
        pRayIdouVTy.setZtynenkinkaisinendo(pIdouMeisaiTyukeiyouItzHzn.getZtynenkinkaisinendo());
        pRayIdouVTy.setZtynenkingatakbn(pIdouMeisaiTyukeiyouItzHzn.getZtynenkingatakbn());
        pRayIdouVTy.setZtynknshry(pIdouMeisaiTyukeiyouItzHzn.getZtynknshry());
        pRayIdouVTy.setZtyheiyoubaraikeiyakukbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyheiyoubaraikeiyakukbn());
        pRayIdouVTy.setZtynenkinmaruteihukakbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtynenkinmaruteihukakbn());
        pRayIdouVTy.setZtysinseizonmrtiarihyj(pIdouMeisaiTyukeiyouItzHzn.getZtysinseizonmrtiarihyj());
        pRayIdouVTy.setZtysnkykyouibokijyukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysnkykyouibokijyukbn());
        pRayIdouVTy.setZtytokusitujyuusitusetkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtytokusitujyuusitusetkbn());
        pRayIdouVTy.setZtysiktsyuknbyugnhsyunshyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtysiktsyuknbyugnhsyunshyj());
        pRayIdouVTy.setZtypmensugugtganhsyunshyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtypmensugugtganhsyunshyj());
        pRayIdouVTy.setZtytkykgyousekihyjszerohyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtytkykgyousekihyjszerohyj());
        pRayIdouVTy.setZtysuuriyouyobin7(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin7());
        pRayIdouVTy.setZtysyussaikeitaikbn(pIdouMeisaiTyukeiyouItzHzn.getZtysyussaikeitaikbn());
        pRayIdouVTy.setZtyyobiv6(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv6());
        pRayIdouVTy.setZtybosyuukeitaikbn(pIdouMeisaiTyukeiyouItzHzn.getZtybosyuukeitaikbn());
        pRayIdouVTy.setZtyaatukaisosikicd(pIdouMeisaiTyukeiyouItzHzn.getZtyaatukaisosikicd());
        pRayIdouVTy.setZtyaatukaikojincd(pIdouMeisaiTyukeiyouItzHzn.getZtyaatukaikojincd());
        pRayIdouVTy.setZtybsydrtencd(pIdouMeisaiTyukeiyouItzHzn.getZtybsydrtencd());
        pRayIdouVTy.setZtycifcd(pIdouMeisaiTyukeiyouItzHzn.getZtycifcd());
        pRayIdouVTy.setZtysuuriyouyobiv8(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobiv8());
        pRayIdouVTy.setZtysinsakbn(pIdouMeisaiTyukeiyouItzHzn.getZtysinsakbn());
        pRayIdouVTy.setZtydai2hihokensyasinsakbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtydai2hihokensyasinsakbn());
        pRayIdouVTy.setZtytoukeiyousinsakbn(pIdouMeisaiTyukeiyouItzHzn.getZtytoukeiyousinsakbn());
        pRayIdouVTy.setZtydai2toukeiyousinsakbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtydai2toukeiyousinsakbn());
        pRayIdouVTy.setZtyketteikijyunkanwakbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyketteikijyunkanwakbn());
        pRayIdouVTy.setZtykihonsibouhyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtykihonsibouhyoukbn());
        pRayIdouVTy.setZtyteikisibouhyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyteikisibouhyoukbn());
        pRayIdouVTy.setZtysonotasibouhyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysonotasibouhyoukbn());
        pRayIdouVTy.setZtymrarihyj(pIdouMeisaiTyukeiyouItzHzn.getZtymrarihyj());
        pRayIdouVTy.setZtysentakujyouhouarihyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtysentakujyouhouarihyouji());
        pRayIdouVTy.setZtydugktnknsntkhuhukbn(pIdouMeisaiTyukeiyouItzHzn.getZtydugktnknsntkhuhukbn());
        pRayIdouVTy.setZtygengakutenkankykhyj(pIdouMeisaiTyukeiyouItzHzn.getZtygengakutenkankykhyj());
        pRayIdouVTy.setZtysykgycd(pIdouMeisaiTyukeiyouItzHzn.getZtysykgycd());
        pRayIdouVTy.setZtyjidoukousinkykkanyuuymd(pIdouMeisaiTyukeiyouItzHzn.
            getZtyjidoukousinkykkanyuuymd());
        pRayIdouVTy.setZtysaikohtnknkykkykymd(pIdouMeisaiTyukeiyouItzHzn.getZtysaikohtnknkykkykymd());
        pRayIdouVTy.setZtykousinmaesykyksburtkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtykousinmaesykyksburtkbn());
        pRayIdouVTy.setZtyhjnkykhyj(pIdouMeisaiTyukeiyouItzHzn.getZtyhjnkykhyj());
        pRayIdouVTy.setZtyanniskcd(pIdouMeisaiTyukeiyouItzHzn.getZtyanniskcd());
        pRayIdouVTy.setZtyhjncd(pIdouMeisaiTyukeiyouItzHzn.getZtyhjncd());
        pRayIdouVTy.setZtyhjnjigyosyocd(pIdouMeisaiTyukeiyouItzHzn.getZtyhjnjigyosyocd());
        pRayIdouVTy.setZtysaihokenno(pIdouMeisaiTyukeiyouItzHzn.getZtysaihokenno());
        pRayIdouVTy.setZtydakuhikettikekkacd(pIdouMeisaiTyukeiyouItzHzn.getZtydakuhikettikekkacd());
        pRayIdouVTy.setZtydai2dakuhiketteikekkacd(pIdouMeisaiTyukeiyouItzHzn.
            getZtydai2dakuhiketteikekkacd());
        pRayIdouVTy.setZtypmenkbnv2(pIdouMeisaiTyukeiyouItzHzn.getZtypmenkbnv2());
        pRayIdouVTy.setZtysiboukyuuhukin(pIdouMeisaiTyukeiyouItzHzn.getZtysiboukyuuhukin());
        pRayIdouVTy.setZtyjyudthumeharaitkykhkhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtyjyudthumeharaitkykhkhyj());
        pRayIdouVTy.setZtyhaitoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyhaitoukbn());
        pRayIdouVTy.setZtyhhknnentysihyj(pIdouMeisaiTyukeiyouItzHzn.getZtyhhknnentysihyj());
        pRayIdouVTy.setZtydai2hhknnentysihyj(pIdouMeisaiTyukeiyouItzHzn.getZtydai2hhknnentysihyj());
        pRayIdouVTy.setZtykyksyaagetyouseihyj(pIdouMeisaiTyukeiyouItzHzn.getZtykyksyaagetyouseihyj());
        pRayIdouVTy.setZtykituenkbn(pIdouMeisaiTyukeiyouItzHzn.getZtykituenkbn());
        pRayIdouVTy.setZtykituenhonsuu(pIdouMeisaiTyukeiyouItzHzn.getZtykituenhonsuu());
        pRayIdouVTy.setZtymusentakukeiyakukbn(pIdouMeisaiTyukeiyouItzHzn.getZtymusentakukeiyakukbn());
        pRayIdouVTy.setZtyyobiv6x2(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv6x2());
        pRayIdouVTy.setZtylivingneedstkykarihyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtylivingneedstkykarihyj());
        pRayIdouVTy.setZtylivingneedssiharaihyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtylivingneedssiharaihyouji());
        pRayIdouVTy.setZtylnseikyuuymd(pIdouMeisaiTyukeiyouItzHzn.getZtylnseikyuuymd());
        pRayIdouVTy.setZtylnshrgenincd(pIdouMeisaiTyukeiyouItzHzn.getZtylnshrgenincd());
        pRayIdouVTy.setZtydakuhikettisyacd(pIdouMeisaiTyukeiyouItzHzn.getZtydakuhikettisyacd());
        pRayIdouVTy.setZtydai2dakuhiketteisyacd(pIdouMeisaiTyukeiyouItzHzn.
            getZtydai2dakuhiketteisyacd());
        pRayIdouVTy.setZtygansapotokuyakuarihyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtygansapotokuyakuarihyouji());
        pRayIdouVTy.setZtygnspshrhyj(pIdouMeisaiTyukeiyouItzHzn.getZtygnspshrhyj());
        pRayIdouVTy.setZtygansaposeikyuuymd(pIdouMeisaiTyukeiyouItzHzn.getZtygansaposeikyuuymd());
        pRayIdouVTy.setZtygnspshrgenincd(pIdouMeisaiTyukeiyouItzHzn.getZtygnspshrgenincd());
        pRayIdouVTy.setZtyyobiv3x2(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv3x2());
        pRayIdouVTy.setZtytargetmokuhyouritu(pIdouMeisaiTyukeiyouItzHzn.getZtytargetmokuhyouritu());
        pRayIdouVTy.setZtyautoswitchmokuhyouritu(pIdouMeisaiTyukeiyouItzHzn.
            getZtyautoswitchmokuhyouritu());
        pRayIdouVTy.setZtytumitatekinitenarihyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtytumitatekinitenarihyj());
        pRayIdouVTy.setZtytumitatekinitenkaisuu(pIdouMeisaiTyukeiyouItzHzn.
            getZtytumitatekinitenkaisuu());
        pRayIdouVTy.setZtydatakanrino2(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino2());
        pRayIdouVTy.setZtydatakanrino3(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino3());
        pRayIdouVTy.setZtyknkuzusnzyrttekinendo(pIdouMeisaiTyukeiyouItzHzn.
            getZtyknkuzusnzyrttekinendo());
        pRayIdouVTy.setZtyknkuzusnzyrt(pIdouMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrt());
        pRayIdouVTy.setZtyknkuzusnzyrtx2(pIdouMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx2());
        pRayIdouVTy.setZtyknkuzusnzyrtx3(pIdouMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx3());
        pRayIdouVTy.setZtysinkeiyakujiknkuzusnzyrt(pIdouMeisaiTyukeiyouItzHzn.
            getZtysinkeiyakujiknkuzusnzyrt());
        pRayIdouVTy.setZtytenkanjiknkuzusnzyrt(pIdouMeisaiTyukeiyouItzHzn.
            getZtytenkanjiknkuzusnzyrt());
        pRayIdouVTy.setZtysinkeiyakujivithkhyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtysinkeiyakujivithkhyouji());
        pRayIdouVTy.setZtykykjivithukusuukykhyj(pIdouMeisaiTyukeiyouItzHzn.getZtykykjivithukusuukykhyj());
        pRayIdouVTy.setZtysuuriyouyobin9x2(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9x2());
        pRayIdouVTy.setZtypwrbksidhitekiyouhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtypwrbksidhitekiyouhyj());
        pRayIdouVTy.setZtysuuriyouyobin9(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9());
        pRayIdouVTy.setZtysuuriyouyobin10x7(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x7());
        pRayIdouVTy.setZtysuuriyouyobin10x8(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x8());
        pRayIdouVTy.setZtysuuriyouyobin10x9(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x9());
        pRayIdouVTy.setZtytumitatekinitenbubun(pIdouMeisaiTyukeiyouItzHzn.
            getZtytumitatekinitenbubun());
        pRayIdouVTy.setZtysagakusknnjynbknzndk(pIdouMeisaiTyukeiyouItzHzn.
            getZtysagakusknnjynbknzndk());
        pRayIdouVTy.setZtyyobin11x5(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x5());
        pRayIdouVTy.setZtyyobin11x6(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x6());
        pRayIdouVTy.setZtyyobin11x7(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x7());
        pRayIdouVTy.setZtyyobin11x8(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x8());
        pRayIdouVTy.setZtyyobin11x9(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x9());
        pRayIdouVTy.setZtyyobin11x10(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x10());
        pRayIdouVTy.setZtyyobin11x11(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x11());
        pRayIdouVTy.setZtyyobin11x12(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x12());
        pRayIdouVTy.setZtyyobin11x13(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x13());
        pRayIdouVTy.setZtyyobin11x14(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x14());
        pRayIdouVTy.setZtyyobin11x15(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x15());
        pRayIdouVTy.setZtyyobin11x16(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x16());
        pRayIdouVTy.setZtyyobin11x17(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x17());
        pRayIdouVTy.setZtyzyrthntiyustatuskbn(pIdouMeisaiTyukeiyouItzHzn.getZtyzyrthntiyustatuskbn());
        pRayIdouVTy.setZtyzyrthntiyustatuskbnx2(pIdouMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx2());
        pRayIdouVTy.setZtyzyrthntiyustatuskbnx3(pIdouMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx3());
        pRayIdouVTy.setZtyzyrthntiyustatuskbnx4(pIdouMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx4());
        pRayIdouVTy.setZtyzyrthntiyustatuskbnx5(pIdouMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx5());
        pRayIdouVTy.setZtyyobiv10(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv10());
        pRayIdouVTy.setZtyyobiv15x2(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv15x2());
        pRayIdouVTy.setZtyyobiv15x3(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv15x3());
        pRayIdouVTy.setZtyyobiv15x4(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv15x4());
        pRayIdouVTy.setZtygaikakbn(pIdouMeisaiTyukeiyouItzHzn.getZtygaikakbn());
        pRayIdouVTy.setZtykawaserate1(pIdouMeisaiTyukeiyouItzHzn.getZtykawaserate1());
        pRayIdouVTy.setZtykawaseratetekiyouymd1(pIdouMeisaiTyukeiyouItzHzn.
            getZtykawaseratetekiyouymd1());
        pRayIdouVTy.setZtykawaserate2(pIdouMeisaiTyukeiyouItzHzn.getZtykawaserate2());
        pRayIdouVTy.setZtykawaseratetekiyouymd2(pIdouMeisaiTyukeiyouItzHzn.
            getZtykawaseratetekiyouymd2());
        pRayIdouVTy.setZtykykjikawaserate(pIdouMeisaiTyukeiyouItzHzn.getZtykykjikawaserate());
        pRayIdouVTy.setZtykykjikawaseratetkyuymd(pIdouMeisaiTyukeiyouItzHzn.
            getZtykykjikawaseratetkyuymd());
        pRayIdouVTy.setZtymvatyouseigow(pIdouMeisaiTyukeiyouItzHzn.getZtymvatyouseigow());
        pRayIdouVTy.setZtymvakeisanjisknnjynbkn(pIdouMeisaiTyukeiyouItzHzn.
            getZtymvakeisanjisknnjynbkn());
        pRayIdouVTy.setZtykaiyakukoujyoritu(pIdouMeisaiTyukeiyouItzHzn.getZtykaiyakukoujyoritu());
        pRayIdouVTy.setZtyrendouritu(pIdouMeisaiTyukeiyouItzHzn.getZtyrendouritu());
        pRayIdouVTy.setZtysrkaiyakusjkkktyouseirrt(pIdouMeisaiTyukeiyouItzHzn.
            getZtysrkaiyakusjkkktyouseirrt());
        pRayIdouVTy.setZtysrkyksjkkktyouseiriritu(pIdouMeisaiTyukeiyouItzHzn.
            getZtysrkyksjkkktyouseiriritu());
        pRayIdouVTy.setZtymvakeisankijyunymd(pIdouMeisaiTyukeiyouItzHzn.getZtymvakeisankijyunymd());
        pRayIdouVTy.setZtymvatyouseikou(pIdouMeisaiTyukeiyouItzHzn.getZtymvatyouseikou());
        pRayIdouVTy.setZtyenkdtsbujsitihsyukngk(pIdouMeisaiTyukeiyouItzHzn.
            getZtyenkdtsbujsitihsyukngk());
        pRayIdouVTy.setZtyenkdtsbujsitihsyucost(pIdouMeisaiTyukeiyouItzHzn.
            getZtyenkdtsbujsitihsyucost());
        pRayIdouVTy.setZtyenkdtsbujsitihsyuarihyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtyenkdtsbujsitihsyuarihyj());
        pRayIdouVTy.setZtykeiyakujiyoteiriritu(pIdouMeisaiTyukeiyouItzHzn.
            getZtykeiyakujiyoteiriritu());
        pRayIdouVTy.setZtytumitateriritu(pIdouMeisaiTyukeiyouItzHzn.getZtytumitateriritu());
        pRayIdouVTy.setZtykaigomaebaraitkykarihyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtykaigomaebaraitkykarihyj());
        pRayIdouVTy.setZtysibouhyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysibouhyoukbn());
        pRayIdouVTy.setZtynyuukintuukakbn(pIdouMeisaiTyukeiyouItzHzn.getZtynyuukintuukakbn());
        pRayIdouVTy.setZtysiharaituukakbn(pIdouMeisaiTyukeiyouItzHzn.getZtysiharaituukakbn());
        pRayIdouVTy.setZtywyendttargetmokuhyouritu(pIdouMeisaiTyukeiyouItzHzn.
            getZtywyendttargetmokuhyouritu());
        pRayIdouVTy.setZtysisuurendourate(pIdouMeisaiTyukeiyouItzHzn.getZtysisuurendourate());
        pRayIdouVTy.setZtysisuukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysisuukbn());
        pRayIdouVTy.setZtyteirituikouhyouji(pIdouMeisaiTyukeiyouItzHzn.getZtyteirituikouhyouji());
        pRayIdouVTy.setZtysrdai1hknkkn(pIdouMeisaiTyukeiyouItzHzn.getZtysrdai1hknkkn());
        pRayIdouVTy.setZtysuuriyouyobin10x11(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x11());
        pRayIdouVTy.setZtytmttknzoukaritujygn(pIdouMeisaiTyukeiyouItzHzn.getZtytmttknzoukaritujygn());
        pRayIdouVTy.setZtysetteibairitu(pIdouMeisaiTyukeiyouItzHzn.getZtysetteibairitu());
        pRayIdouVTy.setZtytykzenoutouymdsisuu(pIdouMeisaiTyukeiyouItzHzn.getZtytykzenoutouymdsisuu());
        pRayIdouVTy.setZtykimatusisuu(pIdouMeisaiTyukeiyouItzHzn.getZtykimatusisuu());
        pRayIdouVTy.setZtytuukasyukbn(pIdouMeisaiTyukeiyouItzHzn.getZtytuukasyukbn());
        pRayIdouVTy.setZtyyobiv2(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv2());
        pRayIdouVTy.setZtyyenkadatekihons(pIdouMeisaiTyukeiyouItzHzn.getZtyyenkadatekihons());
        pRayIdouVTy.setZtysitihsyumegkdtsibous(pIdouMeisaiTyukeiyouItzHzn.
            getZtysitihsyumegkdtsibous());
        pRayIdouVTy.setZtyenkdtssrentumitatekin(pIdouMeisaiTyukeiyouItzHzn.
            getZtyenkdtssrentumitatekin());
        pRayIdouVTy.setZtysisuurentumitatekin(pIdouMeisaiTyukeiyouItzHzn.getZtysisuurentumitatekin());
        pRayIdouVTy.setZtynksjitirttumitatekin(pIdouMeisaiTyukeiyouItzHzn.
            getZtynksjitirttumitatekin());
        pRayIdouVTy.setZtykimatutirttumitatekin(pIdouMeisaiTyukeiyouItzHzn.
            getZtykimatutirttumitatekin());
        pRayIdouVTy.setZtygaikadatejyuutoup(pIdouMeisaiTyukeiyouItzHzn.getZtygaikadatejyuutoup());
        pRayIdouVTy.setZtyyendttargetkijyunkingaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtyyendttargetkijyunkingaku());
        pRayIdouVTy.setZtyyobiv7(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv7());
        pRayIdouVTy.setZtysitivkisnyukykjikwsrate(pIdouMeisaiTyukeiyouItzHzn.
            getZtysitivkisnyukykjikwsrate());
        pRayIdouVTy.setZtysisuurentyokugotmttkn(pIdouMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());
        pRayIdouVTy.setZtyrrthnduhknvkisovkisnyu1(pIdouMeisaiTyukeiyouItzHzn.getZtyrrthnduhknvkisovkisnyu1());
    }

    public void editSkeiKoumoku(
        SrRayIdouVBatchParam pSrRayIdouVBatchParam,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SV_SnkiykGtjSirt pSnkiykGtjSirt,
        IT_KykKihon pKykKihon,
        BM_SyouhnZokusei pSyouhnZokusei,
        IT_KykDairiten pKykDairiten,
        IT_NyknJissekiRireki pNyknJissekiRireki,
        IT_ItekiToukeiInfo pItekiToukeiInfo,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn,
        ZT_RayIdouVTy pRayIdouVTy) {

        SrRayIdouVBatchDbAccess batchDbAccess =
            SWAKInjector.getInstance(SrRayIdouVBatchDbAccess.class);
        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);
        KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd =
            SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

        String kbnkeiriyousegmentKbn = "";
        String kbnkeiriyourgnbnskKbn = "";
        String suuriSyuruiCd = "";
        C_SyouKbn syouKbn = C_SyouKbn.BLNK;
        String sedaiKbn = "";
        String saimnkKykhyj = "";
        String kyksyanenTyouseigo = "";
        String nenkinkaisiNendo = "";
        String nenkingataKbn = "";
        String bosyuukeitaiKbn = "";
        String haitouKbn = "";
        String hhknnenTysihyj = "";
        String kyksyaageTyouseihyj = "";
        String gaikaKbn = "";
        BizNumber kawaserate2 = BizNumber.valueOf(0);
        String kawaserateTekiyouymd2 = "";
        BizNumber kykjiKawaserate = BizNumber.valueOf(0);
        String kykjiKawaserateTkyuymd = "";
        BizNumber rendouRitu = BizNumber.valueOf(0);
        BizNumber srKaiyakuSjkkktyouseirrt = BizNumber.valueOf(0);
        String sibouhyouKbn = "";
        String nyuukintuukaKbn = "";
        String wyendttargetMokuhyouritu = "";
        String sisuuKbn = "";
        String tuukasyuruiKbn = "";
        BizCurrency nksjitirtTumitatekin = BizCurrency.valueOf(0);
        Long yendttargetKijyunkingaku = Long.valueOf(0);

        int syouhinUtilResult = SyouhinUtil.hantei(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu());

        if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {

            String msg = MessageUtil.getMessage(MessageId.ESA1007,
                SrCommonConstants.MSGHYOUJIMOJIRETU_SEGCD,
                pSnkiykGtjSirt.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {
            kbnkeiriyousegmentKbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(0, 2);
            kbnkeiriyourgnbnskKbn = syouhinbetuSegmentBean.getSegcd1().getValue().substring(2);
        }

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec2(
            C_SrKbnHenkanKbn.SUURISYURUI,
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());
        C_ErrorKbn errorKbn = srSuuriKbnHenkanBean.getKekkaKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1006,
                C_SrKbnHenkanKbn.SUURISYURUI.getContent(),
                pSnkiykGtjSirt.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {
            suuriSyuruiCd = srSuuriKbnHenkanBean.getHenkanAtoKbn();
        }

        if (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            syouKbn = C_SyouKbn.SITEITUKANNKN_20;
        }
        else {
            syouKbn = C_SyouKbn.SITEITUKANNKN;
        }

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean1 = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SEDAI,
            pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

        C_ErrorKbn errorKbn1 = srSuuriKbnHenkanBean1.getKekkaKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn1)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SEDAI.getContent(),
                pSnkiykGtjSirt.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno()
                );

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {
            sedaiKbn = srSuuriKbnHenkanBean1.getHenkanAtoKbn();
        }


        if (C_HknkknsmnKbn.SAIMANKI.eq(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn())) {

            saimnkKykhyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            saimnkKykhyj = SrCommonConstants.HYOUJI_NASI;
        }


        if (pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getMonth() >= SrCommonConstants.MONTH_APRIL) {

            nenkinkaisiNendo = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getYear());
        }
        else {

            nenkinkaisiNendo = String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getYear() -
                SrCommonConstants.YEAR_1Y);
        }


        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean2 = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.NENKINGATA,
            pTkJitenKeiyakuSyouhinKijyunBean.getNksyukbn().getValue());

        C_ErrorKbn errorKbn2 = srSuuriKbnHenkanBean2.getKekkaKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn2)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.NENKINGATA.getContent(),
                pSnkiykGtjSirt.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getNksyukbn().getValue()
                );

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;

        }
        else {

            nenkingataKbn = srSuuriKbnHenkanBean2.getHenkanAtoKbn();
        }

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean3 = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.BOSYU_KEITAI,
            pKykDairiten.getDrtencd());

        C_ErrorKbn errorKbn3 = srSuuriKbnHenkanBean3.getKekkaKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn3)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.BOSYU_KEITAI.getContent(),
                pSnkiykGtjSirt.getSyono(),
                pKykDairiten.getDrtencd()
                );

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {
            bosyuukeitaiKbn = srSuuriKbnHenkanBean3.getHenkanAtoKbn();
        }

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean4 = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_HAITOU,
            pSyouhnZokusei.getHaitoukbn().getValue());

        C_ErrorKbn errorKbn4 = srSuuriKbnHenkanBean4.getKekkaKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn4)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_HAITOU.getContent(),
                pSnkiykGtjSirt.getSyono(),
                pSyouhnZokusei.getHaitoukbn().getValue()
                );

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {
            haitouKbn = srSuuriKbnHenkanBean4.getHenkanAtoKbn();
        }

        Integer hhknHkNenrei = setHokenNenrei.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd() ,
            pTkJitenKeiyakuSyouhinKijyunBean.getHhknseiymd());

        if (pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen() != hhknHkNenrei) {
            hhknnenTysihyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            hhknnenTysihyj = SrCommonConstants.HYOUJI_NASI;
        }


        BizDate kykseiymd = null;
        if (pSnkiykGtjSirt.getKykkbn() == C_KykKbn.KEIHI_DOUITU) {
            kykseiymd = pSnkiykGtjSirt.getHhknseiymd();
        }
        else {
            kykseiymd = pSnkiykGtjSirt.getKykseiymd();
        }

        int kyksyanen = setNenrei.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd() , kykseiymd);

        if (kyksyanen > 99) {
            kyksyanenTyouseigo = "";
        }
        else {
            kyksyanenTyouseigo = String.valueOf(kyksyanen);
        }

        Integer kykHkNenrei = setHokenNenrei.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd() , kykseiymd);

        if (kyksyanen != kykHkNenrei) {
            kyksyaageTyouseihyj = SrCommonConstants.HYOUJI_ARI;
        }
        else {

            kyksyaageTyouseihyj = SrCommonConstants.HYOUJI_NASI;
        }

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean5 = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        C_ErrorKbn errorKbn5 = srSuuriKbnHenkanBean5.getKekkaKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn5)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA.getContent(),
                pSnkiykGtjSirt.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()
                );

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {
            gaikaKbn = srSuuriKbnHenkanBean5.getHenkanAtoKbn();
        }

        C_KawaserateSyuruiKbn kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.BLNK;
        C_KawasetsryKbn cawasetsryKbn = C_KawasetsryKbn.BLNK;
        BizNumber crossRate = BizNumber.ZERO;

        if (C_Tuukasyu.JPY.eq(pNyknJissekiRireki.getRstuukasyu())) {
            kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.KOUJIKAWASERATE;
            cawasetsryKbn = C_KawasetsryKbn.NYUKINRATE;
        }
        else {
            kawaserateSyuruiKbn = C_KawaserateSyuruiKbn.PM17JIKAWASERATE;
            cawasetsryKbn = C_KawasetsryKbn.JISSEIRATE;
        }

        C_ErrorKbn errorKbnKawaseRate = getKawaseRate.exec(
            pNyknJissekiRireki.getRyosyuymd(),
            kawaserateSyuruiKbn,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            cawasetsryKbn,
            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
            C_YouhiKbn.HUYOU);

        if (C_ErrorKbn.ERROR.eq(errorKbnKawaseRate)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1004,
                pNyknJissekiRireki.getRyosyuymd().toString(),
                kawaserateSyuruiKbn.getValue(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                C_Tuukasyu.JPY.getValue(),
                C_KawasetekiyoKbn.TTM.getValue(),
                cawasetsryKbn.getValue(),
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                C_YouhiKbn.HUYOU.getValue());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();
            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {

            kawaserate2 = getKawaseRate.getKawaserate();
            kawaserateTekiyouymd2 = getKawaseRate.getKwsrateKjYmd().toString();
            kykjiKawaserate = getKawaseRate.getKawaserate();
            kykjiKawaserateTkyuymd = getKawaseRate.getKwsrateKjYmd().toString();

        }

        if (!pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().eq(pNyknJissekiRireki.getRstuukasyu())
            && (C_Tuukasyu.AUD.eq(pNyknJissekiRireki.getRstuukasyu()) ||
                C_Tuukasyu.USD.eq(pNyknJissekiRireki.getRstuukasyu()))) {

            errorKbn = getKawaseRate.exec(pNyknJissekiRireki.getRyosyuymd(),
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
                pNyknJissekiRireki.getRstuukasyu(),
                C_KawasetekiyoKbn.TTM,
                C_KawasetsryKbn.NYUKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1004,
                    pNyknJissekiRireki.getRyosyuymd().toString(),
                    C_KawaserateSyuruiKbn.KOUJIKAWASERATE.getValue(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue(),
                    pNyknJissekiRireki.getRstuukasyu().getValue(),
                    C_KawasetekiyoKbn.TTM.getValue(),
                    C_KawasetsryKbn.NYUKINRATE.getValue(),
                    C_EigyoubiHoseiKbn.YOKUEIGYOUBI.getValue(),
                    C_YouhiKbn.HUYOU.getValue());

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                    pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
                errorFlag = true;
            }
            else {

                crossRate = getKawaseRate.getKawaserate();
            }

            SrSuuriGouseiRateKeisanBean srSuuriGouseiRateKeisanBean =
                srSuuriGouseiRateKeisan.exec(
                    pNyknJissekiRireki.getRyosyuymd(), pNyknJissekiRireki.getRstuukasyu(), crossRate);

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

                suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                    pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
                errorFlag = true;
            }
            else {

                kykjiKawaserate = srSuuriGouseiRateKeisanBean.getSuuriGouseiRate();
            }
        }

        if (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
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

        BizDate kaiyakuSjkkkTyouseiRirituKijyunYmd = null;
        if (BizDateUtil.compareYmd(pSrRayIdouVBatchParam.getSyoriYmd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {
            kaiyakuSjkkkTyouseiRirituKijyunYmd = pSrRayIdouVBatchParam.getSyoriYmd();
        }
        else {
            kaiyakuSjkkkTyouseiRirituKijyunYmd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
        }

        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu =
            SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);
        GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean =
            SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);

        getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        getSjkkktyouseiyourirituBean.setKijyunymd(kaiyakuSjkkkTyouseiRirituKijyunYmd);
        getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
        getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
        getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

        C_ErrorKbn kekkaKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

        if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

            String msg = MessageUtil.getMessage(
                MessageId.ESA1001, "新契約：市場価格調整用利率", pSnkiykGtjSirt.getSyono());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {

            srKaiyakuSjkkktyouseirrt = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
        }


        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean6 = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_SIBOUHYOU,
            pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());

        C_ErrorKbn errorKbn6 = srSuuriKbnHenkanBean6.getKekkaKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn6)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_SIBOUHYOU.getContent(),
                pSnkiykGtjSirt.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno()
                );

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {
            sibouhyouKbn = srSuuriKbnHenkanBean6.getHenkanAtoKbn();
        }

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean7 = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA,
            pNyknJissekiRireki.getRstuukasyu().getValue());

        C_ErrorKbn errorKbn7 = srSuuriKbnHenkanBean7.getKekkaKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn7)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_NYUUSYUKKIN_TUUKA.getContent(),
                pSnkiykGtjSirt.getSyono(),
                pNyknJissekiRireki.getRstuukasyu().getValue()
                );

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {
            nyuukintuukaKbn = srSuuriKbnHenkanBean7.getHenkanAtoKbn();
        }

        if (C_UmuKbn.ARI.eq(pSnkiykGtjSirt.getTargettkhkumu())) {

            List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuBefaAftMokuhyoutiAscList =
                batchDbAccess.getTargetTokuyakuBefaAftMokuhyoutiAscList(
                    pSnkiykGtjSirt.getSyono());

            if (targetTokuyakuBefaAftMokuhyoutiAscList.size() == 0) {
                wyendttargetMokuhyouritu = pSnkiykGtjSirt.getTargettkmokuhyouti().toString();
            } else {
                wyendttargetMokuhyouritu = targetTokuyakuBefaAftMokuhyoutiAscList.get(0).getBfrnaiyouoriginal();
            }

        }
        else {
            wyendttargetMokuhyouritu = "";
        }

        if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.equals(
            pTkJitenKeiyakuSyouhinKijyunBean.getTmttknhaibunjyoutai())) {
            sisuuKbn = C_Sisuukbn.BLNK.getValue();
        }
        else {
            sisuuKbn = pTkJitenKeiyakuSyouhinKijyunBean.getSisuukbn().getValue();
        }

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean8 = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURI_SISUU,
            sisuuKbn);

        C_ErrorKbn errorKbn8 = srSuuriKbnHenkanBean8.getKekkaKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn8)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURI_SISUU.getContent(),
                pSnkiykGtjSirt.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSisuukbn().getValue()
                );

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {
            sisuuKbn = srSuuriKbnHenkanBean8.getHenkanAtoKbn();
        }

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean9 = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.TUUKA_SYU,
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue());

        C_ErrorKbn errorKbn9 = srSuuriKbnHenkanBean9.getKekkaKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn9)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.TUUKA_SYU.getContent(),
                pSnkiykGtjSirt.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu().getValue()
                );

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {
            tuukasyuruiKbn = srSuuriKbnHenkanBean9.getHenkanAtoKbn();
        }

        C_ErrorKbn keisanSisuuRendouNkTmttknErrorKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
            pSnkiykGtjSirt.getTeikishrtkykhukaumu(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKyktuukasyu(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd().getBizDateYM(),
            pKhSisuurendoTmttkn.getTmttkntaisyouym(),
            pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu(),
            pKhSisuurendoTmttkn.getTeiritutmttkngk(),
            pKhSisuurendoTmttkn.getSisuurendoutmttkngk());

        if (C_ErrorKbn.ERROR.eq(keisanSisuuRendouNkTmttknErrorKbn)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1001, "年金開始時定率部分積立金",
                pSnkiykGtjSirt.getSyono());

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {
            nksjitirtTumitatekin = keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk();
        }

        if (C_UmuKbn.ARI.eq(pSnkiykGtjSirt.getTargettkhkumu())) {

            List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTokuyakuBefaAftKijyungkAscList =
                batchDbAccess.getTargetTokuyakuBefaAftKijyungkAscList(
                    pSnkiykGtjSirt.getSyono());

            if (targetTokuyakuBefaAftKijyungkAscList.size() == 0) {
                yendttargetKijyunkingaku = Long.parseLong(pSnkiykGtjSirt.getTargettkykkijyungk().toAdsoluteString());
            } else {
                yendttargetKijyunkingaku = Long.parseLong(
                    targetTokuyakuBefaAftKijyungkAscList.get(0).getBfrnaiyouoriginal());
            }
        }

        pRayIdouVTy.setZtyrecordkbn(SrCommonConstants.RECORDKBN_IDOUMEISAI);
        pRayIdouVTy.setZtykeijyouym(pSnkiykGtjSirt.getSkeikeijyouym().toString());
        pRayIdouVTy.setZtyidojiyukbn(SrCommonConstants.IDOUJIYUUKBN_SINKEIYAKUSEIRITU);
        pRayIdouVTy.setZtyidourecordkbn(C_IdouRecordKbn.SINGLERECORD.getValue());
        pRayIdouVTy.setZtykeijyouctrlkbn(SrCommonConstants.KIJYCTRLKBN_SONOTA);
        pRayIdouVTy.setZtysuuriyoukouryokukaisiymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        pRayIdouVTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pRayIdouVTy.setZtybsyym(pKykKihon.getBosyuuym().toString());
        pRayIdouVTy.setZtyidoujiyuucd(SrCommonConstants.IDOUJIYUCD_DAITYOUSINKEIYAKU);
        pRayIdouVTy.setZtydatakanrino(pSnkiykGtjSirt.getSyono());
        pRayIdouVTy.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        pRayIdouVTy.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
        pRayIdouVTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
        pRayIdouVTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pRayIdouVTy.setZtystdssnskbn(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
        pRayIdouVTy.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
        pRayIdouVTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
        pRayIdouVTy.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
        pRayIdouVTy.setZtykbnkeiriyousegmentkbn(kbnkeiriyousegmentKbn);
        pRayIdouVTy.setZtykbnkeiriyourgnbnskkbn(kbnkeiriyourgnbnskKbn);
        pRayIdouVTy.setZtysuurisyuruicd(suuriSyuruiCd);
        pRayIdouVTy.setZtyhosyoukinoukbn(C_HosyouKinouKbn.BLNK.getValue());
        pRayIdouVTy.setZtydaikbn(C_DaiKbn.KOJINNENKIN_SISUU.getValue());
        pRayIdouVTy.setZtytyuukbn(C_TyuuKbn.SITEITUKANNKN.getValue());
        pRayIdouVTy.setZtysyoukbn(syouKbn.getValue());
        pRayIdouVTy.setZtysedaikbn(sedaiKbn);
        pRayIdouVTy.setZtyharaikatakbn(SrCommonConstants.HARAIKATAKBN_ITIJIBARAI);
        pRayIdouVTy.setZtykykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        pRayIdouVTy.setZtyhknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().toString());
        pRayIdouVTy.setZtyphrkkikn(SrCommonConstants.PHARAIKOMIKIKAN_ITIJIBARAI);
        pRayIdouVTy.setZtysaimnkkykhyj(saimnkKykhyj);
        pRayIdouVTy.setZtyannaifuyouriyuukbn(SrCommonConstants.ANNAIFUYOURIYUUKBN_ITIJIBARAI);
        pRayIdouVTy.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
        pRayIdouVTy.setZtyhrkkaisuukbn(SrCommonConstants.HRKKAISUUKBN_ITIJIBARAI);
        pRayIdouVTy.setZtysdpdkbn(pSnkiykGtjSirt.getSdpdkbn().getValue());
        pRayIdouVTy.setZtyryouritukbn(SrCommonConstants.RYOURITUKBN_HUTUUITIJIBARAI);
        pRayIdouVTy.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().toString());
        pRayIdouVTy.setZtyhihokensyaagev2(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        pRayIdouVTy.setZtykyksyanen(kyksyanenTyouseigo);
        pRayIdouVTy.setZtytkbthsyumnryuhyouji(SrCommonConstants.HYOUJI_NASI);
        pRayIdouVTy.setZtysyukeiyakupwaribikikbn(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pRayIdouVTy.setZtytenkanwaribikikbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pRayIdouVTy.setZtyyuuhitutnknyuguryurtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pRayIdouVTy.setZtysyukeiyakup(Long.parseLong(
            pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString()));
        pRayIdouVTy.setZtyatukaisisyatodouhukencd(pSnkiykGtjSirt.getDrtenkanritodoufukencd());
        pRayIdouVTy.setZtytokuyakuhukasuu(SrCommonConstants.DEFAULT_INT_ZERO);
        pRayIdouVTy.setZtyhrimnentyoumaephrkkkn(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pRayIdouVTy.setZtytokubetuhosyoukikan(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pRayIdouVTy.setZtykousinmanryouage(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pRayIdouVTy.setZtykanyujidatakanrino(pSnkiykGtjSirt.getSyono());
        pRayIdouVTy.setZtykanyujikykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        pRayIdouVTy.setZtykanyuujihihokensyaage(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        pRayIdouVTy.setZtykykjyoutai(SrCommonConstants.KEIYAKUJYOUTAI_ITIJIBARAI);
        pRayIdouVTy.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
        pRayIdouVTy.setZtysykykhokenhoutekiyouhyj(SrCommonConstants.HYOUJI_ARI);
        pRayIdouVTy.setZtyalmyousohutomeisyoukbn(C_ALMSoftKbn.BLNK.getValue());
        pRayIdouVTy.setZtysnkyksoftmeisyoukbn(C_SkeiSoftKbn.TANTAI.getValue());
        pRayIdouVTy.setZtynenkinkaisinendo(nenkinkaisiNendo);
        pRayIdouVTy.setZtynenkingatakbn(nenkingataKbn);
        pRayIdouVTy.setZtynknshry(pTkJitenKeiyakuSyouhinKijyunBean.getNenkinkkn().toString());
        pRayIdouVTy.setZtysiktsyuknbyugnhsyunshyj(SrCommonConstants.HYOUJI_NASI);
        pRayIdouVTy.setZtypmensugugtganhsyunshyj(SrCommonConstants.HYOUJI_NASI);
        pRayIdouVTy.setZtytkykgyousekihyjszerohyj(SrCommonConstants.HYOUJI_NASI);
        pRayIdouVTy.setZtybosyuukeitaikbn(bosyuukeitaiKbn);
        pRayIdouVTy.setZtyaatukaisosikicd(pKykDairiten.getDrtenkanrisosikicd());
        pRayIdouVTy.setZtyaatukaikojincd(pKykDairiten.getDaibosyuucd());
        pRayIdouVTy.setZtybsydrtencd(pKykDairiten.getDrtencd());
        pRayIdouVTy.setZtycifcd(pKykKihon.getCifcd());
        pRayIdouVTy.setZtysinsakbn(SrCommonConstants.SINSAKBN_SONOTA);
        pRayIdouVTy.setZtytoukeiyousinsakbn(SrCommonConstants.TOUKEIYOUSINSAKBN_MUSENTAKU);
        pRayIdouVTy.setZtyketteikijyunkanwakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pRayIdouVTy.setZtysykgycd(pSnkiykGtjSirt.getHhknsykgycd());
        pRayIdouVTy.setZtydakuhikettikekkacd(pItekiToukeiInfo.getKetkekkacd().getValue());
        pRayIdouVTy.setZtysiboukyuuhukin(Long.parseLong(
            pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString()));
        pRayIdouVTy.setZtyhaitoukbn(haitouKbn);
        pRayIdouVTy.setZtyhhknnentysihyj(hhknnenTysihyj);
        pRayIdouVTy.setZtykyksyaagetyouseihyj(kyksyaageTyouseihyj);
        pRayIdouVTy.setZtykituenkbn(SrCommonConstants.KITUENKBN_HUMEI);
        pRayIdouVTy.setZtymusentakukeiyakukbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pRayIdouVTy.setZtytargetmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        pRayIdouVTy.setZtyautoswitchmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        pRayIdouVTy.setZtytumitatekinitenarihyj(SrCommonConstants.HYOUJI_NASI);
        pRayIdouVTy.setZtytumitatekinitenkaisuu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        pRayIdouVTy.setZtygaikakbn(gaikaKbn);
        pRayIdouVTy.setZtykawaserate2(kawaserate2);
        pRayIdouVTy.setZtykawaseratetekiyouymd2(kawaserateTekiyouymd2);
        pRayIdouVTy.setZtykykjikawaserate(kykjiKawaserate);
        pRayIdouVTy.setZtykykjikawaseratetkyuymd(kykjiKawaserateTkyuymd);
        pRayIdouVTy.setZtymvatyouseigow(Long.parseLong(
            pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString()));
        pRayIdouVTy.setZtymvakeisanjisknnjynbkn(Long.parseLong(
            pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString()));
        pRayIdouVTy.setZtyrendouritu(rendouRitu);
        pRayIdouVTy.setZtysrkaiyakusjkkktyouseirrt(srKaiyakuSjkkktyouseirrt);
        pRayIdouVTy.setZtysrkyksjkkktyouseiriritu(
            pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu());
        pRayIdouVTy.setZtymvakeisankijyunymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        pRayIdouVTy.setZtymvatyouseikou(pSyouhnZokusei.getMvatyouseijikou());
        pRayIdouVTy.setZtykeiyakujiyoteiriritu(
            pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu());
        pRayIdouVTy.setZtytumitateriritu(pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());
        pRayIdouVTy.setZtysibouhyoukbn(sibouhyouKbn);
        pRayIdouVTy.setZtynyuukintuukakbn(nyuukintuukaKbn);
        pRayIdouVTy.setZtywyendttargetmokuhyouritu(wyendttargetMokuhyouritu);
        pRayIdouVTy.setZtysisuurendourate(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykjisisuurendourate().toString());
        pRayIdouVTy.setZtysisuukbn(sisuuKbn);
        pRayIdouVTy.setZtysrdai1hknkkn(String.valueOf(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn()));
        pRayIdouVTy.setZtytmttknzoukaritujygn(pTkJitenKeiyakuSyouhinKijyunBean.getTmttknzoukaritujygn());
        pRayIdouVTy.setZtysetteibairitu(pTkJitenKeiyakuSyouhinKijyunBean.getSetteibairitu());
        pRayIdouVTy.setZtytykzenoutouymdsisuu(
            pKhSisuurendoTmttkn.getTmttknhaneisisuu());
        pRayIdouVTy.setZtykimatusisuu(
            pKhSisuurendoTmttkn.getTmttknhaneisisuu());
        pRayIdouVTy.setZtytuukasyukbn(tuukasyuruiKbn);
        pRayIdouVTy.setZtysisuurentumitatekin(Long.parseLong(
            pKhSisuurendoTmttkn.getSisuurendoutmttkngk().toAdsoluteString()));
        pRayIdouVTy.setZtynksjitirttumitatekin(Long.parseLong(nksjitirtTumitatekin.toAdsoluteString()));
        pRayIdouVTy.setZtykimatutirttumitatekin(
            Long.parseLong(pKhSisuurendoTmttkn.getTeiritutmttkngk().toAdsoluteString()));
        pRayIdouVTy.setZtyyendttargetkijyunkingaku(yendttargetKijyunkingaku);
    }


    private void  editRayIdouVTyData(
        SrRayIdouVBatchParam pSrRayIdouVBatchParam,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SV_SnkiykGtjSirt pSnkiykGtjSirt,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn,
        ZT_RayIdouVTy pRayIdouVTy,
        boolean pIdolBknEditKoumokuFlag) {

        String syono = "";
        BizDate kouryokuKaisiYmd = null;
        BizDate denYmd = null;
        BizDate kouryokuHasseiYmd = null;
        C_UmuKbn teikishrtkykhukaumu = null;

        if (pIdolBknEditKoumokuFlag) {
            syono = pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino();
            kouryokuKaisiYmd = BizDate.valueOf(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyoukouryokukaisiymd());
            denYmd = BizDate.valueOf(pIdouMeisaiTyukeiyouItzHzn.getZtydenymd());
            kouryokuHasseiYmd = BizDate.valueOf(pIdouMeisaiTyukeiyouItzHzn.getZtysrkouryokuhasseiymd());
            teikishrtkykhukaumu = C_UmuKbn.valueOf(pIdouMeisaiTyukeiyouItzHzn.getZtysrteikishrtkykhukaumu());
        }
        else {
            syono = pSnkiykGtjSirt.getSyono();
            kouryokuKaisiYmd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
            denYmd = BizDate.valueOf(SrCommonConstants.DEFAULT_STRING_YMD);
            kouryokuHasseiYmd = pTkJitenKeiyakuSyouhinKijyunBean.getKykymd();
            teikishrtkykhukaumu = pSnkiykGtjSirt.getTeikishrtkykhukaumu();
        }

        BizDate nenkinstartymd = null;
        BizDate jigyouNdhtymd = null;
        BizDate jigyouNdmtYmd = null;
        BizDateYM kaiyakuhrKeisanKijunYm = null;
        BizDate kaiyakuSjkkkTyouseiRirituKijyunYmd = BizDate.MIN_VALUE;
        BizNumber kaiyakuSjkkkTyouseiRiritu = BizNumber.ZERO;

        BizNumber vyouTykzenOutouYmdSisuu =  BizNumber.ZERO;
        BizDate tykzenSisuuKijyunYmd = null;
        BizNumber vyouKimatuSisuu =  BizNumber.ZERO;
        BizDate kmtSisuuKijyunYmd = null;

        nenkinstartymd = pTkJitenKeiyakuSyouhinKijyunBean.getHknkknmanryouymd();

        if (BizDateUtil.compareYmd(kouryokuHasseiYmd, pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) >= BizDateUtil.COMPARE_EQUAL) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null
                && pTkJitenKeiyakuSyouhinKijyunBean.getTmttknitenYmd() == null) {

                vyouTykzenOutouYmdSisuu = pKhSisuurendoTmttkn.getTmttknhaneisisuu();
                tykzenSisuuKijyunYmd = pKhSisuurendoTmttkn.getTmttknhaneitmmshanteiymd();
                vyouKimatuSisuu = pKhSisuurendoTmttkn.getTmttknhaneisisuu();
                kmtSisuuKijyunYmd = pKhSisuurendoTmttkn.getTmttknhaneitmmshanteiymd();
            }
        }

        jigyouNdhtymd = kouryokuHasseiYmd;

        if (jigyouNdhtymd.getMonth() < SrCommonConstants.MONTH_APRIL) {

            jigyouNdmtYmd = BizDate.valueOf(String.valueOf(jigyouNdhtymd.getYear())
                + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }
        else {

            jigyouNdmtYmd = BizDate.valueOf(String.valueOf(jigyouNdhtymd.getYear()
                + SrCommonConstants.YEAR_1Y)
                + SrCommonConstants.FIXEDDAY_NENDOKSNBI);
        }

        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

        kaiyakuhrKeisanKijunYm = keisanWKijunYM.exec(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(), jigyouNdmtYmd,
            null, null, pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

        if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {

            if (BizDateUtil.compareYmd(pSrRayIdouVBatchParam.getSyoriYmd(),
                kouryokuKaisiYmd) == BizDateUtil.COMPARE_LESSER) {

                kaiyakuSjkkkTyouseiRirituKijyunYmd = pSrRayIdouVBatchParam.getSyoriYmd();
            }
            else {

                kaiyakuSjkkkTyouseiRirituKijyunYmd = kouryokuKaisiYmd;
            }

            GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector
                .getInstance(GetSjkkktyouseiyourirituBean.class);
            GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);

            getSjkkktyouseiyourirituBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            getSjkkktyouseiyourirituBean.setKijyunymd(kaiyakuSjkkkTyouseiRirituKijyunYmd);
            getSjkkktyouseiyourirituBean.setHknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn());
            getSjkkktyouseiyourirituBean.setHknkknsmnkbn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkknsmnKbn());
            getSjkkktyouseiyourirituBean.setHhknnen(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen());

            C_ErrorKbn errorKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                String msg = MessageUtil.getMessage(MessageId.ESA1001, "市場価格調整用利率", syono);

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(syono);
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                    pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
                errorFlag = true;
            }
            else {
                kaiyakuSjkkkTyouseiRiritu = getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu();
            }
        }

        BizCurrency[] jmtTirtTumitatekins = {BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizCurrency.valueOf(0)};
        BizCurrency[] jmtSisuuTumitatekins = {BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizCurrency.valueOf(0)};
        BizCurrency[] jmtMvaTyouseigoWs = {BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizCurrency.valueOf(0)};
        BizCurrency[] jmtMvaKeisanjiVs = {BizCurrency.valueOf(0), BizCurrency.valueOf(0), BizCurrency.valueOf(0)};
        int nensuu = 0;
        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
        KeisanWExtBean keisanWExtBean = null;

        for (int i = 0; i < 3; i++) {

            if (pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() == null) {

                break;
            }

            if (BizDateUtil.compareYmd(nenkinstartymd, jigyouNdmtYmd) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(nenkinstartymd, jigyouNdmtYmd) == BizDateUtil.COMPARE_EQUAL) {

                break;
            }

            BizDateYM keisanWKijunymYendthnk = keisanWKijunYM.exec(
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                BizDate.valueOf(jigyouNdmtYmd.getBizDateYM(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd().getDay()).getRekijyou(),
                    null,
                    null,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());

            BizDateYM yendthnYm = keisanWKijunYM.exec(
                pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                null,
                null,
                pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(),
                null);

            KeisanSisuuRendouNkTmttknYendtHnk keisanSisuuRendouNkTmttknYendtHnk =
                SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknYendtHnk.class);

            C_ErrorKbn kekkaKbn = keisanSisuuRendouNkTmttknYendtHnk.exec(
                BizDate.valueOf(jigyouNdmtYmd.getBizDateYM(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd().getDay()).getRekijyou(),
                    keisanWKijunymYendthnk,
                    pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                    yendthnYm,
                    pTkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getKihons(),
                    pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());

            if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                String msg = MessageUtil.getMessage(
                    MessageId.ESA1001, "事業年度末項目：指数連動年金積立金計算" + nensuu, syono);

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(syono);
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                    pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);

                errorFlag = true;
            }
            else {

                jmtTirtTumitatekins[nensuu] = keisanSisuuRendouNkTmttknYendtHnk.getTumitategk();
                jmtSisuuTumitatekins[nensuu] = BizCurrency.valueOf(0);
            }

            keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

            keisanWExtBean.setSyouhncd(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
            keisanWExtBean.setSyouhnsdno(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());
            keisanWExtBean.setRyouritusdno(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
            keisanWExtBean.setYoteiriritu(pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu());
            keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
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
            keisanWExtBean.setTumitateriritu(pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());
            keisanWExtBean.setYendthnkymd(pTkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd());
            keisanWExtBean.setTeikishrtkykhukaumu(teikishrtkykhukaumu);
            keisanWExtBean.setDai1hknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getDai1hknkkn());
            keisanWExtBean.setKykJyoutai(pTkJitenKeiyakuSyouhinKijyunBean.getKykjyoutai());

            C_ErrorKbn keisanWKekkaKbn = keisanW.exec(jigyouNdmtYmd, kaiyakuhrKeisanKijunYm, keisanWExtBean);

            if (C_ErrorKbn.ERROR.eq(keisanWKekkaKbn)) {

                String msg = MessageUtil.getMessage(
                    MessageId.ESA1001, "事業年度末項目：解約返戻金計算" + nensuu, syono);

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrRayIdouVBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrRayIdouVBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(syono);
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrRayIdouVBatchParam.setZokkouErrorSyoriCount(
                    pSrRayIdouVBatchParam.getZokkouErrorSyoriCount() + 1);

                errorFlag = true;
            }
            else {

                jmtMvaTyouseigoWs[nensuu] = keisanW.getW();
                jmtMvaKeisanjiVs[nensuu] = keisanW.getV();
            }

            jigyouNdmtYmd = jigyouNdmtYmd.addYears(SrCommonConstants.YEAR_1Y).getRekijyou();
            kaiyakuhrKeisanKijunYm = kaiyakuhrKeisanKijunYm.addYears(SrCommonConstants.YEAR_1Y);

            nensuu++;
        }

        if (pIdolBknEditKoumokuFlag) {
            pRayIdouVTy.setZtyvkimatutirttumitatekin(pIdouMeisaiTyukeiyouItzHzn
                .getZtykimatutirttumitatekin());
            pRayIdouVTy.setZtykimatusisuutumitatekin(pIdouMeisaiTyukeiyouItzHzn
                .getZtysisuurentumitatekin());
            pRayIdouVTy.setZtyvyoutykzenoutouymdsisuu(
                vyouTykzenOutouYmdSisuu);
            if (tykzenSisuuKijyunYmd != null) {
                pRayIdouVTy.setZtytykzensisuukijyunymd(tykzenSisuuKijyunYmd.toString());
            }
            pRayIdouVTy.setZtyvyoukimatusisuu(vyouKimatuSisuu);
            if (kmtSisuuKijyunYmd != null) {
                pRayIdouVTy.setZtykmtsisuukijyunymd(kmtSisuuKijyunYmd.toString());
            }
            pRayIdouVTy.setZtyvyoutmttknzoukaritujygn(pIdouMeisaiTyukeiyouItzHzn
                .getZtytmttknzoukaritujygn());
            pRayIdouVTy.setZtyvyousetteibairitu(pIdouMeisaiTyukeiyouItzHzn.getZtysetteibairitu());
            pRayIdouVTy.setZtyvyourendouritu(pIdouMeisaiTyukeiyouItzHzn.getZtyrendouritu());

            pRayIdouVTy.setZtykimatusisuutyokugotmttkn(pIdouMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());

            pRayIdouVTy.setZtyjmttirttumitatekinnplus0(Long.parseLong(jmtTirtTumitatekins[0].toAdsoluteString()));
            pRayIdouVTy.setZtyjmttirttumitatekinnplus1(Long.parseLong(jmtTirtTumitatekins[1].toAdsoluteString()));
            pRayIdouVTy.setZtyjmttirttumitatekinnplus2(Long.parseLong(jmtTirtTumitatekins[2].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtssutumitatekinnplus0(Long.parseLong(jmtSisuuTumitatekins[0].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtssutumitatekinnplus1(Long.parseLong(jmtSisuuTumitatekins[1].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtssutumitatekinnplus2(Long.parseLong(jmtSisuuTumitatekins[2].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtmvatyouseigownplus0(Long.parseLong(jmtMvaTyouseigoWs[0].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtmvakeisanjiwnplus0(Long.parseLong(jmtMvaKeisanjiVs[0].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtmvatyouseigownplus1(Long.parseLong(jmtMvaTyouseigoWs[1].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtmvakeisanjiwnplus1(Long.parseLong(jmtMvaKeisanjiVs[1].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtmvatyouseigownplus2(Long.parseLong(jmtMvaTyouseigoWs[2].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtmvakeisanjiwnplus2(Long.parseLong(jmtMvaKeisanjiVs[2].toAdsoluteString()));
        }
        else {
            pRayIdouVTy.setZtyvkimatutirttumitatekin(pRayIdouVTy
                .getZtykimatutirttumitatekin());
            pRayIdouVTy.setZtykimatusisuutumitatekin(pRayIdouVTy
                .getZtysisuurentumitatekin());
            pRayIdouVTy.setZtyvyoutykzenoutouymdsisuu(
                vyouTykzenOutouYmdSisuu);
            if (tykzenSisuuKijyunYmd != null) {
                pRayIdouVTy.setZtytykzensisuukijyunymd(tykzenSisuuKijyunYmd.toString());
            }
            pRayIdouVTy.setZtyvyoukimatusisuu(vyouKimatuSisuu);
            if (kmtSisuuKijyunYmd != null) {
                pRayIdouVTy.setZtykmtsisuukijyunymd(kmtSisuuKijyunYmd.toString());
            }
            pRayIdouVTy.setZtyvyoutmttknzoukaritujygn(pRayIdouVTy
                .getZtytmttknzoukaritujygn());
            pRayIdouVTy.setZtyvyousetteibairitu(pRayIdouVTy.getZtysetteibairitu());
            pRayIdouVTy.setZtyvyourendouritu(pRayIdouVTy.getZtyrendouritu());
            pRayIdouVTy.setZtyjmttirttumitatekinnplus0(Long.parseLong(jmtTirtTumitatekins[0].toAdsoluteString()));
            pRayIdouVTy.setZtyjmttirttumitatekinnplus1(Long.parseLong(jmtTirtTumitatekins[1].toAdsoluteString()));
            pRayIdouVTy.setZtyjmttirttumitatekinnplus2(Long.parseLong(jmtTirtTumitatekins[2].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtssutumitatekinnplus0(Long.parseLong(jmtSisuuTumitatekins[0].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtssutumitatekinnplus1(Long.parseLong(jmtSisuuTumitatekins[1].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtssutumitatekinnplus2(Long.parseLong(jmtSisuuTumitatekins[2].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtmvatyouseigownplus0(Long.parseLong(jmtMvaTyouseigoWs[0].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtmvakeisanjiwnplus0(Long.parseLong(jmtMvaKeisanjiVs[0].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtmvatyouseigownplus1(Long.parseLong(jmtMvaTyouseigoWs[1].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtmvakeisanjiwnplus1(Long.parseLong(jmtMvaKeisanjiVs[1].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtmvatyouseigownplus2(Long.parseLong(jmtMvaTyouseigoWs[2].toAdsoluteString()));
            pRayIdouVTy.setZtyjmtmvakeisanjiwnplus2(Long.parseLong(jmtMvaKeisanjiVs[2].toAdsoluteString()));

        }
    }
}
