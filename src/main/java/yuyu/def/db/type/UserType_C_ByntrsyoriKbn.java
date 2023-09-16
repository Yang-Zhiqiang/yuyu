package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ByntrsyoriKbn;

/**
 * {@link C_ByntrsyoriKbn 募集人登録処理区分} の Hibernate ユーザー定義型です。<br />
 * 募集人登録処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ByntrsyoriKbn extends AbstractUserType<C_ByntrsyoriKbn> {

    @Override
    protected Class<C_ByntrsyoriKbn> returnType() {
        return C_ByntrsyoriKbn.class;
    }

    @Override
    protected C_ByntrsyoriKbn valueOf(String pValue) {
        return C_ByntrsyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ByntrsyoriKbn pValue) {
        return pValue.getValue();
    }
}
