package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SousaRirekiJkKbn;

/**
 * {@link C_SousaRirekiJkKbn 操作履歴状況区分} の Hibernate ユーザー定義型です。<br />
 * 操作履歴状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SousaRirekiJkKbn extends AbstractUserType<C_SousaRirekiJkKbn> {

    @Override
    protected Class<C_SousaRirekiJkKbn> returnType() {
        return C_SousaRirekiJkKbn.class;
    }

    @Override
    protected C_SousaRirekiJkKbn valueOf(String pValue) {
        return C_SousaRirekiJkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SousaRirekiJkKbn pValue) {
        return pValue.getValue();
    }
}
