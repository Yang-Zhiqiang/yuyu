package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KamokuKbn;

/**
 * {@link C_KamokuKbn 科目区分} の Hibernate ユーザー定義型です。<br />
 * 科目区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KamokuKbn extends AbstractUserType<C_KamokuKbn> {

    @Override
    protected Class<C_KamokuKbn> returnType() {
        return C_KamokuKbn.class;
    }

    @Override
    protected C_KamokuKbn valueOf(String pValue) {
        return C_KamokuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KamokuKbn pValue) {
        return pValue.getValue();
    }
}
