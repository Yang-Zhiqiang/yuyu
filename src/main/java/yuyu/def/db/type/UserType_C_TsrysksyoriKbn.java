package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsrysksyoriKbn;

/**
 * {@link C_TsrysksyoriKbn 手数料集計処理区分} の Hibernate ユーザー定義型です。<br />
 * 手数料集計処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsrysksyoriKbn extends AbstractUserType<C_TsrysksyoriKbn> {

    @Override
    protected Class<C_TsrysksyoriKbn> returnType() {
        return C_TsrysksyoriKbn.class;
    }

    @Override
    protected C_TsrysksyoriKbn valueOf(String pValue) {
        return C_TsrysksyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsrysksyoriKbn pValue) {
        return pValue.getValue();
    }
}
