package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kktyhysksitisy;

/**
 * {@link C_Kktyhysksitisy 契約管理帳票作成対象区分} の Hibernate ユーザー定義型です。<br />
 * 契約管理帳票作成対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kktyhysksitisy extends AbstractUserType<C_Kktyhysksitisy> {

    @Override
    protected Class<C_Kktyhysksitisy> returnType() {
        return C_Kktyhysksitisy.class;
    }

    @Override
    protected C_Kktyhysksitisy valueOf(String pValue) {
        return C_Kktyhysksitisy.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kktyhysksitisy pValue) {
        return pValue.getValue();
    }
}
