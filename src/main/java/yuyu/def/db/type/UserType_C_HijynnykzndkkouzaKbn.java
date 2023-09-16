package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HijynnykzndkkouzaKbn;

/**
 * {@link C_HijynnykzndkkouzaKbn 平準払入金額残高口座区分} の Hibernate ユーザー定義型です。<br />
 * 平準払入金額残高口座区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HijynnykzndkkouzaKbn extends AbstractUserType<C_HijynnykzndkkouzaKbn> {

    @Override
    protected Class<C_HijynnykzndkkouzaKbn> returnType() {
        return C_HijynnykzndkkouzaKbn.class;
    }

    @Override
    protected C_HijynnykzndkkouzaKbn valueOf(String pValue) {
        return C_HijynnykzndkkouzaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HijynnykzndkkouzaKbn pValue) {
        return pValue.getValue();
    }
}
