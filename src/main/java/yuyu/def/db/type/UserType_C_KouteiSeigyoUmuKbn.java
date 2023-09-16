package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KouteiSeigyoUmuKbn;

/**
 * {@link C_KouteiSeigyoUmuKbn 工程制御有無区分} の Hibernate ユーザー定義型です。<br />
 * 工程制御有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KouteiSeigyoUmuKbn extends AbstractUserType<C_KouteiSeigyoUmuKbn> {

    @Override
    protected Class<C_KouteiSeigyoUmuKbn> returnType() {
        return C_KouteiSeigyoUmuKbn.class;
    }

    @Override
    protected C_KouteiSeigyoUmuKbn valueOf(String pValue) {
        return C_KouteiSeigyoUmuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KouteiSeigyoUmuKbn pValue) {
        return pValue.getValue();
    }
}
