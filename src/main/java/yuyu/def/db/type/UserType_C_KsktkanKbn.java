package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KsktkanKbn;

/**
 * {@link C_KsktkanKbn 強制決定判定完了区分} の Hibernate ユーザー定義型です。<br />
 * 強制決定判定完了区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KsktkanKbn extends AbstractUserType<C_KsktkanKbn> {

    @Override
    protected Class<C_KsktkanKbn> returnType() {
        return C_KsktkanKbn.class;
    }

    @Override
    protected C_KsktkanKbn valueOf(String pValue) {
        return C_KsktkanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KsktkanKbn pValue) {
        return pValue.getValue();
    }
}
