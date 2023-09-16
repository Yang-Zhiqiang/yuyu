package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YakkanJyuryouKbn;

/**
 * {@link C_YakkanJyuryouKbn 約款受領方法区分} の Hibernate ユーザー定義型です。<br />
 * 約款受領方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YakkanJyuryouKbn extends AbstractUserType<C_YakkanJyuryouKbn> {

    @Override
    protected Class<C_YakkanJyuryouKbn> returnType() {
        return C_YakkanJyuryouKbn.class;
    }

    @Override
    protected C_YakkanJyuryouKbn valueOf(String pValue) {
        return C_YakkanJyuryouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YakkanJyuryouKbn pValue) {
        return pValue.getValue();
    }
}
