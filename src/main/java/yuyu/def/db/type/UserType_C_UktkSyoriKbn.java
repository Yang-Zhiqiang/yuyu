package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UktkSyoriKbn;

/**
 * {@link C_UktkSyoriKbn 受付処理区分} の Hibernate ユーザー定義型です。<br />
 * 受付処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UktkSyoriKbn extends AbstractUserType<C_UktkSyoriKbn> {

    @Override
    protected Class<C_UktkSyoriKbn> returnType() {
        return C_UktkSyoriKbn.class;
    }

    @Override
    protected C_UktkSyoriKbn valueOf(String pValue) {
        return C_UktkSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UktkSyoriKbn pValue) {
        return pValue.getValue();
    }
}
