package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GwtsrydatasakuseisyoriKbn;

/**
 * {@link C_GwtsrydatasakuseisyoriKbn ＧＷ手数料データ作成処理区分} の Hibernate ユーザー定義型です。<br />
 * ＧＷ手数料データ作成処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GwtsrydatasakuseisyoriKbn extends AbstractUserType<C_GwtsrydatasakuseisyoriKbn> {

    @Override
    protected Class<C_GwtsrydatasakuseisyoriKbn> returnType() {
        return C_GwtsrydatasakuseisyoriKbn.class;
    }

    @Override
    protected C_GwtsrydatasakuseisyoriKbn valueOf(String pValue) {
        return C_GwtsrydatasakuseisyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GwtsrydatasakuseisyoriKbn pValue) {
        return pValue.getValue();
    }
}
