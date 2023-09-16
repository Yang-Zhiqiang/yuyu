package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tuukasyu;

/**
 * {@link C_Tuukasyu 通貨種類} の Hibernate ユーザー定義型です。<br />
 * 通貨種類 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tuukasyu extends AbstractUserType<C_Tuukasyu> {

    @Override
    protected Class<C_Tuukasyu> returnType() {
        return C_Tuukasyu.class;
    }

    @Override
    protected C_Tuukasyu valueOf(String pValue) {
        return C_Tuukasyu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tuukasyu pValue) {
        return pValue.getValue();
    }
}
