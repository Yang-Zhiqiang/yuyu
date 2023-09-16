package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_TumitateYosokuRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 積立金額予測ファイルテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_TumitateYosokuRn extends AbstractExDBTable<ZT_TumitateYosokuRn> {

    public GenQZT_TumitateYosokuRn() {
        this("ZT_TumitateYosokuRn");
    }

    public GenQZT_TumitateYosokuRn(String pAlias) {
        super("ZT_TumitateYosokuRn", ZT_TumitateYosokuRn.class, pAlias);
    }

    public String ZT_TumitateYosokuRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_TumitateYosokuRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_TumitateYosokuRn, String> zrnkeiyakuymd = new ExDBFieldString<>("zrnkeiyakuymd", this);

    public final ExDBFieldString<ZT_TumitateYosokuRn, String> zrntysytymd = new ExDBFieldString<>("zrntysytymd", this);

    public final ExDBFieldString<ZT_TumitateYosokuRn, String> zrnkyktuukasyu = new ExDBFieldString<>("zrnkyktuukasyu", this);

    public final ExDBFieldString<ZT_TumitateYosokuRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_TumitateYosokuRn, String> zrntmttknsyuruikbn = new ExDBFieldString<>("zrntmttknsyuruikbn", this);

    public final ExDBFieldString<ZT_TumitateYosokuRn, String> zrnsisuukbn = new ExDBFieldString<>("zrnsisuukbn", this);

    public final ExDBFieldNumber<ZT_TumitateYosokuRn, Integer> zrntmttknysktaisyoukensuu = new ExDBFieldNumber<>("zrntmttknysktaisyoukensuu", this);

    public final ExDBFieldString<ZT_TumitateYosokuRn, BizNumber> zrnkyktuukakyktmttkngk = new ExDBFieldString<>("zrnkyktuukakyktmttkngk", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TumitateYosokuRn, BizNumber> zrnkyktuukakisitmttkngk = new ExDBFieldString<>("zrnkyktuukakisitmttkngk", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TumitateYosokuRn, BizNumber> zrnkyktuukaysktmttkngk = new ExDBFieldString<>("zrnkyktuukaysktmttkngk", this, BizNumberType.class);
}
