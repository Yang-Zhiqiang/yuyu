package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Rendouhousiki;

/**
 * {@link C_Rendouhousiki 連動方式} の Hibernate ユーザー定義型です。<br />
 * 連動方式 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Rendouhousiki extends AbstractUserType<C_Rendouhousiki> {

    @Override
    protected Class<C_Rendouhousiki> returnType() {
        return C_Rendouhousiki.class;
    }

    @Override
    protected C_Rendouhousiki valueOf(String pValue) {
        return C_Rendouhousiki.valueOf(pValue);
    }

    @Override
    protected String toString(C_Rendouhousiki pValue) {
        return pValue.getValue();
    }
}
