package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tyhysksitisy;

/**
 * {@link C_Tyhysksitisy 帳票作成対象区分} の Hibernate ユーザー定義型です。<br />
 * 帳票作成対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tyhysksitisy extends AbstractUserType<C_Tyhysksitisy> {

    @Override
    protected Class<C_Tyhysksitisy> returnType() {
        return C_Tyhysksitisy.class;
    }

    @Override
    protected C_Tyhysksitisy valueOf(String pValue) {
        return C_Tyhysksitisy.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tyhysksitisy pValue) {
        return pValue.getValue();
    }
}
