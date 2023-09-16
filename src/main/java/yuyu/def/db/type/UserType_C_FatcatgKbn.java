package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FatcatgKbn;

/**
 * {@link C_FatcatgKbn ＦＡＴＣＡ対象者区分} の Hibernate ユーザー定義型です。<br />
 * ＦＡＴＣＡ対象者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FatcatgKbn extends AbstractUserType<C_FatcatgKbn> {

    @Override
    protected Class<C_FatcatgKbn> returnType() {
        return C_FatcatgKbn.class;
    }

    @Override
    protected C_FatcatgKbn valueOf(String pValue) {
        return C_FatcatgKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FatcatgKbn pValue) {
        return pValue.getValue();
    }
}
