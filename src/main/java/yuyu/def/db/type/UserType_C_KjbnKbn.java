package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KjbnKbn;

/**
 * {@link C_KjbnKbn 掲示板区分} の Hibernate ユーザー定義型です。<br />
 * 掲示板区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KjbnKbn extends AbstractUserType<C_KjbnKbn> {

    @Override
    protected Class<C_KjbnKbn> returnType() {
        return C_KjbnKbn.class;
    }

    @Override
    protected C_KjbnKbn valueOf(String pValue) {
        return C_KjbnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KjbnKbn pValue) {
        return pValue.getValue();
    }
}
