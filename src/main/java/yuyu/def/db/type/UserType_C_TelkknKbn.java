package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TelkknKbn;

/**
 * {@link C_TelkknKbn 電話確認実施区分} の Hibernate ユーザー定義型です。<br />
 * 電話確認実施区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TelkknKbn extends AbstractUserType<C_TelkknKbn> {

    @Override
    protected Class<C_TelkknKbn> returnType() {
        return C_TelkknKbn.class;
    }

    @Override
    protected C_TelkknKbn valueOf(String pValue) {
        return C_TelkknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TelkknKbn pValue) {
        return pValue.getValue();
    }
}
