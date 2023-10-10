package yuyu.app.biz.bzmaster.bzsyoubyou;

import static yuyu.app.biz.bzmaster.bzsyoubyou.GenBzSyoubyouConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.biz.bzmaster.bzsyoubyou.BzSyoubyouConstants.E_SyoriKbn;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Syoubyou;

/**
 * 傷病登録 のビジネスロジックです。
 */
public class BzSyoubyouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzSyoubyouUiBean uiBean;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    void init() {
    }

    void clear() {
    }

    void pushNewBL() {
        BizPropertyInitializer.initialize(uiBean);
        String syoubyouCd = null;
        BM_Syoubyou syoubyou = null;

        syoubyouCd = uiBean.getSyoubyoucd();

        syoubyou = bizDomManager.getSyoubyou(syoubyouCd);

        if (syoubyou != null) {

            throw new BizLogicException(MessageId.EHA0041,
                    MessageUtil.getMessage(DDID_KEYINFO_SYOUBYOUCD.getErrorResourceKey())
                    );

        }

        uiBean.setGmsyorikbn(E_SyoriKbn.NEW);
    }

    void pushUpdBL() {
        doUpdDel();

        uiBean.setGmsyorikbn(E_SyoriKbn.UPD);
    }

    void pushDelBL() {
        doUpdDel();

        uiBean.setGmsyorikbn(E_SyoriKbn.DEL);

        messageManager.addMessageId(MessageId.QAC0010);
    }

    void pushKakuninBL() {

        E_SyoriKbn syoriKbn = uiBean.getGmsyorikbn();

        if  (syoriKbn == E_SyoriKbn.NEW) {
            messageManager.addMessageId(MessageId.QAC0008);
        }
        else if (syoriKbn == E_SyoriKbn.UPD) {
            messageManager.addMessageId(MessageId.QAC0009);
        }
    }

    @Transactional
    void pushKakuteiBL() {

        doUpdateTables();

        messageManager.addMessageId(MessageId.IAC0009);
    }


    private void doUpdDel() {

        String syoubyouCd = null;
        BM_Syoubyou syoubyou = null;

        syoubyouCd = uiBean.getSyoubyoucd();

        syoubyou = bizDomManager.getSyoubyou(syoubyouCd);

        if (syoubyou == null) {
            throw new BizLogicException(MessageId.EBA0030,
                    MessageUtil.getMessage(DDID_KEYINFO_SYOUBYOUCD.getErrorResourceKey()));

        }
        uiBean.setSyoubyou(syoubyou);

        uiBean.setSyoubyounm(syoubyou.getSyoubyounm());
        uiBean.setSyoubyoucdtyuubunruikbn(syoubyou.getSyoubyoucdtyuubunruikbn());
    }

    private void doUpdateTables() {

        E_SyoriKbn syoriKbn = null;
        BM_Syoubyou syoubyou = null;
        syoriKbn = uiBean.getGmsyorikbn();

        String userId = baseUserInfo.getUserId();
        String kostime = BizDate.getSysDateTimeMilli();

        if  (syoriKbn == E_SyoriKbn.DEL) {
            syoubyou = uiBean.getSyoubyou();
            bizDomManager.delete(syoubyou);
        }
        else if (syoriKbn == E_SyoriKbn.UPD) {
            syoubyou = setSyoubyouUpd();
            setSystemKoumoku(syoubyou, userId, kostime);
            bizDomManager.update(syoubyou);
        }
        else {
            syoubyou = setSyoubyouIns();
            setSystemKoumoku(syoubyou, userId, kostime);
            BizPropertyInitializer.initialize(syoubyou);
            bizDomManager.insert(syoubyou);
        }
    }

    private void setSystemKoumoku(BM_Syoubyou pSyoubyou, String pUserID, String pSysDate) {
        pSyoubyou.setGyoumuKousinsyaId(pUserID);
        pSyoubyou.setGyoumuKousinTime(pSysDate);
    }

    private BM_Syoubyou setSyoubyouUpd() {

        BM_Syoubyou syoubyou = uiBean.getSyoubyou();

        syoubyou.setSyoubyoucd(uiBean.getSyoubyoucd());
        syoubyou.setSyoubyounm(uiBean.getSyoubyounm());
        syoubyou.setSyoubyoucdtyuubunruikbn(uiBean.getSyoubyoucdtyuubunruikbn());

        return syoubyou;
    }

    private BM_Syoubyou setSyoubyouIns() {

        BM_Syoubyou syoubyou = new BM_Syoubyou();

        syoubyou.setSyoubyoucd(uiBean.getSyoubyoucd());
        syoubyou.setSyoubyounm(uiBean.getSyoubyounm());
        syoubyou.setSyoubyoucdtyuubunruikbn(uiBean.getSyoubyoucdtyuubunruikbn());

        return syoubyou;
    }
}
