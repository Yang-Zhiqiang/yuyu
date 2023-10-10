package yuyu.app.base.systemsyoukai.tablesyoukai;

import static yuyu.app.base.systemsyoukai.tablesyoukai.GenTableSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * テーブル照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,         page=PAGENO_INIT,         path="/base/systemsyoukai/tablesyoukai/TableSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_SELECTTABLE,  page=PAGENO_SELECTTABLE,  path="/base/systemsyoukai/tablesyoukai/table_syoukai.jsp"),
    @Forward(name=FORWARDNAME_SEARCH,       page=PAGENO_SEARCH,       path="/base/systemsyoukai/tablesyoukai/table_syoukai.jsp"),
    @Forward(name=FORWARDNAME_RESULTDETAIL, page=PAGENO_RESULTDETAIL, path="/base/systemsyoukai/tablesyoukai/table_syoukai.jsp"),
})
@Input("/base/systemsyoukai/tablesyoukai/table_syoukai.jsp")
@UIBean(beanClass=TableSyoukaiUiBean.class)
@Roles("tablesyoukai")
public class TableSyoukaiAction {

    @Inject
    private TableSyoukaiBizLogic bizLogic;

    @Begin
    public String init() {
        bizLogic.init();
        return FORWARDNAME_SELECTTABLE;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {
        bizLogic.chkSrhCond();
        bizLogic.getTableData();
        return FORWARDNAME_SELECTTABLE;
    }

    public String baseSelectLinkOnClick() {
        bizLogic.setupSearchConditionUiBean();
        return FORWARDNAME_SEARCH;
    }

    public String modoruBtnBySyousaiOnClick() {
        bizLogic.resetData();
        return FORWARDNAME_SELECTTABLE;
    }

    public String baseSyoukaiBtnOnClick() {
        bizLogic.clearSearchCondition();
        bizLogic.relationCheck();
        bizLogic.createMaskingDataMap();
        bizLogic.searchData();
        bizLogic.setTimeStamp();
        return FORWARDNAME_SEARCH;
    }

    public String kakuteiBtnOnClick() {
        bizLogic.chkTimeStamp();
        bizLogic.getDetailData();
        return FORWARDNAME_RESULTDETAIL;
    }
}
