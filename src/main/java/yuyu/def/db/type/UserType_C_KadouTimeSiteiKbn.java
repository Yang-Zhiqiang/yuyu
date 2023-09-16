package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KadouTimeSiteiKbn;

/**
 * {@link C_KadouTimeSiteiKbn 稼働時間指定区分} の Hibernate ユーザー定義型です。<br />
 * 稼働時間指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KadouTimeSiteiKbn extends AbstractUserType<C_KadouTimeSiteiKbn> {

    @Override
    protected Class<C_KadouTimeSiteiKbn> returnType() {
        return C_KadouTimeSiteiKbn.class;
    }

    @Override
    protected C_KadouTimeSiteiKbn valueOf(String pValue) {
        return C_KadouTimeSiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KadouTimeSiteiKbn pValue) {
        return pValue.getValue();
    }
}
