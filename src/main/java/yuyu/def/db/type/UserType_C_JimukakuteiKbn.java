package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JimukakuteiKbn;

/**
 * {@link C_JimukakuteiKbn 事務確定区分} の Hibernate ユーザー定義型です。<br />
 * 事務確定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JimukakuteiKbn extends AbstractUserType<C_JimukakuteiKbn> {

    @Override
    protected Class<C_JimukakuteiKbn> returnType() {
        return C_JimukakuteiKbn.class;
    }

    @Override
    protected C_JimukakuteiKbn valueOf(String pValue) {
        return C_JimukakuteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JimukakuteiKbn pValue) {
        return pValue.getValue();
    }
}
