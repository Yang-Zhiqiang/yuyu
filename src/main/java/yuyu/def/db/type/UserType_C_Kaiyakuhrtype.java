package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kaiyakuhrtype;

/**
 * {@link C_Kaiyakuhrtype 解約返戻金支払タイプ} の Hibernate ユーザー定義型です。<br />
 * 解約返戻金支払タイプ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kaiyakuhrtype extends AbstractUserType<C_Kaiyakuhrtype> {

    @Override
    protected Class<C_Kaiyakuhrtype> returnType() {
        return C_Kaiyakuhrtype.class;
    }

    @Override
    protected C_Kaiyakuhrtype valueOf(String pValue) {
        return C_Kaiyakuhrtype.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kaiyakuhrtype pValue) {
        return pValue.getValue();
    }
}
