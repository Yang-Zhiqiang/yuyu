package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KktjyoutaiKbn;

/**
 * {@link C_KktjyoutaiKbn 確定状態区分} の Hibernate ユーザー定義型です。<br />
 * 確定状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KktjyoutaiKbn extends AbstractUserType<C_KktjyoutaiKbn> {

    @Override
    protected Class<C_KktjyoutaiKbn> returnType() {
        return C_KktjyoutaiKbn.class;
    }

    @Override
    protected C_KktjyoutaiKbn valueOf(String pValue) {
        return C_KktjyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KktjyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
