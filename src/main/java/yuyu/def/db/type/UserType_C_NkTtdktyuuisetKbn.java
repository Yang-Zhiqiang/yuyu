package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NkTtdktyuuisetKbn;

/**
 * {@link C_NkTtdktyuuisetKbn 年金手続注意設定区分} の Hibernate ユーザー定義型です。<br />
 * 年金手続注意設定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NkTtdktyuuisetKbn extends AbstractUserType<C_NkTtdktyuuisetKbn> {

    @Override
    protected Class<C_NkTtdktyuuisetKbn> returnType() {
        return C_NkTtdktyuuisetKbn.class;
    }

    @Override
    protected C_NkTtdktyuuisetKbn valueOf(String pValue) {
        return C_NkTtdktyuuisetKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NkTtdktyuuisetKbn pValue) {
        return pValue.getValue();
    }
}
