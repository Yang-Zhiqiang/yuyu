package yuyu.app.biz.bzkensaku.bzsrchketteisya;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.db.entity.HM_KetteiSya;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

import com.google.common.collect.Lists;

/**
 * 決定者検索 のビジネスロジックです。
 */
public class BzSrchKetteisyaBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzSrchKetteisyaUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private MessageManager messageManager;

    void init() {
        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
    }

    void doSearchBL() {

        if (uiBean.getSearchResultsDataSource() != null) {
            uiBean.getSearchResultsDataSource().getAllData().clear();
        }
        String ketteisyaCd = null;
        String ketteisyaNm = null;
        List<HM_KetteiSya> resultKetteisyaList = null;
        long mKetteisyaCnt = 0;

        uiBean.setSearchResults(null);

        ketteisyaCd = uiBean.getSrchketsyacd();
        ketteisyaNm = uiBean.getSrchketsyanm();

        resultKetteisyaList = sinkeiyakuDomManager
            .getKetteiSyasByKetsyacdKetsyanm(ketteisyaCd, ketteisyaNm);

        mKetteisyaCnt = resultKetteisyaList.size();

        if (mKetteisyaCnt == 0) {
            messageManager.addMessageId(MessageId.IHA0042);
            return;
        }


        searchResultList(resultKetteisyaList);

    }



    private void searchResultList(List<HM_KetteiSya> pResultKetteisyaList) {

        String ketsyacd = null;
        String ketsyanm = null;

        List<SearchResultsDataSourceBean> SearchResultsDataSourceList = Lists.newArrayList();
        for (HM_KetteiSya ketteisya : pResultKetteisyaList) {

            ketsyacd = ketteisya.getKetsyacd();
            ketsyanm = ketteisya.getKetsyanm();

            SearchResultsDataSourceBean searchResultsDSBean = new SearchResultsDataSourceBean();

            searchResultsDSBean.setDispketsyacd(ketsyacd);
            searchResultsDSBean.setDispketsyanm(ketsyanm);

            SearchResultsDataSourceList.add(searchResultsDSBean);
        }

        uiBean.setSearchResults(SearchResultsDataSourceList);
    }

}
