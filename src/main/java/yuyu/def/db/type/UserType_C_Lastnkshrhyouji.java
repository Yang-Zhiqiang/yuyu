package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Lastnkshrhyouji;

/**
 * {@link C_Lastnkshrhyouji 最終年金支払表示} の Hibernate ユーザー定義型です。<br />
 * 最終年金支払表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Lastnkshrhyouji extends AbstractUserType<C_Lastnkshrhyouji> {

    @Override
    protected Class<C_Lastnkshrhyouji> returnType() {
        return C_Lastnkshrhyouji.class;
    }

    @Override
    protected C_Lastnkshrhyouji valueOf(String pValue) {
        return C_Lastnkshrhyouji.valueOf(pValue);
    }

    @Override
    protected String toString(C_Lastnkshrhyouji pValue) {
        return pValue.getValue();
    }
}
