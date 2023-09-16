package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KengenKbn;

/**
 * {@link C_KengenKbn 権限区分} の Hibernate ユーザー定義型です。<br />
 * 権限区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KengenKbn extends AbstractUserType<C_KengenKbn> {

    @Override
    protected Class<C_KengenKbn> returnType() {
        return C_KengenKbn.class;
    }

    @Override
    protected C_KengenKbn valueOf(String pValue) {
        return C_KengenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KengenKbn pValue) {
        return pValue.getValue();
    }
}
