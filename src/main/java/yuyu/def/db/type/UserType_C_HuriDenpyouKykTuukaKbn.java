package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HuriDenpyouKykTuukaKbn;

/**
 * {@link C_HuriDenpyouKykTuukaKbn 振替伝票用契約通貨区分} の Hibernate ユーザー定義型です。<br />
 * 振替伝票用契約通貨区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HuriDenpyouKykTuukaKbn extends AbstractUserType<C_HuriDenpyouKykTuukaKbn> {

    @Override
    protected Class<C_HuriDenpyouKykTuukaKbn> returnType() {
        return C_HuriDenpyouKykTuukaKbn.class;
    }

    @Override
    protected C_HuriDenpyouKykTuukaKbn valueOf(String pValue) {
        return C_HuriDenpyouKykTuukaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HuriDenpyouKykTuukaKbn pValue) {
        return pValue.getValue();
    }
}
