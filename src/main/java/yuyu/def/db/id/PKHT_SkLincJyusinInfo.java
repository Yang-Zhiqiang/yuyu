package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.entity.HT_SkLincJyusinInfo;
import yuyu.def.db.mapping.GenHT_SkLincJyusinInfo;
import yuyu.def.db.meta.GenQHT_SkLincJyusinInfo;
import yuyu.def.db.meta.QHT_SkLincJyusinInfo;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約ＬＩＮＣ受信情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkLincJyusinInfo}</td><td colspan="3">新契約ＬＩＮＣ受信情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getLincsoujyusinsyskbn lincsoujyusinsyskbn}</td><td>ＬＩＮＣ送受信用システム区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_LincsoujyusinsysKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getLinckyknaiykekdatarenno linckyknaiykekdatarenno}</td><td>ＬＩＮＣ契約内容結果データ連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno2 renno2}</td><td>連番２</td><td align="center">○</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSousinymd sousinymd}</td><td>送信日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
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
 *  <tr><td>linchhknseiymd</td><td>ＬＩＮＣ＿被保険者生年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linchhknadrkn</td><td>ＬＩＮＣ＿被保険者住所（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckeihidjnhyouji</td><td>ＬＩＮＣ＿契被同人表示</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linckyknmkn</td><td>ＬＩＮＣ＿契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckyknmkj</td><td>ＬＩＮＣ＿契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckyksei</td><td>ＬＩＮＣ＿契約者性別</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linckykseiymd</td><td>ＬＩＮＣ＿契約者生年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linckykadrkn</td><td>ＬＩＮＣ＿契約者住所（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckjhngflg</td><td>ＬＩＮＣ＿漢字範囲外フラッグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linctrkmousideymd</td><td>ＬＩＮＣ＿登録申出年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linckykytymd</td><td>ＬＩＮＣ＿契約予定年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linckykymd</td><td>ＬＩＮＣ＿契約年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linchozenytymd</td><td>ＬＩＮＣ＿保全予定年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linchozenymd</td><td>ＬＩＮＣ＿保全年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincsousinmotokaisya</td><td>ＬＩＮＣ＿送信元会社</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lincsgnyukyhng</td><td>ＬＩＮＣ＿災害入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsipnyukyhng</td><td>ＬＩＮＣ＿疾病入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsjnyukyhng</td><td>ＬＩＮＣ＿成人病入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsonotanyukyhng</td><td>ＬＩＮＣ＿その他入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>linchutuusbs</td><td>ＬＩＮＣ＿普通死亡保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsgsbksns</td><td>ＬＩＮＣ＿災害死亡時加算保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>linc15sai1000manflg</td><td>ＬＩＮＣ＿１５歳未満１０００万超フラッグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linclincsyoriymd</td><td>ＬＩＮＣ＿ＬＩＮＣ処理日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linckykkanrino</td><td>ＬＩＮＣ＿契約管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckakusyasiyouran</td><td>ＬＩＮＣ＿各社使用欄</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lincmousideflg</td><td>ＬＩＮＣ＿申出フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincmousideflgsetymd</td><td>ＬＩＮＣ＿申出フラグ設定年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincmousideflgkaijyoymd</td><td>ＬＩＮＣ＿申出フラグ解除年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincjgyhknflg</td><td>ＬＩＮＣ＿事業保険フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linctenkanflg</td><td>ＬＩＮＣ＿転換フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkLincJyusinInfo
 * @see     GenHT_SkLincJyusinInfo
 * @see     QHT_SkLincJyusinInfo
 * @see     GenQHT_SkLincJyusinInfo
 */
public class PKHT_SkLincJyusinInfo extends AbstractExDBPrimaryKey<HT_SkLincJyusinInfo, PKHT_SkLincJyusinInfo> {

    private static final long serialVersionUID = 1L;

    public PKHT_SkLincJyusinInfo() {
    }

    public PKHT_SkLincJyusinInfo(
        C_LincsoujyusinsysKbn pLincsoujyusinsyskbn,
        String pLinckyknaiykekdatarenno,
        BizDate pSyoriYmd,
        String pMosno,
        BizNumber pRenno2,
        BizDate pSousinymd
    ) {
        lincsoujyusinsyskbn = pLincsoujyusinsyskbn;
        linckyknaiykekdatarenno = pLinckyknaiykekdatarenno;
        syoriYmd = pSyoriYmd;
        mosno = pMosno;
        renno2 = pRenno2;
        sousinymd = pSousinymd;
    }

    @Transient
    @Override
    public Class<HT_SkLincJyusinInfo> getEntityClass() {
        return HT_SkLincJyusinInfo.class;
    }

    private C_LincsoujyusinsysKbn lincsoujyusinsyskbn;

    @org.hibernate.annotations.Type(type="UserType_C_LincsoujyusinsysKbn")
    public C_LincsoujyusinsysKbn getLincsoujyusinsyskbn() {
        return lincsoujyusinsyskbn;
    }

    public void setLincsoujyusinsyskbn(C_LincsoujyusinsysKbn pLincsoujyusinsyskbn) {
        lincsoujyusinsyskbn = pLincsoujyusinsyskbn;
    }
    private String linckyknaiykekdatarenno;

    public String getLinckyknaiykekdatarenno() {
        return linckyknaiykekdatarenno;
    }

    public void setLinckyknaiykekdatarenno(String pLinckyknaiykekdatarenno) {
        linckyknaiykekdatarenno = pLinckyknaiykekdatarenno;
    }
    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private BizNumber renno2;

    @org.hibernate.annotations.Type(type="BizNumberType")
    public BizNumber getRenno2() {
        return renno2;
    }

    public void setRenno2(BizNumber pRenno2) {
        renno2 = pRenno2;
    }
    private BizDate sousinymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSousinymd() {
        return sousinymd;
    }

    public void setSousinymd(BizDate pSousinymd) {
        sousinymd = pSousinymd;
    }

}