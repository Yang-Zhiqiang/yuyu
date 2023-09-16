package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.mapping.GenJT_SiKykKihon;
import yuyu.def.db.meta.GenQJT_SiKykKihon;
import yuyu.def.db.meta.QJT_SiKykKihon;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払契約基本テーブル（物理テーブルなし） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiKykKihon}</td><td colspan="3">支払契約基本テーブル（物理テーブルなし）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aitesyono</td><td>相手証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkaisuu</td><td>払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>sntkhoukbn</td><td>選択方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SntkhouKbn C_SntkhouKbn}</td></tr>
 *  <tr><td>mosymd</td><td>申込日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kktymd</td><td>告知日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>yuukousyoumetukbn</td><td>有効消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YuukousyoumetuKbn C_YuukousyoumetuKbn}</td></tr>
 *  <tr><td>kykjyoutai</td><td>契約状態</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kykjyoutai C_Kykjyoutai}</td></tr>
 *  <tr><td>nexthrkym</td><td>次回払込年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>yykknmnryymd</td><td>猶予期間満了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>keip</td><td>合計保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sykyknyhenkouymd</td><td>最終契約内容変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lasthkhenkouymd</td><td>最終払方変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoumetujiyuu</td><td>消滅事由</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syoumetujiyuu C_Syoumetujiyuu}</td></tr>
 *  <tr><td>syoumetuymd</td><td>消滅日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hrketykouryokuhasseiymd</td><td>払済延長効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>stknsetkbn</td><td>質権設定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_StknsetKbn C_StknsetKbn}</td></tr>
 *  <tr><td>aplkahikbn</td><td>ＡＰＬ可否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Aplkahi C_Aplkahi}</td></tr>
 *  <tr><td>sbuktnin</td><td>死亡受取人人数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>saihoum</td><td>再保有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Saihoum C_Saihoum}</td></tr>
 *  <tr><td>hksknnkaisiymd</td><td>復活責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gnkykfksknnkaisiymd</td><td>原契約復旧責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>jidouupdatekahi</td><td>自動更新可否</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>jidouupdategop</td><td>自動更新後保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>livingneedshukaumu</td><td>リビングニーズ特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nstkhkumu</td><td>年金支払特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>nkshrtkyknksyukbn</td><td>年金支払特約年金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nstknsyu C_Nstknsyu}</td></tr>
 *  <tr><td>nkshrtkyknksyukkn</td><td>年金支払特約年金期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhkntodouhukencd</td><td>被保険者都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tratkityuiumu</td><td>取扱注意有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tratkityuiuny</td><td>取扱注意内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyksei</td><td>契約者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kyksei C_Kyksei}</td></tr>
 *  <tr><td>kykseiymd</td><td>契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykyno</td><td>契約者郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kkkyktdk</td><td>契約管理契約者続柄</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>kykhnkkaisuu</td><td>契約者変更回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kn</td><td>通信先住所１（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kn</td><td>通信先住所２（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kn</td><td>通信先住所３（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsintelno</td><td>通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkn</td><td>被保険者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknyno</td><td>被保険者郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknadr1kn</td><td>被保険者住所１（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknadr2kn</td><td>被保険者住所２（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknadr3kn</td><td>被保険者住所３（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknadr1kj</td><td>被保険者住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknadr2kj</td><td>被保険者住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknadr3kj</td><td>被保険者住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhkntelno</td><td>被保険者電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>stdrsktkyhkumu</td><td>被保険者代理特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>siteidruktnmkn</td><td>指定代理受取人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siteidruktnmkj</td><td>指定代理受取人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>siteidrukttdk</td><td>指定代理受取人続柄</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tdk C_Tdk}</td></tr>
 *  <tr><td>kykdrtkykhukaumu</td><td>契約者代理特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kykdrknhatudoujyoutai</td><td>契約者代理権発動状態</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykdrknHtdjytKbn C_KykdrknHtdjytKbn}</td></tr>
 *  <tr><td>kykdairinmkj</td><td>契約者代理人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdairinmkn</td><td>契約者代理人名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdrnmkjkhukakbn</td><td>契約者代理人名漢字化不可区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KjkhukaKbn C_KjkhukaKbn}</td></tr>
 *  <tr><td>kykdryno</td><td>契約者代理人郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdradr1kj</td><td>契約者代理人住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdradr2kj</td><td>契約者代理人住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdradr3kj</td><td>契約者代理人住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykdrseiymd</td><td>契約者代理人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykdrtelno</td><td>契約者代理人電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrhousiteikbn</td><td>支払方法指定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrhousiteiKbn C_ShrhousiteiKbn}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtencd</td><td>代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenkanrisosikicd</td><td>代理店管理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuucd</td><td>募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>misyuup</td><td>未収保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>misyuupjyuutouym</td><td>未収保険料充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>misyuupjytkaisuu</td><td>未収保険料充当回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>mikeikap</td><td>未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>mikeikapjyuutouym</td><td>未経過保険料充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>mikeikapjytkaisuu</td><td>未経過保険料充当回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>htykeihi</td><td>必要経費</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenhtykeihi</td><td>円換算必要経費</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>shrkykhtykeihi</td><td>支払時契約者必要経費</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>krkgk</td><td>仮受金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lastsyosaihkymd</td><td>最終証券再発行日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lastmeihenymd</td><td>最終名義変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lastsbukthenymd</td><td>最終死亡受取人変更日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ttdktyuuikbn1</td><td>手続注意区分１</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbn2</td><td>手続注意区分２</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbn3</td><td>手続注意区分３</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbn4</td><td>手続注意区分４</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>ttdktyuuikbn5</td><td>手続注意区分５</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TtdktyuuiKbn C_TtdktyuuiKbn}</td></tr>
 *  <tr><td>initsbjiyensitihsytkhukaumu</td><td>初期死亡時円換算最低保証特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>initsbjiyenkasaiteihsygk</td><td>初期死亡時円換算最低保証額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>fstpnyknymd</td><td>初回保険料入金日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zennouryosyuymd</td><td>前納領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sdpdkbn</td><td>Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sdpd C_Sdpd}</td></tr>
 *  <tr><td>tikiktbrisyuruikbn</td><td>定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TkiktbrisyuruiKbn C_TkiktbrisyuruiKbn}</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiKykKihon
 * @see     GenJT_SiKykKihon
 * @see     QJT_SiKykKihon
 * @see     GenQJT_SiKykKihon
 */
public class PKJT_SiKykKihon extends AbstractExDBPrimaryKey<JT_SiKykKihon, PKJT_SiKykKihon> {

    private static final long serialVersionUID = 1L;

    public PKJT_SiKykKihon() {
    }

    public PKJT_SiKykKihon(String pSyono) {
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<JT_SiKykKihon> getEntityClass() {
        return JT_SiKykKihon.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}