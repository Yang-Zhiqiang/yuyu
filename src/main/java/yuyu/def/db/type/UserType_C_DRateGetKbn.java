package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DRateGetKbn;

/**
 * {@link C_DRateGetKbn Ｄレート取得区分} の Hibernate ユーザー定義型です。<br />
 * Ｄレート取得区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DRateGetKbn extends AbstractUserType<C_DRateGetKbn> {

    @Override
    protected Class<C_DRateGetKbn> returnType() {
        return C_DRateGetKbn.class;
    }

    @Override
    protected C_DRateGetKbn valueOf(String pValue) {
        return C_DRateGetKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DRateGetKbn pValue) {
        return pValue.getValue();
    }
}
