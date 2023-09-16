package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BonusrankKbn;

/**
 * {@link C_BonusrankKbn ボーナスランク区分} の Hibernate ユーザー定義型です。<br />
 * ボーナスランク区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BonusrankKbn extends AbstractUserType<C_BonusrankKbn> {

    @Override
    protected Class<C_BonusrankKbn> returnType() {
        return C_BonusrankKbn.class;
    }

    @Override
    protected C_BonusrankKbn valueOf(String pValue) {
        return C_BonusrankKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BonusrankKbn pValue) {
        return pValue.getValue();
    }
}
