package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kykkaksyrui;

/**
 * {@link C_Kykkaksyrui 契約確認種類} の Hibernate ユーザー定義型です。<br />
 * 契約確認種類 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kykkaksyrui extends AbstractUserType<C_Kykkaksyrui> {

    @Override
    protected Class<C_Kykkaksyrui> returnType() {
        return C_Kykkaksyrui.class;
    }

    @Override
    protected C_Kykkaksyrui valueOf(String pValue) {
        return C_Kykkaksyrui.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kykkaksyrui pValue) {
        return pValue.getValue();
    }
}
