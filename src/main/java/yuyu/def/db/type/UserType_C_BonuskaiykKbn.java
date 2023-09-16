package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BonuskaiykKbn;

/**
 * {@link C_BonuskaiykKbn ボーナス解約区分} の Hibernate ユーザー定義型です。<br />
 * ボーナス解約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BonuskaiykKbn extends AbstractUserType<C_BonuskaiykKbn> {

    @Override
    protected Class<C_BonuskaiykKbn> returnType() {
        return C_BonuskaiykKbn.class;
    }

    @Override
    protected C_BonuskaiykKbn valueOf(String pValue) {
        return C_BonuskaiykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BonuskaiykKbn pValue) {
        return pValue.getValue();
    }
}
