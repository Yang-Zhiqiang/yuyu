package yuyu.app.base.log.batchjyoukyousyoukai;

import static yuyu.app.base.log.batchjyoukyousyoukai.GenBatchJyoukyouSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * バッチ状況照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,    page=PAGENO_INIT,    path="/base/log/batchjyoukyousyoukai/BatchJyoukyouSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                      path="/base/log/batchjyoukyousyoukai/batch_jyoukyou_syoukai.jsp"),
    @Forward(name=FORWARDNAME_SUMMARY, page=PAGENO_SUMMARY, path="/base/log/batchjyoukyousyoukai/batch_jyoukyou_syoukai.jsp"),
    @Forward(name=FORWARDNAME_DETAIL,  page=PAGENO_DETAIL,  path="/base/log/batchjyoukyousyoukai/batch_jyoukyou_syoukai.jsp"),
    @Forward(name=FORWARDNAME_PRINT,   page=PAGENO_PRINT,   path="/base/log/batchjyoukyousyoukai/batch_jyoukyou_syoukai.jsp"),
})
@Input("/base/log/batchjyoukyousyoukai/batch_jyoukyou_syoukai.jsp")
@UIBean(beanClass=BatchJyoukyouSyoukaiUiBean.class)
@Roles("batchjyoukyousyoukai")
public class BatchJyoukyouSyoukaiAction {

    @Inject
    private BatchJyoukyouSyoukaiBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_SUMMARY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String jidouKousinSuruBtnOnClick() {

        bizLogic.setAutoUpdateUmuFlg_Ari();
        return FORWARDNAME_SUMMARY;
    }

    public String jidouKousinSinaiBtnOnClick() {

        bizLogic.setAutoUpdateUmuFlg_None();
        return FORWARDNAME_SUMMARY;
    }

    public String searchBtnOnClick() {

        bizLogic.searchBatchJob();
        return FORWARDNAME_SUMMARY;
    }

    public String syousaiLinkOnClick() {

        bizLogic.setBatchDetailInfo();
        return FORWARDNAME_DETAIL;
    }

    public String tyouhyouSyuturyokuLinkOnClick() {

        bizLogic.execPrePrint();
        return FORWARDNAME_SUMMARY;
    }

    public String kousinBtnOnClick() {

        bizLogic.renewalBatchJob();
        return FORWARDNAME_SUMMARY;
    }

    public String modoruBtnByGaiyouOnClick() {
        bizLogic.clearEntity();
        bizLogic.chkBatchJobCountExExceed();
        return FORWARDNAME_SUMMARY;
    }

    public String insatuGamenBtnOnClick() {

        return FORWARDNAME_PRINT;
    }

    public String tyuudanBtnOnClick() {

        bizLogic.commandIntterupt();
        return FORWARDNAME_DETAIL;
    }

    public String batchJobListPagerOnClick() {

        return FORWARDNAME_CURRENT;
    }

    public String batchLogListPagerOnClick() {

        return FORWARDNAME_CURRENT;
    }

    public void print() {

        bizLogic.print();
    }
}
