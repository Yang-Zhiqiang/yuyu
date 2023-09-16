package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NenkinKbn;

/**
 * {@link C_NenkinKbn 年金区分} の Hibernate ユーザー定義型です。<br />
 * 年金区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NenkinKbn extends AbstractUserType<C_NenkinKbn> {

    @Override
    protected Class<C_NenkinKbn> returnType() {
        return C_NenkinKbn.class;
    }

    @Override
    protected C_NenkinKbn valueOf(String pValue) {
        return C_NenkinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NenkinKbn pValue) {
        return pValue.getValue();
    }
}
