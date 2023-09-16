package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsrysyoriKbn;

/**
 * {@link C_TsrysyoriKbn 手数料処理区分} の Hibernate ユーザー定義型です。<br />
 * 手数料処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsrysyoriKbn extends AbstractUserType<C_TsrysyoriKbn> {

    @Override
    protected Class<C_TsrysyoriKbn> returnType() {
        return C_TsrysyoriKbn.class;
    }

    @Override
    protected C_TsrysyoriKbn valueOf(String pValue) {
        return C_TsrysyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsrysyoriKbn pValue) {
        return pValue.getValue();
    }
}
