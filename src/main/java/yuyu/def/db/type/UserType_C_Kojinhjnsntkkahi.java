package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kojinhjnsntkkahi;

/**
 * {@link C_Kojinhjnsntkkahi 個人法人選択可否} の Hibernate ユーザー定義型です。<br />
 * 個人法人選択可否 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kojinhjnsntkkahi extends AbstractUserType<C_Kojinhjnsntkkahi> {

    @Override
    protected Class<C_Kojinhjnsntkkahi> returnType() {
        return C_Kojinhjnsntkkahi.class;
    }

    @Override
    protected C_Kojinhjnsntkkahi valueOf(String pValue) {
        return C_Kojinhjnsntkkahi.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kojinhjnsntkkahi pValue) {
        return pValue.getValue();
    }
}
