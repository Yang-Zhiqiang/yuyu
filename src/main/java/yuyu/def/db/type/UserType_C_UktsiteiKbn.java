package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UktsiteiKbn;

/**
 * {@link C_UktsiteiKbn 受取人指定区分} の Hibernate ユーザー定義型です。<br />
 * 受取人指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UktsiteiKbn extends AbstractUserType<C_UktsiteiKbn> {

    @Override
    protected Class<C_UktsiteiKbn> returnType() {
        return C_UktsiteiKbn.class;
    }

    @Override
    protected C_UktsiteiKbn valueOf(String pValue) {
        return C_UktsiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UktsiteiKbn pValue) {
        return pValue.getValue();
    }
}
