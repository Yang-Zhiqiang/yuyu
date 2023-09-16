package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BosserviceKbn;

/**
 * {@link C_BosserviceKbn 募集使用サービス区分} の Hibernate ユーザー定義型です。<br />
 * 募集使用サービス区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BosserviceKbn extends AbstractUserType<C_BosserviceKbn> {

    @Override
    protected Class<C_BosserviceKbn> returnType() {
        return C_BosserviceKbn.class;
    }

    @Override
    protected C_BosserviceKbn valueOf(String pValue) {
        return C_BosserviceKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BosserviceKbn pValue) {
        return pValue.getValue();
    }
}
