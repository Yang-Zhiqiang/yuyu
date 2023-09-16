package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LincdatasousinKbn;

/**
 * {@link C_LincdatasousinKbn ＬＩＮＣデータ送信区分} の Hibernate ユーザー定義型です。<br />
 * ＬＩＮＣデータ送信区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LincdatasousinKbn extends AbstractUserType<C_LincdatasousinKbn> {

    @Override
    protected Class<C_LincdatasousinKbn> returnType() {
        return C_LincdatasousinKbn.class;
    }

    @Override
    protected C_LincdatasousinKbn valueOf(String pValue) {
        return C_LincdatasousinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LincdatasousinKbn pValue) {
        return pValue.getValue();
    }
}
