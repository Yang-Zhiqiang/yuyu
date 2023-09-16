package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SntkinfosettaisyoKbn;

/**
 * {@link C_SntkinfosettaisyoKbn 選択情報設定対象区分} の Hibernate ユーザー定義型です。<br />
 * 選択情報設定対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SntkinfosettaisyoKbn extends AbstractUserType<C_SntkinfosettaisyoKbn> {

    @Override
    protected Class<C_SntkinfosettaisyoKbn> returnType() {
        return C_SntkinfosettaisyoKbn.class;
    }

    @Override
    protected C_SntkinfosettaisyoKbn valueOf(String pValue) {
        return C_SntkinfosettaisyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SntkinfosettaisyoKbn pValue) {
        return pValue.getValue();
    }
}
