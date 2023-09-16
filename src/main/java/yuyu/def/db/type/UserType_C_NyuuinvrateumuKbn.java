package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyuuinvrateumuKbn;

/**
 * {@link C_NyuuinvrateumuKbn 入院Ｖレート有無区分} の Hibernate ユーザー定義型です。<br />
 * 入院Ｖレート有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyuuinvrateumuKbn extends AbstractUserType<C_NyuuinvrateumuKbn> {

    @Override
    protected Class<C_NyuuinvrateumuKbn> returnType() {
        return C_NyuuinvrateumuKbn.class;
    }

    @Override
    protected C_NyuuinvrateumuKbn valueOf(String pValue) {
        return C_NyuuinvrateumuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyuuinvrateumuKbn pValue) {
        return pValue.getValue();
    }
}
