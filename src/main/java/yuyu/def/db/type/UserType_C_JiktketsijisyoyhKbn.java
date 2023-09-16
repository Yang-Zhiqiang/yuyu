package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JiktketsijisyoyhKbn;

/**
 * {@link C_JiktketsijisyoyhKbn 事業一括決定指示書要否区分} の Hibernate ユーザー定義型です。<br />
 * 事業一括決定指示書要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JiktketsijisyoyhKbn extends AbstractUserType<C_JiktketsijisyoyhKbn> {

    @Override
    protected Class<C_JiktketsijisyoyhKbn> returnType() {
        return C_JiktketsijisyoyhKbn.class;
    }

    @Override
    protected C_JiktketsijisyoyhKbn valueOf(String pValue) {
        return C_JiktketsijisyoyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JiktketsijisyoyhKbn pValue) {
        return pValue.getValue();
    }
}
