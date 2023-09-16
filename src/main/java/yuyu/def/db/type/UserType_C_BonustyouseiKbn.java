package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BonustyouseiKbn;

/**
 * {@link C_BonustyouseiKbn ボーナス調整区分} の Hibernate ユーザー定義型です。<br />
 * ボーナス調整区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BonustyouseiKbn extends AbstractUserType<C_BonustyouseiKbn> {

    @Override
    protected Class<C_BonustyouseiKbn> returnType() {
        return C_BonustyouseiKbn.class;
    }

    @Override
    protected C_BonustyouseiKbn valueOf(String pValue) {
        return C_BonustyouseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BonustyouseiKbn pValue) {
        return pValue.getValue();
    }
}
