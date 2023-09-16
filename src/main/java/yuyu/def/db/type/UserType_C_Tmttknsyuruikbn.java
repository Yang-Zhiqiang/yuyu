package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tmttknsyuruikbn;

/**
 * {@link C_Tmttknsyuruikbn 積立金種類区分} の Hibernate ユーザー定義型です。<br />
 * 積立金種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tmttknsyuruikbn extends AbstractUserType<C_Tmttknsyuruikbn> {

    @Override
    protected Class<C_Tmttknsyuruikbn> returnType() {
        return C_Tmttknsyuruikbn.class;
    }

    @Override
    protected C_Tmttknsyuruikbn valueOf(String pValue) {
        return C_Tmttknsyuruikbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tmttknsyuruikbn pValue) {
        return pValue.getValue();
    }
}
