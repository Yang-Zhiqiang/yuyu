package yuyu.common.workflow.collection;

import yuyu.common.workflow.workflowutility.CountOfTaskSummaryByTaskBean;

import com.google.common.base.Function;

/**
 * 処理残件数取得(事務手続・タスク指定) ソート用クラスです。
 * ユーザIDの昇順に合わせてソートを実施します。（共用タスクは先頭）
 */
public class WorkflowCountOfTaskSummaryBeanSortFunction implements Function<CountOfTaskSummaryByTaskBean, String> {

    @Override
    public String apply(CountOfTaskSummaryByTaskBean bean) {

        return bean.getUserId();
    }
}

