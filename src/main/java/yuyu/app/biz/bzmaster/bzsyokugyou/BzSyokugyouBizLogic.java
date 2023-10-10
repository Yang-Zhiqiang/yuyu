package yuyu.app.biz.bzmaster.bzsyokugyou;

import static yuyu.app.biz.bzmaster.bzsyokugyou.GenBzSyokugyouConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.biz.bzmaster.bzsyokugyou.BzSyokugyouConstants.E_SyoriKbn;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Syokugyou;

/**
 * 職業登録 のビジネスロジックです。
 */
public class BzSyokugyouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzSyokugyouUiBean uiBean;

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

    void pushAddBL() {

        BizPropertyInitializer.initialize(uiBean);

        String syokugyouCd = null;
        BM_Syokugyou syokugyou = null;

        syokugyouCd = uiBean.getSyokugyoucd();

        syokugyou = bizDomManager.getSyokugyou(syokugyouCd);

        if (syokugyou != null) {

            throw new BizLogicException(MessageId.EHA0041,
                    MessageUtil.getMessage(DDID_KEYINFO_SYOKUGYOUCD.getErrorResourceKey())
                    );

        }

        uiBean.setGmsyorikbn(E_SyoriKbn.NEW);
    }

    void pushUpdBL() {

        BizPropertyInitializer.initialize(uiBean);

        doUpdDel();

        uiBean.setGmsyorikbn(E_SyoriKbn.UPD);
    }

    void pushDelBL() {

        BizPropertyInitializer.initialize(uiBean);

        doUpdDel();

        uiBean.setGmsyorikbn(E_SyoriKbn.DEL);

        messageManager.addMessageId(MessageId.QAC0010);
    }

    void pushKakuninBL() {

        E_SyoriKbn syoriKbn = uiBean.getGmsyorikbn();

        if (syoriKbn == E_SyoriKbn.NEW) {
            messageManager.addMessageId(MessageId.QAC0008);
        }
        else if (syoriKbn == E_SyoriKbn.UPD) {
            messageManager.addMessageId(MessageId.QAC0009);
        }
    }

    @Transactional
    void pushkakuteiBL() {

        E_SyoriKbn syoriKbn = uiBean.getGmsyorikbn();

        if (syoriKbn == E_SyoriKbn.NEW) {
            doInsertTable();
        }
        else if (syoriKbn == E_SyoriKbn.UPD) {
            doUpdateTable();
        }
        else if (syoriKbn == E_SyoriKbn.DEL) {
            doDeleteTable();
        }

        messageManager.addMessageId(MessageId.IAC0009);
    }


    private void doUpdDel() {

        String syokugyouCd = null;
        BM_Syokugyou syokugyou = null;

        syokugyouCd = uiBean.getSyokugyoucd();

        syokugyou = bizDomManager.getSyokugyou(syokugyouCd);

        if (syokugyou == null) {
            throw new BizLogicException(MessageId.EBA0030,
                    MessageUtil.getMessage(DDID_KEYINFO_SYOKUGYOUCD.getErrorResourceKey())
                    );

        }

        uiBean.setSyokugyou(syokugyou);

        uiBean.setSyokugyounm(syokugyou.getSyokugyounm());
    }

    private void doInsertTable() {
        String userID = null;
        String kostime = null;
        BM_Syokugyou syokugyou = null;

        userID = baseUserInfo.getUserId();
        kostime = BizDate.getSysDateTimeMilli();

        syokugyou = setSyokugyou();
        setSystemKoumoku(syokugyou, userID, kostime);

        BizPropertyInitializer.initialize(syokugyou);

        bizDomManager.insert(syokugyou);
    }

    private void doUpdateTable() {
        String userID = null;
        String kostime = null;
        BM_Syokugyou syokugyou = null;

        userID = baseUserInfo.getUserId();
        kostime = BizDate.getSysDateTimeMilli();

        syokugyou = setSyokugyou();
        setSystemKoumoku(syokugyou, userID, kostime);

        bizDomManager.update(syokugyou);
    }

    private void doDeleteTable() {

        BM_Syokugyou syokugyou = uiBean.getSyokugyou();

        bizDomManager.delete(syokugyou);
    }

    private void setSystemKoumoku(BM_Syokugyou pSyokugyou, String pUserID, String pSysDate) {
        pSyokugyou.setGyoumuKousinsyaId(pUserID);
        pSyokugyou.setGyoumuKousinTime(pSysDate);
    }

    private BM_Syokugyou setSyokugyou() {

        BM_Syokugyou syokugyou = null;

        E_SyoriKbn syoriKbn = uiBean.getGmsyorikbn();

        if (syoriKbn == E_SyoriKbn.NEW) {
            syokugyou = new BM_Syokugyou();
        }
        else {
            syokugyou = uiBean.getSyokugyou();
        }

        syokugyou.setSyokugyoucd(uiBean.getSyokugyoucd());
        syokugyou.setSyokugyounm(uiBean.getSyokugyounm());

        return syokugyou;
    }
}
