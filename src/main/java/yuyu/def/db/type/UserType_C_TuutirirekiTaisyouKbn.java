package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TuutirirekiTaisyouKbn;

/**
 * {@link C_TuutirirekiTaisyouKbn 通知履歴対象区分} の Hibernate ユーザー定義型です。<br />
 * 通知履歴対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TuutirirekiTaisyouKbn extends AbstractUserType<C_TuutirirekiTaisyouKbn> {

    @Override
    protected Class<C_TuutirirekiTaisyouKbn> returnType() {
        return C_TuutirirekiTaisyouKbn.class;
    }

    @Override
    protected C_TuutirirekiTaisyouKbn valueOf(String pValue) {
        return C_TuutirirekiTaisyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TuutirirekiTaisyouKbn pValue) {
        return pValue.getValue();
    }
}
