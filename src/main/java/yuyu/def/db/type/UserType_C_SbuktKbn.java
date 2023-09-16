package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SbuktKbn;

/**
 * {@link C_SbuktKbn 死亡受取人区分} の Hibernate ユーザー定義型です。<br />
 * 死亡受取人区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SbuktKbn extends AbstractUserType<C_SbuktKbn> {

    @Override
    protected Class<C_SbuktKbn> returnType() {
        return C_SbuktKbn.class;
    }

    @Override
    protected C_SbuktKbn valueOf(String pValue) {
        return C_SbuktKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SbuktKbn pValue) {
        return pValue.getValue();
    }
}
