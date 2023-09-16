package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BosyuuknkKbn;

/**
 * {@link C_BosyuuknkKbn 募集人関係区分} の Hibernate ユーザー定義型です。<br />
 * 募集人関係区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BosyuuknkKbn extends AbstractUserType<C_BosyuuknkKbn> {

    @Override
    protected Class<C_BosyuuknkKbn> returnType() {
        return C_BosyuuknkKbn.class;
    }

    @Override
    protected C_BosyuuknkKbn valueOf(String pValue) {
        return C_BosyuuknkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BosyuuknkKbn pValue) {
        return pValue.getValue();
    }
}
