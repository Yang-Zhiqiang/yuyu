package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HijynbrKanritukaHantKbn;

/**
 * {@link C_HijynbrKanritukaHantKbn 平準払管理通貨判定区分} の Hibernate ユーザー定義型です。<br />
 * 平準払管理通貨判定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HijynbrKanritukaHantKbn extends AbstractUserType<C_HijynbrKanritukaHantKbn> {

    @Override
    protected Class<C_HijynbrKanritukaHantKbn> returnType() {
        return C_HijynbrKanritukaHantKbn.class;
    }

    @Override
    protected C_HijynbrKanritukaHantKbn valueOf(String pValue) {
        return C_HijynbrKanritukaHantKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HijynbrKanritukaHantKbn pValue) {
        return pValue.getValue();
    }
}
