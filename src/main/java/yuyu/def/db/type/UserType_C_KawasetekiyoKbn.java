package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KawasetekiyoKbn;

/**
 * {@link C_KawasetekiyoKbn 為替適用区分} の Hibernate ユーザー定義型です。<br />
 * 為替適用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KawasetekiyoKbn extends AbstractUserType<C_KawasetekiyoKbn> {

    @Override
    protected Class<C_KawasetekiyoKbn> returnType() {
        return C_KawasetekiyoKbn.class;
    }

    @Override
    protected C_KawasetekiyoKbn valueOf(String pValue) {
        return C_KawasetekiyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KawasetekiyoKbn pValue) {
        return pValue.getValue();
    }
}
