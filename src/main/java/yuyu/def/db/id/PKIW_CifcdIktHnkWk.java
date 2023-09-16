package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IW_CifcdIktHnkWk;
import yuyu.def.db.mapping.GenIW_CifcdIktHnkWk;
import yuyu.def.db.meta.GenQIW_CifcdIktHnkWk;
import yuyu.def.db.meta.QIW_CifcdIktHnkWk;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＣＩＦコード一括変更ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_CifcdIktHnkWk}</td><td colspan="3">ＣＩＦコード一括変更ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cifcd</td><td>ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_CifcdIktHnkWk
 * @see     GenIW_CifcdIktHnkWk
 * @see     QIW_CifcdIktHnkWk
 * @see     GenQIW_CifcdIktHnkWk
 */
public class PKIW_CifcdIktHnkWk extends AbstractExDBPrimaryKey<IW_CifcdIktHnkWk, PKIW_CifcdIktHnkWk> {

    private static final long serialVersionUID = 1L;

    public PKIW_CifcdIktHnkWk() {
    }

    public PKIW_CifcdIktHnkWk(String pKbnkey, String pSyono) {
        kbnkey = pKbnkey;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<IW_CifcdIktHnkWk> getEntityClass() {
        return IW_CifcdIktHnkWk.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}