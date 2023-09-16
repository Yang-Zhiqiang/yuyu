package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TakuouKbn;

/**
 * {@link C_TakuouKbn 宅診往診区分} の Hibernate ユーザー定義型です。<br />
 * 宅診往診区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TakuouKbn extends AbstractUserType<C_TakuouKbn> {

    @Override
    protected Class<C_TakuouKbn> returnType() {
        return C_TakuouKbn.class;
    }

    @Override
    protected C_TakuouKbn valueOf(String pValue) {
        return C_TakuouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TakuouKbn pValue) {
        return pValue.getValue();
    }
}
