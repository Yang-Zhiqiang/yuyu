package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SensinItijikinShrUmuKbn;

/**
 * {@link C_SensinItijikinShrUmuKbn 先進医療一時金支払有無区分} の Hibernate ユーザー定義型です。<br />
 * 先進医療一時金支払有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SensinItijikinShrUmuKbn extends AbstractUserType<C_SensinItijikinShrUmuKbn> {

    @Override
    protected Class<C_SensinItijikinShrUmuKbn> returnType() {
        return C_SensinItijikinShrUmuKbn.class;
    }

    @Override
    protected C_SensinItijikinShrUmuKbn valueOf(String pValue) {
        return C_SensinItijikinShrUmuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SensinItijikinShrUmuKbn pValue) {
        return pValue.getValue();
    }
}
