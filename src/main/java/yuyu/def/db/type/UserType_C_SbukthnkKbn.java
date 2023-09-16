package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SbukthnkKbn;

/**
 * {@link C_SbukthnkKbn 死亡・受取人変更区分} の Hibernate ユーザー定義型です。<br />
 * 死亡・受取人変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SbukthnkKbn extends AbstractUserType<C_SbukthnkKbn> {

    @Override
    protected Class<C_SbukthnkKbn> returnType() {
        return C_SbukthnkKbn.class;
    }

    @Override
    protected C_SbukthnkKbn valueOf(String pValue) {
        return C_SbukthnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SbukthnkKbn pValue) {
        return pValue.getValue();
    }
}
