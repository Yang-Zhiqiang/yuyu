package yuyu.common.biz.koutei;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizUtil;

import com.google.common.collect.Lists;

/**
 * 業務共通 工程 進捗履歴情報設定
 */
public class SetProgressHistory {

    public void exec(SetProgressHistoryExecUiBeanParam pUiBean){

        List<GetProgressHistoryOutBean> getProgressHistoryOutBeanLst;

        GetProgressHistory getProgressHistory = SWAKInjector.getInstance(GetProgressHistory.class);

        if (BizUtil.isBlank(pUiBean.getBzWorkflowInfo().getOyaKouteiKanriId())) {
            getProgressHistoryOutBeanLst = getProgressHistory.exec(pUiBean.getBzWorkflowInfo().getKouteiKanriId());
        }
        else {
            getProgressHistoryOutBeanLst = getProgressHistory.exec(pUiBean.getBzWorkflowInfo().getOyaKouteiKanriId());
        }


        List<ProgressHistoryDataSourceBeanCommonParam> progressHistoryDataSourceBeanLst = Lists.newArrayList();

        for (GetProgressHistoryOutBean getProgressHistoryOutBean : getProgressHistoryOutBeanLst){
            ProgressHistoryDataSourceBeanCommonParam progressHistoryDataSourceBean =
                pUiBean.createProgressHistoryDataSourceBean();

            progressHistoryDataSourceBean.setVprghsdispsyoriymd(
                BizDate.valueOf(getProgressHistoryOutBean.getSyoriTime().substring(0, 8)));
            progressHistoryDataSourceBean.setVprghsdisptasknm(getProgressHistoryOutBean.getTaskName());
            progressHistoryDataSourceBean.setVprghsdispsyorikekkakbn(getProgressHistoryOutBean.getSyorikekkaKbn());
            progressHistoryDataSourceBean.setVprghsdispsousasyanm(getProgressHistoryOutBean.getTantousyaName());
            progressHistoryDataSourceBean.setVprghsdispcomment(getProgressHistoryOutBean.getComment());

            progressHistoryDataSourceBeanLst.add(progressHistoryDataSourceBean);
        }

        pUiBean.convertProgressHistoryForCommonParam(progressHistoryDataSourceBeanLst);
    }
}
