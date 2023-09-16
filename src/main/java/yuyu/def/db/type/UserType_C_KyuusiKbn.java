package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyuusiKbn;

/**
 * {@link C_KyuusiKbn 休止日区分} の Hibernate ユーザー定義型です。<br />
 * 休止日区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyuusiKbn extends AbstractUserType<C_KyuusiKbn> {

    @Override
    protected Class<C_KyuusiKbn> returnType() {
        return C_KyuusiKbn.class;
    }

    @Override
    protected C_KyuusiKbn valueOf(String pValue) {
        return C_KyuusiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyuusiKbn pValue) {
        return pValue.getValue();
    }
}
