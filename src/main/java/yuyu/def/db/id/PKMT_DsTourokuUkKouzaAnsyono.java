package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.db.entity.MT_DsTourokuUkKouzaAnsyono;
import yuyu.def.db.mapping.GenMT_DsTourokuUkKouzaAnsyono;
import yuyu.def.db.meta.GenQMT_DsTourokuUkKouzaAnsyono;
import yuyu.def.db.meta.QMT_DsTourokuUkKouzaAnsyono;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ登録受付（口座暗証番号）テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsTourokuUkKouzaAnsyono}</td><td colspan="3">ＤＳ登録受付（口座暗証番号）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDsttdksyubetukbn dsttdksyubetukbn}</td><td>ＤＳ手続種別区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_DsTtdksyubetuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDatarenno datarenno}</td><td>データ連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kzsyuruikbn</td><td>口座種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KouzasyuruiKbn C_KouzasyuruiKbn}</td></tr>
 *  <tr><td>soukinkzyennrkumu</td><td>送金用口座（円貨）入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>tokuteitrhkansyononrkumu</td><td>特定取引用暗証番号入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>dstrhkserviceknykeironrumu</td><td>ＤＳ取引サービス加入経路入力有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzdoukbn</td><td>口座名義人同一区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kzdou C_Kzdou}</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tokuteitrhkansyono</td><td>特定取引用暗証番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>trksriyuukbn</td><td>取消理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TrksriyuuKbn C_TrksriyuuKbn}</td></tr>
 *  <tr><td>dstrhkservicekanyukeirokbn</td><td>ＤＳ取引サービス加入経路区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_DsTrhkserviceKanyukeiroKbn C_DsTrhkserviceKanyukeiroKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsTourokuUkKouzaAnsyono
 * @see     GenMT_DsTourokuUkKouzaAnsyono
 * @see     QMT_DsTourokuUkKouzaAnsyono
 * @see     GenQMT_DsTourokuUkKouzaAnsyono
 */
public class PKMT_DsTourokuUkKouzaAnsyono extends AbstractExDBPrimaryKey<MT_DsTourokuUkKouzaAnsyono, PKMT_DsTourokuUkKouzaAnsyono> {

    private static final long serialVersionUID = 1L;

    public PKMT_DsTourokuUkKouzaAnsyono() {
    }

    public PKMT_DsTourokuUkKouzaAnsyono(
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
    public Class<MT_DsTourokuUkKouzaAnsyono> getEntityClass() {
        return MT_DsTourokuUkKouzaAnsyono.class;
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