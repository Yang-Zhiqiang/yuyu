package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Henkoukahi;

/**
 * {@link C_Henkoukahi 変更可否} の Hibernate ユーザー定義型です。<br />
 * 変更可否 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Henkoukahi extends AbstractUserType<C_Henkoukahi> {

    @Override
    protected Class<C_Henkoukahi> returnType() {
        return C_Henkoukahi.class;
    }

    @Override
    protected C_Henkoukahi valueOf(String pValue) {
        return C_Henkoukahi.valueOf(pValue);
    }

    @Override
    protected String toString(C_Henkoukahi pValue) {
        return pValue.getValue();
    }
}
