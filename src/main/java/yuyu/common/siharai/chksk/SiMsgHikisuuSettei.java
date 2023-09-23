package yuyu.common.siharai.chksk;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;

import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.classification.C_MsgHikisuuNaiyouKbn;
import yuyu.def.db.entity.JM_SkNaiyouChk;

/**
 * 保険金給付金支払 請求内容チェック メッセージ引数設定処理
 */
public class SiMsgHikisuuSettei {

    @Inject
    private static Logger logger;

    public SiMsgHikisuuSettei() {
        super();
    }

    public List<String> exec(JM_SkNaiyouChk pSkNaiyouChk, String pMsgHikisuu1, String pMsgHikisuu2,
            String pMsgHikisuu3, String pMsgHikisuu4, String pMsgHikisuu5) {

        logger.debug("▽ メッセージ引数設定処理 開始");

        List<String> msgList = new ArrayList<>();

        if (C_MsgHikisuuNaiyouKbn.MESSAGEID.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn1())) {
            String strMsgMongon = MessageUtil.getMessage(pSkNaiyouChk.getMsghikisuu1());
            msgList.add(strMsgMongon);
        }
        else if (C_MsgHikisuuNaiyouKbn.KOUMOKUMEI.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn1())) {
            ResourceBundle resourceBundle = ResourceUtil.getApplicationResources();
            String strResult = resourceBundle.getString(pSkNaiyouChk.getMsghikisuu1());
            msgList.add(strResult);
        }
        else if (C_MsgHikisuuNaiyouKbn.INPUT.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn1())) {
            msgList.add(pMsgHikisuu1);
        }
        else {
            msgList.add("");
        }

        if (C_MsgHikisuuNaiyouKbn.MESSAGEID.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn2())) {
            String strMsgMongon = MessageUtil.getMessage(pSkNaiyouChk.getMsghikisuu2());
            msgList.add(strMsgMongon);
        }
        else if (C_MsgHikisuuNaiyouKbn.KOUMOKUMEI.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn2())) {
            ResourceBundle resourceBundle = ResourceUtil.getApplicationResources();
            String strResult = resourceBundle.getString(pSkNaiyouChk.getMsghikisuu2());
            msgList.add(strResult);
        }
        else if (C_MsgHikisuuNaiyouKbn.INPUT.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn2())) {
            msgList.add(pMsgHikisuu2);
        }
        else {
            msgList.add("");
        }

        if (C_MsgHikisuuNaiyouKbn.MESSAGEID.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn3())) {
            String strMsgMongon = MessageUtil.getMessage(pSkNaiyouChk.getMsghikisuu3());
            msgList.add(strMsgMongon);
        }
        else if (C_MsgHikisuuNaiyouKbn.KOUMOKUMEI.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn3())) {
            ResourceBundle resourceBundle = ResourceUtil.getApplicationResources();
            String strResult = resourceBundle.getString(pSkNaiyouChk.getMsghikisuu3());
            msgList.add(strResult);
        }
        else if (C_MsgHikisuuNaiyouKbn.INPUT.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn3())) {
            msgList.add(pMsgHikisuu3);
        }
        else {
            msgList.add("");
        }

        if (C_MsgHikisuuNaiyouKbn.MESSAGEID.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn4())) {
            String strMsgMongon = MessageUtil.getMessage(pSkNaiyouChk.getMsghikisuu4());
            msgList.add(strMsgMongon);
        }
        else if (C_MsgHikisuuNaiyouKbn.KOUMOKUMEI.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn4())) {
            ResourceBundle resourceBundle = ResourceUtil.getApplicationResources();
            String strResult = resourceBundle.getString(pSkNaiyouChk.getMsghikisuu4());
            msgList.add(strResult);
        }
        else if (C_MsgHikisuuNaiyouKbn.INPUT.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn4())) {
            msgList.add(pMsgHikisuu4);
        }
        else {
            msgList.add("");
        }

        if (C_MsgHikisuuNaiyouKbn.MESSAGEID.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn5())) {
            String strMsgMongon = MessageUtil.getMessage(pSkNaiyouChk.getMsghikisuu5());
            msgList.add(strMsgMongon);
        }
        else if (C_MsgHikisuuNaiyouKbn.KOUMOKUMEI.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn5())) {
            ResourceBundle resourceBundle = ResourceUtil.getApplicationResources();
            String strResult = resourceBundle.getString(pSkNaiyouChk.getMsghikisuu5());
            msgList.add(strResult);
        }
        else if (C_MsgHikisuuNaiyouKbn.INPUT.eq(pSkNaiyouChk.getMsghikisuunaiyoukbn5())) {
            msgList.add(pMsgHikisuu5);
        }
        else {
            msgList.add("");
        }

        logger.debug("△ メッセージ引数設定処理 終了");

        return msgList;
    }
}
