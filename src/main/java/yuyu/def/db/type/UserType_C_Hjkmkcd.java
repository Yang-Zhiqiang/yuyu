package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hjkmkcd;

/**
 * {@link C_Hjkmkcd 補助科目コード} の Hibernate ユーザー定義型です。<br />
 * 補助科目コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hjkmkcd extends AbstractUserType<C_Hjkmkcd> {

    @Override
    protected Class<C_Hjkmkcd> returnType() {
        return C_Hjkmkcd.class;
    }

    @Override
    protected C_Hjkmkcd valueOf(String pValue) {
        return C_Hjkmkcd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hjkmkcd pValue) {
        return pValue.getValue();
    }
}
