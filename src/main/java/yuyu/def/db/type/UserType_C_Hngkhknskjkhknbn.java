package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hngkhknskjkhknbn;

/**
 * {@link C_Hngkhknskjkhknbn 変額保険資格受験区分} の Hibernate ユーザー定義型です。<br />
 * 変額保険資格受験区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hngkhknskjkhknbn extends AbstractUserType<C_Hngkhknskjkhknbn> {

    @Override
    protected Class<C_Hngkhknskjkhknbn> returnType() {
        return C_Hngkhknskjkhknbn.class;
    }

    @Override
    protected C_Hngkhknskjkhknbn valueOf(String pValue) {
        return C_Hngkhknskjkhknbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hngkhknskjkhknbn pValue) {
        return pValue.getValue();
    }
}
