package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;

/**
 * {@link C_HrkmnykndatarenmotoKbn 振込入金データ連携元区分} の Hibernate ユーザー定義型です。<br />
 * 振込入金データ連携元区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HrkmnykndatarenmotoKbn extends AbstractUserType<C_HrkmnykndatarenmotoKbn> {

    @Override
    protected Class<C_HrkmnykndatarenmotoKbn> returnType() {
        return C_HrkmnykndatarenmotoKbn.class;
    }

    @Override
    protected C_HrkmnykndatarenmotoKbn valueOf(String pValue) {
        return C_HrkmnykndatarenmotoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HrkmnykndatarenmotoKbn pValue) {
        return pValue.getValue();
    }
}
