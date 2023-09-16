package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CreditdataKbn;

/**
 * {@link C_CreditdataKbn クレジットデータ区分} の Hibernate ユーザー定義型です。<br />
 * クレジットデータ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CreditdataKbn extends AbstractUserType<C_CreditdataKbn> {

    @Override
    protected Class<C_CreditdataKbn> returnType() {
        return C_CreditdataKbn.class;
    }

    @Override
    protected C_CreditdataKbn valueOf(String pValue) {
        return C_CreditdataKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CreditdataKbn pValue) {
        return pValue.getValue();
    }
}
