package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TetudukisyuKbn;

/**
 * {@link C_TetudukisyuKbn 手続種類区分} の Hibernate ユーザー定義型です。<br />
 * 手続種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TetudukisyuKbn extends AbstractUserType<C_TetudukisyuKbn> {

    @Override
    protected Class<C_TetudukisyuKbn> returnType() {
        return C_TetudukisyuKbn.class;
    }

    @Override
    protected C_TetudukisyuKbn valueOf(String pValue) {
        return C_TetudukisyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TetudukisyuKbn pValue) {
        return pValue.getValue();
    }
}
