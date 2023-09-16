package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ZeitekiHenkouSyoriKbn;

/**
 * {@link C_ZeitekiHenkouSyoriKbn 税適特約変更処理区分} の Hibernate ユーザー定義型です。<br />
 * 税適特約変更処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ZeitekiHenkouSyoriKbn extends AbstractUserType<C_ZeitekiHenkouSyoriKbn> {

    @Override
    protected Class<C_ZeitekiHenkouSyoriKbn> returnType() {
        return C_ZeitekiHenkouSyoriKbn.class;
    }

    @Override
    protected C_ZeitekiHenkouSyoriKbn valueOf(String pValue) {
        return C_ZeitekiHenkouSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ZeitekiHenkouSyoriKbn pValue) {
        return pValue.getValue();
    }
}
