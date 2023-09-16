package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_TumitateYosokuTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 積立金額予測ファイルテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_TumitateYosokuTy extends AbstractExDBTable<ZT_TumitateYosokuTy> {

    public GenQZT_TumitateYosokuTy() {
        this("ZT_TumitateYosokuTy");
    }

    public GenQZT_TumitateYosokuTy(String pAlias) {
        super("ZT_TumitateYosokuTy", ZT_TumitateYosokuTy.class, pAlias);
    }

    public String ZT_TumitateYosokuTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_TumitateYosokuTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_TumitateYosokuTy, String> ztykeiyakuymd = new ExDBFieldString<>("ztykeiyakuymd", this);

    public final ExDBFieldString<ZT_TumitateYosokuTy, String> ztytysytymd = new ExDBFieldString<>("ztytysytymd", this);

    public final ExDBFieldString<ZT_TumitateYosokuTy, String> ztykyktuukasyu = new ExDBFieldString<>("ztykyktuukasyu", this);

    public final ExDBFieldString<ZT_TumitateYosokuTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_TumitateYosokuTy, String> ztytmttknsyuruikbn = new ExDBFieldString<>("ztytmttknsyuruikbn", this);

    public final ExDBFieldString<ZT_TumitateYosokuTy, String> ztysisuukbn = new ExDBFieldString<>("ztysisuukbn", this);

    public final ExDBFieldNumber<ZT_TumitateYosokuTy, Integer> ztytmttknysktaisyoukensuu = new ExDBFieldNumber<>("ztytmttknysktaisyoukensuu", this);

    public final ExDBFieldString<ZT_TumitateYosokuTy, BizNumber> ztykyktuukakyktmttkngk = new ExDBFieldString<>("ztykyktuukakyktmttkngk", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TumitateYosokuTy, BizNumber> ztykyktuukakisitmttkngk = new ExDBFieldString<>("ztykyktuukakisitmttkngk", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TumitateYosokuTy, BizNumber> ztykyktuukaysktmttkngk = new ExDBFieldString<>("ztykyktuukaysktmttkngk", this, BizNumberType.class);
}
