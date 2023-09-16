package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyuujituTokutei;

/**
 * {@link C_KyuujituTokutei 休日特定方法区分} の Hibernate ユーザー定義型です。<br />
 * 休日特定方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyuujituTokutei extends AbstractUserType<C_KyuujituTokutei> {

    @Override
    protected Class<C_KyuujituTokutei> returnType() {
        return C_KyuujituTokutei.class;
    }

    @Override
    protected C_KyuujituTokutei valueOf(String pValue) {
        return C_KyuujituTokutei.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyuujituTokutei pValue) {
        return pValue.getValue();
    }
}
