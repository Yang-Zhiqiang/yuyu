package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.HT_NrkDif;

/**
 * 入力差異テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_NrkDif extends AbstractExDBTable<HT_NrkDif> {

    public GenQHT_NrkDif() {
        this("HT_NrkDif");
    }

    public GenQHT_NrkDif(String pAlias) {
        super("HT_NrkDif", HT_NrkDif.class, pAlias);
    }

    public String HT_NrkDif() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_NrkDif, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_NrkDif, String> vrfkinouid = new ExDBFieldString<>("vrfkinouid", this);

    public final ExDBFieldNumber<HT_NrkDif, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<HT_NrkDif, String> nrksouikm = new ExDBFieldString<>("nrksouikm", this);

    public final ExDBFieldString<HT_NrkDif, String> itijinyuuroku = new ExDBFieldString<>("itijinyuuroku", this);

    public final ExDBFieldString<HT_NrkDif, String> nijinyrk = new ExDBFieldString<>("nijinyrk", this);

    public final ExDBFieldString<HT_NrkDif, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_NrkDif, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
