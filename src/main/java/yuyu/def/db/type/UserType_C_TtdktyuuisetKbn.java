package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TtdktyuuisetKbn;

/**
 * {@link C_TtdktyuuisetKbn 手続注意設定区分} の Hibernate ユーザー定義型です。<br />
 * 手続注意設定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TtdktyuuisetKbn extends AbstractUserType<C_TtdktyuuisetKbn> {

    @Override
    protected Class<C_TtdktyuuisetKbn> returnType() {
        return C_TtdktyuuisetKbn.class;
    }

    @Override
    protected C_TtdktyuuisetKbn valueOf(String pValue) {
        return C_TtdktyuuisetKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TtdktyuuisetKbn pValue) {
        return pValue.getValue();
    }
}
