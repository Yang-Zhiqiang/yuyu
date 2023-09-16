package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyktrkKbn;

/**
 * {@link C_KyktrkKbn 契約者登録区分} の Hibernate ユーザー定義型です。<br />
 * 契約者登録区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyktrkKbn extends AbstractUserType<C_KyktrkKbn> {

    @Override
    protected Class<C_KyktrkKbn> returnType() {
        return C_KyktrkKbn.class;
    }

    @Override
    protected C_KyktrkKbn valueOf(String pValue) {
        return C_KyktrkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyktrkKbn pValue) {
        return pValue.getValue();
    }
}
