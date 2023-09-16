package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BT_OnlineGknyknmeisai;

/**
 * オンライン外貨入出金明細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_OnlineGknyknmeisai extends AbstractExDBTable<BT_OnlineGknyknmeisai> {

    public GenQBT_OnlineGknyknmeisai() {
        this("BT_OnlineGknyknmeisai");
    }

    public GenQBT_OnlineGknyknmeisai(String pAlias) {
        super("BT_OnlineGknyknmeisai", BT_OnlineGknyknmeisai.class, pAlias);
    }

    public String BT_OnlineGknyknmeisai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdatakbn1 = new ExDBFieldString<>("hrkmdatakbn1", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmsyubetucd = new ExDBFieldString<>("hrkmsyubetucd", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmcdkbn = new ExDBFieldString<>("hrkmcdkbn", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmsakuseiymd = new ExDBFieldString<>("hrkmsakuseiymd", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmrenrakuymd = new ExDBFieldString<>("hrkmrenrakuymd", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmrenrakukaisuu = new ExDBFieldString<>("hrkmrenrakukaisuu", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmknjyymdfrom = new ExDBFieldString<>("hrkmknjyymdfrom", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmknjyymdto = new ExDBFieldString<>("hrkmknjyymdto", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmbankcd = new ExDBFieldString<>("hrkmbankcd", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmbanknmej = new ExDBFieldString<>("hrkmbanknmej", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmsitencdtori = new ExDBFieldString<>("hrkmsitencdtori", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmsitennmejtori = new ExDBFieldString<>("hrkmsitennmejtori", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmshitencd = new ExDBFieldString<>("hrkmshitencd", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmsitennmej = new ExDBFieldString<>("hrkmsitennmej", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmyokinkbn = new ExDBFieldString<>("hrkmyokinkbn", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmkouzano = new ExDBFieldString<>("hrkmkouzano", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmkznmej = new ExDBFieldString<>("hrkmkznmej", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmzndktuukasyu = new ExDBFieldString<>("hrkmzndktuukasyu", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmzndkssketa = new ExDBFieldString<>("hrkmzndkssketa", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmgktrhkmaezndk = new ExDBFieldString<>("hrkmgktrhkmaezndk", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmkasikosikbn = new ExDBFieldString<>("hrkmkasikosikbn", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmyobiv86 = new ExDBFieldString<>("hrkmyobiv86", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdatakbn2 = new ExDBFieldString<>("hrkmdatakbn2", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdtrecordkbn1 = new ExDBFieldString<>("hrkmdtrecordkbn1", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdtrecordkousei = new ExDBFieldString<>("hrkmdtrecordkousei", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmsyorino1 = new ExDBFieldString<>("hrkmsyorino1", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmknjyymd = new ExDBFieldString<>("hrkmknjyymd", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmksnymd = new ExDBFieldString<>("hrkmksnymd", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmiribaraikbn = new ExDBFieldString<>("hrkmiribaraikbn", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmtrhkkbn = new ExDBFieldString<>("hrkmtrhkkbn", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmtrhktuukasyu = new ExDBFieldString<>("hrkmtrhktuukasyu", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmtrhkssketa = new ExDBFieldString<>("hrkmtrhkssketa", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmgktrhkgk = new ExDBFieldString<>("hrkmgktrhkgk", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmbanksyoukaino = new ExDBFieldString<>("hrkmbanksyoukaino", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmtrhksyoukaino = new ExDBFieldString<>("hrkmtrhksyoukaino", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmtekiyounaiyouej = new ExDBFieldString<>("hrkmtekiyounaiyouej", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmyobiv103 = new ExDBFieldString<>("hrkmyobiv103", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdatakbn3 = new ExDBFieldString<>("hrkmdatakbn3", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdtrecordkbn2 = new ExDBFieldString<>("hrkmdtrecordkbn2", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdtkouseikbn = new ExDBFieldString<>("hrkmdtkouseikbn", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmtrkscd = new ExDBFieldString<>("hrkmtrkscd", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmsyorino2 = new ExDBFieldString<>("hrkmsyorino2", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmbanksyoukaino2 = new ExDBFieldString<>("hrkmbanksyoukaino2", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmsimukeymd = new ExDBFieldString<>("hrkmsimukeymd", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmsetujyuymd = new ExDBFieldString<>("hrkmsetujyuymd", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmsoukinsyu = new ExDBFieldString<>("hrkmsoukinsyu", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmvalueymd = new ExDBFieldString<>("hrkmvalueymd", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmskntuukasyu = new ExDBFieldString<>("hrkmskntuukasyu", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmsknssketa = new ExDBFieldString<>("hrkmsknssketa", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmgksoukingk = new ExDBFieldString<>("hrkmgksoukingk", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmirninnmej = new ExDBFieldString<>("hrkmirninnmej", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmyobiv40 = new ExDBFieldString<>("hrkmyobiv40", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdatakbn4 = new ExDBFieldString<>("hrkmdatakbn4", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdtrecordkbn3 = new ExDBFieldString<>("hrkmdtrecordkbn3", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdourecordsuu1 = new ExDBFieldString<>("hrkmdourecordsuu1", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdourecordno1 = new ExDBFieldString<>("hrkmdourecordno1", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmkahensuu1 = new ExDBFieldString<>("hrkmkahensuu1", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmkahenketa1 = new ExDBFieldString<>("hrkmkahenketa1", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmkahen1 = new ExDBFieldString<>("hrkmkahen1", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdatakbn5 = new ExDBFieldString<>("hrkmdatakbn5", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdtrecordkbn4 = new ExDBFieldString<>("hrkmdtrecordkbn4", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdourecordsuu2 = new ExDBFieldString<>("hrkmdourecordsuu2", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdourecordno2 = new ExDBFieldString<>("hrkmdourecordno2", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmkahensuu2 = new ExDBFieldString<>("hrkmkahensuu2", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmkahenketa2 = new ExDBFieldString<>("hrkmkahenketa2", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmkahen2 = new ExDBFieldString<>("hrkmkahen2", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdatakbn6 = new ExDBFieldString<>("hrkmdatakbn6", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdtrecordkbn5 = new ExDBFieldString<>("hrkmdtrecordkbn5", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdourecordsuu3 = new ExDBFieldString<>("hrkmdourecordsuu3", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmdourecordno3 = new ExDBFieldString<>("hrkmdourecordno3", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmkahensuu3 = new ExDBFieldString<>("hrkmkahensuu3", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmkahenketa3 = new ExDBFieldString<>("hrkmkahenketa3", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmkahen3 = new ExDBFieldString<>("hrkmkahen3", this);

    public final ExDBFieldString<BT_OnlineGknyknmeisai, String> hrkmrensakuseiymd = new ExDBFieldString<>("hrkmrensakuseiymd", this);
}
