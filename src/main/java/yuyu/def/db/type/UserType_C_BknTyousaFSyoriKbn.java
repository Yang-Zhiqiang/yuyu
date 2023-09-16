package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BknTyousaFSyoriKbn;

/**
 * {@link C_BknTyousaFSyoriKbn 備金調査ファイル処理区分} の Hibernate ユーザー定義型です。<br />
 * 備金調査ファイル処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BknTyousaFSyoriKbn extends AbstractUserType<C_BknTyousaFSyoriKbn> {

    @Override
    protected Class<C_BknTyousaFSyoriKbn> returnType() {
        return C_BknTyousaFSyoriKbn.class;
    }

    @Override
    protected C_BknTyousaFSyoriKbn valueOf(String pValue) {
        return C_BknTyousaFSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BknTyousaFSyoriKbn pValue) {
        return pValue.getValue();
    }
}
