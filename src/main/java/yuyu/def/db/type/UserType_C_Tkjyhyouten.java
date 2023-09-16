package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tkjyhyouten;

/**
 * {@link C_Tkjyhyouten 特条標点} の Hibernate ユーザー定義型です。<br />
 * 特条標点 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tkjyhyouten extends AbstractUserType<C_Tkjyhyouten> {

    @Override
    protected Class<C_Tkjyhyouten> returnType() {
        return C_Tkjyhyouten.class;
    }

    @Override
    protected C_Tkjyhyouten valueOf(String pValue) {
        return C_Tkjyhyouten.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tkjyhyouten pValue) {
        return pValue.getValue();
    }
}
