package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SmbcBosTr;

/**
 * ＳＭＢＣ募集テーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SmbcBosTr extends AbstractExDBTable<ZT_SmbcBosTr> {

    public GenQZT_SmbcBosTr() {
        this("ZT_SmbcBosTr");
    }

    public GenQZT_SmbcBosTr(String pAlias) {
        super("ZT_SmbcBosTr", ZT_SmbcBosTr.class, pAlias);
    }

    public String ZT_SmbcBosTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebidkbn = new ExDBFieldString<>("ztrseihowebidkbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkojincd = new ExDBFieldString<>("ztrseihowebkojincd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebitijihozonhyouji = new ExDBFieldString<>("ztrseihowebitijihozonhyouji", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Integer> ztrseihowebsekno = new ExDBFieldNumber<>("ztrseihowebsekno", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebcalckijyunymd = new ExDBFieldString<>("ztrseihowebcalckijyunymd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhknknnm = new ExDBFieldString<>("ztrseihowebhhknknnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhknkjnm = new ExDBFieldString<>("ztrseihowebhhknkjnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhknseiymd = new ExDBFieldString<>("ztrseihowebhhknseiymd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhknseikbn = new ExDBFieldString<>("ztrseihowebhhknseikbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebmrhkihontikucd = new ExDBFieldString<>("ztrseihowebmrhkihontikucd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhknadr = new ExDBFieldString<>("ztrseihowebhhknadr", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkykknnm = new ExDBFieldString<>("ztrseihowebkykknnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkykkjnm = new ExDBFieldString<>("ztrseihowebkykkjnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkyksyaseiymd = new ExDBFieldString<>("ztrseihowebkyksyaseiymd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkyksyaseikbn = new ExDBFieldString<>("ztrseihowebkyksyaseikbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkykkihontikucd = new ExDBFieldString<>("ztrseihowebkykkihontikucd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkykadr = new ExDBFieldString<>("ztrseihowebkykadr", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhknsyuruino = new ExDBFieldString<>("ztrseihowebhknsyuruino", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhjkktkbn = new ExDBFieldString<>("ztrseihowebhjkktkbn", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Integer> ztrseihowebhknkkn = new ExDBFieldNumber<>("ztrseihowebhknkkn", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Integer> ztrseihowebphrkkikn = new ExDBFieldNumber<>("ztrseihowebphrkkikn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhrkkaisuukbn = new ExDBFieldString<>("ztrseihowebhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhrkkeirokbn = new ExDBFieldString<>("ztrseihowebhrkkeirokbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebsdpdkbn = new ExDBFieldString<>("ztrseihowebsdpdkbn", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebkihons = new ExDBFieldNumber<>("ztrseihowebkihons", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebnksyuruikbn = new ExDBFieldString<>("ztrseihowebnksyuruikbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihoweblntkkbn = new ExDBFieldString<>("ztrseihoweblntkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebnkshrarihyj = new ExDBFieldString<>("ztrseihowebnkshrarihyj", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebmosno = new ExDBFieldString<>("ztrseihowebmosno", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebsekykkigenymd = new ExDBFieldString<>("ztrseihowebsekykkigenymd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebsksjsitencd = new ExDBFieldString<>("ztrseihowebsksjsitencd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebsbuktnrkkbn = new ExDBFieldString<>("ztrseihowebsbuktnrkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebsbukttdkkbn = new ExDBFieldString<>("ztrseihowebsbukttdkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebsbuktknnm = new ExDBFieldString<>("ztrseihowebsbuktknnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebsbuktkjnm = new ExDBFieldString<>("ztrseihowebsbuktkjnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebsbuktseiymd = new ExDBFieldString<>("ztrseihowebsbuktseiymd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebmosprtzmhyj = new ExDBFieldString<>("ztrseihowebmosprtzmhyj", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebfstmossksymd = new ExDBFieldString<>("ztrseihowebfstmossksymd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhnsyukyktdkkbn = new ExDBFieldString<>("ztrseihowebhnsyukyktdkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebbsyutrkno = new ExDBFieldString<>("ztrseihowebbsyutrkno", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhjnkitikbn = new ExDBFieldString<>("ztrseihowebhjnkitikbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhjnkykhyj = new ExDBFieldString<>("ztrseihowebhjnkykhyj", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebtksykmcd1 = new ExDBFieldString<>("ztrseihowebtksykmcd1", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebtksykmcd2 = new ExDBFieldString<>("ztrseihowebtksykmcd2", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebtksykmcd3 = new ExDBFieldString<>("ztrseihowebtksykmcd3", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebtksykmcd4 = new ExDBFieldString<>("ztrseihowebtksykmcd4", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebtksykmcd5 = new ExDBFieldString<>("ztrseihowebtksykmcd5", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebteiwkkn = new ExDBFieldNumber<>("ztrseihowebteiwkkn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhkntelno = new ExDBFieldString<>("ztrseihowebhhkntelno", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkyktelno = new ExDBFieldString<>("ztrseihowebkyktelno", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebknhjnnm = new ExDBFieldString<>("ztrseihowebknhjnnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkjhjnnm = new ExDBFieldString<>("ztrseihowebkjhjnnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkndaihyounm = new ExDBFieldString<>("ztrseihowebkndaihyounm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkjdaihyounm = new ExDBFieldString<>("ztrseihowebkjdaihyounm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebdaihyouktgkkbn = new ExDBFieldString<>("ztrseihowebdaihyouktgkkbn", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebsykihrkp1 = new ExDBFieldNumber<>("ztrseihowebsykihrkp1", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebmosp1 = new ExDBFieldNumber<>("ztrseihowebmosp1", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebtkiyougyoutaikbn = new ExDBFieldString<>("ztrseihowebtkiyougyoutaikbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebpaperlessmoshyj = new ExDBFieldString<>("ztrseihowebpaperlessmoshyj", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebdatasousinzmhyj = new ExDBFieldString<>("ztrseihowebdatasousinzmhyj", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebdrtnskno = new ExDBFieldString<>("ztrseihowebdrtnskno", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebsbnksyukbn = new ExDBFieldString<>("ztrseihowebsbnksyukbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebaatkisyaknyuucd = new ExDBFieldString<>("ztrseihowebaatkisyaknyuucd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkeihidouituhyj = new ExDBFieldString<>("ztrseihowebkeihidouituhyj", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebsiteituukakbn = new ExDBFieldString<>("ztrseihowebsiteituukakbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebnykntuukakbn = new ExDBFieldString<>("ztrseihowebnykntuukakbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebtargettkarihyj = new ExDBFieldString<>("ztrseihowebtargettkarihyj", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebtargettkkbn = new ExDBFieldString<>("ztrseihowebtargettkkbn", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Integer> ztrseihowebtargettkmkht = new ExDBFieldNumber<>("ztrseihowebtargettkmkht", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebnykntuukanykngk = new ExDBFieldNumber<>("ztrseihowebnykntuukanykngk", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebnykntukfsthrkp = new ExDBFieldNumber<>("ztrseihowebnykntukfsthrkp", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebnykntuknexthrkp = new ExDBFieldNumber<>("ztrseihowebnykntuknexthrkp", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebsaimankihyj = new ExDBFieldString<>("ztrseihowebsaimankihyj", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebrayhyj = new ExDBFieldString<>("ztrseihowebrayhyj", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebgnykntuknykngk = new ExDBFieldNumber<>("ztrseihowebgnykntuknykngk", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebgnykntukfsthrkp = new ExDBFieldNumber<>("ztrseihowebgnykntukfsthrkp", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebgnykntuknxthrkp = new ExDBFieldNumber<>("ztrseihowebgnykntuknxthrkp", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebgaikakihonp = new ExDBFieldNumber<>("ztrseihowebgaikakihonp", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkaigmehrtkarihyj = new ExDBFieldString<>("ztrseihowebkaigmehrtkarihyj", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebyenhsyutkarihyj = new ExDBFieldString<>("ztrseihowebyenhsyutkarihyj", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebgaikakihons = new ExDBFieldNumber<>("ztrseihowebgaikakihons", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Integer> ztrseihowebdai1hknkkn = new ExDBFieldNumber<>("ztrseihowebdai1hknkkn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkyksykgycd = new ExDBFieldString<>("ztrseihowebkyksykgycd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkknmskhjnkitikbn = new ExDBFieldString<>("ztrseihowebkknmskhjnkitikbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkykottmsk = new ExDBFieldString<>("ztrseihowebkykottmsk", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhknsykgycd = new ExDBFieldString<>("ztrseihowebhhknsykgycd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhknmskhjnkitikbn = new ExDBFieldString<>("ztrseihowebhknmskhjnkitikbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhknottmsk = new ExDBFieldString<>("ztrseihowebhhknottmsk", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhknnensyuukbn = new ExDBFieldString<>("ztrseihowebhhknnensyuukbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebplhhknkjnm = new ExDBFieldString<>("ztrseihowebplhhknkjnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebplkykkjnm = new ExDBFieldString<>("ztrseihowebplkykkjnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebplhrkkeirokbn = new ExDBFieldString<>("ztrseihowebplhrkkeirokbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebplsbuktnrkkbn = new ExDBFieldString<>("ztrseihowebplsbuktnrkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebplsbukttdkkbn = new ExDBFieldString<>("ztrseihowebplsbukttdkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebplsbuktknnm = new ExDBFieldString<>("ztrseihowebplsbuktknnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebplsbuktkjnm = new ExDBFieldString<>("ztrseihowebplsbuktkjnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebplsbuktseiymd = new ExDBFieldString<>("ztrseihowebplsbuktseiymd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebplhhkntelno = new ExDBFieldString<>("ztrseihowebplhhkntelno", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebplkyktelno = new ExDBFieldString<>("ztrseihowebplkyktelno", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebplkihontikucd = new ExDBFieldString<>("ztrseihowebplkihontikucd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebpltsinadrkai = new ExDBFieldString<>("ztrseihowebpltsinadrkai", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebplhiikihontikucd = new ExDBFieldString<>("ztrseihowebplhiikihontikucd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebplhhknadr = new ExDBFieldString<>("ztrseihowebplhhknadr", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhnyppltzmhyj = new ExDBFieldString<>("ztrseihowebhnyppltzmhyj", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Integer> ztrseihowebssrndhbnwr = new ExDBFieldNumber<>("ztrseihowebssrndhbnwr", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Integer> ztrseihowebtrtrndhbnwr = new ExDBFieldNumber<>("ztrseihowebtrtrndhbnwr", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Integer> ztrseihowebsueokikkn = new ExDBFieldNumber<>("ztrseihowebsueokikkn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebmnkuktnrkkbn = new ExDBFieldString<>("ztrseihowebmnkuktnrkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebmnkukttdkkbn = new ExDBFieldString<>("ztrseihowebmnkukttdkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebmnkuktknnm = new ExDBFieldString<>("ztrseihowebmnkuktknnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebmnkuktkjnm = new ExDBFieldString<>("ztrseihowebmnkuktkjnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebmnkuktseiymd = new ExDBFieldString<>("ztrseihowebmnkuktseiymd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebankenkanrino = new ExDBFieldString<>("ztrseihowebankenkanrino", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebikkatup = new ExDBFieldNumber<>("ztrseihowebikkatup", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebikkatubaraikbn = new ExDBFieldString<>("ztrseihowebikkatubaraikbn", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Integer> ztrseihowebiktbrikaisuu = new ExDBFieldNumber<>("ztrseihowebiktbrikaisuu", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebzennoup = new ExDBFieldNumber<>("ztrseihowebzennoup", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Long> ztrseihowebgaikazennoup = new ExDBFieldNumber<>("ztrseihowebgaikazennoup", this);

    public final ExDBFieldNumber<ZT_SmbcBosTr, Integer> ztrseihowebzennoukkn = new ExDBFieldNumber<>("ztrseihowebzennoukkn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebzennouhyj = new ExDBFieldString<>("ztrseihowebzennouhyj", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkydbosyuukjncd = new ExDBFieldString<>("ztrseihowebkydbosyuukjncd", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkzktrkmoskbn = new ExDBFieldString<>("ztrseihowebkzktrkmoskbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkzktdkkbn1 = new ExDBFieldString<>("ztrseihowebkzktdkkbn1", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkzkknnm1 = new ExDBFieldString<>("ztrseihowebkzkknnm1", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkzkkjnm1 = new ExDBFieldString<>("ztrseihowebkzkkjnm1", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkzkseikbn1 = new ExDBFieldString<>("ztrseihowebkzkseikbn1", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkzkseiymd1 = new ExDBFieldString<>("ztrseihowebkzkseiymd1", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkzkkykdoukyohyj1 = new ExDBFieldString<>("ztrseihowebkzkkykdoukyohyj1", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkzkyno1 = new ExDBFieldString<>("ztrseihowebkzkyno1", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkzkadr1 = new ExDBFieldString<>("ztrseihowebkzkadr1", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkzktelno1 = new ExDBFieldString<>("ztrseihowebkzktelno1", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkykdrtkkanouhyj = new ExDBFieldString<>("ztrseihowebkykdrtkkanouhyj", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhkndrtkkanouhyj = new ExDBFieldString<>("ztrseihowebhhkndrtkkanouhyj", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebdrtkkbn = new ExDBFieldString<>("ztrseihowebdrtkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebkykdrnrkkbn = new ExDBFieldString<>("ztrseihowebkykdrnrkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhkndrnrkkbn = new ExDBFieldString<>("ztrseihowebhhkndrnrkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhkndrtdkkbn = new ExDBFieldString<>("ztrseihowebhhkndrtdkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhkndrknnm = new ExDBFieldString<>("ztrseihowebhhkndrknnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhkndrkjnm = new ExDBFieldString<>("ztrseihowebhhkndrkjnm", this);

    public final ExDBFieldString<ZT_SmbcBosTr, String> ztrseihowebhhkndrseiymd = new ExDBFieldString<>("ztrseihowebhhkndrseiymd", this);
}
