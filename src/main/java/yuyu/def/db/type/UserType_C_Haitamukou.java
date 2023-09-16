package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Haitamukou;

/**
 * {@link C_Haitamukou 排他無効フラグ} の Hibernate ユーザー定義型です。<br />
 * 排他無効フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Haitamukou extends AbstractUserType<C_Haitamukou> {

    @Override
    protected Class<C_Haitamukou> returnType() {
        return C_Haitamukou.class;
    }

    @Override
    protected C_Haitamukou valueOf(String pValue) {
        return C_Haitamukou.valueOf(pValue);
    }

    @Override
    protected String toString(C_Haitamukou pValue) {
        return pValue.getValue();
    }
}
