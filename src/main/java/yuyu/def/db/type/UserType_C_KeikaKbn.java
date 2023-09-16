package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KeikaKbn;

/**
 * {@link C_KeikaKbn 経過区分} の Hibernate ユーザー定義型です。<br />
 * 経過区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KeikaKbn extends AbstractUserType<C_KeikaKbn> {

    @Override
    protected Class<C_KeikaKbn> returnType() {
        return C_KeikaKbn.class;
    }

    @Override
    protected C_KeikaKbn valueOf(String pValue) {
        return C_KeikaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KeikaKbn pValue) {
        return pValue.getValue();
    }
}
