package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SkkinouModeIdKbn;

/**
 * {@link C_SkkinouModeIdKbn 新契約機能モードＩＤ区分} の Hibernate ユーザー定義型です。<br />
 * 新契約機能モードＩＤ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SkkinouModeIdKbn extends AbstractUserType<C_SkkinouModeIdKbn> {

    @Override
    protected Class<C_SkkinouModeIdKbn> returnType() {
        return C_SkkinouModeIdKbn.class;
    }

    @Override
    protected C_SkkinouModeIdKbn valueOf(String pValue) {
        return C_SkkinouModeIdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SkkinouModeIdKbn pValue) {
        return pValue.getValue();
    }
}
