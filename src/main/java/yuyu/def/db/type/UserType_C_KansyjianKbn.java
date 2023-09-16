package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KansyjianKbn;

/**
 * {@link C_KansyjianKbn 勧奨要事案区分} の Hibernate ユーザー定義型です。<br />
 * 勧奨要事案区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KansyjianKbn extends AbstractUserType<C_KansyjianKbn> {

    @Override
    protected Class<C_KansyjianKbn> returnType() {
        return C_KansyjianKbn.class;
    }

    @Override
    protected C_KansyjianKbn valueOf(String pValue) {
        return C_KansyjianKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KansyjianKbn pValue) {
        return pValue.getValue();
    }
}
