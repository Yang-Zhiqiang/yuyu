package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tysyteisyutflg;

/**
 * {@link C_Tysyteisyutflg 調書提出フラグ} の Hibernate ユーザー定義型です。<br />
 * 調書提出フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tysyteisyutflg extends AbstractUserType<C_Tysyteisyutflg> {

    @Override
    protected Class<C_Tysyteisyutflg> returnType() {
        return C_Tysyteisyutflg.class;
    }

    @Override
    protected C_Tysyteisyutflg valueOf(String pValue) {
        return C_Tysyteisyutflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tysyteisyutflg pValue) {
        return pValue.getValue();
    }
}
