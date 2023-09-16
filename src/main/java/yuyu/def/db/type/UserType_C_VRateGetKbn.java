package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_VRateGetKbn;

/**
 * {@link C_VRateGetKbn Ｖレート取得区分} の Hibernate ユーザー定義型です。<br />
 * Ｖレート取得区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_VRateGetKbn extends AbstractUserType<C_VRateGetKbn> {

    @Override
    protected Class<C_VRateGetKbn> returnType() {
        return C_VRateGetKbn.class;
    }

    @Override
    protected C_VRateGetKbn valueOf(String pValue) {
        return C_VRateGetKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_VRateGetKbn pValue) {
        return pValue.getValue();
    }
}
