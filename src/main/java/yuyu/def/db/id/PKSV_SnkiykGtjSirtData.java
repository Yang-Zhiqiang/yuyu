package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.SV_SnkiykGtjSirtData;
import yuyu.def.db.mapping.GenSV_SnkiykGtjSirtData;
import yuyu.def.db.meta.GenQSV_SnkiykGtjSirtData;
import yuyu.def.db.meta.QSV_SnkiykGtjSirtData;

/**
 * 新契約決算ベース月次成立情報ビュー のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link SV_SnkiykGtjSirtData}</td><td colspan="3">新契約決算ベース月次成立情報ビュー</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno8keta renno8keta}</td><td>連番（８桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>mosno</td><td>申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mosnrkymd</td><td>申込書入力日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seiritukbn</td><td>成立区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SeirituKbn C_SeirituKbn}</td></tr>
 *  <tr><td>srsyoriymd</td><td>成立処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mosymd</td><td>申込日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mossakuseiymd</td><td>申込書作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mosym</td><td>申込月度</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>kktymd</td><td>告知日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>skykymd</td><td>指定契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sknnkaisiymd</td><td>責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seisekiym</td><td>成績計上年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>skeikeijyouym</td><td>新契約計上年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>kykkbn</td><td>契約者区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykKbn C_KykKbn}</td></tr>
 *  <tr><td>stdrsktkyhkumu</td><td>指定代理請求特約付加有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>sdpdkbn</td><td>Ｓ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Sdpd C_Sdpd}</td></tr>
 *  <tr><td>sntkhoukbn</td><td>選択方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SntkhouKbn C_SntkhouKbn}</td></tr>
 *  <tr><td>haitoukbn</td><td>配当区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitouKbn C_HaitouKbn}</td></tr>
 *  <tr><td>haitoukinuketorihoukbn</td><td>配当金受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HaitoukinuketorihouKbn C_HaitoukinuketorihouKbn}</td></tr>
 *  <tr><td>fstphrkgk</td><td>初回Ｐ払込必要額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hhknnmkn</td><td>被保険者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknseiymd</td><td>被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknnen</td><td>被保険者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hhknsei</td><td>被保険者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hhknsei C_Hhknsei}</td></tr>
 *  <tr><td>hhknsykgycd</td><td>被保険者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykseiymd</td><td>契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyknen</td><td>契約者年齢</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kyksei</td><td>契約者性別</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kyksei C_Kyksei}</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nstksbnsyu</td><td>年金支払特約死亡年金種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Nstknsyu C_Nstknsyu}</td></tr>
 *  <tr><td>nstksbnkkn</td><td>年金支払特約死亡年金期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kykhonninkakninsyoruikbn</td><td>契約者本人確認書類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HonninkakuninSyoruiKbn C_HonninkakuninSyoruiKbn}</td></tr>
 *  <tr><td>syouhncd</td><td>商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ryouritusdno</td><td>料率世代番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syutkkbn</td><td>主契約特約区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyutkKbn C_SyutkKbn}</td></tr>
 *  <tr><td>yoteiriritu</td><td>予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>seitoukihons</td><td>正当基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syutkp</td><td>主契約・特約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hknkkn</td><td>保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hknkknsmnkbn</td><td>保険期間歳満期区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HknkknsmnKbn C_HknkknsmnKbn}</td></tr>
 *  <tr><td>mosdairitentblrenno</td><td>申込代理店テーブル連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>cifcd</td><td>ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtencd</td><td>代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuucd</td><td>募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>daibosyuucd</td><td>代表募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtenkanrisosikicd</td><td>代理店管理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykKaktblrenno</td><td>契約確認テーブル連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kykkaksyrui</td><td>契約確認種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kykkaksyrui C_Kykkaksyrui}</td></tr>
 *  <tr><td>nyuukintblrenno</td><td>入金テーブル連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ryosyuymd</td><td>領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>spgndtknkbn</td><td>ＳＰ限度特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SpgndtknKbn C_SpgndtknKbn}</td></tr>
 *  <tr><td>nenkkntknkbn</td><td>年齢期間特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NenkkntknKbn C_NenkkntknKbn}</td></tr>
 *  <tr><td>tsngndtknkbn</td><td>通算限度特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TsngndtknKbn C_TsngndtknKbn}</td></tr>
 *  <tr><td>sentakuinfotknkbn</td><td>選択情報特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SentakuinfotknKbn C_SentakuinfotknKbn}</td></tr>
 *  <tr><td>kakoymdkyytknkbn</td><td>過去日付許容特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KakoymdkyytknKbn C_KakoymdkyytknKbn}</td></tr>
 *  <tr><td>saiteiptknkbn</td><td>最低P特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SaiteiptknKbn C_SaiteiptknKbn}</td></tr>
 *  <tr><td>signalkaihikbn</td><td>シグナル回避区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SignalkaihiKbn C_SignalkaihiKbn}</td></tr>
 *  <tr><td>sonotatknkbn</td><td>その他特認区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SonotaTokuninKbn C_SonotaTokuninKbn}</td></tr>
 *  <tr><td>drtenkanritodoufukencd</td><td>代理店管理都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktsyukbn</td><td>受取人種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktsyuKbn C_UktsyuKbn}</td></tr>
 *  <tr><td>uktsyurenno</td><td>受取人種類別連番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>uktkbn</td><td>受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UktKbn C_UktKbn}</td></tr>
 *  <tr><td>seg1cd</td><td>セグメント１コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Segcd C_Segcd}</td></tr>
 * </table>
 * @see     SV_SnkiykGtjSirtData
 * @see     GenSV_SnkiykGtjSirtData
 * @see     QSV_SnkiykGtjSirtData
 * @see     GenQSV_SnkiykGtjSirtData
 */
public class PKSV_SnkiykGtjSirtData extends AbstractExDBPrimaryKey<SV_SnkiykGtjSirtData, PKSV_SnkiykGtjSirtData> {

    private static final long serialVersionUID = 1L;

    public PKSV_SnkiykGtjSirtData() {
    }

    public PKSV_SnkiykGtjSirtData(Integer pRenno8keta) {
        renno8keta = pRenno8keta;
    }

    @Transient
    @Override
    public Class<SV_SnkiykGtjSirtData> getEntityClass() {
        return SV_SnkiykGtjSirtData.class;
    }

    private Integer renno8keta;

    public Integer getRenno8keta() {
        return renno8keta;
    }

    public void setRenno8keta(Integer pRenno8keta) {
        renno8keta = pRenno8keta;
    }

}