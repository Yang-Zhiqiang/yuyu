package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NoinitYouhiKbn;

/**
 * {@link C_NoinitYouhiKbn 初期値無し要否区分} の Hibernate ユーザー定義型です。<br />
 * 初期値無し要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NoinitYouhiKbn extends AbstractUserType<C_NoinitYouhiKbn> {

    @Override
    protected Class<C_NoinitYouhiKbn> returnType() {
        return C_NoinitYouhiKbn.class;
    }

    @Override
    protected C_NoinitYouhiKbn valueOf(String pValue) {
        return C_NoinitYouhiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NoinitYouhiKbn pValue) {
        return pValue.getValue();
    }
}
