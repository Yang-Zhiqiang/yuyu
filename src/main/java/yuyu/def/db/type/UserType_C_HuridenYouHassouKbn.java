package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HuridenYouHassouKbn;

/**
 * {@link C_HuridenYouHassouKbn 振替伝票用発送区分} の Hibernate ユーザー定義型です。<br />
 * 振替伝票用発送区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HuridenYouHassouKbn extends AbstractUserType<C_HuridenYouHassouKbn> {

    @Override
    protected Class<C_HuridenYouHassouKbn> returnType() {
        return C_HuridenYouHassouKbn.class;
    }

    @Override
    protected C_HuridenYouHassouKbn valueOf(String pValue) {
        return C_HuridenYouHassouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HuridenYouHassouKbn pValue) {
        return pValue.getValue();
    }
}
