package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IjitoukeiHokensyuruiKbn;

/**
 * {@link C_IjitoukeiHokensyuruiKbn 医事統計用保険種類区分} の Hibernate ユーザー定義型です。<br />
 * 医事統計用保険種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IjitoukeiHokensyuruiKbn extends AbstractUserType<C_IjitoukeiHokensyuruiKbn> {

    @Override
    protected Class<C_IjitoukeiHokensyuruiKbn> returnType() {
        return C_IjitoukeiHokensyuruiKbn.class;
    }

    @Override
    protected C_IjitoukeiHokensyuruiKbn valueOf(String pValue) {
        return C_IjitoukeiHokensyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IjitoukeiHokensyuruiKbn pValue) {
        return pValue.getValue();
    }
}
