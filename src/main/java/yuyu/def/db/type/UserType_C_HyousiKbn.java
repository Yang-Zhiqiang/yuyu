package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HyousiKbn;

/**
 * {@link C_HyousiKbn 表紙区分} の Hibernate ユーザー定義型です。<br />
 * 表紙区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HyousiKbn extends AbstractUserType<C_HyousiKbn> {

    @Override
    protected Class<C_HyousiKbn> returnType() {
        return C_HyousiKbn.class;
    }

    @Override
    protected C_HyousiKbn valueOf(String pValue) {
        return C_HyousiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HyousiKbn pValue) {
        return pValue.getValue();
    }
}
