package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.db.entity.MT_DsTourokuUkKanri;
import yuyu.def.db.mapping.GenMT_DsTourokuUkKanri;
import yuyu.def.db.meta.GenQMT_DsTourokuUkKanri;
import yuyu.def.db.meta.QMT_DsTourokuUkKanri;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ登録受付管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsTourokuUkKanri}</td><td colspan="3">ＤＳ登録受付管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsttdksyubetukbn dsttdksyubetukbn}</td><td>ＤＳ手続種別区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_DsTtdksyubetuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDatarenno datarenno}</td><td>データ連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dskokno</td><td>ＤＳ顧客番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mosno</td><td>申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tourokustatus</td><td>登録ステータス</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TourokustatusKbn C_TourokustatusKbn}</td></tr>
 *  <tr><td>dsjimukaisiymd</td><td>ＤＳ事務開始日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dsjimukanryouymd</td><td>ＤＳ事務完了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dstourokukanryouymd</td><td>ＤＳ登録完了日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsTourokuUkKanri
 * @see     GenMT_DsTourokuUkKanri
 * @see     QMT_DsTourokuUkKanri
 * @see     GenQMT_DsTourokuUkKanri
 */
public class PKMT_DsTourokuUkKanri extends AbstractExDBPrimaryKey<MT_DsTourokuUkKanri, PKMT_DsTourokuUkKanri> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsTourokuUkKanri() {
    }

    public PKMT_DsTourokuUkKanri(
        String pSyono,
        C_DsTtdksyubetuKbn pDsttdksyubetukbn,
        Integer pDatarenno
    ) {
        syono = pSyono;
        dsttdksyubetukbn = pDsttdksyubetukbn;
        datarenno = pDatarenno;
    }

    @Transient
    @Override
    public Class<MT_DsTourokuUkKanri> getEntityClass() {
        return MT_DsTourokuUkKanri.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private C_DsTtdksyubetuKbn dsttdksyubetukbn;

    @org.hibernate.annotations.Type(type="UserType_C_DsTtdksyubetuKbn")
    public C_DsTtdksyubetuKbn getDsttdksyubetukbn() {
        return dsttdksyubetukbn;
    }

    public void setDsttdksyubetukbn(C_DsTtdksyubetuKbn pDsttdksyubetukbn) {
        dsttdksyubetukbn = pDsttdksyubetukbn;
    }
    private Integer datarenno;

    public Integer getDatarenno() {
        return datarenno;
    }

    public void setDatarenno(Integer pDatarenno) {
        datarenno = pDatarenno;
    }

}