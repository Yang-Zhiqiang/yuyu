package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KouseiinkykKbn;

/**
 * {@link C_KouseiinkykKbn 構成員契約区分} の Hibernate ユーザー定義型です。<br />
 * 構成員契約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KouseiinkykKbn extends AbstractUserType<C_KouseiinkykKbn> {

    @Override
    protected Class<C_KouseiinkykKbn> returnType() {
        return C_KouseiinkykKbn.class;
    }

    @Override
    protected C_KouseiinkykKbn valueOf(String pValue) {
        return C_KouseiinkykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KouseiinkykKbn pValue) {
        return pValue.getValue();
    }
}
