package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BosyuujtKbn;

/**
 * {@link C_BosyuujtKbn 募集人状態区分} の Hibernate ユーザー定義型です。<br />
 * 募集人状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BosyuujtKbn extends AbstractUserType<C_BosyuujtKbn> {

    @Override
    protected Class<C_BosyuujtKbn> returnType() {
        return C_BosyuujtKbn.class;
    }

    @Override
    protected C_BosyuujtKbn valueOf(String pValue) {
        return C_BosyuujtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BosyuujtKbn pValue) {
        return pValue.getValue();
    }
}
