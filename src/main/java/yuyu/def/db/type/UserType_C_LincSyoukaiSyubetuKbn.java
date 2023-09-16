package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LincSyoukaiSyubetuKbn;

/**
 * {@link C_LincSyoukaiSyubetuKbn ＬＩＮＣ照会種別区分} の Hibernate ユーザー定義型です。<br />
 * ＬＩＮＣ照会種別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LincSyoukaiSyubetuKbn extends AbstractUserType<C_LincSyoukaiSyubetuKbn> {

    @Override
    protected Class<C_LincSyoukaiSyubetuKbn> returnType() {
        return C_LincSyoukaiSyubetuKbn.class;
    }

    @Override
    protected C_LincSyoukaiSyubetuKbn valueOf(String pValue) {
        return C_LincSyoukaiSyubetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LincSyoukaiSyubetuKbn pValue) {
        return pValue.getValue();
    }
}
