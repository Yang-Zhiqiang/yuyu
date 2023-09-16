package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsSyoriKbn;

/**
 * {@link C_DsSyoriKbn ＤＳ処理区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsSyoriKbn extends AbstractUserType<C_DsSyoriKbn> {

    @Override
    protected Class<C_DsSyoriKbn> returnType() {
        return C_DsSyoriKbn.class;
    }

    @Override
    protected C_DsSyoriKbn valueOf(String pValue) {
        return C_DsSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsSyoriKbn pValue) {
        return pValue.getValue();
    }
}
