package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GaibusiryoskmotoKbn;

/**
 * {@link C_GaibusiryoskmotoKbn 外部資料請求元区分} の Hibernate ユーザー定義型です。<br />
 * 外部資料請求元区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GaibusiryoskmotoKbn extends AbstractUserType<C_GaibusiryoskmotoKbn> {

    @Override
    protected Class<C_GaibusiryoskmotoKbn> returnType() {
        return C_GaibusiryoskmotoKbn.class;
    }

    @Override
    protected C_GaibusiryoskmotoKbn valueOf(String pValue) {
        return C_GaibusiryoskmotoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GaibusiryoskmotoKbn pValue) {
        return pValue.getValue();
    }
}
