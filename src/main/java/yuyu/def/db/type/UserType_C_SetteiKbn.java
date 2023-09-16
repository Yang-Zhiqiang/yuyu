package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SetteiKbn;

/**
 * {@link C_SetteiKbn 設定区分} の Hibernate ユーザー定義型です。<br />
 * 設定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SetteiKbn extends AbstractUserType<C_SetteiKbn> {

    @Override
    protected Class<C_SetteiKbn> returnType() {
        return C_SetteiKbn.class;
    }

    @Override
    protected C_SetteiKbn valueOf(String pValue) {
        return C_SetteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SetteiKbn pValue) {
        return pValue.getValue();
    }
}
