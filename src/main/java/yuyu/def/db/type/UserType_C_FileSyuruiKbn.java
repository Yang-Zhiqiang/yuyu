package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FileSyuruiKbn;

/**
 * {@link C_FileSyuruiKbn ファイル種類区分} の Hibernate ユーザー定義型です。<br />
 * ファイル種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FileSyuruiKbn extends AbstractUserType<C_FileSyuruiKbn> {

    @Override
    protected Class<C_FileSyuruiKbn> returnType() {
        return C_FileSyuruiKbn.class;
    }

    @Override
    protected C_FileSyuruiKbn valueOf(String pValue) {
        return C_FileSyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FileSyuruiKbn pValue) {
        return pValue.getValue();
    }
}
