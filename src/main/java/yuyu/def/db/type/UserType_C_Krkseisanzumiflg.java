package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Krkseisanzumiflg;

/**
 * {@link C_Krkseisanzumiflg 仮受精算済フラグ} の Hibernate ユーザー定義型です。<br />
 * 仮受精算済フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Krkseisanzumiflg extends AbstractUserType<C_Krkseisanzumiflg> {

    @Override
    protected Class<C_Krkseisanzumiflg> returnType() {
        return C_Krkseisanzumiflg.class;
    }

    @Override
    protected C_Krkseisanzumiflg valueOf(String pValue) {
        return C_Krkseisanzumiflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Krkseisanzumiflg pValue) {
        return pValue.getValue();
    }
}
