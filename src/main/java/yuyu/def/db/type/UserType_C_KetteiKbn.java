package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KetteiKbn;

/**
 * {@link C_KetteiKbn 決定状態区分} の Hibernate ユーザー定義型です。<br />
 * 決定状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KetteiKbn extends AbstractUserType<C_KetteiKbn> {

    @Override
    protected Class<C_KetteiKbn> returnType() {
        return C_KetteiKbn.class;
    }

    @Override
    protected C_KetteiKbn valueOf(String pValue) {
        return C_KetteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KetteiKbn pValue) {
        return pValue.getValue();
    }
}
