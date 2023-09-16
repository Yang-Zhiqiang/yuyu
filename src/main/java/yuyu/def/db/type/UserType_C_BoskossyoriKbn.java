package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BoskossyoriKbn;

/**
 * {@link C_BoskossyoriKbn 募集人更新処理区分} の Hibernate ユーザー定義型です。<br />
 * 募集人更新処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BoskossyoriKbn extends AbstractUserType<C_BoskossyoriKbn> {

    @Override
    protected Class<C_BoskossyoriKbn> returnType() {
        return C_BoskossyoriKbn.class;
    }

    @Override
    protected C_BoskossyoriKbn valueOf(String pValue) {
        return C_BoskossyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BoskossyoriKbn pValue) {
        return pValue.getValue();
    }
}
