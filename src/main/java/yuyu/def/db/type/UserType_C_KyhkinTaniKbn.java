package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyhkinTaniKbn;

/**
 * {@link C_KyhkinTaniKbn 給付金単位区分} の Hibernate ユーザー定義型です。<br />
 * 給付金単位区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyhkinTaniKbn extends AbstractUserType<C_KyhkinTaniKbn> {

    @Override
    protected Class<C_KyhkinTaniKbn> returnType() {
        return C_KyhkinTaniKbn.class;
    }

    @Override
    protected C_KyhkinTaniKbn valueOf(String pValue) {
        return C_KyhkinTaniKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyhkinTaniKbn pValue) {
        return pValue.getValue();
    }
}
