package yuyu.app.siharai.sikensaku.sisrchbyoumei;

import static yuyu.app.siharai.sikensaku.sisrchbyoumei.SiSrchByoumeiConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.message.MessageManager;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 病名検索 のビジネスロジックです。
 */
public class SiSrchByoumeiBizLogic {

    @Inject
    private SiSrchByoumeiUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    void init() {
        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
    }

    void doSearchBL() {

        String byoumeikj = null;
        String byoumeikn = null;
        String byoumeicd = null;
        List<JM_Byoumei> byoumeiLst = null;

        byoumeikj = uiBean.getByoumeikj();
        byoumeikn = uiBean.getByoumeikn();
        byoumeicd = uiBean.getByoumeicd();

        uiBean.setSearchResults(null);
        byoumeiLst = siharaiDomManager.getByoumeisByByoumeikjByoumeiknByoumeicd(byoumeikj, byoumeikn, byoumeicd);

        if (byoumeiLst.size() == 0) {
            messageManager.addMessageId(MessageId.EJA0013);
            return;
        }

        if (byoumeiLst.size()  > DATA_LIMIT_COUNT) {
            messageManager.addMessageId(MessageId.EBF0110);
            return;
        }

        searchResultList(byoumeiLst);
    }


    private void searchResultList(List<JM_Byoumei> pByoumeiLst) {

        uiBean.getSearchResultsDataSource().setDatas(null);

        List<SearchResultsDataSourceBean> searchResultsDataSourceLst = new ArrayList<>();
        for(JM_Byoumei byoumei : pByoumeiLst) {

            SearchResultsDataSourceBean searchResultsDSBean = new SearchResultsDataSourceBean();
            searchResultsDSBean.setByoumeitourokuno(byoumei.getByoumeitourokuno());
            searchResultsDSBean.setByoumeikj(byoumei.getByoumeikj());
            searchResultsDSBean.setByoumeikn(byoumei.getByoumeikn());
            searchResultsDSBean.setByoumeicd(byoumei.getByoumeicd());
            searchResultsDSBean.setGaitoukbn2(byoumei.getGaitoukbn2());

            searchResultsDataSourceLst.add(searchResultsDSBean);
        }

        uiBean.setSearchResults(searchResultsDataSourceLst);
    }
}
