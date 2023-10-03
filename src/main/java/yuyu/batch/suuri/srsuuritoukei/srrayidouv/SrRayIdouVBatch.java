package yuyu.batch.suuri.srsuuritoukei.srrayidouv;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyouhinJyouhouGetKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_SnkiykGtjSirt;
import yuyu.def.db.entity.ZT_RayIdouVTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 ＲＡＹ異動Ｖ情報作成
 */
public class SrRayIdouVBatch implements Batch {

    private static final String SUURIYOUERRJYOUHOUTBL_NAME = "数理用エラー情報テーブル";

    private static final String RAYKIMATUVTY_NAME = "ＲＡＹ異動ＶＦテーブル（中）";

    private static final String SUURIYOUERRJYOUHOUNM_KEIKOKU = "数理用エラー情報テーブル（警告）";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrRayIdouVBatchParam batchParam;

    private int tableCount = 0;

    private boolean idolBknEditKoumokuFlag = true;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String ibKakutyouJobCd = batchParam.getIbKakutyoujobcd();
        String kakutyouJobCd = "";
        idolBknEditKoumokuFlag = true;

        SrRayIdouVBatchDbAccess srRayIdouVBatchDbAccess =
            SWAKInjector.getInstance(SrRayIdouVBatchDbAccess.class);

        if (!SrRayIdouVBatchParam.RGJNM000.equals(ibKakutyouJobCd)) {

            if (SrRayIdouVBatchParam.RGJNM001.equals(ibKakutyouJobCd)) {

                kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN1_BK;
            }
            else if (SrRayIdouVBatchParam.RGJNM002.equals(ibKakutyouJobCd)) {

                kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_BK;
            }
            else if (SrRayIdouVBatchParam.RGJNM003.equals(ibKakutyouJobCd)) {

                kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN3_BK;
            }
            else if (SrRayIdouVBatchParam.RGJNM004.equals(ibKakutyouJobCd)) {

                kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_BK;
            }

            try (
                ExDBResults<ST_IdouMeisaiTyukeiyouItzHzn> idouMeisaiTyukeiyouItzHznList =
                srRayIdouVBatchDbAccess.getIdouMeisaiTyukeiyouItzHzn(
                    batchParam.getKijyunymd().getBizDateYM().toString(), kakutyouJobCd, SrCommonConstants.HKNSYUKIGOU_RAY_ARRAY);

                EntityInserter<ZT_RayIdouVTy> rayIdouVTyInserter = new EntityInserter<>();
                ) {

                for (ST_IdouMeisaiTyukeiyouItzHzn idouMeisaiTyukeiyouItzHzn : idouMeisaiTyukeiyouItzHznList) {

                    ZT_RayIdouVTy rayIdouVTy = new ZT_RayIdouVTy();
                    TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
                        SWAKInjector.getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);
                    SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                        SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);
                    SrRayIdouVBatchEdit editKoumoku =
                        SWAKInjector.getInstance(SrRayIdouVBatchEdit.class);

                    List<SV_KiykSyuhnData> kiykSyuhnDataLst =
                        srRayIdouVBatchDbAccess.getKiykSyuhnData(
                            idouMeisaiTyukeiyouItzHzn.getZtydatakanrino(), C_SyutkKbn.SYU);

                    if (idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                        SrCommonConstants.IDOUJIYUCD_GENGAKU_MINUS) ||
                        idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                            SrCommonConstants.IDOUJIYUCD_GENGAKU_PLUS)) {

                        TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                            C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
                            idouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            null,
                            idouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey(),
                            kiykSyuhnDataLst);

                        if (idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                            SrCommonConstants.IDOUJIYUCD_GENGAKU_MINUS)) {
                            tkJitenKeiyakuSyouhinKijyunBean =
                                tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanMae();

                        }
                        else {
                            tkJitenKeiyakuSyouhinKijyunBean =
                                tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();
                        }

                    }
                    else {

                        TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                            C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                            idouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            batchParam.getKijyunymd(),
                            "",
                            kiykSyuhnDataLst);

                        tkJitenKeiyakuSyouhinKijyunBean =
                            tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();

                    }
                    boolean editKoumokuErrorFlag = editKoumoku.editKoumoku(
                        batchParam,
                        idouMeisaiTyukeiyouItzHzn,
                        kiykSyuhnDataLst,
                        tkJitenKeiyakuSyouhinKijyunBean,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null,
                        rayIdouVTy,
                        idolBknEditKoumokuFlag);

                    if (editKoumokuErrorFlag) {

                        continue;
                    }

                    BizPropertyInitializer.initialize(rayIdouVTy);

                    rayIdouVTyInserter.add(rayIdouVTy);

                    tableCount++;
                }
            }
        }

        idolBknEditKoumokuFlag = true;

        if (SrRayIdouVBatchParam.RGJNM000.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_REIGETSU_ID;

        }
        else if (SrRayIdouVBatchParam.RGJNM001.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN1_ID;
        }
        else if (SrRayIdouVBatchParam.RGJNM002.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_ID;
        }
        else if (SrRayIdouVBatchParam.RGJNM003.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN3_ID;
        }
        else if (SrRayIdouVBatchParam.RGJNM004.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_ID;
        }

        try (
            ExDBResults<ST_IdouMeisaiTyukeiyouItzHzn> idouMeisaiTyukeiyouItzHznList =
            srRayIdouVBatchDbAccess.getIdouMeisaiTyukeiyouItzHzn(
                batchParam.getKijyunymd().getBizDateYM().toString(), kakutyouJobCd, SrCommonConstants.HKNSYUKIGOU_RAY_ARRAY);

            EntityInserter<ZT_RayIdouVTy> rayIdouVTyInserter = new EntityInserter<>();
            ) {

            for (ST_IdouMeisaiTyukeiyouItzHzn idouMeisaiTyukeiyouItzHzn : idouMeisaiTyukeiyouItzHznList) {

                ZT_RayIdouVTy rayIdouVTy = new ZT_RayIdouVTy();
                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
                    SWAKInjector.getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);
                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                    SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);
                SrRayIdouVBatchEdit editKoumoku =
                    SWAKInjector.getInstance(SrRayIdouVBatchEdit.class);

                List<SV_KiykSyuhnData> kiykSyuhnDataLst =
                    srRayIdouVBatchDbAccess.getKiykSyuhnData(
                        idouMeisaiTyukeiyouItzHzn.getZtydatakanrino(), C_SyutkKbn.SYU);

                if (idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_GENGAKU_MINUS) ||
                    idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_GENGAKU_PLUS) ||
                    idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                        SrCommonConstants.IDOUJIYUCD_SEINENGAPPISEI_MINUS) ||
                        idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                            SrCommonConstants.IDOUJIYUCD_SEINENGAPPISEI_PLUS)||
                            idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                SrCommonConstants.IDOUJIYUCD_YENDTSYSNHENKOU_PLUS) ||
                                idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                    SrCommonConstants.IDOUJIYUCD_YENDTSYSNHENKOUTRKS_MINUS) ||
                                    idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                        SrCommonConstants.IDOUJIYUCD_YENDTNNKNHENKOU_MINUS) ||
                                        idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                            SrCommonConstants.IDOUJIYUCD_YENDTNNKNHENKOU_PLUS) ||
                                            idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                                SrCommonConstants.IDOUJIYUCD_YENDTNNKNHENKOUTRKS_MINUS) ||
                                                idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                                    SrCommonConstants.IDOUJIYUCD_YENDTNNKNHENKOUTRKS_PLUS) ||
                                                    idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                                        SrCommonConstants.IDOUJIYUCD_TEIRITUITEN_MINUS) ||
                                                        idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                                            SrCommonConstants.IDOUJIYUCD_TEIRITUITEN_PLUS) ||
                                                            idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                                                SrCommonConstants.IDOUJIYUCD_TEIRITUITENTRKS_MINUS) ||
                                                                idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                                                    SrCommonConstants.IDOUJIYUCD_TEIRITUITENTRKS_PLUS)) {

                    TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                        C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
                        idouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                        null,
                        idouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey(),
                        kiykSyuhnDataLst);

                    if (idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                        SrCommonConstants.IDOUJIYUCD_GENGAKU_MINUS) ||
                        idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                            SrCommonConstants.IDOUJIYUCD_SEINENGAPPISEI_MINUS)||
                            idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                SrCommonConstants.IDOUJIYUCD_YENDTSYSNHENKOUTRKS_MINUS) ||
                                idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                    SrCommonConstants.IDOUJIYUCD_YENDTNNKNHENKOU_MINUS) ||
                                    idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                        SrCommonConstants.IDOUJIYUCD_YENDTNNKNHENKOUTRKS_MINUS) ||
                                        idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                            SrCommonConstants.IDOUJIYUCD_TEIRITUITEN_MINUS) ||
                                            idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                                                SrCommonConstants.IDOUJIYUCD_TEIRITUITENTRKS_MINUS)) {
                        tkJitenKeiyakuSyouhinKijyunBean =
                            tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanMae();

                    }
                    else {
                        tkJitenKeiyakuSyouhinKijyunBean =
                            tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();
                    }

                }
                else if (idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                    SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_MINUS) ||
                    idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                        SrCommonConstants.IDOUJIYUCD_MOKUHYOURITUHENKOU_PLUS)) {

                    for (SV_KiykSyuhnData kiykSyuhnData : kiykSyuhnDataLst) {

                        if (kiykSyuhnData.getHenkousikibetukey().compareTo(
                            idouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey()) < 0) {

                            BeanUtil.copyProperties(tkJitenKeiyakuSyouhinKijyunBean, kiykSyuhnData);

                            tkJitenKeiyakuSyouhinKijyunBean.setSyutkKbn(kiykSyuhnData.getSyutkkbn());
                            tkJitenKeiyakuSyouhinKijyunBean.setYuukousyoumetuKbn(kiykSyuhnData.getYuukousyoumetukbn());
                            tkJitenKeiyakuSyouhinKijyunBean.setKykymdsiteiumuKbn(kiykSyuhnData.getKykymdsiteiumukbn());
                            tkJitenKeiyakuSyouhinKijyunBean.setHknkknsmnKbn(kiykSyuhnData.getHknkknsmnkbn());
                            tkJitenKeiyakuSyouhinKijyunBean.setHrkkknsmnKbn(kiykSyuhnData.getHrkkknsmnkbn());
                            tkJitenKeiyakuSyouhinKijyunBean.setKataKbn(kiykSyuhnData.getKatakbn());
                            tkJitenKeiyakuSyouhinKijyunBean.setKyhgndkataKbn(kiykSyuhnData.getKyhgndkatakbn());
                            tkJitenKeiyakuSyouhinKijyunBean.setSyukyhkinkataKbn(kiykSyuhnData.getSyukyhkinkatakbn());
                            tkJitenKeiyakuSyouhinKijyunBean.setKhnkyhkgbairituKbn(kiykSyuhnData.getKhnkyhkgbairitukbn());
                            tkJitenKeiyakuSyouhinKijyunBean.setPmnjtkKbn(kiykSyuhnData.getPmnjtkkbn());
                            tkJitenKeiyakuSyouhinKijyunBean.setTmttknitenYmd(kiykSyuhnData.getTmttknitenymd());

                            break;
                        }

                    }

                    if(SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(
                        idouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) ||
                        SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(
                            idouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) ||
                            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(
                                idouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) ||
                                SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(
                                    idouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn())) {

                        TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                            C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
                            idouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            null,
                            idouMeisaiTyukeiyouItzHzn.getZtysrhoseihenkousikibetukey(),
                            kiykSyuhnDataLst);

                        if(SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD.equals(
                            idouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) ||
                            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO.equals(
                                idouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn())) {

                            tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanMae();
                        }

                        else if(SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD.equals(
                            idouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) ||
                            SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO.equals(
                                idouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn())) {

                            tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();
                        }
                    }
                }
                else if (idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_MINUS) ||
                    idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_PLUS) ||
                    idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_MINUS) ||
                    idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASITRKS_PLUS)) {

                    TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                        C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
                        idouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                        null,
                        idouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey(),
                        kiykSyuhnDataLst);

                    if(C_SyouhinJyouhouGetKbn.SYOUHININFOARI.eq(tkJitenKeiyakuSyouhinBean.getSyouhinJyouhouGetKbnAto())) {

                        if (idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_MINUS) ||
                            idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_SISUUTUMIMASI_PLUS)) {
                            tkJitenKeiyakuSyouhinKijyunBean =
                                tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanMae();
                        }
                        else {
                            tkJitenKeiyakuSyouhinKijyunBean =
                                tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();
                        }
                    }
                    else {

                        for (SV_KiykSyuhnData sKiykSyuhnData : kiykSyuhnDataLst) {

                            if (sKiykSyuhnData.getHenkousikibetukey().compareTo(
                                idouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey()) < 0) {

                                BeanUtil.copyProperties(tkJitenKeiyakuSyouhinKijyunBean, sKiykSyuhnData);

                                tkJitenKeiyakuSyouhinKijyunBean.setSyutkKbn(sKiykSyuhnData.getSyutkkbn());
                                tkJitenKeiyakuSyouhinKijyunBean.setYuukousyoumetuKbn(sKiykSyuhnData.getYuukousyoumetukbn());
                                tkJitenKeiyakuSyouhinKijyunBean.setKykymdsiteiumuKbn(sKiykSyuhnData.getKykymdsiteiumukbn());
                                tkJitenKeiyakuSyouhinKijyunBean.setHknkknsmnKbn(sKiykSyuhnData.getHknkknsmnkbn());
                                tkJitenKeiyakuSyouhinKijyunBean.setHrkkknsmnKbn(sKiykSyuhnData.getHrkkknsmnkbn());
                                tkJitenKeiyakuSyouhinKijyunBean.setKataKbn(sKiykSyuhnData.getKatakbn());
                                tkJitenKeiyakuSyouhinKijyunBean.setKyhgndkataKbn(sKiykSyuhnData.getKyhgndkatakbn());
                                tkJitenKeiyakuSyouhinKijyunBean.setSyukyhkinkataKbn(sKiykSyuhnData.getSyukyhkinkatakbn());
                                tkJitenKeiyakuSyouhinKijyunBean.setKhnkyhkgbairituKbn(sKiykSyuhnData.getKhnkyhkgbairitukbn());
                                tkJitenKeiyakuSyouhinKijyunBean.setPmnjtkKbn(sKiykSyuhnData.getPmnjtkkbn());
                                tkJitenKeiyakuSyouhinKijyunBean.setTmttknitenYmd(sKiykSyuhnData.getTmttknitenymd());

                                break;
                            }
                        }
                    }

                    if(SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(
                        idouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn()) ||
                        SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITSRECORD.equals(
                            idouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn())) {

                        tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                            C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
                            idouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            null,
                            idouMeisaiTyukeiyouItzHzn.getZtysrhoseihenkousikibetukey(),
                            kiykSyuhnDataLst);

                        if(SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD.equals(
                            idouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn())) {

                            tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanMae();
                        }

                        else if(SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITSRECORD.equals(
                            idouMeisaiTyukeiyouItzHzn.getZtysrhoseirecordhanbetukbn())) {

                            tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();
                        }
                    }
                }
                else {

                    TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                        C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                        idouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                        BizDate.valueOf(idouMeisaiTyukeiyouItzHzn.getZtyhenkousyoriymd()),
                        "",
                        kiykSyuhnDataLst);

                    tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();
                }

                if (SrCommonConstants.IDOUJIYUCD_SINKEIYAKUTORIKESI.equals(idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd()) &&
                    C_Syoumetujiyuu.MUKOU.eq(tkJitenKeiyakuSyouhinKijyunBean.getSyoumetujiyuu())) {

                    batchLogger.warn(MessageUtil.getMessage(MessageId.WSA1001,
                        "無効異動が出力されました。",
                        idouMeisaiTyukeiyouItzHzn.getZtydatakanrino()));

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(batchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(ibKakutyouJobCd);
                    suuriyouErrJyouhou.setSyono(idouMeisaiTyukeiyouItzHzn.getZtydatakanrino());
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(MessageUtil.getMessage(MessageId.WSA1001,
                        "無効異動が出力されました。",
                        idouMeisaiTyukeiyouItzHzn.getZtydatakanrino()));

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    batchParam.setKeikokuSyoriCount(batchParam.getKeikokuSyoriCount() + 1);

                    TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                        C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                        idouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                        tkJitenKeiyakuSyouhinKijyunBean.getSknnkaisiymd(),
                        "",
                        kiykSyuhnDataLst);

                    tkJitenKeiyakuSyouhinKijyunBean =
                        tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();
                }

                boolean editKoumokuErrorFlag = editKoumoku.editKoumoku(
                    batchParam,
                    idouMeisaiTyukeiyouItzHzn,
                    kiykSyuhnDataLst,
                    tkJitenKeiyakuSyouhinKijyunBean,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    rayIdouVTy,
                    idolBknEditKoumokuFlag);

                if (editKoumokuErrorFlag) {

                    continue;
                }

                BizPropertyInitializer.initialize(rayIdouVTy);

                rayIdouVTyInserter.add(rayIdouVTy);

                tableCount++;
            }
        }

        idolBknEditKoumokuFlag = false;

        try (
            ExDBResults<SV_SnkiykGtjSirt> snkiykGtjSirtLst =
            srRayIdouVBatchDbAccess.getSkSeirituDate(
                batchParam.getKijyunymd().getBizDateYM() , C_SeirituKbn.SEIRITU);

            EntityInserter<ZT_RayIdouVTy> rayIdouVTyInserter = new EntityInserter<>();
            ) {

            for (SV_SnkiykGtjSirt snkiykGtjSirt : snkiykGtjSirtLst) {

                ZT_RayIdouVTy rayIdouVTy = new ZT_RayIdouVTy();
                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
                    SWAKInjector.getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);
                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                    SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);
                SrRayIdouVBatchEdit editKoumoku =
                    SWAKInjector.getInstance(SrRayIdouVBatchEdit.class);

                List<SV_KiykSyuhnData> kiykSyuhnDataLst =
                    srRayIdouVBatchDbAccess.getKiykSyuhnData(snkiykGtjSirt.getSyono(), C_SyutkKbn.SYU);

                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    snkiykGtjSirt.getSyono(),
                    snkiykGtjSirt.getSknnkaisiymd(),
                    "",
                    kiykSyuhnDataLst);

                tkJitenKeiyakuSyouhinKijyunBean =
                    tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();

                int syohinHanteiKbn = SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

                if (syohinHanteiKbn != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR &&
                    syohinHanteiKbn != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                    continue;
                }

                IT_KykKihon kykKihon = srRayIdouVBatchDbAccess.getKykKihon(snkiykGtjSirt.getSyono());

                BM_SyouhnZokusei syouhnZokusei = srRayIdouVBatchDbAccess.getSyouhnZokusei(
                    tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd() ,
                    tkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());

                IT_KykDairiten kykDairiten = srRayIdouVBatchDbAccess.getKykDairiten(
                    snkiykGtjSirt.getSyono(),
                    SrCommonConstants.RENBAN_1);

                IT_NyknJissekiRireki nyknJissekiRireki = srRayIdouVBatchDbAccess.getNyknJissekiRireki(
                    snkiykGtjSirt.getSyono(),
                    snkiykGtjSirt.getKykymd().getBizDateYM(),
                    SrCommonConstants.RENBAN_1);

                IT_ItekiToukeiInfo itekiToukeiInfo = srRayIdouVBatchDbAccess.getItekiToukeiInfoBySyono(
                    snkiykGtjSirt.getSyono());

                boolean editKoumokuErrorFlag = editKoumoku.editKoumoku(
                    batchParam,
                    null,
                    null,
                    tkJitenKeiyakuSyouhinKijyunBean,
                    snkiykGtjSirt,
                    kykKihon,
                    syouhnZokusei,
                    kykDairiten,
                    nyknJissekiRireki,
                    itekiToukeiInfo,
                    rayIdouVTy,
                    idolBknEditKoumokuFlag);

                if (editKoumokuErrorFlag) {

                    continue;
                }

                BizPropertyInitializer.initialize(rayIdouVTy);

                SrRayIdouVConverter.convertPadding(rayIdouVTy);

                rayIdouVTyInserter.add(rayIdouVTy);

                tableCount++;
            }
        }

        if (batchParam.getZokkouErrorSyoriCount() != 0 &&
            (SrRayIdouVBatchParam.RGJNM000.equals(ibKakutyouJobCd) ||
                SrRayIdouVBatchParam.RGJNM004.equals(ibKakutyouJobCd))) {

            throw new BizAppException(MessageId.ISA1001, SUURIYOUERRJYOUHOUTBL_NAME,
                String.valueOf(batchParam.getZokkouErrorSyoriCount()));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, RAYKIMATUVTY_NAME,
            String.valueOf(tableCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, SUURIYOUERRJYOUHOUTBL_NAME,
            String.valueOf(batchParam.getZokkouErrorSyoriCount())));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, SUURIYOUERRJYOUHOUNM_KEIKOKU,
            String.valueOf(batchParam.getKeikokuSyoriCount())));
    }
}
