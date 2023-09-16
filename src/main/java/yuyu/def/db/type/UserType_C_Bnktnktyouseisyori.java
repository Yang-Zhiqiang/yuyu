package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Bnktnktyouseisyori;

/**
 * {@link C_Bnktnktyouseisyori 分割年金額調整処理} の Hibernate ユーザー定義型です。<br />
 * 分割年金額調整処理 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Bnktnktyouseisyori extends AbstractUserType<C_Bnktnktyouseisyori> {

    @Override
    protected Class<C_Bnktnktyouseisyori> returnType() {
        return C_Bnktnktyouseisyori.class;
    }

    @Override
    protected C_Bnktnktyouseisyori valueOf(String pValue) {
        return C_Bnktnktyouseisyori.valueOf(pValue);
    }

    @Override
    protected String toString(C_Bnktnktyouseisyori pValue) {
        return pValue.getValue();
    }
}
