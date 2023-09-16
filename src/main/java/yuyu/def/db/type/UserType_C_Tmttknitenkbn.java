package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tmttknitenkbn;

/**
 * {@link C_Tmttknitenkbn 積立金移転区分} の Hibernate ユーザー定義型です。<br />
 * 積立金移転区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tmttknitenkbn extends AbstractUserType<C_Tmttknitenkbn> {

    @Override
    protected Class<C_Tmttknitenkbn> returnType() {
        return C_Tmttknitenkbn.class;
    }

    @Override
    protected C_Tmttknitenkbn valueOf(String pValue) {
        return C_Tmttknitenkbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tmttknitenkbn pValue) {
        return pValue.getValue();
    }
}
