package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BuninfosyoriKbn;

/**
 * {@link C_BuninfosyoriKbn 分担情報処理区分} の Hibernate ユーザー定義型です。<br />
 * 分担情報処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BuninfosyoriKbn extends AbstractUserType<C_BuninfosyoriKbn> {

    @Override
    protected Class<C_BuninfosyoriKbn> returnType() {
        return C_BuninfosyoriKbn.class;
    }

    @Override
    protected C_BuninfosyoriKbn valueOf(String pValue) {
        return C_BuninfosyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BuninfosyoriKbn pValue) {
        return pValue.getValue();
    }
}
