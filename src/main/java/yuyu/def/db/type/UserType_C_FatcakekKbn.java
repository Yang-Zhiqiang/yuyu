package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FatcakekKbn;

/**
 * {@link C_FatcakekKbn ＦＡＴＣＡ結果区分} の Hibernate ユーザー定義型です。<br />
 * ＦＡＴＣＡ結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FatcakekKbn extends AbstractUserType<C_FatcakekKbn> {

    @Override
    protected Class<C_FatcakekKbn> returnType() {
        return C_FatcakekKbn.class;
    }

    @Override
    protected C_FatcakekKbn valueOf(String pValue) {
        return C_FatcakekKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FatcakekKbn pValue) {
        return pValue.getValue();
    }
}
