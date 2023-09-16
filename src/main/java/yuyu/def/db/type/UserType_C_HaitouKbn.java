package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HaitouKbn;

/**
 * {@link C_HaitouKbn 配当区分} の Hibernate ユーザー定義型です。<br />
 * 配当区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HaitouKbn extends AbstractUserType<C_HaitouKbn> {

    @Override
    protected Class<C_HaitouKbn> returnType() {
        return C_HaitouKbn.class;
    }

    @Override
    protected C_HaitouKbn valueOf(String pValue) {
        return C_HaitouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HaitouKbn pValue) {
        return pValue.getValue();
    }
}
