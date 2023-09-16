package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TumahtnpKbn;

/**
 * {@link C_TumahtnpKbn 妻不担保区分} の Hibernate ユーザー定義型です。<br />
 * 妻不担保区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TumahtnpKbn extends AbstractUserType<C_TumahtnpKbn> {

    @Override
    protected Class<C_TumahtnpKbn> returnType() {
        return C_TumahtnpKbn.class;
    }

    @Override
    protected C_TumahtnpKbn valueOf(String pValue) {
        return C_TumahtnpKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TumahtnpKbn pValue) {
        return pValue.getValue();
    }
}
