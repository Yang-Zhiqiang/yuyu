package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HokensyuruiKbn;

/**
 * {@link C_HokensyuruiKbn 保険種類区分} の Hibernate ユーザー定義型です。<br />
 * 保険種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HokensyuruiKbn extends AbstractUserType<C_HokensyuruiKbn> {

    @Override
    protected Class<C_HokensyuruiKbn> returnType() {
        return C_HokensyuruiKbn.class;
    }

    @Override
    protected C_HokensyuruiKbn valueOf(String pValue) {
        return C_HokensyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HokensyuruiKbn pValue) {
        return pValue.getValue();
    }
}
