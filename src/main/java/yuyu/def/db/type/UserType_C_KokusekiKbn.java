package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KokusekiKbn;

/**
 * {@link C_KokusekiKbn 国籍区分} の Hibernate ユーザー定義型です。<br />
 * 国籍区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KokusekiKbn extends AbstractUserType<C_KokusekiKbn> {

    @Override
    protected Class<C_KokusekiKbn> returnType() {
        return C_KokusekiKbn.class;
    }

    @Override
    protected C_KokusekiKbn valueOf(String pValue) {
        return C_KokusekiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KokusekiKbn pValue) {
        return pValue.getValue();
    }
}
