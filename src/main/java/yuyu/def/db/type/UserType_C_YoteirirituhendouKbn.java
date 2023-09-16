package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YoteirirituhendouKbn;

/**
 * {@link C_YoteirirituhendouKbn 予定利率変動区分} の Hibernate ユーザー定義型です。<br />
 * 予定利率変動区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YoteirirituhendouKbn extends AbstractUserType<C_YoteirirituhendouKbn> {

    @Override
    protected Class<C_YoteirirituhendouKbn> returnType() {
        return C_YoteirirituhendouKbn.class;
    }

    @Override
    protected C_YoteirirituhendouKbn valueOf(String pValue) {
        return C_YoteirirituhendouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YoteirirituhendouKbn pValue) {
        return pValue.getValue();
    }
}
