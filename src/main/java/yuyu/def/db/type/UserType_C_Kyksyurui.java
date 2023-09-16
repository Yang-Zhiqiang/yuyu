package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kyksyurui;

/**
 * {@link C_Kyksyurui 契約者種類} の Hibernate ユーザー定義型です。<br />
 * 契約者種類 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kyksyurui extends AbstractUserType<C_Kyksyurui> {

    @Override
    protected Class<C_Kyksyurui> returnType() {
        return C_Kyksyurui.class;
    }

    @Override
    protected C_Kyksyurui valueOf(String pValue) {
        return C_Kyksyurui.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kyksyurui pValue) {
        return pValue.getValue();
    }
}
