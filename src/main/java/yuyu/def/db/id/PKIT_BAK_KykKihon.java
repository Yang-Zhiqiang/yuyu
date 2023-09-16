package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.mapping.GenIT_BAK_KykKihon;
import yuyu.def.db.meta.GenQIT_BAK_KykKihon;
import yuyu.def.db.meta.QIT_BAK_KykKihon;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約基本バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KykKihon}</td><td colspan="3">契約基本バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aitesyono</td><td>相手証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>haitoukbn</td><td>配当区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitouKbn C_HaitouKbn}</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>sdpdkbn</td><td>Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sdpd C_Sdpd}</td></tr>
 *  <tr><td>dntryouritukbn</td><td>団体料率区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DntryourituKbn C_DntryourituKbn}</td></tr>
 *  <tr><td>dntcd</td><td>団体コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sntkhoukbn</td><td>選択方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SntkhouKbn C_SntkhouKbn}</td></tr>
 *  <tr><td>sinsakbn</td><td>診査区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SinsaKbn C_SinsaKbn}</td></tr>
 *  <tr><td>mosymd</td><td>申込日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kktymd</td><td>告知日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>fstpnyknymd</td><td>初回保険料入金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mosukeymd</td><td>申込書受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mosjimosuktymd</td><td>申込時申込書受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seirituymd</td><td>成立日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>itiprsymd</td><td>１Ｐ領収予定日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>bosyuuym</td><td>募集年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>seisekiym</td><td>成績計上年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>skeikeijyouym</td><td>新契約計上年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>plancd</td><td>プランコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>planrenno</td><td>プラン連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>aisyoumeikbn</td><td>愛称名区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AisyoumeiKbn C_AisyoumeiKbn}</td></tr>
 *  <tr><td>syusaiumu</td><td>出再有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>stknsetkbn</td><td>質権設定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_StknsetKbn C_StknsetKbn}</td></tr>
 *  <tr><td>kykksykjyumu</td><td>契約者貸付約定有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kykksumu</td><td>契約者貸付有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>aplkahikbn</td><td>ＡＰＬ可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Aplkahi C_Aplkahi}</td></tr>
 *  <tr><td>aplumu</td><td>ＡＰＬ有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>fstphrkkeirokbn</td><td>初回保険料払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FstphrkkeiroKbn C_FstphrkkeiroKbn}</td></tr>
 *  <tr><td>haitounendo</td><td>配当年度</td><td>&nbsp;</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>haitoukinuketorihoukbn</td><td>配当金受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitoukinuketorihouKbn C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>tratkityuiumu</td><td>取扱注意有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tratkityuiuny</td><td>取扱注意内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sbuktnin</td><td>死亡受取人人数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gansindankakuteiymd</td><td>がん診断確定日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mosuketukekbn</td><td>申込受付区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_MosUketukeKbn C_MosUketukeKbn}</td></tr>
 *  <tr><td>kijikbn</td><td>記事区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KijiKbn C_KijiKbn}</td></tr>
 *  <tr><td>hhknsykgycd</td><td>被保険者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnensyuukbn</td><td>被保険者年収区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NensyuuKbn C_NensyuuKbn}</td></tr>
 *  <tr><td>drtenkanritodoufukencd</td><td>代理店管理都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cifcd</td><td>ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>smbckanriid</td><td>ＳＭＢＣ受付管理ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsryhshrkykumukbn</td><td>手数料不支払契約有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kykhonninkakninsyoruikbn</td><td>契約者本人確認書類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HonninkakuninSyoruiKbn C_HonninkakuninSyoruiKbn}</td></tr>
 *  <tr><td>skskknhonninkakninsyoruikbn</td><td>親権者後見人本人確認書類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HonninkakuninSyoruiKbn C_HonninkakuninSyoruiKbn}</td></tr>
 *  <tr><td>boskykjyoutai</td><td>募集契約状態</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Boskykjyoutai C_Boskykjyoutai}</td></tr>
 *  <tr><td>kanyuusyano</td><td>加入者番号</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>drctservicemoskbn</td><td>ダイレクトサービス申込区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DirectServiceMosKbn C_DirectServiceMosKbn}</td></tr>
 *  <tr><td>sksyoukenskskbn</td><td>新契約証券作成区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SkSyoukenSksKbn C_SkSyoukenSksKbn}</td></tr>
 *  <tr><td>sinkyksyokensakuseiymd</td><td>新契約証券作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoyousinkyksyohakkouymd</td><td>証券用新契約証券発行日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>skjmosno</td><td>新契約時申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nkuikosumikbn</td><td>年金移行済区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NkIkouzumiKbn C_NkIkouzumiKbn}</td></tr>
 *  <tr><td>syhenkouymd</td><td>最終変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lastsyosaihkymd</td><td>最終証券再発行日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lastmeihenymd</td><td>最終名義変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lastkykmeighnkymd</td><td>最終契約者名義変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lastsbukthenymd</td><td>最終死亡受取人変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lastkyknmseiymdhenkouymd</td><td>最終契約者名生年月日変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lastkyknmkanakjteiymd</td><td>最終契約者名仮名漢字訂正日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lasttsinynohenkouymd</td><td>最終通信先郵便番号変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lastjyuuhenymd</td><td>最終住所変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seiritujitrhkjikakkbn</td><td>成立時取引時確認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TrhkjiKakKbn C_TrhkjiKakKbn}</td></tr>
 *  <tr><td>tikiktbrisyuruikbn</td><td>定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkiktbrisyuruiKbn C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>yakkanjyuryouhoukbn</td><td>約款受領方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YakkanJyuryouKbn C_YakkanJyuryouKbn}</td></tr>
 *  <tr><td>yakkanbunsyono</td><td>約款文書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siorino</td><td>しおり番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ynkhrkmgkannituutikbn</td><td>円貨払込額案内通知区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YnkHrkmgkAnniTuutiKbn C_YnkHrkmgkAnniTuutiKbn}</td></tr>
 * </table>
 * @see     IT_BAK_KykKihon
 * @see     GenIT_BAK_KykKihon
 * @see     QIT_BAK_KykKihon
 * @see     GenQIT_BAK_KykKihon
 */
public class PKIT_BAK_KykKihon extends AbstractExDBPrimaryKey<IT_BAK_KykKihon, PKIT_BAK_KykKihon> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_KykKihon() {
    }

    public PKIT_BAK_KykKihon(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
    }

    @Transient
    @Override
    public Class<IT_BAK_KykKihon> getEntityClass() {
        return IT_BAK_KykKihon.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }

}