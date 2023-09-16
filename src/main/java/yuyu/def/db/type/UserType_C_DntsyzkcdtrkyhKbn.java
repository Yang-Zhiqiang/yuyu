package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DntsyzkcdtrkyhKbn;

/**
 * {@link C_DntsyzkcdtrkyhKbn 団体所属コード登録要否区分} の Hibernate ユーザー定義型です。<br />
 * 団体所属コード登録要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DntsyzkcdtrkyhKbn extends AbstractUserType<C_DntsyzkcdtrkyhKbn> {

    @Override
    protected Class<C_DntsyzkcdtrkyhKbn> returnType() {
        return C_DntsyzkcdtrkyhKbn.class;
    }

    @Override
    protected C_DntsyzkcdtrkyhKbn valueOf(String pValue) {
        return C_DntsyzkcdtrkyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DntsyzkcdtrkyhKbn pValue) {
        return pValue.getValue();
    }
}
