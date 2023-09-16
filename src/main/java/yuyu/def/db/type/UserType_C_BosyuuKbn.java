package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BosyuuKbn;

/**
 * {@link C_BosyuuKbn 募集人区分} の Hibernate ユーザー定義型です。<br />
 * 募集人区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BosyuuKbn extends AbstractUserType<C_BosyuuKbn> {

    @Override
    protected Class<C_BosyuuKbn> returnType() {
        return C_BosyuuKbn.class;
    }

    @Override
    protected C_BosyuuKbn valueOf(String pValue) {
        return C_BosyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BosyuuKbn pValue) {
        return pValue.getValue();
    }
}
