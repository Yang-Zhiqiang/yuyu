package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GeninKbn;

/**
 * {@link C_GeninKbn 原因区分} の Hibernate ユーザー定義型です。<br />
 * 原因区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GeninKbn extends AbstractUserType<C_GeninKbn> {

    @Override
    protected Class<C_GeninKbn> returnType() {
        return C_GeninKbn.class;
    }

    @Override
    protected C_GeninKbn valueOf(String pValue) {
        return C_GeninKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GeninKbn pValue) {
        return pValue.getValue();
    }
}
