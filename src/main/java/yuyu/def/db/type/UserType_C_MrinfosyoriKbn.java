package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MrinfosyoriKbn;

/**
 * {@link C_MrinfosyoriKbn ＭＲ情報処理区分} の Hibernate ユーザー定義型です。<br />
 * ＭＲ情報処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MrinfosyoriKbn extends AbstractUserType<C_MrinfosyoriKbn> {

    @Override
    protected Class<C_MrinfosyoriKbn> returnType() {
        return C_MrinfosyoriKbn.class;
    }

    @Override
    protected C_MrinfosyoriKbn valueOf(String pValue) {
        return C_MrinfosyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MrinfosyoriKbn pValue) {
        return pValue.getValue();
    }
}
