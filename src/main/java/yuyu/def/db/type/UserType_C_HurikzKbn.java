package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HurikzKbn;

/**
 * {@link C_HurikzKbn 振替口座区分} の Hibernate ユーザー定義型です。<br />
 * 振替口座区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HurikzKbn extends AbstractUserType<C_HurikzKbn> {

    @Override
    protected Class<C_HurikzKbn> returnType() {
        return C_HurikzKbn.class;
    }

    @Override
    protected C_HurikzKbn valueOf(String pValue) {
        return C_HurikzKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HurikzKbn pValue) {
        return pValue.getValue();
    }
}
