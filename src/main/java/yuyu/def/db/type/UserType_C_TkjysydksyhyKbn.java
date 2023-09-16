package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkjysydksyhyKbn;

/**
 * {@link C_TkjysydksyhyKbn 特条承諾書不要区分} の Hibernate ユーザー定義型です。<br />
 * 特条承諾書不要区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkjysydksyhyKbn extends AbstractUserType<C_TkjysydksyhyKbn> {

    @Override
    protected Class<C_TkjysydksyhyKbn> returnType() {
        return C_TkjysydksyhyKbn.class;
    }

    @Override
    protected C_TkjysydksyhyKbn valueOf(String pValue) {
        return C_TkjysydksyhyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkjysydksyhyKbn pValue) {
        return pValue.getValue();
    }
}
