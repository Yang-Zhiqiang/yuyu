package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FirstmiseikyuuKbn;

/**
 * {@link C_FirstmiseikyuuKbn 初回年金未請求区分} の Hibernate ユーザー定義型です。<br />
 * 初回年金未請求区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FirstmiseikyuuKbn extends AbstractUserType<C_FirstmiseikyuuKbn> {

    @Override
    protected Class<C_FirstmiseikyuuKbn> returnType() {
        return C_FirstmiseikyuuKbn.class;
    }

    @Override
    protected C_FirstmiseikyuuKbn valueOf(String pValue) {
        return C_FirstmiseikyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FirstmiseikyuuKbn pValue) {
        return pValue.getValue();
    }
}
