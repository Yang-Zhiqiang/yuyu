package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrhousiteiKbn;

/**
 * {@link C_ShrhousiteiKbn 支払方法指定区分} の Hibernate ユーザー定義型です。<br />
 * 支払方法指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrhousiteiKbn extends AbstractUserType<C_ShrhousiteiKbn> {

    @Override
    protected Class<C_ShrhousiteiKbn> returnType() {
        return C_ShrhousiteiKbn.class;
    }

    @Override
    protected C_ShrhousiteiKbn valueOf(String pValue) {
        return C_ShrhousiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrhousiteiKbn pValue) {
        return pValue.getValue();
    }
}
