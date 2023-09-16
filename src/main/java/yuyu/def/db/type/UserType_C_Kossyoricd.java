package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kossyoricd;

/**
 * {@link C_Kossyoricd 更新処理コード} の Hibernate ユーザー定義型です。<br />
 * 更新処理コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kossyoricd extends AbstractUserType<C_Kossyoricd> {

    @Override
    protected Class<C_Kossyoricd> returnType() {
        return C_Kossyoricd.class;
    }

    @Override
    protected C_Kossyoricd valueOf(String pValue) {
        return C_Kossyoricd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kossyoricd pValue) {
        return pValue.getValue();
    }
}
