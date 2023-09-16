package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;

/**
 * {@link C_Kjsmhakkouzumiflg 控除証明書発行済フラグ} の Hibernate ユーザー定義型です。<br />
 * 控除証明書発行済フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kjsmhakkouzumiflg extends AbstractUserType<C_Kjsmhakkouzumiflg> {

    @Override
    protected Class<C_Kjsmhakkouzumiflg> returnType() {
        return C_Kjsmhakkouzumiflg.class;
    }

    @Override
    protected C_Kjsmhakkouzumiflg valueOf(String pValue) {
        return C_Kjsmhakkouzumiflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kjsmhakkouzumiflg pValue) {
        return pValue.getValue();
    }
}
