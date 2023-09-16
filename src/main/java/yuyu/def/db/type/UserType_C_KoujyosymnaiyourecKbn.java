package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoujyosymnaiyourecKbn;

/**
 * {@link C_KoujyosymnaiyourecKbn 控除証明内容レコード区分} の Hibernate ユーザー定義型です。<br />
 * 控除証明内容レコード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoujyosymnaiyourecKbn extends AbstractUserType<C_KoujyosymnaiyourecKbn> {

    @Override
    protected Class<C_KoujyosymnaiyourecKbn> returnType() {
        return C_KoujyosymnaiyourecKbn.class;
    }

    @Override
    protected C_KoujyosymnaiyourecKbn valueOf(String pValue) {
        return C_KoujyosymnaiyourecKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoujyosymnaiyourecKbn pValue) {
        return pValue.getValue();
    }
}
