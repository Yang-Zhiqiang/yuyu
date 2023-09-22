package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SekmossakuseiKbn;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;

/**
 * 新契約 申込内容チェック ＭＲ関連チェック
 */
public class CheckMRKanren {

    private static final int SIGNALASTERISKNUM = 6;

    private static final int MRASTERISKNUM = 3;

    private static final int SINSNTKASTERISKNUM = 7;

    private static final int TTDKASTERISKNUM = 4;

    @Inject
    private static Logger logger;

    @Inject
    private CheckFreeInsurance checkFreeInsurance;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckMRKanren() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ MR関連チェック 開始");
        }

        HT_SyoriCTL syoriCtl = pMp.getDataSyoriControl();
        String mosNo = syoriCtl.getMosno();
        HT_MosKihon mosKihon = syoriCtl.getMosKihon();
        C_KykKbn kykKbn = mosKihon.getKykkbn();
        C_SysKbn sysKbn = pMp.getSysKbn();
        C_Seibetu seibetu = C_Seibetu.BLNK;
        boolean hhknSinsntkhnsyKaihiFlg = false;
        boolean kykSinsntkhnsyKaihiFlg = false;
        boolean uktSinsntkhnsyKaihiFlg = false;
        boolean kykdairinSinsntkhnsyKaihiFlg = false;
        boolean hhkndairinSinsntkhnsyKaihiFlg = false;

        C_TknKbn sentakuTknKbn = C_TknKbn.NONE;
        C_TknKbn signalTknKbn = C_TknKbn.NONE;
        C_SentakuinfotknKbn sentakuinfotknKbn = C_SentakuinfotknKbn.NONE;
        C_SignalkaihiKbn signalkaihikbn = C_SignalkaihiKbn.NONE;

        if (C_SysKbn.SKEI.eq(sysKbn)) {

            HT_Tokunin tokunin = syoriCtl.getTokunin();

            if (tokunin != null) {

                sentakuinfotknKbn = tokunin.getSentakuinfotknkbn();
                signalkaihikbn = tokunin.getSignalkaihikbn();
            }
            else {

                sentakuinfotknKbn = C_SentakuinfotknKbn.NONE;
                signalkaihikbn = C_SignalkaihiKbn.NONE;
            }

            if (C_SentakuinfotknKbn.NONE.eq(sentakuinfotknKbn)) {

                sentakuTknKbn = C_TknKbn.KANOU;
            }
            else if (C_SentakuinfotknKbn.ARI.eq(sentakuinfotknKbn)) {

                sentakuTknKbn = C_TknKbn.SUMI;
            }

            if (C_SignalkaihiKbn.NONE.eq(signalkaihikbn)) {

                signalTknKbn = C_TknKbn.KANOU;
            }
            else if (C_SignalkaihiKbn.ARI.eq(signalkaihikbn)) {

                signalTknKbn = C_TknKbn.SUMI;
            }
        }

        String syuSyouhinCd = "";

        List<HT_MosSyouhn> mosSyouhnLst = syoriCtl.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (mosSyouhnLst == null || mosSyouhnLst.size() != 1) {

            throw new CommonBizAppException("申込番号：" + mosNo);
        }
        syuSyouhinCd = mosSyouhnLst.get(0).getSyouhncd();

        if (C_SentakuinfotknKbn.NONE.eq(sentakuinfotknKbn)) {

            if (C_UmuKbn.ARI.eq(pMp.getHhknTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMp.getHhknSntkinfohnsyUmuKbnMr())) {

                if (C_SysKbn.SKEI.eq(sysKbn)) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1010, MessageUtil.getMessage(MessageId.EHC1010, C_SntkInfoTaisyousyaKbn.HIHOKENSYA.getContent())),
                        pMp, sentakuTknKbn, msgKbn);
                }
                else {
                    execSeihowebError(pMp, MRASTERISKNUM);
                    return;
                }
                hhknSinsntkhnsyKaihiFlg = true;
            }
        }

        if (C_SignalkaihiKbn.NONE.eq(signalkaihikbn)) {

            if (C_UmuKbn.ARI.eq(pMp.getHhknTratkityuiUmuKbnSignal()) || C_UmuKbn.ARI.eq(pMp.getHhknInfohnsyUmuKbnSignal())) {
                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1011, MessageUtil.getMessage(MessageId.EHC1011, C_SntkInfoTaisyousyaKbn.HIHOKENSYA.getContent())),
                        pMp, signalTknKbn, msgKbn);
                }
                else {
                    execSeihowebError(pMp, SIGNALASTERISKNUM);
                    return;
                }
                hhknSinsntkhnsyKaihiFlg = true;
            }
        }

        if (C_SentakuinfotknKbn.NONE.eq(sentakuinfotknKbn) && !hhknSinsntkhnsyKaihiFlg){
            if (C_UmuKbn.ARI.eq(pMp.getHhknSinsntkhnsyumukbn())) {

                if (C_SysKbn.SKEI.eq(sysKbn)) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1059, MessageUtil.getMessage(MessageId.EHC1059, C_SntkInfoTaisyousyaKbn.HIHOKENSYA.getContent())),
                        pMp, sentakuTknKbn, msgKbn);
                }
                else {
                    execSeihowebError(pMp, SINSNTKASTERISKNUM);
                    return;
                }
            }
        }

        if (!C_KykKbn.KEIHI_DOUITU.eq(kykKbn)) {
            if (C_SentakuinfotknKbn.NONE.eq(sentakuinfotknKbn)) {

                if (C_UmuKbn.ARI.eq(pMp.getKykTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMp.getKykSntkinfohnsyUmuKbnMr())) {

                    if (C_SysKbn.SKEI.eq(sysKbn)) {

                        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                        C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                        setHubiMsg.exec(ketsrhkosKbn,
                            makeMsg(MessageId.EHC1010, MessageUtil.getMessage(MessageId.EHC1010, C_SntkInfoTaisyousyaKbn.KEIYAKUSYA.getContent())),
                            pMp, sentakuTknKbn, msgKbn);
                    }
                    else {
                        execSeihowebError(pMp, MRASTERISKNUM);
                        return;
                    }
                    kykSinsntkhnsyKaihiFlg = true;
                }
            }

            if (C_SignalkaihiKbn.NONE.eq(signalkaihikbn)) {

                if (C_UmuKbn.ARI.eq(pMp.getKykTratkityuiUmuKbnSignal()) || C_UmuKbn.ARI.eq(pMp.getKykInfohnsyUmuKbnSignal()) ) {
                    if (C_SysKbn.SKEI.eq(sysKbn)) {
                        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                        C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                        setHubiMsg.exec(ketsrhkosKbn,
                            makeMsg(MessageId.EHC1011, MessageUtil.getMessage(MessageId.EHC1011, C_SntkInfoTaisyousyaKbn.KEIYAKUSYA.getContent())),
                            pMp, signalTknKbn, msgKbn);
                    }
                    else {
                        execSeihowebError(pMp, SIGNALASTERISKNUM);
                        return;
                    }
                    kykSinsntkhnsyKaihiFlg = true;
                }
            }

            if(C_SentakuinfotknKbn.NONE.eq(sentakuinfotknKbn) && !kykSinsntkhnsyKaihiFlg){
                if (C_UmuKbn.ARI.eq(pMp.getKykSinsntkhnsyumukbn())) {

                    if (C_SysKbn.SKEI.eq(sysKbn)) {

                        C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                        C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                        setHubiMsg.exec(ketsrhkosKbn,
                            makeMsg(MessageId.EHC1059, MessageUtil.getMessage(MessageId.EHC1059, C_SntkInfoTaisyousyaKbn.KEIYAKUSYA.getContent())),
                            pMp, sentakuTknKbn, msgKbn);
                    }
                    else {
                        execSeihowebError(pMp, SINSNTKASTERISKNUM);
                        return;
                    }
                }
            }
        }

        if (C_SentakuinfotknKbn.NONE.eq(sentakuinfotknKbn)) {

            if (C_UmuKbn.ARI.eq(pMp.getUktTratkityuiUmuKbnMr()) || C_UmuKbn.ARI.eq(pMp.getUktSntkinfohnsyUmuKbnMr())) {

                if (C_SysKbn.SKEI.eq(sysKbn)) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1010, MessageUtil.getMessage(MessageId.EHC1010, C_UktsyuKbn.SBUKT.getContent())),
                        pMp, sentakuTknKbn, msgKbn);
                }
                else {
                    execSeihowebError(pMp, MRASTERISKNUM);
                    return;
                }
                uktSinsntkhnsyKaihiFlg = true;
            }
        }
        if (C_SignalkaihiKbn.NONE.eq(signalkaihikbn)) {

            if (C_UmuKbn.ARI.eq(pMp.getUktTratkityuiUmuKbnSignal()) || C_UmuKbn.ARI.eq(pMp.getUktInfohnsyUmuKbnSignal())) {
                if (C_SysKbn.SKEI.eq(sysKbn)) {
                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1011, MessageUtil.getMessage(MessageId.EHC1011, C_UktsyuKbn.SBUKT.getContent())),
                        pMp, signalTknKbn, msgKbn);
                }
                else {
                    execSeihowebError(pMp, SIGNALASTERISKNUM);
                    return;
                }
                uktSinsntkhnsyKaihiFlg = true;
            }
        }
        if(C_SentakuinfotknKbn.NONE.eq(sentakuinfotknKbn) && !uktSinsntkhnsyKaihiFlg){
            if (C_UmuKbn.ARI.eq(pMp.getUktSinsntkhnsyumukbn())) {

                if (C_SysKbn.SKEI.eq(sysKbn)) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1059, MessageUtil.getMessage(MessageId.EHC1059, C_UktsyuKbn.SBUKT.getContent())),
                        pMp, sentakuTknKbn, msgKbn);
                }
                else {
                    execSeihowebError(pMp, SINSNTKASTERISKNUM);
                    return;
                }
            }
        }

        if (C_SentakuinfotknKbn.NONE.eq(sentakuinfotknKbn)) {

            if (C_UmuKbn.ARI.eq(pMp.getKykDairiTratkityuiUmuKbnMr()) ||
                C_UmuKbn.ARI.eq(pMp.getKykDairiSntkinfohnsyUmuKbnMr())) {

                if (C_SysKbn.SKEI.eq(sysKbn)) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1010, MessageUtil.getMessage(MessageId.EHC1010,
                            C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ.getContent())),
                            pMp, sentakuTknKbn, msgKbn);
                }
                else {

                    execSeihowebError(pMp, MRASTERISKNUM);
                    return;
                }

                kykdairinSinsntkhnsyKaihiFlg = true;
            }
        }

        if (C_SignalkaihiKbn.NONE.eq(signalkaihikbn)) {

            if (C_UmuKbn.ARI.eq(pMp.getKykDairiTratkityuiUmuKbnSignal()) ||
                C_UmuKbn.ARI.eq(pMp.getKykDairiInfohnsyUmuKbnSignal())) {

                if (C_SysKbn.SKEI.eq(sysKbn)) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1011, MessageUtil.getMessage(MessageId.EHC1011,
                            C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ.getContent())),
                            pMp, signalTknKbn, msgKbn);
                }
                else {

                    execSeihowebError(pMp, SIGNALASTERISKNUM);
                    return;
                }

                kykdairinSinsntkhnsyKaihiFlg = true;
            }
        }

        if (C_SentakuinfotknKbn.NONE.eq(sentakuinfotknKbn) && !kykdairinSinsntkhnsyKaihiFlg) {

            if (C_UmuKbn.ARI.eq(pMp.getKykDairiSinsntkhnsyUmuKbn())) {

                if (C_SysKbn.SKEI.eq(sysKbn)) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1059, MessageUtil.getMessage(MessageId.EHC1059,
                            C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ.getContent())),
                            pMp, sentakuTknKbn, msgKbn);
                }
                else {

                    execSeihowebError(pMp, SINSNTKASTERISKNUM);
                    return;
                }
            }
        }

        if (C_SentakuinfotknKbn.NONE.eq(sentakuinfotknKbn)) {

            if (C_UmuKbn.ARI.eq(pMp.getHhknDairiTratkityuiUmuKbnMr()) ||
                C_UmuKbn.ARI.eq(pMp.getHhknDairiSntkinfohnsyUmuKbnMr())) {

                if (C_SysKbn.SKEI.eq(sysKbn)) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1010, MessageUtil.getMessage(MessageId.EHC1010,
                            C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ.getContent())),
                            pMp, sentakuTknKbn, msgKbn);
                }
                else {

                    execSeihowebError(pMp, MRASTERISKNUM);
                    return;
                }

                hhkndairinSinsntkhnsyKaihiFlg = true;
            }
        }

        if (C_SignalkaihiKbn.NONE.eq(signalkaihikbn)) {

            if (C_UmuKbn.ARI.eq(pMp.getHhknDairiTratkityuiUmuKbnSignal()) ||
                C_UmuKbn.ARI.eq(pMp.getHhknDairiInfohnsyUmuKbnSignal())) {

                if (C_SysKbn.SKEI.eq(sysKbn)) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1011, MessageUtil.getMessage(MessageId.EHC1011,
                            C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ.getContent())),
                            pMp, signalTknKbn, msgKbn);
                }
                else {

                    execSeihowebError(pMp, SIGNALASTERISKNUM);
                    return;
                }

                hhkndairinSinsntkhnsyKaihiFlg = true;
            }
        }

        if (C_SentakuinfotknKbn.NONE.eq(sentakuinfotknKbn) && !hhkndairinSinsntkhnsyKaihiFlg) {

            if (C_UmuKbn.ARI.eq(pMp.getHhknDairiSinsntkhnsyUmuKbn())) {

                if (C_SysKbn.SKEI.eq(sysKbn)) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1059, MessageUtil.getMessage(MessageId.EHC1059,
                            C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ.getContent())),
                            pMp, sentakuTknKbn, msgKbn);
                }
                else {

                    execSeihowebError(pMp, SINSNTKASTERISKNUM);
                    return;
                }
            }
        }

        if (C_SysKbn.SKEI.eq(sysKbn)) {

            if (C_SentakuinfotknKbn.NONE.eq(sentakuinfotknKbn)) {

                if (C_YouhiblnkKbn.YOU.eq(pMp.getHhknTtdkTyuuiKnkHndktYhKbn())) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;
                    String msgHikisuu = C_SntkInfoTaisyousyaKbn.HIHOKENSYA.getContent();

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1049, MessageUtil.getMessage(MessageId.EHC1049, msgHikisuu)),
                        pMp, sentakuTknKbn, msgKbn);

                }

                if (!C_KykKbn.KEIHI_DOUITU.eq(kykKbn) && C_YouhiblnkKbn.YOU.eq(pMp.getKykTtdkTyuuiKnkHndktYhKbn())) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;
                    String msgHikisuu = C_SntkInfoTaisyousyaKbn.KEIYAKUSYA.getContent();

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1049, MessageUtil.getMessage(MessageId.EHC1049, msgHikisuu)),
                        pMp, sentakuTknKbn, msgKbn);
                }

                if (C_YouhiblnkKbn.YOU.eq(pMp.getUktTtdkTyuuiKnkHndktYhKbn())) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;
                    String msgHikisuu = C_UktsyuKbn.SBUKT.getContent();

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1049, MessageUtil.getMessage(MessageId.EHC1049, msgHikisuu)),
                        pMp, sentakuTknKbn, msgKbn);
                }

                if (C_YouhiblnkKbn.YOU.eq(pMp.getKykDairiTtdkTyuuiKnkHndktYhKbn())) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;
                    String msgHikisuu = C_UktsyuKbn.KYKDRN.getContent();

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1049, MessageUtil.getMessage(MessageId.EHC1049, msgHikisuu)),
                        pMp, sentakuTknKbn, msgKbn);
                }

                if (C_YouhiblnkKbn.YOU.eq(pMp.getHhknDairiTtdkTyuuiKnkHndktYhKbn())) {

                    C_KetsrhkosKbn ketsrhkosKbn = C_KetsrhkosKbn.SRHORYU_HUBI;
                    C_MsgKbn msgKbn = C_MsgKbn.ERROR;
                    String msgHikisuu = C_UktsyuKbn.STDRSK.getContent();

                    setHubiMsg.exec(ketsrhkosKbn,
                        makeMsg(MessageId.EHC1049, MessageUtil.getMessage(MessageId.EHC1049, msgHikisuu)),
                        pMp, sentakuTknKbn, msgKbn);
                }

            }
        }
        else {
            if (C_YouhiblnkKbn.YOU.eq(pMp.getHhknTtdkTyuuiKnkHndktYhKbn()) ||
                C_YouhiblnkKbn.YOU.eq(pMp.getKykTtdkTyuuiKnkHndktYhKbn()) ||
                C_YouhiblnkKbn.YOU.eq(pMp.getUktTtdkTyuuiKnkHndktYhKbn()) ||
                C_YouhiblnkKbn.YOU.eq(pMp.getHhknDairiTtdkTyuuiKnkHndktYhKbn()) ||
                C_YouhiblnkKbn.YOU.eq(pMp.getKykDairiTtdkTyuuiKnkHndktYhKbn())) {
                execSeihowebError(pMp, TTDKASTERISKNUM);
                return;
            }
        }

        if (C_SysKbn.SKEI.eq(sysKbn)) {
            checkFreeInsurance.exec(pMp, seibetu, syuSyouhinCd, sentakuTknKbn);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ MR関連チェック 終了");
        }
    }

    private void execSeihowebError(MosnaiCheckParam pMp, int asteriskNum) {
        String asteriskString = "";

        for (int i = 0; i < asteriskNum; i++) {
            asteriskString = asteriskString + "＊";
        }

        String msgHikisuu = "";

        if (C_SekmossakuseiKbn.SEKKEISYO.eq(pMp.getSekmossakuseiKbn())) {
            msgHikisuu = C_SekmossakuseiKbn.SEKKEISYO.getContent();
        }
        else if (C_SekmossakuseiKbn.MOUSIKOMISYO.eq(pMp.getSekmossakuseiKbn())
            || C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO.eq(pMp.getSekmossakuseiKbn())) {
            msgHikisuu = C_SekmossakuseiKbn.MOUSIKOMISYO.getContent();
        }

        setHubiMsg.exec("",
            MessageUtil.getMessage(MessageId.EGA1016, asteriskString, msgHikisuu, asteriskString),
            C_SekmossakuseiErroutKbn.GAMEN,
            pMp);

        logger.debug("△ MR関連チェック 終了");
    }

    private  String makeMsg(String pInMessageID, String pMsg1) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(pMsg1);
        return ret.toString();
    }
}
