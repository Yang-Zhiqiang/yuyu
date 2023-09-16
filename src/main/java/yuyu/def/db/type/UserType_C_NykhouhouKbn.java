package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NykhouhouKbn;

/**
 * {@link C_NykhouhouKbn 入金方法区分} の Hibernate ユーザー定義型です。<br />
 * 入金方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NykhouhouKbn extends AbstractUserType<C_NykhouhouKbn> {

    @Override
    protected Class<C_NykhouhouKbn> returnType() {
        return C_NykhouhouKbn.class;
    }

    @Override
    protected C_NykhouhouKbn valueOf(String pValue) {
        return C_NykhouhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NykhouhouKbn pValue) {
        return pValue.getValue();
    }
}
