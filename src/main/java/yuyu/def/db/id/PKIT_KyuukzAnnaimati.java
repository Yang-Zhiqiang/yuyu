package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_KyuukzAnnaimati;
import yuyu.def.db.mapping.GenIT_KyuukzAnnaimati;
import yuyu.def.db.meta.GenQIT_KyuukzAnnaimati;
import yuyu.def.db.meta.QIT_KyuukzAnnaimati;

/**
 * 旧口座案内待ちテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KyuukzAnnaimati}</td><td colspan="3">旧口座案内待ちテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syorizumiflg</td><td>処理済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syorizumiflg C_Syorizumiflg}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KyuukzAnnaimati
 * @see     GenIT_KyuukzAnnaimati
 * @see     QIT_KyuukzAnnaimati
 * @see     GenQIT_KyuukzAnnaimati
 */
public class PKIT_KyuukzAnnaimati extends AbstractExDBPrimaryKey<IT_KyuukzAnnaimati, PKIT_KyuukzAnnaimati> {

    private static final long serialVersionUID = 1L;

    public PKIT_KyuukzAnnaimati() {
    }

    public PKIT_KyuukzAnnaimati(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @Transient
    @Override
    public Class<IT_KyuukzAnnaimati> getEntityClass() {
        return IT_KyuukzAnnaimati.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

}