package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkbtKanjyouUnitFundKbn;

/**
 * {@link C_TkbtKanjyouUnitFundKbn 特別勘定ユニットファンド区分} の Hibernate ユーザー定義型です。<br />
 * 特別勘定ユニットファンド区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkbtKanjyouUnitFundKbn extends AbstractUserType<C_TkbtKanjyouUnitFundKbn> {

    @Override
    protected Class<C_TkbtKanjyouUnitFundKbn> returnType() {
        return C_TkbtKanjyouUnitFundKbn.class;
    }

    @Override
    protected C_TkbtKanjyouUnitFundKbn valueOf(String pValue) {
        return C_TkbtKanjyouUnitFundKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkbtKanjyouUnitFundKbn pValue) {
        return pValue.getValue();
    }
}
