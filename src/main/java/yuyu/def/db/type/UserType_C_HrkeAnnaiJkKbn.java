package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HrkeAnnaiJkKbn;

/**
 * {@link C_HrkeAnnaiJkKbn 振替案内状況区分} の Hibernate ユーザー定義型です。<br />
 * 振替案内状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HrkeAnnaiJkKbn extends AbstractUserType<C_HrkeAnnaiJkKbn> {

    @Override
    protected Class<C_HrkeAnnaiJkKbn> returnType() {
        return C_HrkeAnnaiJkKbn.class;
    }

    @Override
    protected C_HrkeAnnaiJkKbn valueOf(String pValue) {
        return C_HrkeAnnaiJkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HrkeAnnaiJkKbn pValue) {
        return pValue.getValue();
    }
}
