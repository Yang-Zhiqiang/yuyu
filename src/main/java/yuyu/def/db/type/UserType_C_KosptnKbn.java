package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KosptnKbn;

/**
 * {@link C_KosptnKbn 更新パターン区分} の Hibernate ユーザー定義型です。<br />
 * 更新パターン区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KosptnKbn extends AbstractUserType<C_KosptnKbn> {

    @Override
    protected Class<C_KosptnKbn> returnType() {
        return C_KosptnKbn.class;
    }

    @Override
    protected C_KosptnKbn valueOf(String pValue) {
        return C_KosptnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KosptnKbn pValue) {
        return pValue.getValue();
    }
}
