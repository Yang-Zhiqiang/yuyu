package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;

/**
 * {@link C_TargetTkHukaKanouKbn ターゲット特約付加可能区分} の Hibernate ユーザー定義型です。<br />
 * ターゲット特約付加可能区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TargetTkHukaKanouKbn extends AbstractUserType<C_TargetTkHukaKanouKbn> {

    @Override
    protected Class<C_TargetTkHukaKanouKbn> returnType() {
        return C_TargetTkHukaKanouKbn.class;
    }

    @Override
    protected C_TargetTkHukaKanouKbn valueOf(String pValue) {
        return C_TargetTkHukaKanouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TargetTkHukaKanouKbn pValue) {
        return pValue.getValue();
    }
}
