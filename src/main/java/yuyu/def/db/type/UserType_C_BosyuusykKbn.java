package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BosyuusykKbn;

/**
 * {@link C_BosyuusykKbn 募集紹介区分} の Hibernate ユーザー定義型です。<br />
 * 募集紹介区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BosyuusykKbn extends AbstractUserType<C_BosyuusykKbn> {

    @Override
    protected Class<C_BosyuusykKbn> returnType() {
        return C_BosyuusykKbn.class;
    }

    @Override
    protected C_BosyuusykKbn valueOf(String pValue) {
        return C_BosyuusykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BosyuusykKbn pValue) {
        return pValue.getValue();
    }
}
