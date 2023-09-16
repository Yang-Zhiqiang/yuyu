package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MdhnSchemeDrtenHyouji;

/**
 * {@link C_MdhnSchemeDrtenHyouji 窓販スキーム代理店表示} の Hibernate ユーザー定義型です。<br />
 * 窓販スキーム代理店表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MdhnSchemeDrtenHyouji extends AbstractUserType<C_MdhnSchemeDrtenHyouji> {

    @Override
    protected Class<C_MdhnSchemeDrtenHyouji> returnType() {
        return C_MdhnSchemeDrtenHyouji.class;
    }

    @Override
    protected C_MdhnSchemeDrtenHyouji valueOf(String pValue) {
        return C_MdhnSchemeDrtenHyouji.valueOf(pValue);
    }

    @Override
    protected String toString(C_MdhnSchemeDrtenHyouji pValue) {
        return pValue.getValue();
    }
}
