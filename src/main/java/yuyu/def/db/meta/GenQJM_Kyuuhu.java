package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BknTyousaFSyoriKbn;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KyuuhuKbn;
import yuyu.def.classification.C_Sateirank;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.type.UserType_C_BknTyousaFSyoriKbn;
import yuyu.def.db.type.UserType_C_GeninKbn;
import yuyu.def.db.type.UserType_C_HokenkinsyuruiKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KyuuhuKbn;
import yuyu.def.db.type.UserType_C_Sateirank;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_UktsyuKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 給付マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJM_Kyuuhu extends AbstractExDBTable<JM_Kyuuhu> {

    public GenQJM_Kyuuhu() {
        this("JM_Kyuuhu");
    }

    public GenQJM_Kyuuhu(String pAlias) {
        super("JM_Kyuuhu", JM_Kyuuhu.class, pAlias);
    }

    public String JM_Kyuuhu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JM_Kyuuhu, String> kyuuhucd = new ExDBFieldString<>("kyuuhucd", this);

    public final ExDBFieldString<JM_Kyuuhu, C_SeikyuuSyubetu> seikyuusyubetu = new ExDBFieldString<>("seikyuusyubetu", this, UserType_C_SeikyuuSyubetu.class);

    public final ExDBFieldString<JM_Kyuuhu, String> kyuuhuname = new ExDBFieldString<>("kyuuhuname", this);

    public final ExDBFieldString<JM_Kyuuhu, String> kyuuhunamegamen = new ExDBFieldString<>("kyuuhunamegamen", this);

    public final ExDBFieldString<JM_Kyuuhu, String> kyuuhunamereport = new ExDBFieldString<>("kyuuhunamereport", this);

    public final ExDBFieldNumber<JM_Kyuuhu, Integer> hyoujijyun = new ExDBFieldNumber<>("hyoujijyun", this);

    public final ExDBFieldString<JM_Kyuuhu, C_GeninKbn> geninkbn = new ExDBFieldString<>("geninkbn", this, UserType_C_GeninKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> saigaisippeinyuinumukbn = new ExDBFieldString<>("saigaisippeinyuinumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_KyuuhuKbn> kyuuhukbn = new ExDBFieldString<>("kyuuhukbn", this, UserType_C_KyuuhuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_HokenkinsyuruiKbn> hokenkinsyuruikbn = new ExDBFieldString<>("hokenkinsyuruikbn", this, UserType_C_HokenkinsyuruiKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UktsyuKbn> uktsyukbn = new ExDBFieldString<>("uktsyukbn", this, UserType_C_UktsyuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_Sateirank> sateirankcd = new ExDBFieldString<>("sateirankcd", this, UserType_C_Sateirank.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> seikyuusyainfocheck = new ExDBFieldString<>("seikyuusyainfocheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sinkensyainfocheck = new ExDBFieldString<>("sinkensyainfocheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> souhusakiinfocheck = new ExDBFieldString<>("souhusakiinfocheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> soukinsakiinfocheck = new ExDBFieldString<>("soukinsakiinfocheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> uketorihouhoucheck = new ExDBFieldString<>("uketorihouhoucheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> nkseikyuucheck = new ExDBFieldString<>("nkseikyuucheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> hassoukbncheck = new ExDBFieldString<>("hassoukbncheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> honninkaknincheck = new ExDBFieldString<>("honninkaknincheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> saigaigtkanouseicheck = new ExDBFieldString<>("saigaigtkanouseicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> saikeninfocheck = new ExDBFieldString<>("saikeninfocheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> saisateicheck = new ExDBFieldString<>("saisateicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> kijyunymdcheck = new ExDBFieldString<>("kijyunymdcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> geninkbncheck = new ExDBFieldString<>("geninkbncheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> syuhiyoucheck = new ExDBFieldString<>("syuhiyoucheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> syoumetucheck = new ExDBFieldString<>("syoumetucheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> doujisksyoricheck = new ExDBFieldString<>("doujisksyoricheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> khsyoricheck = new ExDBFieldString<>("khsyoricheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sknnkaisiymdcheck = new ExDBFieldString<>("sknnkaisiymdcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> hknkkncheck = new ExDBFieldString<>("hknkkncheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> phrkyuuyokkncheck = new ExDBFieldString<>("phrkyuuyokkncheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> fstphrkyuuyokkntyoukacheck = new ExDBFieldString<>("fstphrkyuuyokkntyoukacheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> tokkoudosghtnpcheck = new ExDBFieldString<>("tokkoudosghtnpcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> hokenkinshrskgnkkncheck = new ExDBFieldString<>("hokenkinshrskgnkkncheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> nkkiteicheck = new ExDBFieldString<>("nkkiteicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> ttdktyuuicheck = new ExDBFieldString<>("ttdktyuuicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> uktcheck = new ExDBFieldString<>("uktcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> firstpminyuucheck = new ExDBFieldString<>("firstpminyuucheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sinsatyuuicheck = new ExDBFieldString<>("sinsatyuuicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateijisatumensekicheck = new ExDBFieldString<>("sateijisatumensekicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateisknnkaisiymdcheck = new ExDBFieldString<>("sateisknnkaisiymdcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateigengkcheck = new ExDBFieldString<>("sateigengkcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateimeigihnkcheck = new ExDBFieldString<>("sateimeigihnkcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateistknsetcheck = new ExDBFieldString<>("sateistknsetcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateisaikenkaiyakumcheck = new ExDBFieldString<>("sateisaikenkaiyakumcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateihasantosancheck = new ExDBFieldString<>("sateihasantosancheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateisasiosaecheck = new ExDBFieldString<>("sateisasiosaecheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateisousasyoukaicheck = new ExDBFieldString<>("sateisousasyoukaicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateihusyousicheck = new ExDBFieldString<>("sateihusyousicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateikaigaisbcheck = new ExDBFieldString<>("sateikaigaisbcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateikaigaicheck = new ExDBFieldString<>("sateikaigaicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateimrinfocheck = new ExDBFieldString<>("sateimrinfocheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateihigaitoucheck = new ExDBFieldString<>("sateihigaitoucheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateihnsycheck = new ExDBFieldString<>("sateihnsycheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateiseikyuusyoruicheck = new ExDBFieldString<>("sateiseikyuusyoruicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateisaigaigtkanouseicheck = new ExDBFieldString<>("sateisaigaigtkanouseicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateisaisateicheck = new ExDBFieldString<>("sateisaisateicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> calcsyoruiukeymdcheck = new ExDBFieldString<>("calcsyoruiukeymdcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> calchonninkakunincheck = new ExDBFieldString<>("calchonninkakunincheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> calcmnmeigibangoucheck = new ExDBFieldString<>("calcmnmeigibangoucheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> calcsyksbyensitihsyucheck = new ExDBFieldString<>("calcsyksbyensitihsyucheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldNumber<JM_Kyuuhu, Integer> hokenkngkhyoujikbn = new ExDBFieldNumber<>("hokenkngkhyoujikbn", this);

    public final ExDBFieldString<JM_Kyuuhu, String> hokenkngkhyoujimsg1 = new ExDBFieldString<>("hokenkngkhyoujimsg1", this);

    public final ExDBFieldString<JM_Kyuuhu, String> hokenkngkhyoujimsg2 = new ExDBFieldString<>("hokenkngkhyoujimsg2", this);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> mrfkouzatratkicheck = new ExDBFieldString<>("mrfkouzatratkicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> keiyakusyahnkcheck = new ExDBFieldString<>("keiyakusyahnkcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> dskaiyakusyoricheck = new ExDBFieldString<>("dskaiyakusyoricheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> kykymdcheck = new ExDBFieldString<>("kykymdcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> endthnkymdcheck = new ExDBFieldString<>("endthnkymdcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> hrmbrcheck = new ExDBFieldString<>("hrmbrcheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> haitoukincheck = new ExDBFieldString<>("haitoukincheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> tmttknjyoutaicheck = new ExDBFieldString<>("tmttknjyoutaicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_UmuKbn> sateisgsbjisatumensekicheck = new ExDBFieldString<>("sateisgsbjisatumensekicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_Kyuuhu, C_BknTyousaFSyoriKbn> bkntyousafsyorikbn = new ExDBFieldString<>("bkntyousafsyorikbn", this, UserType_C_BknTyousaFSyoriKbn.class);
}
