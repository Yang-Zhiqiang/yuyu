package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FatcatghtkekKbn;

/**
 * {@link C_FatcatghtkekKbn ＦＡＴＣＡ対象判定結果区分} の Hibernate ユーザー定義型です。<br />
 * ＦＡＴＣＡ対象判定結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FatcatghtkekKbn extends AbstractUserType<C_FatcatghtkekKbn> {

    @Override
    protected Class<C_FatcatghtkekKbn> returnType() {
        return C_FatcatghtkekKbn.class;
    }

    @Override
    protected C_FatcatghtkekKbn valueOf(String pValue) {
        return C_FatcatghtkekKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FatcatghtkekKbn pValue) {
        return pValue.getValue();
    }
}
