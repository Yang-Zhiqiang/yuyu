package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TumitateDSakuseiKbn;

/**
 * {@link C_TumitateDSakuseiKbn 積立Ｄ作成区分} の Hibernate ユーザー定義型です。<br />
 * 積立Ｄ作成区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TumitateDSakuseiKbn extends AbstractUserType<C_TumitateDSakuseiKbn> {

    @Override
    protected Class<C_TumitateDSakuseiKbn> returnType() {
        return C_TumitateDSakuseiKbn.class;
    }

    @Override
    protected C_TumitateDSakuseiKbn valueOf(String pValue) {
        return C_TumitateDSakuseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TumitateDSakuseiKbn pValue) {
        return pValue.getValue();
    }
}
