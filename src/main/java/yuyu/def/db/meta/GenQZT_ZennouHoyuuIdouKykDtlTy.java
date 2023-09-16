package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_ZennouHoyuuIdouKykDtlTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 前納保有異動契約明細Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_ZennouHoyuuIdouKykDtlTy extends AbstractExDBTable<ZT_ZennouHoyuuIdouKykDtlTy> {

    public GenQZT_ZennouHoyuuIdouKykDtlTy() {
        this("ZT_ZennouHoyuuIdouKykDtlTy");
    }

    public GenQZT_ZennouHoyuuIdouKykDtlTy(String pAlias) {
        super("ZT_ZennouHoyuuIdouKykDtlTy", ZT_ZennouHoyuuIdouKykDtlTy.class, pAlias);
    }

    public String ZT_ZennouHoyuuIdouKykDtlTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyyobiv9 = new ExDBFieldString<>("ztyyobiv9", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyhenkousyoriymd = new ExDBFieldString<>("ztyhenkousyoriymd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyzennoucalckijyunymd = new ExDBFieldString<>("ztyzennoucalckijyunymd", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Integer> ztykykmfksnctr = new ExDBFieldNumber<>("ztykykmfksnctr", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyzennoubikinkbn = new ExDBFieldString<>("ztyzennoubikinkbn", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztysyukeiyakusyuruicdv2 = new ExDBFieldString<>("ztysyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztykbnkeiriyousegmentcd = new ExDBFieldString<>("ztykbnkeiriyousegmentcd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyzennoutoukeilistkbn = new ExDBFieldString<>("ztyzennoutoukeilistkbn", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, BizNumber> ztyzennouwrbkrt = new ExDBFieldString<>("ztyzennouwrbkrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, BizNumber> ztytkyrt1 = new ExDBFieldString<>("ztytkyrt1", this, BizNumberType.class);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztytndzndkhikakukbn = new ExDBFieldString<>("ztytndzndkhikakukbn", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyyobiv5 = new ExDBFieldString<>("ztyyobiv5", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyzennoukaisiymd = new ExDBFieldString<>("ztyzennoukaisiymd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyzennoukbn = new ExDBFieldString<>("ztyzennoukbn", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyzennoukikan = new ExDBFieldString<>("ztyzennoukikan", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyzennounyuukinymd = new ExDBFieldString<>("ztyzennounyuukinymd", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztyzennounyuukinkgk = new ExDBFieldNumber<>("ztyzennounyuukinkgk", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyyobiv5x2 = new ExDBFieldString<>("ztyyobiv5x2", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyansyuyouyobin10 = new ExDBFieldString<>("ztyansyuyouyobin10", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyyobiv10x2 = new ExDBFieldString<>("ztyyobiv10x2", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztytoukimatuzennouzndk = new ExDBFieldNumber<>("ztytoukimatuzennouzndk", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztytoukijyuutoup = new ExDBFieldNumber<>("ztytoukijyuutoup", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztytoukizennouseisangk = new ExDBFieldNumber<>("ztytoukizennouseisangk", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztytoukizennounyuukinkgk = new ExDBFieldNumber<>("ztytoukizennounyuukinkgk", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztyyokukinenbaraip = new ExDBFieldNumber<>("ztyyokukinenbaraip", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztywrbkrttkyrttekiyouzndk = new ExDBFieldNumber<>("ztywrbkrttkyrttekiyouzndk", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztygkdtznnhyj = new ExDBFieldString<>("ztygkdtznnhyj", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyyenkanyknhyj = new ExDBFieldString<>("ztyyenkanyknhyj", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, BizNumber> ztynyknjikawaserate = new ExDBFieldString<>("ztynyknjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztynyknjikawaseratetkyuymd = new ExDBFieldString<>("ztynyknjikawaseratetkyuymd", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, BizNumber> ztyksnkisikawaserate = new ExDBFieldString<>("ztyksnkisikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, BizNumber> ztyznncalckjynymdkwsrate = new ExDBFieldString<>("ztyznncalckjynymdkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, BizNumber> ztyksnkimatukawaserate = new ExDBFieldString<>("ztyksnkimatukawaserate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztyzennounyuukinkgktkmatu = new ExDBFieldNumber<>("ztyzennounyuukinkgktkmatu", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztytkmatuznnzndktkmatu = new ExDBFieldNumber<>("ztytkmatuznnzndktkmatu", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldNumber<ZT_ZennouHoyuuIdouKykDtlTy, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldString<ZT_ZennouHoyuuIdouKykDtlTy, String> ztyyobiv23 = new ExDBFieldString<>("ztyyobiv23", this);
}
