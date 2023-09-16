package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RiyousysKbn;

/**
 * {@link C_RiyousysKbn 利用元システム区分} の Hibernate ユーザー定義型です。<br />
 * 利用元システム区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RiyousysKbn extends AbstractUserType<C_RiyousysKbn> {

    @Override
    protected Class<C_RiyousysKbn> returnType() {
        return C_RiyousysKbn.class;
    }

    @Override
    protected C_RiyousysKbn valueOf(String pValue) {
        return C_RiyousysKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RiyousysKbn pValue) {
        return pValue.getValue();
    }
}
