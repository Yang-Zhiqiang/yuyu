package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkjysydksyoKbn;

/**
 * {@link C_TkjysydksyoKbn 特条承諾書区分} の Hibernate ユーザー定義型です。<br />
 * 特条承諾書区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkjysydksyoKbn extends AbstractUserType<C_TkjysydksyoKbn> {

    @Override
    protected Class<C_TkjysydksyoKbn> returnType() {
        return C_TkjysydksyoKbn.class;
    }

    @Override
    protected C_TkjysydksyoKbn valueOf(String pValue) {
        return C_TkjysydksyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkjysydksyoKbn pValue) {
        return pValue.getValue();
    }
}
