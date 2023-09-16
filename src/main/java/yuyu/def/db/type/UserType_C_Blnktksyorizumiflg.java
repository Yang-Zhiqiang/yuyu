package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Blnktksyorizumiflg;

/**
 * {@link C_Blnktksyorizumiflg ブランク付処理済フラグ} の Hibernate ユーザー定義型です。<br />
 * ブランク付処理済フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Blnktksyorizumiflg extends AbstractUserType<C_Blnktksyorizumiflg> {

    @Override
    protected Class<C_Blnktksyorizumiflg> returnType() {
        return C_Blnktksyorizumiflg.class;
    }

    @Override
    protected C_Blnktksyorizumiflg valueOf(String pValue) {
        return C_Blnktksyorizumiflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Blnktksyorizumiflg pValue) {
        return pValue.getValue();
    }
}
