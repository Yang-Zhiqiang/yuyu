package yuyu.common.workflow.wfcommon;

import java.util.LinkedHashMap;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BzGetExecutableTasks;
import yuyu.common.biz.bzcommon.BzGetExecutableTasksBean;
import yuyu.common.biz.bzcommon.BzGetExecutableTasksOutBean;
import yuyu.common.workflow.collection.WfSubsystemFilter;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * ユーザーセレクト作成共通処理クラス<br />
 */
public class WfUserSelectCommon {

    private final String BLANK = "";


    @Inject
    private static Logger logger;


    public WfUserSelectCommon() {
        super();
    }

    public GetExecutableSubSystemsSelectOutBean getExecutableSubSystemsSelectList(
        GetExecutableSubSystemsSelectInBean inBean) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 権限ありサブシステムセレクト作成 開始");
        }
        GetExecutableSubSystemsSelectOutBean outBean =
            SWAKInjector.getInstance(GetExecutableSubSystemsSelectOutBean.class);

        UserDefsList retList = new UserDefsList();

        List<BzGetExecutableTasksBean> tempBeanList = Lists.newLinkedList();

        LinkedHashMap<String, String> retMap = Maps.newLinkedHashMap();


        BzGetExecutableTasks bzGetExecutableTasks = SWAKInjector.getInstance(BzGetExecutableTasks.class);
        BzGetExecutableTasksOutBean bzGetExecutableTasksOutBean = bzGetExecutableTasks.exec(inBean.getUserId());

        List<BzGetExecutableTasksBean> bzGetExecutableTasksBeanList =
            bzGetExecutableTasksOutBean.getBzGetExecutableTasksBeanList();

        for (BzGetExecutableTasksBean tempBean : bzGetExecutableTasksBeanList) {

            retMap.put(tempBean.getSubSystemId(), tempBean.getSubSystemNm());

            if (tempBeanList.size() == 0) {
                tempBeanList.add(tempBean);
                continue;
            }

            if (tempBean.getSubSystemId().equals(tempBeanList.get(tempBeanList.size() - 1).getSubSystemId())) {
                continue;
            }

            tempBeanList.add(tempBean);
        }


        if (inBean.getBlankUmu() == true) {

            retList.addAll(insertBlank(ImmutableList.<LabelValuePair> builder()
                .addAll(
                    Iterables.transform(
                        ImmutableList.copyOf(Iterables.filter(tempBeanList, new WfSubsystemFilter())),
                        new Function<BzGetExecutableTasksBean, LabelValuePair>() {
                            @Override
                            public LabelValuePair apply(BzGetExecutableTasksBean bean) {
                                return new LabelValuePair(bean.getSubSystemNm(), bean.getSubSystemId());

                            }
                        }
                        )
                    )
                    .build()));
        }
        else {

            retList.addAll(
                ImmutableList.<LabelValuePair> builder()
                .addAll(
                    Iterables.transform(
                        ImmutableList.copyOf(Iterables.filter(tempBeanList, new WfSubsystemFilter())),
                        new Function<BzGetExecutableTasksBean, LabelValuePair>() {
                            @Override
                            public LabelValuePair apply(BzGetExecutableTasksBean bean) {
                                return new LabelValuePair(bean.getSubSystemNm(), bean.getSubSystemId());

                            }
                        }
                        )
                    )
                    .build()
                );
        }


        outBean.setUserDefsList(retList);
        outBean.setSubSystemIdNameArray(retMap.keySet().toArray(new String[0]));


        if (logger.isDebugEnabled()) {
            logger.debug("△ 権限ありサブシステムセレクト作成 終了");
        }

        return outBean;
    }

    private UserDefsList insertBlank(Iterable<LabelValuePair> optionList) {
        UserDefsList list = new UserDefsList();
        list.addAll(
            ImmutableList.<LabelValuePair> builder()
            .add(
                new LabelValuePair(
                    BLANK,
                    BLANK
                    )
                )
                .addAll(optionList)
                .build()
            );
        return list;
    }
}
