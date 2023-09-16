package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Teizounkhasuusyori;

/**
 * {@link C_Teizounkhasuusyori 逓増年金年額端数処理} の Hibernate ユーザー定義型です。<br />
 * 逓増年金年額端数処理 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Teizounkhasuusyori extends AbstractUserType<C_Teizounkhasuusyori> {

    @Override
    protected Class<C_Teizounkhasuusyori> returnType() {
        return C_Teizounkhasuusyori.class;
    }

    @Override
    protected C_Teizounkhasuusyori valueOf(String pValue) {
        return C_Teizounkhasuusyori.valueOf(pValue);
    }

    @Override
    protected String toString(C_Teizounkhasuusyori pValue) {
        return pValue.getValue();
    }
}
