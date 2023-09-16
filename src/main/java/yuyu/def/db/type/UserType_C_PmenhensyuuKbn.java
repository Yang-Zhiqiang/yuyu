package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PmenhensyuuKbn;

/**
 * {@link C_PmenhensyuuKbn Ｐ免編集区分} の Hibernate ユーザー定義型です。<br />
 * Ｐ免編集区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PmenhensyuuKbn extends AbstractUserType<C_PmenhensyuuKbn> {

    @Override
    protected Class<C_PmenhensyuuKbn> returnType() {
        return C_PmenhensyuuKbn.class;
    }

    @Override
    protected C_PmenhensyuuKbn valueOf(String pValue) {
        return C_PmenhensyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PmenhensyuuKbn pValue) {
        return pValue.getValue();
    }
}
