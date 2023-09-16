package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NaihousotozuketkKbn;

/**
 * {@link C_NaihousotozuketkKbn 内包外付特約区分} の Hibernate ユーザー定義型です。<br />
 * 内包外付特約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NaihousotozuketkKbn extends AbstractUserType<C_NaihousotozuketkKbn> {

    @Override
    protected Class<C_NaihousotozuketkKbn> returnType() {
        return C_NaihousotozuketkKbn.class;
    }

    @Override
    protected C_NaihousotozuketkKbn valueOf(String pValue) {
        return C_NaihousotozuketkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NaihousotozuketkKbn pValue) {
        return pValue.getValue();
    }
}
