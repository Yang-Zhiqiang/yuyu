package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykNaiyouTeiseiSyoriKbn;

/**
 * {@link C_KykNaiyouTeiseiSyoriKbn 契約内容訂正処理区分} の Hibernate ユーザー定義型です。<br />
 * 契約内容訂正処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykNaiyouTeiseiSyoriKbn extends AbstractUserType<C_KykNaiyouTeiseiSyoriKbn> {

    @Override
    protected Class<C_KykNaiyouTeiseiSyoriKbn> returnType() {
        return C_KykNaiyouTeiseiSyoriKbn.class;
    }

    @Override
    protected C_KykNaiyouTeiseiSyoriKbn valueOf(String pValue) {
        return C_KykNaiyouTeiseiSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykNaiyouTeiseiSyoriKbn pValue) {
        return pValue.getValue();
    }
}
