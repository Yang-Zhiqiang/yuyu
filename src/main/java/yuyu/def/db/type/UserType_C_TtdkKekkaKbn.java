package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TtdkKekkaKbn;

/**
 * {@link C_TtdkKekkaKbn 手続結果区分} の Hibernate ユーザー定義型です。<br />
 * 手続結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TtdkKekkaKbn extends AbstractUserType<C_TtdkKekkaKbn> {

    @Override
    protected Class<C_TtdkKekkaKbn> returnType() {
        return C_TtdkKekkaKbn.class;
    }

    @Override
    protected C_TtdkKekkaKbn valueOf(String pValue) {
        return C_TtdkKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TtdkKekkaKbn pValue) {
        return pValue.getValue();
    }
}
