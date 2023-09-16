package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyhySrchTuukasyu;

/**
 * {@link C_TyhySrchTuukasyu 帳票検索用通貨種類} の Hibernate ユーザー定義型です。<br />
 * 帳票検索用通貨種類 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyhySrchTuukasyu extends AbstractUserType<C_TyhySrchTuukasyu> {

    @Override
    protected Class<C_TyhySrchTuukasyu> returnType() {
        return C_TyhySrchTuukasyu.class;
    }

    @Override
    protected C_TyhySrchTuukasyu valueOf(String pValue) {
        return C_TyhySrchTuukasyu.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyhySrchTuukasyu pValue) {
        return pValue.getValue();
    }
}
