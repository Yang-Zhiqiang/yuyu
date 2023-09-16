package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyouseijiyuuKbn;

/**
 * {@link C_TyouseijiyuuKbn 調整事由区分} の Hibernate ユーザー定義型です。<br />
 * 調整事由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyouseijiyuuKbn extends AbstractUserType<C_TyouseijiyuuKbn> {

    @Override
    protected Class<C_TyouseijiyuuKbn> returnType() {
        return C_TyouseijiyuuKbn.class;
    }

    @Override
    protected C_TyouseijiyuuKbn valueOf(String pValue) {
        return C_TyouseijiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyouseijiyuuKbn pValue) {
        return pValue.getValue();
    }
}
