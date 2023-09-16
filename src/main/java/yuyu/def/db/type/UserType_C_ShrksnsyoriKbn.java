package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrksnsyoriKbn;

/**
 * {@link C_ShrksnsyoriKbn 支払計算用処理区分} の Hibernate ユーザー定義型です。<br />
 * 支払計算用処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrksnsyoriKbn extends AbstractUserType<C_ShrksnsyoriKbn> {

    @Override
    protected Class<C_ShrksnsyoriKbn> returnType() {
        return C_ShrksnsyoriKbn.class;
    }

    @Override
    protected C_ShrksnsyoriKbn valueOf(String pValue) {
        return C_ShrksnsyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrksnsyoriKbn pValue) {
        return pValue.getValue();
    }
}
