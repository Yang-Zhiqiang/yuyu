package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SysCdKbn;

/**
 * {@link C_SysCdKbn システムコード区分} の Hibernate ユーザー定義型です。<br />
 * システムコード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SysCdKbn extends AbstractUserType<C_SysCdKbn> {

    @Override
    protected Class<C_SysCdKbn> returnType() {
        return C_SysCdKbn.class;
    }

    @Override
    protected C_SysCdKbn valueOf(String pValue) {
        return C_SysCdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SysCdKbn pValue) {
        return pValue.getValue();
    }
}
