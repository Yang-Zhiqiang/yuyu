package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TrkkzkttdkKbn;

/**
 * {@link C_TrkkzkttdkKbn 登録家族手続区分} の Hibernate ユーザー定義型です。<br />
 * 登録家族手続区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TrkkzkttdkKbn extends AbstractUserType<C_TrkkzkttdkKbn> {

    @Override
    protected Class<C_TrkkzkttdkKbn> returnType() {
        return C_TrkkzkttdkKbn.class;
    }

    @Override
    protected C_TrkkzkttdkKbn valueOf(String pValue) {
        return C_TrkkzkttdkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TrkkzkttdkKbn pValue) {
        return pValue.getValue();
    }
}
