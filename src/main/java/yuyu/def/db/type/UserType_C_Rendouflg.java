package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Rendouflg;

/**
 * {@link C_Rendouflg 連動フラグ} の Hibernate ユーザー定義型です。<br />
 * 連動フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Rendouflg extends AbstractUserType<C_Rendouflg> {

    @Override
    protected Class<C_Rendouflg> returnType() {
        return C_Rendouflg.class;
    }

    @Override
    protected C_Rendouflg valueOf(String pValue) {
        return C_Rendouflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Rendouflg pValue) {
        return pValue.getValue();
    }
}
