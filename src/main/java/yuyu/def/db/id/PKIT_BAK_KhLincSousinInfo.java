package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.entity.IT_BAK_KhLincSousinInfo;
import yuyu.def.db.mapping.GenIT_BAK_KhLincSousinInfo;
import yuyu.def.db.meta.GenQIT_BAK_KhLincSousinInfo;
import yuyu.def.db.meta.QIT_BAK_KhLincSousinInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全ＬＩＮＣ送信情報バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhLincSousinInfo}</td><td colspan="3">契約保全ＬＩＮＣ送信情報バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getLincsoujyusinsyskbn lincsoujyusinsyskbn}</td><td>ＬＩＮＣ送受信用システム区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_LincsoujyusinsysKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincsousinkbn</td><td>ＬＩＮＣ送信区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SousinKbn C_SousinKbn}</td></tr>
 *  <tr><td>lincrecordsyubetu</td><td>ＬＩＮＣ＿レコード種別</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linchenkoutype</td><td>ＬＩＮＣ＿変更タイプ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>linckanyuusyano</td><td>ＬＩＮＣ＿加入者番号</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
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
 *  <tr><td>linctrkmousideymd</td><td>ＬＩＮＣ＿登録申出年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linckykytymd</td><td>ＬＩＮＣ＿契約予定年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linckykymd</td><td>ＬＩＮＣ＿契約年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linchozenytymd</td><td>ＬＩＮＣ＿保全予定年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincsgnyukyhng</td><td>ＬＩＮＣ＿災害入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>linchozenymd</td><td>ＬＩＮＣ＿保全年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincsipnyukyhng</td><td>ＬＩＮＣ＿疾病入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsjnyukyhng</td><td>ＬＩＮＣ＿成人病入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsonotanyukyhng</td><td>ＬＩＮＣ＿その他入院給付金日額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>linchutuusbs</td><td>ＬＩＮＣ＿普通死亡保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>lincsgsbksns</td><td>ＬＩＮＣ＿災害死亡時加算保険金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>linckakusyasiyouran</td><td>ＬＩＮＣ＿各社使用欄</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lincmousideflg</td><td>ＬＩＮＣ＿申出フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincmousideflgsetymd</td><td>ＬＩＮＣ＿申出フラグ設定年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincmousideflgkaijyoymd</td><td>ＬＩＮＣ＿申出フラグ解除年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>lincjgyhknflg</td><td>ＬＩＮＣ＿事業保険フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>linctenkanflg</td><td>ＬＩＮＣ＿転換フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KhLincSousinInfo
 * @see     GenIT_BAK_KhLincSousinInfo
 * @see     QIT_BAK_KhLincSousinInfo
 * @see     GenQIT_BAK_KhLincSousinInfo
 */
public class PKIT_BAK_KhLincSousinInfo extends AbstractExDBPrimaryKey<IT_BAK_KhLincSousinInfo, PKIT_BAK_KhLincSousinInfo> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_KhLincSousinInfo() {
    }

    public PKIT_BAK_KhLincSousinInfo(
        String pKbnkey,
        C_LincsoujyusinsysKbn pLincsoujyusinsyskbn,
        String pTrkssikibetukey,
        String pSyono,
        Integer pRenno
    ) {
        kbnkey = pKbnkey;
        lincsoujyusinsyskbn = pLincsoujyusinsyskbn;
        trkssikibetukey = pTrkssikibetukey;
        syono = pSyono;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IT_BAK_KhLincSousinInfo> getEntityClass() {
        return IT_BAK_KhLincSousinInfo.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private C_LincsoujyusinsysKbn lincsoujyusinsyskbn;

    @org.hibernate.annotations.Type(type="UserType_C_LincsoujyusinsysKbn")
    public C_LincsoujyusinsysKbn getLincsoujyusinsyskbn() {
        return lincsoujyusinsyskbn;
    }

    public void setLincsoujyusinsyskbn(C_LincsoujyusinsysKbn pLincsoujyusinsyskbn) {
        lincsoujyusinsyskbn = pLincsoujyusinsyskbn;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}