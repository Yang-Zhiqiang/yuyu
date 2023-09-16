package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tsryshrteisihyj;

/**
 * {@link C_Tsryshrteisihyj 手数料支払停止表示} の Hibernate ユーザー定義型です。<br />
 * 手数料支払停止表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tsryshrteisihyj extends AbstractUserType<C_Tsryshrteisihyj> {

    @Override
    protected Class<C_Tsryshrteisihyj> returnType() {
        return C_Tsryshrteisihyj.class;
    }

    @Override
    protected C_Tsryshrteisihyj valueOf(String pValue) {
        return C_Tsryshrteisihyj.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tsryshrteisihyj pValue) {
        return pValue.getValue();
    }
}
