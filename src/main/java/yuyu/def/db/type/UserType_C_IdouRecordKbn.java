package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IdouRecordKbn;

/**
 * {@link C_IdouRecordKbn 異動レコード区分} の Hibernate ユーザー定義型です。<br />
 * 異動レコード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IdouRecordKbn extends AbstractUserType<C_IdouRecordKbn> {

    @Override
    protected Class<C_IdouRecordKbn> returnType() {
        return C_IdouRecordKbn.class;
    }

    @Override
    protected C_IdouRecordKbn valueOf(String pValue) {
        return C_IdouRecordKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IdouRecordKbn pValue) {
        return pValue.getValue();
    }
}
