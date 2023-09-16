package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;

/**
 * {@link C_KyksyaSibouUmuKbn 契約者死亡有無区分} の Hibernate ユーザー定義型です。<br />
 * 契約者死亡有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyksyaSibouUmuKbn extends AbstractUserType<C_KyksyaSibouUmuKbn> {

    @Override
    protected Class<C_KyksyaSibouUmuKbn> returnType() {
        return C_KyksyaSibouUmuKbn.class;
    }

    @Override
    protected C_KyksyaSibouUmuKbn valueOf(String pValue) {
        return C_KyksyaSibouUmuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyksyaSibouUmuKbn pValue) {
        return pValue.getValue();
    }
}
