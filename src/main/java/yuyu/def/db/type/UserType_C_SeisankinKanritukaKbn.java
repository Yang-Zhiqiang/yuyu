package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SeisankinKanritukaKbn;

/**
 * {@link C_SeisankinKanritukaKbn 精算金管理通貨区分} の Hibernate ユーザー定義型です。<br />
 * 精算金管理通貨区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SeisankinKanritukaKbn extends AbstractUserType<C_SeisankinKanritukaKbn> {

    @Override
    protected Class<C_SeisankinKanritukaKbn> returnType() {
        return C_SeisankinKanritukaKbn.class;
    }

    @Override
    protected C_SeisankinKanritukaKbn valueOf(String pValue) {
        return C_SeisankinKanritukaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SeisankinKanritukaKbn pValue) {
        return pValue.getValue();
    }
}
