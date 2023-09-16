package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BT_Gknyknmeisai;

/**
 * 外貨入出金明細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_Gknyknmeisai extends AbstractExDBTable<BT_Gknyknmeisai> {

    public GenQBT_Gknyknmeisai() {
        this("BT_Gknyknmeisai");
    }

    public GenQBT_Gknyknmeisai(String pAlias) {
        super("BT_Gknyknmeisai", BT_Gknyknmeisai.class, pAlias);
    }

    public String BT_Gknyknmeisai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdatakbn1 = new ExDBFieldString<>("hrkmdatakbn1", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmsyubetucd = new ExDBFieldString<>("hrkmsyubetucd", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmcdkbn = new ExDBFieldString<>("hrkmcdkbn", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmsakuseiymd = new ExDBFieldString<>("hrkmsakuseiymd", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmrenrakuymd = new ExDBFieldString<>("hrkmrenrakuymd", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmrenrakukaisuu = new ExDBFieldString<>("hrkmrenrakukaisuu", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmknjyymdfrom = new ExDBFieldString<>("hrkmknjyymdfrom", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmknjyymdto = new ExDBFieldString<>("hrkmknjyymdto", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmbankcd = new ExDBFieldString<>("hrkmbankcd", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmbanknmej = new ExDBFieldString<>("hrkmbanknmej", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmsitencdtori = new ExDBFieldString<>("hrkmsitencdtori", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmsitennmejtori = new ExDBFieldString<>("hrkmsitennmejtori", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmshitencd = new ExDBFieldString<>("hrkmshitencd", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmsitennmej = new ExDBFieldString<>("hrkmsitennmej", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmyokinkbn = new ExDBFieldString<>("hrkmyokinkbn", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmkouzano = new ExDBFieldString<>("hrkmkouzano", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmkznmej = new ExDBFieldString<>("hrkmkznmej", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmzndktuukasyu = new ExDBFieldString<>("hrkmzndktuukasyu", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmzndkssketa = new ExDBFieldString<>("hrkmzndkssketa", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmgktrhkmaezndk = new ExDBFieldString<>("hrkmgktrhkmaezndk", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmkasikosikbn = new ExDBFieldString<>("hrkmkasikosikbn", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmyobiv86 = new ExDBFieldString<>("hrkmyobiv86", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdatakbn2 = new ExDBFieldString<>("hrkmdatakbn2", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdtrecordkbn1 = new ExDBFieldString<>("hrkmdtrecordkbn1", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdtrecordkousei = new ExDBFieldString<>("hrkmdtrecordkousei", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmsyorino1 = new ExDBFieldString<>("hrkmsyorino1", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmknjyymd = new ExDBFieldString<>("hrkmknjyymd", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmksnymd = new ExDBFieldString<>("hrkmksnymd", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmiribaraikbn = new ExDBFieldString<>("hrkmiribaraikbn", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmtrhkkbn = new ExDBFieldString<>("hrkmtrhkkbn", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmtrhktuukasyu = new ExDBFieldString<>("hrkmtrhktuukasyu", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmtrhkssketa = new ExDBFieldString<>("hrkmtrhkssketa", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmgktrhkgk = new ExDBFieldString<>("hrkmgktrhkgk", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmbanksyoukaino = new ExDBFieldString<>("hrkmbanksyoukaino", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmtrhksyoukaino = new ExDBFieldString<>("hrkmtrhksyoukaino", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmtekiyounaiyouej = new ExDBFieldString<>("hrkmtekiyounaiyouej", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmyobiv103 = new ExDBFieldString<>("hrkmyobiv103", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdatakbn3 = new ExDBFieldString<>("hrkmdatakbn3", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdtrecordkbn2 = new ExDBFieldString<>("hrkmdtrecordkbn2", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdtkouseikbn = new ExDBFieldString<>("hrkmdtkouseikbn", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmtrkscd = new ExDBFieldString<>("hrkmtrkscd", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmsyorino2 = new ExDBFieldString<>("hrkmsyorino2", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmbanksyoukaino2 = new ExDBFieldString<>("hrkmbanksyoukaino2", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmsimukeymd = new ExDBFieldString<>("hrkmsimukeymd", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmsetujyuymd = new ExDBFieldString<>("hrkmsetujyuymd", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmsoukinsyu = new ExDBFieldString<>("hrkmsoukinsyu", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmvalueymd = new ExDBFieldString<>("hrkmvalueymd", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmskntuukasyu = new ExDBFieldString<>("hrkmskntuukasyu", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmsknssketa = new ExDBFieldString<>("hrkmsknssketa", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmgksoukingk = new ExDBFieldString<>("hrkmgksoukingk", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmirninnmej = new ExDBFieldString<>("hrkmirninnmej", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmyobiv40 = new ExDBFieldString<>("hrkmyobiv40", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdatakbn4 = new ExDBFieldString<>("hrkmdatakbn4", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdtrecordkbn3 = new ExDBFieldString<>("hrkmdtrecordkbn3", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdourecordsuu1 = new ExDBFieldString<>("hrkmdourecordsuu1", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdourecordno1 = new ExDBFieldString<>("hrkmdourecordno1", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmkahensuu1 = new ExDBFieldString<>("hrkmkahensuu1", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmkahenketa1 = new ExDBFieldString<>("hrkmkahenketa1", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmkahen1 = new ExDBFieldString<>("hrkmkahen1", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdatakbn5 = new ExDBFieldString<>("hrkmdatakbn5", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdtrecordkbn4 = new ExDBFieldString<>("hrkmdtrecordkbn4", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdourecordsuu2 = new ExDBFieldString<>("hrkmdourecordsuu2", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdourecordno2 = new ExDBFieldString<>("hrkmdourecordno2", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmkahensuu2 = new ExDBFieldString<>("hrkmkahensuu2", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmkahenketa2 = new ExDBFieldString<>("hrkmkahenketa2", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmkahen2 = new ExDBFieldString<>("hrkmkahen2", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdatakbn6 = new ExDBFieldString<>("hrkmdatakbn6", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdtrecordkbn5 = new ExDBFieldString<>("hrkmdtrecordkbn5", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdourecordsuu3 = new ExDBFieldString<>("hrkmdourecordsuu3", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmdourecordno3 = new ExDBFieldString<>("hrkmdourecordno3", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmkahensuu3 = new ExDBFieldString<>("hrkmkahensuu3", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmkahenketa3 = new ExDBFieldString<>("hrkmkahenketa3", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmkahen3 = new ExDBFieldString<>("hrkmkahen3", this);

    public final ExDBFieldString<BT_Gknyknmeisai, String> hrkmrensakuseiymd = new ExDBFieldString<>("hrkmrensakuseiymd", this);
}
