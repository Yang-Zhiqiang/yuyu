package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SnkiSyunyupSyuturyokuKbn;

/**
 * {@link C_SnkiSyunyupSyuturyokuKbn 新契約収入Ｐ出力対象区分} の Hibernate ユーザー定義型です。<br />
 * 新契約収入Ｐ出力対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SnkiSyunyupSyuturyokuKbn extends AbstractUserType<C_SnkiSyunyupSyuturyokuKbn> {

    @Override
    protected Class<C_SnkiSyunyupSyuturyokuKbn> returnType() {
        return C_SnkiSyunyupSyuturyokuKbn.class;
    }

    @Override
    protected C_SnkiSyunyupSyuturyokuKbn valueOf(String pValue) {
        return C_SnkiSyunyupSyuturyokuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SnkiSyunyupSyuturyokuKbn pValue) {
        return pValue.getValue();
    }
}
