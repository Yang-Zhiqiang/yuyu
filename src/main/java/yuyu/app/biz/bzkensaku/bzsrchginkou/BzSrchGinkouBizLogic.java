package yuyu.app.biz.bzkensaku.bzsrchginkou;

import static yuyu.app.biz.bzkensaku.bzsrchginkou.BzSrchGinkouConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Ginkou;

/**
 * 銀行検索 のビジネスロジックです。
 */
public class BzSrchGinkouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzSrchGinkouUiBean uiBean;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    void init() {

        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
    }

    void doSearchBL() {

        uiBean.setSearchResults(null);
        String srchBankCd = uiBean.getSrchbankcd();
        String srchBankNmKn = uiBean.getSrchbanknmkn();


        if (BizUtil.isBlank(srchBankCd) && BizUtil.isBlank(srchBankNmKn)) {

            messageManager.addMessageId(MessageId.EMC1005);
            return;
        }

        Long ginkouCnt = bizDomManager.getGinkousCountByBankcdBanknmkn(srchBankCd, srchBankNmKn);

        if (ginkouCnt == 0) {

            messageManager.addMessageId(MessageId.IHA0045);
            return;
        }
        if (ginkouCnt > DATA_LIMIT_COUNT) {

            messageManager.addMessageId(MessageId.IBA0019, String.valueOf(DATA_LIMIT_COUNT));
            return;
        }

        List<BM_Ginkou> ginkouList = bizDomManager.getGinkousByBankcdBanknmknOrderByBankcdAsc(srchBankCd, srchBankNmKn);

        setListData(ginkouList);
    }


    private void setListData(List<BM_Ginkou> pGinkouList) {

        if (uiBean.getSearchResultsDataSource() != null) {
            uiBean.getSearchResultsDataSource().getAllData().clear();
        }

        List<SearchResultsDataSourceBean> searchResultsDataSourceBeanList = new ArrayList<SearchResultsDataSourceBean>();
        for (BM_Ginkou ginkou : pGinkouList) {

            SearchResultsDataSourceBean searchResultsDSBean = new SearchResultsDataSourceBean();

            searchResultsDSBean.setDispbankcd(ginkou.getBankcd());
            searchResultsDSBean.setDispbanknmkn(ginkou.getBanknmkn());
            searchResultsDSBean.setDispbanknmkj(ginkou.getBanknmkj());

            searchResultsDataSourceBeanList.add(searchResultsDSBean);
        }

        uiBean.setSearchResults(searchResultsDataSourceBeanList);
    }
}
