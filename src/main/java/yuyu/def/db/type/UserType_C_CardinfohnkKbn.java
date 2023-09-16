package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CardinfohnkKbn;

/**
 * {@link C_CardinfohnkKbn カード情報変更区分} の Hibernate ユーザー定義型です。<br />
 * カード情報変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CardinfohnkKbn extends AbstractUserType<C_CardinfohnkKbn> {

    @Override
    protected Class<C_CardinfohnkKbn> returnType() {
        return C_CardinfohnkKbn.class;
    }

    @Override
    protected C_CardinfohnkKbn valueOf(String pValue) {
        return C_CardinfohnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CardinfohnkKbn pValue) {
        return pValue.getValue();
    }
}
