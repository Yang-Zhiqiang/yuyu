package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_KmTsRireki;
import yuyu.def.db.mapping.GenHT_KmTsRireki;
import yuyu.def.db.meta.GenQHT_KmTsRireki;
import yuyu.def.db.meta.QHT_KmTsRireki;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 項目訂正履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_KmTsRireki}</td><td colspan="3">項目訂正履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriTime syoriTime}</td><td>処理時間</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kinouId</td><td>機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kinouModeId</td><td>機能モードＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tskmnm</td><td>訂正項目名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsmaenaiyou</td><td>訂正前内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsgonaiyou</td><td>訂正後内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tantid</td><td>担当者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_KmTsRireki
 * @see     GenHT_KmTsRireki
 * @see     QHT_KmTsRireki
 * @see     GenQHT_KmTsRireki
 */
public class PKHT_KmTsRireki extends AbstractExDBPrimaryKey<HT_KmTsRireki, PKHT_KmTsRireki> {

    private static final long serialVersionUID = 1L;

    public PKHT_KmTsRireki() {
    }

    public PKHT_KmTsRireki(
        String pMosno,
        String pSyoriTime,
        Integer pRenno3keta
    ) {
        mosno = pMosno;
        syoriTime = pSyoriTime;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<HT_KmTsRireki> getEntityClass() {
        return HT_KmTsRireki.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private String syoriTime;

    public String getSyoriTime() {
        return syoriTime;
    }

    public void setSyoriTime(String pSyoriTime) {
        syoriTime = pSyoriTime;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}