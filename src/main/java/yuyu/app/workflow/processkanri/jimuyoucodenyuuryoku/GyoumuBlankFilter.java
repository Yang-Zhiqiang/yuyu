package yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku;

import com.google.common.base.Predicate;

/***
 * 条件に合致する事務用コードリストを抽出するためのPredicate クラスです。<br />
 * 業務キー、事務用コードが未入力の場合は除外します。<br />
 */
public class GyoumuBlankFilter implements Predicate<JimuyouCodeListDataSourceBean> {

    public GyoumuBlankFilter() {

    }

    @Override
    public boolean apply(JimuyouCodeListDataSourceBean input) {
        if (input.getMosno().isEmpty() &&input.getSyono().isEmpty() && input.getNksysyno().isEmpty() && input.getJimuyoucd().isEmpty()) {
            return false;
        }
        return true;
    }

}
