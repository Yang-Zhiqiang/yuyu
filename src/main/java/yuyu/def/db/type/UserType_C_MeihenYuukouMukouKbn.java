package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;

/**
 * {@link C_MeihenYuukouMukouKbn 名義変更有効無効区分} の Hibernate ユーザー定義型です。<br />
 * 名義変更有効無効区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MeihenYuukouMukouKbn extends AbstractUserType<C_MeihenYuukouMukouKbn> {

    @Override
    protected Class<C_MeihenYuukouMukouKbn> returnType() {
        return C_MeihenYuukouMukouKbn.class;
    }

    @Override
    protected C_MeihenYuukouMukouKbn valueOf(String pValue) {
        return C_MeihenYuukouMukouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MeihenYuukouMukouKbn pValue) {
        return pValue.getValue();
    }
}
