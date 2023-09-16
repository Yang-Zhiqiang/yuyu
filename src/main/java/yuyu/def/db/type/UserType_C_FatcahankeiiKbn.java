package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FatcahankeiiKbn;

/**
 * {@link C_FatcahankeiiKbn ＦＡＴＣＡ判明経緯区分} の Hibernate ユーザー定義型です。<br />
 * ＦＡＴＣＡ判明経緯区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FatcahankeiiKbn extends AbstractUserType<C_FatcahankeiiKbn> {

    @Override
    protected Class<C_FatcahankeiiKbn> returnType() {
        return C_FatcahankeiiKbn.class;
    }

    @Override
    protected C_FatcahankeiiKbn valueOf(String pValue) {
        return C_FatcahankeiiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FatcahankeiiKbn pValue) {
        return pValue.getValue();
    }
}
