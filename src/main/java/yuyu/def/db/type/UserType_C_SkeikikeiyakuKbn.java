package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SkeikikeiyakuKbn;

/**
 * {@link C_SkeikikeiyakuKbn 新契約既契約区分} の Hibernate ユーザー定義型です。<br />
 * 新契約既契約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SkeikikeiyakuKbn extends AbstractUserType<C_SkeikikeiyakuKbn> {

    @Override
    protected Class<C_SkeikikeiyakuKbn> returnType() {
        return C_SkeikikeiyakuKbn.class;
    }

    @Override
    protected C_SkeikikeiyakuKbn valueOf(String pValue) {
        return C_SkeikikeiyakuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SkeikikeiyakuKbn pValue) {
        return pValue.getValue();
    }
}
