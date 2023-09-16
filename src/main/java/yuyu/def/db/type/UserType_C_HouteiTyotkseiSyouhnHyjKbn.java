package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HouteiTyotkseiSyouhnHyjKbn;

/**
 * {@link C_HouteiTyotkseiSyouhnHyjKbn 法定貯蓄性商品表示区分} の Hibernate ユーザー定義型です。<br />
 * 法定貯蓄性商品表示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HouteiTyotkseiSyouhnHyjKbn extends AbstractUserType<C_HouteiTyotkseiSyouhnHyjKbn> {

    @Override
    protected Class<C_HouteiTyotkseiSyouhnHyjKbn> returnType() {
        return C_HouteiTyotkseiSyouhnHyjKbn.class;
    }

    @Override
    protected C_HouteiTyotkseiSyouhnHyjKbn valueOf(String pValue) {
        return C_HouteiTyotkseiSyouhnHyjKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HouteiTyotkseiSyouhnHyjKbn pValue) {
        return pValue.getValue();
    }
}
