package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;

/**
 * {@link C_NyuukinjyoutaiKbn 入金状態区分} の Hibernate ユーザー定義型です。<br />
 * 入金状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyuukinjyoutaiKbn extends AbstractUserType<C_NyuukinjyoutaiKbn> {

    @Override
    protected Class<C_NyuukinjyoutaiKbn> returnType() {
        return C_NyuukinjyoutaiKbn.class;
    }

    @Override
    protected C_NyuukinjyoutaiKbn valueOf(String pValue) {
        return C_NyuukinjyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyuukinjyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
