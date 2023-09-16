package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoshanteikoumokuKbn;

/**
 * {@link C_KoshanteikoumokuKbn 更新判定項目区分} の Hibernate ユーザー定義型です。<br />
 * 更新判定項目区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoshanteikoumokuKbn extends AbstractUserType<C_KoshanteikoumokuKbn> {

    @Override
    protected Class<C_KoshanteikoumokuKbn> returnType() {
        return C_KoshanteikoumokuKbn.class;
    }

    @Override
    protected C_KoshanteikoumokuKbn valueOf(String pValue) {
        return C_KoshanteikoumokuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoshanteikoumokuKbn pValue) {
        return pValue.getValue();
    }
}
