package yuyu.app.biz.bzkensaku.bzsrchsyoubyou;

import static yuyu.app.biz.bzkensaku.bzsrchsyoubyou.BzSrchSyoubyouConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Syoubyou;

/**
 * 傷病検索 のビジネスロジックです。
 */
public class BzSrchSyoubyouBizLogic {


    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzSrchSyoubyouUiBean uiBean;

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
        String srchSyoubyouCd = null;
        String srchSyoubyouNm = null;
        List<BM_Syoubyou> syoubyouLst = null;

        uiBean.setSearchResults(null);
        srchSyoubyouCd = uiBean.getSrchsyoubyoucd();
        srchSyoubyouNm = uiBean.getSrchsyoubyounm();

        syoubyouLst = bizDomManager.getSyoubyousBySyoubyoucdSyoubyounm(srchSyoubyouCd, srchSyoubyouNm);


        if(syoubyouLst.size() == 0) {
            messageManager.addMessageId(MessageId.IHA0044,DISP_SYOUBYOU);
            return;

        }
        searchResultList(syoubyouLst);
    }


    private void searchResultList(List<BM_Syoubyou> pSyoubyouLst) {

        List<SearchResultsDataSourceBean> SearchResultsDataSourceLst = new ArrayList<>();


        for(BM_Syoubyou syoubyou : pSyoubyouLst) {

            SearchResultsDataSourceBean searchResultsDSBean = new SearchResultsDataSourceBean();

            searchResultsDSBean.setDispsyoubyoucd(syoubyou.getSyoubyoucd());
            searchResultsDSBean.setDispsyoubyounm(syoubyou.getSyoubyounm());
            SearchResultsDataSourceLst.add(searchResultsDSBean);
        }

        uiBean.setSearchResults(SearchResultsDataSourceLst);
    }
}
