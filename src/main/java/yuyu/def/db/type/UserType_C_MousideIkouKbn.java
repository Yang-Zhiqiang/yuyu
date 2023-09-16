package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MousideIkouKbn;

/**
 * {@link C_MousideIkouKbn 申出移行区分} の Hibernate ユーザー定義型です。<br />
 * 申出移行区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MousideIkouKbn extends AbstractUserType<C_MousideIkouKbn> {

    @Override
    protected Class<C_MousideIkouKbn> returnType() {
        return C_MousideIkouKbn.class;
    }

    @Override
    protected C_MousideIkouKbn valueOf(String pValue) {
        return C_MousideIkouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MousideIkouKbn pValue) {
        return pValue.getValue();
    }
}
