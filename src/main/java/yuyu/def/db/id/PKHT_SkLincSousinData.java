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
import yuyu.def.db.entity.HT_SkLincSousinData;
import yuyu.def.db.mapping.GenHT_SkLincSousinData;
import yuyu.def.db.meta.GenQHT_SkLincSousinData;
import yuyu.def.db.meta.QHT_SkLincSousinData;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約ＬＩＮＣ送信データテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkLincSousinData}</td><td colspan="3">新契約ＬＩＮＣ送信データテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lincsousinkbn</td><td>ＬＩＮＣ送信区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SousinKbn C_SousinKbn}</td></tr>
 *  <tr><td>lincrecordsyubetu</td><td>ＬＩＮＣ＿レコード種別</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linchenkoutype</td><td>ＬＩＮＣ＿変更タイプ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckanyuusyano</td><td>ＬＩＮＣ＿加入者番号</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
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
 *  <tr><td>linctrkmousideymd</td><td>ＬＩＮＣ＿登録申出年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>linckykytymd</td><td>ＬＩＮＣ＿契約予定年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>linckykymd</td><td>ＬＩＮＣ＿契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>linchozenytymd</td><td>ＬＩＮＣ＿保全予定年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>linchozenymd</td><td>ＬＩＮＣ＿保全年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lincsgnyukyhng</td><td>ＬＩＮＣ＿災害入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsipnyukyhng</td><td>ＬＩＮＣ＿疾病入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsjnyukyhng</td><td>ＬＩＮＣ＿成人病入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsonotanyukyhng</td><td>ＬＩＮＣ＿その他入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>linchutuusbs</td><td>ＬＩＮＣ＿普通死亡保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsgsbksns</td><td>ＬＩＮＣ＿災害死亡時加算保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>linckakusyasiyouran</td><td>ＬＩＮＣ＿各社使用欄</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lincmousideflg</td><td>ＬＩＮＣ＿申出フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincmousideflgsetymd</td><td>ＬＩＮＣ＿申出フラグ設定年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lincmousideflgkaijyoymd</td><td>ＬＩＮＣ＿申出フラグ解除年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>lincjgyhknflg</td><td>ＬＩＮＣ＿事業保険フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linctenkanflg</td><td>ＬＩＮＣ＿転換フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkLincSousinData
 * @see     GenHT_SkLincSousinData
 * @see     QHT_SkLincSousinData
 * @see     GenQHT_SkLincSousinData
 */
public class PKHT_SkLincSousinData extends AbstractExDBPrimaryKey<HT_SkLincSousinData, PKHT_SkLincSousinData> {

    private static final long serialVersionUID = 1L;

    public PKHT_SkLincSousinData() {
    }

    public PKHT_SkLincSousinData(
        String pMosno,
        BizDate pSyoriYmd,
        Integer pRenno
    ) {
        mosno = pMosno;
        syoriYmd = pSyoriYmd;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_SkLincSousinData> getEntityClass() {
        return HT_SkLincSousinData.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}