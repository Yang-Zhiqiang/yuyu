package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YuukshantkekKbn;

/**
 * {@link C_YuukshantkekKbn 有効性判定結果区分} の Hibernate ユーザー定義型です。<br />
 * 有効性判定結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YuukshantkekKbn extends AbstractUserType<C_YuukshantkekKbn> {

    @Override
    protected Class<C_YuukshantkekKbn> returnType() {
        return C_YuukshantkekKbn.class;
    }

    @Override
    protected C_YuukshantkekKbn valueOf(String pValue) {
        return C_YuukshantkekKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YuukshantkekKbn pValue) {
        return pValue.getValue();
    }
}
