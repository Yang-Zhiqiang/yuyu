package yuyu.app.biz.bzkensaku.bzsrchsimekiribi;

import static yuyu.app.biz.bzkensaku.bzsrchsimekiribi.BzSrchSimekiribiConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Simekiribi;

/**
 * 締切日検索 のビジネスロジックです。
 */
public class BzSrchSimekiribiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzSrchSimekiribiUiBean uiBean;

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

        BizDateYM srchBosyuuYm = null;
        List<BM_Simekiribi> simekiribiLst = null;

        uiBean.setSearchResults(null);

        srchBosyuuYm = uiBean.getSrchbosyuuym();

        if (srchBosyuuYm != null) {
            String bosyuuYm = srchBosyuuYm.toString();
            simekiribiLst = new ArrayList<>();

            BM_Simekiribi simekiribi = bizDomManager.getSimekiribi(BizDateYM.valueOf(bosyuuYm));
            if (simekiribi != null) {
                simekiribiLst.add(simekiribi);
            }
        }
        else {
            simekiribiLst = bizDomManager.getAllSimekiribi();
        }

        if(simekiribiLst.size() == 0) {
            messageManager.addMessageId(MessageId.IHA0044,DISP_SIMEKIRIBI);
            return;
        }
        searchResultList(simekiribiLst);
    }


    private void searchResultList(List<BM_Simekiribi> pSimekiribiLst) {

        List<SearchResultsDataSourceBean> searchResultsDataSourceBeanLst = new ArrayList<>();


        for(BM_Simekiribi simekiribi : pSimekiribiLst) {

            SearchResultsDataSourceBean searchResultsDSBean = new SearchResultsDataSourceBean();

            searchResultsDSBean.setDispbosyuuym(simekiribi.getBosyuuym());
            searchResultsDSBean.setDispmossimefromymd(simekiribi.getMossimefromymd());
            searchResultsDSBean.setDispmossimetoymd(simekiribi.getMossimetoymd());
            searchResultsDSBean.setDispmosnrksimefromymd(simekiribi.getMosnrksimefromymd());
            searchResultsDSBean.setDispmosnrksimetoymd(simekiribi.getMosnrksimetoymd());
            searchResultsDSBean.setDispnrksimefromymd(simekiribi.getNyknsimefromymd());
            searchResultsDSBean.setDispnrksimetoymd(simekiribi.getNyknsimetoymd());
            searchResultsDSBean.setDispsyrisimefromymd(simekiribi.getSyorisimefromymd());
            searchResultsDSBean.setDispsyrisimetoymd(simekiribi.getSyorisimetoymd());
            searchResultsDataSourceBeanLst.add(searchResultsDSBean);
        }
        uiBean.setSearchResults(searchResultsDataSourceBeanLst);
    }
}