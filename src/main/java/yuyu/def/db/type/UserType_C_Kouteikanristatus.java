package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kouteikanristatus;

/**
 * {@link C_Kouteikanristatus 工程管理状況} の Hibernate ユーザー定義型です。<br />
 * 工程管理状況 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kouteikanristatus extends AbstractUserType<C_Kouteikanristatus> {

    @Override
    protected Class<C_Kouteikanristatus> returnType() {
        return C_Kouteikanristatus.class;
    }

    @Override
    protected C_Kouteikanristatus valueOf(String pValue) {
        return C_Kouteikanristatus.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kouteikanristatus pValue) {
        return pValue.getValue();
    }
}
