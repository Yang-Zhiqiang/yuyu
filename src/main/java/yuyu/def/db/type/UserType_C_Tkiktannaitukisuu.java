package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tkiktannaitukisuu;

/**
 * {@link C_Tkiktannaitukisuu 定期一括案内月数} の Hibernate ユーザー定義型です。<br />
 * 定期一括案内月数 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tkiktannaitukisuu extends AbstractUserType<C_Tkiktannaitukisuu> {

    @Override
    protected Class<C_Tkiktannaitukisuu> returnType() {
        return C_Tkiktannaitukisuu.class;
    }

    @Override
    protected C_Tkiktannaitukisuu valueOf(String pValue) {
        return C_Tkiktannaitukisuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tkiktannaitukisuu pValue) {
        return pValue.getValue();
    }
}
