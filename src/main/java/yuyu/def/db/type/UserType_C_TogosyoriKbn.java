package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TogosyoriKbn;

/**
 * {@link C_TogosyoriKbn 統合処理区分} の Hibernate ユーザー定義型です。<br />
 * 統合処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TogosyoriKbn extends AbstractUserType<C_TogosyoriKbn> {

    @Override
    protected Class<C_TogosyoriKbn> returnType() {
        return C_TogosyoriKbn.class;
    }

    @Override
    protected C_TogosyoriKbn valueOf(String pValue) {
        return C_TogosyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TogosyoriKbn pValue) {
        return pValue.getValue();
    }
}
