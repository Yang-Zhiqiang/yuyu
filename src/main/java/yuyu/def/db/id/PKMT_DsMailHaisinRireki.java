package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import yuyu.def.db.mapping.GenMT_DsMailHaisinRireki;
import yuyu.def.db.meta.GenQMT_DsMailHaisinRireki;
import yuyu.def.db.meta.QMT_DsMailHaisinRireki;

/**
 * ＤＳメール配信履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsMailHaisinRireki}</td><td colspan="3">ＤＳメール配信履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsmailhaisinrenban dsmailhaisinrenban}</td><td>ＤＳメール配信連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>haisinjidsmailaddress</td><td>配信時ＤＳメールアドレス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dssousinno</td><td>ＤＳ送信番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dssousinmailsyubetukbn</td><td>ＤＳ送信メール種別区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsSousinMailSyubetuKbn C_DsSousinMailSyubetuKbn}</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsMailHaisinRireki
 * @see     GenMT_DsMailHaisinRireki
 * @see     QMT_DsMailHaisinRireki
 * @see     GenQMT_DsMailHaisinRireki
 */
public class PKMT_DsMailHaisinRireki extends AbstractExDBPrimaryKey<MT_DsMailHaisinRireki, PKMT_DsMailHaisinRireki> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsMailHaisinRireki() {
    }

    public PKMT_DsMailHaisinRireki(
        BizDate pDsdatasakuseiymd,
        String pDskokno,
        Integer pDsmailhaisinrenban
    ) {
        dsdatasakuseiymd = pDsdatasakuseiymd;
        dskokno = pDskokno;
        dsmailhaisinrenban = pDsmailhaisinrenban;
    }

    @Transient
    @Override
    public Class<MT_DsMailHaisinRireki> getEntityClass() {
        return MT_DsMailHaisinRireki.class;
    }

    private BizDate dsdatasakuseiymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getDsdatasakuseiymd() {
        return dsdatasakuseiymd;
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        dsdatasakuseiymd = pDsdatasakuseiymd;
    }
    private String dskokno;

    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }
    private Integer dsmailhaisinrenban;

    public Integer getDsmailhaisinrenban() {
        return dsmailhaisinrenban;
    }

    public void setDsmailhaisinrenban(Integer pDsmailhaisinrenban) {
        dsmailhaisinrenban = pDsmailhaisinrenban;
    }

}