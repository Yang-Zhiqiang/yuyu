package yuyu.app.biz.bzkensaku.bzsrchdairiten;

import static yuyu.app.biz.bzkensaku.bzsrchdairiten.BzSrchDairitenConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Dairiten;

/**
 * 代理店検索 のビジネスロジックです。
 */
public class BzSrchDairitenBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzSrchDairitenUiBean uiBean;

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

        List<BM_Dairiten> dairitenList  = null;
        long drtenCnt = 0;

        uiBean.setSearchResults(null);
        String drtencd = uiBean.getSrchdrtencd();
        String drtenNm = uiBean.getSrchdrtennm();
        String kanjidairitenNm1 = uiBean.getSrchkanjidairitennm1();
        String kanjidairitenNm2 = uiBean.getSrchkanjidairitennm2();

        if (BizUtil.isBlank(drtencd) &&
            BizUtil.isBlank(drtenNm) &&
            BizUtil.isBlank(kanjidairitenNm1) &&
            BizUtil.isBlank(kanjidairitenNm2)) {

            messageManager.addMessageId(MessageId.EMC1005);
            return;
        }

        drtenCnt = bizDomManager.getDairitenCountByDrtencdDrtennm(drtencd, drtenNm, kanjidairitenNm1, kanjidairitenNm2);

        if (drtenCnt == 0) {

            messageManager.addMessageId(MessageId.IHA0044, DISP_DAIRITEN);
            return;
        }
        if (drtenCnt > DATA_LIMIT_COUNT) {

            messageManager.addMessageId(MessageId.IBA0019, String.valueOf(DATA_LIMIT_COUNT));
            return;
        }
        dairitenList = bizDomManager.getDairitenByDrtencdDrtennmOrderByDrtencdAsc(drtencd, drtenNm, kanjidairitenNm1, kanjidairitenNm2);

        setListData(dairitenList);
    }


    private void setListData(List<BM_Dairiten> pDairitenList) {

        String drtencd = null;
        String drtenNm = null;
        String kanjidairitenNm = null;

        if (uiBean.getSearchResultsDataSource() != null) {
            uiBean.getSearchResultsDataSource().getAllData().clear();
        }

        List<SearchResultsDataSourceBean> searchResultsDataSourceBeanList = new ArrayList<>();

        for (BM_Dairiten dairiten : pDairitenList) {

            drtencd = dairiten.getDrtencd();
            drtenNm = dairiten.getDrtennm();
            kanjidairitenNm = dairiten.getKanjidairitennm();

            SearchResultsDataSourceBean searchResultsDSBean = new SearchResultsDataSourceBean();

            searchResultsDSBean.setDispdrtencd(drtencd);
            searchResultsDSBean.setDispdrtennmkn(drtenNm);
            searchResultsDSBean.setDispdrtennmkj(kanjidairitenNm);

            searchResultsDataSourceBeanList.add(searchResultsDSBean);
        }

        uiBean.setSearchResults(searchResultsDataSourceBeanList);
    }
}
