package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SateiketsyorinmKbn;

/**
 * {@link C_SateiketsyorinmKbn 査定・決定処理名区分} の Hibernate ユーザー定義型です。<br />
 * 査定・決定処理名区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SateiketsyorinmKbn extends AbstractUserType<C_SateiketsyorinmKbn> {

    @Override
    protected Class<C_SateiketsyorinmKbn> returnType() {
        return C_SateiketsyorinmKbn.class;
    }

    @Override
    protected C_SateiketsyorinmKbn valueOf(String pValue) {
        return C_SateiketsyorinmKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SateiketsyorinmKbn pValue) {
        return pValue.getValue();
    }
}
