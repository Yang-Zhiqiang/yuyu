package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DntkojincdtrkyhKbn;

/**
 * {@link C_DntkojincdtrkyhKbn 団体個人コード登録要否区分} の Hibernate ユーザー定義型です。<br />
 * 団体個人コード登録要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DntkojincdtrkyhKbn extends AbstractUserType<C_DntkojincdtrkyhKbn> {

    @Override
    protected Class<C_DntkojincdtrkyhKbn> returnType() {
        return C_DntkojincdtrkyhKbn.class;
    }

    @Override
    protected C_DntkojincdtrkyhKbn valueOf(String pValue) {
        return C_DntkojincdtrkyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DntkojincdtrkyhKbn pValue) {
        return pValue.getValue();
    }
}
