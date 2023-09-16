package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AeoisnsiKbn;

/**
 * {@link C_AeoisnsiKbn ＡＥＯＩ宣誓区分} の Hibernate ユーザー定義型です。<br />
 * ＡＥＯＩ宣誓区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AeoisnsiKbn extends AbstractUserType<C_AeoisnsiKbn> {

    @Override
    protected Class<C_AeoisnsiKbn> returnType() {
        return C_AeoisnsiKbn.class;
    }

    @Override
    protected C_AeoisnsiKbn valueOf(String pValue) {
        return C_AeoisnsiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AeoisnsiKbn pValue) {
        return pValue.getValue();
    }
}
