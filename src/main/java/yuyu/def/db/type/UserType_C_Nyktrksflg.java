package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Nyktrksflg;

/**
 * {@link C_Nyktrksflg 入金取消フラグ} の Hibernate ユーザー定義型です。<br />
 * 入金取消フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Nyktrksflg extends AbstractUserType<C_Nyktrksflg> {

    @Override
    protected Class<C_Nyktrksflg> returnType() {
        return C_Nyktrksflg.class;
    }

    @Override
    protected C_Nyktrksflg valueOf(String pValue) {
        return C_Nyktrksflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Nyktrksflg pValue) {
        return pValue.getValue();
    }
}
