package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UktsyuKbn;

/**
 * {@link C_UktsyuKbn 受取人種類区分} の Hibernate ユーザー定義型です。<br />
 * 受取人種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UktsyuKbn extends AbstractUserType<C_UktsyuKbn> {

    @Override
    protected Class<C_UktsyuKbn> returnType() {
        return C_UktsyuKbn.class;
    }

    @Override
    protected C_UktsyuKbn valueOf(String pValue) {
        return C_UktsyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UktsyuKbn pValue) {
        return pValue.getValue();
    }
}
