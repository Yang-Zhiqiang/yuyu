package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Mfrenflg;

/**
 * {@link C_Mfrenflg ＭＦ連動済フラグ} の Hibernate ユーザー定義型です。<br />
 * ＭＦ連動済フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Mfrenflg extends AbstractUserType<C_Mfrenflg> {

    @Override
    protected Class<C_Mfrenflg> returnType() {
        return C_Mfrenflg.class;
    }

    @Override
    protected C_Mfrenflg valueOf(String pValue) {
        return C_Mfrenflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Mfrenflg pValue) {
        return pValue.getValue();
    }
}
