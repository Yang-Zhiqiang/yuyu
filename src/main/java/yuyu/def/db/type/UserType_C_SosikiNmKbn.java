package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SosikiNmKbn;

/**
 * {@link C_SosikiNmKbn 組織名区分} の Hibernate ユーザー定義型です。<br />
 * 組織名区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SosikiNmKbn extends AbstractUserType<C_SosikiNmKbn> {

    @Override
    protected Class<C_SosikiNmKbn> returnType() {
        return C_SosikiNmKbn.class;
    }

    @Override
    protected C_SosikiNmKbn valueOf(String pValue) {
        return C_SosikiNmKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SosikiNmKbn pValue) {
        return pValue.getValue();
    }
}
