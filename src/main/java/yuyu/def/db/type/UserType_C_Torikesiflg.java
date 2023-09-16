package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Torikesiflg;

/**
 * {@link C_Torikesiflg 取消フラグ} の Hibernate ユーザー定義型です。<br />
 * 取消フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Torikesiflg extends AbstractUserType<C_Torikesiflg> {

    @Override
    protected Class<C_Torikesiflg> returnType() {
        return C_Torikesiflg.class;
    }

    @Override
    protected C_Torikesiflg valueOf(String pValue) {
        return C_Torikesiflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Torikesiflg pValue) {
        return pValue.getValue();
    }
}
