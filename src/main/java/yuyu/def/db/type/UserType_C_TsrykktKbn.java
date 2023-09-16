package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsrykktKbn;

/**
 * {@link C_TsrykktKbn 手数料確定区分} の Hibernate ユーザー定義型です。<br />
 * 手数料確定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsrykktKbn extends AbstractUserType<C_TsrykktKbn> {

    @Override
    protected Class<C_TsrykktKbn> returnType() {
        return C_TsrykktKbn.class;
    }

    @Override
    protected C_TsrykktKbn valueOf(String pValue) {
        return C_TsrykktKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsrykktKbn pValue) {
        return pValue.getValue();
    }
}
