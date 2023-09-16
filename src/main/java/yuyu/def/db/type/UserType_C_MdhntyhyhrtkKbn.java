package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MdhntyhyhrtkKbn;

/**
 * {@link C_MdhntyhyhrtkKbn 窓販帳票配列区分} の Hibernate ユーザー定義型です。<br />
 * 窓販帳票配列区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MdhntyhyhrtkKbn extends AbstractUserType<C_MdhntyhyhrtkKbn> {

    @Override
    protected Class<C_MdhntyhyhrtkKbn> returnType() {
        return C_MdhntyhyhrtkKbn.class;
    }

    @Override
    protected C_MdhntyhyhrtkKbn valueOf(String pValue) {
        return C_MdhntyhyhrtkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MdhntyhyhrtkKbn pValue) {
        return pValue.getValue();
    }
}
