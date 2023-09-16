package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Documentstatus;

/**
 * {@link C_Documentstatus ドキュメント状況} の Hibernate ユーザー定義型です。<br />
 * ドキュメント状況 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Documentstatus extends AbstractUserType<C_Documentstatus> {

    @Override
    protected Class<C_Documentstatus> returnType() {
        return C_Documentstatus.class;
    }

    @Override
    protected C_Documentstatus valueOf(String pValue) {
        return C_Documentstatus.valueOf(pValue);
    }

    @Override
    protected String toString(C_Documentstatus pValue) {
        return pValue.getValue();
    }
}
