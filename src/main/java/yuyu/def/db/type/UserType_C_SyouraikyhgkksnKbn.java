package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyouraikyhgkksnKbn;

/**
 * {@link C_SyouraikyhgkksnKbn 将来給付額計算区分} の Hibernate ユーザー定義型です。<br />
 * 将来給付額計算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyouraikyhgkksnKbn extends AbstractUserType<C_SyouraikyhgkksnKbn> {

    @Override
    protected Class<C_SyouraikyhgkksnKbn> returnType() {
        return C_SyouraikyhgkksnKbn.class;
    }

    @Override
    protected C_SyouraikyhgkksnKbn valueOf(String pValue) {
        return C_SyouraikyhgkksnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyouraikyhgkksnKbn pValue) {
        return pValue.getValue();
    }
}
