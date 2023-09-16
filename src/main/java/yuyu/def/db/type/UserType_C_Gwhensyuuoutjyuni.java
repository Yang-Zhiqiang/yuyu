package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Gwhensyuuoutjyuni;

/**
 * {@link C_Gwhensyuuoutjyuni ＧＷ編集出力順位} の Hibernate ユーザー定義型です。<br />
 * ＧＷ編集出力順位 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Gwhensyuuoutjyuni extends AbstractUserType<C_Gwhensyuuoutjyuni> {

    @Override
    protected Class<C_Gwhensyuuoutjyuni> returnType() {
        return C_Gwhensyuuoutjyuni.class;
    }

    @Override
    protected C_Gwhensyuuoutjyuni valueOf(String pValue) {
        return C_Gwhensyuuoutjyuni.valueOf(pValue);
    }

    @Override
    protected String toString(C_Gwhensyuuoutjyuni pValue) {
        return pValue.getValue();
    }
}
