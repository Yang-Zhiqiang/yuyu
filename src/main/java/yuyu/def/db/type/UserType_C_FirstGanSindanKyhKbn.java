package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FirstGanSindanKyhKbn;

/**
 * {@link C_FirstGanSindanKyhKbn 初回がん診断給付区分} の Hibernate ユーザー定義型です。<br />
 * 初回がん診断給付区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FirstGanSindanKyhKbn extends AbstractUserType<C_FirstGanSindanKyhKbn> {

    @Override
    protected Class<C_FirstGanSindanKyhKbn> returnType() {
        return C_FirstGanSindanKyhKbn.class;
    }

    @Override
    protected C_FirstGanSindanKyhKbn valueOf(String pValue) {
        return C_FirstGanSindanKyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FirstGanSindanKyhKbn pValue) {
        return pValue.getValue();
    }
}
