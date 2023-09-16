package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.SV_IdouMeisai;
import yuyu.def.db.mapping.GenSV_IdouMeisai;
import yuyu.def.db.meta.GenQSV_IdouMeisai;
import yuyu.def.db.meta.QSV_IdouMeisai;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 異動明細情報ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_IdouMeisai}</td><td colspan="3">異動明細情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sdpdkbn</td><td>Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sdpd C_Sdpd}</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>bosyuuym</td><td>募集年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>skeikeijyouym</td><td>新契約計上年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>hhknsykgycd</td><td>被保険者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenkanritodoufukencd</td><td>代理店管理都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cifcd</td><td>ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fstpnyknymd</td><td>初回保険料入金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>seirituymd</td><td>成立日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>haitoukinuketorihoukbn</td><td>配当金受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitoukinuketorihouKbn C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>tikiktbrisyuruikbn</td><td>定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkiktbrisyuruiKbn C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>syutkkbn</td><td>主契約特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoumetujiyuu</td><td>消滅事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syoumetujiyuu C_Syoumetujiyuu}</td></tr>
 *  <tr><td>yendthnkymd</td><td>円建変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>drtencd</td><td>代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenkanrisosikicd</td><td>代理店管理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>daibosyuucd</td><td>代表募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenbunumu</td><td>代理店分担有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kyksakuinmeino</td><td>契約者索引名番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kkkyktdk</td><td>契約管理契約者続柄</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>kykseiymd</td><td>契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>henkousikibetukey</td><td>変更識別キー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrkekkakbn</td><td>支払結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrKekkaKbn C_ShrKekkaKbn}</td></tr>
 *  <tr><td>syorikbn</td><td>処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoriKbn C_SyoriKbn}</td></tr>
 *  <tr><td>syushrgkkei</td><td>主たる支払額小計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tyakkinymd</td><td>着金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoruiukeymd</td><td>書類受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hubikanryouymd</td><td>不備完了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kouryokuhasseiymd</td><td>効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>shrtuukasyu</td><td>支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>skno</td><td>請求番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuusyubetu</td><td>請求種別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeikyuuSyubetu C_SeikyuuSyubetu}</td></tr>
 *  <tr><td>ketkekkacd</td><td>決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Ketkekkacd C_Ketkekkacd}</td></tr>
 *  <tr><td>palketsyacd</td><td>ＰＡＬ決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stdrsktkyhkumu</td><td>被保険者代理特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>stdrsktkyhkymd</td><td>被保険者代理特約付加日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yenshrtkhkumu</td><td>円支払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>initsbjiyensitihsytkhukaumu</td><td>初期死亡時円換算最低保証特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>initsbjiyenkasaiteihsygk</td><td>初期死亡時円換算最低保証額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>jyudkaigomeharaitkhukaumu</td><td>重度介護前払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>targettkhkumu</td><td>ターゲット特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>targettkykkykhenkoymd</td><td>ターゲット特約契約変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>targettkmokuhyouti</td><td>ターゲット特約目標値</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>targettkykkijyungk</td><td>ターゲット特約基準金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kykdrtkykhukaumu</td><td>契約者代理特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kykdrtkykhukaymd</td><td>契約者代理特約付加日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykdrtkykkaiyakuymd</td><td>契約者代理特約解約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>teikishrtkykhukaumu</td><td>定期支払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>siinkbn</td><td>死因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SiinKbn C_SiinKbn}</td></tr>
 *  <tr><td>sitihsyutkyumaeyenhknkngk</td><td>最低保証適用前円換算保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>jkipjytym</td><td>次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>zennoukaisiymd</td><td>前納開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennoukikan</td><td>前納期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     SV_IdouMeisai
 * @see     GenSV_IdouMeisai
 * @see     QSV_IdouMeisai
 * @see     GenQSV_IdouMeisai
 */
public class PKSV_IdouMeisai extends AbstractExDBPrimaryKey<SV_IdouMeisai, PKSV_IdouMeisai> {

    private static final long serialVersionUID = 1L;

    public PKSV_IdouMeisai() {
    }

    public PKSV_IdouMeisai(
        String pSyono,
        String pGyoumuKousinKinou,
        String pGyoumuKousinTime
    ) {
        syono = pSyono;
        gyoumuKousinKinou = pGyoumuKousinKinou;
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    @Transient
    @Override
    public Class<SV_IdouMeisai> getEntityClass() {
        return SV_IdouMeisai.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String gyoumuKousinKinou;

    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }
    private String gyoumuKousinTime;

    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

}