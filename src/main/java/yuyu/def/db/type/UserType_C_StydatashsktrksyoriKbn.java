package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_StydatashsktrksyoriKbn;

/**
 * {@link C_StydatashsktrksyoriKbn 進捗データ送付先登録処理区分} の Hibernate ユーザー定義型です。<br />
 * 進捗データ送付先登録処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_StydatashsktrksyoriKbn extends AbstractUserType<C_StydatashsktrksyoriKbn> {

    @Override
    protected Class<C_StydatashsktrksyoriKbn> returnType() {
        return C_StydatashsktrksyoriKbn.class;
    }

    @Override
    protected C_StydatashsktrksyoriKbn valueOf(String pValue) {
        return C_StydatashsktrksyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_StydatashsktrksyoriKbn pValue) {
        return pValue.getValue();
    }
}
