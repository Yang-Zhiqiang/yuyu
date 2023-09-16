package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TargetTkHenkouKbn;

/**
 * {@link C_TargetTkHenkouKbn ターゲット特約変更区分} の Hibernate ユーザー定義型です。<br />
 * ターゲット特約変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TargetTkHenkouKbn extends AbstractUserType<C_TargetTkHenkouKbn> {

    @Override
    protected Class<C_TargetTkHenkouKbn> returnType() {
        return C_TargetTkHenkouKbn.class;
    }

    @Override
    protected C_TargetTkHenkouKbn valueOf(String pValue) {
        return C_TargetTkHenkouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TargetTkHenkouKbn pValue) {
        return pValue.getValue();
    }
}
