package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_SkCreditCardTourokuKekka;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 新契約クレジットカード登録結果テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_SkCreditCardTourokuKekka extends AbstractExDBTable<IT_SkCreditCardTourokuKekka> {

    public GenQIT_SkCreditCardTourokuKekka() {
        this("IT_SkCreditCardTourokuKekka");
    }

    public GenQIT_SkCreditCardTourokuKekka(String pAlias) {
        super("IT_SkCreditCardTourokuKekka", IT_SkCreditCardTourokuKekka.class, pAlias);
    }

    public String IT_SkCreditCardTourokuKekka() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> datajyusinymd = new ExDBFieldString<>("datajyusinymd", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> kaiintourokukbn = new ExDBFieldString<>("kaiintourokukbn", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> creditcardno = new ExDBFieldString<>("creditcardno", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> cardyuukoukigen4keta = new ExDBFieldString<>("cardyuukoukigen4keta", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> authorigk7keta = new ExDBFieldString<>("authorigk7keta", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> authorikekkaerrorcd = new ExDBFieldString<>("authorikekkaerrorcd", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> bluegateerrorcd = new ExDBFieldString<>("bluegateerrorcd", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> hisimukekaisyacd = new ExDBFieldString<>("hisimukekaisyacd", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> wentryuserid = new ExDBFieldString<>("wentryuserid", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> errorcomment = new ExDBFieldString<>("errorcomment", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> niniinfo = new ExDBFieldString<>("niniinfo", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> datasyorijyoukyou = new ExDBFieldString<>("datasyorijyoukyou", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_SkCreditCardTourokuKekka, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
