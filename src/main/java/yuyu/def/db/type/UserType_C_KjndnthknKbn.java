package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KjndnthknKbn;

/**
 * {@link C_KjndnthknKbn 個人保険団体保険区分} の Hibernate ユーザー定義型です。<br />
 * 個人保険団体保険区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KjndnthknKbn extends AbstractUserType<C_KjndnthknKbn> {

    @Override
    protected Class<C_KjndnthknKbn> returnType() {
        return C_KjndnthknKbn.class;
    }

    @Override
    protected C_KjndnthknKbn valueOf(String pValue) {
        return C_KjndnthknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KjndnthknKbn pValue) {
        return pValue.getValue();
    }
}
