package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Knkysatei1jiyhKbn;

/**
 * {@link C_Knkysatei1jiyhKbn 環境査定（１次）要否区分} の Hibernate ユーザー定義型です。<br />
 * 環境査定（１次）要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Knkysatei1jiyhKbn extends AbstractUserType<C_Knkysatei1jiyhKbn> {

    @Override
    protected Class<C_Knkysatei1jiyhKbn> returnType() {
        return C_Knkysatei1jiyhKbn.class;
    }

    @Override
    protected C_Knkysatei1jiyhKbn valueOf(String pValue) {
        return C_Knkysatei1jiyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Knkysatei1jiyhKbn pValue) {
        return pValue.getValue();
    }
}
