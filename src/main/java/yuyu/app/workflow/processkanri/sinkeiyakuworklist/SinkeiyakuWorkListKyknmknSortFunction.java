package yuyu.app.workflow.processkanri.sinkeiyakuworklist;

import com.google.common.base.Function;

/**
 * 新契約工程ワークリスト 機能の契約者名（カナ）ソート用クラスです。
 * 新契約工程ワークリストで表示する事務手続コード・タスクIDの表示順に合わせてソートを実施します。
 */
public class SinkeiyakuWorkListKyknmknSortFunction implements Function<ResultInfoItiranDataSourceBean, String> {

    @Override
    public String apply(ResultInfoItiranDataSourceBean bean) {

        return bean.getKyknmkn();
    }
}

