package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykMsnKbn;

/**
 * {@link C_KykMsnKbn 契約者未成年区分} の Hibernate ユーザー定義型です。<br />
 * 契約者未成年区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykMsnKbn extends AbstractUserType<C_KykMsnKbn> {

    @Override
    protected Class<C_KykMsnKbn> returnType() {
        return C_KykMsnKbn.class;
    }

    @Override
    protected C_KykMsnKbn valueOf(String pValue) {
        return C_KykMsnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykMsnKbn pValue) {
        return pValue.getValue();
    }
}
