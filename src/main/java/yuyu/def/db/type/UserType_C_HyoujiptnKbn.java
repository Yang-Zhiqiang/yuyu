package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HyoujiptnKbn;

/**
 * {@link C_HyoujiptnKbn 表示パターン区分} の Hibernate ユーザー定義型です。<br />
 * 表示パターン区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HyoujiptnKbn extends AbstractUserType<C_HyoujiptnKbn> {

    @Override
    protected Class<C_HyoujiptnKbn> returnType() {
        return C_HyoujiptnKbn.class;
    }

    @Override
    protected C_HyoujiptnKbn valueOf(String pValue) {
        return C_HyoujiptnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HyoujiptnKbn pValue) {
        return pValue.getValue();
    }
}
