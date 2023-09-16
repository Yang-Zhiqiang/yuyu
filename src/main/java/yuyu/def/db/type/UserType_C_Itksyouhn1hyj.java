package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Itksyouhn1hyj;

/**
 * {@link C_Itksyouhn1hyj 委託商品１有表示} の Hibernate ユーザー定義型です。<br />
 * 委託商品１有表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Itksyouhn1hyj extends AbstractUserType<C_Itksyouhn1hyj> {

    @Override
    protected Class<C_Itksyouhn1hyj> returnType() {
        return C_Itksyouhn1hyj.class;
    }

    @Override
    protected C_Itksyouhn1hyj valueOf(String pValue) {
        return C_Itksyouhn1hyj.valueOf(pValue);
    }

    @Override
    protected String toString(C_Itksyouhn1hyj pValue) {
        return pValue.getValue();
    }
}
