package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SousinKbn;

/**
 * {@link C_SousinKbn 送信区分} の Hibernate ユーザー定義型です。<br />
 * 送信区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SousinKbn extends AbstractUserType<C_SousinKbn> {

    @Override
    protected Class<C_SousinKbn> returnType() {
        return C_SousinKbn.class;
    }

    @Override
    protected C_SousinKbn valueOf(String pValue) {
        return C_SousinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SousinKbn pValue) {
        return pValue.getValue();
    }
}
