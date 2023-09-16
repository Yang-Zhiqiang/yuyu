package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NiGamenModeJyoutaiKbn;

/**
 * {@link C_NiGamenModeJyoutaiKbn ２画面モード状態区分} の Hibernate ユーザー定義型です。<br />
 * ２画面モード状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NiGamenModeJyoutaiKbn extends AbstractUserType<C_NiGamenModeJyoutaiKbn> {

    @Override
    protected Class<C_NiGamenModeJyoutaiKbn> returnType() {
        return C_NiGamenModeJyoutaiKbn.class;
    }

    @Override
    protected C_NiGamenModeJyoutaiKbn valueOf(String pValue) {
        return C_NiGamenModeJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NiGamenModeJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
