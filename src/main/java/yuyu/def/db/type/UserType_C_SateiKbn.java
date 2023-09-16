package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SateiKbn;

/**
 * {@link C_SateiKbn 査定区分} の Hibernate ユーザー定義型です。<br />
 * 査定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SateiKbn extends AbstractUserType<C_SateiKbn> {

    @Override
    protected Class<C_SateiKbn> returnType() {
        return C_SateiKbn.class;
    }

    @Override
    protected C_SateiKbn valueOf(String pValue) {
        return C_SateiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SateiKbn pValue) {
        return pValue.getValue();
    }
}
