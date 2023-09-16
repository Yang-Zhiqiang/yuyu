package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyouKbn;

/**
 * {@link C_SyouKbn 小区分} の Hibernate ユーザー定義型です。<br />
 * 小区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyouKbn extends AbstractUserType<C_SyouKbn> {

    @Override
    protected Class<C_SyouKbn> returnType() {
        return C_SyouKbn.class;
    }

    @Override
    protected C_SyouKbn valueOf(String pValue) {
        return C_SyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyouKbn pValue) {
        return pValue.getValue();
    }
}
