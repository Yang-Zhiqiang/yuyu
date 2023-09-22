package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckTelNo;
import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KetsrhkosKbn;

/**
 * 新契約 申込内容チェック 電話番号チェック呼出し
 */
public class CheckTelNoCall {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckTelNoCall() {
        super();
    }

    public void execHhkn(MosnaiCheckParam pMP) {
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 被保険者電話番号チェック 開始");
        }

        String hhknTelNo = pMP.getDataSyoriControl().getMosKihon().getHhkntelno();

        if (BizUtil.isBlank(hhknTelNo)) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 被保険者電話番号チェック 終了（電話番号：ブランク）");
            }
            return;
        }

        checkTelNo(hhknTelNo, ICommonKoumoku.DISP_S_HHKNTELNO, pMP);
        if (logger.isDebugEnabled()) {
            logger.debug("△ 被保険者電話番号チェック 終了");
        }
    }

    public void execTuusin(MosnaiCheckParam pMP) {
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 通信先電話番号チェック 開始");
        }

        String tsinTelNo = pMP.getDataSyoriControl().getMosKihon().getTsintelno();

        if (BizUtil.isBlank(tsinTelNo)) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 通信先電話番号チェック 終了（電話番号：ブランク）");
            }
            return;
        }

        checkTelNo(tsinTelNo, ICommonKoumoku.DISP_S_TSINTELNO, pMP);

        if (logger.isDebugEnabled()) {
            logger.debug("△ 通信先電話番号チェック 終了");
        }
    }

    public void execDainiTuusin(MosnaiCheckParam pMP) {
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 第２通信先チェック 開始");
        }

        String dai2TsinTelNo = pMP.getDataSyoriControl().getMosKihon().getDai2tsintelno();

        if (BizUtil.isBlank(dai2TsinTelNo)) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 第２通信先チェック 終了（電話番号：ブランク）");
            }
            return;
        }

        checkTelNo(dai2TsinTelNo, ICommonKoumoku.DISP_S_DAINITSINTELNO, pMP);

        if (logger.isDebugEnabled()) {
            logger.debug("△ 第２通信先チェック 終了");
        }
    }

    public void execKok(MosnaiCheckParam pMP) {
        if (logger.isDebugEnabled()) {
            logger.debug("▽ 顧客電話番号チェック 開始");
        }

        String kokTelNo = pMP.getDataSyoriControl().getMosKihon().getTsintelno();

        if (BizUtil.isBlank(kokTelNo)) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 顧客電話番号チェック 終了（電話番号：ブランク）");
            }
            return;
        }

        checkTelNo(kokTelNo, ICommonKoumoku.DISP_S_KOKTELNO, pMP);

        if (logger.isDebugEnabled()) {
            logger.debug("△ 顧客電話番号チェック 終了");
        }
    }

    public void execTelNo(MosnaiCheckParam pMp, String pTelNo, String pMessage) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 電話番号チェック 開始");
        }

        if (BizUtil.isBlank(pTelNo)) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 電話番号チェック  終了（電話番号：ブランク）");
            }
            return;
        }

        checkTelNo(pTelNo, pMessage, pMp);

        if (logger.isDebugEnabled()) {
            logger.debug("△ 電話番号チェック 終了");
        }
    }

    private void checkTelNo(String pTelNo, String pMessage, MosnaiCheckParam pMP) {

        if(!CheckTelNo.isCheckOK(pTelNo)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                makeMsg(MessageId.EHC0148, MessageId.EHC0148, pMessage), pMP);
        }
    }

    private String makeMsg(String pInMessageID, String pMsgID, String pReplaceMsg1) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg1));
        return ret.toString();
    }
}