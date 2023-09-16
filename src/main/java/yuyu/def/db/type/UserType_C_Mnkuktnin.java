package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Mnkuktnin;

/**
 * {@link C_Mnkuktnin 満期受取人人数} の Hibernate ユーザー定義型です。<br />
 * 満期受取人人数 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Mnkuktnin extends AbstractUserType<C_Mnkuktnin> {

    @Override
    protected Class<C_Mnkuktnin> returnType() {
        return C_Mnkuktnin.class;
    }

    @Override
    protected C_Mnkuktnin valueOf(String pValue) {
        return C_Mnkuktnin.valueOf(pValue);
    }

    @Override
    protected String toString(C_Mnkuktnin pValue) {
        return pValue.getValue();
    }
}
