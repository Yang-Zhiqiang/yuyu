package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kokunaikwskameihyj;

/**
 * {@link C_Kokunaikwskameihyj 内国為替制度加盟表示} の Hibernate ユーザー定義型です。<br />
 * 内国為替制度加盟表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kokunaikwskameihyj extends AbstractUserType<C_Kokunaikwskameihyj> {

    @Override
    protected Class<C_Kokunaikwskameihyj> returnType() {
        return C_Kokunaikwskameihyj.class;
    }

    @Override
    protected C_Kokunaikwskameihyj valueOf(String pValue) {
        return C_Kokunaikwskameihyj.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kokunaikwskameihyj pValue) {
        return pValue.getValue();
    }
}
