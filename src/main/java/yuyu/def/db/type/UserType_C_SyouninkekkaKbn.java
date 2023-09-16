package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyouninkekkaKbn;

/**
 * {@link C_SyouninkekkaKbn 承認結果区分} の Hibernate ユーザー定義型です。<br />
 * 承認結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyouninkekkaKbn extends AbstractUserType<C_SyouninkekkaKbn> {

    @Override
    protected Class<C_SyouninkekkaKbn> returnType() {
        return C_SyouninkekkaKbn.class;
    }

    @Override
    protected C_SyouninkekkaKbn valueOf(String pValue) {
        return C_SyouninkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyouninkekkaKbn pValue) {
        return pValue.getValue();
    }
}
