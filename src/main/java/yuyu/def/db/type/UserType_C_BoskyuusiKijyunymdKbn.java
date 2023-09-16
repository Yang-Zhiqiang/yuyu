package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BoskyuusiKijyunymdKbn;

/**
 * {@link C_BoskyuusiKijyunymdKbn 募集休止基準日区分} の Hibernate ユーザー定義型です。<br />
 * 募集休止基準日区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BoskyuusiKijyunymdKbn extends AbstractUserType<C_BoskyuusiKijyunymdKbn> {

    @Override
    protected Class<C_BoskyuusiKijyunymdKbn> returnType() {
        return C_BoskyuusiKijyunymdKbn.class;
    }

    @Override
    protected C_BoskyuusiKijyunymdKbn valueOf(String pValue) {
        return C_BoskyuusiKijyunymdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BoskyuusiKijyunymdKbn pValue) {
        return pValue.getValue();
    }
}
