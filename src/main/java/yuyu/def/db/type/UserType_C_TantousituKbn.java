package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TantousituKbn;

/**
 * {@link C_TantousituKbn 担当室区分} の Hibernate ユーザー定義型です。<br />
 * 担当室区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TantousituKbn extends AbstractUserType<C_TantousituKbn> {

    @Override
    protected Class<C_TantousituKbn> returnType() {
        return C_TantousituKbn.class;
    }

    @Override
    protected C_TantousituKbn valueOf(String pValue) {
        return C_TantousituKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TantousituKbn pValue) {
        return pValue.getValue();
    }
}
