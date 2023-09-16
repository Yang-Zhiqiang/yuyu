package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Syorikeiyu;

/**
 * {@link C_Syorikeiyu 処理経由区分} の Hibernate ユーザー定義型です。<br />
 * 処理経由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Syorikeiyu extends AbstractUserType<C_Syorikeiyu> {

    @Override
    protected Class<C_Syorikeiyu> returnType() {
        return C_Syorikeiyu.class;
    }

    @Override
    protected C_Syorikeiyu valueOf(String pValue) {
        return C_Syorikeiyu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Syorikeiyu pValue) {
        return pValue.getValue();
    }
}
