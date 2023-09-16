package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GyousekihyoujisksnKbn;

/**
 * {@link C_GyousekihyoujisksnKbn 業績表示Ｓ計算区分} の Hibernate ユーザー定義型です。<br />
 * 業績表示Ｓ計算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GyousekihyoujisksnKbn extends AbstractUserType<C_GyousekihyoujisksnKbn> {

    @Override
    protected Class<C_GyousekihyoujisksnKbn> returnType() {
        return C_GyousekihyoujisksnKbn.class;
    }

    @Override
    protected C_GyousekihyoujisksnKbn valueOf(String pValue) {
        return C_GyousekihyoujisksnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GyousekihyoujisksnKbn pValue) {
        return pValue.getValue();
    }
}
