package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NewOldKbn;

/**
 * {@link C_NewOldKbn 新旧区分} の Hibernate ユーザー定義型です。<br />
 * 新旧区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NewOldKbn extends AbstractUserType<C_NewOldKbn> {

    @Override
    protected Class<C_NewOldKbn> returnType() {
        return C_NewOldKbn.class;
    }

    @Override
    protected C_NewOldKbn valueOf(String pValue) {
        return C_NewOldKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NewOldKbn pValue) {
        return pValue.getValue();
    }
}
