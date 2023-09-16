package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
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
import yuyu.def.db.id.PKJM_Kyuuhu;
import yuyu.def.db.meta.GenQJM_Kyuuhu;
import yuyu.def.db.meta.QJM_Kyuuhu;
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
 * 給付マスタ テーブルのマッピング情報クラスで、 {@link JM_Kyuuhu} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_Kyuuhu}</td><td colspan="3">給付マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKyuuhucd kyuuhucd}</td><td>給付コード</td><td align="center">{@link PKJM_Kyuuhu ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuusyubetu seikyuusyubetu}</td><td>請求種別</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>{@link #getKyuuhuname kyuuhuname}</td><td>給付名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyuuhunamegamen kyuuhunamegamen}</td><td>給付名（画面用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyuuhunamereport kyuuhunamereport}</td><td>給付名（帳票用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHyoujijyun hyoujijyun}</td><td>表示順</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGeninkbn geninkbn}</td><td>原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GeninKbn}</td></tr>
 *  <tr><td>{@link #getSaigaisippeinyuinumukbn saigaisippeinyuinumukbn}</td><td>災害疾病入院有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKyuuhukbn kyuuhukbn}</td><td>給付区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyuuhuKbn}</td></tr>
 *  <tr><td>{@link #getHokenkinsyuruikbn hokenkinsyuruikbn}</td><td>保険金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HokenkinsyuruiKbn}</td></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getUktsyukbn uktsyukbn}</td><td>受取人種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UktsyuKbn}</td></tr>
 *  <tr><td>{@link #getSateirankcd sateirankcd}</td><td>査定ランクコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Sateirank}</td></tr>
 *  <tr><td>{@link #getSeikyuusyainfocheck seikyuusyainfocheck}</td><td>請求者情報チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSinkensyainfocheck sinkensyainfocheck}</td><td>親権者情報チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSouhusakiinfocheck souhusakiinfocheck}</td><td>送付先情報チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSoukinsakiinfocheck soukinsakiinfocheck}</td><td>送金先情報チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getUketorihouhoucheck uketorihouhoucheck}</td><td>受取方法チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNkseikyuucheck nkseikyuucheck}</td><td>年金請求チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHassoukbncheck hassoukbncheck}</td><td>発送区分チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHonninkaknincheck honninkaknincheck}</td><td>本人確認チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSaigaigtkanouseicheck saigaigtkanouseicheck}</td><td>災害該当可能性チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSaikeninfocheck saikeninfocheck}</td><td>債権者情報チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSaisateicheck saisateicheck}</td><td>再査定チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKijyunymdcheck kijyunymdcheck}</td><td>基準日チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getGeninkbncheck geninkbncheck}</td><td>原因区分チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyuhiyoucheck syuhiyoucheck}</td><td>守秘要チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSyoumetucheck syoumetucheck}</td><td>消滅チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDoujisksyoricheck doujisksyoricheck}</td><td>同時請求処理中チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKhsyoricheck khsyoricheck}</td><td>契約保全処理中チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSknnkaisiymdcheck sknnkaisiymdcheck}</td><td>責任開始日チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHknkkncheck hknkkncheck}</td><td>保険期間チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getPhrkyuuyokkncheck phrkyuuyokkncheck}</td><td>保険料払込猶予期間チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getFstphrkyuuyokkntyoukacheck fstphrkyuuyokkntyoukacheck}</td><td>初回保険料払込猶予期間超過チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTokkoudosghtnpcheck tokkoudosghtnpcheck}</td><td>特定高度障害不担保チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHokenkinshrskgnkkncheck hokenkinshrskgnkkncheck}</td><td>保険金支払削減期間チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getNkkiteicheck nkkiteicheck}</td><td>年金規定チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTtdktyuuicheck ttdktyuuicheck}</td><td>手続注意チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getUktcheck uktcheck}</td><td>受取人チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getFirstpminyuucheck firstpminyuucheck}</td><td>初回保険料未入チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSinsatyuuicheck sinsatyuuicheck}</td><td>審査注意チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateijisatumensekicheck sateijisatumensekicheck}</td><td>査定項目＿自殺免責チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateisknnkaisiymdcheck sateisknnkaisiymdcheck}</td><td>査定項目＿責任開始日チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateigengkcheck sateigengkcheck}</td><td>査定項目＿減額チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateimeigihnkcheck sateimeigihnkcheck}</td><td>査定項目＿名義変更チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateistknsetcheck sateistknsetcheck}</td><td>査定項目＿質権設定チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateisaikenkaiyakumcheck sateisaikenkaiyakumcheck}</td><td>査定項目＿債権者解約申出チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateihasantosancheck sateihasantosancheck}</td><td>査定項目＿破産および倒産チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateisasiosaecheck sateisasiosaecheck}</td><td>査定項目＿差押チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateisousasyoukaicheck sateisousasyoukaicheck}</td><td>査定項目＿捜査照会チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateihusyousicheck sateihusyousicheck}</td><td>査定項目＿不詳の死チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateikaigaisbcheck sateikaigaisbcheck}</td><td>査定項目＿海外死亡チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateikaigaicheck sateikaigaicheck}</td><td>査定項目＿海外チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateimrinfocheck sateimrinfocheck}</td><td>査定項目＿ＭＲ情報チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateihigaitoucheck sateihigaitoucheck}</td><td>査定項目＿非該当チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateihnsycheck sateihnsycheck}</td><td>査定項目＿反社チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateiseikyuusyoruicheck sateiseikyuusyoruicheck}</td><td>査定項目＿請求書類チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateisaigaigtkanouseicheck sateisaigaigtkanouseicheck}</td><td>査定項目＿災害該当可能性チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateisaisateicheck sateisaisateicheck}</td><td>査定項目＿再査定チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getCalcsyoruiukeymdcheck calcsyoruiukeymdcheck}</td><td>支払金額計算後＿書類受付日チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getCalchonninkakunincheck calchonninkakunincheck}</td><td>支払金額計算後＿本人確認チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getCalcmnmeigibangoucheck calcmnmeigibangoucheck}</td><td>支払金額計算後＿ＭＮ名義番号チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getCalcsyksbyensitihsyucheck calcsyksbyensitihsyucheck}</td><td>支払金額計算後＿初期死亡時円換算最低保証適用チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHokenkngkhyoujikbn hokenkngkhyoujikbn}</td><td>保険金額表示区分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHokenkngkhyoujimsg1 hokenkngkhyoujimsg1}</td><td>保険金額表示メッセージ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHokenkngkhyoujimsg2 hokenkngkhyoujimsg2}</td><td>保険金額表示メッセージ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMrfkouzatratkicheck mrfkouzatratkicheck}</td><td>ＭＲＦ口座取扱チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKeiyakusyahnkcheck keiyakusyahnkcheck}</td><td>契約者変更チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDskaiyakusyoricheck dskaiyakusyoricheck}</td><td>ＤＳ解約処理中チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getKykymdcheck kykymdcheck}</td><td>契約日チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getEndthnkymdcheck endthnkymdcheck}</td><td>円建変更日チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHrmbrcheck hrmbrcheck}</td><td>返戻金未払いチェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getHaitoukincheck haitoukincheck}</td><td>配当金チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getTmttknjyoutaicheck tmttknjyoutaicheck}</td><td>積立金状態チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getSateisgsbjisatumensekicheck sateisgsbjisatumensekicheck}</td><td>査定項目＿災害死亡自殺免責チェック</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getBkntyousafsyorikbn bkntyousafsyorikbn}</td><td>備金調査ファイル処理区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BknTyousaFSyoriKbn}</td></tr>
 * </table>
 * @see     JM_Kyuuhu
 * @see     PKJM_Kyuuhu
 * @see     QJM_Kyuuhu
 * @see     GenQJM_Kyuuhu
 */
@MappedSuperclass
@Table(name=GenJM_Kyuuhu.TABLE_NAME)
@IdClass(value=PKJM_Kyuuhu.class)
@TypeDefs({
    @TypeDef(name="UserType_C_BknTyousaFSyoriKbn", typeClass=UserType_C_BknTyousaFSyoriKbn.class),
    @TypeDef(name="UserType_C_GeninKbn", typeClass=UserType_C_GeninKbn.class),
    @TypeDef(name="UserType_C_HokenkinsyuruiKbn", typeClass=UserType_C_HokenkinsyuruiKbn.class),
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class),
    @TypeDef(name="UserType_C_KyuuhuKbn", typeClass=UserType_C_KyuuhuKbn.class),
    @TypeDef(name="UserType_C_Sateirank", typeClass=UserType_C_Sateirank.class),
    @TypeDef(name="UserType_C_SeikyuuSyubetu", typeClass=UserType_C_SeikyuuSyubetu.class),
    @TypeDef(name="UserType_C_UktsyuKbn", typeClass=UserType_C_UktsyuKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenJM_Kyuuhu extends AbstractExDBEntity<JM_Kyuuhu, PKJM_Kyuuhu> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JM_Kyuuhu";
    public static final String KYUUHUCD                 = "kyuuhucd";
    public static final String SEIKYUUSYUBETU           = "seikyuusyubetu";
    public static final String KYUUHUNAME               = "kyuuhuname";
    public static final String KYUUHUNAMEGAMEN          = "kyuuhunamegamen";
    public static final String KYUUHUNAMEREPORT         = "kyuuhunamereport";
    public static final String HYOUJIJYUN               = "hyoujijyun";
    public static final String GENINKBN                 = "geninkbn";
    public static final String SAIGAISIPPEINYUINUMUKBN  = "saigaisippeinyuinumukbn";
    public static final String KYUUHUKBN                = "kyuuhukbn";
    public static final String HOKENKINSYURUIKBN        = "hokenkinsyuruikbn";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String UKTSYUKBN                = "uktsyukbn";
    public static final String SATEIRANKCD              = "sateirankcd";
    public static final String SEIKYUUSYAINFOCHECK      = "seikyuusyainfocheck";
    public static final String SINKENSYAINFOCHECK       = "sinkensyainfocheck";
    public static final String SOUHUSAKIINFOCHECK       = "souhusakiinfocheck";
    public static final String SOUKINSAKIINFOCHECK      = "soukinsakiinfocheck";
    public static final String UKETORIHOUHOUCHECK       = "uketorihouhoucheck";
    public static final String NKSEIKYUUCHECK           = "nkseikyuucheck";
    public static final String HASSOUKBNCHECK           = "hassoukbncheck";
    public static final String HONNINKAKNINCHECK        = "honninkaknincheck";
    public static final String SAIGAIGTKANOUSEICHECK    = "saigaigtkanouseicheck";
    public static final String SAIKENINFOCHECK          = "saikeninfocheck";
    public static final String SAISATEICHECK            = "saisateicheck";
    public static final String KIJYUNYMDCHECK           = "kijyunymdcheck";
    public static final String GENINKBNCHECK            = "geninkbncheck";
    public static final String SYUHIYOUCHECK            = "syuhiyoucheck";
    public static final String SYOUMETUCHECK            = "syoumetucheck";
    public static final String DOUJISKSYORICHECK        = "doujisksyoricheck";
    public static final String KHSYORICHECK             = "khsyoricheck";
    public static final String SKNNKAISIYMDCHECK        = "sknnkaisiymdcheck";
    public static final String HKNKKNCHECK              = "hknkkncheck";
    public static final String PHRKYUUYOKKNCHECK        = "phrkyuuyokkncheck";
    public static final String FSTPHRKYUUYOKKNTYOUKACHECK = "fstphrkyuuyokkntyoukacheck";
    public static final String TOKKOUDOSGHTNPCHECK      = "tokkoudosghtnpcheck";
    public static final String HOKENKINSHRSKGNKKNCHECK  = "hokenkinshrskgnkkncheck";
    public static final String NKKITEICHECK             = "nkkiteicheck";
    public static final String TTDKTYUUICHECK           = "ttdktyuuicheck";
    public static final String UKTCHECK                 = "uktcheck";
    public static final String FIRSTPMINYUUCHECK        = "firstpminyuucheck";
    public static final String SINSATYUUICHECK          = "sinsatyuuicheck";
    public static final String SATEIJISATUMENSEKICHECK  = "sateijisatumensekicheck";
    public static final String SATEISKNNKAISIYMDCHECK   = "sateisknnkaisiymdcheck";
    public static final String SATEIGENGKCHECK          = "sateigengkcheck";
    public static final String SATEIMEIGIHNKCHECK       = "sateimeigihnkcheck";
    public static final String SATEISTKNSETCHECK        = "sateistknsetcheck";
    public static final String SATEISAIKENKAIYAKUMCHECK = "sateisaikenkaiyakumcheck";
    public static final String SATEIHASANTOSANCHECK     = "sateihasantosancheck";
    public static final String SATEISASIOSAECHECK       = "sateisasiosaecheck";
    public static final String SATEISOUSASYOUKAICHECK   = "sateisousasyoukaicheck";
    public static final String SATEIHUSYOUSICHECK       = "sateihusyousicheck";
    public static final String SATEIKAIGAISBCHECK       = "sateikaigaisbcheck";
    public static final String SATEIKAIGAICHECK         = "sateikaigaicheck";
    public static final String SATEIMRINFOCHECK         = "sateimrinfocheck";
    public static final String SATEIHIGAITOUCHECK       = "sateihigaitoucheck";
    public static final String SATEIHNSYCHECK           = "sateihnsycheck";
    public static final String SATEISEIKYUUSYORUICHECK  = "sateiseikyuusyoruicheck";
    public static final String SATEISAIGAIGTKANOUSEICHECK = "sateisaigaigtkanouseicheck";
    public static final String SATEISAISATEICHECK       = "sateisaisateicheck";
    public static final String CALCSYORUIUKEYMDCHECK    = "calcsyoruiukeymdcheck";
    public static final String CALCHONNINKAKUNINCHECK   = "calchonninkakunincheck";
    public static final String CALCMNMEIGIBANGOUCHECK   = "calcmnmeigibangoucheck";
    public static final String CALCSYKSBYENSITIHSYUCHECK = "calcsyksbyensitihsyucheck";
    public static final String HOKENKNGKHYOUJIKBN       = "hokenkngkhyoujikbn";
    public static final String HOKENKNGKHYOUJIMSG1      = "hokenkngkhyoujimsg1";
    public static final String HOKENKNGKHYOUJIMSG2      = "hokenkngkhyoujimsg2";
    public static final String MRFKOUZATRATKICHECK      = "mrfkouzatratkicheck";
    public static final String KEIYAKUSYAHNKCHECK       = "keiyakusyahnkcheck";
    public static final String DSKAIYAKUSYORICHECK      = "dskaiyakusyoricheck";
    public static final String KYKYMDCHECK              = "kykymdcheck";
    public static final String ENDTHNKYMDCHECK          = "endthnkymdcheck";
    public static final String HRMBRCHECK               = "hrmbrcheck";
    public static final String HAITOUKINCHECK           = "haitoukincheck";
    public static final String TMTTKNJYOUTAICHECK       = "tmttknjyoutaicheck";
    public static final String SATEISGSBJISATUMENSEKICHECK = "sateisgsbjisatumensekicheck";
    public static final String BKNTYOUSAFSYORIKBN       = "bkntyousafsyorikbn";

    private final PKJM_Kyuuhu primaryKey;

    public GenJM_Kyuuhu() {
        primaryKey = new PKJM_Kyuuhu();
    }

    public GenJM_Kyuuhu(String pKyuuhucd) {
        primaryKey = new PKJM_Kyuuhu(pKyuuhucd);
    }

    @Transient
    @Override
    public PKJM_Kyuuhu getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJM_Kyuuhu> getMetaClass() {
        return QJM_Kyuuhu.class;
    }

    @Id
    @Column(name=GenJM_Kyuuhu.KYUUHUCD)
    public String getKyuuhucd() {
        return getPrimaryKey().getKyuuhucd();
    }

    public void setKyuuhucd(String pKyuuhucd) {
        getPrimaryKey().setKyuuhucd(pKyuuhucd);
    }

    private C_SeikyuuSyubetu seikyuusyubetu;

    @Type(type="UserType_C_SeikyuuSyubetu")
    @Column(name=GenJM_Kyuuhu.SEIKYUUSYUBETU)
    public C_SeikyuuSyubetu getSeikyuusyubetu() {
        return seikyuusyubetu;
    }

    public void setSeikyuusyubetu(C_SeikyuuSyubetu pSeikyuusyubetu) {
        seikyuusyubetu = pSeikyuusyubetu;
    }

    private String kyuuhuname;

    @Column(name=GenJM_Kyuuhu.KYUUHUNAME)
    public String getKyuuhuname() {
        return kyuuhuname;
    }

    public void setKyuuhuname(String pKyuuhuname) {
        kyuuhuname = pKyuuhuname;
    }

    private String kyuuhunamegamen;

    @Column(name=GenJM_Kyuuhu.KYUUHUNAMEGAMEN)
    public String getKyuuhunamegamen() {
        return kyuuhunamegamen;
    }

    public void setKyuuhunamegamen(String pKyuuhunamegamen) {
        kyuuhunamegamen = pKyuuhunamegamen;
    }

    private String kyuuhunamereport;

    @Column(name=GenJM_Kyuuhu.KYUUHUNAMEREPORT)
    public String getKyuuhunamereport() {
        return kyuuhunamereport;
    }

    public void setKyuuhunamereport(String pKyuuhunamereport) {
        kyuuhunamereport = pKyuuhunamereport;
    }

    private Integer hyoujijyun;

    @Column(name=GenJM_Kyuuhu.HYOUJIJYUN)
    public Integer getHyoujijyun() {
        return hyoujijyun;
    }

    public void setHyoujijyun(Integer pHyoujijyun) {
        hyoujijyun = pHyoujijyun;
    }

    private C_GeninKbn geninkbn;

    @Type(type="UserType_C_GeninKbn")
    @Column(name=GenJM_Kyuuhu.GENINKBN)
    public C_GeninKbn getGeninkbn() {
        return geninkbn;
    }

    public void setGeninkbn(C_GeninKbn pGeninkbn) {
        geninkbn = pGeninkbn;
    }

    private C_UmuKbn saigaisippeinyuinumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SAIGAISIPPEINYUINUMUKBN)
    public C_UmuKbn getSaigaisippeinyuinumukbn() {
        return saigaisippeinyuinumukbn;
    }

    public void setSaigaisippeinyuinumukbn(C_UmuKbn pSaigaisippeinyuinumukbn) {
        saigaisippeinyuinumukbn = pSaigaisippeinyuinumukbn;
    }

    private C_KyuuhuKbn kyuuhukbn;

    @Type(type="UserType_C_KyuuhuKbn")
    @Column(name=GenJM_Kyuuhu.KYUUHUKBN)
    public C_KyuuhuKbn getKyuuhukbn() {
        return kyuuhukbn;
    }

    public void setKyuuhukbn(C_KyuuhuKbn pKyuuhukbn) {
        kyuuhukbn = pKyuuhukbn;
    }

    private C_HokenkinsyuruiKbn hokenkinsyuruikbn;

    @Type(type="UserType_C_HokenkinsyuruiKbn")
    @Column(name=GenJM_Kyuuhu.HOKENKINSYURUIKBN)
    public C_HokenkinsyuruiKbn getHokenkinsyuruikbn() {
        return hokenkinsyuruikbn;
    }

    public void setHokenkinsyuruikbn(C_HokenkinsyuruiKbn pHokenkinsyuruikbn) {
        hokenkinsyuruikbn = pHokenkinsyuruikbn;
    }

    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenJM_Kyuuhu.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return kanjyoukmkcd;
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        kanjyoukmkcd = pKanjyoukmkcd;
    }

    private C_UktsyuKbn uktsyukbn;

    @Type(type="UserType_C_UktsyuKbn")
    @Column(name=GenJM_Kyuuhu.UKTSYUKBN)
    public C_UktsyuKbn getUktsyukbn() {
        return uktsyukbn;
    }

    public void setUktsyukbn(C_UktsyuKbn pUktsyukbn) {
        uktsyukbn = pUktsyukbn;
    }

    private C_Sateirank sateirankcd;

    @Type(type="UserType_C_Sateirank")
    @Column(name=GenJM_Kyuuhu.SATEIRANKCD)
    public C_Sateirank getSateirankcd() {
        return sateirankcd;
    }

    public void setSateirankcd(C_Sateirank pSateirankcd) {
        sateirankcd = pSateirankcd;
    }

    private C_UmuKbn seikyuusyainfocheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SEIKYUUSYAINFOCHECK)
    public C_UmuKbn getSeikyuusyainfocheck() {
        return seikyuusyainfocheck;
    }

    public void setSeikyuusyainfocheck(C_UmuKbn pSeikyuusyainfocheck) {
        seikyuusyainfocheck = pSeikyuusyainfocheck;
    }

    private C_UmuKbn sinkensyainfocheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SINKENSYAINFOCHECK)
    public C_UmuKbn getSinkensyainfocheck() {
        return sinkensyainfocheck;
    }

    public void setSinkensyainfocheck(C_UmuKbn pSinkensyainfocheck) {
        sinkensyainfocheck = pSinkensyainfocheck;
    }

    private C_UmuKbn souhusakiinfocheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SOUHUSAKIINFOCHECK)
    public C_UmuKbn getSouhusakiinfocheck() {
        return souhusakiinfocheck;
    }

    public void setSouhusakiinfocheck(C_UmuKbn pSouhusakiinfocheck) {
        souhusakiinfocheck = pSouhusakiinfocheck;
    }

    private C_UmuKbn soukinsakiinfocheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SOUKINSAKIINFOCHECK)
    public C_UmuKbn getSoukinsakiinfocheck() {
        return soukinsakiinfocheck;
    }

    public void setSoukinsakiinfocheck(C_UmuKbn pSoukinsakiinfocheck) {
        soukinsakiinfocheck = pSoukinsakiinfocheck;
    }

    private C_UmuKbn uketorihouhoucheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.UKETORIHOUHOUCHECK)
    public C_UmuKbn getUketorihouhoucheck() {
        return uketorihouhoucheck;
    }

    public void setUketorihouhoucheck(C_UmuKbn pUketorihouhoucheck) {
        uketorihouhoucheck = pUketorihouhoucheck;
    }

    private C_UmuKbn nkseikyuucheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.NKSEIKYUUCHECK)
    public C_UmuKbn getNkseikyuucheck() {
        return nkseikyuucheck;
    }

    public void setNkseikyuucheck(C_UmuKbn pNkseikyuucheck) {
        nkseikyuucheck = pNkseikyuucheck;
    }

    private C_UmuKbn hassoukbncheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.HASSOUKBNCHECK)
    public C_UmuKbn getHassoukbncheck() {
        return hassoukbncheck;
    }

    public void setHassoukbncheck(C_UmuKbn pHassoukbncheck) {
        hassoukbncheck = pHassoukbncheck;
    }

    private C_UmuKbn honninkaknincheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.HONNINKAKNINCHECK)
    public C_UmuKbn getHonninkaknincheck() {
        return honninkaknincheck;
    }

    public void setHonninkaknincheck(C_UmuKbn pHonninkaknincheck) {
        honninkaknincheck = pHonninkaknincheck;
    }

    private C_UmuKbn saigaigtkanouseicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SAIGAIGTKANOUSEICHECK)
    public C_UmuKbn getSaigaigtkanouseicheck() {
        return saigaigtkanouseicheck;
    }

    public void setSaigaigtkanouseicheck(C_UmuKbn pSaigaigtkanouseicheck) {
        saigaigtkanouseicheck = pSaigaigtkanouseicheck;
    }

    private C_UmuKbn saikeninfocheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SAIKENINFOCHECK)
    public C_UmuKbn getSaikeninfocheck() {
        return saikeninfocheck;
    }

    public void setSaikeninfocheck(C_UmuKbn pSaikeninfocheck) {
        saikeninfocheck = pSaikeninfocheck;
    }

    private C_UmuKbn saisateicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SAISATEICHECK)
    public C_UmuKbn getSaisateicheck() {
        return saisateicheck;
    }

    public void setSaisateicheck(C_UmuKbn pSaisateicheck) {
        saisateicheck = pSaisateicheck;
    }

    private C_UmuKbn kijyunymdcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.KIJYUNYMDCHECK)
    public C_UmuKbn getKijyunymdcheck() {
        return kijyunymdcheck;
    }

    public void setKijyunymdcheck(C_UmuKbn pKijyunymdcheck) {
        kijyunymdcheck = pKijyunymdcheck;
    }

    private C_UmuKbn geninkbncheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.GENINKBNCHECK)
    public C_UmuKbn getGeninkbncheck() {
        return geninkbncheck;
    }

    public void setGeninkbncheck(C_UmuKbn pGeninkbncheck) {
        geninkbncheck = pGeninkbncheck;
    }

    private C_UmuKbn syuhiyoucheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SYUHIYOUCHECK)
    public C_UmuKbn getSyuhiyoucheck() {
        return syuhiyoucheck;
    }

    public void setSyuhiyoucheck(C_UmuKbn pSyuhiyoucheck) {
        syuhiyoucheck = pSyuhiyoucheck;
    }

    private C_UmuKbn syoumetucheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SYOUMETUCHECK)
    public C_UmuKbn getSyoumetucheck() {
        return syoumetucheck;
    }

    public void setSyoumetucheck(C_UmuKbn pSyoumetucheck) {
        syoumetucheck = pSyoumetucheck;
    }

    private C_UmuKbn doujisksyoricheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.DOUJISKSYORICHECK)
    public C_UmuKbn getDoujisksyoricheck() {
        return doujisksyoricheck;
    }

    public void setDoujisksyoricheck(C_UmuKbn pDoujisksyoricheck) {
        doujisksyoricheck = pDoujisksyoricheck;
    }

    private C_UmuKbn khsyoricheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.KHSYORICHECK)
    public C_UmuKbn getKhsyoricheck() {
        return khsyoricheck;
    }

    public void setKhsyoricheck(C_UmuKbn pKhsyoricheck) {
        khsyoricheck = pKhsyoricheck;
    }

    private C_UmuKbn sknnkaisiymdcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SKNNKAISIYMDCHECK)
    public C_UmuKbn getSknnkaisiymdcheck() {
        return sknnkaisiymdcheck;
    }

    public void setSknnkaisiymdcheck(C_UmuKbn pSknnkaisiymdcheck) {
        sknnkaisiymdcheck = pSknnkaisiymdcheck;
    }

    private C_UmuKbn hknkkncheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.HKNKKNCHECK)
    public C_UmuKbn getHknkkncheck() {
        return hknkkncheck;
    }

    public void setHknkkncheck(C_UmuKbn pHknkkncheck) {
        hknkkncheck = pHknkkncheck;
    }

    private C_UmuKbn phrkyuuyokkncheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.PHRKYUUYOKKNCHECK)
    public C_UmuKbn getPhrkyuuyokkncheck() {
        return phrkyuuyokkncheck;
    }

    public void setPhrkyuuyokkncheck(C_UmuKbn pPhrkyuuyokkncheck) {
        phrkyuuyokkncheck = pPhrkyuuyokkncheck;
    }

    private C_UmuKbn fstphrkyuuyokkntyoukacheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.FSTPHRKYUUYOKKNTYOUKACHECK)
    public C_UmuKbn getFstphrkyuuyokkntyoukacheck() {
        return fstphrkyuuyokkntyoukacheck;
    }

    public void setFstphrkyuuyokkntyoukacheck(C_UmuKbn pFstphrkyuuyokkntyoukacheck) {
        fstphrkyuuyokkntyoukacheck = pFstphrkyuuyokkntyoukacheck;
    }

    private C_UmuKbn tokkoudosghtnpcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.TOKKOUDOSGHTNPCHECK)
    public C_UmuKbn getTokkoudosghtnpcheck() {
        return tokkoudosghtnpcheck;
    }

    public void setTokkoudosghtnpcheck(C_UmuKbn pTokkoudosghtnpcheck) {
        tokkoudosghtnpcheck = pTokkoudosghtnpcheck;
    }

    private C_UmuKbn hokenkinshrskgnkkncheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.HOKENKINSHRSKGNKKNCHECK)
    public C_UmuKbn getHokenkinshrskgnkkncheck() {
        return hokenkinshrskgnkkncheck;
    }

    public void setHokenkinshrskgnkkncheck(C_UmuKbn pHokenkinshrskgnkkncheck) {
        hokenkinshrskgnkkncheck = pHokenkinshrskgnkkncheck;
    }

    private C_UmuKbn nkkiteicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.NKKITEICHECK)
    public C_UmuKbn getNkkiteicheck() {
        return nkkiteicheck;
    }

    public void setNkkiteicheck(C_UmuKbn pNkkiteicheck) {
        nkkiteicheck = pNkkiteicheck;
    }

    private C_UmuKbn ttdktyuuicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.TTDKTYUUICHECK)
    public C_UmuKbn getTtdktyuuicheck() {
        return ttdktyuuicheck;
    }

    public void setTtdktyuuicheck(C_UmuKbn pTtdktyuuicheck) {
        ttdktyuuicheck = pTtdktyuuicheck;
    }

    private C_UmuKbn uktcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.UKTCHECK)
    public C_UmuKbn getUktcheck() {
        return uktcheck;
    }

    public void setUktcheck(C_UmuKbn pUktcheck) {
        uktcheck = pUktcheck;
    }

    private C_UmuKbn firstpminyuucheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.FIRSTPMINYUUCHECK)
    public C_UmuKbn getFirstpminyuucheck() {
        return firstpminyuucheck;
    }

    public void setFirstpminyuucheck(C_UmuKbn pFirstpminyuucheck) {
        firstpminyuucheck = pFirstpminyuucheck;
    }

    private C_UmuKbn sinsatyuuicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SINSATYUUICHECK)
    public C_UmuKbn getSinsatyuuicheck() {
        return sinsatyuuicheck;
    }

    public void setSinsatyuuicheck(C_UmuKbn pSinsatyuuicheck) {
        sinsatyuuicheck = pSinsatyuuicheck;
    }

    private C_UmuKbn sateijisatumensekicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEIJISATUMENSEKICHECK)
    public C_UmuKbn getSateijisatumensekicheck() {
        return sateijisatumensekicheck;
    }

    public void setSateijisatumensekicheck(C_UmuKbn pSateijisatumensekicheck) {
        sateijisatumensekicheck = pSateijisatumensekicheck;
    }

    private C_UmuKbn sateisknnkaisiymdcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEISKNNKAISIYMDCHECK)
    public C_UmuKbn getSateisknnkaisiymdcheck() {
        return sateisknnkaisiymdcheck;
    }

    public void setSateisknnkaisiymdcheck(C_UmuKbn pSateisknnkaisiymdcheck) {
        sateisknnkaisiymdcheck = pSateisknnkaisiymdcheck;
    }

    private C_UmuKbn sateigengkcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEIGENGKCHECK)
    public C_UmuKbn getSateigengkcheck() {
        return sateigengkcheck;
    }

    public void setSateigengkcheck(C_UmuKbn pSateigengkcheck) {
        sateigengkcheck = pSateigengkcheck;
    }

    private C_UmuKbn sateimeigihnkcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEIMEIGIHNKCHECK)
    public C_UmuKbn getSateimeigihnkcheck() {
        return sateimeigihnkcheck;
    }

    public void setSateimeigihnkcheck(C_UmuKbn pSateimeigihnkcheck) {
        sateimeigihnkcheck = pSateimeigihnkcheck;
    }

    private C_UmuKbn sateistknsetcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEISTKNSETCHECK)
    public C_UmuKbn getSateistknsetcheck() {
        return sateistknsetcheck;
    }

    public void setSateistknsetcheck(C_UmuKbn pSateistknsetcheck) {
        sateistknsetcheck = pSateistknsetcheck;
    }

    private C_UmuKbn sateisaikenkaiyakumcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEISAIKENKAIYAKUMCHECK)
    public C_UmuKbn getSateisaikenkaiyakumcheck() {
        return sateisaikenkaiyakumcheck;
    }

    public void setSateisaikenkaiyakumcheck(C_UmuKbn pSateisaikenkaiyakumcheck) {
        sateisaikenkaiyakumcheck = pSateisaikenkaiyakumcheck;
    }

    private C_UmuKbn sateihasantosancheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEIHASANTOSANCHECK)
    public C_UmuKbn getSateihasantosancheck() {
        return sateihasantosancheck;
    }

    public void setSateihasantosancheck(C_UmuKbn pSateihasantosancheck) {
        sateihasantosancheck = pSateihasantosancheck;
    }

    private C_UmuKbn sateisasiosaecheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEISASIOSAECHECK)
    public C_UmuKbn getSateisasiosaecheck() {
        return sateisasiosaecheck;
    }

    public void setSateisasiosaecheck(C_UmuKbn pSateisasiosaecheck) {
        sateisasiosaecheck = pSateisasiosaecheck;
    }

    private C_UmuKbn sateisousasyoukaicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEISOUSASYOUKAICHECK)
    public C_UmuKbn getSateisousasyoukaicheck() {
        return sateisousasyoukaicheck;
    }

    public void setSateisousasyoukaicheck(C_UmuKbn pSateisousasyoukaicheck) {
        sateisousasyoukaicheck = pSateisousasyoukaicheck;
    }

    private C_UmuKbn sateihusyousicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEIHUSYOUSICHECK)
    public C_UmuKbn getSateihusyousicheck() {
        return sateihusyousicheck;
    }

    public void setSateihusyousicheck(C_UmuKbn pSateihusyousicheck) {
        sateihusyousicheck = pSateihusyousicheck;
    }

    private C_UmuKbn sateikaigaisbcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEIKAIGAISBCHECK)
    public C_UmuKbn getSateikaigaisbcheck() {
        return sateikaigaisbcheck;
    }

    public void setSateikaigaisbcheck(C_UmuKbn pSateikaigaisbcheck) {
        sateikaigaisbcheck = pSateikaigaisbcheck;
    }

    private C_UmuKbn sateikaigaicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEIKAIGAICHECK)
    public C_UmuKbn getSateikaigaicheck() {
        return sateikaigaicheck;
    }

    public void setSateikaigaicheck(C_UmuKbn pSateikaigaicheck) {
        sateikaigaicheck = pSateikaigaicheck;
    }

    private C_UmuKbn sateimrinfocheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEIMRINFOCHECK)
    public C_UmuKbn getSateimrinfocheck() {
        return sateimrinfocheck;
    }

    public void setSateimrinfocheck(C_UmuKbn pSateimrinfocheck) {
        sateimrinfocheck = pSateimrinfocheck;
    }

    private C_UmuKbn sateihigaitoucheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEIHIGAITOUCHECK)
    public C_UmuKbn getSateihigaitoucheck() {
        return sateihigaitoucheck;
    }

    public void setSateihigaitoucheck(C_UmuKbn pSateihigaitoucheck) {
        sateihigaitoucheck = pSateihigaitoucheck;
    }

    private C_UmuKbn sateihnsycheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEIHNSYCHECK)
    public C_UmuKbn getSateihnsycheck() {
        return sateihnsycheck;
    }

    public void setSateihnsycheck(C_UmuKbn pSateihnsycheck) {
        sateihnsycheck = pSateihnsycheck;
    }

    private C_UmuKbn sateiseikyuusyoruicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEISEIKYUUSYORUICHECK)
    public C_UmuKbn getSateiseikyuusyoruicheck() {
        return sateiseikyuusyoruicheck;
    }

    public void setSateiseikyuusyoruicheck(C_UmuKbn pSateiseikyuusyoruicheck) {
        sateiseikyuusyoruicheck = pSateiseikyuusyoruicheck;
    }

    private C_UmuKbn sateisaigaigtkanouseicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEISAIGAIGTKANOUSEICHECK)
    public C_UmuKbn getSateisaigaigtkanouseicheck() {
        return sateisaigaigtkanouseicheck;
    }

    public void setSateisaigaigtkanouseicheck(C_UmuKbn pSateisaigaigtkanouseicheck) {
        sateisaigaigtkanouseicheck = pSateisaigaigtkanouseicheck;
    }

    private C_UmuKbn sateisaisateicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEISAISATEICHECK)
    public C_UmuKbn getSateisaisateicheck() {
        return sateisaisateicheck;
    }

    public void setSateisaisateicheck(C_UmuKbn pSateisaisateicheck) {
        sateisaisateicheck = pSateisaisateicheck;
    }

    private C_UmuKbn calcsyoruiukeymdcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.CALCSYORUIUKEYMDCHECK)
    public C_UmuKbn getCalcsyoruiukeymdcheck() {
        return calcsyoruiukeymdcheck;
    }

    public void setCalcsyoruiukeymdcheck(C_UmuKbn pCalcsyoruiukeymdcheck) {
        calcsyoruiukeymdcheck = pCalcsyoruiukeymdcheck;
    }

    private C_UmuKbn calchonninkakunincheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.CALCHONNINKAKUNINCHECK)
    public C_UmuKbn getCalchonninkakunincheck() {
        return calchonninkakunincheck;
    }

    public void setCalchonninkakunincheck(C_UmuKbn pCalchonninkakunincheck) {
        calchonninkakunincheck = pCalchonninkakunincheck;
    }

    private C_UmuKbn calcmnmeigibangoucheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.CALCMNMEIGIBANGOUCHECK)
    public C_UmuKbn getCalcmnmeigibangoucheck() {
        return calcmnmeigibangoucheck;
    }

    public void setCalcmnmeigibangoucheck(C_UmuKbn pCalcmnmeigibangoucheck) {
        calcmnmeigibangoucheck = pCalcmnmeigibangoucheck;
    }

    private C_UmuKbn calcsyksbyensitihsyucheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.CALCSYKSBYENSITIHSYUCHECK)
    public C_UmuKbn getCalcsyksbyensitihsyucheck() {
        return calcsyksbyensitihsyucheck;
    }

    public void setCalcsyksbyensitihsyucheck(C_UmuKbn pCalcsyksbyensitihsyucheck) {
        calcsyksbyensitihsyucheck = pCalcsyksbyensitihsyucheck;
    }

    private Integer hokenkngkhyoujikbn;

    @Column(name=GenJM_Kyuuhu.HOKENKNGKHYOUJIKBN)
    public Integer getHokenkngkhyoujikbn() {
        return hokenkngkhyoujikbn;
    }

    public void setHokenkngkhyoujikbn(Integer pHokenkngkhyoujikbn) {
        hokenkngkhyoujikbn = pHokenkngkhyoujikbn;
    }

    private String hokenkngkhyoujimsg1;

    @Column(name=GenJM_Kyuuhu.HOKENKNGKHYOUJIMSG1)
    public String getHokenkngkhyoujimsg1() {
        return hokenkngkhyoujimsg1;
    }

    public void setHokenkngkhyoujimsg1(String pHokenkngkhyoujimsg1) {
        hokenkngkhyoujimsg1 = pHokenkngkhyoujimsg1;
    }

    private String hokenkngkhyoujimsg2;

    @Column(name=GenJM_Kyuuhu.HOKENKNGKHYOUJIMSG2)
    public String getHokenkngkhyoujimsg2() {
        return hokenkngkhyoujimsg2;
    }

    public void setHokenkngkhyoujimsg2(String pHokenkngkhyoujimsg2) {
        hokenkngkhyoujimsg2 = pHokenkngkhyoujimsg2;
    }

    private C_UmuKbn mrfkouzatratkicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.MRFKOUZATRATKICHECK)
    public C_UmuKbn getMrfkouzatratkicheck() {
        return mrfkouzatratkicheck;
    }

    public void setMrfkouzatratkicheck(C_UmuKbn pMrfkouzatratkicheck) {
        mrfkouzatratkicheck = pMrfkouzatratkicheck;
    }

    private C_UmuKbn keiyakusyahnkcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.KEIYAKUSYAHNKCHECK)
    public C_UmuKbn getKeiyakusyahnkcheck() {
        return keiyakusyahnkcheck;
    }

    public void setKeiyakusyahnkcheck(C_UmuKbn pKeiyakusyahnkcheck) {
        keiyakusyahnkcheck = pKeiyakusyahnkcheck;
    }

    private C_UmuKbn dskaiyakusyoricheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.DSKAIYAKUSYORICHECK)
    public C_UmuKbn getDskaiyakusyoricheck() {
        return dskaiyakusyoricheck;
    }

    public void setDskaiyakusyoricheck(C_UmuKbn pDskaiyakusyoricheck) {
        dskaiyakusyoricheck = pDskaiyakusyoricheck;
    }

    private C_UmuKbn kykymdcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.KYKYMDCHECK)
    public C_UmuKbn getKykymdcheck() {
        return kykymdcheck;
    }

    public void setKykymdcheck(C_UmuKbn pKykymdcheck) {
        kykymdcheck = pKykymdcheck;
    }

    private C_UmuKbn endthnkymdcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.ENDTHNKYMDCHECK)
    public C_UmuKbn getEndthnkymdcheck() {
        return endthnkymdcheck;
    }

    public void setEndthnkymdcheck(C_UmuKbn pEndthnkymdcheck) {
        endthnkymdcheck = pEndthnkymdcheck;
    }

    private C_UmuKbn hrmbrcheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.HRMBRCHECK)
    public C_UmuKbn getHrmbrcheck() {
        return hrmbrcheck;
    }

    public void setHrmbrcheck(C_UmuKbn pHrmbrcheck) {
        hrmbrcheck = pHrmbrcheck;
    }

    private C_UmuKbn haitoukincheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.HAITOUKINCHECK)
    public C_UmuKbn getHaitoukincheck() {
        return haitoukincheck;
    }

    public void setHaitoukincheck(C_UmuKbn pHaitoukincheck) {
        haitoukincheck = pHaitoukincheck;
    }

    private C_UmuKbn tmttknjyoutaicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.TMTTKNJYOUTAICHECK)
    public C_UmuKbn getTmttknjyoutaicheck() {
        return tmttknjyoutaicheck;
    }

    public void setTmttknjyoutaicheck(C_UmuKbn pTmttknjyoutaicheck) {
        tmttknjyoutaicheck = pTmttknjyoutaicheck;
    }

    private C_UmuKbn sateisgsbjisatumensekicheck;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenJM_Kyuuhu.SATEISGSBJISATUMENSEKICHECK)
    public C_UmuKbn getSateisgsbjisatumensekicheck() {
        return sateisgsbjisatumensekicheck;
    }

    public void setSateisgsbjisatumensekicheck(C_UmuKbn pSateisgsbjisatumensekicheck) {
        sateisgsbjisatumensekicheck = pSateisgsbjisatumensekicheck;
    }

    private C_BknTyousaFSyoriKbn bkntyousafsyorikbn;

    @Type(type="UserType_C_BknTyousaFSyoriKbn")
    @Column(name=GenJM_Kyuuhu.BKNTYOUSAFSYORIKBN)
    public C_BknTyousaFSyoriKbn getBkntyousafsyorikbn() {
        return bkntyousafsyorikbn;
    }

    public void setBkntyousafsyorikbn(C_BknTyousaFSyoriKbn pBkntyousafsyorikbn) {
        bkntyousafsyorikbn = pBkntyousafsyorikbn;
    }
}