package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SouhusakiKbn;

/**
 * {@link C_SouhusakiKbn 送付先区分} の Hibernate ユーザー定義型です。<br />
 * 送付先区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SouhusakiKbn extends AbstractUserType<C_SouhusakiKbn> {

    @Override
    protected Class<C_SouhusakiKbn> returnType() {
        return C_SouhusakiKbn.class;
    }

    @Override
    protected C_SouhusakiKbn valueOf(String pValue) {
        return C_SouhusakiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SouhusakiKbn pValue) {
        return pValue.getValue();
    }
}
