package yuyu.app.biz.bzkensaku.bzsrchsyokugyou;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Syokugyou;

import com.google.common.collect.Lists;

/**
 * 職業検索 のビジネスロジックです。
 */
public class BzSrchSyokugyouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzSrchSyokugyouUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BizDomManager bizDomManager;

    void init() {
    }

    void clear() {
    }

    void doSearchBL() {

        BizPropertyInitializer.initialize(uiBean);

        String syokugyouCd = null;
        String syokugyouNm = null;
        List<BM_Syokugyou> resultSyokugyouList = null;

        uiBean.setSearchResults(null);
        syokugyouCd = uiBean.getSrchsyokugyoucd();
        syokugyouNm = uiBean.getSrchsyokugyounm();

        resultSyokugyouList = bizDomManager.getSyokugyousBySyokugyoucdSyokugyounm(syokugyouCd, syokugyouNm);

        if (resultSyokugyouList.size() == 0) {
            messageManager.addMessageId(MessageId.IHA0043);
            return;
        }

        searchResultList(resultSyokugyouList);

    }


    private void searchResultList(List<BM_Syokugyou> pResultSyokugyouList) {
        List<SearchResultsDataSourceBean> SearchResultsDataSourceList = Lists.newArrayList();

        for (BM_Syokugyou syokugyou : pResultSyokugyouList) {

            SearchResultsDataSourceBean searchResultsDSBean = new SearchResultsDataSourceBean();

            searchResultsDSBean.setDispsyokugyoucd(syokugyou.getSyokugyoucd());
            searchResultsDSBean.setDispsyokugyounm(syokugyou.getSyokugyounm());
            SearchResultsDataSourceList.add(searchResultsDSBean);
        }

        uiBean.setSearchResults(SearchResultsDataSourceList);
    }
}
