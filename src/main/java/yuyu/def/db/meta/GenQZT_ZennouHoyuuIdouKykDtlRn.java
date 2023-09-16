package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_ZennouHoyuuIdouKykDtlRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 前納保有異動契約明細Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_ZennouHoyuuIdouKykDtlRn extends AbstractExDBTable<ZT_ZennouHoyuuIdouKykDtlRn> {

    public GenQZT_ZennouHoyuuIdouKykDtlRn() {
        this("ZT_ZennouHoyuuIdouKykDtlRn");
    }

    public GenQZT_ZennouHoyuuIdouKykDtlRn(String pAlias) {
        super("ZT_ZennouHoyuuIdouKykDtlRn", ZT_ZennouHoyuuIdouKykDtlRn.class, pAlias);
    }

    public String ZT_ZennouHoyuuIdouKykDtlRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnyobiv9 = new ExDBFieldString<>("zrnyobiv9", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnhenkousyoriymd = new ExDBFieldString<>("zrnhenkousyoriymd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrndenymd = new ExDBFieldString<>("zrndenymd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnzennoucalckijyunymd = new ExDBFieldString<>("zrnzennoucalckijyunymd", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Integer> zrnkykmfksnctr = new ExDBFieldNumber<>("zrnkykmfksnctr", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnzennoubikinkbn = new ExDBFieldString<>("zrnzennoubikinkbn", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnyobiv10 = new ExDBFieldString<>("zrnyobiv10", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnsyukeiyakusyuruicdv2 = new ExDBFieldString<>("zrnsyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnkbnkeiriyousegmentcd = new ExDBFieldString<>("zrnkbnkeiriyousegmentcd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnzennoutoukeilistkbn = new ExDBFieldString<>("zrnzennoutoukeilistkbn", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, BizNumber> zrnzennouwrbkrt = new ExDBFieldString<>("zrnzennouwrbkrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, BizNumber> zrntkyrt1 = new ExDBFieldString<>("zrntkyrt1", this, BizNumberType.class);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrntndzndkhikakukbn = new ExDBFieldString<>("zrntndzndkhikakukbn", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnzennoukaisiymd = new ExDBFieldString<>("zrnzennoukaisiymd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnzennoukbn = new ExDBFieldString<>("zrnzennoukbn", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnzennoukikan = new ExDBFieldString<>("zrnzennoukikan", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnzennounyuukinymd = new ExDBFieldString<>("zrnzennounyuukinymd", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrnzennounyuukinkgk = new ExDBFieldNumber<>("zrnzennounyuukinkgk", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnyobiv5x2 = new ExDBFieldString<>("zrnyobiv5x2", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnansyuyouyobin10 = new ExDBFieldString<>("zrnansyuyouyobin10", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnyobiv10x2 = new ExDBFieldString<>("zrnyobiv10x2", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrntoukimatuzennouzndk = new ExDBFieldNumber<>("zrntoukimatuzennouzndk", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrntoukijyuutoup = new ExDBFieldNumber<>("zrntoukijyuutoup", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrntoukizennouseisangk = new ExDBFieldNumber<>("zrntoukizennouseisangk", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrntoukizennounyuukinkgk = new ExDBFieldNumber<>("zrntoukizennounyuukinkgk", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrnyokukinenbaraip = new ExDBFieldNumber<>("zrnyokukinenbaraip", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrnwrbkrttkyrttekiyouzndk = new ExDBFieldNumber<>("zrnwrbkrttkyrttekiyouzndk", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrngkdtznnhyj = new ExDBFieldString<>("zrngkdtznnhyj", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnyenkanyknhyj = new ExDBFieldString<>("zrnyenkanyknhyj", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, BizNumber> zrnnyknjikawaserate = new ExDBFieldString<>("zrnnyknjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnnyknjikawaseratetkyuymd = new ExDBFieldString<>("zrnnyknjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, BizNumber> zrnksnkisikawaserate = new ExDBFieldString<>("zrnksnkisikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, BizNumber> zrnznncalckjynymdkwsrate = new ExDBFieldString<>("zrnznncalckjynymdkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, BizNumber> zrnksnkimatukawaserate = new ExDBFieldString<>("zrnksnkimatukawaserate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrnzennounyuukinkgktkmatu = new ExDBFieldNumber<>("zrnzennounyuukinkgktkmatu", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrntkmatuznnzndktkmatu = new ExDBFieldNumber<>("zrntkmatuznnzndktkmatu", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrnyobin11x7 = new ExDBFieldNumber<>("zrnyobin11x7", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlRn, Long> zrnyobin11x8 = new ExDBFieldNumber<>("zrnyobin11x8", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlRn, String> zrnyobiv23 = new ExDBFieldString<>("zrnyobiv23", this);
}
