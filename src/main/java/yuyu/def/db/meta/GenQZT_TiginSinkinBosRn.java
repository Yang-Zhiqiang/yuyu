package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_TiginSinkinBosRn;

/**
 * 地銀信金募集テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_TiginSinkinBosRn extends AbstractExDBTable<ZT_TiginSinkinBosRn> {

    public GenQZT_TiginSinkinBosRn() {
        this("ZT_TiginSinkinBosRn");
    }

    public GenQZT_TiginSinkinBosRn(String pAlias) {
        super("ZT_TiginSinkinBosRn", ZT_TiginSinkinBosRn.class, pAlias);
    }

    public String ZT_TiginSinkinBosRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebidkbn = new ExDBFieldString<>("zrnseihowebidkbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkojincd = new ExDBFieldString<>("zrnseihowebkojincd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebitijihozonhyouji = new ExDBFieldString<>("zrnseihowebitijihozonhyouji", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebsekno = new ExDBFieldNumber<>("zrnseihowebsekno", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebcalckijyunymd = new ExDBFieldNumber<>("zrnseihowebcalckijyunymd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhhknknnm = new ExDBFieldString<>("zrnseihowebhhknknnm", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhhknkjnm = new ExDBFieldString<>("zrnseihowebhhknkjnm", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebhhknseiymd = new ExDBFieldNumber<>("zrnseihowebhhknseiymd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhhknseikbn = new ExDBFieldString<>("zrnseihowebhhknseikbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebmrhkihontikucd = new ExDBFieldString<>("zrnseihowebmrhkihontikucd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhhknadr = new ExDBFieldString<>("zrnseihowebhhknadr", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkykknnm = new ExDBFieldString<>("zrnseihowebkykknnm", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkykkjnm = new ExDBFieldString<>("zrnseihowebkykkjnm", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebkyksyaseiymd = new ExDBFieldNumber<>("zrnseihowebkyksyaseiymd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkyksyaseikbn = new ExDBFieldString<>("zrnseihowebkyksyaseikbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkykkihontikucd = new ExDBFieldString<>("zrnseihowebkykkihontikucd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkykadr = new ExDBFieldString<>("zrnseihowebkykadr", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebhknsyuruino = new ExDBFieldNumber<>("zrnseihowebhknsyuruino", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhjkktkbn = new ExDBFieldString<>("zrnseihowebhjkktkbn", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebhknkkn = new ExDBFieldNumber<>("zrnseihowebhknkkn", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebphrkkikn = new ExDBFieldNumber<>("zrnseihowebphrkkikn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhrkkaisuukbn = new ExDBFieldString<>("zrnseihowebhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhrkkeirokbn = new ExDBFieldString<>("zrnseihowebhrkkeirokbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebsdpdkbn = new ExDBFieldString<>("zrnseihowebsdpdkbn", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebkihons = new ExDBFieldNumber<>("zrnseihowebkihons", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebnksyuruikbn = new ExDBFieldString<>("zrnseihowebnksyuruikbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihoweblntkkbn = new ExDBFieldString<>("zrnseihoweblntkkbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebnkshrarihyj = new ExDBFieldString<>("zrnseihowebnkshrarihyj", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebmosno = new ExDBFieldNumber<>("zrnseihowebmosno", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebsekykkigenymd = new ExDBFieldNumber<>("zrnseihowebsekykkigenymd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebsksjsitencd = new ExDBFieldString<>("zrnseihowebsksjsitencd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebsbuktnrkkbn = new ExDBFieldString<>("zrnseihowebsbuktnrkkbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebsbukttdkkbn = new ExDBFieldString<>("zrnseihowebsbukttdkkbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebsbuktknnm = new ExDBFieldString<>("zrnseihowebsbuktknnm", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebsbuktkjnm = new ExDBFieldString<>("zrnseihowebsbuktkjnm", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebsbuktseiymd = new ExDBFieldNumber<>("zrnseihowebsbuktseiymd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebmosprtzmhyj = new ExDBFieldString<>("zrnseihowebmosprtzmhyj", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebfstmossksymd = new ExDBFieldNumber<>("zrnseihowebfstmossksymd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhnsyukyktdkkbn = new ExDBFieldString<>("zrnseihowebhnsyukyktdkkbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebbsyutrkno = new ExDBFieldString<>("zrnseihowebbsyutrkno", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhjnkitikbn = new ExDBFieldString<>("zrnseihowebhjnkitikbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhjnkykhyj = new ExDBFieldString<>("zrnseihowebhjnkykhyj", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebtksykmcd1 = new ExDBFieldString<>("zrnseihowebtksykmcd1", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebtksykmcd2 = new ExDBFieldString<>("zrnseihowebtksykmcd2", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebtksykmcd3 = new ExDBFieldString<>("zrnseihowebtksykmcd3", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebtksykmcd4 = new ExDBFieldString<>("zrnseihowebtksykmcd4", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebtksykmcd5 = new ExDBFieldString<>("zrnseihowebtksykmcd5", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebteiwkkn = new ExDBFieldNumber<>("zrnseihowebteiwkkn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhhkntelno = new ExDBFieldString<>("zrnseihowebhhkntelno", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkyktelno = new ExDBFieldString<>("zrnseihowebkyktelno", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebknhjnnm = new ExDBFieldString<>("zrnseihowebknhjnnm", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkjhjnnm = new ExDBFieldString<>("zrnseihowebkjhjnnm", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkndaihyounm = new ExDBFieldString<>("zrnseihowebkndaihyounm", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkjdaihyounm = new ExDBFieldString<>("zrnseihowebkjdaihyounm", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebdaihyouktgkkbn = new ExDBFieldString<>("zrnseihowebdaihyouktgkkbn", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebsykihrkp1 = new ExDBFieldNumber<>("zrnseihowebsykihrkp1", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebmosp1 = new ExDBFieldNumber<>("zrnseihowebmosp1", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebtkiyougyoutaikbn = new ExDBFieldString<>("zrnseihowebtkiyougyoutaikbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebpaperlessmoshyj = new ExDBFieldString<>("zrnseihowebpaperlessmoshyj", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebdatasousinzmhyj = new ExDBFieldString<>("zrnseihowebdatasousinzmhyj", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebdrtnskno = new ExDBFieldString<>("zrnseihowebdrtnskno", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebsbnksyukbn = new ExDBFieldString<>("zrnseihowebsbnksyukbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebaatkisyaknyuucd = new ExDBFieldString<>("zrnseihowebaatkisyaknyuucd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkeihidouituhyj = new ExDBFieldString<>("zrnseihowebkeihidouituhyj", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebsiteituukakbn = new ExDBFieldString<>("zrnseihowebsiteituukakbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebnykntuukakbn = new ExDBFieldString<>("zrnseihowebnykntuukakbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebtargettkarihyj = new ExDBFieldString<>("zrnseihowebtargettkarihyj", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebtargettkkbn = new ExDBFieldString<>("zrnseihowebtargettkkbn", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebtargettkmkht = new ExDBFieldNumber<>("zrnseihowebtargettkmkht", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebnykntuukanykngk = new ExDBFieldNumber<>("zrnseihowebnykntuukanykngk", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebnykntukfsthrkp = new ExDBFieldNumber<>("zrnseihowebnykntukfsthrkp", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebnykntuknexthrkp = new ExDBFieldNumber<>("zrnseihowebnykntuknexthrkp", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebsaimankihyj = new ExDBFieldString<>("zrnseihowebsaimankihyj", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebrayhyj = new ExDBFieldString<>("zrnseihowebrayhyj", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebgnykntuknykngk = new ExDBFieldNumber<>("zrnseihowebgnykntuknykngk", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebgnykntukfsthrkp = new ExDBFieldNumber<>("zrnseihowebgnykntukfsthrkp", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebgnykntuknxthrkp = new ExDBFieldNumber<>("zrnseihowebgnykntuknxthrkp", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebgaikakihonp = new ExDBFieldNumber<>("zrnseihowebgaikakihonp", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkaigmehrtkarihyj = new ExDBFieldString<>("zrnseihowebkaigmehrtkarihyj", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebyenhsyutkarihyj = new ExDBFieldString<>("zrnseihowebyenhsyutkarihyj", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebgaikakihons = new ExDBFieldNumber<>("zrnseihowebgaikakihons", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebdai1hknkkn = new ExDBFieldNumber<>("zrnseihowebdai1hknkkn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkyksykgycd = new ExDBFieldString<>("zrnseihowebkyksykgycd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkknmskhjnkitikbn = new ExDBFieldString<>("zrnseihowebkknmskhjnkitikbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkykottmsk = new ExDBFieldString<>("zrnseihowebkykottmsk", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhhknsykgycd = new ExDBFieldString<>("zrnseihowebhhknsykgycd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhknmskhjnkitikbn = new ExDBFieldString<>("zrnseihowebhknmskhjnkitikbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhhknottmsk = new ExDBFieldString<>("zrnseihowebhhknottmsk", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhhknnensyuukbn = new ExDBFieldString<>("zrnseihowebhhknnensyuukbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebplhhknkjnm = new ExDBFieldString<>("zrnseihowebplhhknkjnm", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebplkykkjnm = new ExDBFieldString<>("zrnseihowebplkykkjnm", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebplhrkkeirokbn = new ExDBFieldString<>("zrnseihowebplhrkkeirokbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebplsbuktnrkkbn = new ExDBFieldString<>("zrnseihowebplsbuktnrkkbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebplsbukttdkkbn = new ExDBFieldString<>("zrnseihowebplsbukttdkkbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebplsbuktknnm = new ExDBFieldString<>("zrnseihowebplsbuktknnm", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebplsbuktkjnm = new ExDBFieldString<>("zrnseihowebplsbuktkjnm", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebplsbuktseiymd = new ExDBFieldNumber<>("zrnseihowebplsbuktseiymd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebplhhkntelno = new ExDBFieldString<>("zrnseihowebplhhkntelno", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebplkyktelno = new ExDBFieldString<>("zrnseihowebplkyktelno", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebplkihontikucd = new ExDBFieldString<>("zrnseihowebplkihontikucd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebpltsinadrkai = new ExDBFieldString<>("zrnseihowebpltsinadrkai", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebplhiikihontikucd = new ExDBFieldString<>("zrnseihowebplhiikihontikucd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebplhhknadr = new ExDBFieldString<>("zrnseihowebplhhknadr", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhnyppltzmhyj = new ExDBFieldString<>("zrnseihowebhnyppltzmhyj", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebssrndhbnwr = new ExDBFieldNumber<>("zrnseihowebssrndhbnwr", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebtrtrndhbnwr = new ExDBFieldNumber<>("zrnseihowebtrtrndhbnwr", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebsueokikkn = new ExDBFieldNumber<>("zrnseihowebsueokikkn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebmnkuktnrkkbn = new ExDBFieldString<>("zrnseihowebmnkuktnrkkbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebmnkukttdkkbn = new ExDBFieldString<>("zrnseihowebmnkukttdkkbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebmnkuktknnm = new ExDBFieldString<>("zrnseihowebmnkuktknnm", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebmnkuktkjnm = new ExDBFieldString<>("zrnseihowebmnkuktkjnm", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebmnkuktseiymd = new ExDBFieldNumber<>("zrnseihowebmnkuktseiymd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebankenkanrino = new ExDBFieldString<>("zrnseihowebankenkanrino", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebikkatup = new ExDBFieldNumber<>("zrnseihowebikkatup", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebikkatubaraikbn = new ExDBFieldString<>("zrnseihowebikkatubaraikbn", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebiktbrikaisuu = new ExDBFieldNumber<>("zrnseihowebiktbrikaisuu", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebzennoup = new ExDBFieldNumber<>("zrnseihowebzennoup", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Long> zrnseihowebgaikazennoup = new ExDBFieldNumber<>("zrnseihowebgaikazennoup", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebzennoukkn = new ExDBFieldNumber<>("zrnseihowebzennoukkn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebzennouhyj = new ExDBFieldString<>("zrnseihowebzennouhyj", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkydbosyuukjncd = new ExDBFieldString<>("zrnseihowebkydbosyuukjncd", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkzktrkmoskbn = new ExDBFieldString<>("zrnseihowebkzktrkmoskbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkzktdkkbn1 = new ExDBFieldString<>("zrnseihowebkzktdkkbn1", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkzkknnm1 = new ExDBFieldString<>("zrnseihowebkzkknnm1", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkzkkjnm1 = new ExDBFieldString<>("zrnseihowebkzkkjnm1", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkzkseikbn1 = new ExDBFieldString<>("zrnseihowebkzkseikbn1", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebkzkseiymd1 = new ExDBFieldNumber<>("zrnseihowebkzkseiymd1", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkzkkykdoukyohyj1 = new ExDBFieldString<>("zrnseihowebkzkkykdoukyohyj1", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkzkyno1 = new ExDBFieldString<>("zrnseihowebkzkyno1", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkzkadr1 = new ExDBFieldString<>("zrnseihowebkzkadr1", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkzktelno1 = new ExDBFieldString<>("zrnseihowebkzktelno1", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkykdrtkkanouhyj = new ExDBFieldString<>("zrnseihowebkykdrtkkanouhyj", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhhkndrtkkanouhyj = new ExDBFieldString<>("zrnseihowebhhkndrtkkanouhyj", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebdrtkkbn = new ExDBFieldString<>("zrnseihowebdrtkkbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebkykdrnrkkbn = new ExDBFieldString<>("zrnseihowebkykdrnrkkbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhhkndrnrkkbn = new ExDBFieldString<>("zrnseihowebhhkndrnrkkbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhhkndrtdkkbn = new ExDBFieldString<>("zrnseihowebhhkndrtdkkbn", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhhkndrknnm = new ExDBFieldString<>("zrnseihowebhhkndrknnm", this);

    public final ExDBFieldString<ZT_TiginSinkinBosRn, String> zrnseihowebhhkndrkjnm = new ExDBFieldString<>("zrnseihowebhhkndrkjnm", this);

    public final ExDBFieldNumber<ZT_TiginSinkinBosRn, Integer> zrnseihowebhhkndrseiymd = new ExDBFieldNumber<>("zrnseihowebhhkndrseiymd", this);
}
