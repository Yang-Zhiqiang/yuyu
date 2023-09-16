package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SateisnKbn;

/**
 * {@link C_SateisnKbn 査定承認区分} の Hibernate ユーザー定義型です。<br />
 * 査定承認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SateisnKbn extends AbstractUserType<C_SateisnKbn> {

    @Override
    protected Class<C_SateisnKbn> returnType() {
        return C_SateisnKbn.class;
    }

    @Override
    protected C_SateisnKbn valueOf(String pValue) {
        return C_SateisnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SateisnKbn pValue) {
        return pValue.getValue();
    }
}
