package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;

/**
 * {@link C_TargetTkMokuhyoutiKbn ターゲット特約目標値区分} の Hibernate ユーザー定義型です。<br />
 * ターゲット特約目標値区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TargetTkMokuhyoutiKbn extends AbstractUserType<C_TargetTkMokuhyoutiKbn> {

    @Override
    protected Class<C_TargetTkMokuhyoutiKbn> returnType() {
        return C_TargetTkMokuhyoutiKbn.class;
    }

    @Override
    protected C_TargetTkMokuhyoutiKbn valueOf(String pValue) {
        return C_TargetTkMokuhyoutiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TargetTkMokuhyoutiKbn pValue) {
        return pValue.getValue();
    }
}
