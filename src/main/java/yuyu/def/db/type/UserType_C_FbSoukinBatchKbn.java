package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FbSoukinBatchKbn;

/**
 * {@link C_FbSoukinBatchKbn ＦＢ送金バッチ区分} の Hibernate ユーザー定義型です。<br />
 * ＦＢ送金バッチ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FbSoukinBatchKbn extends AbstractUserType<C_FbSoukinBatchKbn> {

    @Override
    protected Class<C_FbSoukinBatchKbn> returnType() {
        return C_FbSoukinBatchKbn.class;
    }

    @Override
    protected C_FbSoukinBatchKbn valueOf(String pValue) {
        return C_FbSoukinBatchKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FbSoukinBatchKbn pValue) {
        return pValue.getValue();
    }
}
