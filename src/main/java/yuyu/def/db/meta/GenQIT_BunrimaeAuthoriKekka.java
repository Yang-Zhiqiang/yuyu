package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_BunrimaeAuthoriKekka;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 分離前オーソリ結果テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BunrimaeAuthoriKekka extends AbstractExDBTable<IT_BunrimaeAuthoriKekka> {

    public GenQIT_BunrimaeAuthoriKekka() {
        this("IT_BunrimaeAuthoriKekka");
    }

    public GenQIT_BunrimaeAuthoriKekka(String pAlias) {
        super("IT_BunrimaeAuthoriKekka", IT_BunrimaeAuthoriKekka.class, pAlias);
    }

    public String IT_BunrimaeAuthoriKekka() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> datajyusinymd = new ExDBFieldString<>("datajyusinymd", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> kaiintourokukbn = new ExDBFieldString<>("kaiintourokukbn", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> creditcardno = new ExDBFieldString<>("creditcardno", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> cardyuukoukigen4keta = new ExDBFieldString<>("cardyuukoukigen4keta", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> authorigk7keta = new ExDBFieldString<>("authorigk7keta", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> authorikekkaerrorcd = new ExDBFieldString<>("authorikekkaerrorcd", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> bluegateerrorcd = new ExDBFieldString<>("bluegateerrorcd", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> hisimukekaisyacd = new ExDBFieldString<>("hisimukekaisyacd", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> wentryuserid = new ExDBFieldString<>("wentryuserid", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> errorcomment = new ExDBFieldString<>("errorcomment", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> niniinfo = new ExDBFieldString<>("niniinfo", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> datasyorijyoukyou = new ExDBFieldString<>("datasyorijyoukyou", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BunrimaeAuthoriKekka, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
