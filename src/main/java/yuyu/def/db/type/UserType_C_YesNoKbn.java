package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YesNoKbn;

/**
 * {@link C_YesNoKbn YesNo区分} の Hibernate ユーザー定義型です。<br />
 * YesNo区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YesNoKbn extends AbstractUserType<C_YesNoKbn> {

    @Override
    protected Class<C_YesNoKbn> returnType() {
        return C_YesNoKbn.class;
    }

    @Override
    protected C_YesNoKbn valueOf(String pValue) {
        return C_YesNoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YesNoKbn pValue) {
        return pValue.getValue();
    }
}
