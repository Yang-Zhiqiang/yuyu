package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AzukarijikiKbn;

/**
 * {@link C_AzukarijikiKbn 預り時期区分} の Hibernate ユーザー定義型です。<br />
 * 預り時期区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AzukarijikiKbn extends AbstractUserType<C_AzukarijikiKbn> {

    @Override
    protected Class<C_AzukarijikiKbn> returnType() {
        return C_AzukarijikiKbn.class;
    }

    @Override
    protected C_AzukarijikiKbn valueOf(String pValue) {
        return C_AzukarijikiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AzukarijikiKbn pValue) {
        return pValue.getValue();
    }
}
