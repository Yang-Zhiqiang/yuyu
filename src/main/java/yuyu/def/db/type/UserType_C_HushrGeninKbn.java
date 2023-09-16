package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HushrGeninKbn;

/**
 * {@link C_HushrGeninKbn 不支払原因区分} の Hibernate ユーザー定義型です。<br />
 * 不支払原因区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HushrGeninKbn extends AbstractUserType<C_HushrGeninKbn> {

    @Override
    protected Class<C_HushrGeninKbn> returnType() {
        return C_HushrGeninKbn.class;
    }

    @Override
    protected C_HushrGeninKbn valueOf(String pValue) {
        return C_HushrGeninKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HushrGeninKbn pValue) {
        return pValue.getValue();
    }
}
