package yuyu.app.biz.bzkensaku.bzsrchginkousiten;

import static yuyu.app.biz.bzkensaku.bzsrchginkousiten.BzSrchGinkouSitenConstants.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.IGkCommonKoumoku;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Ginkou;

import com.google.common.collect.Lists;

/**
 * 銀行支店検索 のビジネスロジックです。
 */
public class BzSrchGinkouSitenBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzSrchGinkouSitenUiBean uiBean;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    void init() {

        BizPropertyInitializer.initialize(uiBean);

        messageManager.addConversationMessageId(MessageId.IBF1007);
    }

    void clear() {
    }

    void doSearchBL() {

        String srchBankCd    = null;
        String srchBankNmKn  = null;
        String srchSitenCd   = null;
        String srchSitenNmKn = null;
        String srchBankNmKj  = null;
        String srchSitenNmKj = null;
        List<BM_Ginkou> ginkouList = null;
        long ginkouCnt = 0;
        String[] tysyttaiSyougaiBankcdhrt = {IGkCommonKoumoku.BANKCD_YTGINKOU};

        uiBean.setSearchResults(null);
        srchBankCd = uiBean.getSrchbankcd();
        srchBankNmKn = uiBean.getSrchbanknmkn();
        srchSitenCd = uiBean.getSrchsitencd();
        srchSitenNmKn = uiBean.getSrchsitennmkn();
        srchBankNmKj = uiBean.getSrchbanknmkj();
        srchSitenNmKj = uiBean.getSrchsitennmkj();

        ginkouCnt = bizDomManager.getGinkouCountByBankcdSitencdBanknmSitennm(
            srchBankCd, srchSitenCd, srchBankNmKn, srchSitenNmKn, srchBankNmKj, srchSitenNmKj,tysyttaiSyougaiBankcdhrt);

        if (ginkouCnt == 0) {
            messageManager.addMessageId(MessageId.IHA0045);
            return;
        }
        if (ginkouCnt > DATA_LIMIT_COUNT) {
            messageManager.addMessageId(MessageId.IBF0024);
            return;
        }
        ginkouList = bizDomManager.getGinkousByBankcdSitencdBanknmSitennm(
            srchBankCd, srchSitenCd, srchBankNmKn, srchSitenNmKn, srchBankNmKj, srchSitenNmKj,tysyttaiSyougaiBankcdhrt);

        setListData(ginkouList);
    }


    private void setListData(List<BM_Ginkou> pGinkouList) {

        String ginkouBankCd = null;
        String ginkouBankNmKj = null;
        String ginkouSitenCd = null;
        String ginkouSitenNmKj = null;

        if (uiBean.getSearchResultsDataSource() != null) {
            uiBean.getSearchResultsDataSource().getAllData().clear();
        }

        List<SearchResultsDataSourceBean> searchResultsDataSourceBeanList = Lists.newArrayList();
        for (BM_Ginkou ginkou : pGinkouList) {

            ginkouBankCd = ginkou.getBankcd();
            ginkouBankNmKj = ginkou.getBanknmkj();
            ginkouSitenCd = ginkou.getSitencd();
            ginkouSitenNmKj = ginkou.getSitennmkj();

            SearchResultsDataSourceBean searchResultsDSBean = new SearchResultsDataSourceBean();

            searchResultsDSBean.setDispbankcd(ginkouBankCd);
            searchResultsDSBean.setDispbanknmkj(ginkouBankNmKj);
            searchResultsDSBean.setDispsitencd(ginkouSitenCd);
            searchResultsDSBean.setDispsitennmkj(ginkouSitenNmKj);

            searchResultsDataSourceBeanList.add(searchResultsDSBean);
        }

        uiBean.setSearchResults(searchResultsDataSourceBeanList);
    }
}
