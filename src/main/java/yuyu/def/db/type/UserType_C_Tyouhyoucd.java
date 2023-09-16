package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tyouhyoucd;

/**
 * {@link C_Tyouhyoucd 帳票コード} の Hibernate ユーザー定義型です。<br />
 * 帳票コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tyouhyoucd extends AbstractUserType<C_Tyouhyoucd> {

    @Override
    protected Class<C_Tyouhyoucd> returnType() {
        return C_Tyouhyoucd.class;
    }

    @Override
    protected C_Tyouhyoucd valueOf(String pValue) {
        return C_Tyouhyoucd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tyouhyoucd pValue) {
        return pValue.getValue();
    }
}
