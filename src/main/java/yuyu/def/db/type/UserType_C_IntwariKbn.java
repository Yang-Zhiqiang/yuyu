package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IntwariKbn;

/**
 * {@link C_IntwariKbn インターネット割引区分} の Hibernate ユーザー定義型です。<br />
 * インターネット割引区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IntwariKbn extends AbstractUserType<C_IntwariKbn> {

    @Override
    protected Class<C_IntwariKbn> returnType() {
        return C_IntwariKbn.class;
    }

    @Override
    protected C_IntwariKbn valueOf(String pValue) {
        return C_IntwariKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IntwariKbn pValue) {
        return pValue.getValue();
    }
}
