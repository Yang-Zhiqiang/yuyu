package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.db.entity.MT_DsHanyouKokTuutiError;
import yuyu.def.db.mapping.GenMT_DsHanyouKokTuutiError;
import yuyu.def.db.meta.GenQMT_DsHanyouKokTuutiError;
import yuyu.def.db.meta.QMT_DsHanyouKokTuutiError;

/**
 * ＤＳ汎用顧客宛通知エラーテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsHanyouKokTuutiError}</td><td colspan="3">ＤＳ汎用顧客宛通知エラーテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskoktuutirenno dskoktuutirenno}</td><td>ＤＳ顧客通知連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDshanyoukokyakuatetuutikbn dshanyoukokyakuatetuutikbn}</td><td>ＤＳ汎用顧客宛通知区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_DsHanyouKokyakuateTuutiKbn}</td></tr>
 *  <tr><td>dshagakisouhujyoukyoukbn</td><td>ＤＳハガキ送付状況区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsHagakiSouhuJyoukyouKbn C_DsHagakiSouhuJyoukyouKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsHanyouKokTuutiError
 * @see     GenMT_DsHanyouKokTuutiError
 * @see     QMT_DsHanyouKokTuutiError
 * @see     GenQMT_DsHanyouKokTuutiError
 */
public class PKMT_DsHanyouKokTuutiError extends AbstractExDBPrimaryKey<MT_DsHanyouKokTuutiError, PKMT_DsHanyouKokTuutiError> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsHanyouKokTuutiError() {
    }

    public PKMT_DsHanyouKokTuutiError(
        BizDate pDsdatasakuseiymd,
        String pDskoktuutirenno,
        String pDskokno,
        C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn
    ) {
        dsdatasakuseiymd = pDsdatasakuseiymd;
        dskoktuutirenno = pDskoktuutirenno;
        dskokno = pDskokno;
        dshanyoukokyakuatetuutikbn = pDshanyoukokyakuatetuutikbn;
    }

    @Transient
    @Override
    public Class<MT_DsHanyouKokTuutiError> getEntityClass() {
        return MT_DsHanyouKokTuutiError.class;
    }

    private BizDate dsdatasakuseiymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getDsdatasakuseiymd() {
        return dsdatasakuseiymd;
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        dsdatasakuseiymd = pDsdatasakuseiymd;
    }
    private String dskoktuutirenno;

    public String getDskoktuutirenno() {
        return dskoktuutirenno;
    }

    public void setDskoktuutirenno(String pDskoktuutirenno) {
        dskoktuutirenno = pDskoktuutirenno;
    }
    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }
    private C_DsHanyouKokyakuateTuutiKbn dshanyoukokyakuatetuutikbn;

    @org.hibernate.annotations.Type(type="UserType_C_DsHanyouKokyakuateTuutiKbn")
    public C_DsHanyouKokyakuateTuutiKbn getDshanyoukokyakuatetuutikbn() {
        return dshanyoukokyakuatetuutikbn;
    }

    public void setDshanyoukokyakuatetuutikbn(C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn) {
        dshanyoukokyakuatetuutikbn = pDshanyoukokyakuatetuutikbn;
    }

}