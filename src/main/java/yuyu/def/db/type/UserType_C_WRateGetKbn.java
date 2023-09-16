package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_WRateGetKbn;

/**
 * {@link C_WRateGetKbn Ｗレート取得区分} の Hibernate ユーザー定義型です。<br />
 * Ｗレート取得区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_WRateGetKbn extends AbstractUserType<C_WRateGetKbn> {

    @Override
    protected Class<C_WRateGetKbn> returnType() {
        return C_WRateGetKbn.class;
    }

    @Override
    protected C_WRateGetKbn valueOf(String pValue) {
        return C_WRateGetKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_WRateGetKbn pValue) {
        return pValue.getValue();
    }
}
