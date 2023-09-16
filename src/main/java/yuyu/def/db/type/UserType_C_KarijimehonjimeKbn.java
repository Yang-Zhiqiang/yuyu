package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KarijimehonjimeKbn;

/**
 * {@link C_KarijimehonjimeKbn 仮締本締区分} の Hibernate ユーザー定義型です。<br />
 * 仮締本締区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KarijimehonjimeKbn extends AbstractUserType<C_KarijimehonjimeKbn> {

    @Override
    protected Class<C_KarijimehonjimeKbn> returnType() {
        return C_KarijimehonjimeKbn.class;
    }

    @Override
    protected C_KarijimehonjimeKbn valueOf(String pValue) {
        return C_KarijimehonjimeKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KarijimehonjimeKbn pValue) {
        return pValue.getValue();
    }
}
