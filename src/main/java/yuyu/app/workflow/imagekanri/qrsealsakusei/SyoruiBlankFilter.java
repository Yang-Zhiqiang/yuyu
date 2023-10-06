package yuyu.app.workflow.imagekanri.qrsealsakusei;

import com.google.common.base.Predicate;

/**
 * QRシール用紙作成で使用する抽出処理です。<br/>
 * 条件に合致する入力項目3リストを抽出するためのPredicate クラスです。
 * 証券番号、取込書類コードが未入力の場合は除外します。
 */
public class SyoruiBlankFilter implements Predicate<InputContentsInfo3DataSourceBean> {

    public SyoruiBlankFilter() {

    }

    @Override
    public boolean apply(InputContentsInfo3DataSourceBean input) {
        if (input.getMosno().isEmpty() && input.getTorikomiSyoruiCd() == null) {
            return false;
        }
        return true;
    }

}
