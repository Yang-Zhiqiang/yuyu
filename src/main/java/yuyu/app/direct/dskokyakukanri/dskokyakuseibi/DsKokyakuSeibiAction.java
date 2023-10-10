package yuyu.app.direct.dskokyakukanri.dskokyakuseibi;

import static yuyu.app.direct.dskokyakukanri.dskokyakuseibi.GenDsKokyakuSeibiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 顧客整備 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,                  page=PAGENO_INIT,                  path="/direct/dskokyakukanri/dskokyakuseibi/DsKokyakuSeibi.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                                  path="/direct/dskokyakukanri/dskokyakuseibi/ds_kokyaku_seibi.jsp"),
    @Forward(name=FORWARDNAME_SELECTSYORI,           page=PAGENO_SELECTSYORI,           path="/direct/dskokyakukanri/dskokyakuseibi/ds_kokyaku_seibi.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEYSELECT,        page=PAGENO_INPUTKEYSELECT,        path="/direct/dskokyakukanri/dskokyakuseibi/ds_kokyaku_seibi.jsp"),
    @Forward(name=FORWARDNAME_SEIBITSSEARCH,         page=PAGENO_SEIBITSSEARCH,         path="/direct/dskokyakukanri/dskokyakuseibi/ds_kokyaku_seibi.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,         page=PAGENO_INPUTCONTENTS,         path="/direct/dskokyakukanri/dskokyakuseibi/ds_kokyaku_seibi.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,               page=PAGENO_CONFIRM,               path="/direct/dskokyakukanri/dskokyakuseibi/ds_kokyaku_seibi.jsp"),
    @Forward(name=FORWARDNAME_RESULT,                page=PAGENO_RESULT,                path="/direct/dskokyakukanri/dskokyakuseibi/ds_kokyaku_seibi.jsp"),
    @Forward(name=FORWARDNAME_KYKBTINPUTCONTENTS,    page=PAGENO_KYKBTINPUTCONTENTS,    path="/direct/dskokyakukanri/dskokyakuseibi/ds_kokyaku_seibi.jsp"),
    @Forward(name=FORWARDNAME_KYKBTCONFIRM,          page=PAGENO_KYKBTCONFIRM,          path="/direct/dskokyakukanri/dskokyakuseibi/ds_kokyaku_seibi.jsp"),
    @Forward(name=FORWARDNAME_KYKBTRESULT,           page=PAGENO_KYKBTRESULT,           path="/direct/dskokyakukanri/dskokyakuseibi/ds_kokyaku_seibi.jsp"),
    @Forward(name=FORWARDNAME_TKTITRHKYUKOUZASEARCH, page=PAGENO_TKTITRHKYUKOUZASEARCH, path="/direct/dskokyakukanri/dskokyakuseibi/ds_kokyaku_seibi.jsp"),
    @Forward(name=FORWARDNAME_GOTODSTRHKSERVICETOUROKU,                                 path="/direct/dskokyakukanri/dstrhkservicetouroku/DsTrhkServiceTouroku.do?_eventHandler=fromDsKokyakuSeibi", redirect=true),
})
@Input("/direct/dskokyakukanri/dskokyakuseibi/ds_kokyaku_seibi.jsp")
@UIBean(beanClass=DsKokyakuSeibiUiBean.class)
public class DsKokyakuSeibiAction {

    @Inject
    private DsKokyakuSeibiBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_SELECTSYORI;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchbtnbyinputkeyselectOnClick() {
        bizLogic.pushSearchbtnbyinputkeyselectBL();
        return FORWARDNAME_INPUTKEYSELECT;
    }

    public String clearbtnbyinputkeyselectOnClick() {
        bizLogic.pushClearbtnbyinputkeyselectBL();
        return FORWARDNAME_INPUTKEYSELECT;
    }

    public String searchbtnbyseibitssearchOnClick() {
        bizLogic.pushSearchbtnbyseibitssearchBL();
        return FORWARDNAME_SEIBITSSEARCH;
    }

    public String clearbtnbyseibitssearchOnClick() {
        bizLogic.pushClearbtnbyseibitssearchBL();
        return FORWARDNAME_SEIBITSSEARCH;
    }

    public String dskoknoOnClick() {
        bizLogic.pushDskoknoLink();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin
    public String kokseibibtnOnClick() {
        bizLogic.pushKokseibibtnBL();
        return FORWARDNAME_INPUTKEYSELECT;
    }

    @Begin(renew = true)
    public String fromCTI() {
        bizLogic.fromCTIkokseibi();
        return FORWARDNAME_INPUTKEYSELECT;
    }

    @Begin
    public String seibitssearchbtnOnClick() {
        bizLogic.pushSeibitssearchbtnBL();
        return FORWARDNAME_SEIBITSSEARCH;
    }

    @Begin
    public String searchtktitrhkkzbtnOnClick() {
        bizLogic.pushSearchtktitrhkkzbtnBL();
        return FORWARDNAME_TKTITRHKYUKOUZASEARCH;
    }

    public String searchbtnbytktitrhkkzOnClick() {
        bizLogic.pushSearchbtnbytktitrhkkzBL();
        return FORWARDNAME_TKTITRHKYUKOUZASEARCH;
    }

    public String clearbtnbytktitrhkkzOnClick() {
        bizLogic.pushClearbtnbytktitrhkkzBL();
        return FORWARDNAME_TKTITRHKYUKOUZASEARCH;
    }

    @End
    public String modorubtnOnClick() {
        bizLogic.clear();
        return FORWARDNAME_SELECTSYORI;
    }

    public String modoruBtnByInputContentsOnClick() {

        String rtnUrl = bizLogic.pushModoruBtnByInputContentsBL();

        return rtnUrl;
    }

    public String kakuninBtnOnClick() {
        bizLogic.pushKakuninBtnBL();
        return FORWARDNAME_CONFIRM;
    }

    public String syonoOnClick() {

        bizLogic.pushSyonoLink();
        return FORWARDNAME_KYKBTINPUTCONTENTS;
    }

    public String accountlockkaijyobtnOnClick() {
        bizLogic.pushAccountlockkaijyobtnBL();
        return FORWARDNAME_CONFIRM;
    }

    public String serviceteisibtnOnClick() {
        bizLogic.pushServiceteisibtnBL();
        return FORWARDNAME_CONFIRM;
    }

    public String servicesaikaibtnOnClick() {
        bizLogic.pushServicesaikaibtnBL();
        return FORWARDNAME_CONFIRM;
    }

    public String dskaiyakubtnOnClick() {
        bizLogic.pushDskaiyakubtnBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.pushModoruBtnByConfirmBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.pushKakuteiBtnBL();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenhebtnbyresultOnClick() {
        return FORWARDNAME_SELECTSYORI;
    }

    public String modorubtnbykykbticOnClick() {
        bizLogic.pushModoruBtnByKykbticBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String trhkserviceteisibtnOnClick() {
        bizLogic.pushTrhkserviceteisiBtnBL();
        return FORWARDNAME_KYKBTCONFIRM;
    }

    public String modorubtnbykykconfirmOnClick() {
        bizLogic.pushModoruBtnByKykconfirmBL();
        return FORWARDNAME_KYKBTINPUTCONTENTS;
    }

    @End
    public String kakuteibtnbykykconfirmOnClick() {
        bizLogic.pushKakuteiBtnByKykconfirmBL();
        return FORWARDNAME_KYKBTRESULT;
    }

    public String syokigamenhebtnbykykbtrsltOnClick() {
        return FORWARDNAME_SELECTSYORI;
    }

    public String searchResultInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    public String srchRsltKzInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    public String dskokkykInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
