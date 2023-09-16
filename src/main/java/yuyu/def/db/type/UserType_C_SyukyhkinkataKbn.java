package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyukyhkinkataKbn;

/**
 * {@link C_SyukyhkinkataKbn 手術給付金型区分} の Hibernate ユーザー定義型です。<br />
 * 手術給付金型区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyukyhkinkataKbn extends AbstractUserType<C_SyukyhkinkataKbn> {

    @Override
    protected Class<C_SyukyhkinkataKbn> returnType() {
        return C_SyukyhkinkataKbn.class;
    }

    @Override
    protected C_SyukyhkinkataKbn valueOf(String pValue) {
        return C_SyukyhkinkataKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyukyhkinkataKbn pValue) {
        return pValue.getValue();
    }
}
