package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NensiteiKbn;

/**
 * {@link C_NensiteiKbn 年齢指定区分} の Hibernate ユーザー定義型です。<br />
 * 年齢指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NensiteiKbn extends AbstractUserType<C_NensiteiKbn> {

    @Override
    protected Class<C_NensiteiKbn> returnType() {
        return C_NensiteiKbn.class;
    }

    @Override
    protected C_NensiteiKbn valueOf(String pValue) {
        return C_NensiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NensiteiKbn pValue) {
        return pValue.getValue();
    }
}
