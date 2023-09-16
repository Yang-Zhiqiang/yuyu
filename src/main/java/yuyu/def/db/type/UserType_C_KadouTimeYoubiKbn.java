package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KadouTimeYoubiKbn;

/**
 * {@link C_KadouTimeYoubiKbn 稼働時間曜日区分} の Hibernate ユーザー定義型です。<br />
 * 稼働時間曜日区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KadouTimeYoubiKbn extends AbstractUserType<C_KadouTimeYoubiKbn> {

    @Override
    protected Class<C_KadouTimeYoubiKbn> returnType() {
        return C_KadouTimeYoubiKbn.class;
    }

    @Override
    protected C_KadouTimeYoubiKbn valueOf(String pValue) {
        return C_KadouTimeYoubiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KadouTimeYoubiKbn pValue) {
        return pValue.getValue();
    }
}
