package yuyu.app.biz.bzkensaku.bzsrchyno;
import static yuyu.app.biz.bzkensaku.bzsrchyno.BzSrchYnoConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.result.bean.AddressDistinctPostAdrkjAdrknbkarisByItemsBean;
import yuyu.def.classification.C_KihontikucdSyoumetuKbn;
import yuyu.def.classification.C_TodouhukenKbn;

/**
 * 郵便番号検索 のビジネスロジックです。
 */
public class BzSrchYnoBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzSrchYnoUiBean uiBean;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    void init() {
        clear();
    }

    void clear() {
        BizPropertyInitializer.initialize(uiBean);
    }

    void searchAddress() {

        if (!BizUtil.isBlank(uiBean.getSrchyno()) && uiBean.getSrchyno().length() < YNO_MIN_COUNT) {
            throw new BizLogicException(MessageId.EBF0109);
        }

        if (BizUtil.isBlank(uiBean.getSrchyno()) &&
            C_TodouhukenKbn.BLNK.eq(uiBean.getTodouhukenKbn())) {
            throw new BizLogicException(MessageId.EBF1016);
        }

        if (!C_TodouhukenKbn.BLNK.eq(uiBean.getTodouhukenKbn()) &&
            (BizUtil.isBlank(uiBean.getSrchyno()) &&
                BizUtil.isBlank(uiBean.getSrchknadr()) &&
                BizUtil.isBlank(uiBean.getSrchkjadr()))) {
            throw new BizLogicException(MessageId.EBF1016);
        }

        uiBean.setSearchResult(null);

        C_TodouhukenKbn todouhukenKbn = null;
        if(!C_TodouhukenKbn.BLNK.eq(uiBean.getTodouhukenKbn())){
            todouhukenKbn = uiBean.getTodouhukenKbn();
        }

        List<AddressDistinctPostAdrkjAdrknbkarisByItemsBean> resutltBeanLst =
            bizDomManager.getAddressDistinctPostAdrkjAdrknbkarisByItems(uiBean.getSrchyno(),
                C_KihontikucdSyoumetuKbn.YUUKOUTYUU,
                todouhukenKbn,
                uiBean.getSrchknadr(),
                uiBean.getSrchkjadr());

        if (resutltBeanLst.size() == 0) {
            messageManager.addMessageId(MessageId.IAC0023);
            return;
        }
        else if (resutltBeanLst.size() > DATA_LIMIT_COUNT) {
            messageManager.addMessageId(MessageId.IBF0024);
            return;
        }

        List<SearchResultDataSourceBean> searchResultBeanLst = new ArrayList<SearchResultDataSourceBean>();

        for (AddressDistinctPostAdrkjAdrknbkarisByItemsBean resultBean : resutltBeanLst) {
            SearchResultDataSourceBean searchResult = new SearchResultDataSourceBean();
            searchResult.setDispyno(resultBean.getPostalCd());
            searchResult.setDispkjadr(resultBean.getAdrkj());
            searchResult.setDispknadr(resultBean.getAdrknblankari());

            searchResult.setDisptodouhukennmkj(resultBean.getAdrkj()
                .substring(0, resultBean.getKjtodouhukennmketasuu()));
            searchResult.setTodoufukenSikutyousonNm(resultBean.getAdrkj().substring(0,
                resultBean.getKjsikugunnmketasuu()));
            searchResult.setDispsikutyousonnmkj(resultBean.getAdrkj().substring(resultBean.getKjtodouhukennmketasuu(),
                resultBean.getKjsikugunnmketasuu()));
            searchResult.setDisptyouikinmkj(resultBean.getAdrkj().substring(resultBean.getKjsikugunnmketasuu()));
            searchResult.setTodoufukenSikutyousonNmKn("");

            searchResultBeanLst.add(searchResult);
        }

        uiBean.setSearchResult(searchResultBeanLst);
    }
}
