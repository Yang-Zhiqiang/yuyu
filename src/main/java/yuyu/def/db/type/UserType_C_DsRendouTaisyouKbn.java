package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsRendouTaisyouKbn;

/**
 * {@link C_DsRendouTaisyouKbn ＤＳ連動対象区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ連動対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsRendouTaisyouKbn extends AbstractUserType<C_DsRendouTaisyouKbn> {

    @Override
    protected Class<C_DsRendouTaisyouKbn> returnType() {
        return C_DsRendouTaisyouKbn.class;
    }

    @Override
    protected C_DsRendouTaisyouKbn valueOf(String pValue) {
        return C_DsRendouTaisyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsRendouTaisyouKbn pValue) {
        return pValue.getValue();
    }
}
