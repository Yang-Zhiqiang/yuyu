package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_MsgSyubetu;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_YobidasimotoTaskKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JM_SkNaiyouChk;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 請求内容チェック 請求内容チェック結果設定処理
 */
public class SiSKNaiyouChkkekkaSettei {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private static Logger logger;

    public SiSKNaiyouChkkekkaSettei() {
        super();
    }

    public void exec(C_SeikyuuSyubetu pSeikyuuSyubetu,
        String pYobidasiMotoKinouID,
        C_SikinouModeIdKbn pYobidasiMotoTaskID,
        CheckSbSkNaiyouKekkaBean pCheckSbSkNaiyouKekkaBean,
        CheckKdSkNaiyouKekkaBean pCheckKdSkNaiyouKekkaBean,
        CheckSbkrSkNaiyouKekkaBean pCheckSbkrSkNaiyouKekkaBean,
        CheckSdsSkNaiyouKekkaBean pCheckSdsSkNaiyouKekkaBean,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 請求内容チェック結果設定処理 開始");

        C_YobidasimotoTaskKbn yobidasimotoTaskKbn = C_YobidasimotoTaskKbn.BLNK;

        if (TeisuuSiharai.SISEIKYUUUKETUKESB.equals(pYobidasiMotoKinouID) &&
            (C_SikinouModeIdKbn.INPUT.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.TENKEN.eq(pYobidasiMotoTaskID))) {
            yobidasimotoTaskKbn = C_YobidasimotoTaskKbn.SKUKE;
        }
        else if (TeisuuSiharai.SISATEISB.equals(pYobidasiMotoKinouID) &&
            (C_SikinouModeIdKbn.SATEI1.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.SATEI2.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.SATEI3.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.SATEI4.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.HUBIKANRITYUU.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.KAKUNINIRAITYUU.eq(pYobidasiMotoTaskID))) {
            yobidasimotoTaskKbn = C_YobidasimotoTaskKbn.SATEI;
        }
        else if (TeisuuSiharai.SISATEISB.equals(pYobidasiMotoKinouID) &&
            (C_SikinouModeIdKbn.TETUDUKI_SATEIYOU.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.eq(pYobidasiMotoTaskID))) {
            yobidasimotoTaskKbn = C_YobidasimotoTaskKbn.TETUDUKI_SYOUNIN;
        }
        else if (TeisuuSiharai.SISATEISB.equals(pYobidasiMotoKinouID) &&
            (C_SikinouModeIdKbn.SESSYOU1.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.SESSYOU2.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.eq(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.eq(pYobidasiMotoTaskID))) {
            yobidasimotoTaskKbn = C_YobidasimotoTaskKbn.SESYOU_KAIKETU;
        }
        else if(TeisuuSiharai.SISIBOUKARIUKETUKE.equals(pYobidasiMotoKinouID)){
            yobidasimotoTaskKbn = C_YobidasimotoTaskKbn.SIBOUKARIUKETUKE;
        }
        else if (TeisuuSiharai.SISINDANSYORYOUSIHARAI.equals(pYobidasiMotoKinouID)
            && (C_SikinouModeIdKbn.INPUT.equals(pYobidasiMotoTaskID) ||
                C_SikinouModeIdKbn.TENKEN.equals(pYobidasiMotoTaskID))) {
            yobidasimotoTaskKbn = C_YobidasimotoTaskKbn.SINDANSYORYOUSHR;
        }

        for (ChkKekkaBean chkKekkaBean : pChkKekkaBeanLst) {
            JM_SkNaiyouChk skNaiyouChk = siharaiDomManager.getSkNaiyouChk(chkKekkaBean.getSKNaiyouChkKbn(),
                yobidasimotoTaskKbn);
            if (skNaiyouChk != null) {
                SiMsgHikisuuSettei siMsgHikisuuSettei = SWAKInjector.getInstance(SiMsgHikisuuSettei.class);
                List<String> msgLst = siMsgHikisuuSettei.exec(skNaiyouChk, chkKekkaBean.getMsgHikisuu1(),
                    chkKekkaBean.getMsgHikisuu2(),
                    chkKekkaBean.getMsgHikisuu3(),
                    chkKekkaBean.getMsgHikisuu4(),
                    chkKekkaBean.getMsgHikisuu5());
                if (C_SeikyuuSyubetu.SB.eq(pSeikyuuSyubetu)) {
                    if (C_YouhiKbn.YOU.eq(skNaiyouChk.getSateikaisouyouhikbn())) {
                        pCheckSbSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(skNaiyouChk.getSateikaisouyouhikbn());
                    }
                    if (C_KahiKbn.HUKA.eq(skNaiyouChk.getKeisankahikbn())) {
                        pCheckSbSkNaiyouKekkaBean.setKeisanKahiKbn(skNaiyouChk.getKeisankahikbn());
                    }
                    if (C_MsgSyubetu.WARNING.eq(skNaiyouChk.getMsgsyubetu())) {

                        pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add(skNaiyouChk.getMessageId());
                        pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add(msgLst.get(0));
                        pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add(msgLst.get(1));
                        pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add(msgLst.get(2));
                        pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add(msgLst.get(3));
                        pCheckSbSkNaiyouKekkaBean.getWarningMessageList().add(msgLst.get(4));

                    }
                    else if (C_MsgSyubetu.ERROR.eq(skNaiyouChk.getMsgsyubetu()) ||
                        C_MsgSyubetu.TERROR.eq(skNaiyouChk.getMsgsyubetu())) {
                        pCheckSbSkNaiyouKekkaBean.getErrorMessageCollector().addMessage(
                            skNaiyouChk.getMessageId(),
                            msgLst.get(0),
                            msgLst.get(1),
                            msgLst.get(2),
                            msgLst.get(3),
                            msgLst.get(4));
                    }
                }
                else if (C_SeikyuuSyubetu.KOUSG.eq(pSeikyuuSyubetu)) {
                    if (C_YouhiKbn.YOU.eq(skNaiyouChk.getSateikaisouyouhikbn())) {
                        pCheckKdSkNaiyouKekkaBean.setSateiKaisouYouhiKbn(skNaiyouChk.getSateikaisouyouhikbn());
                    }
                    if (C_KahiKbn.HUKA.eq(skNaiyouChk.getKeisankahikbn())) {
                        pCheckKdSkNaiyouKekkaBean.setKeisanKahiKbn(skNaiyouChk.getKeisankahikbn());
                    }
                    if (C_MsgSyubetu.WARNING.eq(skNaiyouChk.getMsgsyubetu())) {

                        pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add(skNaiyouChk.getMessageId());
                        pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add(msgLst.get(0));
                        pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add(msgLst.get(1));
                        pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add(msgLst.get(2));
                        pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add(msgLst.get(3));
                        pCheckKdSkNaiyouKekkaBean.getWarningMessageList().add(msgLst.get(4));
                    }
                    else if (C_MsgSyubetu.ERROR.eq(skNaiyouChk.getMsgsyubetu()) ||
                        C_MsgSyubetu.TERROR.eq(skNaiyouChk.getMsgsyubetu())) {
                        pCheckKdSkNaiyouKekkaBean.getErrorMessageCollector().addMessage(skNaiyouChk.getMessageId(),
                            msgLst.get(0),
                            msgLst.get(1),
                            msgLst.get(2),
                            msgLst.get(3),
                            msgLst.get(4));
                    }
                }
                else if (C_SeikyuuSyubetu.SDSSHR.eq(pSeikyuuSyubetu)) {
                    if (C_MsgSyubetu.WARNING.eq(skNaiyouChk.getMsgsyubetu())) {

                        pCheckSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().add(
                            skNaiyouChk.getMessageId());
                        pCheckSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().add(msgLst.get(0));
                        pCheckSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().add(msgLst.get(1));
                        pCheckSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().add(msgLst.get(2));
                        pCheckSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().add(msgLst.get(3));
                        pCheckSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaAlert().add(msgLst.get(4));
                    }
                    else if (C_MsgSyubetu.ERROR.eq(skNaiyouChk.getMsgsyubetu()) ||
                        C_MsgSyubetu.TERROR.eq(skNaiyouChk.getMsgsyubetu())) {
                        pCheckSdsSkNaiyouKekkaBean.getSdsrSeikyuuNaiyouChkKekkaError().addMessage(
                            skNaiyouChk.getMessageId(),
                            msgLst.get(0),
                            msgLst.get(1),
                            msgLst.get(2),
                            msgLst.get(3),
                            msgLst.get(4));
                    }
                }
                else if (C_SeikyuuSyubetu.SBKRUKTK.eq(pSeikyuuSyubetu)){
                    if (C_MsgSyubetu.WARNING.eq(skNaiyouChk.getMsgsyubetu())) {

                        pCheckSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().add(
                            skNaiyouChk.getMessageId());
                        pCheckSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().add(msgLst.get(0));
                        pCheckSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().add(msgLst.get(1));
                        pCheckSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().add(msgLst.get(2));
                        pCheckSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().add(msgLst.get(3));
                        pCheckSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaAlert().add(msgLst.get(4));
                    }
                    else if (C_MsgSyubetu.ERROR.eq(skNaiyouChk.getMsgsyubetu()) ||
                        C_MsgSyubetu.TERROR.eq(skNaiyouChk.getMsgsyubetu())) {
                        pCheckSbkrSkNaiyouKekkaBean.getSbkrSeikyuuNaiyouChkKekkaError().addMessage(
                            skNaiyouChk.getMessageId(),
                            msgLst.get(0),
                            msgLst.get(1),
                            msgLst.get(2),
                            msgLst.get(3),
                            msgLst.get(4));
                    }
                }
            }
        }
        logger.debug("△ 請求内容チェック結果設定処理 終了");
    }
}
