package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyuuryokuKbn;

/**
 * {@link C_NyuuryokuKbn 入力区分} の Hibernate ユーザー定義型です。<br />
 * 入力区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyuuryokuKbn extends AbstractUserType<C_NyuuryokuKbn> {

    @Override
    protected Class<C_NyuuryokuKbn> returnType() {
        return C_NyuuryokuKbn.class;
    }

    @Override
    protected C_NyuuryokuKbn valueOf(String pValue) {
        return C_NyuuryokuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyuuryokuKbn pValue) {
        return pValue.getValue();
    }
}
