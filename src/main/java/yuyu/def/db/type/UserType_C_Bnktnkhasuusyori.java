package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Bnktnkhasuusyori;

/**
 * {@link C_Bnktnkhasuusyori 分割年金額端数処理} の Hibernate ユーザー定義型です。<br />
 * 分割年金額端数処理 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Bnktnkhasuusyori extends AbstractUserType<C_Bnktnkhasuusyori> {

    @Override
    protected Class<C_Bnktnkhasuusyori> returnType() {
        return C_Bnktnkhasuusyori.class;
    }

    @Override
    protected C_Bnktnkhasuusyori valueOf(String pValue) {
        return C_Bnktnkhasuusyori.valueOf(pValue);
    }

    @Override
    protected String toString(C_Bnktnkhasuusyori pValue) {
        return pValue.getValue();
    }
}
