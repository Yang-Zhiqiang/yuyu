package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RecordsyuruiKbn;

/**
 * {@link C_RecordsyuruiKbn レコード種類区分} の Hibernate ユーザー定義型です。<br />
 * レコード種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RecordsyuruiKbn extends AbstractUserType<C_RecordsyuruiKbn> {

    @Override
    protected Class<C_RecordsyuruiKbn> returnType() {
        return C_RecordsyuruiKbn.class;
    }

    @Override
    protected C_RecordsyuruiKbn valueOf(String pValue) {
        return C_RecordsyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RecordsyuruiKbn pValue) {
        return pValue.getValue();
    }
}
