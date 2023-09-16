package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Sbuktnin;

/**
 * {@link C_Sbuktnin 死亡受取人人数} の Hibernate ユーザー定義型です。<br />
 * 死亡受取人人数 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Sbuktnin extends AbstractUserType<C_Sbuktnin> {

    @Override
    protected Class<C_Sbuktnin> returnType() {
        return C_Sbuktnin.class;
    }

    @Override
    protected C_Sbuktnin valueOf(String pValue) {
        return C_Sbuktnin.valueOf(pValue);
    }

    @Override
    protected String toString(C_Sbuktnin pValue) {
        return pValue.getValue();
    }
}
