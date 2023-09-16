package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ImusateikaniyhKbn;

/**
 * {@link C_ImusateikaniyhKbn 医務査定（簡易）要否区分} の Hibernate ユーザー定義型です。<br />
 * 医務査定（簡易）要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ImusateikaniyhKbn extends AbstractUserType<C_ImusateikaniyhKbn> {

    @Override
    protected Class<C_ImusateikaniyhKbn> returnType() {
        return C_ImusateikaniyhKbn.class;
    }

    @Override
    protected C_ImusateikaniyhKbn valueOf(String pValue) {
        return C_ImusateikaniyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ImusateikaniyhKbn pValue) {
        return pValue.getValue();
    }
}
