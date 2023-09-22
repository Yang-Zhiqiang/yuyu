package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizRate;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.common.sinkeiyaku.skcommon.EditGamenString;
import yuyu.common.sinkeiyaku.skcommon.SkZennouIkkatuUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;
import yuyu.def.classification.C_KetsijisyoyhKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SonotaTkykJktk;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_SyouhnTokujyou;

import com.google.common.collect.Lists;

/**
 * 新契約 申込内容チェック 不備メッセージ設定
 */
public class SetHubiMsg {

    private static final String MESSAGE_1ST_CHAR_TOKUNIN_SUMI  = "K";
    private static final String MESSAGE_1ST_CHAR_TOKUNIN_KANOU = "T";

    private static final String TOKUNIN_SUMI_SETTOU  = "（特認済）";
    private static final String TOKUNIN_KANOU_SETTOU = "【特認可能】";
    private static final int FUBI_MSG_MAX_KETASUU = 150;

    @Inject
    private static Logger logger;

    public SetHubiMsg() {
        super();
    }

    public void exec(C_KetsrhkosKbn pKetsrhkosKbn,
        C_SpKeisanKahiKbn pSpKeisanKahiKbn,
        C_HubisyubetusyousaiKbn pHubisyubetusyousaiKbn,
        C_SyoruiCdKbn pSyoruiCdKbn,
        String pMessage,
        MosnaiCheckParam pMp,
        C_TknKbn pTknKbn,
        C_MsgKbn pMsgKbn) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 不備メッセージ設定処理 開始");
            logger.debug("｜    決定・成立保留更新区分=" + pKetsrhkosKbn);
            logger.debug("｜    決定保留時ＳＰ計算可否区分=" + pSpKeisanKahiKbn);
            logger.debug("｜    不備種別詳細区分=" + pHubisyubetusyousaiKbn);
            logger.debug("｜    必要書類コード区分=" + pSyoruiCdKbn);
            logger.debug("｜    メッセージ文言=" + pMessage);
            logger.debug("｜    特認区分=" + pTknKbn);
            logger.debug("｜    メッセージ区分=" + pMsgKbn);
        }

        if (C_SysKbn.ESHIEN.eq(pMp.getSysKbn())) {
            List<String> msgResultLst = editMsg(pMessage, pMp.getSysKbn(), C_TknKbn.NONE);

            editSeihoWebMsg("", msgResultLst.get(2), C_SekmossakuseiErroutKbn.GAMEN, pMp);

            if (logger.isDebugEnabled()) {
                logger.debug("△ 不備メッセージ設定処理 終了");
            }

            return;
        }

        HT_SyoriCTL syoriCtl = pMp.getDataSyoriControl();
        String mosNo = syoriCtl.getMosno();

        if (!C_TknKbn.SUMI.eq(pTknKbn) && !C_KetsrhkosKbn.KOS_NONE.eq(pKetsrhkosKbn)) {

            if (C_KetsrhkosKbn.KETHORYU_HUBI.eq(pKetsrhkosKbn)) {
                syoriCtl.setKthhbkbn(C_UmuKbn.ARI);
            }
            if (C_KetsrhkosKbn.SRHORYU_HUBI.eq(pKetsrhkosKbn)) {
                syoriCtl.setSrhhbkbn(C_UmuKbn.ARI);
            }
            if (C_KetsrhkosKbn.KIHON_HUBI.eq(pKetsrhkosKbn)) {
                syoriCtl.setKhnhbkbn(C_UmuKbn.ARI);
            }
        }

        int renNo = 0;
        List<HT_HubiMsg> hubiMsgList = pMp.getListHubiMsg();

        if (hubiMsgList.size() > 0){

            renNo = hubiMsgList.size();
        }

        List<String> msgResultLst = editMsg(pMessage, pMp.getSysKbn(), pTknKbn);

        HT_HubiMsg hubiMsg = new HT_HubiMsg();
        hubiMsg.setMosno(mosNo);
        hubiMsg.setRenno(renNo + 1);
        hubiMsg.setMessageId(msgResultLst.get(1));
        hubiMsg.setHubimsg(msgResultLst.get(2));
        hubiMsg.setHubisyubetukbn(C_HubisyubetuKbn.valueOf(pKetsrhkosKbn.getValue()));
        hubiMsg.setHubisyubetusyousaikbn(pHubisyubetusyousaiKbn);
        hubiMsg.setHituyousyoruicd(pSyoruiCdKbn);
        hubiMsg.setGyoumuKousinsyaId(pMp.getKosID());
        hubiMsg.setGyoumuKousinTime(pMp.getKosTime());

        BizPropertyInitializer.initialize(hubiMsg);

        hubiMsgList.add(hubiMsg);

        if (C_KetteiKbn.KETTEI_SUMI.eq(syoriCtl.getKetteikbn()) &&
            C_UmuKbn.ARI.eq(syoriCtl.getKthhbkbn())) {
            syoriCtl.setKetteikbn(C_KetteiKbn.NONE);
            syoriCtl.setSateijtkbn(C_SateijtKbn.SATEI_TYUU);
            syoriCtl.setSateizumiymd(null);
            syoriCtl.setSeiritukbn(C_SeirituKbn.NONE);
            pMp.setKetteiSijisyoYouhiKbn(C_KetsijisyoyhKbn.YOU);
            pMp.getListKetteiSijiMsg().add(MessageUtil.getMessage(MessageId.WHC0018));
            pMp.getListKetteiSijiMsgId().add(MessageId.WHC0018);

            if (syoriCtl.getTokujyou() != null) {
                syoriCtl.setTokujyou(null);
            }

            boolean delFlag = false;

            List<HT_SyouhnTokujyou> syouhnTokujyouLst = syoriCtl.getSyouhnTokujyous();
            if (syouhnTokujyouLst != null && syouhnTokujyouLst.size() > 0) {
                syouhnTokujyouLst.clear();
                delFlag = true;
            }

            List<HT_SonotaTkykJktk> sonotaTkykJktkLst = syoriCtl.getSonotaTkykJktks();
            if (sonotaTkykJktkLst != null && sonotaTkykJktkLst.size() > 0) {
                sonotaTkykJktkLst.clear();
                delFlag = true;
            }

            if (delFlag) {
                pMp.getListKekkaGmnMsg().add(MessageUtil.getMessage(MessageId.IHC0004));
            }
        }

        if (C_KetsrhkosKbn.KETHORYU_HUBI.eq(pKetsrhkosKbn) &&
            !C_SpKeisanKahiKbn.SPKEISANHUKA.eq(pMp.getKthjiSpKeisanKahiKbn())) {
            pMp.setKthjiSpKeisanKahiKbn(pSpKeisanKahiKbn);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 不備メッセージ設定処理 終了");
        }
    }
    public void exec(C_KetsrhkosKbn pKetsrhkosKbn,
        C_SyoruiCdKbn pSyoruiCdKbn,
        String pMessage,
        MosnaiCheckParam pMp,
        C_TknKbn pTknKbn,
        C_MsgKbn pMsgKbn) {

        exec(pKetsrhkosKbn, C_SpKeisanKahiKbn.MISETTEI, C_HubisyubetusyousaiKbn.NONE, pSyoruiCdKbn, pMessage, pMp,
            pTknKbn, pMsgKbn);

    }

    public void exec(C_KetsrhkosKbn pKetsrhkosKbn,
        C_SpKeisanKahiKbn pSpKeisanKahiKbn,
        C_HubisyubetusyousaiKbn pHubisyubetusyousaiKbn,
        String pMessage,
        MosnaiCheckParam pMp,
        C_TknKbn pTknKbn,
        C_MsgKbn pMsgKbn) {

        exec(pKetsrhkosKbn, pSpKeisanKahiKbn, pHubisyubetusyousaiKbn, C_SyoruiCdKbn.BLNK, pMessage,
            pMp, pTknKbn, pMsgKbn);

    }
    public void exec(C_KetsrhkosKbn pKetsrhkosKbn,
        C_HubisyubetusyousaiKbn pHubisyubetusyousaiKbn,
        String                  pMessage,
        MosnaiCheckParam        pMp,
        C_TknKbn                pTknKbn,
        C_MsgKbn                pMsgKbn) {

        exec(pKetsrhkosKbn, C_SpKeisanKahiKbn.SPKEISANHUKA, pHubisyubetusyousaiKbn, pMessage, pMp, pTknKbn, pMsgKbn);
    }

    public void exec(C_KetsrhkosKbn pKetsrhkosKbn,
        String           pMessage,
        MosnaiCheckParam pMp,
        C_TknKbn         pTknKbn,
        C_MsgKbn         pMsgKbn) {
        exec(pKetsrhkosKbn, C_HubisyubetusyousaiKbn.NONE, pMessage, pMp, pTknKbn, pMsgKbn);
    }

    public void exec(C_KetsrhkosKbn pKetsrhkosKbn, String pMessage, MosnaiCheckParam pMp) {
        exec(pKetsrhkosKbn, pMessage, pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
    }

    public void exec(C_KetsrhkosKbn pKetsrhkosKbn, String pMessage,
        MosnaiCheckParam pMp, C_TknKbn pTknKbn) {
        exec(pKetsrhkosKbn, pMessage, pMp, pTknKbn, C_MsgKbn.ERROR);
    }

    public void exec(String pMessageUpper, String pMessageLower,
        C_SekmossakuseiErroutKbn pSekmossakuseiErroutKbn, MosnaiCheckParam pMp) {
        logger.debug("▽ 不備メッセージ設定処理 開始");
        logger.debug("｜    メッセージ文言上段=" + pMessageUpper);
        logger.debug("｜    メッセージ文言下段=" + pMessageLower);
        logger.debug("｜    設計書申込書作成エラー出力区分=" + pSekmossakuseiErroutKbn);

        editSeihoWebMsg(pMessageUpper, pMessageLower, pSekmossakuseiErroutKbn, pMp);

        logger.debug("△ 不備メッセージ設定処理 終了");
    }

    public String editHubiMsgKingaku(BizCurrency pGk, BizCurrency pGkSiteiTani, C_Tuukasyu pTuukasyu) {

        BizCurrency kingaku = pGk;
        int yuukoussketasuu = 0;

        if(C_Tuukasyu.JPY.eq(pTuukasyu)) {
            if (BizCurrency.valueOf(10000, BizCurrencyTypes.YEN).compareTo(pGkSiteiTani) <= 0) {

                kingaku = pGk.convCurrencyType(BizCurrencyTypes.MANYEN, BizRate.optional());
            }
        }
        else {

            if (BizCurrency.valueOf(1, pGkSiteiTani.getType()).compareTo(pGkSiteiTani) > 0) {

                if (BizCurrency.valueOf(0.1, pGkSiteiTani.getType()).compareTo(pGkSiteiTani) <= 0) {
                    yuukoussketasuu = 1;
                }
                else {
                    yuukoussketasuu = 2;
                }
            }
        }

        return ViewReport.editCommaTuukaNoSpace(kingaku, BizUtil.ZERO_FILL, yuukoussketasuu);
    }

    public String editHubiMsgKingakuPKans(BizCurrency pKingaku, BizCurrency pGkSiteiTani, C_Tuukasyu pTuukasyu,
        boolean pJougenKingakuKansyouFlg, MosnaiCheckParam pMosnaiCheckParam,
        HT_MosKihon pMosKihon, BM_SyouhnZokusei pSyouhnZokusei) {

        BizCurrency kingaku = pKingaku;
        BizCurrency gkSiteiTani = pGkSiteiTani;

        if (C_Tuukasyu.JPY.eq(pTuukasyu)) {

            if (C_UmuKbn.ARI.eq(pMosnaiCheckParam.getSekmossakuseiHrksknnyrykUmuKbn())) {

                SkZennouIkkatuUtil skZennouIkkatuUtil = SWAKInjector.getInstance(SkZennouIkkatuUtil.class);
                BizCurrency Hrkskn = null;

                BizCurrency pTani = skZennouIkkatuUtil.getHaraikomiPTanni(
                    pSyouhnZokusei.getSyouhncd(), pSyouhnZokusei.getSyouhnsdno(), pMosKihon.getHrkkaisuu(),
                    pMosnaiCheckParam.getKiteiCheckChannelCd(), null, pTuukasyu);

                if (C_IkkatubaraiKbn.TEIKIIKKATU.eq(pMosKihon.getIkkatubaraikbn())) {
                    if (C_UmuKbn.ARI.eq(pMosKihon.getZennoumousideumu())) {

                        Hrkskn = skZennouIkkatuUtil.getZennouPFrom12IkkatuTukiPYenforMsg(
                            pJougenKingakuKansyouFlg, pSyouhnZokusei.getSyouhncd(), pSyouhnZokusei.getSyouhnsdno(),
                            pSyouhnZokusei.getRyouritusdno(), pMosKihon.getKykymd(), pKingaku, pTani, pMosKihon.getZnnkai() + 1, -4);
                    }
                    else {
                        Hrkskn = skZennouIkkatuUtil.getIkkatuPFromIkkatuTukiPYenforMsg(
                            pJougenKingakuKansyouFlg, pSyouhnZokusei.getSyouhncd(), pSyouhnZokusei.getSyouhnsdno(),
                            pSyouhnZokusei.getRyouritusdno(), pKingaku, pTani, pMosKihon.getIkkatubaraikaisuu(), -4);
                    }
                }
                else {
                    if (C_UmuKbn.ARI.eq(pMosKihon.getZennoumousideumu())) {
                        Hrkskn = skZennouIkkatuUtil.getZennouPFromNenbaraiPforMsg(
                            pJougenKingakuKansyouFlg, pSyouhnZokusei.getSyouhncd(), pSyouhnZokusei.getSyouhnsdno(),
                            pSyouhnZokusei.getRyouritusdno(), pMosKihon.getKykymd(), pKingaku, pTani, pMosKihon.getZnnkai() + 1, 0);
                    }
                }
                if (Hrkskn != null) {
                    kingaku = Hrkskn;

                    if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(pMosKihon.getHknsyuruino())) {
                        gkSiteiTani = BizCurrency.valueOf(10000, BizCurrencyTypes.YEN);
                    }
                    else {
                        gkSiteiTani = BizCurrency.valueOf(1, BizCurrencyTypes.YEN);
                    }
                }
            }
        }

        return editHubiMsgKingaku(kingaku, gkSiteiTani, pTuukasyu);
    }


    private void editSeihoWebMsg(String pMessageUpper, String pMessageLower,
        C_SekmossakuseiErroutKbn pSekmossakuseiErroutKbn, MosnaiCheckParam pMp) {
        String msgUpper = ConvertUtil.toZenAll(pMessageUpper, 1, 1);
        String msgLower = ConvertUtil.toZenAll(pMessageLower, 1, 1);

        if (BizUtil.isBlank(pMessageUpper) && pMessageLower.length() > 40) {
            msgUpper = msgLower.substring(0, 40);
            msgLower = msgLower.substring(40);
        }

        if (msgUpper.length() > 40) {
            msgUpper = msgUpper.substring(0, 40);
        }

        if (msgLower.length() > 40) {
            msgLower = msgLower.substring(0, 40);
        }

        pMp.setSekmossakuseiErroutKbn(pSekmossakuseiErroutKbn);
        pMp.setSekmossakuseiErrmsg1(msgUpper);
        pMp.setSekmossakuseiErrmsg2(msgLower);
        pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
    }

    public List<String> editMsg(String pMessage, C_SysKbn pSysKbn, C_TknKbn pTknKbn) {
        List<String> msgResultLst = Lists.newArrayList();

        String msgID = "";
        if (BizUtil.isBlank(pMessage) || pMessage.length() < 9) {
            msgID = "";
        }
        else {
            msgID = pMessage.substring(0, 7);
        }

        String convertTarStr = "";
        if (BizUtil.isBlank(pMessage)) {
            convertTarStr = "";
        }
        else if (pMessage.length() < 9) {
            convertTarStr = pMessage;
        }
        else {
            convertTarStr = pMessage.substring(8);
        }

        String zenMsg = ConvertUtil.toZenAll(convertTarStr, 1, 1);

        String tokuninSettou = "";

        String zenMojiEditMsg = "";

        C_TknKbn tknKbn = null;

        if (C_SysKbn.ESHIEN.eq(pSysKbn)) {
            tknKbn = C_TknKbn.NONE;
        }
        else {
            tknKbn = pTknKbn;
        }

        zenMojiEditMsg = EditGamenString.editStringSbstr(zenMsg, FUBI_MSG_MAX_KETASUU);

        if (BizUtil.isBlank(msgID)) {
            msgResultLst.add(msgID);
            msgResultLst.add(msgID);
            msgResultLst.add(zenMojiEditMsg);

            return msgResultLst;
        }

        if (C_TknKbn.NONE.eq(tknKbn)) {
            msgResultLst.add(msgID);
            msgResultLst.add(msgID);
            msgResultLst.add(zenMojiEditMsg);

            return msgResultLst;
        }

        String msg1stChar = "";
        if (C_TknKbn.SUMI.eq(tknKbn)) {
            msg1stChar = MESSAGE_1ST_CHAR_TOKUNIN_SUMI;
            tokuninSettou = TOKUNIN_SUMI_SETTOU;
        }
        else {
            msg1stChar = MESSAGE_1ST_CHAR_TOKUNIN_KANOU;
            tokuninSettou = TOKUNIN_KANOU_SETTOU;
        }

        msgResultLst.add(msgID);
        msgResultLst.add(msg1stChar + msgID.substring(1));
        msgResultLst.add(EditGamenString.editStringSbstr(tokuninSettou + zenMojiEditMsg, FUBI_MSG_MAX_KETASUU));

        return msgResultLst;
    }
}