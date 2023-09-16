package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyhhyoKbn;

/**
 * {@link C_KyhhyoKbn 給付事例表示区分} の Hibernate ユーザー定義型です。<br />
 * 給付事例表示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyhhyoKbn extends AbstractUserType<C_KyhhyoKbn> {

    @Override
    protected Class<C_KyhhyoKbn> returnType() {
        return C_KyhhyoKbn.class;
    }

    @Override
    protected C_KyhhyoKbn valueOf(String pValue) {
        return C_KyhhyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyhhyoKbn pValue) {
        return pValue.getValue();
    }
}
