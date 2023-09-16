package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SignalkaihiKbn;

/**
 * {@link C_SignalkaihiKbn シグナル回避区分} の Hibernate ユーザー定義型です。<br />
 * シグナル回避区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SignalkaihiKbn extends AbstractUserType<C_SignalkaihiKbn> {

    @Override
    protected Class<C_SignalkaihiKbn> returnType() {
        return C_SignalkaihiKbn.class;
    }

    @Override
    protected C_SignalkaihiKbn valueOf(String pValue) {
        return C_SignalkaihiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SignalkaihiKbn pValue) {
        return pValue.getValue();
    }
}
