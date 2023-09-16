package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KaiyakuhrstgakksnKbn;

/**
 * {@link C_KaiyakuhrstgakksnKbn 解約返戻金相当額計算区分} の Hibernate ユーザー定義型です。<br />
 * 解約返戻金相当額計算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KaiyakuhrstgakksnKbn extends AbstractUserType<C_KaiyakuhrstgakksnKbn> {

    @Override
    protected Class<C_KaiyakuhrstgakksnKbn> returnType() {
        return C_KaiyakuhrstgakksnKbn.class;
    }

    @Override
    protected C_KaiyakuhrstgakksnKbn valueOf(String pValue) {
        return C_KaiyakuhrstgakksnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KaiyakuhrstgakksnKbn pValue) {
        return pValue.getValue();
    }
}
