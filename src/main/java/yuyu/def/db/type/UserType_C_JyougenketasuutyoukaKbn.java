package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JyougenketasuutyoukaKbn;

/**
 * {@link C_JyougenketasuutyoukaKbn 上限桁数超過区分} の Hibernate ユーザー定義型です。<br />
 * 上限桁数超過区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JyougenketasuutyoukaKbn extends AbstractUserType<C_JyougenketasuutyoukaKbn> {

    @Override
    protected Class<C_JyougenketasuutyoukaKbn> returnType() {
        return C_JyougenketasuutyoukaKbn.class;
    }

    @Override
    protected C_JyougenketasuutyoukaKbn valueOf(String pValue) {
        return C_JyougenketasuutyoukaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JyougenketasuutyoukaKbn pValue) {
        return pValue.getValue();
    }
}
