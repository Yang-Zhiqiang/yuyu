package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NyskekkaKbn;

/**
 * {@link C_NyskekkaKbn 名寄せ結果区分} の Hibernate ユーザー定義型です。<br />
 * 名寄せ結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NyskekkaKbn extends AbstractUserType<C_NyskekkaKbn> {

    @Override
    protected Class<C_NyskekkaKbn> returnType() {
        return C_NyskekkaKbn.class;
    }

    @Override
    protected C_NyskekkaKbn valueOf(String pValue) {
        return C_NyskekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NyskekkaKbn pValue) {
        return pValue.getValue();
    }
}
