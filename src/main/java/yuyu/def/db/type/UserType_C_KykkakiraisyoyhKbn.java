package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykkakiraisyoyhKbn;

/**
 * {@link C_KykkakiraisyoyhKbn 契約確認依頼書要否区分} の Hibernate ユーザー定義型です。<br />
 * 契約確認依頼書要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykkakiraisyoyhKbn extends AbstractUserType<C_KykkakiraisyoyhKbn> {

    @Override
    protected Class<C_KykkakiraisyoyhKbn> returnType() {
        return C_KykkakiraisyoyhKbn.class;
    }

    @Override
    protected C_KykkakiraisyoyhKbn valueOf(String pValue) {
        return C_KykkakiraisyoyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykkakiraisyoyhKbn pValue) {
        return pValue.getValue();
    }
}
