package yuyu.batch.suuri.srsuuritoukei.srkbkssurnduhknidouv;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyouhinJyouhouGetKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_SnkiykGtjSirt;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknIdouVTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 株価指数連動保険異動Ｖ情報作成
 */
public class SrKbkSsuRnduHknIdouVBatch implements Batch {

    private static final String SUURIYOUERRJYOUHOUTBL_NAME = "数理用エラー情報テーブル";

    private static final String KBKSSURNDUHKNKIMATUVTY_NAME = "株価指数連動保険異動ＶＦテーブル（中）";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrKbkSsuRnduHknIdouVBatchParam batchParam;

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

        SrKbkSsuRnduHknIdouVBatchDbAccess srKbkSsuRnduHknIdouVBatchDbAccess =
            SWAKInjector.getInstance(SrKbkSsuRnduHknIdouVBatchDbAccess.class);

        if (!SrKbkSsuRnduHknIdouVBatchParam.RGJNM000.equals(ibKakutyouJobCd)) {

            if (SrKbkSsuRnduHknIdouVBatchParam.RGJNM001.equals(ibKakutyouJobCd)) {

                kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN1_BK;
            }
            else if (SrKbkSsuRnduHknIdouVBatchParam.RGJNM002.equals(ibKakutyouJobCd)) {

                kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_BK;
            }
            else if (SrKbkSsuRnduHknIdouVBatchParam.RGJNM003.equals(ibKakutyouJobCd)) {

                kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN3_BK;
            }
            else if (SrKbkSsuRnduHknIdouVBatchParam.RGJNM004.equals(ibKakutyouJobCd)) {

                kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_BK;
            }

            try (
                ExDBResults<ST_IdouMeisaiTyukeiyouItzHzn> idouMeisaiTyukeiyouItzHznList =null;

                EntityInserter<ZT_KbkSsuRnduHknIdouVTy> kbkSsuRnduHknIdouVTyInserter = new EntityInserter<>();
                ) {

                for (ST_IdouMeisaiTyukeiyouItzHzn idouMeisaiTyukeiyouItzHzn : idouMeisaiTyukeiyouItzHznList) {

                    ZT_KbkSsuRnduHknIdouVTy kbkSsuRnduHknIdouVTy = new ZT_KbkSsuRnduHknIdouVTy();
                    TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
                        SWAKInjector.getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);
                    SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                        SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);
                    SrKbkSsuRnduHknIdouVBatchEdit editKoumoku =
                        SWAKInjector.getInstance(SrKbkSsuRnduHknIdouVBatchEdit.class);

                    List<SV_KiykSyuhnData> kiykSyuhnDataLst =
                        srKbkSsuRnduHknIdouVBatchDbAccess.getKiykSyuhnData(
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
                        kbkSsuRnduHknIdouVTy,
                        idolBknEditKoumokuFlag);

                    if (editKoumokuErrorFlag) {

                        continue;
                    }

                    BizPropertyInitializer.initialize(kbkSsuRnduHknIdouVTy);

                    kbkSsuRnduHknIdouVTyInserter.add(kbkSsuRnduHknIdouVTy);

                    tableCount++;
                }
            }
        }

        idolBknEditKoumokuFlag = true;

        if (SrKbkSsuRnduHknIdouVBatchParam.RGJNM000.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_REIGETSU_ID;

        }
        else if (SrKbkSsuRnduHknIdouVBatchParam.RGJNM001.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN1_ID;
        }
        else if (SrKbkSsuRnduHknIdouVBatchParam.RGJNM002.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_ID;
        }
        else if (SrKbkSsuRnduHknIdouVBatchParam.RGJNM003.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN3_ID;
        }
        else if (SrKbkSsuRnduHknIdouVBatchParam.RGJNM004.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_ID;
        }

        try (
            ExDBResults<ST_IdouMeisaiTyukeiyouItzHzn> idouMeisaiTyukeiyouItzHznList =null;
            EntityInserter<ZT_KbkSsuRnduHknIdouVTy> kbkSsuRnduHknIdouVTyInserter = new EntityInserter<>();
            ) {

            for (ST_IdouMeisaiTyukeiyouItzHzn idouMeisaiTyukeiyouItzHzn : idouMeisaiTyukeiyouItzHznList) {

                ZT_KbkSsuRnduHknIdouVTy kbkSsuRnduHknIdouVTy = new ZT_KbkSsuRnduHknIdouVTy();
                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
                    SWAKInjector.getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);
                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                    SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);
                SrKbkSsuRnduHknIdouVBatchEdit editKoumoku =
                    SWAKInjector.getInstance(SrKbkSsuRnduHknIdouVBatchEdit.class);

                List<SV_KiykSyuhnData> kiykSyuhnDataLst =
                    srKbkSsuRnduHknIdouVBatchDbAccess.getKiykSyuhnData(
                        idouMeisaiTyukeiyouItzHzn.getZtydatakanrino(), C_SyutkKbn.SYU);

                if (idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_GENGAKU_MINUS) ||
                    idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(SrCommonConstants.IDOUJIYUCD_GENGAKU_PLUS) ||
                    idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                        SrCommonConstants.IDOUJIYUCD_SEINENGAPPISEI_MINUS) ||
                        idouMeisaiTyukeiyouItzHzn.getZtyidoujiyuucd().equals(
                            SrCommonConstants.IDOUJIYUCD_SEINENGAPPISEI_PLUS)||
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

                    String  mokuhyourituhenkougosikibetukey = "";
                    boolean mokuhyourituHenkougoUmuFlag = false;

                    for (SV_KiykSyuhnData kiykSyuhnData : kiykSyuhnDataLst) {

                        if (BizDateUtil.compareYmd(BizDate.valueOf(
                            idouMeisaiTyukeiyouItzHzn.getZtysrkouryokuhasseiymd()),
                            kiykSyuhnData.getKouryokuhasseiymd ()) == BizDateUtil.COMPARE_LESSER) {

                            if ((BizDateUtil.compareYmd(kiykSyuhnData.getKouryokuhasseiymd(), kiykSyuhnData.getKykymd())
                                == BizDateUtil.COMPARE_EQUAL) &&
                                (Integer.parseInt(idouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey()) >
                                Integer.parseInt(kiykSyuhnData.getHenkousikibetukey()))) {
                                mokuhyourituHenkougoUmuFlag = false;
                            }
                            else {
                                mokuhyourituhenkougosikibetukey = kiykSyuhnData.getHenkousikibetukey();
                                mokuhyourituHenkougoUmuFlag = true;
                            }
                        }
                        else if (BizDateUtil.compareYmd(BizDate.valueOf(
                            idouMeisaiTyukeiyouItzHzn.getZtysrkouryokuhasseiymd()),
                            kiykSyuhnData.getKouryokuhasseiymd()) == BizDateUtil.COMPARE_EQUAL) {

                            if (Long.parseLong(idouMeisaiTyukeiyouItzHzn.getZtysrhenkousikibetukey()) <
                                Long.parseLong(kiykSyuhnData.getHenkousikibetukey())){

                                mokuhyourituhenkougosikibetukey = kiykSyuhnData.getHenkousikibetukey();
                                mokuhyourituHenkougoUmuFlag = true;

                            }
                            else {

                                break;

                            }
                        }
                        else {

                            break;
                        }
                    }

                    if (mokuhyourituHenkougoUmuFlag) {

                        TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                            C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
                            idouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            null,
                            mokuhyourituhenkougosikibetukey,
                            kiykSyuhnDataLst);

                        tkJitenKeiyakuSyouhinKijyunBean =
                            tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanMae();


                    }
                    else {

                        TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                            C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                            idouMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                            BizDate.valueOf(idouMeisaiTyukeiyouItzHzn.getZtysrkouryokuhasseiymd()),
                            "",
                            kiykSyuhnDataLst);

                        tkJitenKeiyakuSyouhinKijyunBean =
                            tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();
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
                    kbkSsuRnduHknIdouVTy,
                    idolBknEditKoumokuFlag);

                if (editKoumokuErrorFlag) {

                    continue;
                }

                BizPropertyInitializer.initialize(kbkSsuRnduHknIdouVTy);

                kbkSsuRnduHknIdouVTyInserter.add(kbkSsuRnduHknIdouVTy);

                tableCount++;
            }
        }

        idolBknEditKoumokuFlag = false;

        try (
            ExDBResults<SV_SnkiykGtjSirt> snkiykGtjSirtLst =
            srKbkSsuRnduHknIdouVBatchDbAccess.getSkSeirituDate(
                batchParam.getKijyunymd().getBizDateYM() , C_SeirituKbn.SEIRITU);

            EntityInserter<ZT_KbkSsuRnduHknIdouVTy> kbkSsuRnduHknIdouVTyInserter = new EntityInserter<>();
            ) {

            for (SV_SnkiykGtjSirt snkiykGtjSirt : snkiykGtjSirtLst) {

                ZT_KbkSsuRnduHknIdouVTy kbkSsuRnduHknIdouVTy = new ZT_KbkSsuRnduHknIdouVTy();
                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
                    SWAKInjector.getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);
                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                    SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);
                SrKbkSsuRnduHknIdouVBatchEdit editKoumoku =
                    SWAKInjector.getInstance(SrKbkSsuRnduHknIdouVBatchEdit.class);

                List<SV_KiykSyuhnData> kiykSyuhnDataLst =
                    srKbkSsuRnduHknIdouVBatchDbAccess.getKiykSyuhnData(snkiykGtjSirt.getSyono(), C_SyutkKbn.SYU);

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

                IT_KykKihon kykKihon = srKbkSsuRnduHknIdouVBatchDbAccess.getKykKihon(snkiykGtjSirt.getSyono());

                BM_SyouhnZokusei syouhnZokusei = srKbkSsuRnduHknIdouVBatchDbAccess.getSyouhnZokusei(
                    tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd() ,
                    tkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno());

                IT_KykDairiten kykDairiten = srKbkSsuRnduHknIdouVBatchDbAccess.getKykDairiten(
                    snkiykGtjSirt.getSyono(),
                    SrCommonConstants.RENBAN_1);

                IT_NyknJissekiRireki nyknJissekiRireki = srKbkSsuRnduHknIdouVBatchDbAccess.getNyknJissekiRireki(
                    snkiykGtjSirt.getSyono(),
                    snkiykGtjSirt.getKykymd().getBizDateYM(),
                    SrCommonConstants.RENBAN_1);

                IT_ItekiToukeiInfo itekiToukeiInfo = srKbkSsuRnduHknIdouVBatchDbAccess.getItekiToukeiInfoBySyono(
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
                    kbkSsuRnduHknIdouVTy,
                    idolBknEditKoumokuFlag);

                if (editKoumokuErrorFlag) {

                    continue;
                }

                BizPropertyInitializer.initialize(kbkSsuRnduHknIdouVTy);

                SrKbkSsuRnduHknIdouVConverter.convertPadding(kbkSsuRnduHknIdouVTy);

                kbkSsuRnduHknIdouVTyInserter.add(kbkSsuRnduHknIdouVTy);

                tableCount++;
            }
        }

        if (batchParam.getZokkouErrorSyoriCount() != 0 &&
            (SrKbkSsuRnduHknIdouVBatchParam.RGJNM000.equals(ibKakutyouJobCd) ||
                SrKbkSsuRnduHknIdouVBatchParam.RGJNM004.equals(ibKakutyouJobCd))) {

            throw new BizAppException(MessageId.ISA1001, SUURIYOUERRJYOUHOUTBL_NAME,
                String.valueOf(batchParam.getZokkouErrorSyoriCount()));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, KBKSSURNDUHKNKIMATUVTY_NAME,
            String.valueOf(tableCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, SUURIYOUERRJYOUHOUTBL_NAME,
            String.valueOf(batchParam.getZokkouErrorSyoriCount())));
    }
}
