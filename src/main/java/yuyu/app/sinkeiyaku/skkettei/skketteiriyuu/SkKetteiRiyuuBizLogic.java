package yuyu.app.sinkeiyaku.skkettei.skketteiriyuu;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.classification.Classification;
import jp.co.slcs.swak.core.classification.DisplayItem;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.classification.C_Ketriyuucd;

/**
 * 決定理由一覧 のビジネスロジックです。
 */
public class SkKetteiRiyuuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkKetteiRiyuuUiBean uiBean;

    void init() {

        clear();

        BizPropertyInitializer.initialize(uiBean);

        List<KetteiriyuuListDataSourceBean> ketteiriyuuListDataSourceBeanList = new ArrayList<>();

        DisplayItem<C_Ketriyuucd>[] ketteiriyuuLst = Classification.getDisplayItems(C_Ketriyuucd.class,
            C_Ketriyuucd.PATTERN_ITIRAN);

        for (int i = 0; i < ketteiriyuuLst.length; i++) {

            KetteiriyuuListDataSourceBean ketteiriyuuListDataSourceBean = SWAKInjector
                .getInstance(KetteiriyuuListDataSourceBean.class);

            ketteiriyuuListDataSourceBean.setDispketteiriyuucd(ketteiriyuuLst[i].getValue());

            ketteiriyuuListDataSourceBean.setDispketteiriyuunaiyou(ketteiriyuuLst[i].getContent());

            ketteiriyuuListDataSourceBeanList.add(ketteiriyuuListDataSourceBean);
        }

        uiBean.setKetteiriyuuList(ketteiriyuuListDataSourceBeanList);

    }

    void clear() {
    }
}
