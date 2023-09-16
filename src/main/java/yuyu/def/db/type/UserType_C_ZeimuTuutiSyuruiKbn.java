package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZeimuTuutiSyuruiKbn;

/**
 * {@link C_ZeimuTuutiSyuruiKbn 税務通知種類区分} の Hibernate ユーザー定義型です。<br />
 * 税務通知種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZeimuTuutiSyuruiKbn extends AbstractUserType<C_ZeimuTuutiSyuruiKbn> {

    @Override
    protected Class<C_ZeimuTuutiSyuruiKbn> returnType() {
        return C_ZeimuTuutiSyuruiKbn.class;
    }

    @Override
    protected C_ZeimuTuutiSyuruiKbn valueOf(String pValue) {
        return C_ZeimuTuutiSyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZeimuTuutiSyuruiKbn pValue) {
        return pValue.getValue();
    }
}
