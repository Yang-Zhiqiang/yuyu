package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FileSyuruiCdKbn;

/**
 * {@link C_FileSyuruiCdKbn ファイル種類コード区分} の Hibernate ユーザー定義型です。<br />
 * ファイル種類コード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FileSyuruiCdKbn extends AbstractUserType<C_FileSyuruiCdKbn> {

    @Override
    protected Class<C_FileSyuruiCdKbn> returnType() {
        return C_FileSyuruiCdKbn.class;
    }

    @Override
    protected C_FileSyuruiCdKbn valueOf(String pValue) {
        return C_FileSyuruiCdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FileSyuruiCdKbn pValue) {
        return pValue.getValue();
    }
}
