package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BosyuuitijimtrkKbn;

/**
 * {@link C_BosyuuitijimtrkKbn 募集人一事務所登録区分} の Hibernate ユーザー定義型です。<br />
 * 募集人一事務所登録区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BosyuuitijimtrkKbn extends AbstractUserType<C_BosyuuitijimtrkKbn> {

    @Override
    protected Class<C_BosyuuitijimtrkKbn> returnType() {
        return C_BosyuuitijimtrkKbn.class;
    }

    @Override
    protected C_BosyuuitijimtrkKbn valueOf(String pValue) {
        return C_BosyuuitijimtrkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BosyuuitijimtrkKbn pValue) {
        return pValue.getValue();
    }
}
