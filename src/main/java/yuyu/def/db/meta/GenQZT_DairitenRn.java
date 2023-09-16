package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_DairitenRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 代理店ＰＲＴ用連動Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DairitenRn extends AbstractExDBTable<ZT_DairitenRn> {

    public GenQZT_DairitenRn() {
        this("ZT_DairitenRn");
    }

    public GenQZT_DairitenRn(String pAlias) {
        super("ZT_DairitenRn", ZT_DairitenRn.class, pAlias);
    }

    public String ZT_DairitenRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DairitenRn, String> zrndairitencd = new ExDBFieldString<>("zrndairitencd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndairitennm = new ExDBFieldString<>("zrndairitennm", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnkanjidairitennm = new ExDBFieldString<>("zrnkanjidairitennm", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnitakukeiyakuymd = new ExDBFieldString<>("zrnitakukeiyakuymd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnitakukeiyakukaiyakuymd = new ExDBFieldString<>("zrnitakukeiyakukaiyakuymd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndairitentourokuymd = new ExDBFieldString<>("zrndairitentourokuymd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndaisinhidaisinkbn = new ExDBFieldString<>("zrndaisinhidaisinkbn", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnkanrisosikicd1 = new ExDBFieldString<>("zrnkanrisosikicd1", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnkanrisosikicd2 = new ExDBFieldString<>("zrnkanrisosikicd2", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnkanrisosikicd3 = new ExDBFieldString<>("zrnkanrisosikicd3", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnkeisyousakidairitencd = new ExDBFieldString<>("zrnkeisyousakidairitencd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnkeisyoumotodairitencd = new ExDBFieldString<>("zrnkeisyoumotodairitencd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x1 = new ExDBFieldString<>("zrndrtensyouhncdkami3x1", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux1 = new ExDBFieldString<>("zrntsryshrkbntougetux1", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux1 = new ExDBFieldString<>("zrntsryshrkbnyokugetux1", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx1 = new ExDBFieldString<>("zrnbntnptnkbnx1", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x2 = new ExDBFieldString<>("zrndrtensyouhncdkami3x2", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux2 = new ExDBFieldString<>("zrntsryshrkbntougetux2", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux2 = new ExDBFieldString<>("zrntsryshrkbnyokugetux2", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx2 = new ExDBFieldString<>("zrnbntnptnkbnx2", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x3 = new ExDBFieldString<>("zrndrtensyouhncdkami3x3", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux3 = new ExDBFieldString<>("zrntsryshrkbntougetux3", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux3 = new ExDBFieldString<>("zrntsryshrkbnyokugetux3", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx3 = new ExDBFieldString<>("zrnbntnptnkbnx3", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x4 = new ExDBFieldString<>("zrndrtensyouhncdkami3x4", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux4 = new ExDBFieldString<>("zrntsryshrkbntougetux4", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux4 = new ExDBFieldString<>("zrntsryshrkbnyokugetux4", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx4 = new ExDBFieldString<>("zrnbntnptnkbnx4", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x5 = new ExDBFieldString<>("zrndrtensyouhncdkami3x5", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux5 = new ExDBFieldString<>("zrntsryshrkbntougetux5", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux5 = new ExDBFieldString<>("zrntsryshrkbnyokugetux5", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx5 = new ExDBFieldString<>("zrnbntnptnkbnx5", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x6 = new ExDBFieldString<>("zrndrtensyouhncdkami3x6", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux6 = new ExDBFieldString<>("zrntsryshrkbntougetux6", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux6 = new ExDBFieldString<>("zrntsryshrkbnyokugetux6", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx6 = new ExDBFieldString<>("zrnbntnptnkbnx6", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x7 = new ExDBFieldString<>("zrndrtensyouhncdkami3x7", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux7 = new ExDBFieldString<>("zrntsryshrkbntougetux7", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux7 = new ExDBFieldString<>("zrntsryshrkbnyokugetux7", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx7 = new ExDBFieldString<>("zrnbntnptnkbnx7", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x8 = new ExDBFieldString<>("zrndrtensyouhncdkami3x8", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux8 = new ExDBFieldString<>("zrntsryshrkbntougetux8", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux8 = new ExDBFieldString<>("zrntsryshrkbnyokugetux8", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx8 = new ExDBFieldString<>("zrnbntnptnkbnx8", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x9 = new ExDBFieldString<>("zrndrtensyouhncdkami3x9", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux9 = new ExDBFieldString<>("zrntsryshrkbntougetux9", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux9 = new ExDBFieldString<>("zrntsryshrkbnyokugetux9", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx9 = new ExDBFieldString<>("zrnbntnptnkbnx9", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x10 = new ExDBFieldString<>("zrndrtensyouhncdkami3x10", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux10 = new ExDBFieldString<>("zrntsryshrkbntougetux10", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux10 = new ExDBFieldString<>("zrntsryshrkbnyokugetux10", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx10 = new ExDBFieldString<>("zrnbntnptnkbnx10", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x11 = new ExDBFieldString<>("zrndrtensyouhncdkami3x11", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux11 = new ExDBFieldString<>("zrntsryshrkbntougetux11", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux11 = new ExDBFieldString<>("zrntsryshrkbnyokugetux11", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx11 = new ExDBFieldString<>("zrnbntnptnkbnx11", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x12 = new ExDBFieldString<>("zrndrtensyouhncdkami3x12", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux12 = new ExDBFieldString<>("zrntsryshrkbntougetux12", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux12 = new ExDBFieldString<>("zrntsryshrkbnyokugetux12", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx12 = new ExDBFieldString<>("zrnbntnptnkbnx12", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x13 = new ExDBFieldString<>("zrndrtensyouhncdkami3x13", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux13 = new ExDBFieldString<>("zrntsryshrkbntougetux13", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux13 = new ExDBFieldString<>("zrntsryshrkbnyokugetux13", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx13 = new ExDBFieldString<>("zrnbntnptnkbnx13", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x14 = new ExDBFieldString<>("zrndrtensyouhncdkami3x14", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux14 = new ExDBFieldString<>("zrntsryshrkbntougetux14", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux14 = new ExDBFieldString<>("zrntsryshrkbnyokugetux14", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx14 = new ExDBFieldString<>("zrnbntnptnkbnx14", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtensyouhncdkami3x15 = new ExDBFieldString<>("zrndrtensyouhncdkami3x15", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbntougetux15 = new ExDBFieldString<>("zrntsryshrkbntougetux15", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsryshrkbnyokugetux15 = new ExDBFieldString<>("zrntsryshrkbnyokugetux15", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbntnptnkbnx15 = new ExDBFieldString<>("zrnbntnptnkbnx15", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsrybntnaitedrtencdx1 = new ExDBFieldString<>("zrntsrybntnaitedrtencdx1", this);

    public final ExDBFieldString<ZT_DairitenRn, BizNumber> zrntsrybntnwarix1 = new ExDBFieldString<>("zrntsrybntnwarix1", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsrybntnaitedrtencdx2 = new ExDBFieldString<>("zrntsrybntnaitedrtencdx2", this);

    public final ExDBFieldString<ZT_DairitenRn, BizNumber> zrntsrybntnwarix2 = new ExDBFieldString<>("zrntsrybntnwarix2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsrybntnaitedrtencdx3 = new ExDBFieldString<>("zrntsrybntnaitedrtencdx3", this);

    public final ExDBFieldString<ZT_DairitenRn, BizNumber> zrntsrybntnwarix3 = new ExDBFieldString<>("zrntsrybntnwarix3", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntsrybntnaitedrtencdx4 = new ExDBFieldString<>("zrntsrybntnaitedrtencdx4", this);

    public final ExDBFieldString<ZT_DairitenRn, BizNumber> zrntsrybntnwarix4 = new ExDBFieldString<>("zrntsrybntnwarix4", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_DairitenRn, Integer> zrnhnsituhykranktougetu = new ExDBFieldNumber<>("zrnhnsituhykranktougetu", this);

    public final ExDBFieldNumber<ZT_DairitenRn, Integer> zrnhnsituhykrankyokugetu = new ExDBFieldNumber<>("zrnhnsituhykrankyokugetu", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnyobiv2x6 = new ExDBFieldString<>("zrnyobiv2x6", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndairitentelno = new ExDBFieldString<>("zrndairitentelno", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndairitenfaxno = new ExDBFieldString<>("zrndairitenfaxno", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnyobiv2 = new ExDBFieldString<>("zrnyobiv2", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnyobiv2x2 = new ExDBFieldString<>("zrnyobiv2x2", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnyobiv2x3 = new ExDBFieldString<>("zrnyobiv2x3", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnyobiv2x4 = new ExDBFieldString<>("zrnyobiv2x4", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnyobiv2x5 = new ExDBFieldString<>("zrnyobiv2x5", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnoyadairitencd = new ExDBFieldString<>("zrnoyadairitencd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndairitenkouryokustartymd = new ExDBFieldString<>("zrndairitenkouryokustartymd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndairitenkouryokuendymd = new ExDBFieldString<>("zrndairitenkouryokuendymd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnkinyuukikancd = new ExDBFieldString<>("zrnkinyuukikancd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnkinyuukikansitencd = new ExDBFieldString<>("zrnkinyuukikansitencd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndairitenjimusyocd = new ExDBFieldString<>("zrndairitenjimusyocd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndaihyoubosyuunincd = new ExDBFieldString<>("zrndaihyoubosyuunincd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnbuntanaitedairitencd = new ExDBFieldString<>("zrnbuntanaitedairitencd", this);

    public final ExDBFieldNumber<ZT_DairitenRn, Long> zrnbuntanwariai = new ExDBFieldNumber<>("zrnbuntanwariai", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntokureitiikihyouji = new ExDBFieldString<>("zrntokureitiikihyouji", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnkyoudousosikhyouji = new ExDBFieldString<>("zrnkyoudousosikhyouji", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnkyoudoubosyuhyouji = new ExDBFieldString<>("zrnkyoudoubosyuhyouji", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnyuuseijimusyocd = new ExDBFieldString<>("zrnyuuseijimusyocd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntoukatudairitencd = new ExDBFieldString<>("zrntoukatudairitencd", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnmdhnschemedrtenhyouji = new ExDBFieldString<>("zrnmdhnschemedrtenhyouji", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrntykatukaiyoudrtenhyouji = new ExDBFieldString<>("zrntykatukaiyoudrtenhyouji", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrndrtentrkno = new ExDBFieldString<>("zrndrtentrkno", this);

    public final ExDBFieldString<ZT_DairitenRn, String> zrnyobiv21 = new ExDBFieldString<>("zrnyobiv21", this);
}
