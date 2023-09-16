package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KengenUmuKbn;

/**
 * {@link C_KengenUmuKbn 権限有無区分} の Hibernate ユーザー定義型です。<br />
 * 権限有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KengenUmuKbn extends AbstractUserType<C_KengenUmuKbn> {

    @Override
    protected Class<C_KengenUmuKbn> returnType() {
        return C_KengenUmuKbn.class;
    }

    @Override
    protected C_KengenUmuKbn valueOf(String pValue) {
        return C_KengenUmuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KengenUmuKbn pValue) {
        return pValue.getValue();
    }
}
