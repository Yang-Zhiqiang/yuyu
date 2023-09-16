package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Segcd;

/**
 * {@link C_Segcd セグメントコード} の Hibernate ユーザー定義型です。<br />
 * セグメントコード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Segcd extends AbstractUserType<C_Segcd> {

    @Override
    protected Class<C_Segcd> returnType() {
        return C_Segcd.class;
    }

    @Override
    protected C_Segcd valueOf(String pValue) {
        return C_Segcd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Segcd pValue) {
        return pValue.getValue();
    }
}
