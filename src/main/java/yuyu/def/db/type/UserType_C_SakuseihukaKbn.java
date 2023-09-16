package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SakuseihukaKbn;

/**
 * {@link C_SakuseihukaKbn 作成不可区分} の Hibernate ユーザー定義型です。<br />
 * 作成不可区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SakuseihukaKbn extends AbstractUserType<C_SakuseihukaKbn> {

    @Override
    protected Class<C_SakuseihukaKbn> returnType() {
        return C_SakuseihukaKbn.class;
    }

    @Override
    protected C_SakuseihukaKbn valueOf(String pValue) {
        return C_SakuseihukaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SakuseihukaKbn pValue) {
        return pValue.getValue();
    }
}
