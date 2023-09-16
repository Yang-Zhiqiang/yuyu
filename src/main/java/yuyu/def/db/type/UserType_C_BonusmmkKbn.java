package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BonusmmkKbn;

/**
 * {@link C_BonusmmkKbn ボーナス名目区分} の Hibernate ユーザー定義型です。<br />
 * ボーナス名目区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BonusmmkKbn extends AbstractUserType<C_BonusmmkKbn> {

    @Override
    protected Class<C_BonusmmkKbn> returnType() {
        return C_BonusmmkKbn.class;
    }

    @Override
    protected C_BonusmmkKbn valueOf(String pValue) {
        return C_BonusmmkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BonusmmkKbn pValue) {
        return pValue.getValue();
    }
}
