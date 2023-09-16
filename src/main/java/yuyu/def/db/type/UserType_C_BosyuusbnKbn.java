package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BosyuusbnKbn;

/**
 * {@link C_BosyuusbnKbn 募集人任意採番区分} の Hibernate ユーザー定義型です。<br />
 * 募集人任意採番区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BosyuusbnKbn extends AbstractUserType<C_BosyuusbnKbn> {

    @Override
    protected Class<C_BosyuusbnKbn> returnType() {
        return C_BosyuusbnKbn.class;
    }

    @Override
    protected C_BosyuusbnKbn valueOf(String pValue) {
        return C_BosyuusbnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BosyuusbnKbn pValue) {
        return pValue.getValue();
    }
}
