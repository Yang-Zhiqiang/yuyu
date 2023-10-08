package yuyu.app.hozen.khozen.khsiteidairitokuyakuhuka;

import static yuyu.app.hozen.khozen.khsiteidairitokuyakuhuka.GenKhSiteidairiTokuyakuHukaConstants.*;

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

/**
 * 被保険者代理特約中途付加 機能のアクションクラスです。
 */
@Forwards({
    @Forward(name = FORWARDNAME_INIT, page = PAGENO_INIT, path = "/hozen/khozen/khsiteidairitokuyakuhuka/KhSiteidairiTokuyakuHuka.do", redirect = true),
    @Forward(name = FORWARDNAME_INPUTKEY, page = PAGENO_INPUTKEY, path = "/hozen/khozen/khsiteidairitokuyakuhuka/kh_siteidairi_tokuyaku_huka.jsp"),
    @Forward(name = FORWARDNAME_INPUTCONTENTS, page = PAGENO_INPUTCONTENTS, path = "/hozen/khozen/khsiteidairitokuyakuhuka/kh_siteidairi_tokuyaku_huka.jsp"),
    @Forward(name = FORWARDNAME_REFERENCE, page = PAGENO_REFERENCE, path = "/hozen/khozen/khsiteidairitokuyakuhuka/kh_siteidairi_tokuyaku_huka.jsp"),
    @Forward(name = FORWARDNAME_CONFIRM, page = PAGENO_CONFIRM, path = "/hozen/khozen/khsiteidairitokuyakuhuka/kh_siteidairi_tokuyaku_huka.jsp"),
    @Forward(name = FORWARDNAME_RESULT, page = PAGENO_RESULT, path = "/hozen/khozen/khsiteidairitokuyakuhuka/kh_siteidairi_tokuyaku_huka.jsp"),
    @Forward(name = FORWARDNAME_SKSCONFIRM, page = PAGENO_SKSCONFIRM, path = "/hozen/khozen/khsiteidairitokuyakuhuka/kh_siteidairi_tokuyaku_huka.jsp"),
    @Forward(name = FORWARDNAME_SKSRESULT, page = PAGENO_SKSRESULT, path = "/hozen/khozen/khsiteidairitokuyakuhuka/kh_siteidairi_tokuyaku_huka.jsp"),
    @Forward(name = FORWARDNAME_BACKTOWORKLIST, path = "/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhSiteidairiTokuyakuHuka", redirect = true),
})
@Input("/hozen/khozen/khsiteidairitokuyakuhuka/kh_siteidairi_tokuyaku_huka.jsp")
@UIBean(beanClass = KhSiteidairiTokuyakuHukaUiBean.class)
public class KhSiteidairiTokuyakuHukaAction {

    @Inject
    private KhSiteidairiTokuyakuHukaBizLogic bizLogic;

    @Inject
    private KhSiteidairiTokuyakuHukaUiBean uiBean;

    @Inject
    private InputContentsCopyBean inputContentsBean;

    @Inject
    private ReferenceCopyBean referenceBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    public String fromHozenWorkList() {
        try {
            bizLogic.iwfOpenBL();

        } catch (BizLogicException bizLogicException) {

            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);

            bizLogic.unlockProcess();

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    @End(nested = true)
    public String functionNameOnClick() {

        String rtnUrl = bizLogic.functionNameOnClickBL();

        return rtnUrl;
    }

    @End
    public String tojiruBtnOnClick() {

        bizLogic.closeBL();

        return null;
    }

    @Begin
    public String nyuuryokubtnOnClick() {

        bizLogic.pushNyuuryokuBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String syoukaibtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean,inputContentsBean);

        bizLogic.pushSyoukaiBL();

        return FORWARDNAME_REFERENCE;
    }

    @End(nested = true)
    public String modoruBtnByInputContentsOnClick() {

        String rtnUrl = bizLogic.modoruBtnByInputBL();

        return rtnUrl;
    }

    public String hyoujilinkOnClick() {

        bizLogic.printHyoujiOutBL();

        return null;
    }

    public String allhyoujibtnOnClick() {

        bizLogic.printAllHyoujiOutBL();

        return null;
    }

    public String skssakuseibtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean, referenceBean);

        bizLogic.pushSeikyuusyoSakuseiBL();

        return FORWARDNAME_SKSCONFIRM;
    }

    @End(nested = true)
    public String syoukainomibtnOnClick() {

        String rtnUrl = bizLogic.pushSyoukainomiBL();

        return rtnUrl;
    }

    public String sainyuuryokubtnOnClick() {

        bizLogic.pushSainyuuryokuBL();

        BizUiBeanBackupUtil.restore(uiBean, inputContentsBean);

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String kakuninBtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean, referenceBean);

        bizLogic.pushKakuninBL();

        return FORWARDNAME_CONFIRM;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        try {
            bizLogic.pushKakuteiByKakuninBL();

        } catch (BizLogicException bizLogicException) {

            bizLogic.unlockProcess();
            throw bizLogicException;
        }

        return FORWARDNAME_RESULT;
    }

    public String modoruBtnByConfirmOnClick() {

        BizUiBeanBackupUtil.restore(uiBean, referenceBean);

        bizLogic.modoruBtnByKakuninBL();

        return FORWARDNAME_REFERENCE;
    }

    @End(nested = true)
    public String syokigamenheBtnOnClick() {

        String rtnUrl = bizLogic.syokigamenBykekkaBL();

        return rtnUrl;
    }

    @MultiPostConstraints
    public String kakuteibtnbysksconfirmOnClick() {

        try {
            bizLogic.pushKakuteiBySksconfirmBL();
        } catch (BizLogicException bizLogicException) {

            bizLogic.unlockProcess();
            throw bizLogicException;
        }

        return FORWARDNAME_SKSRESULT;
    }

    public String modorubtnbysksconfirmOnClick() {

        BizUiBeanBackupUtil.restore(uiBean, referenceBean);

        return FORWARDNAME_REFERENCE;
    }

    @End(nested = true)
    public String syokigamenhebtnbysksresultOnClick() {
        return FORWARDNAME_INIT;
    }

    @MultiPostConstraints
    public String print() {

        bizLogic.printOut();

        return null;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {

        bizLogic.unlockProcess();
    }

}
