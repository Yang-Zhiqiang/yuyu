package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Nknsnp3rdsecptksnKbn;

/**
 * {@link C_Nknsnp3rdsecptksnKbn 年換算保険料（第三分野部分）計算区分} の Hibernate ユーザー定義型です。<br />
 * 年換算保険料（第三分野部分）計算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Nknsnp3rdsecptksnKbn extends AbstractUserType<C_Nknsnp3rdsecptksnKbn> {

    @Override
    protected Class<C_Nknsnp3rdsecptksnKbn> returnType() {
        return C_Nknsnp3rdsecptksnKbn.class;
    }

    @Override
    protected C_Nknsnp3rdsecptksnKbn valueOf(String pValue) {
        return C_Nknsnp3rdsecptksnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Nknsnp3rdsecptksnKbn pValue) {
        return pValue.getValue();
    }
}
