package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SosikimasterUmuKbn;

/**
 * {@link C_SosikimasterUmuKbn 組織マスタ有無区分} の Hibernate ユーザー定義型です。<br />
 * 組織マスタ有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SosikimasterUmuKbn extends AbstractUserType<C_SosikimasterUmuKbn> {

    @Override
    protected Class<C_SosikimasterUmuKbn> returnType() {
        return C_SosikimasterUmuKbn.class;
    }

    @Override
    protected C_SosikimasterUmuKbn valueOf(String pValue) {
        return C_SosikimasterUmuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SosikimasterUmuKbn pValue) {
        return pValue.getValue();
    }
}
