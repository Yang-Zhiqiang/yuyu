package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tkyksyurui;

/**
 * {@link C_Tkyksyurui 特約種類} の Hibernate ユーザー定義型です。<br />
 * 特約種類 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tkyksyurui extends AbstractUserType<C_Tkyksyurui> {

    @Override
    protected Class<C_Tkyksyurui> returnType() {
        return C_Tkyksyurui.class;
    }

    @Override
    protected C_Tkyksyurui valueOf(String pValue) {
        return C_Tkyksyurui.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tkyksyurui pValue) {
        return pValue.getValue();
    }
}
