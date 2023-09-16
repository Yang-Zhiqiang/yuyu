package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Bntnhknsyurui;

/**
 * {@link C_Bntnhknsyurui 分担保険種類} の Hibernate ユーザー定義型です。<br />
 * 分担保険種類 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Bntnhknsyurui extends AbstractUserType<C_Bntnhknsyurui> {

    @Override
    protected Class<C_Bntnhknsyurui> returnType() {
        return C_Bntnhknsyurui.class;
    }

    @Override
    protected C_Bntnhknsyurui valueOf(String pValue) {
        return C_Bntnhknsyurui.valueOf(pValue);
    }

    @Override
    protected String toString(C_Bntnhknsyurui pValue) {
        return pValue.getValue();
    }
}
