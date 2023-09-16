package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoriKbn;

/**
 * {@link C_SyoriKbn 処理区分} の Hibernate ユーザー定義型です。<br />
 * 処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoriKbn extends AbstractUserType<C_SyoriKbn> {

    @Override
    protected Class<C_SyoriKbn> returnType() {
        return C_SyoriKbn.class;
    }

    @Override
    protected C_SyoriKbn valueOf(String pValue) {
        return C_SyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoriKbn pValue) {
        return pValue.getValue();
    }
}
