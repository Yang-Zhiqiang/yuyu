package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;

/**
 * {@link C_DsHanyouKokyakuateTuutiKbn ＤＳ汎用顧客宛通知区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ汎用顧客宛通知区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsHanyouKokyakuateTuutiKbn extends AbstractUserType<C_DsHanyouKokyakuateTuutiKbn> {

    @Override
    protected Class<C_DsHanyouKokyakuateTuutiKbn> returnType() {
        return C_DsHanyouKokyakuateTuutiKbn.class;
    }

    @Override
    protected C_DsHanyouKokyakuateTuutiKbn valueOf(String pValue) {
        return C_DsHanyouKokyakuateTuutiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsHanyouKokyakuateTuutiKbn pValue) {
        return pValue.getValue();
    }
}
