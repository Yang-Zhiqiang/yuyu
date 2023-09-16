package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;

/**
 * {@link C_AsTyouhyoukigouKbn 案内収納用帳票記号区分} の Hibernate ユーザー定義型です。<br />
 * 案内収納用帳票記号区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AsTyouhyoukigouKbn extends AbstractUserType<C_AsTyouhyoukigouKbn> {

    @Override
    protected Class<C_AsTyouhyoukigouKbn> returnType() {
        return C_AsTyouhyoukigouKbn.class;
    }

    @Override
    protected C_AsTyouhyoukigouKbn valueOf(String pValue) {
        return C_AsTyouhyoukigouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AsTyouhyoukigouKbn pValue) {
        return pValue.getValue();
    }
}
