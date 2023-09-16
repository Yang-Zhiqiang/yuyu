package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;

/**
 * {@link C_SakuintsnSyoukaiKbn 索引通算照会区分} の Hibernate ユーザー定義型です。<br />
 * 索引通算照会区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SakuintsnSyoukaiKbn extends AbstractUserType<C_SakuintsnSyoukaiKbn> {

    @Override
    protected Class<C_SakuintsnSyoukaiKbn> returnType() {
        return C_SakuintsnSyoukaiKbn.class;
    }

    @Override
    protected C_SakuintsnSyoukaiKbn valueOf(String pValue) {
        return C_SakuintsnSyoukaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SakuintsnSyoukaiKbn pValue) {
        return pValue.getValue();
    }
}
