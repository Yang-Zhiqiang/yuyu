package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TrkKzkKbn;

/**
 * {@link C_TrkKzkKbn 登録家族区分} の Hibernate ユーザー定義型です。<br />
 * 登録家族区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TrkKzkKbn extends AbstractUserType<C_TrkKzkKbn> {

    @Override
    protected Class<C_TrkKzkKbn> returnType() {
        return C_TrkKzkKbn.class;
    }

    @Override
    protected C_TrkKzkKbn valueOf(String pValue) {
        return C_TrkKzkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TrkKzkKbn pValue) {
        return pValue.getValue();
    }
}
