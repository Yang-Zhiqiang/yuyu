package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BT_Nyknmeisai;

/**
 * 入出金明細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_Nyknmeisai extends AbstractExDBTable<BT_Nyknmeisai> {

    public GenQBT_Nyknmeisai() {
        this("BT_Nyknmeisai");
    }

    public GenQBT_Nyknmeisai(String pAlias) {
        super("BT_Nyknmeisai", BT_Nyknmeisai.class, pAlias);
    }

    public String BT_Nyknmeisai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmdatakbn1 = new ExDBFieldString<>("hrkmdatakbn1", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmsyubetucd = new ExDBFieldString<>("hrkmsyubetucd", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmcdkbn = new ExDBFieldString<>("hrkmcdkbn", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmsakuseiymd6keta = new ExDBFieldString<>("hrkmsakuseiymd6keta", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmknjyymdfrom6keta = new ExDBFieldString<>("hrkmknjyymdfrom6keta", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmknjyymdto6keta = new ExDBFieldString<>("hrkmknjyymdto6keta", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmbankcd = new ExDBFieldString<>("hrkmbankcd", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmbanknmkn = new ExDBFieldString<>("hrkmbanknmkn", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmshitencd = new ExDBFieldString<>("hrkmshitencd", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmsitennmkn = new ExDBFieldString<>("hrkmsitennmkn", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmyobiv3 = new ExDBFieldString<>("hrkmyobiv3", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmyokinkbn = new ExDBFieldString<>("hrkmyokinkbn", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmkouzano = new ExDBFieldString<>("hrkmkouzano", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmkznmkn = new ExDBFieldString<>("hrkmkznmkn", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmkasikosikbn = new ExDBFieldString<>("hrkmkasikosikbn", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmtuutyousysykbn = new ExDBFieldString<>("hrkmtuutyousysykbn", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmtrhkmaezndk = new ExDBFieldString<>("hrkmtrhkmaezndk", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmyobiv63 = new ExDBFieldString<>("hrkmyobiv63", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmrenno8 = new ExDBFieldString<>("hrkmrenno8", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmdatakbn2 = new ExDBFieldString<>("hrkmdatakbn2", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmsyoukaino = new ExDBFieldString<>("hrkmsyoukaino", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmknjyymd6keta = new ExDBFieldString<>("hrkmknjyymd6keta", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmazkrhrdsymd6keta = new ExDBFieldString<>("hrkmazkrhrdsymd6keta", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmiribaraikbn = new ExDBFieldString<>("hrkmiribaraikbn", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmtrhkkbn = new ExDBFieldString<>("hrkmtrhkkbn", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmtrhkgk = new ExDBFieldString<>("hrkmtrhkgk", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmtatenkengk = new ExDBFieldString<>("hrkmtatenkengk", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmkknteijiymd6keta = new ExDBFieldString<>("hrkmkknteijiymd6keta", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmhwtrhnknymd6keta = new ExDBFieldString<>("hrkmhwtrhnknymd6keta", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmtgtkgtkbn = new ExDBFieldString<>("hrkmtgtkgtkbn", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmtgtkgtno = new ExDBFieldString<>("hrkmtgtkgtno", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmryoutenno = new ExDBFieldString<>("hrkmryoutenno", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmhrkmirnincd = new ExDBFieldString<>("hrkmhrkmirnincd", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmhrkmirninnm = new ExDBFieldString<>("hrkmhrkmirninnm", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmsimukebanknmkn = new ExDBFieldString<>("hrkmsimukebanknmkn", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmsimuketennmkn = new ExDBFieldString<>("hrkmsimuketennmkn", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmtekiyounaiyou = new ExDBFieldString<>("hrkmtekiyounaiyou", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmediinfo = new ExDBFieldString<>("hrkmediinfo", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmyobiv1 = new ExDBFieldString<>("hrkmyobiv1", this);

    public final ExDBFieldString<BT_Nyknmeisai, String> hrkmrensakuseiymd6keta = new ExDBFieldString<>("hrkmrensakuseiymd6keta", this);
}
