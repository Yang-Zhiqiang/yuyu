package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RateGetErrorKbn;

/**
 * {@link C_RateGetErrorKbn レート取得エラー区分} の Hibernate ユーザー定義型です。<br />
 * レート取得エラー区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RateGetErrorKbn extends AbstractUserType<C_RateGetErrorKbn> {

    @Override
    protected Class<C_RateGetErrorKbn> returnType() {
        return C_RateGetErrorKbn.class;
    }

    @Override
    protected C_RateGetErrorKbn valueOf(String pValue) {
        return C_RateGetErrorKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RateGetErrorKbn pValue) {
        return pValue.getValue();
    }
}
