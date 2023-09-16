package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.MW_DsMailHaisinRirekiWk;
import yuyu.def.db.mapping.GenMW_DsMailHaisinRirekiWk;
import yuyu.def.db.meta.GenQMW_DsMailHaisinRirekiWk;
import yuyu.def.db.meta.QMW_DsMailHaisinRirekiWk;

/**
 * ＤＳメール配信履歴ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MW_DsMailHaisinRirekiWk}</td><td colspan="3">ＤＳメール配信履歴ワークテーブル</td></tr>
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
 * @see     MW_DsMailHaisinRirekiWk
 * @see     GenMW_DsMailHaisinRirekiWk
 * @see     QMW_DsMailHaisinRirekiWk
 * @see     GenQMW_DsMailHaisinRirekiWk
 */
public class PKMW_DsMailHaisinRirekiWk extends AbstractExDBPrimaryKey<MW_DsMailHaisinRirekiWk, PKMW_DsMailHaisinRirekiWk> {

    private static final long serialVersionUID = 1L;

    public PKMW_DsMailHaisinRirekiWk() {
    }

    public PKMW_DsMailHaisinRirekiWk(
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
    public Class<MW_DsMailHaisinRirekiWk> getEntityClass() {
        return MW_DsMailHaisinRirekiWk.class;
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