package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn;

/**
 * {@link C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn 月払一括入金額計算エラー理由区分} の Hibernate ユーザー定義型です。<br />
 * 月払一括入金額計算エラー理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn extends AbstractUserType<C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn> {

    @Override
    protected Class<C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn> returnType() {
        return C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.class;
    }

    @Override
    protected C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn valueOf(String pValue) {
        return C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
