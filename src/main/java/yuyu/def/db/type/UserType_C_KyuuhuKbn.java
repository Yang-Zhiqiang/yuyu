package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyuuhuKbn;

/**
 * {@link C_KyuuhuKbn 給付区分} の Hibernate ユーザー定義型です。<br />
 * 給付区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyuuhuKbn extends AbstractUserType<C_KyuuhuKbn> {

    @Override
    protected Class<C_KyuuhuKbn> returnType() {
        return C_KyuuhuKbn.class;
    }

    @Override
    protected C_KyuuhuKbn valueOf(String pValue) {
        return C_KyuuhuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyuuhuKbn pValue) {
        return pValue.getValue();
    }
}
