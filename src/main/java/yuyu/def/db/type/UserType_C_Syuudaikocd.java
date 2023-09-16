package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Syuudaikocd;

/**
 * {@link C_Syuudaikocd 収納代行社コード} の Hibernate ユーザー定義型です。<br />
 * 収納代行社コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Syuudaikocd extends AbstractUserType<C_Syuudaikocd> {

    @Override
    protected Class<C_Syuudaikocd> returnType() {
        return C_Syuudaikocd.class;
    }

    @Override
    protected C_Syuudaikocd valueOf(String pValue) {
        return C_Syuudaikocd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Syuudaikocd pValue) {
        return pValue.getValue();
    }
}
