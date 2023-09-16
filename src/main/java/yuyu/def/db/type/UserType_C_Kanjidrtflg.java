package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kanjidrtflg;

/**
 * {@link C_Kanjidrtflg 幹事代理店フラグ} の Hibernate ユーザー定義型です。<br />
 * 幹事代理店フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kanjidrtflg extends AbstractUserType<C_Kanjidrtflg> {

    @Override
    protected Class<C_Kanjidrtflg> returnType() {
        return C_Kanjidrtflg.class;
    }

    @Override
    protected C_Kanjidrtflg valueOf(String pValue) {
        return C_Kanjidrtflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kanjidrtflg pValue) {
        return pValue.getValue();
    }
}
