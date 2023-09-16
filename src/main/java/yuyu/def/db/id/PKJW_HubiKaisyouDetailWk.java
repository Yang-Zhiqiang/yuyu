package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JW_HubiKaisyouDetailWk;
import yuyu.def.db.mapping.GenJW_HubiKaisyouDetailWk;
import yuyu.def.db.meta.GenQJW_HubiKaisyouDetailWk;
import yuyu.def.db.meta.QJW_HubiKaisyouDetailWk;

/**
 * 支払不備解消詳細ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JW_HubiKaisyouDetailWk}</td><td colspan="3">支払不備解消詳細ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>hubikaisyouumukbn</td><td>不備解消有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JW_HubiKaisyouDetailWk
 * @see     GenJW_HubiKaisyouDetailWk
 * @see     QJW_HubiKaisyouDetailWk
 * @see     GenQJW_HubiKaisyouDetailWk
 */
public class PKJW_HubiKaisyouDetailWk extends AbstractExDBPrimaryKey<JW_HubiKaisyouDetailWk, PKJW_HubiKaisyouDetailWk> {

    private static final long serialVersionUID = 1L;

    public PKJW_HubiKaisyouDetailWk() {
    }

    public PKJW_HubiKaisyouDetailWk(String pKouteikanriid, Integer pRenno3keta) {
        kouteikanriid = pKouteikanriid;
        renno3keta = pRenno3keta;
    }

    @Transient
    @Override
    public Class<JW_HubiKaisyouDetailWk> getEntityClass() {
        return JW_HubiKaisyouDetailWk.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }
    private Integer renno3keta;

    public Integer getRenno3keta() {
        return renno3keta;
    }

    public void setRenno3keta(Integer pRenno3keta) {
        renno3keta = pRenno3keta;
    }

}