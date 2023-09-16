package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GaitouKbn;

/**
 * {@link C_GaitouKbn 該当区分} の Hibernate ユーザー定義型です。<br />
 * 該当区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GaitouKbn extends AbstractUserType<C_GaitouKbn> {

    @Override
    protected Class<C_GaitouKbn> returnType() {
        return C_GaitouKbn.class;
    }

    @Override
    protected C_GaitouKbn valueOf(String pValue) {
        return C_GaitouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GaitouKbn pValue) {
        return pValue.getValue();
    }
}
