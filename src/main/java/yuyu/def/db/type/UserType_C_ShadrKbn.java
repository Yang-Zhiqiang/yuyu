package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShadrKbn;

/**
 * {@link C_ShadrKbn 送付先住所区分} の Hibernate ユーザー定義型です。<br />
 * 送付先住所区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShadrKbn extends AbstractUserType<C_ShadrKbn> {

    @Override
    protected Class<C_ShadrKbn> returnType() {
        return C_ShadrKbn.class;
    }

    @Override
    protected C_ShadrKbn valueOf(String pValue) {
        return C_ShadrKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShadrKbn pValue) {
        return pValue.getValue();
    }
}
