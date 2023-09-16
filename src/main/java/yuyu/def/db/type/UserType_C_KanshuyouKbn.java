package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KanshuyouKbn;

/**
 * {@link C_KanshuyouKbn 勧奨不要区分} の Hibernate ユーザー定義型です。<br />
 * 勧奨不要区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KanshuyouKbn extends AbstractUserType<C_KanshuyouKbn> {

    @Override
    protected Class<C_KanshuyouKbn> returnType() {
        return C_KanshuyouKbn.class;
    }

    @Override
    protected C_KanshuyouKbn valueOf(String pValue) {
        return C_KanshuyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KanshuyouKbn pValue) {
        return pValue.getValue();
    }
}
