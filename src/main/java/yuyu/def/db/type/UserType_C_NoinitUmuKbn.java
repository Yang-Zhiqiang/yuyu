package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NoinitUmuKbn;

/**
 * {@link C_NoinitUmuKbn 初期値無し有無区分} の Hibernate ユーザー定義型です。<br />
 * 初期値無し有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NoinitUmuKbn extends AbstractUserType<C_NoinitUmuKbn> {

    @Override
    protected Class<C_NoinitUmuKbn> returnType() {
        return C_NoinitUmuKbn.class;
    }

    @Override
    protected C_NoinitUmuKbn valueOf(String pValue) {
        return C_NoinitUmuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NoinitUmuKbn pValue) {
        return pValue.getValue();
    }
}
