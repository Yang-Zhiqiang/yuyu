package yuyu.app.workflow.imagekanri.qrsealsakusei;

import com.google.common.base.Predicate;

/**
 * QRシール用紙作成で使用する抽出処理です。<br/>
 * 条件に合致する入力項目2リストを抽出するためのPredicate クラスです。
 * 証券番号が未入力の場合は除外します。
 */
public class SyonoBlankFilter implements Predicate<InputContentsInfo2DataSourceBean> {

    public SyonoBlankFilter() {

    }

    @Override
    public boolean apply(InputContentsInfo2DataSourceBean input) {
        if (input.getMosno1().isEmpty() && input.getMosno2().isEmpty() && input.getMosno3().isEmpty()) {
            return false;
        }
        return true;
    }
}
