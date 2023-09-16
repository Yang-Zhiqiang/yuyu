package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PhrkkknKbn;

/**
 * {@link C_PhrkkknKbn 保険料払込期間区分} の Hibernate ユーザー定義型です。<br />
 * 保険料払込期間区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PhrkkknKbn extends AbstractUserType<C_PhrkkknKbn> {

    @Override
    protected Class<C_PhrkkknKbn> returnType() {
        return C_PhrkkknKbn.class;
    }

    @Override
    protected C_PhrkkknKbn valueOf(String pValue) {
        return C_PhrkkknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PhrkkknKbn pValue) {
        return pValue.getValue();
    }
}
