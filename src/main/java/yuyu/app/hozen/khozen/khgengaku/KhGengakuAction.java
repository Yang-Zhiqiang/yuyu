package yuyu.app.hozen.khozen.khgengaku;

import static yuyu.app.hozen.khozen.khgengaku.GenKhGengakuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;
import yuyu.common.biz.bzcommon.BizUiBeanBackupUtil;
import yuyu.def.classification.C_KidougmKbn;

/**
 * 減額 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/hozen/khozen/khgengaku/KhGengaku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/hozen/khozen/khgengaku/kh_gengaku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/hozen/khozen/khgengaku/kh_gengaku.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE,      page=PAGENO_REFERENCE,     path="/hozen/khozen/khgengaku/kh_gengaku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/hozen/khozen/khgengaku/kh_gengaku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/hozen/khozen/khgengaku/kh_gengaku.jsp"),
    @Forward(name=FORWARDNAME_SKSCONFIRM,     page=PAGENO_SKSCONFIRM,    path="/hozen/khozen/khgengaku/kh_gengaku.jsp"),
    @Forward(name=FORWARDNAME_SKSRESULT,      page=PAGENO_SKSRESULT,     path="/hozen/khozen/khgengaku/kh_gengaku.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhGengaku", redirect=true),
})
@Input("/hozen/khozen/khgengaku/kh_gengaku.jsp")
@UIBean(beanClass=KhGengakuUiBean.class)
public class KhGengakuAction {

    @Inject
    private KhGengakuBizLogic bizLogic;

    @Inject
    private KhGengakuUiBean uiBean;

    @Inject
    private InputContentsCopyBean inputContentsBean;

    @Inject
    private ReferenceCopyBean referenceBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {

        if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {

            bizLogic.pushUnlockProcessBL();
        }

        return null;
    }

    public String fromHozenWorkList() {

        try {

            bizLogic.iwfOpenBL();

        } catch (BizLogicException bizLogicException) {

            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);

            bizLogic.pushUnlockProcessBL();

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String hyoujilinkOnClick() {

        bizLogic.printHyoujiOut();

        return null;
    }

    public String allhyoujibtnOnClick() {

        bizLogic.printAllHyoujiOut();

        return null;
    }

    @End(nested = true)
    public String syoukainomibtnOnClick() {

        String rtnUrl = bizLogic.syoukainomibtnOnClickBL();

        return rtnUrl;
    }

    public String sainyuuryokubtnOnClick() {

        BizUiBeanBackupUtil.restore(uiBean, inputContentsBean);

        bizLogic.pushSaiNyuuryoku();

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String skssakuseibtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean,referenceBean);

        bizLogic.pushSeikyuusyoSakusei();

        return FORWARDNAME_SKSCONFIRM;
    }

    @Begin
    public String nyuuryokubtnOnClick() {

        bizLogic.pushNyuryoku();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @End(nested = true)
    public String modoruBtnByInputContentsOnClick() {

        String rtnUrl = bizLogic.modorubtnbyinputcontentsOnClickBL();

        return rtnUrl;
    }

    public String syoukaibtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean,inputContentsBean);

        bizLogic.pushSyoukai();

        return FORWARDNAME_REFERENCE;
    }

    public String kakuninBtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean,referenceBean);

        bizLogic.pushKakunin();

        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        BizUiBeanBackupUtil.restore(uiBean, referenceBean);

        bizLogic.kakuninModoru();

        return FORWARDNAME_REFERENCE;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        try {

            bizLogic.doUpdate();

        } catch (BizLogicException bizLogicException) {

            bizLogic.pushUnlockProcessBL();

            throw bizLogicException;
        }

        return FORWARDNAME_RESULT;
    }

    @End(nested = true)
    public String syokigamenheBtnOnClick() {

        String rtnUrl = bizLogic.syokigamenhebtnbyresultOnClickBL();

        return rtnUrl;
    }

    public String modorubtnbysksconfirmOnClick() {

        bizLogic.seikyuSyoModoru();

        BizUiBeanBackupUtil.restore(uiBean, referenceBean);

        return FORWARDNAME_REFERENCE;
    }

    @MultiPostConstraints
    public String kakuteibtnbysksconfirmOnClick() {

        bizLogic.doUpdateSeikyuSyo();

        return FORWARDNAME_SKSRESULT;
    }

    @End(nested = true)
    public String syokigamenhebtnbysksresultOnClick() {
        return FORWARDNAME_INIT;
    }

    @End(nested = true)
    public String functionNameOnClick() {

        String rtnUrl = bizLogic.functionNameOnClickBL();

        return rtnUrl;
    }

    public String fromCTI() {
        bizLogic.ctiOpenBL();
        return FORWARDNAME_INPUTKEY;
    }

    @MultiPostConstraints
    public void print() {

        bizLogic.printOut();
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {

        bizLogic.pushUnlockProcessBL();
    }
}
