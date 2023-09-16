package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HaitouhouKbn;

/**
 * {@link C_HaitouhouKbn 配当方法区分} の Hibernate ユーザー定義型です。<br />
 * 配当方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HaitouhouKbn extends AbstractUserType<C_HaitouhouKbn> {

    @Override
    protected Class<C_HaitouhouKbn> returnType() {
        return C_HaitouhouKbn.class;
    }

    @Override
    protected C_HaitouhouKbn valueOf(String pValue) {
        return C_HaitouhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HaitouhouKbn pValue) {
        return pValue.getValue();
    }
}
