package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykkakkekKbn;

/**
 * {@link C_KykkakkekKbn 契約確認結果区分} の Hibernate ユーザー定義型です。<br />
 * 契約確認結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykkakkekKbn extends AbstractUserType<C_KykkakkekKbn> {

    @Override
    protected Class<C_KykkakkekKbn> returnType() {
        return C_KykkakkekKbn.class;
    }

    @Override
    protected C_KykkakkekKbn valueOf(String pValue) {
        return C_KykkakkekKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykkakkekKbn pValue) {
        return pValue.getValue();
    }
}
