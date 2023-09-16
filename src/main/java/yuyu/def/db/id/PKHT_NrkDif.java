package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_NrkDif;
import yuyu.def.db.mapping.GenHT_NrkDif;
import yuyu.def.db.meta.GenQHT_NrkDif;
import yuyu.def.db.meta.QHT_NrkDif;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 入力差異テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_NrkDif}</td><td colspan="3">入力差異テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getVrfkinouid vrfkinouid}</td><td>ベリファイ機能ID</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nrksouikm</td><td>入力相違項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>itijinyuuroku</td><td>１次入力</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nijinyrk</td><td>２次入力</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_NrkDif
 * @see     GenHT_NrkDif
 * @see     QHT_NrkDif
 * @see     GenQHT_NrkDif
 */
public class PKHT_NrkDif extends AbstractExDBPrimaryKey<HT_NrkDif, PKHT_NrkDif> {

    private static final long serialVersionUID = 1L;

    public PKHT_NrkDif() {
    }

    public PKHT_NrkDif(
        String pMosno,
        String pVrfkinouid,
        Integer pRenno3keta
    ) {
        mosno = pMosno;
        vrfkinouid = pVrfkinouid;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<HT_NrkDif> getEntityClass() {
        return HT_NrkDif.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private String vrfkinouid;

    public String getVrfkinouid() {
        return vrfkinouid;
    }

    public void setVrfkinouid(String pVrfkinouid) {
        vrfkinouid = pVrfkinouid;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}