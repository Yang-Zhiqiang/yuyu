package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkykTratkiKbn;

/**
 * {@link C_TkykTratkiKbn 特約取扱区分} の Hibernate ユーザー定義型です。<br />
 * 特約取扱区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkykTratkiKbn extends AbstractUserType<C_TkykTratkiKbn> {

    @Override
    protected Class<C_TkykTratkiKbn> returnType() {
        return C_TkykTratkiKbn.class;
    }

    @Override
    protected C_TkykTratkiKbn valueOf(String pValue) {
        return C_TkykTratkiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkykTratkiKbn pValue) {
        return pValue.getValue();
    }
}
