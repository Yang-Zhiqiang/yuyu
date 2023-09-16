package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KensktKbn;

/**
 * {@link C_KensktKbn 検証工程区分} の Hibernate ユーザー定義型です。<br />
 * 検証工程区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KensktKbn extends AbstractUserType<C_KensktKbn> {

    @Override
    protected Class<C_KensktKbn> returnType() {
        return C_KensktKbn.class;
    }

    @Override
    protected C_KensktKbn valueOf(String pValue) {
        return C_KensktKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KensktKbn pValue) {
        return pValue.getValue();
    }
}
