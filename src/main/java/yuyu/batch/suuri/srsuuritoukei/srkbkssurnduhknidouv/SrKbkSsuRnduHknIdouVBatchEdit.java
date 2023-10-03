package yuyu.batch.suuri.srsuuritoukei.srkbkssurnduhknidouv;

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
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknOverNnd;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknYendtHnk;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
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
import yuyu.def.db.entity.ZT_KbkSsuRnduHknIdouVTy;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 株価指数連動保険異動Ｖ情報作成バッチ機能の項目編集クラス
 */
public class SrKbkSsuRnduHknIdouVBatchEdit {

    private static final String ITKHSISUURENDOTMTTKN = "IT_KhSisuurendoTmttkn";

    private static final String SISUURENDOUTMTTKNGK = "sisuurendoutmttkngk";

    @Inject
    private BatchLogger batchLogger;

    private Boolean errorFlag;

    public SrKbkSsuRnduHknIdouVBatchEdit() {

        errorFlag = false;
    }

    public boolean editKoumoku(
        SrKbkSsuRnduHknIdouVBatchParam pSrKbkSsuRnduHknIdouVBatchParam,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SV_SnkiykGtjSirt pSnkiykGtjSirt,
        IT_KykKihon pKykKihon,
        BM_SyouhnZokusei pSyouhnZokusei,
        IT_KykDairiten pKykDairiten,
        IT_NyknJissekiRireki pNyknJissekiRireki,
        IT_ItekiToukeiInfo pItekiToukeiInfo,
        ZT_KbkSsuRnduHknIdouVTy pKbkSsuRnduHknIdouVTy,
        boolean pIdolBknEditKoumokuFlag) {

        editHeaderData(
            pSrKbkSsuRnduHknIdouVBatchParam,
            pKbkSsuRnduHknIdouVTy);

        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = getTmttknInfo(
            pIdouMeisaiTyukeiyouItzHzn,
            pSvKiykSyuhnDataLst,
            pTkJitenKeiyakuSyouhinKijyunBean,
            pSnkiykGtjSirt,
            pIdolBknEditKoumokuFlag);

        if (pIdolBknEditKoumokuFlag) {

            editIdouMeisai(pIdouMeisaiTyukeiyouItzHzn,pKbkSsuRnduHknIdouVTy);
        }
        else {
            editSkeiKoumoku(pSrKbkSsuRnduHknIdouVBatchParam , pTkJitenKeiyakuSyouhinKijyunBean ,
                pSnkiykGtjSirt , pKykKihon , pSyouhnZokusei , pKykDairiten , pNyknJissekiRireki , pItekiToukeiInfo,
                khSisuurendoTmttkn , pKbkSsuRnduHknIdouVTy) ;
        }

        editKbkSsuRnduIdouVTyData(pSrKbkSsuRnduHknIdouVBatchParam , pIdouMeisaiTyukeiyouItzHzn,
            pTkJitenKeiyakuSyouhinKijyunBean , pSnkiykGtjSirt , khSisuurendoTmttkn ,
            pKbkSsuRnduHknIdouVTy,pIdolBknEditKoumokuFlag);

        return errorFlag;
    }

    private void editHeaderData(
        SrKbkSsuRnduHknIdouVBatchParam pSrKbkSsuRnduHknIdouVBatchParam,
        ZT_KbkSsuRnduHknIdouVTy pKbkSsuRnduHknIdouVTy) {

        Integer keyKoumoku = pSrKbkSsuRnduHknIdouVBatchParam.getSyoriCount();
        pSrKbkSsuRnduHknIdouVBatchParam.setSyoriCount(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriCount() + 1);

        pKbkSsuRnduHknIdouVTy.setZtysequenceno(keyKoumoku);

    }

    private IT_KhSisuurendoTmttkn getTmttknInfo(
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn,
        List<SV_KiykSyuhnData> pSvKiykSyuhnDataLst,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SV_SnkiykGtjSirt pSnkiykGtjSirt,
        boolean pIdolBknEditKoumokuFlag) {

        IT_KhSisuurendoTmttkn khSisuurendoTmttkn = null;

        SrKbkSsuRnduHknIdouVBatchDbAccess batchDbAccess =
            SWAKInjector.getInstance(SrKbkSsuRnduHknIdouVBatchDbAccess.class);

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

                if((SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                    SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_MINUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                    (SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                        SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_PLUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                        (SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                            SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_PLUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                            (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
                                SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_MINUS.equals(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd())) ||
                                (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) &&
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
                    SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn())) {
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

                    if (SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(pIdouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn())) {
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
        ZT_KbkSsuRnduHknIdouVTy pKbkSsuRnduHknIdouVTy) {

        pKbkSsuRnduHknIdouVTy.setZtyrecordkbn(pIdouMeisaiTyukeiyouItzHzn.getZtyrecordkbn());
        pKbkSsuRnduHknIdouVTy.setZtynenkinkaisigohyouji(pIdouMeisaiTyukeiyouItzHzn.getZtynenkinkaisigohyouji());
        pKbkSsuRnduHknIdouVTy.setZtynksgokurikosidhyj(pIdouMeisaiTyukeiyouItzHzn.getZtynksgokurikosidhyj());
        pKbkSsuRnduHknIdouVTy.setZtykeijyouym(pIdouMeisaiTyukeiyouItzHzn.getZtykeijyouym());
        pKbkSsuRnduHknIdouVTy.setZtyidojiyukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyidojiyukbn());
        pKbkSsuRnduHknIdouVTy.setZtyzougenkbn(pIdouMeisaiTyukeiyouItzHzn.getZtyzougenkbn());
        pKbkSsuRnduHknIdouVTy.setZtyidourecordkbn(pIdouMeisaiTyukeiyouItzHzn.getZtyidourecordkbn());
        pKbkSsuRnduHknIdouVTy.setZtykeijyouctrlkbn(pIdouMeisaiTyukeiyouItzHzn.getZtykeijyouctrlkbn());
        pKbkSsuRnduHknIdouVTy.setZtyhenkousyoriymd(pIdouMeisaiTyukeiyouItzHzn.getZtyhenkousyoriymd());
        pKbkSsuRnduHknIdouVTy.setZtykykmfksnctr(pIdouMeisaiTyukeiyouItzHzn.getZtykykmfksnctr());
        pKbkSsuRnduHknIdouVTy.setZtyrecordctr(pIdouMeisaiTyukeiyouItzHzn.getZtyrecordctr());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyoukouryokukaisiymd(pIdouMeisaiTyukeiyouItzHzn
            .getZtysuuriyoukouryokukaisiymd());
        pKbkSsuRnduHknIdouVTy.setZtydenymd(pIdouMeisaiTyukeiyouItzHzn.getZtydenymd());
        pKbkSsuRnduHknIdouVTy.setZtybluekeizokuhyouji(pIdouMeisaiTyukeiyouItzHzn.getZtybluekeizokuhyouji());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin1x2(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x2());
        pKbkSsuRnduHknIdouVTy.setZtytoukeikeijyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtytoukeikeijyoukbn());
        pKbkSsuRnduHknIdouVTy.setZtyraysystemhyj(pIdouMeisaiTyukeiyouItzHzn.getZtyraysystemhyj());
        pKbkSsuRnduHknIdouVTy.setZtyzenkiidouteiseikbn(pIdouMeisaiTyukeiyouItzHzn.getZtyzenkiidouteiseikbn());
        pKbkSsuRnduHknIdouVTy.setZtybsyym(pIdouMeisaiTyukeiyouItzHzn.getZtybsyym());
        pKbkSsuRnduHknIdouVTy.setZtytenkangokeiyakubosyuuym(pIdouMeisaiTyukeiyouItzHzn
            .getZtytenkangokeiyakubosyuuym());
        pKbkSsuRnduHknIdouVTy.setZtyidoujiyuucd(pIdouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd());
        pKbkSsuRnduHknIdouVTy.setZtysyoricd(pIdouMeisaiTyukeiyouItzHzn.getZtysyoricd());
        pKbkSsuRnduHknIdouVTy.setZtysekininteiseihyouji(pIdouMeisaiTyukeiyouItzHzn.getZtysekininteiseihyouji());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin8(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8());
        pKbkSsuRnduHknIdouVTy.setZtysihankibikinkbn(pIdouMeisaiTyukeiyouItzHzn.getZtysihankibikinkbn());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin1x3(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x3());
        pKbkSsuRnduHknIdouVTy.setZtydatakanrino(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino());
        pKbkSsuRnduHknIdouVTy.setZtyhknsyukigou(pIdouMeisaiTyukeiyouItzHzn.getZtyhknsyukigou());
        pKbkSsuRnduHknIdouVTy.setZtyhknsyuruikigousedaikbn(pIdouMeisaiTyukeiyouItzHzn
            .getZtyhknsyuruikigousedaikbn());
        pKbkSsuRnduHknIdouVTy.setZtysotodasipmenkbn(pIdouMeisaiTyukeiyouItzHzn.getZtysotodasipmenkbn());
        pKbkSsuRnduHknIdouVTy.setZtystdssytikbn(pIdouMeisaiTyukeiyouItzHzn.getZtystdssytikbn());
        pKbkSsuRnduHknIdouVTy.setZtystdssnskbn(pIdouMeisaiTyukeiyouItzHzn.getZtystdssnskbn());
        pKbkSsuRnduHknIdouVTy
        .setZtysotodasimanagehyouji(pIdouMeisaiTyukeiyouItzHzn.getZtysotodasimanagehyouji());
        pKbkSsuRnduHknIdouVTy.setZtysotodasiphkbnmnoshyouji(pIdouMeisaiTyukeiyouItzHzn
            .getZtysotodasiphkbnmnoshyouji());
        pKbkSsuRnduHknIdouVTy.setZtystdsstkjytkyuhyj(pIdouMeisaiTyukeiyouItzHzn.getZtystdsstkjytkyuhyj());
        pKbkSsuRnduHknIdouVTy.setZtykbnkeiriyousegmentkbn(pIdouMeisaiTyukeiyouItzHzn
            .getZtykbnkeiriyousegmentkbn());
        pKbkSsuRnduHknIdouVTy.setZtykbnkeiriyourgnbnskkbn(pIdouMeisaiTyukeiyouItzHzn
            .getZtykbnkeiriyourgnbnskkbn());
        pKbkSsuRnduHknIdouVTy.setZtysuurisyuruicd(pIdouMeisaiTyukeiyouItzHzn.getZtysuurisyuruicd());
        pKbkSsuRnduHknIdouVTy.setZtyhosyoukinoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyhosyoukinoukbn());
        pKbkSsuRnduHknIdouVTy.setZtydaikbn(pIdouMeisaiTyukeiyouItzHzn.getZtydaikbn());
        pKbkSsuRnduHknIdouVTy.setZtytyuukbn(pIdouMeisaiTyukeiyouItzHzn.getZtytyuukbn());
        pKbkSsuRnduHknIdouVTy.setZtysyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysyoukbn());
        pKbkSsuRnduHknIdouVTy.setZtysedaikbn(pIdouMeisaiTyukeiyouItzHzn.getZtysedaikbn());
        pKbkSsuRnduHknIdouVTy.setZtyharaikatakbn(pIdouMeisaiTyukeiyouItzHzn.getZtyharaikatakbn());
        pKbkSsuRnduHknIdouVTy.setZtykykymd(pIdouMeisaiTyukeiyouItzHzn.getZtykykymd());
        pKbkSsuRnduHknIdouVTy.setZtyhknkkn(pIdouMeisaiTyukeiyouItzHzn.getZtyhknkkn());
        pKbkSsuRnduHknIdouVTy.setZtyphrkkikn(pIdouMeisaiTyukeiyouItzHzn.getZtyphrkkikn());
        pKbkSsuRnduHknIdouVTy.setZtysaimnkkykhyj(pIdouMeisaiTyukeiyouItzHzn.getZtysaimnkkykhyj());
        pKbkSsuRnduHknIdouVTy.setZtyannaifuyouriyuukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyannaifuyouriyuukbn());
        pKbkSsuRnduHknIdouVTy.setZtytksyuannaikykkbn(pIdouMeisaiTyukeiyouItzHzn.getZtytksyuannaikykkbn());
        pKbkSsuRnduHknIdouVTy.setZtyhrkkaisuukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyhrkkaisuukbn());
        pKbkSsuRnduHknIdouVTy.setZtyhrkkeirokbn(pIdouMeisaiTyukeiyouItzHzn.getZtyhrkkeirokbn());
        pKbkSsuRnduHknIdouVTy.setZtysdpdkbn(pIdouMeisaiTyukeiyouItzHzn.getZtysdpdkbn());
        pKbkSsuRnduHknIdouVTy.setZtyryouritukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyryouritukbn());
        pKbkSsuRnduHknIdouVTy.setZtyao3tyou3sibousdatehyouji(pIdouMeisaiTyukeiyouItzHzn
            .getZtyao3tyou3sibousdatehyouji());
        pKbkSsuRnduHknIdouVTy.setZtyhhknseikbn(pIdouMeisaiTyukeiyouItzHzn.getZtyhhknseikbn());
        pKbkSsuRnduHknIdouVTy.setZtyhihokensyaagev2(pIdouMeisaiTyukeiyouItzHzn.getZtyhihokensyaagev2());
        pKbkSsuRnduHknIdouVTy.setZtykyksyanen(pIdouMeisaiTyukeiyouItzHzn.getZtykyksyanen());
        pKbkSsuRnduHknIdouVTy.setZtydai2hhknnen(pIdouMeisaiTyukeiyouItzHzn.getZtydai2hhknnen());
        pKbkSsuRnduHknIdouVTy.setZtytkbthsyumnryuhyouji(pIdouMeisaiTyukeiyouItzHzn.getZtytkbthsyumnryuhyouji());
        pKbkSsuRnduHknIdouVTy.setZtysyukeiyakupwaribikikbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtysyukeiyakupwaribikikbn());
        pKbkSsuRnduHknIdouVTy.setZtytenkanwaribikikbn(pIdouMeisaiTyukeiyouItzHzn.getZtytenkanwaribikikbn());
        pKbkSsuRnduHknIdouVTy.setZtyyuuhitutnknyuguryurtkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyyuuhitutnknyuguryurtkbn());
        pKbkSsuRnduHknIdouVTy.setZtysyukeiyakup(pIdouMeisaiTyukeiyouItzHzn.getZtysyukeiyakup());
        pKbkSsuRnduHknIdouVTy.setZtytokujyoup(pIdouMeisaiTyukeiyouItzHzn.getZtytokujyoup());
        pKbkSsuRnduHknIdouVTy.setZtysiteizukisyukeiyakup(pIdouMeisaiTyukeiyouItzHzn.
            getZtysiteizukisyukeiyakup());
        pKbkSsuRnduHknIdouVTy.setZtykihons(pIdouMeisaiTyukeiyouItzHzn.getZtykihons());
        pKbkSsuRnduHknIdouVTy.setZtysibous(pIdouMeisaiTyukeiyouItzHzn.getZtysibous());
        pKbkSsuRnduHknIdouVTy.setZtyhenkougokihons(pIdouMeisaiTyukeiyouItzHzn.getZtyhenkougokihons());
        pKbkSsuRnduHknIdouVTy.setZtyhenkougosibous(pIdouMeisaiTyukeiyouItzHzn.getZtyhenkougosibous());
        pKbkSsuRnduHknIdouVTy.setZtyhenkouymd(pIdouMeisaiTyukeiyouItzHzn.getZtyhenkouymd());
        pKbkSsuRnduHknIdouVTy.setZtyentyoukikan(pIdouMeisaiTyukeiyouItzHzn.getZtyentyoukikan());
        pKbkSsuRnduHknIdouVTy.setZtyseizonkyuuhukinsiteimd(pIdouMeisaiTyukeiyouItzHzn.
            getZtyseizonkyuuhukinsiteimd());
        pKbkSsuRnduHknIdouVTy.setZtysyukeiyakusiharaikingaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtysyukeiyakusiharaikingaku());
        pKbkSsuRnduHknIdouVTy.setZtyatukaisisyatodouhukencd(pIdouMeisaiTyukeiyouItzHzn.
            getZtyatukaisisyatodouhukencd());
        pKbkSsuRnduHknIdouVTy.setZtytokuyakuhukasuu(pIdouMeisaiTyukeiyouItzHzn.getZtytokuyakuhukasuu());
        pKbkSsuRnduHknIdouVTy.setZtydi2hknkknikoujihisyaage(pIdouMeisaiTyukeiyouItzHzn.
            getZtydi2hknkknikoujihisyaage());
        pKbkSsuRnduHknIdouVTy.setZtyhrimnentyoumaephrkkkn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhrimnentyoumaephrkkkn());
        pKbkSsuRnduHknIdouVTy.setZtytokubetuhosyoukikan(pIdouMeisaiTyukeiyouItzHzn.getZtytokubetuhosyoukikan());
        pKbkSsuRnduHknIdouVTy.setZtykousinmanryouage(pIdouMeisaiTyukeiyouItzHzn.getZtykousinmanryouage());
        pKbkSsuRnduHknIdouVTy.setZtyknkuzusnzyrttekitkarihyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtyknkuzusnzyrttekitkarihyj());
        pKbkSsuRnduHknIdouVTy.setZtykuriagekurisagekbn(pIdouMeisaiTyukeiyouItzHzn.getZtykuriagekurisagekbn());
        pKbkSsuRnduHknIdouVTy.setZtyhrizmjhknsyukigousdkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhrizmjhknsyukigousdkbn());
        pKbkSsuRnduHknIdouVTy.setZtykrsgjhknsyukigousdkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtykrsgjhknsyukigousdkbn());
        pKbkSsuRnduHknIdouVTy.setZtysotodasisyouhinkaiteikbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtysotodasisyouhinkaiteikbn());
        pKbkSsuRnduHknIdouVTy.setZtyyobiv4(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv4());
        pKbkSsuRnduHknIdouVTy.setZtygoukeitenkans(pIdouMeisaiTyukeiyouItzHzn.getZtygoukeitenkans());
        pKbkSsuRnduHknIdouVTy.setZtygoukeipbubuntenkans(pIdouMeisaiTyukeiyouItzHzn.getZtygoukeipbubuntenkans());
        pKbkSsuRnduHknIdouVTy.setZtytenkanteikisyuruikigou(pIdouMeisaiTyukeiyouItzHzn.
            getZtytenkanteikisyuruikigou());
        pKbkSsuRnduHknIdouVTy.setZtytenkanteikikigousedaikbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtytenkanteikikigousedaikbn());
        pKbkSsuRnduHknIdouVTy.setZtytnkntiksotodasikusnkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtytnkntiksotodasikusnkbn());
        pKbkSsuRnduHknIdouVTy.setZtytnkntikstdspmenkbn(pIdouMeisaiTyukeiyouItzHzn.getZtytnkntikstdspmenkbn());
        pKbkSsuRnduHknIdouVTy.setZtytenkanteikikigouyobi(pIdouMeisaiTyukeiyouItzHzn.
            getZtytenkanteikikigouyobi());
        pKbkSsuRnduHknIdouVTy.setZtytenkanteikikikan(pIdouMeisaiTyukeiyouItzHzn.getZtytenkanteikikikan());
        pKbkSsuRnduHknIdouVTy.setZtygoukeitenkanteikis(pIdouMeisaiTyukeiyouItzHzn.getZtygoukeitenkanteikis());
        pKbkSsuRnduHknIdouVTy.setZtytnknteikinkshrkkn(pIdouMeisaiTyukeiyouItzHzn.getZtytnknteikinkshrkkn());
        pKbkSsuRnduHknIdouVTy.setZtytenkansiharaikingaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtytenkansiharaikingaku());
        pKbkSsuRnduHknIdouVTy.setZtytnkntikshrkngk(pIdouMeisaiTyukeiyouItzHzn.getZtytnkntikshrkngk());
        pKbkSsuRnduHknIdouVTy.setZtytenkankaisuu(pIdouMeisaiTyukeiyouItzHzn.getZtytenkankaisuu());
        pKbkSsuRnduHknIdouVTy.setZtygoukeitenkankakaku(pIdouMeisaiTyukeiyouItzHzn.getZtygoukeitenkankakaku());
        pKbkSsuRnduHknIdouVTy.setZtytnknkhnbbnjyuturt(pIdouMeisaiTyukeiyouItzHzn.getZtytnknkhnbbnjyuturt());
        pKbkSsuRnduHknIdouVTy.setZtywnasigoukeitenkanteikis(pIdouMeisaiTyukeiyouItzHzn.
            getZtywnasigoukeitenkanteikis());
        pKbkSsuRnduHknIdouVTy.setZtytnknteikikousinmnryouage(pIdouMeisaiTyukeiyouItzHzn.
            getZtytnknteikikousinmnryouage());
        pKbkSsuRnduHknIdouVTy.setZtyyobiv5(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv5());
        pKbkSsuRnduHknIdouVTy.setZtykanyujidatakanrino(pIdouMeisaiTyukeiyouItzHzn.getZtykanyujidatakanrino());
        pKbkSsuRnduHknIdouVTy.setZtykanyujikykymd(pIdouMeisaiTyukeiyouItzHzn.getZtykanyujikykymd());
        pKbkSsuRnduHknIdouVTy.setZtykanyuujihihokensyaage(pIdouMeisaiTyukeiyouItzHzn.
            getZtykanyuujihihokensyaage());
        pKbkSsuRnduHknIdouVTy.setZtykanyuujitenkanhyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtykanyuujitenkanhyouji());
        pKbkSsuRnduHknIdouVTy.setZtyhsyuikktminaosikaisu(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhsyuikktminaosikaisu());
        pKbkSsuRnduHknIdouVTy.setZtysknnjynbknsisnrt(pIdouMeisaiTyukeiyouItzHzn.getZtysknnjynbknsisnrt());
        pKbkSsuRnduHknIdouVTy.setZtytkjykbn(pIdouMeisaiTyukeiyouItzHzn.getZtytkjykbn());
        pKbkSsuRnduHknIdouVTy.setZtysakugenkikan(pIdouMeisaiTyukeiyouItzHzn.getZtysakugenkikan());
        pKbkSsuRnduHknIdouVTy.setZtyryoumasihyouten(pIdouMeisaiTyukeiyouItzHzn.getZtyryoumasihyouten());
        pKbkSsuRnduHknIdouVTy.setZtysykyktkjyuryumsratehyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtysykyktkjyuryumsratehyj());
        pKbkSsuRnduHknIdouVTy.setZtysykyktkjyuryumsrate(pIdouMeisaiTyukeiyouItzHzn.getZtysykyktkjyuryumsrate());
        pKbkSsuRnduHknIdouVTy.setZtydai2tokujyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtydai2tokujyoukbn());
        pKbkSsuRnduHknIdouVTy.setZtydai2sakugenkikan(pIdouMeisaiTyukeiyouItzHzn.getZtydai2sakugenkikan());
        pKbkSsuRnduHknIdouVTy.setZtydai2ryoumasihyouten(pIdouMeisaiTyukeiyouItzHzn.getZtydai2ryoumasihyouten());
        pKbkSsuRnduHknIdouVTy.setZtytokuteibuijyoukenhyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtytokuteibuijyoukenhyouji());
        pKbkSsuRnduHknIdouVTy.setZtytokuteibuino1(pIdouMeisaiTyukeiyouItzHzn.getZtytokuteibuino1());
        pKbkSsuRnduHknIdouVTy.setZtyhtnpkkn1(pIdouMeisaiTyukeiyouItzHzn.getZtyhtnpkkn1());
        pKbkSsuRnduHknIdouVTy.setZtytokuteibuino2(pIdouMeisaiTyukeiyouItzHzn.getZtytokuteibuino2());
        pKbkSsuRnduHknIdouVTy.setZtyhtnpkkn2(pIdouMeisaiTyukeiyouItzHzn.getZtyhtnpkkn2());
        pKbkSsuRnduHknIdouVTy.setZtymhituiryuyutktbijyknhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtymhituiryuyutktbijyknhyj());
        pKbkSsuRnduHknIdouVTy.setZtymuhaitouiryouyoutktbino1(pIdouMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyoutktbino1());
        pKbkSsuRnduHknIdouVTy.setZtymuhaitouiryouyouhtnpkkn1(pIdouMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyouhtnpkkn1());
        pKbkSsuRnduHknIdouVTy.setZtymuhaitouiryouyoutktbino2(pIdouMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyoutktbino2());
        pKbkSsuRnduHknIdouVTy.setZtymuhaitouiryouyouhtnpkkn2(pIdouMeisaiTyukeiyouItzHzn.
            getZtymuhaitouiryouyouhtnpkkn2());
        pKbkSsuRnduHknIdouVTy.setZtysiteizukipwarimasihyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtysiteizukipwarimasihyouji());
        pKbkSsuRnduHknIdouVTy.setZtypwarimasisiteim1(pIdouMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim1());
        pKbkSsuRnduHknIdouVTy.setZtypwarimasisiteim2(pIdouMeisaiTyukeiyouItzHzn.getZtypwarimasisiteim2());
        pKbkSsuRnduHknIdouVTy.setZtysiteimsykykpbairitu(pIdouMeisaiTyukeiyouItzHzn.getZtysiteimsykykpbairitu());
        pKbkSsuRnduHknIdouVTy.setZtysaisyuusiteiym(pIdouMeisaiTyukeiyouItzHzn.getZtysaisyuusiteiym());
        pKbkSsuRnduHknIdouVTy.setZtysykykkitmttvkeisanym(pIdouMeisaiTyukeiyouItzHzn.
            getZtysykykkitmttvkeisanym());
        pKbkSsuRnduHknIdouVTy.setZtysykykkitmttsknnjynbkngk(pIdouMeisaiTyukeiyouItzHzn.
            getZtysykykkitmttsknnjynbkngk());
        pKbkSsuRnduHknIdouVTy.setZtydftumitatekingaku(pIdouMeisaiTyukeiyouItzHzn.getZtydftumitatekingaku());
        pKbkSsuRnduHknIdouVTy.setZtydftumimasikin(pIdouMeisaiTyukeiyouItzHzn.getZtydftumimasikin());
        pKbkSsuRnduHknIdouVTy.setZtyvbubundftenkankakaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtyvbubundftenkankakaku());
        pKbkSsuRnduHknIdouVTy.setZtydpbubundftenkankakaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtydpbubundftenkankakaku());
        pKbkSsuRnduHknIdouVTy.setZtydftmttkngkitjbrbbn(pIdouMeisaiTyukeiyouItzHzn.getZtydftmttkngkitjbrbbn());
        pKbkSsuRnduHknIdouVTy.setZtyhendous(pIdouMeisaiTyukeiyouItzHzn.getZtyhendous());
        pKbkSsuRnduHknIdouVTy.setZtyhengakujigyounendomatucv(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhengakujigyounendomatucv());
        pKbkSsuRnduHknIdouVTy.setZtyitibuitijibarais(pIdouMeisaiTyukeiyouItzHzn.getZtyitibuitijibarais());
        pKbkSsuRnduHknIdouVTy.setZtyitibuitijibaraip(pIdouMeisaiTyukeiyouItzHzn.getZtyitibuitijibaraip());
        pKbkSsuRnduHknIdouVTy.setZtyitibitjbrshrkngk(pIdouMeisaiTyukeiyouItzHzn.getZtyitibitjbrshrkngk());
        pKbkSsuRnduHknIdouVTy.setZtygoukeicv(pIdouMeisaiTyukeiyouItzHzn.getZtygoukeicv());
        pKbkSsuRnduHknIdouVTy.setZtyminasicv(pIdouMeisaiTyukeiyouItzHzn.getZtyminasicv());
        pKbkSsuRnduHknIdouVTy.setZtyloanfund(pIdouMeisaiTyukeiyouItzHzn.getZtyloanfund());
        pKbkSsuRnduHknIdouVTy.setZtysaiteihosyougaku(pIdouMeisaiTyukeiyouItzHzn.getZtysaiteihosyougaku());
        pKbkSsuRnduHknIdouVTy.setZtyhngksitihsyuyusykykp(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhngksitihsyuyusykykp());
        pKbkSsuRnduHknIdouVTy.setZtyhijynbrivasbujsitihsyugk(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhijynbrivasbujsitihsyugk());
        pKbkSsuRnduHknIdouVTy.setZtyhijynbrivamnkjsitihsyugk(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhijynbrivamnkjsitihsyugk());
        pKbkSsuRnduHknIdouVTy.setZtysiinkbn(pIdouMeisaiTyukeiyouItzHzn.getZtysiinkbn());
        pKbkSsuRnduHknIdouVTy.setZtymudkaimasikihons(pIdouMeisaiTyukeiyouItzHzn.getZtymudkaimasikihons());
        pKbkSsuRnduHknIdouVTy.setZtykaimasiymd(pIdouMeisaiTyukeiyouItzHzn.getZtykaimasiymd());
        pKbkSsuRnduHknIdouVTy.setZtykaimasikikan(pIdouMeisaiTyukeiyouItzHzn.getZtykaimasikikan());
        pKbkSsuRnduHknIdouVTy.setZtyhikitugikaimasis(pIdouMeisaiTyukeiyouItzHzn.getZtyhikitugikaimasis());
        pKbkSsuRnduHknIdouVTy.setZtymudkaimasisiharaikingaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtymudkaimasisiharaikingaku());
        pKbkSsuRnduHknIdouVTy.setZtyszoukouryokukaisiymdx1(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszoukouryokukaisiymdx1());
        pKbkSsuRnduHknIdouVTy.setZtyszouhokensyuruikigoux1(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszouhokensyuruikigoux1());
        pKbkSsuRnduHknIdouVTy.setZtyszoukigousedaikbnx1(pIdouMeisaiTyukeiyouItzHzn.getZtyszoukigousedaikbnx1());
        pKbkSsuRnduHknIdouVTy.setZtyszoukikanx1(pIdouMeisaiTyukeiyouItzHzn.getZtyszoukikanx1());
        pKbkSsuRnduHknIdouVTy.setZtyszouhihokensyaagex1(pIdouMeisaiTyukeiyouItzHzn.getZtyszouhihokensyaagex1());
        pKbkSsuRnduHknIdouVTy.setZtyszoudai2hihknsyaagex1(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszoudai2hihknsyaagex1());
        pKbkSsuRnduHknIdouVTy.setZtyzoukasx1(pIdouMeisaiTyukeiyouItzHzn.getZtyzoukasx1());
        pKbkSsuRnduHknIdouVTy.setZtyzennendozoukasx1(pIdouMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx1());
        pKbkSsuRnduHknIdouVTy.setZtyszousiharaikingakux1(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszousiharaikingakux1());
        pKbkSsuRnduHknIdouVTy.setZtyszoukouryokukaisiymdx2(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszoukouryokukaisiymdx2());
        pKbkSsuRnduHknIdouVTy.setZtyszouhokensyuruikigoux2(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszouhokensyuruikigoux2());
        pKbkSsuRnduHknIdouVTy.setZtyszoukigousedaikbnx2(pIdouMeisaiTyukeiyouItzHzn.getZtyszoukigousedaikbnx2());
        pKbkSsuRnduHknIdouVTy.setZtyszoukikanx2(pIdouMeisaiTyukeiyouItzHzn.getZtyszoukikanx2());
        pKbkSsuRnduHknIdouVTy.setZtyszouhihokensyaagex2(pIdouMeisaiTyukeiyouItzHzn.getZtyszouhihokensyaagex2());
        pKbkSsuRnduHknIdouVTy.setZtyszoudai2hihknsyaagex2(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszoudai2hihknsyaagex2());
        pKbkSsuRnduHknIdouVTy.setZtyzoukasx2(pIdouMeisaiTyukeiyouItzHzn.getZtyzoukasx2());
        pKbkSsuRnduHknIdouVTy.setZtyzennendozoukasx2(pIdouMeisaiTyukeiyouItzHzn.getZtyzennendozoukasx2());
        pKbkSsuRnduHknIdouVTy.setZtyszousiharaikingakux2(pIdouMeisaiTyukeiyouItzHzn.
            getZtyszousiharaikingakux2());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin1x5(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x5());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin1x6(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin1x6());
        pKbkSsuRnduHknIdouVTy.setZtyhrimngkizktkykpmenhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhrimngkizktkykpmenhyj());
        pKbkSsuRnduHknIdouVTy.setZtymisyuustartym(pIdouMeisaiTyukeiyouItzHzn.getZtymisyuustartym());
        pKbkSsuRnduHknIdouVTy.setZtymisyuukaisuu(pIdouMeisaiTyukeiyouItzHzn.getZtymisyuukaisuu());
        pKbkSsuRnduHknIdouVTy.setZtyitjbrtkykkousnuktkarhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtyitjbrtkykkousnuktkarhyj());
        pKbkSsuRnduHknIdouVTy.setZtygyousekihyoujis(pIdouMeisaiTyukeiyouItzHzn.getZtygyousekihyoujis());
        pKbkSsuRnduHknIdouVTy.setZtysykykgyusekihyjs(pIdouMeisaiTyukeiyouItzHzn.getZtysykykgyusekihyjs());
        pKbkSsuRnduHknIdouVTy.setZtytenkangyousekihyoujis(pIdouMeisaiTyukeiyouItzHzn.
            getZtytenkangyousekihyoujis());
        pKbkSsuRnduHknIdouVTy.setZtytnknteikigyousekihyjs(pIdouMeisaiTyukeiyouItzHzn.
            getZtytnknteikigyousekihyjs());
        pKbkSsuRnduHknIdouVTy.setZtytnkndpbbngyuskhyjs(pIdouMeisaiTyukeiyouItzHzn.getZtytnkndpbbngyuskhyjs());
        pKbkSsuRnduHknIdouVTy.setZtykykjyoutai(pIdouMeisaiTyukeiyouItzHzn.getZtykykjyoutai());
        pKbkSsuRnduHknIdouVTy.setZtypmenhukakbn(pIdouMeisaiTyukeiyouItzHzn.getZtypmenhukakbn());
        pKbkSsuRnduHknIdouVTy.setZtykousinkbn(pIdouMeisaiTyukeiyouItzHzn.getZtykousinkbn());
        pKbkSsuRnduHknIdouVTy.setZtymankiyoteikbn(pIdouMeisaiTyukeiyouItzHzn.getZtymankiyoteikbn());
        pKbkSsuRnduHknIdouVTy.setZtysykyktikmnkyoteikbn(pIdouMeisaiTyukeiyouItzHzn.getZtysykyktikmnkyoteikbn());
        pKbkSsuRnduHknIdouVTy.setZtytnknsykykkhnmnkytikbn(pIdouMeisaiTyukeiyouItzHzn
            .getZtytnknsykykkhnmnkytikbn());
        pKbkSsuRnduHknIdouVTy.setZtytnknsykyktikmnkytikbn(pIdouMeisaiTyukeiyouItzHzn
            .getZtytnknsykyktikmnkytikbn());
        pKbkSsuRnduHknIdouVTy.setZtytenkanteikimankiyoteikbn(pIdouMeisaiTyukeiyouItzHzn
            .getZtytenkanteikimankiyoteikbn());
        pKbkSsuRnduHknIdouVTy.setZtyszoumankiyoteikbnx1(pIdouMeisaiTyukeiyouItzHzn.getZtyszoumankiyoteikbnx1());
        pKbkSsuRnduHknIdouVTy.setZtyszoumankiyoteikbnx2(pIdouMeisaiTyukeiyouItzHzn.getZtyszoumankiyoteikbnx2());
        pKbkSsuRnduHknIdouVTy
        .setZtyvestingmankiyoteikbn(pIdouMeisaiTyukeiyouItzHzn.getZtyvestingmankiyoteikbn());
        pKbkSsuRnduHknIdouVTy.setZtyvkeisanhyouji(pIdouMeisaiTyukeiyouItzHzn.getZtyvkeisanhyouji());
        pKbkSsuRnduHknIdouVTy.setZtytoukisinkeiyakuhyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtytoukisinkeiyakuhyouji());
        pKbkSsuRnduHknIdouVTy.setZtysykykhokenhoutekiyouhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtysykykhokenhoutekiyouhyj());
        pKbkSsuRnduHknIdouVTy.setZtytokuteijyoutaihushrhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtytokuteijyoutaihushrhyj());
        pKbkSsuRnduHknIdouVTy.setZtyytirrthndsysnmnskaisuu(pIdouMeisaiTyukeiyouItzHzn.
            getZtyytirrthndsysnmnskaisuu());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin3(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin3());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin11(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin11());
        pKbkSsuRnduHknIdouVTy.setZtywnasigoukeitenkankakaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtywnasigoukeitenkankakaku());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x2(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x2());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x3(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x3());
        pKbkSsuRnduHknIdouVTy.setZtytukibaraikansantokujyoup(pIdouMeisaiTyukeiyouItzHzn.
            getZtytukibaraikansantokujyoup());
        pKbkSsuRnduHknIdouVTy.setZtytnkngkykkssnkijyuym(pIdouMeisaiTyukeiyouItzHzn.getZtytnkngkykkssnkijyuym());
        pKbkSsuRnduHknIdouVTy.setZtysaiteihosyouhyouji(pIdouMeisaiTyukeiyouItzHzn.getZtysaiteihosyouhyouji());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin8x2(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin8x2());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin14(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin14());
        pKbkSsuRnduHknIdouVTy.setZtyhrimngtkykphrkkaisuukbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhrimngtkykphrkkaisuukbn());
        pKbkSsuRnduHknIdouVTy.setZtyhrimngtkykphrkkirkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyhrimngtkykphrkkirkbn());
        pKbkSsuRnduHknIdouVTy.setZtyhrimngtkykpryurtkbn(pIdouMeisaiTyukeiyouItzHzn.getZtyhrimngtkykpryurtkbn());
        pKbkSsuRnduHknIdouVTy.setZtyyobiv13(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv13());
        pKbkSsuRnduHknIdouVTy.setZtyidoujisaiteihosyoukngk(pIdouMeisaiTyukeiyouItzHzn.
            getZtyidoujisaiteihosyoukngk());
        pKbkSsuRnduHknIdouVTy.setZtyidoujisaiteihosyoucost(pIdouMeisaiTyukeiyouItzHzn.
            getZtyidoujisaiteihosyoucost());
        pKbkSsuRnduHknIdouVTy.setZtysinhokenfundtumitatekin(pIdouMeisaiTyukeiyouItzHzn.
            getZtysinhokenfundtumitatekin());
        pKbkSsuRnduHknIdouVTy.setZtymsyuptusshkgkaiykhnrikn(pIdouMeisaiTyukeiyouItzHzn.
            getZtymsyuptusshkgkaiykhnrikn());
        pKbkSsuRnduHknIdouVTy.setZtyrrthndugtnkgetumatuv(pIdouMeisaiTyukeiyouItzHzn.
            getZtyrrthndugtnkgetumatuv());
        pKbkSsuRnduHknIdouVTy.setZtyrrthndnksaiteihosyonkgns(pIdouMeisaiTyukeiyouItzHzn.
            getZtyrrthndnksaiteihosyonkgns());
        pKbkSsuRnduHknIdouVTy.setZtyrrthendougatanksibous(pIdouMeisaiTyukeiyouItzHzn.
            getZtyrrthendougatanksibous());
        pKbkSsuRnduHknIdouVTy.setZtyalmyousohutomeisyoukbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyalmyousohutomeisyoukbn());
        pKbkSsuRnduHknIdouVTy.setZtysnkyksoftmeisyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysnkyksoftmeisyoukbn());
        pKbkSsuRnduHknIdouVTy.setZtysoftmeisyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysoftmeisyoukbn());
        pKbkSsuRnduHknIdouVTy.setZtykykjitokujyouarihyj(pIdouMeisaiTyukeiyouItzHzn.getZtykykjitokujyouarihyj());
        pKbkSsuRnduHknIdouVTy.setZtybnkttnknkbn(pIdouMeisaiTyukeiyouItzHzn.getZtybnkttnknkbn());
        pKbkSsuRnduHknIdouVTy.setZtytenkanminaosikbn(pIdouMeisaiTyukeiyouItzHzn.getZtytenkanminaosikbn());
        pKbkSsuRnduHknIdouVTy.setZtysoujikeitenkankbn(pIdouMeisaiTyukeiyouItzHzn.getZtysoujikeitenkankbn());
        pKbkSsuRnduHknIdouVTy.setZtynenkinkaisinendo(pIdouMeisaiTyukeiyouItzHzn.getZtynenkinkaisinendo());
        pKbkSsuRnduHknIdouVTy.setZtynenkingatakbn(pIdouMeisaiTyukeiyouItzHzn.getZtynenkingatakbn());
        pKbkSsuRnduHknIdouVTy.setZtynknshry(pIdouMeisaiTyukeiyouItzHzn.getZtynknshry());
        pKbkSsuRnduHknIdouVTy.setZtyheiyoubaraikeiyakukbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyheiyoubaraikeiyakukbn());
        pKbkSsuRnduHknIdouVTy.setZtynenkinmaruteihukakbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtynenkinmaruteihukakbn());
        pKbkSsuRnduHknIdouVTy.setZtysinseizonmrtiarihyj(pIdouMeisaiTyukeiyouItzHzn.getZtysinseizonmrtiarihyj());
        pKbkSsuRnduHknIdouVTy.setZtysnkykyouibokijyukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysnkykyouibokijyukbn());
        pKbkSsuRnduHknIdouVTy.setZtytokusitujyuusitusetkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtytokusitujyuusitusetkbn());
        pKbkSsuRnduHknIdouVTy.setZtysiktsyuknbyugnhsyunshyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtysiktsyuknbyugnhsyunshyj());
        pKbkSsuRnduHknIdouVTy.setZtypmensugugtganhsyunshyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtypmensugugtganhsyunshyj());
        pKbkSsuRnduHknIdouVTy.setZtytkykgyousekihyjszerohyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtytkykgyousekihyjszerohyj());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin7(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin7());
        pKbkSsuRnduHknIdouVTy.setZtysyussaikeitaikbn(pIdouMeisaiTyukeiyouItzHzn.getZtysyussaikeitaikbn());
        pKbkSsuRnduHknIdouVTy.setZtyyobiv6(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv6());
        pKbkSsuRnduHknIdouVTy.setZtybosyuukeitaikbn(pIdouMeisaiTyukeiyouItzHzn.getZtybosyuukeitaikbn());
        pKbkSsuRnduHknIdouVTy.setZtyaatukaisosikicd(pIdouMeisaiTyukeiyouItzHzn.getZtyaatukaisosikicd());
        pKbkSsuRnduHknIdouVTy.setZtyaatukaikojincd(pIdouMeisaiTyukeiyouItzHzn.getZtyaatukaikojincd());
        pKbkSsuRnduHknIdouVTy.setZtybsydrtencd(pIdouMeisaiTyukeiyouItzHzn.getZtybsydrtencd());
        pKbkSsuRnduHknIdouVTy.setZtycifcd(pIdouMeisaiTyukeiyouItzHzn.getZtycifcd());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobiv8(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobiv8());
        pKbkSsuRnduHknIdouVTy.setZtysinsakbn(pIdouMeisaiTyukeiyouItzHzn.getZtysinsakbn());
        pKbkSsuRnduHknIdouVTy.setZtydai2hihokensyasinsakbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtydai2hihokensyasinsakbn());
        pKbkSsuRnduHknIdouVTy.setZtytoukeiyousinsakbn(pIdouMeisaiTyukeiyouItzHzn.getZtytoukeiyousinsakbn());
        pKbkSsuRnduHknIdouVTy.setZtydai2toukeiyousinsakbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtydai2toukeiyousinsakbn());
        pKbkSsuRnduHknIdouVTy.setZtyketteikijyunkanwakbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtyketteikijyunkanwakbn());
        pKbkSsuRnduHknIdouVTy.setZtykihonsibouhyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtykihonsibouhyoukbn());
        pKbkSsuRnduHknIdouVTy.setZtyteikisibouhyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyteikisibouhyoukbn());
        pKbkSsuRnduHknIdouVTy.setZtysonotasibouhyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysonotasibouhyoukbn());
        pKbkSsuRnduHknIdouVTy.setZtymrarihyj(pIdouMeisaiTyukeiyouItzHzn.getZtymrarihyj());
        pKbkSsuRnduHknIdouVTy.setZtysentakujyouhouarihyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtysentakujyouhouarihyouji());
        pKbkSsuRnduHknIdouVTy.setZtydugktnknsntkhuhukbn(pIdouMeisaiTyukeiyouItzHzn.getZtydugktnknsntkhuhukbn());
        pKbkSsuRnduHknIdouVTy.setZtygengakutenkankykhyj(pIdouMeisaiTyukeiyouItzHzn.getZtygengakutenkankykhyj());
        pKbkSsuRnduHknIdouVTy.setZtysykgycd(pIdouMeisaiTyukeiyouItzHzn.getZtysykgycd());
        pKbkSsuRnduHknIdouVTy.setZtyjidoukousinkykkanyuuymd(pIdouMeisaiTyukeiyouItzHzn.
            getZtyjidoukousinkykkanyuuymd());
        pKbkSsuRnduHknIdouVTy.setZtysaikohtnknkykkykymd(pIdouMeisaiTyukeiyouItzHzn.getZtysaikohtnknkykkykymd());
        pKbkSsuRnduHknIdouVTy.setZtykousinmaesykyksburtkbn(pIdouMeisaiTyukeiyouItzHzn.
            getZtykousinmaesykyksburtkbn());
        pKbkSsuRnduHknIdouVTy.setZtyhjnkykhyj(pIdouMeisaiTyukeiyouItzHzn.getZtyhjnkykhyj());
        pKbkSsuRnduHknIdouVTy.setZtyanniskcd(pIdouMeisaiTyukeiyouItzHzn.getZtyanniskcd());
        pKbkSsuRnduHknIdouVTy.setZtyhjncd(pIdouMeisaiTyukeiyouItzHzn.getZtyhjncd());
        pKbkSsuRnduHknIdouVTy.setZtyhjnjigyosyocd(pIdouMeisaiTyukeiyouItzHzn.getZtyhjnjigyosyocd());
        pKbkSsuRnduHknIdouVTy.setZtysaihokenno(pIdouMeisaiTyukeiyouItzHzn.getZtysaihokenno());
        pKbkSsuRnduHknIdouVTy.setZtydakuhikettikekkacd(pIdouMeisaiTyukeiyouItzHzn.getZtydakuhikettikekkacd());
        pKbkSsuRnduHknIdouVTy.setZtydai2dakuhiketteikekkacd(pIdouMeisaiTyukeiyouItzHzn.
            getZtydai2dakuhiketteikekkacd());
        pKbkSsuRnduHknIdouVTy.setZtypmenkbnv2(pIdouMeisaiTyukeiyouItzHzn.getZtypmenkbnv2());
        pKbkSsuRnduHknIdouVTy.setZtysiboukyuuhukin(pIdouMeisaiTyukeiyouItzHzn.getZtysiboukyuuhukin());
        pKbkSsuRnduHknIdouVTy.setZtyjyudthumeharaitkykhkhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtyjyudthumeharaitkykhkhyj());
        pKbkSsuRnduHknIdouVTy.setZtyhaitoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtyhaitoukbn());
        pKbkSsuRnduHknIdouVTy.setZtyhhknnentysihyj(pIdouMeisaiTyukeiyouItzHzn.getZtyhhknnentysihyj());
        pKbkSsuRnduHknIdouVTy.setZtydai2hhknnentysihyj(pIdouMeisaiTyukeiyouItzHzn.getZtydai2hhknnentysihyj());
        pKbkSsuRnduHknIdouVTy.setZtykyksyaagetyouseihyj(pIdouMeisaiTyukeiyouItzHzn.getZtykyksyaagetyouseihyj());
        pKbkSsuRnduHknIdouVTy.setZtykituenkbn(pIdouMeisaiTyukeiyouItzHzn.getZtykituenkbn());
        pKbkSsuRnduHknIdouVTy.setZtykituenhonsuu(pIdouMeisaiTyukeiyouItzHzn.getZtykituenhonsuu());
        pKbkSsuRnduHknIdouVTy.setZtymusentakukeiyakukbn(pIdouMeisaiTyukeiyouItzHzn.getZtymusentakukeiyakukbn());
        pKbkSsuRnduHknIdouVTy.setZtyyobiv6x2(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv6x2());
        pKbkSsuRnduHknIdouVTy.setZtylivingneedstkykarihyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtylivingneedstkykarihyj());
        pKbkSsuRnduHknIdouVTy.setZtylivingneedssiharaihyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtylivingneedssiharaihyouji());
        pKbkSsuRnduHknIdouVTy.setZtylnseikyuuymd(pIdouMeisaiTyukeiyouItzHzn.getZtylnseikyuuymd());
        pKbkSsuRnduHknIdouVTy.setZtylnshrgenincd(pIdouMeisaiTyukeiyouItzHzn.getZtylnshrgenincd());
        pKbkSsuRnduHknIdouVTy.setZtydakuhikettisyacd(pIdouMeisaiTyukeiyouItzHzn.getZtydakuhikettisyacd());
        pKbkSsuRnduHknIdouVTy.setZtydai2dakuhiketteisyacd(pIdouMeisaiTyukeiyouItzHzn.
            getZtydai2dakuhiketteisyacd());
        pKbkSsuRnduHknIdouVTy.setZtygansapotokuyakuarihyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtygansapotokuyakuarihyouji());
        pKbkSsuRnduHknIdouVTy.setZtygnspshrhyj(pIdouMeisaiTyukeiyouItzHzn.getZtygnspshrhyj());
        pKbkSsuRnduHknIdouVTy.setZtygansaposeikyuuymd(pIdouMeisaiTyukeiyouItzHzn.getZtygansaposeikyuuymd());
        pKbkSsuRnduHknIdouVTy.setZtygnspshrgenincd(pIdouMeisaiTyukeiyouItzHzn.getZtygnspshrgenincd());
        pKbkSsuRnduHknIdouVTy.setZtyyobiv3x2(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv3x2());
        pKbkSsuRnduHknIdouVTy.setZtytargetmokuhyouritu(pIdouMeisaiTyukeiyouItzHzn.getZtytargetmokuhyouritu());
        pKbkSsuRnduHknIdouVTy.setZtyautoswitchmokuhyouritu(pIdouMeisaiTyukeiyouItzHzn.
            getZtyautoswitchmokuhyouritu());
        pKbkSsuRnduHknIdouVTy.setZtytumitatekinitenarihyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtytumitatekinitenarihyj());
        pKbkSsuRnduHknIdouVTy.setZtytumitatekinitenkaisuu(pIdouMeisaiTyukeiyouItzHzn.
            getZtytumitatekinitenkaisuu());
        pKbkSsuRnduHknIdouVTy.setZtydatakanrino2(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino2());
        pKbkSsuRnduHknIdouVTy.setZtydatakanrino3(pIdouMeisaiTyukeiyouItzHzn.getZtydatakanrino3());
        pKbkSsuRnduHknIdouVTy.setZtyknkuzusnzyrttekinendo(pIdouMeisaiTyukeiyouItzHzn.
            getZtyknkuzusnzyrttekinendo());
        pKbkSsuRnduHknIdouVTy.setZtyknkuzusnzyrt(pIdouMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrt());
        pKbkSsuRnduHknIdouVTy.setZtyknkuzusnzyrtx2(pIdouMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx2());
        pKbkSsuRnduHknIdouVTy.setZtyknkuzusnzyrtx3(pIdouMeisaiTyukeiyouItzHzn.getZtyknkuzusnzyrtx3());
        pKbkSsuRnduHknIdouVTy.setZtysinkeiyakujiknkuzusnzyrt(pIdouMeisaiTyukeiyouItzHzn.
            getZtysinkeiyakujiknkuzusnzyrt());
        pKbkSsuRnduHknIdouVTy.setZtytenkanjiknkuzusnzyrt(pIdouMeisaiTyukeiyouItzHzn.
            getZtytenkanjiknkuzusnzyrt());
        pKbkSsuRnduHknIdouVTy.setZtysinkeiyakujivithkhyouji(pIdouMeisaiTyukeiyouItzHzn.
            getZtysinkeiyakujivithkhyouji());
        pKbkSsuRnduHknIdouVTy.setZtykykjivithukusuukykhyj(pIdouMeisaiTyukeiyouItzHzn.getZtykykjivithukusuukykhyj());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin9x2(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9x2());
        pKbkSsuRnduHknIdouVTy.setZtypwrbksidhitekiyouhyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtypwrbksidhitekiyouhyj());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin9(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin9());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin10x7(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x7());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin10x8(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x8());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin10x9(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x9());
        pKbkSsuRnduHknIdouVTy.setZtytumitatekinitenbubun(pIdouMeisaiTyukeiyouItzHzn.
            getZtytumitatekinitenbubun());
        pKbkSsuRnduHknIdouVTy.setZtysagakusknnjynbknzndk(pIdouMeisaiTyukeiyouItzHzn.
            getZtysagakusknnjynbknzndk());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x5(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x5());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x6(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x6());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x7(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x7());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x8(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x8());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x9(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x9());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x10(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x10());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x11(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x11());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x12(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x12());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x13(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x13());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x14(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x14());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x15(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x15());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x16(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x16());
        pKbkSsuRnduHknIdouVTy.setZtyyobin11x17(pIdouMeisaiTyukeiyouItzHzn.getZtyyobin11x17());
        pKbkSsuRnduHknIdouVTy.setZtyzyrthntiyustatuskbn(pIdouMeisaiTyukeiyouItzHzn.getZtyzyrthntiyustatuskbn());
        pKbkSsuRnduHknIdouVTy.setZtyzyrthntiyustatuskbnx2(pIdouMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx2());
        pKbkSsuRnduHknIdouVTy.setZtyzyrthntiyustatuskbnx3(pIdouMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx3());
        pKbkSsuRnduHknIdouVTy.setZtyzyrthntiyustatuskbnx4(pIdouMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx4());
        pKbkSsuRnduHknIdouVTy.setZtyzyrthntiyustatuskbnx5(pIdouMeisaiTyukeiyouItzHzn.
            getZtyzyrthntiyustatuskbnx5());
        pKbkSsuRnduHknIdouVTy.setZtyyobiv10(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv10());
        pKbkSsuRnduHknIdouVTy.setZtyyobiv15x2(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv15x2());
        pKbkSsuRnduHknIdouVTy.setZtyyobiv15x3(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv15x3());
        pKbkSsuRnduHknIdouVTy.setZtyyobiv15x4(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv15x4());
        pKbkSsuRnduHknIdouVTy.setZtygaikakbn(pIdouMeisaiTyukeiyouItzHzn.getZtygaikakbn());
        pKbkSsuRnduHknIdouVTy.setZtykawaserate1(pIdouMeisaiTyukeiyouItzHzn.getZtykawaserate1());
        pKbkSsuRnduHknIdouVTy.setZtykawaseratetekiyouymd1(pIdouMeisaiTyukeiyouItzHzn.
            getZtykawaseratetekiyouymd1());
        pKbkSsuRnduHknIdouVTy.setZtykawaserate2(pIdouMeisaiTyukeiyouItzHzn.getZtykawaserate2());
        pKbkSsuRnduHknIdouVTy.setZtykawaseratetekiyouymd2(pIdouMeisaiTyukeiyouItzHzn.
            getZtykawaseratetekiyouymd2());
        pKbkSsuRnduHknIdouVTy.setZtykykjikawaserate(pIdouMeisaiTyukeiyouItzHzn.getZtykykjikawaserate());
        pKbkSsuRnduHknIdouVTy.setZtykykjikawaseratetkyuymd(pIdouMeisaiTyukeiyouItzHzn.
            getZtykykjikawaseratetkyuymd());
        pKbkSsuRnduHknIdouVTy.setZtymvatyouseigow(pIdouMeisaiTyukeiyouItzHzn.getZtymvatyouseigow());
        pKbkSsuRnduHknIdouVTy.setZtymvakeisanjisknnjynbkn(pIdouMeisaiTyukeiyouItzHzn.
            getZtymvakeisanjisknnjynbkn());
        pKbkSsuRnduHknIdouVTy.setZtykaiyakukoujyoritu(pIdouMeisaiTyukeiyouItzHzn.getZtykaiyakukoujyoritu());
        pKbkSsuRnduHknIdouVTy.setZtyrendouritu(pIdouMeisaiTyukeiyouItzHzn.getZtyrendouritu());
        pKbkSsuRnduHknIdouVTy.setZtysrkaiyakusjkkktyouseirrt(pIdouMeisaiTyukeiyouItzHzn.
            getZtysrkaiyakusjkkktyouseirrt());
        pKbkSsuRnduHknIdouVTy.setZtysrkyksjkkktyouseiriritu(pIdouMeisaiTyukeiyouItzHzn.
            getZtysrkyksjkkktyouseiriritu());
        pKbkSsuRnduHknIdouVTy.setZtymvakeisankijyunymd(pIdouMeisaiTyukeiyouItzHzn.getZtymvakeisankijyunymd());
        pKbkSsuRnduHknIdouVTy.setZtymvatyouseikou(pIdouMeisaiTyukeiyouItzHzn.getZtymvatyouseikou());
        pKbkSsuRnduHknIdouVTy.setZtyenkdtsbujsitihsyukngk(pIdouMeisaiTyukeiyouItzHzn.
            getZtyenkdtsbujsitihsyukngk());
        pKbkSsuRnduHknIdouVTy.setZtyenkdtsbujsitihsyucost(pIdouMeisaiTyukeiyouItzHzn.
            getZtyenkdtsbujsitihsyucost());
        pKbkSsuRnduHknIdouVTy.setZtyenkdtsbujsitihsyuarihyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtyenkdtsbujsitihsyuarihyj());
        pKbkSsuRnduHknIdouVTy.setZtykeiyakujiyoteiriritu(pIdouMeisaiTyukeiyouItzHzn.
            getZtykeiyakujiyoteiriritu());
        pKbkSsuRnduHknIdouVTy.setZtytumitateriritu(pIdouMeisaiTyukeiyouItzHzn.getZtytumitateriritu());
        pKbkSsuRnduHknIdouVTy.setZtykaigomaebaraitkykarihyj(pIdouMeisaiTyukeiyouItzHzn.
            getZtykaigomaebaraitkykarihyj());
        pKbkSsuRnduHknIdouVTy.setZtysibouhyoukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysibouhyoukbn());
        pKbkSsuRnduHknIdouVTy.setZtynyuukintuukakbn(pIdouMeisaiTyukeiyouItzHzn.getZtynyuukintuukakbn());
        pKbkSsuRnduHknIdouVTy.setZtysiharaituukakbn(pIdouMeisaiTyukeiyouItzHzn.getZtysiharaituukakbn());
        pKbkSsuRnduHknIdouVTy.setZtywyendttargetmokuhyouritu(pIdouMeisaiTyukeiyouItzHzn.
            getZtywyendttargetmokuhyouritu());
        pKbkSsuRnduHknIdouVTy.setZtysisuurendourate(pIdouMeisaiTyukeiyouItzHzn.getZtysisuurendourate());
        pKbkSsuRnduHknIdouVTy.setZtysisuukbn(pIdouMeisaiTyukeiyouItzHzn.getZtysisuukbn());
        pKbkSsuRnduHknIdouVTy.setZtyteirituikouhyouji(pIdouMeisaiTyukeiyouItzHzn.getZtyteirituikouhyouji());
        pKbkSsuRnduHknIdouVTy.setZtysuuriyouyobin10x11(pIdouMeisaiTyukeiyouItzHzn.getZtysuuriyouyobin10x11());
        pKbkSsuRnduHknIdouVTy.setZtytmttknzoukaritujygn(pIdouMeisaiTyukeiyouItzHzn.getZtytmttknzoukaritujygn());
        pKbkSsuRnduHknIdouVTy.setZtysetteibairitu(pIdouMeisaiTyukeiyouItzHzn.getZtysetteibairitu());
        pKbkSsuRnduHknIdouVTy.setZtytykzenoutouymdsisuu(pIdouMeisaiTyukeiyouItzHzn.getZtytykzenoutouymdsisuu());
        pKbkSsuRnduHknIdouVTy.setZtykimatusisuu(pIdouMeisaiTyukeiyouItzHzn.getZtykimatusisuu());
        pKbkSsuRnduHknIdouVTy.setZtyyenkadatekihons(pIdouMeisaiTyukeiyouItzHzn.getZtyyenkadatekihons());
        pKbkSsuRnduHknIdouVTy.setZtysitihsyumegkdtsibous(pIdouMeisaiTyukeiyouItzHzn.
            getZtysitihsyumegkdtsibous());
        pKbkSsuRnduHknIdouVTy.setZtyenkdtssrentumitatekin(pIdouMeisaiTyukeiyouItzHzn.
            getZtyenkdtssrentumitatekin());
        pKbkSsuRnduHknIdouVTy.setZtysisuurentumitatekin(pIdouMeisaiTyukeiyouItzHzn.getZtysisuurentumitatekin());
        pKbkSsuRnduHknIdouVTy.setZtynksjitirttumitatekin(pIdouMeisaiTyukeiyouItzHzn.
            getZtynksjitirttumitatekin());
        pKbkSsuRnduHknIdouVTy.setZtykimatutirttumitatekin(pIdouMeisaiTyukeiyouItzHzn.
            getZtykimatutirttumitatekin());
        pKbkSsuRnduHknIdouVTy.setZtygaikadatejyuutoup(pIdouMeisaiTyukeiyouItzHzn.getZtygaikadatejyuutoup());
        pKbkSsuRnduHknIdouVTy.setZtyyendttargetkijyunkingaku(pIdouMeisaiTyukeiyouItzHzn.
            getZtyyendttargetkijyunkingaku());
        pKbkSsuRnduHknIdouVTy.setZtyyobiv7(pIdouMeisaiTyukeiyouItzHzn.getZtyyobiv7());
        pKbkSsuRnduHknIdouVTy.setZtysitivkisnyukykjikwsrate(pIdouMeisaiTyukeiyouItzHzn.
            getZtysitivkisnyukykjikwsrate());
        pKbkSsuRnduHknIdouVTy.setZtysisuurentyokugotmttkn(pIdouMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());
        pKbkSsuRnduHknIdouVTy.setZtyrrthnduhknvkisovkisnyu1(pIdouMeisaiTyukeiyouItzHzn.getZtyrrthnduhknvkisovkisnyu1());
    }

    public void editSkeiKoumoku(
        SrKbkSsuRnduHknIdouVBatchParam pSrKbkSsuRnduHknIdouVBatchParam,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SV_SnkiykGtjSirt pSnkiykGtjSirt,
        IT_KykKihon pKykKihon,
        BM_SyouhnZokusei pSyouhnZokusei,
        IT_KykDairiten pKykDairiten,
        IT_NyknJissekiRireki pNyknJissekiRireki,
        IT_ItekiToukeiInfo pItekiToukeiInfo,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn,
        ZT_KbkSsuRnduHknIdouVTy pKbkSsuRnduHknIdouVTy) {

        SrKbkSsuRnduHknIdouVBatchDbAccess batchDbAccess =
            SWAKInjector.getInstance(SrKbkSsuRnduHknIdouVBatchDbAccess.class);
        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);
        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);
        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        SrSuuriGouseiRateKeisan srSuuriGouseiRateKeisan = SWAKInjector.getInstance(SrSuuriGouseiRateKeisan.class);
        KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd =
            SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

        String suuriSyuruiCd = "";
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
        BizNumber srKaiyakuSjkkktyouseirrt = BizNumber.valueOf(0);
        String sibouhyouKbn = "";
        String nyuukintuukaKbn = "";
        String wyendttargetMokuhyouritu = "";
        String sisuuKbn = "";
        BizCurrency nksjitirtTumitatekin = BizCurrency.valueOf(0);
        Long yendttargetKijyunkingaku = Long.valueOf(0);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(
            C_SrKbnHenkanKbn.SUURISYURUI,
            pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

        C_ErrorKbn errorKbn = srSuuriKbnHenkanBean.getKekkaKbn();

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            String msg = MessageUtil.getMessage(MessageId.ESA1002,
                C_SrKbnHenkanKbn.SUURISYURUI.getContent(),
                pSnkiykGtjSirt.getSyono(),
                pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd()
                );

            batchLogger.warn(msg);

            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

            suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {
            suuriSyuruiCd = srSuuriKbnHenkanBean.getHenkanAtoKbn();
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

            suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
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

            suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
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

            suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
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

            suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
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

            suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
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
            suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
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

                suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                    pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
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

                suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                    pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
                errorFlag = true;
            }
            else {

                kykjiKawaserate = srSuuriGouseiRateKeisanBean.getSuuriGouseiRate();
            }
        }

        BizDate kaiyakuSjkkkTyouseiRirituKijyunYmd = null;
        if (BizDateUtil.compareYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd(),
            pTkJitenKeiyakuSyouhinKijyunBean.getKykymd()) == BizDateUtil.COMPARE_LESSER) {
            kaiyakuSjkkkTyouseiRirituKijyunYmd = pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd();
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

            suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
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

            suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
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

            suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
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

            suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
            errorFlag = true;
        }
        else {
            sisuuKbn = srSuuriKbnHenkanBean8.getHenkanAtoKbn();
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

            suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
            suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
            suuriyouErrJyouhou.setSyono(pSnkiykGtjSirt.getSyono());
            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

            pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
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

        pKbkSsuRnduHknIdouVTy.setZtyrecordkbn(SrCommonConstants.RECORDKBN_IDOUMEISAI);
        pKbkSsuRnduHknIdouVTy.setZtykeijyouym(pSnkiykGtjSirt.getSkeikeijyouym().toString());
        pKbkSsuRnduHknIdouVTy.setZtyidojiyukbn(SrCommonConstants.IDOUJIYUUKBN_SINKEIYAKUSEIRITU);
        pKbkSsuRnduHknIdouVTy.setZtyidourecordkbn(C_IdouRecordKbn.SINGLERECORD.getValue());
        pKbkSsuRnduHknIdouVTy.setZtykeijyouctrlkbn(SrCommonConstants.KIJYCTRLKBN_SONOTA);
        pKbkSsuRnduHknIdouVTy.setZtysuuriyoukouryokukaisiymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        pKbkSsuRnduHknIdouVTy.setZtyraysystemhyj(SrCommonConstants.HYOUJI_ARI);
        pKbkSsuRnduHknIdouVTy.setZtybsyym(pKykKihon.getBosyuuym().toString());
        pKbkSsuRnduHknIdouVTy.setZtyidoujiyuucd(SrCommonConstants.IDOUJIYUCD_DAITYOUSINKEIYAKU);
        pKbkSsuRnduHknIdouVTy.setZtydatakanrino(pSnkiykGtjSirt.getSyono());
        pKbkSsuRnduHknIdouVTy.setZtyhknsyukigou(pTkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());
        pKbkSsuRnduHknIdouVTy.setZtyhknsyuruikigousedaikbn(pTkJitenKeiyakuSyouhinKijyunBean.getRyouritusdno());
        pKbkSsuRnduHknIdouVTy.setZtysotodasipmenkbn(SrCommonConstants.HKNSYKGUYBI3X2_PMENTKYKNASI);
        pKbkSsuRnduHknIdouVTy.setZtystdssytikbn(SrCommonConstants.HKNSYKGUYBI1X1_SONOTA);
        pKbkSsuRnduHknIdouVTy.setZtystdssnskbn(SrCommonConstants.HKNSYKGUYBI3X1_MUSINSA);
        pKbkSsuRnduHknIdouVTy.setZtysotodasimanagehyouji(SrCommonConstants.HYOUJI_ARI);
        pKbkSsuRnduHknIdouVTy.setZtysotodasiphkbnmnoshyouji(SrCommonConstants.HYOUJI_ARI);
        pKbkSsuRnduHknIdouVTy.setZtystdsstkjytkyuhyj(SrCommonConstants.HYOUJI_ARI);
        pKbkSsuRnduHknIdouVTy.setZtykbnkeiriyousegmentkbn(pSyouhnZokusei.getSeg1cd().getValue().substring(0, 2));
        pKbkSsuRnduHknIdouVTy.setZtykbnkeiriyourgnbnskkbn(pSyouhnZokusei.getSeg1cd().getValue().substring(2, 4));
        pKbkSsuRnduHknIdouVTy.setZtysuurisyuruicd(suuriSyuruiCd);
        pKbkSsuRnduHknIdouVTy.setZtyhosyoukinoukbn(C_HosyouKinouKbn.BLNK.getValue());
        pKbkSsuRnduHknIdouVTy.setZtydaikbn(C_DaiKbn.KOJINNENKIN_SISUU.getValue());
        pKbkSsuRnduHknIdouVTy.setZtytyuukbn(C_TyuuKbn.SITEITUKANNKN.getValue());
        pKbkSsuRnduHknIdouVTy.setZtysyoukbn(C_SyouKbn.SITEITUKANNKN.getValue());
        pKbkSsuRnduHknIdouVTy.setZtysedaikbn(sedaiKbn);
        pKbkSsuRnduHknIdouVTy.setZtyharaikatakbn(SrCommonConstants.HARAIKATAKBN_ITIJIBARAI);
        pKbkSsuRnduHknIdouVTy.setZtykykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        pKbkSsuRnduHknIdouVTy.setZtyhknkkn(pTkJitenKeiyakuSyouhinKijyunBean.getHknkkn().toString());
        pKbkSsuRnduHknIdouVTy.setZtyphrkkikn(SrCommonConstants.PHARAIKOMIKIKAN_ITIJIBARAI);
        pKbkSsuRnduHknIdouVTy.setZtysaimnkkykhyj(saimnkKykhyj);
        pKbkSsuRnduHknIdouVTy.setZtyannaifuyouriyuukbn(SrCommonConstants.ANNAIFUYOURIYUUKBN_ITIJIBARAI);
        pKbkSsuRnduHknIdouVTy.setZtytksyuannaikykkbn(SrCommonConstants.TKSYUANNAIKYKKBN_TAISYOUGAI);
        pKbkSsuRnduHknIdouVTy.setZtyhrkkaisuukbn(SrCommonConstants.HRKKAISUUKBN_ITIJIBARAI);
        pKbkSsuRnduHknIdouVTy.setZtysdpdkbn(pSnkiykGtjSirt.getSdpdkbn().getValue());
        pKbkSsuRnduHknIdouVTy.setZtyryouritukbn(SrCommonConstants.RYOURITUKBN_HUTUUITIJIBARAI);
        pKbkSsuRnduHknIdouVTy.setZtyhhknseikbn(pTkJitenKeiyakuSyouhinKijyunBean.getHhknsei().toString());
        pKbkSsuRnduHknIdouVTy.setZtyhihokensyaagev2(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        pKbkSsuRnduHknIdouVTy.setZtykyksyanen(kyksyanenTyouseigo);
        pKbkSsuRnduHknIdouVTy.setZtytkbthsyumnryuhyouji(SrCommonConstants.HYOUJI_NASI);
        pKbkSsuRnduHknIdouVTy.setZtysyukeiyakupwaribikikbn(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pKbkSsuRnduHknIdouVTy.setZtytenkanwaribikikbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pKbkSsuRnduHknIdouVTy.setZtyyuuhitutnknyuguryurtkbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pKbkSsuRnduHknIdouVTy.setZtysyukeiyakup(Long.parseLong(
            pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString()));
        pKbkSsuRnduHknIdouVTy.setZtyatukaisisyatodouhukencd(pSnkiykGtjSirt.getDrtenkanritodoufukencd());
        pKbkSsuRnduHknIdouVTy.setZtytokuyakuhukasuu(SrCommonConstants.DEFAULT_INT_ZERO);
        pKbkSsuRnduHknIdouVTy.setZtyhrimnentyoumaephrkkkn(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pKbkSsuRnduHknIdouVTy.setZtytokubetuhosyoukikan(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pKbkSsuRnduHknIdouVTy.setZtykousinmanryouage(SrCommonConstants.DEFAULT_STRING_ZERO_2);
        pKbkSsuRnduHknIdouVTy.setZtykanyujidatakanrino(pSnkiykGtjSirt.getSyono());
        pKbkSsuRnduHknIdouVTy.setZtykanyujikykymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        pKbkSsuRnduHknIdouVTy.setZtykanyuujihihokensyaage(pTkJitenKeiyakuSyouhinKijyunBean.getHhknnen().toString());
        pKbkSsuRnduHknIdouVTy.setZtykykjyoutai(SrCommonConstants.KEIYAKUJYOUTAI_ITIJIBARAI);
        pKbkSsuRnduHknIdouVTy.setZtypmenhukakbn(SrCommonConstants.PMENHUKAKBN_PMENTKYKNASI);
        pKbkSsuRnduHknIdouVTy.setZtysykykhokenhoutekiyouhyj(SrCommonConstants.HYOUJI_ARI);
        pKbkSsuRnduHknIdouVTy.setZtyalmyousohutomeisyoukbn(C_ALMSoftKbn.BLNK.getValue());
        pKbkSsuRnduHknIdouVTy.setZtysnkyksoftmeisyoukbn(C_SkeiSoftKbn.TANTAI.getValue());
        pKbkSsuRnduHknIdouVTy.setZtynenkinkaisinendo(nenkinkaisiNendo);
        pKbkSsuRnduHknIdouVTy.setZtynenkingatakbn(nenkingataKbn);
        pKbkSsuRnduHknIdouVTy.setZtynknshry(pTkJitenKeiyakuSyouhinKijyunBean.getNenkinkkn().toString());
        pKbkSsuRnduHknIdouVTy.setZtysiktsyuknbyugnhsyunshyj(SrCommonConstants.HYOUJI_NASI);
        pKbkSsuRnduHknIdouVTy.setZtypmensugugtganhsyunshyj(SrCommonConstants.HYOUJI_NASI);
        pKbkSsuRnduHknIdouVTy.setZtytkykgyousekihyjszerohyj(SrCommonConstants.HYOUJI_NASI);
        pKbkSsuRnduHknIdouVTy.setZtybosyuukeitaikbn(bosyuukeitaiKbn);
        pKbkSsuRnduHknIdouVTy.setZtyaatukaisosikicd(pKykDairiten.getDrtenkanrisosikicd());
        pKbkSsuRnduHknIdouVTy.setZtyaatukaikojincd(pKykDairiten.getDaibosyuucd());
        pKbkSsuRnduHknIdouVTy.setZtybsydrtencd(pKykDairiten.getDrtencd());
        pKbkSsuRnduHknIdouVTy.setZtycifcd(pKykKihon.getCifcd());
        pKbkSsuRnduHknIdouVTy.setZtysinsakbn(SrCommonConstants.SINSAKBN_SONOTA);
        pKbkSsuRnduHknIdouVTy.setZtytoukeiyousinsakbn(SrCommonConstants.TOUKEIYOUSINSAKBN_MUSENTAKU);
        pKbkSsuRnduHknIdouVTy.setZtyketteikijyunkanwakbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pKbkSsuRnduHknIdouVTy.setZtysykgycd(pSnkiykGtjSirt.getHhknsykgycd());
        pKbkSsuRnduHknIdouVTy.setZtydakuhikettikekkacd(pItekiToukeiInfo.getKetkekkacd().getValue());
        pKbkSsuRnduHknIdouVTy.setZtysiboukyuuhukin(Long.parseLong(
            pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString()));
        pKbkSsuRnduHknIdouVTy.setZtyhaitoukbn(haitouKbn);
        pKbkSsuRnduHknIdouVTy.setZtyhhknnentysihyj(hhknnenTysihyj);
        pKbkSsuRnduHknIdouVTy.setZtykyksyaagetyouseihyj(kyksyaageTyouseihyj);
        pKbkSsuRnduHknIdouVTy.setZtykituenkbn(SrCommonConstants.KITUENKBN_HUMEI);
        pKbkSsuRnduHknIdouVTy.setZtymusentakukeiyakukbn(SrCommonConstants.DEFAULT_STRING_ZERO_1);
        pKbkSsuRnduHknIdouVTy.setZtytargetmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        pKbkSsuRnduHknIdouVTy.setZtyautoswitchmokuhyouritu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        pKbkSsuRnduHknIdouVTy.setZtytumitatekinitenarihyj(SrCommonConstants.HYOUJI_NASI);
        pKbkSsuRnduHknIdouVTy.setZtytumitatekinitenkaisuu(SrCommonConstants.DEFAULT_STRING_ZERO_3);
        pKbkSsuRnduHknIdouVTy.setZtygaikakbn(gaikaKbn);
        pKbkSsuRnduHknIdouVTy.setZtykawaserate2(kawaserate2);
        pKbkSsuRnduHknIdouVTy.setZtykawaseratetekiyouymd2(kawaserateTekiyouymd2);
        pKbkSsuRnduHknIdouVTy.setZtykykjikawaserate(kykjiKawaserate);
        pKbkSsuRnduHknIdouVTy.setZtykykjikawaseratetkyuymd(kykjiKawaserateTkyuymd);
        pKbkSsuRnduHknIdouVTy.setZtymvatyouseigow(Long.parseLong(
            pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString()));
        pKbkSsuRnduHknIdouVTy.setZtymvakeisanjisknnjynbkn(Long.parseLong(
            pTkJitenKeiyakuSyouhinKijyunBean.getHokenryou().toAdsoluteString()));
        pKbkSsuRnduHknIdouVTy.setZtyrendouritu(pTkJitenKeiyakuSyouhinKijyunBean.getRendouritu());
        pKbkSsuRnduHknIdouVTy.setZtysrkaiyakusjkkktyouseirrt(srKaiyakuSjkkktyouseirrt);
        pKbkSsuRnduHknIdouVTy.setZtysrkyksjkkktyouseiriritu(
            pTkJitenKeiyakuSyouhinKijyunBean.getKyksjkkktyouseiriritu());
        pKbkSsuRnduHknIdouVTy.setZtymvakeisankijyunymd(pTkJitenKeiyakuSyouhinKijyunBean.getKykymd().toString());
        pKbkSsuRnduHknIdouVTy.setZtymvatyouseikou(pSyouhnZokusei.getMvatyouseijikou());
        pKbkSsuRnduHknIdouVTy.setZtykeiyakujiyoteiriritu(
            pTkJitenKeiyakuSyouhinKijyunBean.getYoteiriritu());
        pKbkSsuRnduHknIdouVTy.setZtytumitateriritu(pTkJitenKeiyakuSyouhinKijyunBean.getTumitateriritu());
        pKbkSsuRnduHknIdouVTy.setZtysibouhyoukbn(sibouhyouKbn);
        pKbkSsuRnduHknIdouVTy.setZtynyuukintuukakbn(nyuukintuukaKbn);
        pKbkSsuRnduHknIdouVTy.setZtywyendttargetmokuhyouritu(wyendttargetMokuhyouritu);
        pKbkSsuRnduHknIdouVTy.setZtysisuurendourate(
            pTkJitenKeiyakuSyouhinKijyunBean.getKykjisisuurendourate().toString());
        pKbkSsuRnduHknIdouVTy.setZtysisuukbn(sisuuKbn);
        pKbkSsuRnduHknIdouVTy.setZtytmttknzoukaritujygn(pTkJitenKeiyakuSyouhinKijyunBean.getTmttknzoukaritujygn());
        pKbkSsuRnduHknIdouVTy.setZtysetteibairitu(pTkJitenKeiyakuSyouhinKijyunBean.getSetteibairitu());
        pKbkSsuRnduHknIdouVTy.setZtytykzenoutouymdsisuu(
            pKhSisuurendoTmttkn.getTmttknhaneisisuu());
        pKbkSsuRnduHknIdouVTy.setZtykimatusisuu(
            pKhSisuurendoTmttkn.getTmttknhaneisisuu());
        pKbkSsuRnduHknIdouVTy.setZtysisuurentumitatekin(Long.parseLong(
            pKhSisuurendoTmttkn.getSisuurendoutmttkngk().toAdsoluteString()));
        pKbkSsuRnduHknIdouVTy.setZtynksjitirttumitatekin(Long.parseLong(nksjitirtTumitatekin.toAdsoluteString()));
        pKbkSsuRnduHknIdouVTy.setZtykimatutirttumitatekin(
            Long.parseLong(pKhSisuurendoTmttkn.getTeiritutmttkngk().toAdsoluteString()));
        pKbkSsuRnduHknIdouVTy.setZtyyendttargetkijyunkingaku(yendttargetKijyunkingaku);
    }


    private void  editKbkSsuRnduIdouVTyData(
        SrKbkSsuRnduHknIdouVBatchParam pSrKbkSsuRnduHknIdouVBatchParam,
        ST_IdouMeisaiTyukeiyouItzHzn pIdouMeisaiTyukeiyouItzHzn,
        TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        SV_SnkiykGtjSirt pSnkiykGtjSirt,
        IT_KhSisuurendoTmttkn pKhSisuurendoTmttkn,
        ZT_KbkSsuRnduHknIdouVTy pKbkSsuRnduHknIdouVTy,
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

        if (BizDateUtil.compareYmd(denYmd, kouryokuKaisiYmd) == BizDateUtil.COMPARE_LESSER) {
            jigyouNdhtymd = kouryokuKaisiYmd;
        }
        else {
            jigyouNdhtymd = denYmd;
        }

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

            if (BizDateUtil.compareYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd(),
                kouryokuKaisiYmd) == BizDateUtil.COMPARE_LESSER) {

                kaiyakuSjkkkTyouseiRirituKijyunYmd = pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd();
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

                suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(syono);
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                    pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);
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

                suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(syono);
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                    pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);

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

            C_ErrorKbn keisanWKekkaKbn = keisanW.exec(jigyouNdmtYmd, kaiyakuhrKeisanKijunYm, keisanWExtBean);

            if (C_ErrorKbn.ERROR.eq(keisanWKekkaKbn)) {

                String msg = MessageUtil.getMessage(
                    MessageId.ESA1001, "事業年度末項目：解約返戻金計算" + nensuu, syono);

                batchLogger.warn(msg);

                ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                suuriyouErrJyouhou.setSyoriYmd(pSrKbkSsuRnduHknIdouVBatchParam.getSyoriYmd());
                suuriyouErrJyouhou.setKakutyoujobcd(pSrKbkSsuRnduHknIdouVBatchParam.getIbKakutyoujobcd());
                suuriyouErrJyouhou.setSyono(syono);
                suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);
                suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                pSrKbkSsuRnduHknIdouVBatchParam.setZokkouErrorSyoriCount(
                    pSrKbkSsuRnduHknIdouVBatchParam.getZokkouErrorSyoriCount() + 1);

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
            pKbkSsuRnduHknIdouVTy.setZtyvkimatutirttumitatekin(pIdouMeisaiTyukeiyouItzHzn
                .getZtykimatutirttumitatekin());
            pKbkSsuRnduHknIdouVTy.setZtykimatusisuutumitatekin(pIdouMeisaiTyukeiyouItzHzn
                .getZtysisuurentumitatekin());
            pKbkSsuRnduHknIdouVTy.setZtyvyoutykzenoutouymdsisuu(
                vyouTykzenOutouYmdSisuu);
            if (tykzenSisuuKijyunYmd != null) {
                pKbkSsuRnduHknIdouVTy.setZtytykzensisuukijyunymd(tykzenSisuuKijyunYmd.toString());
            }
            pKbkSsuRnduHknIdouVTy.setZtyvyoukimatusisuu(vyouKimatuSisuu);
            if (kmtSisuuKijyunYmd != null) {
                pKbkSsuRnduHknIdouVTy.setZtykmtsisuukijyunymd(kmtSisuuKijyunYmd.toString());
            }
            pKbkSsuRnduHknIdouVTy.setZtyvyoutmttknzoukaritujygn(pIdouMeisaiTyukeiyouItzHzn
                .getZtytmttknzoukaritujygn());
            pKbkSsuRnduHknIdouVTy.setZtyvyousetteibairitu(pIdouMeisaiTyukeiyouItzHzn.getZtysetteibairitu());
            pKbkSsuRnduHknIdouVTy.setZtyvyourendouritu(pIdouMeisaiTyukeiyouItzHzn.getZtyrendouritu());

            pKbkSsuRnduHknIdouVTy.setZtykimatusisuutyokugotmttkn(pIdouMeisaiTyukeiyouItzHzn.getZtysisuurentyokugotmttkn());

            pKbkSsuRnduHknIdouVTy.setZtyjmttirttumitatekinnplus0(Long.parseLong(jmtTirtTumitatekins[0].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmttirttumitatekinnplus1(Long.parseLong(jmtTirtTumitatekins[1].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmttirttumitatekinnplus2(Long.parseLong(jmtTirtTumitatekins[2].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtssutumitatekinnplus0(Long.parseLong(jmtSisuuTumitatekins[0].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtssutumitatekinnplus1(Long.parseLong(jmtSisuuTumitatekins[1].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtssutumitatekinnplus2(Long.parseLong(jmtSisuuTumitatekins[2].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtmvatyouseigownplus0(Long.parseLong(jmtMvaTyouseigoWs[0].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtmvakeisanjiwnplus0(Long.parseLong(jmtMvaKeisanjiVs[0].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtmvatyouseigownplus1(Long.parseLong(jmtMvaTyouseigoWs[1].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtmvakeisanjiwnplus1(Long.parseLong(jmtMvaKeisanjiVs[1].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtmvatyouseigownplus2(Long.parseLong(jmtMvaTyouseigoWs[2].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtmvakeisanjiwnplus2(Long.parseLong(jmtMvaKeisanjiVs[2].toAdsoluteString()));
        }
        else {
            pKbkSsuRnduHknIdouVTy.setZtyvkimatutirttumitatekin(pKbkSsuRnduHknIdouVTy
                .getZtykimatutirttumitatekin());
            pKbkSsuRnduHknIdouVTy.setZtykimatusisuutumitatekin(pKbkSsuRnduHknIdouVTy
                .getZtysisuurentumitatekin());
            pKbkSsuRnduHknIdouVTy.setZtyvyoutykzenoutouymdsisuu(
                vyouTykzenOutouYmdSisuu);
            if (tykzenSisuuKijyunYmd != null) {
                pKbkSsuRnduHknIdouVTy.setZtytykzensisuukijyunymd(tykzenSisuuKijyunYmd.toString());
            }
            pKbkSsuRnduHknIdouVTy.setZtyvyoukimatusisuu(vyouKimatuSisuu);
            if (kmtSisuuKijyunYmd != null) {
                pKbkSsuRnduHknIdouVTy.setZtykmtsisuukijyunymd(kmtSisuuKijyunYmd.toString());
            }
            pKbkSsuRnduHknIdouVTy.setZtyvyoutmttknzoukaritujygn(pKbkSsuRnduHknIdouVTy
                .getZtytmttknzoukaritujygn());
            pKbkSsuRnduHknIdouVTy.setZtyvyousetteibairitu(pKbkSsuRnduHknIdouVTy.getZtysetteibairitu());
            pKbkSsuRnduHknIdouVTy.setZtyvyourendouritu(pKbkSsuRnduHknIdouVTy.getZtyrendouritu());
            pKbkSsuRnduHknIdouVTy.setZtyjmttirttumitatekinnplus0(Long.parseLong(jmtTirtTumitatekins[0].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmttirttumitatekinnplus1(Long.parseLong(jmtTirtTumitatekins[1].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmttirttumitatekinnplus2(Long.parseLong(jmtTirtTumitatekins[2].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtssutumitatekinnplus0(Long.parseLong(jmtSisuuTumitatekins[0].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtssutumitatekinnplus1(Long.parseLong(jmtSisuuTumitatekins[1].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtssutumitatekinnplus2(Long.parseLong(jmtSisuuTumitatekins[2].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtmvatyouseigownplus0(Long.parseLong(jmtMvaTyouseigoWs[0].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtmvakeisanjiwnplus0(Long.parseLong(jmtMvaKeisanjiVs[0].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtmvatyouseigownplus1(Long.parseLong(jmtMvaTyouseigoWs[1].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtmvakeisanjiwnplus1(Long.parseLong(jmtMvaKeisanjiVs[1].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtmvatyouseigownplus2(Long.parseLong(jmtMvaTyouseigoWs[2].toAdsoluteString()));
            pKbkSsuRnduHknIdouVTy.setZtyjmtmvakeisanjiwnplus2(Long.parseLong(jmtMvaKeisanjiVs[2].toAdsoluteString()));

        }
    }
}
