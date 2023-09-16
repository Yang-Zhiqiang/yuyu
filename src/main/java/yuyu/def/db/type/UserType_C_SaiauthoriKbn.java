package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SaiauthoriKbn;

/**
 * {@link C_SaiauthoriKbn 再オーソリ区分} の Hibernate ユーザー定義型です。<br />
 * 再オーソリ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SaiauthoriKbn extends AbstractUserType<C_SaiauthoriKbn> {

    @Override
    protected Class<C_SaiauthoriKbn> returnType() {
        return C_SaiauthoriKbn.class;
    }

    @Override
    protected C_SaiauthoriKbn valueOf(String pValue) {
        return C_SaiauthoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SaiauthoriKbn pValue) {
        return pValue.getValue();
    }
}
