package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Itksyouhn3hyj;

/**
 * {@link C_Itksyouhn3hyj 委託商品３有表示} の Hibernate ユーザー定義型です。<br />
 * 委託商品３有表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Itksyouhn3hyj extends AbstractUserType<C_Itksyouhn3hyj> {

    @Override
    protected Class<C_Itksyouhn3hyj> returnType() {
        return C_Itksyouhn3hyj.class;
    }

    @Override
    protected C_Itksyouhn3hyj valueOf(String pValue) {
        return C_Itksyouhn3hyj.valueOf(pValue);
    }

    @Override
    protected String toString(C_Itksyouhn3hyj pValue) {
        return pValue.getValue();
    }
}
