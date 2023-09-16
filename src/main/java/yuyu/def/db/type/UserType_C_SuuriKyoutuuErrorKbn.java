package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SuuriKyoutuuErrorKbn;

/**
 * {@link C_SuuriKyoutuuErrorKbn 数理用共通エラー区分} の Hibernate ユーザー定義型です。<br />
 * 数理用共通エラー区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SuuriKyoutuuErrorKbn extends AbstractUserType<C_SuuriKyoutuuErrorKbn> {

    @Override
    protected Class<C_SuuriKyoutuuErrorKbn> returnType() {
        return C_SuuriKyoutuuErrorKbn.class;
    }

    @Override
    protected C_SuuriKyoutuuErrorKbn valueOf(String pValue) {
        return C_SuuriKyoutuuErrorKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SuuriKyoutuuErrorKbn pValue) {
        return pValue.getValue();
    }
}
