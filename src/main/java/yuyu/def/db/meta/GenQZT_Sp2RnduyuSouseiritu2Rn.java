package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu2Rn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * ＳＰ２連動用総成立Fテーブル２（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_Sp2RnduyuSouseiritu2Rn extends AbstractExDBTable<ZT_Sp2RnduyuSouseiritu2Rn> {

    public GenQZT_Sp2RnduyuSouseiritu2Rn() {
        this("ZT_Sp2RnduyuSouseiritu2Rn");
    }

    public GenQZT_Sp2RnduyuSouseiritu2Rn(String pAlias) {
        super("ZT_Sp2RnduyuSouseiritu2Rn", ZT_Sp2RnduyuSouseiritu2Rn.class, pAlias);
    }

    public String ZT_Sp2RnduyuSouseiritu2Rn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnktgysyrymd = new ExDBFieldString<>("zrnktgysyrymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnktgysyono = new ExDBFieldString<>("zrnktgysyono", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnktgyfilerenno = new ExDBFieldString<>("zrnktgyfilerenno", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsiteidairininkbn = new ExDBFieldString<>("zrnsiteidairininkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnstdairiseikyuutkykarihyj = new ExDBFieldString<>("zrnstdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsrkykdrkbn = new ExDBFieldString<>("zrnsrkykdrkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkykdrtkykarihyj = new ExDBFieldString<>("zrnkykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv6x3 = new ExDBFieldString<>("zrnyobiv6x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnlivingneedstkykarihyj = new ExDBFieldString<>("zrnlivingneedstkykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv4x12 = new ExDBFieldString<>("zrnyobiv4x12", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrngansupporttkykarihyj = new ExDBFieldString<>("zrngansupporttkykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv4x13 = new ExDBFieldString<>("zrnyobiv4x13", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntuuintokuyakusyuruikigou = new ExDBFieldString<>("zrntuuintokuyakusyuruikigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntuuintokuyakukikan = new ExDBFieldString<>("zrntuuintokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntuintkykphrkkkn = new ExDBFieldString<>("zrntuintkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrntuuintokuyakunitigaku = new ExDBFieldNumber<>("zrntuuintokuyakunitigaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntuuintokuyakup = new ExDBFieldNumber<>("zrntuuintokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntuuintokuyakugatakbn = new ExDBFieldString<>("zrntuuintokuyakugatakbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrntuintkjyuryumshyutn = new ExDBFieldNumber<>("zrntuintkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntuuintokujyoup = new ExDBFieldNumber<>("zrntuuintokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntuuintokuteibuicdx1 = new ExDBFieldString<>("zrntuuintokuteibuicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntuuinhutanpokikanx1 = new ExDBFieldString<>("zrntuuinhutanpokikanx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntuuintokuteibuicdx2 = new ExDBFieldString<>("zrntuuintokuteibuicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntuuinhutanpokikanx2 = new ExDBFieldString<>("zrntuuinhutanpokikanx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntuintkykkgusdkbn = new ExDBFieldString<>("zrntuintkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntuintkykpwrbkkbn = new ExDBFieldString<>("zrntuintkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv3x4 = new ExDBFieldString<>("zrnyobiv3x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2tuintkyksyrikgu = new ExDBFieldString<>("zrndi2tuintkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2tuuintokuyakukikan = new ExDBFieldString<>("zrndai2tuuintokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2tuintkykphrkkkn = new ExDBFieldString<>("zrndai2tuintkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrndai2tuuintokuyakuntgk = new ExDBFieldNumber<>("zrndai2tuuintokuyakuntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndai2tuuintokuyakup = new ExDBFieldNumber<>("zrndai2tuuintokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2tuuintokuyakugatakbn = new ExDBFieldString<>("zrndai2tuuintokuyakugatakbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrndi2tuintkjyuryumshyutn = new ExDBFieldNumber<>("zrndi2tuintkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndai2tuuintokujyoup = new ExDBFieldNumber<>("zrndai2tuuintokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2tuuintokuteibuicdx1 = new ExDBFieldString<>("zrndai2tuuintokuteibuicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2tuuinhutanpokikanx1 = new ExDBFieldString<>("zrndai2tuuinhutanpokikanx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2tuuintokuteibuicdx2 = new ExDBFieldString<>("zrndai2tuuintokuteibuicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2tuuinhutanpokikanx2 = new ExDBFieldString<>("zrndai2tuuinhutanpokikanx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2tuintkykkgusdkbn = new ExDBFieldString<>("zrndi2tuintkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2tuintkykpwrbkkbn = new ExDBFieldString<>("zrndi2tuintkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv3x5 = new ExDBFieldString<>("zrnyobiv3x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkangotokuyakusyuruikigou = new ExDBFieldString<>("zrnkangotokuyakusyuruikigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkangotokuyakukikan = new ExDBFieldString<>("zrnkangotokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkangotkykphrkkkn = new ExDBFieldString<>("zrnkangotkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrnkangotokuyakunitigaku = new ExDBFieldNumber<>("zrnkangotokuyakunitigaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkangotokuyakup = new ExDBFieldNumber<>("zrnkangotokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkangotokuyakugatakbn = new ExDBFieldString<>("zrnkangotokuyakugatakbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrnkngtkjyuryumshyutn = new ExDBFieldNumber<>("zrnkngtkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkangotokujyoup = new ExDBFieldNumber<>("zrnkangotokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkangotokuteibuicdx1 = new ExDBFieldString<>("zrnkangotokuteibuicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkangohutanpokikanx1 = new ExDBFieldString<>("zrnkangohutanpokikanx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkangotokuteibuicdx2 = new ExDBFieldString<>("zrnkangotokuteibuicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkangohutanpokikanx2 = new ExDBFieldString<>("zrnkangohutanpokikanx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2kngtkyksyrikgu = new ExDBFieldString<>("zrndi2kngtkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2kangotokuyakukikan = new ExDBFieldString<>("zrndai2kangotokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2kngtkykphrkkkn = new ExDBFieldString<>("zrndai2kngtkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrndai2kangotokuyakuntgk = new ExDBFieldNumber<>("zrndai2kangotokuyakuntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndai2kangotokuyakup = new ExDBFieldNumber<>("zrndai2kangotokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2kangotokuyakugatakbn = new ExDBFieldString<>("zrndai2kangotokuyakugatakbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrndi2kngtkjyuryumshyutn = new ExDBFieldNumber<>("zrndi2kngtkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndai2kangotokujyoup = new ExDBFieldNumber<>("zrndai2kangotokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2kangotokuteibuicdx1 = new ExDBFieldString<>("zrndai2kangotokuteibuicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2kangohutanpokikanx1 = new ExDBFieldString<>("zrndai2kangohutanpokikanx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2kangotokuteibuicdx2 = new ExDBFieldString<>("zrndai2kangotokuteibuicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2kangohutanpokikanx2 = new ExDBFieldString<>("zrndai2kangohutanpokikanx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv6x2 = new ExDBFieldString<>("zrnyobiv6x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjysisppitkyksyuruikgu = new ExDBFieldString<>("zrnjysisppitkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjysisppitkykkkn = new ExDBFieldString<>("zrnjysisppitkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjysisppitkykphrkkkn = new ExDBFieldString<>("zrnjysisppitkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrnjysisppitkykntgk = new ExDBFieldNumber<>("zrnjysisppitkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnjyoseisippeitokuyakup = new ExDBFieldNumber<>("zrnjyoseisippeitokuyakup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrnjysisppitkjyuryumshyutn = new ExDBFieldNumber<>("zrnjysisppitkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnjyoseisippeitokujyoup = new ExDBFieldNumber<>("zrnjyoseisippeitokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjysisppitktbicdx1 = new ExDBFieldString<>("zrnjysisppitktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjysisppihtnpkknx1 = new ExDBFieldString<>("zrnjysisppihtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjysisppitktbicdx2 = new ExDBFieldString<>("zrnjysisppitktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjysisppihtnpkknx2 = new ExDBFieldString<>("zrnjysisppihtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjysisppitkykkgusdkbn = new ExDBFieldString<>("zrnjysisppitkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjysisppitkykpwrbkkbn = new ExDBFieldString<>("zrnjysisppitkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjysisppitkykkusnmnryoage = new ExDBFieldString<>("zrnjysisppitkykkusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv2x2 = new ExDBFieldString<>("zrnyobiv2x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jysisppitkyksyrikgu = new ExDBFieldString<>("zrndi2jysisppitkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jysisppitkykkkn = new ExDBFieldString<>("zrndi2jysisppitkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jysisppitkykphrkkkn = new ExDBFieldString<>("zrndi2jysisppitkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrndi2jysisppitkykntgk = new ExDBFieldNumber<>("zrndi2jysisppitkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndi2jysisppitkykp = new ExDBFieldNumber<>("zrndi2jysisppitkykp", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrndi2jysisppitkjyurymshytn = new ExDBFieldNumber<>("zrndi2jysisppitkjyurymshytn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndi2jysisppitkjyup = new ExDBFieldNumber<>("zrndi2jysisppitkjyup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jysisppitktbicdx1 = new ExDBFieldString<>("zrndi2jysisppitktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jysisppihtnpkknx1 = new ExDBFieldString<>("zrndi2jysisppihtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jysisppitktbicdx2 = new ExDBFieldString<>("zrndi2jysisppitktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jysisppihtnpkknx2 = new ExDBFieldString<>("zrndi2jysisppihtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jysisppitkykkgusdkbn = new ExDBFieldString<>("zrndi2jysisppitkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jysisppitkykpwrbkkbn = new ExDBFieldString<>("zrndi2jysisppitkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv4x14 = new ExDBFieldString<>("zrnyobiv4x14", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnwinninglifehyouji = new ExDBFieldString<>("zrnwinninglifehyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnstyouikusikinuktrininkbn = new ExDBFieldString<>("zrnstyouikusikinuktrininkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyudthumeharaitkykarihyj = new ExDBFieldString<>("zrnjyudthumeharaitkykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsinkenkouseikatupackhyj = new ExDBFieldString<>("zrnsinkenkouseikatupackhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsyukeiyakupwaribikikbn = new ExDBFieldString<>("zrnsyukeiyakupwaribikikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsykyktnknyugukbn = new ExDBFieldString<>("zrnsykyktnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnmosjihonninkknnkbn = new ExDBFieldString<>("zrnmosjihonninkknnkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkituenhonsuu = new ExDBFieldString<>("zrnkituenhonsuu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkousinmaetenkannensuukbn = new ExDBFieldString<>("zrnkousinmaetenkannensuukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnmankimaetenkannensuukbn = new ExDBFieldString<>("zrnmankimaetenkannensuukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnseikitenkanhyouji = new ExDBFieldString<>("zrnseikitenkanhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrngengakutenkankykhyj = new ExDBFieldString<>("zrngengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv2x3 = new ExDBFieldString<>("zrnyobiv2x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkousin3nenmaetnknhyj = new ExDBFieldString<>("zrnkousin3nenmaetnknhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndugktnknsntkhuhukbn = new ExDBFieldString<>("zrndugktnknsntkhuhukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntnknsnstkbttrtkkbn = new ExDBFieldString<>("zrntnknsnstkbttrtkkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnhtnknsiginyuintkykgkntgk = new ExDBFieldNumber<>("zrnhtnknsiginyuintkykgkntgk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknsiginyuintkykkykymd = new ExDBFieldString<>("zrnhtnknsiginyuintkykkykymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknsiginyuintkyksnskbn = new ExDBFieldString<>("zrnhtnknsiginyuintkyksnskbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnhtnknsppinyuintkykgkntgk = new ExDBFieldNumber<>("zrnhtnknsppinyuintkykgkntgk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknsppinyuintkykkykymd = new ExDBFieldString<>("zrnhtnknsppinyuintkykkykymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknsppinyuintkyksnskbn = new ExDBFieldString<>("zrnhtnknsppinyuintkyksnskbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnhtnknsijnbyutkykgukintgk = new ExDBFieldNumber<>("zrnhtnknsijnbyutkykgukintgk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknsijnbyutkykkykymd = new ExDBFieldString<>("zrnhtnknsijnbyutkykkykymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknsijnbyutkyksnskbn = new ExDBFieldString<>("zrnhtnknsijnbyutkyksnskbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnhtnknjysisppitkykgkintgk = new ExDBFieldNumber<>("zrnhtnknjysisppitkykgkintgk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknjysisppitkykkykymd = new ExDBFieldString<>("zrnhtnknjysisppitkykkykymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknjysisppitkyksnskbn = new ExDBFieldString<>("zrnhtnknjysisppitkyksnskbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsiteizukipwarimasihyouji = new ExDBFieldString<>("zrnsiteizukipwarimasihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnpwarimasisiteim1 = new ExDBFieldString<>("zrnpwarimasisiteim1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnpwarimasisiteim2 = new ExDBFieldString<>("zrnpwarimasisiteim2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsiteimsykykpbairitu = new ExDBFieldString<>("zrnsiteimsykykpbairitu", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsiteizukisyukeiyakup = new ExDBFieldNumber<>("zrnsiteizukisyukeiyakup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntuujyoutukiharaikomip = new ExDBFieldNumber<>("zrntuujyoutukiharaikomip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsiteizukiharaikomip = new ExDBFieldNumber<>("zrnsiteizukiharaikomip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnmaruteikisiteizukip = new ExDBFieldNumber<>("zrnmaruteikisiteizukip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnseizonmaruteisiteimp = new ExDBFieldNumber<>("zrnseizonmaruteisiteimp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnmaruteipsiteibairitu = new ExDBFieldString<>("zrnmaruteipsiteibairitu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnseizonmaruteipstbairitu = new ExDBFieldString<>("zrnseizonmaruteipstbairitu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdtmrtisyuruikgu = new ExDBFieldString<>("zrnnkdtmrtisyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnenkindatemaruteikikan = new ExDBFieldString<>("zrnnenkindatemaruteikikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdatemaruteiphrkkkn = new ExDBFieldString<>("zrnnkdatemaruteiphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnnkdatemaruteinenkinnengk = new ExDBFieldNumber<>("zrnnkdatemaruteinenkinnengk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnnenkindatemaruteis = new ExDBFieldNumber<>("zrnnenkindatemaruteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnnenkindatemaruteip = new ExDBFieldNumber<>("zrnnenkindatemaruteip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnnkdatemaruteimods = new ExDBFieldNumber<>("zrnnkdatemaruteimods", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdtmrtimodsskgnhyj = new ExDBFieldString<>("zrnnkdtmrtimodsskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdatemaruteitkjyoukbn = new ExDBFieldString<>("zrnnkdatemaruteitkjyoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdtmrtitkjyouskgnkkn = new ExDBFieldString<>("zrnnkdtmrtitkjyouskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrnnkdtmrtitkjyouryumshytn = new ExDBFieldNumber<>("zrnnkdtmrtitkjyouryumshytn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnnkdatemaruteitkjyoup = new ExDBFieldNumber<>("zrnnkdatemaruteitkjyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknnkdtmrtisyuruikgux1 = new ExDBFieldString<>("zrnhtnknnkdtmrtisyuruikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknnkdtmrtisyuruikgux2 = new ExDBFieldString<>("zrnhtnknnkdtmrtisyuruikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknnkdtmrtisyuruikgux3 = new ExDBFieldString<>("zrnhtnknnkdtmrtisyuruikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknnkdtmrtisyuruikgux4 = new ExDBFieldString<>("zrnhtnknnkdtmrtisyuruikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknnkdtmrtisyuruikgux5 = new ExDBFieldString<>("zrnhtnknnkdtmrtisyuruikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknnkdtmrtisyuruikgux6 = new ExDBFieldString<>("zrnhtnknnkdtmrtisyuruikgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdatemaruteishrkkn = new ExDBFieldString<>("zrnnkdatemaruteishrkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsuriyounkdtmrtipwrbkkbn = new ExDBFieldString<>("zrnsuriyounkdtmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdatemaruteipwrbkkbn = new ExDBFieldString<>("zrnnkdatemaruteipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkyksiteimhyjx1 = new ExDBFieldString<>("zrnhtnknkyksiteimhyjx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkyksiteimhyjx2 = new ExDBFieldString<>("zrnhtnknkyksiteimhyjx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkyksiteimhyjx3 = new ExDBFieldString<>("zrnhtnknkyksiteimhyjx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkyksiteimhyjx4 = new ExDBFieldString<>("zrnhtnknkyksiteimhyjx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkyksiteimhyjx5 = new ExDBFieldString<>("zrnhtnknkyksiteimhyjx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkyksiteimhyjx6 = new ExDBFieldString<>("zrnhtnknkyksiteimhyjx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntyohkreinyutkbttrtkhyj = new ExDBFieldString<>("zrntyohkreinyutkbttrtkhyj", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkazokumrtinknengk = new ExDBFieldNumber<>("zrnkazokumrtinknengk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnalmyoukijyunym = new ExDBFieldString<>("zrnalmyoukijyunym", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsetaitesyono2 = new ExDBFieldString<>("zrnsetaitesyono2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsetaitehokensyuruikigou2 = new ExDBFieldString<>("zrnsetaitehokensyuruikigou2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsetaitemrtisyuruikgu2 = new ExDBFieldString<>("zrnsetaitemrtisyuruikgu2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsetaitesiznmrtisyurui2 = new ExDBFieldString<>("zrnsetaitesiznmrtisyurui2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsetaitetignmrtisyurui2 = new ExDBFieldString<>("zrnsetaitetignmrtisyurui2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsetaitekihonbubuns2 = new ExDBFieldNumber<>("zrnsetaitekihonbubuns2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsetgukitnknitjbrkhns2 = new ExDBFieldNumber<>("zrnsetgukitnknitjbrkhns2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsetaitesibous2 = new ExDBFieldNumber<>("zrnsetaitesibous2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsetgukitnknitjbrsbus2 = new ExDBFieldNumber<>("zrnsetgukitnknitjbrsbus2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsetaitesyuuseis2 = new ExDBFieldNumber<>("zrnsetaitesyuuseis2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsetaiteharaikomip2 = new ExDBFieldNumber<>("zrnsetaiteharaikomip2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsetaitesyukeiyakububunp2 = new ExDBFieldNumber<>("zrnsetaitesyukeiyakububunp2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsetaitgukikzkmrtis2 = new ExDBFieldNumber<>("zrnsetaitgukikzkmrtis2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsetaitetenkankykhyj2 = new ExDBFieldString<>("zrnsetaitetenkankykhyj2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsetaitesiteimhrkp2 = new ExDBFieldNumber<>("zrnsetaitesiteimhrkp2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsetaitesiteimsykykp2 = new ExDBFieldNumber<>("zrnsetaitesiteimsykykp2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsetaitenkmrtisyurui2 = new ExDBFieldString<>("zrnsetaitenkmrtisyurui2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsetaitehknkgusdkbn2 = new ExDBFieldString<>("zrnsetaitehknkgusdkbn2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv17 = new ExDBFieldString<>("zrnyobiv17", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndujmossitismodsyuguhyj = new ExDBFieldString<>("zrndujmossitismodsyuguhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnrnsijhiyubrijdujmoskbn = new ExDBFieldString<>("zrnrnsijhiyubrijdujmoskbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntktsppisykyktikknbbns = new ExDBFieldNumber<>("zrntktsppisykyktikknbbns", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntksttkyksyuruikgu = new ExDBFieldString<>("zrntksttkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntokusitutokuyakukikan = new ExDBFieldString<>("zrntokusitutokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntksttkykphrkkkn = new ExDBFieldString<>("zrntksttkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntokusitutokuyakus = new ExDBFieldNumber<>("zrntokusitutokuyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntokusitutokuyakup = new ExDBFieldNumber<>("zrntokusitutokuyakup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntokusitutokuyakusyuuseis = new ExDBFieldNumber<>("zrntokusitutokuyakusyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntksttkykmodssakugenhyj = new ExDBFieldString<>("zrntksttkykmodssakugenhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntksttkyktkjyukbn = new ExDBFieldString<>("zrntksttkyktkjyukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntksttkyktkjyuskgnkkn = new ExDBFieldString<>("zrntksttkyktkjyuskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrntksttkyktkjyuryumshyutn = new ExDBFieldNumber<>("zrntksttkyktkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntksttkyktkjyup = new ExDBFieldNumber<>("zrntksttkyktkjyup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntksttkyktikknbbns = new ExDBFieldNumber<>("zrntksttkyktikknbbns", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntktsppitkykkgux1 = new ExDBFieldString<>("zrnhtnkntktsppitkykkgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntktsppitkykkgux2 = new ExDBFieldString<>("zrnhtnkntktsppitkykkgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntktsppitkykkgux3 = new ExDBFieldString<>("zrnhtnkntktsppitkykkgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntktsppitkykkgux4 = new ExDBFieldString<>("zrnhtnkntktsppitkykkgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntktsppitkykkgux5 = new ExDBFieldString<>("zrnhtnkntktsppitkykkgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntktsppitkykkgux6 = new ExDBFieldString<>("zrnhtnkntktsppitkykkgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsuryutksttkykpwrbkkbn = new ExDBFieldString<>("zrnsuryutksttkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntksttkykpwrbkkbn = new ExDBFieldString<>("zrntksttkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntksttkyktnknyugukbn = new ExDBFieldString<>("zrntksttkyktnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntksttkykkgusdkbn = new ExDBFieldString<>("zrntksttkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv9x8 = new ExDBFieldString<>("zrnyobiv9x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2tksttkyksyrikgu = new ExDBFieldString<>("zrndi2tksttkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2tokusitutokuyakukkn = new ExDBFieldString<>("zrndai2tokusitutokuyakukkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2tksttkykphrkkkn = new ExDBFieldString<>("zrndai2tksttkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndai2tokusitutokuyakus = new ExDBFieldNumber<>("zrndai2tokusitutokuyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndai2tokusitutokuyakup = new ExDBFieldNumber<>("zrndai2tokusitutokuyakup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndi2tksttkyksyuuseis = new ExDBFieldNumber<>("zrndi2tksttkyksyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2tksttkykmodsskgnhyj = new ExDBFieldString<>("zrndi2tksttkykmodsskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2tksttkyktkjyukbn = new ExDBFieldString<>("zrndi2tksttkyktkjyukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2tksttkyktkjyuskgnkkn = new ExDBFieldString<>("zrndi2tksttkyktkjyuskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrndi2tksttkyktkjyurymshytn = new ExDBFieldNumber<>("zrndi2tksttkyktkjyurymshytn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndi2tksttkyktkjyup = new ExDBFieldNumber<>("zrndi2tksttkyktkjyup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndi2tksttkyktaikknbbns = new ExDBFieldNumber<>("zrndi2tksttkyktaikknbbns", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2tktsppitkykkgux1 = new ExDBFieldString<>("zrnhtnkndi2tktsppitkykkgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2tktsppitkykkgux2 = new ExDBFieldString<>("zrnhtnkndi2tktsppitkykkgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2tktsppitkykkgux3 = new ExDBFieldString<>("zrnhtnkndi2tktsppitkykkgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2tktsppitkykkgux4 = new ExDBFieldString<>("zrnhtnkndi2tktsppitkykkgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2tktsppitkykkgux5 = new ExDBFieldString<>("zrnhtnkndi2tktsppitkykkgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2tktsppitkykkgux6 = new ExDBFieldString<>("zrnhtnkndi2tktsppitkykkgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsuryudi2tksttkykpwrbkkbn = new ExDBFieldString<>("zrnsuryudi2tksttkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2tksttkykpwrbkkbn = new ExDBFieldString<>("zrndi2tksttkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2tksttkyktnknyugukbn = new ExDBFieldString<>("zrndi2tksttkyktnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2tksttkykkgusdkbn = new ExDBFieldString<>("zrndi2tksttkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv9x9 = new ExDBFieldString<>("zrnyobiv9x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyuusitutkyksyuruikgu = new ExDBFieldString<>("zrnjyuusitutkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyuusitutokuyakukikan = new ExDBFieldString<>("zrnjyuusitutokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyuusitutkykphrkkkn = new ExDBFieldString<>("zrnjyuusitutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnjyuusitutokuyakus = new ExDBFieldNumber<>("zrnjyuusitutokuyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnjyuusitutokuyakup = new ExDBFieldNumber<>("zrnjyuusitutokuyakup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnjyuusitutokuyakusyuuseis = new ExDBFieldNumber<>("zrnjyuusitutokuyakusyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyuusitutkykmodsskgnhyj = new ExDBFieldString<>("zrnjyuusitutkykmodsskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyuusitutkyktkjyukbn = new ExDBFieldString<>("zrnjyuusitutkyktkjyukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyuusitutkyktkjyuskgnkkn = new ExDBFieldString<>("zrnjyuusitutkyktkjyuskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrnjyusttkyktkjyuryumshyutn = new ExDBFieldNumber<>("zrnjyusttkyktkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnjyuusitutkyktkjyup = new ExDBFieldNumber<>("zrnjyuusitutkyktkjyup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyuusitutkyktktbicdx1 = new ExDBFieldString<>("zrnjyuusitutkyktktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyuusitutkykhtnpkknx1 = new ExDBFieldString<>("zrnjyuusitutkykhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyuusitutkyktktbicdx2 = new ExDBFieldString<>("zrnjyuusitutkyktktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyuusitutkykhtnpkknx2 = new ExDBFieldString<>("zrnjyuusitutkykhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknmnsiskkntkykkgux1 = new ExDBFieldString<>("zrnhtnknmnsiskkntkykkgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknmnsiskkntkykkgux2 = new ExDBFieldString<>("zrnhtnknmnsiskkntkykkgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknmnsiskkntkykkgux3 = new ExDBFieldString<>("zrnhtnknmnsiskkntkykkgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknmnsiskkntkykkgux4 = new ExDBFieldString<>("zrnhtnknmnsiskkntkykkgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknmnsiskkntkykkgux5 = new ExDBFieldString<>("zrnhtnknmnsiskkntkykkgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknmnsiskkntkykkgux6 = new ExDBFieldString<>("zrnhtnknmnsiskkntkykkgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsuryujyusttkykpwrbkkbn = new ExDBFieldString<>("zrnsuryujyusttkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyuusitutkykpwrbkkbn = new ExDBFieldString<>("zrnjyuusitutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyuusitutkyktnknyugukbn = new ExDBFieldString<>("zrnjyuusitutkyktnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnjyuusitutkykkgusdkbn = new ExDBFieldString<>("zrnjyuusitutkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv7x3 = new ExDBFieldString<>("zrnyobiv7x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jyuusitutkyksyrikgu = new ExDBFieldString<>("zrndi2jyuusitutkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jyuusitutkykkkn = new ExDBFieldString<>("zrndi2jyuusitutkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jyuusitutkykphrkkkn = new ExDBFieldString<>("zrndi2jyuusitutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndai2jyuusitutokuyakus = new ExDBFieldNumber<>("zrndai2jyuusitutokuyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndai2jyuusitutokuyakup = new ExDBFieldNumber<>("zrndai2jyuusitutokuyakup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndi2jyuusitutkyksyuuseis = new ExDBFieldNumber<>("zrndi2jyuusitutkyksyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jyusttkykmodsskgnhyj = new ExDBFieldString<>("zrndi2jyusttkykmodsskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jyuusitutkyktkjyukbn = new ExDBFieldString<>("zrndi2jyuusitutkyktkjyukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jyusttkyktkjyuskgnkkn = new ExDBFieldString<>("zrndi2jyusttkyktkjyuskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrndi2jyusttkyktkjyrymshytn = new ExDBFieldNumber<>("zrndi2jyusttkyktkjyrymshytn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndi2jyuusitutkyktkjyup = new ExDBFieldNumber<>("zrndi2jyuusitutkyktkjyup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jyuusitutkyktktbicdx1 = new ExDBFieldString<>("zrndi2jyuusitutkyktktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jyuusitutkykhtnpkknx1 = new ExDBFieldString<>("zrndi2jyuusitutkykhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jyuusitutkyktktbicdx2 = new ExDBFieldString<>("zrndi2jyuusitutkyktktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jyuusitutkykhtnpkknx2 = new ExDBFieldString<>("zrndi2jyuusitutkykhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2mnsiskkntkykkgx1 = new ExDBFieldString<>("zrnhtnkndi2mnsiskkntkykkgx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2mnsiskkntkykkgx2 = new ExDBFieldString<>("zrnhtnkndi2mnsiskkntkykkgx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2mnsiskkntkykkgx3 = new ExDBFieldString<>("zrnhtnkndi2mnsiskkntkykkgx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2mnsiskkntkykkgx4 = new ExDBFieldString<>("zrnhtnkndi2mnsiskkntkykkgx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2mnsiskkntkykkgx5 = new ExDBFieldString<>("zrnhtnkndi2mnsiskkntkykkgx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2mnsiskkntkykkgx6 = new ExDBFieldString<>("zrnhtnkndi2mnsiskkntkykkgx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsuryud2jyusttkykpwrbkkbn = new ExDBFieldString<>("zrnsuryud2jyusttkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jyuusitutkykpwrbkkbn = new ExDBFieldString<>("zrndi2jyuusitutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jyusttkyktnknyugukbn = new ExDBFieldString<>("zrndi2jyusttkyktnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2jyuusitutkykkgusdkbn = new ExDBFieldString<>("zrndi2jyuusitutkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv7x4 = new ExDBFieldString<>("zrnyobiv7x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhaitousiharaikbn = new ExDBFieldString<>("zrnhaitousiharaikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsuryusykykpwrbkkbn = new ExDBFieldString<>("zrnsuryusykykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdatetokuteisyuruikgu = new ExDBFieldString<>("zrnnkdatetokuteisyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnenkindatetokuteikikan = new ExDBFieldString<>("zrnnenkindatetokuteikikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnnkdatetokuteinkgk = new ExDBFieldNumber<>("zrnnkdatetokuteinkgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnnenkindatetokuteis = new ExDBFieldNumber<>("zrnnenkindatetokuteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnnenkindatetokuteip = new ExDBFieldNumber<>("zrnnenkindatetokuteip", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdatetokuteisdtpdtkbn = new ExDBFieldString<>("zrnnkdatetokuteisdtpdtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnnkdatetokuteimods = new ExDBFieldNumber<>("zrnnkdatetokuteimods", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdatetokuteimodsskgnhyj = new ExDBFieldString<>("zrnnkdatetokuteimodsskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdatetokuteishrkkn = new ExDBFieldString<>("zrnnkdatetokuteishrkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkykniyutksytioukbn = new ExDBFieldString<>("zrnkykniyutksytioukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkeika2nenmimantenkanhyj = new ExDBFieldString<>("zrnkeika2nenmimantenkanhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntukiyuhtnknkusnmennsukbn = new ExDBFieldString<>("zrntukiyuhtnknkusnmennsukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdatetokuteikgusdkbn = new ExDBFieldString<>("zrnnkdatetokuteikgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnenkindatetokuteikatakbn = new ExDBFieldString<>("zrnnenkindatetokuteikatakbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv2x4 = new ExDBFieldString<>("zrnyobiv2x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsugusnsyutkyksyuruikgu = new ExDBFieldString<>("zrnsugusnsyutkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsugusnsyutkykkkn = new ExDBFieldString<>("zrnsugusnsyutkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsugusnsyutkykphrkkkn = new ExDBFieldString<>("zrnsugusnsyutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsougousonsyoutokuyakus = new ExDBFieldNumber<>("zrnsougousonsyoutokuyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsougousonsyoutokuyakup = new ExDBFieldNumber<>("zrnsougousonsyoutokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsugusnsyutkykkgusdkbn = new ExDBFieldString<>("zrnsugusnsyutkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsugusnsyutkykpwrbkkbn = new ExDBFieldString<>("zrnsugusnsyutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsugusnsyutkykkusnmnryage = new ExDBFieldString<>("zrnsugusnsyutkykkusnmnryage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv7x5 = new ExDBFieldString<>("zrnyobiv7x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sugusnsyutkyksyrikgu = new ExDBFieldString<>("zrndi2sugusnsyutkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sugusnsyutkykkkn = new ExDBFieldString<>("zrndi2sugusnsyutkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sugusnsyutkykphrkkkn = new ExDBFieldString<>("zrndi2sugusnsyutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndi2sugusnsyutkyks = new ExDBFieldNumber<>("zrndi2sugusnsyutkyks", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndi2sugusnsyutkykp = new ExDBFieldNumber<>("zrndi2sugusnsyutkykp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sugusnsytkykkgusdkbn = new ExDBFieldString<>("zrndi2sugusnsytkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sugusnsyutkykpwrbkkbn = new ExDBFieldString<>("zrndi2sugusnsyutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv9x10 = new ExDBFieldString<>("zrnyobiv9x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntenkankeitaikbn = new ExDBFieldString<>("zrntenkankeitaikbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngukitnknitjbrtiknknengk = new ExDBFieldNumber<>("zrngukitnknitjbrtiknknengk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngukihtnknsugusnsyutkyks = new ExDBFieldNumber<>("zrngukihtnknsugusnsyutkyks", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntenkanitijibaraip = new ExDBFieldNumber<>("zrntenkanitijibaraip", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv24 = new ExDBFieldString<>("zrnyobiv24", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngoukeinenbaraikansanpx1 = new ExDBFieldNumber<>("zrngoukeinenbaraikansanpx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhktgtikkikkknx1 = new ExDBFieldString<>("zrnhktgtikkikkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkykkigmrsysyrikgux1 = new ExDBFieldString<>("zrnhtnknkykkigmrsysyrikgux1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngoukeinenbaraikansanpx2 = new ExDBFieldNumber<>("zrngoukeinenbaraikansanpx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhktgtikkikkknx2 = new ExDBFieldString<>("zrnhktgtikkikkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkykkigmrsysyrikgux2 = new ExDBFieldString<>("zrnhtnknkykkigmrsysyrikgux2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngoukeinenbaraikansanpx3 = new ExDBFieldNumber<>("zrngoukeinenbaraikansanpx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhktgtikkikkknx3 = new ExDBFieldString<>("zrnhktgtikkikkknx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkykkigmrsysyrikgux3 = new ExDBFieldString<>("zrnhtnknkykkigmrsysyrikgux3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngoukeinenbaraikansanpx4 = new ExDBFieldNumber<>("zrngoukeinenbaraikansanpx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhktgtikkikkknx4 = new ExDBFieldString<>("zrnhktgtikkikkknx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkykkigmrsysyrikgux4 = new ExDBFieldString<>("zrnhtnknkykkigmrsysyrikgux4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngoukeinenbaraikansanpx5 = new ExDBFieldNumber<>("zrngoukeinenbaraikansanpx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhktgtikkikkknx5 = new ExDBFieldString<>("zrnhktgtikkikkknx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkykkigmrsysyrikgux5 = new ExDBFieldString<>("zrnhtnknkykkigmrsysyrikgux5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngoukeinenbaraikansanpx6 = new ExDBFieldNumber<>("zrngoukeinenbaraikansanpx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhktgtikkikkknx6 = new ExDBFieldString<>("zrnhktgtikkikkknx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkykkigmrsysyrikgux6 = new ExDBFieldString<>("zrnhtnknkykkigmrsysyrikgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnniceonplanhyj = new ExDBFieldString<>("zrnniceonplanhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsyokaipryosyuymd = new ExDBFieldString<>("zrnsyokaipryosyuymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnldownmaetenkannensuukbn = new ExDBFieldString<>("zrnldownmaetenkannensuukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnldownmaesaiteismitatuhyj = new ExDBFieldString<>("zrnldownmaesaiteismitatuhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndntitikgtkbttrtkhyj = new ExDBFieldString<>("zrndntitikgtkbttrtkhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnreformkbn = new ExDBFieldString<>("zrnreformkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkikeiyakutyuuihyouji = new ExDBFieldString<>("zrnkikeiyakutyuuihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkbnkeiriyousegcd = new ExDBFieldString<>("zrnkbnkeiriyousegcd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsyuuseiskiteitekiyoukbn = new ExDBFieldString<>("zrnsyuuseiskiteitekiyoukbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngukihtnknkzkmrtimods = new ExDBFieldNumber<>("zrngukihtnknkzkmrtimods", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntnknkijyntkyuhtnknsbus = new ExDBFieldNumber<>("zrntnknkijyntkyuhtnknsbus", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsrjsnyusyouhinhyj = new ExDBFieldString<>("zrnsrjsnyusyouhinhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsirajikakuninzumihyouji = new ExDBFieldString<>("zrnsirajikakuninzumihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsrjsnyusyouhintknnhyj = new ExDBFieldString<>("zrnsrjsnyusyouhintknnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsinsakbn = new ExDBFieldString<>("zrnsinsakbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2sinsakbn = new ExDBFieldString<>("zrndai2sinsakbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntoukeiyousinsakbn = new ExDBFieldString<>("zrntoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndai2toukeiyousinsakbn = new ExDBFieldString<>("zrndai2toukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnseizonkyuhknshrsiteimd = new ExDBFieldString<>("zrnseizonkyuhknshrsiteimd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, BizNumber> zrnyoteiriritun5 = new ExDBFieldString<>("zrnyoteiriritun5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, BizNumber> zrnsaiteihosyouriritu = new ExDBFieldString<>("zrnsaiteihosyouriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, BizNumber> zrnnkgnsritu = new ExDBFieldString<>("zrnnkgnsritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnjigyounendomatuv = new ExDBFieldNumber<>("zrnjigyounendomatuv", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngukihtnkn5nnmeksnyumods = new ExDBFieldNumber<>("zrngukihtnkn5nnmeksnyumods", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnrenseiteikitksyusnksnhyj = new ExDBFieldString<>("zrnrenseiteikitksyusnksnhyj", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngoukeinenbaraikansanp2x1 = new ExDBFieldNumber<>("zrngoukeinenbaraikansanp2x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrngukinenbaraiknsnp2kbnx1 = new ExDBFieldString<>("zrngukinenbaraiknsnp2kbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhktgtikkikkkn2x1 = new ExDBFieldString<>("zrnhktgtikkikkkn2x1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngoukeinenbaraikansanp2x2 = new ExDBFieldNumber<>("zrngoukeinenbaraikansanp2x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrngukinenbaraiknsnp2kbnx2 = new ExDBFieldString<>("zrngukinenbaraiknsnp2kbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhktgtikkikkkn2x2 = new ExDBFieldString<>("zrnhktgtikkikkkn2x2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngoukeinenbaraikansanp2x3 = new ExDBFieldNumber<>("zrngoukeinenbaraikansanp2x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrngukinenbaraiknsnp2kbnx3 = new ExDBFieldString<>("zrngukinenbaraiknsnp2kbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhktgtikkikkkn2x3 = new ExDBFieldString<>("zrnhktgtikkikkkn2x3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngoukeinenbaraikansanp2x4 = new ExDBFieldNumber<>("zrngoukeinenbaraikansanp2x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrngukinenbaraiknsnp2kbnx4 = new ExDBFieldString<>("zrngukinenbaraiknsnp2kbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhktgtikkikkkn2x4 = new ExDBFieldString<>("zrnhktgtikkikkkn2x4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngoukeinenbaraikansanp2x5 = new ExDBFieldNumber<>("zrngoukeinenbaraikansanp2x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrngukinenbaraiknsnp2kbnx5 = new ExDBFieldString<>("zrngukinenbaraiknsnp2kbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhktgtikkikkkn2x5 = new ExDBFieldString<>("zrnhktgtikkikkkn2x5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrngoukeinenbaraikansanp2x6 = new ExDBFieldNumber<>("zrngoukeinenbaraikansanp2x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrngukinenbaraiknsnp2kbnx6 = new ExDBFieldString<>("zrngukinenbaraiknsnp2kbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhktgtikkikkkn2x6 = new ExDBFieldString<>("zrnhktgtikkikkkn2x6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkokutituusantaisyous = new ExDBFieldNumber<>("zrnkokutituusantaisyous", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntokusyuyouroumankis = new ExDBFieldNumber<>("zrntokusyuyouroumankis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdtmrtitnknyuuguukbn = new ExDBFieldString<>("zrnnkdtmrtitnknyuuguukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdtmrtikgusdkbn = new ExDBFieldString<>("zrnnkdtmrtikgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnenkindatemaruteikatakbn = new ExDBFieldString<>("zrnnenkindatemaruteikatakbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnkdtmrtikusnmnryoage = new ExDBFieldString<>("zrnnkdtmrtikusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdtmrtisyuruikgu = new ExDBFieldString<>("zrnkaigonkdtmrtisyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdtmrtikkan = new ExDBFieldString<>("zrnkaigonkdtmrtikkan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdtmrtiphrkkkn = new ExDBFieldString<>("zrnkaigonkdtmrtiphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigonkdtmrtinnknnengk = new ExDBFieldNumber<>("zrnkaigonkdtmrtinnknnengk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigonkdtmrtis = new ExDBFieldNumber<>("zrnkaigonkdtmrtis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigonkdtmrtip = new ExDBFieldNumber<>("zrnkaigonkdtmrtip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigonkdtmrtimods = new ExDBFieldNumber<>("zrnkaigonkdtmrtimods", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdtmrtitkjyukbn = new ExDBFieldString<>("zrnkaigonkdtmrtitkjyukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdtmrtitkjyskgnkkn = new ExDBFieldString<>("zrnkaigonkdtmrtitkjyskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrnkaigonkdtmrttkjyrymshytn = new ExDBFieldNumber<>("zrnkaigonkdtmrttkjyrymshytn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigonkdtmrtitkjyup = new ExDBFieldNumber<>("zrnkaigonkdtmrtitkjyup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonkmrtsyrikgux1 = new ExDBFieldString<>("zrnhtnknkaigonkmrtsyrikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonkmrtsyrikgux2 = new ExDBFieldString<>("zrnhtnknkaigonkmrtsyrikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonkmrtsyrikgux3 = new ExDBFieldString<>("zrnhtnknkaigonkmrtsyrikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonkmrtsyrikgux4 = new ExDBFieldString<>("zrnhtnknkaigonkmrtsyrikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonkmrtsyrikgux5 = new ExDBFieldString<>("zrnhtnknkaigonkmrtsyrikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonkmrtsyrikgux6 = new ExDBFieldString<>("zrnhtnknkaigonkmrtsyrikgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdtmrtishrkkn = new ExDBFieldString<>("zrnkaigonkdtmrtishrkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsurikaigonkmrtipwrbkkbn = new ExDBFieldString<>("zrnsurikaigonkmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdtmrtipwrbkkbn = new ExDBFieldString<>("zrnkaigonkdtmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdtmrtitnknyugukbn = new ExDBFieldString<>("zrnkaigonkdtmrtitnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdtmrtikgusdkbn = new ExDBFieldString<>("zrnkaigonkdtmrtikgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdtmrtiktkbn = new ExDBFieldString<>("zrnkaigonkdtmrtiktkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkignkdtmrtikusnmnryoage = new ExDBFieldString<>("zrnkignkdtmrtikusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdttktisyuruikgu = new ExDBFieldString<>("zrnkaigonkdttktisyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdttktikkn = new ExDBFieldString<>("zrnkaigonkdttktikkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigonkdttkteinenkngk = new ExDBFieldNumber<>("zrnkaigonkdttkteinenkngk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigonenkindatetokuteis = new ExDBFieldNumber<>("zrnkaigonenkindatetokuteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigonenkindatetokuteip = new ExDBFieldNumber<>("zrnkaigonenkindatetokuteip", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdttktisdtpdtkbn = new ExDBFieldString<>("zrnkaigonkdttktisdtpdtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigonkdttktimods = new ExDBFieldNumber<>("zrnkaigonkdttktimods", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdttktishrkkn = new ExDBFieldString<>("zrnkaigonkdttktishrkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdttktikgusdkbn = new ExDBFieldString<>("zrnkaigonkdttktikgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonkdttktiktkbn = new ExDBFieldString<>("zrnkaigonkdttktiktkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkignkdttktikusnmnryoage = new ExDBFieldString<>("zrnkignkdttktikusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv2x5 = new ExDBFieldString<>("zrnyobiv2x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigoteigenmrtisyuruikgu = new ExDBFieldString<>("zrnkaigoteigenmrtisyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigoteigenmaruteikikan = new ExDBFieldString<>("zrnkaigoteigenmaruteikikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigotignmrtiphrkkkn = new ExDBFieldString<>("zrnkaigotignmrtiphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigoteigenmaruteis = new ExDBFieldNumber<>("zrnkaigoteigenmaruteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigoteigenmaruteip = new ExDBFieldNumber<>("zrnkaigoteigenmaruteip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkigtignmrtimods = new ExDBFieldNumber<>("zrnkigtignmrtimods", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkigtignmrtitkjyukbn = new ExDBFieldString<>("zrnkigtignmrtitkjyukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkigtignmrtitkjyuskgnkkn = new ExDBFieldString<>("zrnkigtignmrtitkjyuskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrnkigtignmrtitkjyurymshytn = new ExDBFieldNumber<>("zrnkigtignmrtitkjyurymshytn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkigtignmrtitkjyup = new ExDBFieldNumber<>("zrnkigtignmrtitkjyup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigtignmrtsyrikgux1 = new ExDBFieldString<>("zrnhtnknkigtignmrtsyrikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigtignmrtsyrikgux2 = new ExDBFieldString<>("zrnhtnknkigtignmrtsyrikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigtignmrtsyrikgux3 = new ExDBFieldString<>("zrnhtnknkigtignmrtsyrikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigtignmrtsyrikgux4 = new ExDBFieldString<>("zrnhtnknkigtignmrtsyrikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigtignmrtsyrikgux5 = new ExDBFieldString<>("zrnhtnknkigtignmrtsyrikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigtignmrtsyrikgux6 = new ExDBFieldString<>("zrnhtnknkigtignmrtsyrikgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsurkigtignmrtipwrbkkbn = new ExDBFieldString<>("zrnsurkigtignmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkigtignmrtipwrbkkbn = new ExDBFieldString<>("zrnkigtignmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkigtignmrtitnknyugukbn = new ExDBFieldString<>("zrnkigtignmrtitnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigotignmrtikgusdkbn = new ExDBFieldString<>("zrnkaigotignmrtikgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkigtignmrtikusnmnryoage = new ExDBFieldString<>("zrnkigtignmrtikusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv4x15 = new ExDBFieldString<>("zrnyobiv4x15", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigoteigentktisyuruikgu = new ExDBFieldString<>("zrnkaigoteigentktisyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigoteigentokuteikikan = new ExDBFieldString<>("zrnkaigoteigentokuteikikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigoteigentokuteis = new ExDBFieldNumber<>("zrnkaigoteigentokuteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigoteigentokuteip = new ExDBFieldNumber<>("zrnkaigoteigentokuteip", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkigtigntktisdtpdtkbn = new ExDBFieldString<>("zrnkigtigntktisdtpdtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkigtigntktimods = new ExDBFieldNumber<>("zrnkigtigntktimods", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigotigntktikgusdkbn = new ExDBFieldString<>("zrnkaigotigntktikgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkigtigntktikusnmnryoage = new ExDBFieldString<>("zrnkigtigntktikusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv2x6 = new ExDBFieldString<>("zrnyobiv2x6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnhikitugikaimasis = new ExDBFieldNumber<>("zrnhikitugikaimasis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkyhtisyukykumkbn = new ExDBFieldString<>("zrncbkyhtisyukykumkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntukiyucbkyhtisyus = new ExDBFieldNumber<>("zrntukiyucbkyhtisyus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrncbhanteituusans = new ExDBFieldNumber<>("zrncbhanteituusans", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntukiyusnkykcbhntis = new ExDBFieldNumber<>("zrntukiyusnkykcbhntis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbstagekbn = new ExDBFieldString<>("zrncbstagekbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntoukeiyoucbhanteituusans = new ExDBFieldNumber<>("zrntoukeiyoucbhanteituusans", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrncbtuusankensuu = new ExDBFieldNumber<>("zrncbtuusankensuu", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrncbhanteitaisyoutsnkensuu = new ExDBFieldNumber<>("zrncbhanteitaisyoutsnkensuu", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzentuusanhanteisx1 = new ExDBFieldNumber<>("zrntyokuzentuusanhanteisx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzenkyuuhutaisyousx1 = new ExDBFieldNumber<>("zrntyokuzenkyuuhutaisyousx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzencbgakux1 = new ExDBFieldNumber<>("zrntyokuzencbgakux1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugotuusanhanteisx1 = new ExDBFieldNumber<>("zrntyokugotuusanhanteisx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugokyuuhutaisyousx1 = new ExDBFieldNumber<>("zrntyokugokyuuhutaisyousx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugocbgakux1 = new ExDBFieldNumber<>("zrntyokugocbgakux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv12 = new ExDBFieldString<>("zrnyobiv12", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzentuusanhanteisx2 = new ExDBFieldNumber<>("zrntyokuzentuusanhanteisx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzenkyuuhutaisyousx2 = new ExDBFieldNumber<>("zrntyokuzenkyuuhutaisyousx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzencbgakux2 = new ExDBFieldNumber<>("zrntyokuzencbgakux2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugotuusanhanteisx2 = new ExDBFieldNumber<>("zrntyokugotuusanhanteisx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugokyuuhutaisyousx2 = new ExDBFieldNumber<>("zrntyokugokyuuhutaisyousx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugocbgakux2 = new ExDBFieldNumber<>("zrntyokugocbgakux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv12x2 = new ExDBFieldString<>("zrnyobiv12x2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzentuusanhanteisx3 = new ExDBFieldNumber<>("zrntyokuzentuusanhanteisx3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzenkyuuhutaisyousx3 = new ExDBFieldNumber<>("zrntyokuzenkyuuhutaisyousx3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzencbgakux3 = new ExDBFieldNumber<>("zrntyokuzencbgakux3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugotuusanhanteisx3 = new ExDBFieldNumber<>("zrntyokugotuusanhanteisx3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugokyuuhutaisyousx3 = new ExDBFieldNumber<>("zrntyokugokyuuhutaisyousx3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugocbgakux3 = new ExDBFieldNumber<>("zrntyokugocbgakux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv12x3 = new ExDBFieldString<>("zrnyobiv12x3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzentuusanhanteisx4 = new ExDBFieldNumber<>("zrntyokuzentuusanhanteisx4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzenkyuuhutaisyousx4 = new ExDBFieldNumber<>("zrntyokuzenkyuuhutaisyousx4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzencbgakux4 = new ExDBFieldNumber<>("zrntyokuzencbgakux4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugotuusanhanteisx4 = new ExDBFieldNumber<>("zrntyokugotuusanhanteisx4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugokyuuhutaisyousx4 = new ExDBFieldNumber<>("zrntyokugokyuuhutaisyousx4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugocbgakux4 = new ExDBFieldNumber<>("zrntyokugocbgakux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv12x4 = new ExDBFieldString<>("zrnyobiv12x4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzentuusanhanteisx5 = new ExDBFieldNumber<>("zrntyokuzentuusanhanteisx5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzenkyuuhutaisyousx5 = new ExDBFieldNumber<>("zrntyokuzenkyuuhutaisyousx5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzencbgakux5 = new ExDBFieldNumber<>("zrntyokuzencbgakux5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugotuusanhanteisx5 = new ExDBFieldNumber<>("zrntyokugotuusanhanteisx5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugokyuuhutaisyousx5 = new ExDBFieldNumber<>("zrntyokugokyuuhutaisyousx5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugocbgakux5 = new ExDBFieldNumber<>("zrntyokugocbgakux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv12x5 = new ExDBFieldString<>("zrnyobiv12x5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzentuusanhanteisx6 = new ExDBFieldNumber<>("zrntyokuzentuusanhanteisx6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzenkyuuhutaisyousx6 = new ExDBFieldNumber<>("zrntyokuzenkyuuhutaisyousx6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokuzencbgakux6 = new ExDBFieldNumber<>("zrntyokuzencbgakux6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugotuusanhanteisx6 = new ExDBFieldNumber<>("zrntyokugotuusanhanteisx6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugokyuuhutaisyousx6 = new ExDBFieldNumber<>("zrntyokugokyuuhutaisyousx6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrntyokugocbgakux6 = new ExDBFieldNumber<>("zrntyokugocbgakux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv12x6 = new ExDBFieldString<>("zrnyobiv12x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikyksyonox1 = new ExDBFieldString<>("zrncbkikyksyonox1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikykhknsyruikbnx1 = new ExDBFieldString<>("zrncbkikykhknsyruikbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikeiyakukeiyakuymdx1 = new ExDBFieldString<>("zrncbkikeiyakukeiyakuymdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikykkyhtisyukbnx1 = new ExDBFieldString<>("zrncbkikykkyhtisyukbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikykhntitaisyoukbnx1 = new ExDBFieldString<>("zrncbkikykhntitaisyoukbnx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkikeiyakucbgakux1x1 = new ExDBFieldNumber<>("zrnkikeiyakucbgakux1x1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkikeiyakucbgakux2x1 = new ExDBFieldNumber<>("zrnkikeiyakucbgakux2x1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrncbkikykhanteitsnsx1x1 = new ExDBFieldNumber<>("zrncbkikykhanteitsnsx1x1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrncbkikykhanteitsnsx2x1 = new ExDBFieldNumber<>("zrncbkikykhanteitsnsx2x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv12x7 = new ExDBFieldString<>("zrnyobiv12x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikyksyonox2 = new ExDBFieldString<>("zrncbkikyksyonox2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikykhknsyruikbnx2 = new ExDBFieldString<>("zrncbkikykhknsyruikbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikeiyakukeiyakuymdx2 = new ExDBFieldString<>("zrncbkikeiyakukeiyakuymdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikykkyhtisyukbnx2 = new ExDBFieldString<>("zrncbkikykkyhtisyukbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikykhntitaisyoukbnx2 = new ExDBFieldString<>("zrncbkikykhntitaisyoukbnx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkikeiyakucbgakux1x2 = new ExDBFieldNumber<>("zrnkikeiyakucbgakux1x2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkikeiyakucbgakux2x2 = new ExDBFieldNumber<>("zrnkikeiyakucbgakux2x2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrncbkikykhanteitsnsx1x2 = new ExDBFieldNumber<>("zrncbkikykhanteitsnsx1x2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrncbkikykhanteitsnsx2x2 = new ExDBFieldNumber<>("zrncbkikykhanteitsnsx2x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv12x8 = new ExDBFieldString<>("zrnyobiv12x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikyksyonox3 = new ExDBFieldString<>("zrncbkikyksyonox3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikykhknsyruikbnx3 = new ExDBFieldString<>("zrncbkikykhknsyruikbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikeiyakukeiyakuymdx3 = new ExDBFieldString<>("zrncbkikeiyakukeiyakuymdx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikykkyhtisyukbnx3 = new ExDBFieldString<>("zrncbkikykkyhtisyukbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrncbkikykhntitaisyoukbnx3 = new ExDBFieldString<>("zrncbkikykhntitaisyoukbnx3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkikeiyakucbgakux1x3 = new ExDBFieldNumber<>("zrnkikeiyakucbgakux1x3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkikeiyakucbgakux2x3 = new ExDBFieldNumber<>("zrnkikeiyakucbgakux2x3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrncbkikykhanteitsnsx1x3 = new ExDBFieldNumber<>("zrncbkikykhanteitsnsx1x3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrncbkikykhanteitsnsx2x3 = new ExDBFieldNumber<>("zrncbkikykhanteitsnsx2x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv12x9 = new ExDBFieldString<>("zrnyobiv12x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknhknsyrikgusdkbnx1 = new ExDBFieldString<>("zrnhtnknhknsyrikgusdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknmrtikgusdkbnx1 = new ExDBFieldString<>("zrnhtnknmrtikgusdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknsiznmrtikgusdkbnx1 = new ExDBFieldString<>("zrnhtnknsiznmrtikgusdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntignmrtikgusdkbnx1 = new ExDBFieldString<>("zrnhtnkntignmrtikgusdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknnkmrtikgusdkbnx1 = new ExDBFieldString<>("zrnhtnknnkmrtikgusdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntkstkgusdkbnx1 = new ExDBFieldString<>("zrnhtnkntkstkgusdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2tkstkgusdkbnx1 = new ExDBFieldString<>("zrnhtnkndi2tkstkgusdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknjyustkgusdkbnx1 = new ExDBFieldString<>("zrnhtnknjyustkgusdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2jysitkgusdkbnx1 = new ExDBFieldString<>("zrnhtnkndi2jysitkgusdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonkmrtisdkbnx1 = new ExDBFieldString<>("zrnhtnknkaigonkmrtisdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigtignmrtisdkbnx1 = new ExDBFieldString<>("zrnhtnknkigtignmrtisdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigomrsykgusdkbnx1 = new ExDBFieldString<>("zrnhtnknkaigomrsykgusdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsuuriyouyobiv8x2 = new ExDBFieldString<>("zrnsuuriyouyobiv8x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknhknsyrikgusdkbnx2 = new ExDBFieldString<>("zrnhtnknhknsyrikgusdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknmrtikgusdkbnx2 = new ExDBFieldString<>("zrnhtnknmrtikgusdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknsiznmrtikgusdkbnx2 = new ExDBFieldString<>("zrnhtnknsiznmrtikgusdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntignmrtikgusdkbnx2 = new ExDBFieldString<>("zrnhtnkntignmrtikgusdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknnkmrtikgusdkbnx2 = new ExDBFieldString<>("zrnhtnknnkmrtikgusdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntkstkgusdkbnx2 = new ExDBFieldString<>("zrnhtnkntkstkgusdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2tkstkgusdkbnx2 = new ExDBFieldString<>("zrnhtnkndi2tkstkgusdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknjyustkgusdkbnx2 = new ExDBFieldString<>("zrnhtnknjyustkgusdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2jysitkgusdkbnx2 = new ExDBFieldString<>("zrnhtnkndi2jysitkgusdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonkmrtisdkbnx2 = new ExDBFieldString<>("zrnhtnknkaigonkmrtisdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigtignmrtisdkbnx2 = new ExDBFieldString<>("zrnhtnknkigtignmrtisdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigomrsykgusdkbnx2 = new ExDBFieldString<>("zrnhtnknkaigomrsykgusdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv8x5 = new ExDBFieldString<>("zrnyobiv8x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknhknsyrikgusdkbnx3 = new ExDBFieldString<>("zrnhtnknhknsyrikgusdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknmrtikgusdkbnx3 = new ExDBFieldString<>("zrnhtnknmrtikgusdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknsiznmrtikgusdkbnx3 = new ExDBFieldString<>("zrnhtnknsiznmrtikgusdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntignmrtikgusdkbnx3 = new ExDBFieldString<>("zrnhtnkntignmrtikgusdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknnkmrtikgusdkbnx3 = new ExDBFieldString<>("zrnhtnknnkmrtikgusdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntkstkgusdkbnx3 = new ExDBFieldString<>("zrnhtnkntkstkgusdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2tkstkgusdkbnx3 = new ExDBFieldString<>("zrnhtnkndi2tkstkgusdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknjyustkgusdkbnx3 = new ExDBFieldString<>("zrnhtnknjyustkgusdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2jysitkgusdkbnx3 = new ExDBFieldString<>("zrnhtnkndi2jysitkgusdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonkmrtisdkbnx3 = new ExDBFieldString<>("zrnhtnknkaigonkmrtisdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigtignmrtisdkbnx3 = new ExDBFieldString<>("zrnhtnknkigtignmrtisdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigomrsykgusdkbnx3 = new ExDBFieldString<>("zrnhtnknkaigomrsykgusdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv8x6 = new ExDBFieldString<>("zrnyobiv8x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknhknsyrikgusdkbnx4 = new ExDBFieldString<>("zrnhtnknhknsyrikgusdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknmrtikgusdkbnx4 = new ExDBFieldString<>("zrnhtnknmrtikgusdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknsiznmrtikgusdkbnx4 = new ExDBFieldString<>("zrnhtnknsiznmrtikgusdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntignmrtikgusdkbnx4 = new ExDBFieldString<>("zrnhtnkntignmrtikgusdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknnkmrtikgusdkbnx4 = new ExDBFieldString<>("zrnhtnknnkmrtikgusdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntkstkgusdkbnx4 = new ExDBFieldString<>("zrnhtnkntkstkgusdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2tkstkgusdkbnx4 = new ExDBFieldString<>("zrnhtnkndi2tkstkgusdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknjyustkgusdkbnx4 = new ExDBFieldString<>("zrnhtnknjyustkgusdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2jysitkgusdkbnx4 = new ExDBFieldString<>("zrnhtnkndi2jysitkgusdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonkmrtisdkbnx4 = new ExDBFieldString<>("zrnhtnknkaigonkmrtisdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigtignmrtisdkbnx4 = new ExDBFieldString<>("zrnhtnknkigtignmrtisdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigomrsykgusdkbnx4 = new ExDBFieldString<>("zrnhtnknkaigomrsykgusdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv8x7 = new ExDBFieldString<>("zrnyobiv8x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknhknsyrikgusdkbnx5 = new ExDBFieldString<>("zrnhtnknhknsyrikgusdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknmrtikgusdkbnx5 = new ExDBFieldString<>("zrnhtnknmrtikgusdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknsiznmrtikgusdkbnx5 = new ExDBFieldString<>("zrnhtnknsiznmrtikgusdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntignmrtikgusdkbnx5 = new ExDBFieldString<>("zrnhtnkntignmrtikgusdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknnkmrtikgusdkbnx5 = new ExDBFieldString<>("zrnhtnknnkmrtikgusdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntkstkgusdkbnx5 = new ExDBFieldString<>("zrnhtnkntkstkgusdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2tkstkgusdkbnx5 = new ExDBFieldString<>("zrnhtnkndi2tkstkgusdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknjyustkgusdkbnx5 = new ExDBFieldString<>("zrnhtnknjyustkgusdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2jysitkgusdkbnx5 = new ExDBFieldString<>("zrnhtnkndi2jysitkgusdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonkmrtisdkbnx5 = new ExDBFieldString<>("zrnhtnknkaigonkmrtisdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigtignmrtisdkbnx5 = new ExDBFieldString<>("zrnhtnknkigtignmrtisdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigomrsykgusdkbnx5 = new ExDBFieldString<>("zrnhtnknkaigomrsykgusdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv8x8 = new ExDBFieldString<>("zrnyobiv8x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknhknsyrikgusdkbnx6 = new ExDBFieldString<>("zrnhtnknhknsyrikgusdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknmrtikgusdkbnx6 = new ExDBFieldString<>("zrnhtnknmrtikgusdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknsiznmrtikgusdkbnx6 = new ExDBFieldString<>("zrnhtnknsiznmrtikgusdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntignmrtikgusdkbnx6 = new ExDBFieldString<>("zrnhtnkntignmrtikgusdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknnkmrtikgusdkbnx6 = new ExDBFieldString<>("zrnhtnknnkmrtikgusdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkntkstkgusdkbnx6 = new ExDBFieldString<>("zrnhtnkntkstkgusdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2tkstkgusdkbnx6 = new ExDBFieldString<>("zrnhtnkndi2tkstkgusdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknjyustkgusdkbnx6 = new ExDBFieldString<>("zrnhtnknjyustkgusdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnkndi2jysitkgusdkbnx6 = new ExDBFieldString<>("zrnhtnkndi2jysitkgusdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonkmrtisdkbnx6 = new ExDBFieldString<>("zrnhtnknkaigonkmrtisdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigtignmrtisdkbnx6 = new ExDBFieldString<>("zrnhtnknkigtignmrtisdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigomrsykgusdkbnx6 = new ExDBFieldString<>("zrnhtnknkaigomrsykgusdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv8x9 = new ExDBFieldString<>("zrnyobiv8x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonktkyksyuruikgu = new ExDBFieldString<>("zrnkaigonktkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonktkykkgusdkbn = new ExDBFieldString<>("zrnkaigonktkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonenkintokuyakukikan = new ExDBFieldString<>("zrnkaigonenkintokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonktkykphrkkkn = new ExDBFieldString<>("zrnkaigonktkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigonktkyknkgk = new ExDBFieldNumber<>("zrnkaigonktkyknkgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigonenkintokuyakus = new ExDBFieldNumber<>("zrnkaigonenkintokuyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigonenkintokuyakup = new ExDBFieldNumber<>("zrnkaigonenkintokuyakup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigonktkykmods = new ExDBFieldNumber<>("zrnkaigonktkykmods", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonktkyknkshrkkn = new ExDBFieldString<>("zrnkaigonktkyknkshrkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonktkykkgux1 = new ExDBFieldString<>("zrnhtnknkaigonktkykkgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonktkykkgux2 = new ExDBFieldString<>("zrnhtnknkaigonktkykkgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonktkykkgux3 = new ExDBFieldString<>("zrnhtnknkaigonktkykkgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonktkykkgux4 = new ExDBFieldString<>("zrnhtnknkaigonktkykkgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonktkykkgux5 = new ExDBFieldString<>("zrnhtnknkaigonktkykkgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonktkykkgux6 = new ExDBFieldString<>("zrnhtnknkaigonktkykkgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonktkyksdkbnx1 = new ExDBFieldString<>("zrnhtnknkaigonktkyksdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonktkyksdkbnx2 = new ExDBFieldString<>("zrnhtnknkaigonktkyksdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonktkyksdkbnx3 = new ExDBFieldString<>("zrnhtnknkaigonktkyksdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonktkyksdkbnx4 = new ExDBFieldString<>("zrnhtnknkaigonktkyksdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonktkyksdkbnx5 = new ExDBFieldString<>("zrnhtnknkaigonktkyksdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigonktkyksdkbnx6 = new ExDBFieldString<>("zrnhtnknkaigonktkyksdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsurikaigonktkykpwrbkkbn = new ExDBFieldString<>("zrnsurikaigonktkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonktkykpwrbkkbn = new ExDBFieldString<>("zrnkaigonktkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigonktkyktnknyugukbn = new ExDBFieldString<>("zrnkaigonktkyktnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv14 = new ExDBFieldString<>("zrnyobiv14", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnitjbrkignktkyksyrikgu = new ExDBFieldString<>("zrnitjbrkignktkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnitjbrkignktkyksdkbn = new ExDBFieldString<>("zrnitjbrkignktkyksdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnitjbrkignktkykkkn = new ExDBFieldString<>("zrnitjbrkignktkykkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnitjbrkignktkyknnkngk = new ExDBFieldNumber<>("zrnitjbrkignktkyknnkngk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnitjbrkignktkyks = new ExDBFieldNumber<>("zrnitjbrkignktkyks", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnitjbrkignktkykp = new ExDBFieldNumber<>("zrnitjbrkignktkykp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnitjbrkignktkykspdtkbn = new ExDBFieldString<>("zrnitjbrkignktkykspdtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnitjbrkignktkykmods = new ExDBFieldNumber<>("zrnitjbrkignktkykmods", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnitjbrkignktkykshrkkn = new ExDBFieldString<>("zrnitjbrkignktkykshrkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv8x10 = new ExDBFieldString<>("zrnyobiv8x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnnyuuinnissuugatakbn = new ExDBFieldString<>("zrnnyuuinnissuugatakbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrntenkankeikanensuu = new ExDBFieldString<>("zrntenkankeikanensuu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsykkyuhtkyksyuruikgu = new ExDBFieldString<>("zrnsykkyuhtkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsyokikyuuhutokuyakukikan = new ExDBFieldString<>("zrnsyokikyuuhutokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsyokikyuuhutkykphrkkkn = new ExDBFieldString<>("zrnsyokikyuuhutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrnsykkyuhtkykntgk = new ExDBFieldNumber<>("zrnsykkyuhtkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsyokikyuuhutokuyakup = new ExDBFieldNumber<>("zrnsyokikyuuhutokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsykkyuhtkykgtkbn = new ExDBFieldString<>("zrnsykkyuhtkykgtkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsyokikyuuhutkykkgusdkbn = new ExDBFieldString<>("zrnsyokikyuuhutkykkgusdkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrnsykkyuhtkjyuryumshyutn = new ExDBFieldNumber<>("zrnsykkyuhtkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnsyokikyuuhutokujyoup = new ExDBFieldNumber<>("zrnsyokikyuuhutokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsykkyuhtktbicdx1 = new ExDBFieldString<>("zrnsykkyuhtktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsykkyuhhtnpkknx1 = new ExDBFieldString<>("zrnsykkyuhhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsykkyuhtktbicdx2 = new ExDBFieldString<>("zrnsykkyuhtktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsykkyuhhtnpkknx2 = new ExDBFieldString<>("zrnsykkyuhhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsykkyuhtkykpwrbkkbn = new ExDBFieldString<>("zrnsykkyuhtkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv3x6 = new ExDBFieldString<>("zrnyobiv3x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sykkyuhtkyksyrikgu = new ExDBFieldString<>("zrndi2sykkyuhtkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sykkyuhtkykkkn = new ExDBFieldString<>("zrndi2sykkyuhtkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sykkyuhtkykphrkkkn = new ExDBFieldString<>("zrndi2sykkyuhtkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrndi2sykkyuhtkykntgk = new ExDBFieldNumber<>("zrndi2sykkyuhtkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndai2syokikyuuhutokuyakup = new ExDBFieldNumber<>("zrndai2syokikyuuhutokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sykkyuhtkykgtkbn = new ExDBFieldString<>("zrndi2sykkyuhtkykgtkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sykkyuhtkykkgusdkbn = new ExDBFieldString<>("zrndi2sykkyuhtkykkgusdkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrndi2sykkyuhtkjyuryumshytn = new ExDBFieldNumber<>("zrndi2sykkyuhtkjyuryumshytn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndai2syokikyuuhutokujyoup = new ExDBFieldNumber<>("zrndai2syokikyuuhutokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sykkyuhtktbicdx1 = new ExDBFieldString<>("zrndi2sykkyuhtktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sykkyuhhtnpkknx1 = new ExDBFieldString<>("zrndi2sykkyuhhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sykkyuhtktbicdx2 = new ExDBFieldString<>("zrndi2sykkyuhtktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sykkyuhhtnpkknx2 = new ExDBFieldString<>("zrndi2sykkyuhhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrndi2sykkyuhtkykpwrbkkbn = new ExDBFieldString<>("zrndi2sykkyuhtkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv3x7 = new ExDBFieldString<>("zrnyobiv3x7", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndfitijibaraip = new ExDBFieldNumber<>("zrndfitijibaraip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndfgoukeitenkankakaku = new ExDBFieldNumber<>("zrndfgoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndfuktkjivbbntnknkakaku = new ExDBFieldNumber<>("zrndfuktkjivbbntnknkakaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndfuktkjipbbntnknkakaku = new ExDBFieldNumber<>("zrndfuktkjipbbntnknkakaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndftnkngvbbntnknkakaku = new ExDBFieldNumber<>("zrndftnkngvbbntnknkakaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrndftnkngpbbntnknkakaku = new ExDBFieldNumber<>("zrndftnkngpbbntnknkakaku", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv18x2 = new ExDBFieldString<>("zrnyobiv18x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigomrtisyuruikgu = new ExDBFieldString<>("zrnkaigomrtisyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigomaruteikigousdkbn = new ExDBFieldString<>("zrnkaigomaruteikigousdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigomaruteikikan = new ExDBFieldString<>("zrnkaigomaruteikikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigomaruteiphrkkkn = new ExDBFieldString<>("zrnkaigomaruteiphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigomaruteis = new ExDBFieldNumber<>("zrnkaigomaruteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigomaruteip = new ExDBFieldNumber<>("zrnkaigomaruteip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigomaruteisyuuseis = new ExDBFieldNumber<>("zrnkaigomaruteisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigomaruteimodsskgnhyj = new ExDBFieldString<>("zrnkaigomaruteimodsskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkigmrtitkjyukbn = new ExDBFieldString<>("zrnkigmrtitkjyukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkigmrtitkjyuskgnkkn = new ExDBFieldString<>("zrnkigmrtitkjyuskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Integer> zrnkigmrtitkjyuryumshyutn = new ExDBFieldNumber<>("zrnkigmrtitkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigomaruteitokujyoup = new ExDBFieldNumber<>("zrnkaigomaruteitokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigmrtisyrikgux1 = new ExDBFieldString<>("zrnhtnknkigmrtisyrikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigmrtisyrikgux2 = new ExDBFieldString<>("zrnhtnknkigmrtisyrikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigmrtisyrikgux3 = new ExDBFieldString<>("zrnhtnknkigmrtisyrikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigmrtisyrikgux4 = new ExDBFieldString<>("zrnhtnknkigmrtisyrikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigmrtisyrikgux5 = new ExDBFieldString<>("zrnhtnknkigmrtisyrikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkigmrtisyrikgux6 = new ExDBFieldString<>("zrnhtnknkigmrtisyrikgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigomrtisdkbnx1 = new ExDBFieldString<>("zrnhtnknkaigomrtisdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigomrtisdkbnx2 = new ExDBFieldString<>("zrnhtnknkaigomrtisdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigomrtisdkbnx3 = new ExDBFieldString<>("zrnhtnknkaigomrtisdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigomrtisdkbnx4 = new ExDBFieldString<>("zrnhtnknkaigomrtisdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigomrtisdkbnx5 = new ExDBFieldString<>("zrnhtnknkaigomrtisdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnhtnknkaigomrtisdkbnx6 = new ExDBFieldString<>("zrnhtnknkaigomrtisdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnsurkigmrtipwrbkkbn = new ExDBFieldString<>("zrnsurkigmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkigmrtipwrbkkbn = new ExDBFieldString<>("zrnkigmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkigmrtitnknyugukbn = new ExDBFieldString<>("zrnkigmrtitnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkigmrtikusnmnryoage = new ExDBFieldString<>("zrnkigmrtikusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv2x7 = new ExDBFieldString<>("zrnyobiv2x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigotokuteisyuruikigou = new ExDBFieldString<>("zrnkaigotokuteisyuruikigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigotktikgusdkbn = new ExDBFieldString<>("zrnkaigotktikgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigotokuteikikan = new ExDBFieldString<>("zrnkaigotokuteikikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigotokuteis = new ExDBFieldNumber<>("zrnkaigotokuteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigotokuteip = new ExDBFieldNumber<>("zrnkaigotokuteip", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkigtktisdtpdtkbn = new ExDBFieldString<>("zrnkigtktisdtpdtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkaigotokuteisyuuseis = new ExDBFieldNumber<>("zrnkaigotokuteisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigotktimodsskgnhyj = new ExDBFieldString<>("zrnkaigotktimodsskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkaigotktikusnmnryoage = new ExDBFieldString<>("zrnkaigotktikusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv8x11 = new ExDBFieldString<>("zrnyobiv8x11", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkazokuiryoutkyksyuruikgu = new ExDBFieldString<>("zrnkazokuiryoutkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkazokuiryoutokuyakukikan = new ExDBFieldString<>("zrnkazokuiryoutokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkazokuiryoutkykphrkkkn = new ExDBFieldString<>("zrnkazokuiryoutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkzkiryoutkykntgk = new ExDBFieldNumber<>("zrnkzkiryoutkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu2Rn, Long> zrnkazokuiryoutokuyakup = new ExDBFieldNumber<>("zrnkazokuiryoutokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkzkiryoutkykgtkbn = new ExDBFieldString<>("zrnkzkiryoutkykgtkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkazokuiryoutkykkgusdkbn = new ExDBFieldString<>("zrnkazokuiryoutkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkzkiryoutktbicdx1 = new ExDBFieldString<>("zrnkzkiryoutktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkzkiryouhtnpkknx1 = new ExDBFieldString<>("zrnkzkiryouhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkzkiryoutktbicdx2 = new ExDBFieldString<>("zrnkzkiryoutktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnkzkiryouhtnpkknx2 = new ExDBFieldString<>("zrnkzkiryouhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu2Rn, String> zrnyobiv12x10 = new ExDBFieldString<>("zrnyobiv12x10", this);
}
