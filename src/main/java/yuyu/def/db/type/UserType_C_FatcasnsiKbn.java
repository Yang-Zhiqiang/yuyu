package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FatcasnsiKbn;

/**
 * {@link C_FatcasnsiKbn ＦＡＴＣＡ宣誓区分} の Hibernate ユーザー定義型です。<br />
 * ＦＡＴＣＡ宣誓区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FatcasnsiKbn extends AbstractUserType<C_FatcasnsiKbn> {

    @Override
    protected Class<C_FatcasnsiKbn> returnType() {
        return C_FatcasnsiKbn.class;
    }

    @Override
    protected C_FatcasnsiKbn valueOf(String pValue) {
        return C_FatcasnsiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FatcasnsiKbn pValue) {
        return pValue.getValue();
    }
}
