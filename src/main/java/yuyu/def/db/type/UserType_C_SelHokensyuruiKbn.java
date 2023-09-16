package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SelHokensyuruiKbn;

/**
 * {@link C_SelHokensyuruiKbn （選択用）保険種類区分} の Hibernate ユーザー定義型です。<br />
 * （選択用）保険種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SelHokensyuruiKbn extends AbstractUserType<C_SelHokensyuruiKbn> {

    @Override
    protected Class<C_SelHokensyuruiKbn> returnType() {
        return C_SelHokensyuruiKbn.class;
    }

    @Override
    protected C_SelHokensyuruiKbn valueOf(String pValue) {
        return C_SelHokensyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SelHokensyuruiKbn pValue) {
        return pValue.getValue();
    }
}
