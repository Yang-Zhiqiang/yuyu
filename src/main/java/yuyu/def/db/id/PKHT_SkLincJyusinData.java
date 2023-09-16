package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HT_SkLincJyusinData;
import yuyu.def.db.mapping.GenHT_SkLincJyusinData;
import yuyu.def.db.meta.GenQHT_SkLincJyusinData;
import yuyu.def.db.meta.QHT_SkLincJyusinData;

/**
 * 新契約ＬＩＮＣ受信データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkLincJyusinData}</td><td colspan="3">新契約ＬＩＮＣ受信データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getLinckyknaiykekdatarenno linckyknaiykekdatarenno}</td><td>ＬＩＮＣ契約内容結果データ連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckyknaiykekdatarennooya</td><td>ＬＩＮＣ契約内容結果データ連番（親）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lincsousinymd</td><td>ＬＩＮＣ＿送信日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lincdatasyubetu</td><td>ＬＩＮＣ＿データ種別</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lincsoujyusinsyskbn</td><td>ＬＩＮＣ送受信用システム区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_LincsoujyusinsysKbn C_LincsoujyusinsysKbn}</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rendoumosnochknasi</td><td>連動用申込番号（チェックなし）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lincrecordsyubetu</td><td>ＬＩＮＣ＿レコード種別</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linchenkoutype</td><td>ＬＩＮＣ＿変更タイプ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lincsyorikekkakekkacd</td><td>ＬＩＮＣ＿処理結果_結果コード</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincsyorikekkakekkajiyu</td><td>ＬＩＮＣ＿処理結果_結果事由</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincsyorikekkaerrkouban</td><td>ＬＩＮＣ＿処理結果_エラー項番</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincnayoserecordsuu</td><td>ＬＩＮＣ＿名寄せレコード数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linckanyuusyano</td><td>ＬＩＮＣ＿加入者番号</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>lincnayoseyomiknnm</td><td>ＬＩＮＣ＿名寄せ読みカナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linchhknnmkn</td><td>ＬＩＮＣ＿被保険者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linchhknnmkj</td><td>ＬＩＮＣ＿被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linchhknsei</td><td>ＬＩＮＣ＿被保険者性別</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linchhknseiymd</td><td>ＬＩＮＣ＿被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>linchhknadrkn</td><td>ＬＩＮＣ＿被保険者住所（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckeihidjnhyouji</td><td>ＬＩＮＣ＿契被同人表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KykKbn C_KykKbn}</td></tr>
 *  <tr><td>linckyknmkn</td><td>ＬＩＮＣ＿契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckyknmkj</td><td>ＬＩＮＣ＿契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckyksei</td><td>ＬＩＮＣ＿契約者性別</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linckykseiymd</td><td>ＬＩＮＣ＿契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>linckykadrkn</td><td>ＬＩＮＣ＿契約者住所（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckjhngflg</td><td>ＬＩＮＣ＿漢字範囲外フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linctrkmousideymd</td><td>ＬＩＮＣ＿登録申出年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>linckykytymd</td><td>ＬＩＮＣ＿契約予定年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>linckykymd</td><td>ＬＩＮＣ＿契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>linchozenytymd</td><td>ＬＩＮＣ＿保全予定年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>linchozenymd</td><td>ＬＩＮＣ＿保全年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lincsousinmotokaisya</td><td>ＬＩＮＣ＿送信元会社</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lincsgnyukyhng</td><td>ＬＩＮＣ＿災害入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsipnyukyhng</td><td>ＬＩＮＣ＿疾病入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsjnyukyhng</td><td>ＬＩＮＣ＿成人病入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsonotanyukyhng</td><td>ＬＩＮＣ＿その他入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>linchutuusbs</td><td>ＬＩＮＣ＿普通死亡保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsgsbksns</td><td>ＬＩＮＣ＿災害死亡時加算保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>linc15sai1000manflg</td><td>ＬＩＮＣ＿１５歳未満１０００万超フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linclincsyoriymd</td><td>ＬＩＮＣ＿ＬＩＮＣ処理日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>linckykkanrino</td><td>ＬＩＮＣ＿契約管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckakusyasiyouran</td><td>ＬＩＮＣ＿各社使用欄</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lincmousideflg</td><td>ＬＩＮＣ＿申出フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincmousideflgsetymd</td><td>ＬＩＮＣ＿申出フラグ設定年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lincmousideflgkaijyoymd</td><td>ＬＩＮＣ＿申出フラグ解除年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lincjgyhknflg</td><td>ＬＩＮＣ＿事業保険フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linctenkanflg</td><td>ＬＩＮＣ＿転換フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkLincJyusinData
 * @see     GenHT_SkLincJyusinData
 * @see     QHT_SkLincJyusinData
 * @see     GenQHT_SkLincJyusinData
 */
public class PKHT_SkLincJyusinData extends AbstractExDBPrimaryKey<HT_SkLincJyusinData, PKHT_SkLincJyusinData> {

    private static final long serialVersionUID = 1L;

    public PKHT_SkLincJyusinData() {
    }

    public PKHT_SkLincJyusinData(BizDate pSyoriYmd, String pLinckyknaiykekdatarenno) {
        syoriYmd = pSyoriYmd;
        linckyknaiykekdatarenno = pLinckyknaiykekdatarenno;
    }

    @Transient
    @Override
    public Class<HT_SkLincJyusinData> getEntityClass() {
        return HT_SkLincJyusinData.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String linckyknaiykekdatarenno;

    public String getLinckyknaiykekdatarenno() {
        return linckyknaiykekdatarenno;
    }

    public void setLinckyknaiykekdatarenno(String pLinckyknaiykekdatarenno) {
        linckyknaiykekdatarenno = pLinckyknaiykekdatarenno;
    }

}