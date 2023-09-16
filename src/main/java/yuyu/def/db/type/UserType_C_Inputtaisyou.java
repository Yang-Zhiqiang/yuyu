package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Inputtaisyou;

/**
 * {@link C_Inputtaisyou 入力対象区分} の Hibernate ユーザー定義型です。<br />
 * 入力対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Inputtaisyou extends AbstractUserType<C_Inputtaisyou> {

    @Override
    protected Class<C_Inputtaisyou> returnType() {
        return C_Inputtaisyou.class;
    }

    @Override
    protected C_Inputtaisyou valueOf(String pValue) {
        return C_Inputtaisyou.valueOf(pValue);
    }

    @Override
    protected String toString(C_Inputtaisyou pValue) {
        return pValue.getValue();
    }
}
