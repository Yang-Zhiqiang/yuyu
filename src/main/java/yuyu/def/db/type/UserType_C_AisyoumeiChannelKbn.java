package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AisyoumeiChannelKbn;

/**
 * {@link C_AisyoumeiChannelKbn 愛称名チャネル区分} の Hibernate ユーザー定義型です。<br />
 * 愛称名チャネル区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AisyoumeiChannelKbn extends AbstractUserType<C_AisyoumeiChannelKbn> {

    @Override
    protected Class<C_AisyoumeiChannelKbn> returnType() {
        return C_AisyoumeiChannelKbn.class;
    }

    @Override
    protected C_AisyoumeiChannelKbn valueOf(String pValue) {
        return C_AisyoumeiChannelKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AisyoumeiChannelKbn pValue) {
        return pValue.getValue();
    }
}
