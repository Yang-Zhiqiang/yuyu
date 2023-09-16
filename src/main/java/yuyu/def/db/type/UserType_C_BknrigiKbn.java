package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BknrigiKbn;

/**
 * {@link C_BknrigiKbn 備金例外区分} の Hibernate ユーザー定義型です。<br />
 * 備金例外区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BknrigiKbn extends AbstractUserType<C_BknrigiKbn> {

    @Override
    protected Class<C_BknrigiKbn> returnType() {
        return C_BknrigiKbn.class;
    }

    @Override
    protected C_BknrigiKbn valueOf(String pValue) {
        return C_BknrigiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BknrigiKbn pValue) {
        return pValue.getValue();
    }
}
