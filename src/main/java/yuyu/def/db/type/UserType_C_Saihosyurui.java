package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Saihosyurui;

/**
 * {@link C_Saihosyurui 再保種類} の Hibernate ユーザー定義型です。<br />
 * 再保種類 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Saihosyurui extends AbstractUserType<C_Saihosyurui> {

    @Override
    protected Class<C_Saihosyurui> returnType() {
        return C_Saihosyurui.class;
    }

    @Override
    protected C_Saihosyurui valueOf(String pValue) {
        return C_Saihosyurui.valueOf(pValue);
    }

    @Override
    protected String toString(C_Saihosyurui pValue) {
        return pValue.getValue();
    }
}
