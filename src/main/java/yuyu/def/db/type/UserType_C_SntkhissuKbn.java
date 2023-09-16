package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SntkhissuKbn;

/**
 * {@link C_SntkhissuKbn 選択必須区分} の Hibernate ユーザー定義型です。<br />
 * 選択必須区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SntkhissuKbn extends AbstractUserType<C_SntkhissuKbn> {

    @Override
    protected Class<C_SntkhissuKbn> returnType() {
        return C_SntkhissuKbn.class;
    }

    @Override
    protected C_SntkhissuKbn valueOf(String pValue) {
        return C_SntkhissuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SntkhissuKbn pValue) {
        return pValue.getValue();
    }
}
