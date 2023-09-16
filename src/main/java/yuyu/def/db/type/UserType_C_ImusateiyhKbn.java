package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ImusateiyhKbn;

/**
 * {@link C_ImusateiyhKbn 医務査定要否区分} の Hibernate ユーザー定義型です。<br />
 * 医務査定要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ImusateiyhKbn extends AbstractUserType<C_ImusateiyhKbn> {

    @Override
    protected Class<C_ImusateiyhKbn> returnType() {
        return C_ImusateiyhKbn.class;
    }

    @Override
    protected C_ImusateiyhKbn valueOf(String pValue) {
        return C_ImusateiyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ImusateiyhKbn pValue) {
        return pValue.getValue();
    }
}
