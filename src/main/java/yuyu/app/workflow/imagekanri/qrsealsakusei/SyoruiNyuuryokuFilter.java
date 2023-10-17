package yuyu.app.workflow.imagekanri.qrsealsakusei;

import com.google.common.base.Predicate;

/**
 * QRシール用紙作成で使用する抽出処理です。<br/>
 * 条件に合致する入力項目3リストを抽出するためのPredicate クラスです。
 * 入力有り、取込書類コードが未入力の場合は除外します。
 */
public class SyoruiNyuuryokuFilter implements Predicate<InputContentsInfo4DataSourceBean> {


    public SyoruiNyuuryokuFilter() {

    }

    @Override
    public boolean apply(InputContentsInfo4DataSourceBean input) {
        if (input.getMosno() != null && input.getTorikomiSyoruiCd() == null) {
            return false;
        }
        return true;
    }

}
