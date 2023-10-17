package yuyu.app.siharai.sisatei.sisateisb;

import static yuyu.app.siharai.sisatei.sisateisb.GenSiSateiSbConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;
import yuyu.common.biz.bzcommon.BizUiBeanBackupUtil;

/**
 * （死亡）査定 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,                              page=PAGENO_INIT,                              path="/siharai/sisatei/sisateisb/SiSateiSb.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTCONTENTS_SATEI1,              page=PAGENO_INPUTCONTENTS_SATEI1,              path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_INPUTCORRECT,                      page=PAGENO_INPUTCORRECT,                      path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM_SATEI1,                    page=PAGENO_CONFIRM_SATEI1,                    path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_RESULT_SATEI1,                     page=PAGENO_RESULT_SATEI1,                     path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS_SATEI2,              page=PAGENO_INPUTCONTENTS_SATEI2,              path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM_SATEI2,                    page=PAGENO_CONFIRM_SATEI2,                    path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_RESULT_SATEI2,                     page=PAGENO_RESULT_SATEI2,                     path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS_SATEI3,              page=PAGENO_INPUTCONTENTS_SATEI3,              path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM_SATEI3,                    page=PAGENO_CONFIRM_SATEI3,                    path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_RESULT_SATEI3,                     page=PAGENO_RESULT_SATEI3,                     path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS_SATEI4,              page=PAGENO_INPUTCONTENTS_SATEI4,              path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM_SATEI4,                    page=PAGENO_CONFIRM_SATEI4,                    path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_RESULT_SATEI4,                     page=PAGENO_RESULT_SATEI4,                     path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS_TETUZUKI_SATEIHUYOU, page=PAGENO_INPUTCONTENTS_TETUZUKI_SATEIHUYOU, path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM_TETUZUKI_SATEIHUYOU,       page=PAGENO_CONFIRM_TETUZUKI_SATEIHUYOU,       path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_RESULT_TETUZUKI_SATEIHUYOU,        page=PAGENO_RESULT_TETUZUKI_SATEIHUYOU,        path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS_TETUZUKI_SATEIYOU,   page=PAGENO_INPUTCONTENTS_TETUZUKI_SATEIYOU,   path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM_TETUZUKI_SATEIYOU,         page=PAGENO_CONFIRM_TETUZUKI_SATEIYOU,         path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_RESULT_TETUZUKI_SATEIYOU,          page=PAGENO_RESULT_TETUZUKI_SATEIYOU,          path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS_SYOUNIN_SATEIHUYOU,  page=PAGENO_INPUTCONTENTS_SYOUNIN_SATEIHUYOU,  path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM_SYOUNIN_SATEIHUYOU,        page=PAGENO_CONFIRM_SYOUNIN_SATEIHUYOU,        path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_RESULT_SYOUNIN_SATEIHUYOU,         page=PAGENO_RESULT_SYOUNIN_SATEIHUYOU,         path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS_SYOUNIN_SATEIYOU,    page=PAGENO_INPUTCONTENTS_SYOUNIN_SATEIYOU,    path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM_SYOUNIN_SATEIYOU,          page=PAGENO_CONFIRM_SYOUNIN_SATEIYOU,          path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_RESULT_SYOUNIN_SATEIYOU,           page=PAGENO_RESULT_SYOUNIN_SATEIYOU,           path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS_SESSYOU,             page=PAGENO_INPUTCONTENTS_SESSYOU,             path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM_SESSYOU,                   page=PAGENO_CONFIRM_SESSYOU,                   path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_RESULT_SESSYOU,                    page=PAGENO_RESULT_SESSYOU,                    path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS_KAIKETU,             page=PAGENO_INPUTCONTENTS_KAIKETU,             path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM_KAIKETU,                   page=PAGENO_CONFIRM_KAIKETU,                   path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_RESULT_KAIKETU,                    page=PAGENO_RESULT_KAIKETU,                    path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS_KAKUNIN_HUBI,        page=PAGENO_INPUTCONTENTS_KAKUNIN_HUBI,        path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM_KAKUNIN_HUBI,              page=PAGENO_CONFIRM_KAKUNIN_HUBI,              path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_RESULT_KAKUNIN_HUBI,               page=PAGENO_RESULT_KAKUNIN_HUBI,               path="/siharai/sisatei/sisateisb/si_satei_sb.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                                                                   path="/workflow/processkanri/siharaiworklist/SiharaiWorkList.do?_eventHandler=fromSiSateiSb", redirect=true),
})
@Input("/siharai/sisatei/sisateisb/si_satei_sb.jsp")
@UIBean(beanClass=SiSateiSbUiBean.class)
@Roles("sisateisb")
public class SiSateiSbAction {

    @Inject
    private SiSateiSbBizLogic bizLogic;

    @Inject
    private SiSateiSbUiBean uiBean;

    @Inject
    private OldSiSateiSbUiBean oldSiSateiSbUiBean;


    public String init() {

        bizLogic.init();
        return null;
    }

    @Roles("sittzkrirekisyoukai")
    public String fromSiTtzkRirekiSyoukai() {

        String kakuninPath = bizLogic.pushFromSiTtzkRirekiSyoukaiBL();

        return kakuninPath;
    }

    public String fromSiharaiWorkList() {

        try {
            String  inputContentsPath = bizLogic.pushFromSiharaiWorkListBL();

            return inputContentsPath;

        } catch (BizLogicException exception) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(exception);
            bizLogic.pushUnlocProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
    }

    @End(nested = true)
    public String functionNameOnClick() {

        bizLogic.pushUnlocProcessBL();

        return FORWARDNAME_BACKTOWORKLIST;

    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.pushUnlocProcessBL();
        return null;
    }

    public String hbtrbtnOnClick() {
        return null;
    }

    public String hkngksisanbtnOnClick() {
        return null;
    }

    @Roles({ "sisateisb.satei1", "sisateisb.satei2", "sisateisb.satei3", "sisateisb.satei4",
        "sisateisb.tetuduki_sateiyou", "sisateisb.tetuduki_sateihuyou" })
    public String nyuuryokuteiseibtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean,oldSiSateiSbUiBean);

        bizLogic.pushTeiseiBL();

        return FORWARDNAME_INPUTCORRECT;
    }

    @End(nested = true)
    @Roles({ "sisateisb.satei1", "sisateisb.satei2", "sisateisb.satei3", "sisateisb.satei4",
        "sisateisb.tetuduki_sateiyou", "sisateisb.tetuduki_sateihuyou", "sisateisb.syounin_sateiyou",
        "sisateisb.syounin_sateihuyou","sisateisb.sessyou1", "sisateisb.sessyou2", "sisateisb.kaiketu_sessyouyou",
        "sisateisb.kaiketu_sessyouhuyou", "sisateisb.kakuniniraityuu", "sisateisb.hubikanrityuu" })
    public String modoruBtnByInputContentsOnClick() {

        bizLogic.pushUnlocProcessBL();

        return FORWARDNAME_BACKTOWORKLIST;
    }

    @Roles({ "sisateisb.satei1", "sisateisb.satei2", "sisateisb.satei3", "sisateisb.satei4",
        "sisateisb.tetuduki_sateiyou", "sisateisb.tetuduki_sateihuyou", "sisateisb.syounin_sateiyou",
        "sisateisb.syounin_sateihuyou","sisateisb.sessyou1", "sisateisb.sessyou2", "sisateisb.kaiketu_sessyouyou",
        "sisateisb.kaiketu_sessyouhuyou", "sisateisb.kakuniniraityuu", "sisateisb.hubikanrityuu" })
    public String kakuninBtnOnClick() {

        String kakuninPath =  bizLogic.pushKakuninBL();

        return kakuninPath;
    }

    @Roles({ "sisateisb.satei1", "sisateisb.satei2", "sisateisb.satei3", "sisateisb.satei4",
        "sisateisb.tetuduki_sateiyou", "sisateisb.tetuduki_sateihuyou" })
    public String modorubtnbyinputcorrectOnClick() {

        BizUiBeanBackupUtil.restore(uiBean, oldSiSateiSbUiBean);

        String inputContentsPath = bizLogic.pushInputContentsBL();

        return inputContentsPath;
    }

    @Roles({ "sisateisb.satei1", "sisateisb.satei2", "sisateisb.satei3", "sisateisb.satei4",
        "sisateisb.tetuduki_sateiyou", "sisateisb.tetuduki_sateihuyou" })
    public String saikeisanbtnOnClick() {

        String inputContentsPath = bizLogic.pushSaikeisanBL();

        return inputContentsPath;
    }

    @Roles({ "sisateisb.satei1", "sisateisb.satei2", "sisateisb.satei3", "sisateisb.satei4",
        "sisateisb.tetuduki_sateiyou", "sisateisb.tetuduki_sateihuyou", "sisateisb.syounin_sateiyou",
        "sisateisb.syounin_sateihuyou","sisateisb.sessyou1", "sisateisb.sessyou2", "sisateisb.kaiketu_sessyouyou",
        "sisateisb.kaiketu_sessyouhuyou", "sisateisb.kakuniniraityuu", "sisateisb.hubikanrityuu" })
    public String modoruBtnByConfirmOnClick() {

        String inputContentsPath = bizLogic.pushModoruByConfirmBL();

        return inputContentsPath;
    }

    @MultiPostConstraints
    @Roles({ "sisateisb.satei1", "sisateisb.satei2", "sisateisb.satei3", "sisateisb.satei4",
        "sisateisb.tetuduki_sateiyou", "sisateisb.tetuduki_sateihuyou", "sisateisb.syounin_sateiyou",
        "sisateisb.syounin_sateihuyou","sisateisb.sessyou1", "sisateisb.sessyou2", "sisateisb.kaiketu_sessyouyou",
        "sisateisb.kaiketu_sessyouhuyou", "sisateisb.kakuniniraityuu", "sisateisb.hubikanrityuu" })
    public String kakuteiBtnOnClick() {

        String resultPath = bizLogic.pushKakuteiBL();

        return resultPath;
    }

    @End(nested = true)
    @Roles({ "sisateisb.satei1", "sisateisb.satei2", "sisateisb.satei3", "sisateisb.satei4",
        "sisateisb.tetuduki_sateiyou", "sisateisb.tetuduki_sateihuyou", "sisateisb.syounin_sateiyou",
        "sisateisb.syounin_sateihuyou","sisateisb.sessyou1", "sisateisb.sessyou2", "sisateisb.kaiketu_sessyouyou",
        "sisateisb.kaiketu_sessyouhuyou", "sisateisb.kakuniniraityuu", "sisateisb.hubikanrityuu" })
    public String syokigamenheBtnOnClick() {

        return FORWARDNAME_BACKTOWORKLIST;
    }

    @Roles({ "sisateisb.satei1", "sisateisb.satei2" })
    public String kakuniniraisyosakuseibtnOnClick() {

        String inputContentsPath = bizLogic.pushKakuniniraisyoSakuseiBL();

        return inputContentsPath;
    }

    public void kakuniniraisyoSakuseiPrint() {

        bizLogic.pushKakuniniraisyoSakuseiPrintOutBL();
    }

    @MultiPostConstraints
    public void kakuteiPrint() {
        bizLogic.pushKakuteiPrintOutBL();
    }


    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.pushUnlocProcessBL();
    }
}
