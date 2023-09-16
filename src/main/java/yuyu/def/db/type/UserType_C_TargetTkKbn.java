package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TargetTkKbn;

/**
 * {@link C_TargetTkKbn ターゲット特約区分} の Hibernate ユーザー定義型です。<br />
 * ターゲット特約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TargetTkKbn extends AbstractUserType<C_TargetTkKbn> {

    @Override
    protected Class<C_TargetTkKbn> returnType() {
        return C_TargetTkKbn.class;
    }

    @Override
    protected C_TargetTkKbn valueOf(String pValue) {
        return C_TargetTkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TargetTkKbn pValue) {
        return pValue.getValue();
    }
}
