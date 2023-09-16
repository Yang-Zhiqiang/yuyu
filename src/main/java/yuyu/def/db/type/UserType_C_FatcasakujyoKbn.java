package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FatcasakujyoKbn;

/**
 * {@link C_FatcasakujyoKbn ＦＡＴＣＡ削除区分} の Hibernate ユーザー定義型です。<br />
 * ＦＡＴＣＡ削除区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FatcasakujyoKbn extends AbstractUserType<C_FatcasakujyoKbn> {

    @Override
    protected Class<C_FatcasakujyoKbn> returnType() {
        return C_FatcasakujyoKbn.class;
    }

    @Override
    protected C_FatcasakujyoKbn valueOf(String pValue) {
        return C_FatcasakujyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FatcasakujyoKbn pValue) {
        return pValue.getValue();
    }
}
