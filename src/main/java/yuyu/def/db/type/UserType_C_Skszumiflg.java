package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Skszumiflg;

/**
 * {@link C_Skszumiflg 作成済フラグ} の Hibernate ユーザー定義型です。<br />
 * 作成済フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Skszumiflg extends AbstractUserType<C_Skszumiflg> {

    @Override
    protected Class<C_Skszumiflg> returnType() {
        return C_Skszumiflg.class;
    }

    @Override
    protected C_Skszumiflg valueOf(String pValue) {
        return C_Skszumiflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Skszumiflg pValue) {
        return pValue.getValue();
    }
}
