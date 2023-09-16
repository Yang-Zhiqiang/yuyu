package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrsyoriKbn;

/**
 * {@link C_ShrsyoriKbn 支払処理区分} の Hibernate ユーザー定義型です。<br />
 * 支払処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrsyoriKbn extends AbstractUserType<C_ShrsyoriKbn> {

    @Override
    protected Class<C_ShrsyoriKbn> returnType() {
        return C_ShrsyoriKbn.class;
    }

    @Override
    protected C_ShrsyoriKbn valueOf(String pValue) {
        return C_ShrsyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrsyoriKbn pValue) {
        return pValue.getValue();
    }
}
