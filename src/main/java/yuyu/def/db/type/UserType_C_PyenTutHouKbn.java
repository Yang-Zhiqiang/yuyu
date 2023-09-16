package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PyenTutHouKbn;

/**
 * {@link C_PyenTutHouKbn 保険料円換算額通知方法区分} の Hibernate ユーザー定義型です。<br />
 * 保険料円換算額通知方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PyenTutHouKbn extends AbstractUserType<C_PyenTutHouKbn> {

    @Override
    protected Class<C_PyenTutHouKbn> returnType() {
        return C_PyenTutHouKbn.class;
    }

    @Override
    protected C_PyenTutHouKbn valueOf(String pValue) {
        return C_PyenTutHouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PyenTutHouKbn pValue) {
        return pValue.getValue();
    }
}
