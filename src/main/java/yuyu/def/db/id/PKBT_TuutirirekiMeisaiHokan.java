package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import yuyu.def.db.mapping.GenBT_TuutirirekiMeisaiHokan;
import yuyu.def.db.meta.GenQBT_TuutirirekiMeisaiHokan;
import yuyu.def.db.meta.QBT_TuutirirekiMeisaiHokan;

/**
 * 通知履歴明細保管テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_TuutirirekiMeisaiHokan}</td><td colspan="3">通知履歴明細保管テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuutirirekirenno tuutirirekirenno}</td><td>通知履歴連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tuutirirekino</td><td>通知履歴番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tuutisakuseiymd</td><td>通知作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>tuutisakuseino</td><td>通知作成番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tuutisyuruicd</td><td>通知種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiyoutuutisakuseiymd</td><td>表示用通知作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BT_TuutirirekiMeisaiHokan
 * @see     GenBT_TuutirirekiMeisaiHokan
 * @see     QBT_TuutirirekiMeisaiHokan
 * @see     GenQBT_TuutirirekiMeisaiHokan
 */
public class PKBT_TuutirirekiMeisaiHokan extends AbstractExDBPrimaryKey<BT_TuutirirekiMeisaiHokan, PKBT_TuutirirekiMeisaiHokan> {

    private static final long serialVersionUID = 1L;

    public PKBT_TuutirirekiMeisaiHokan() {
    }

    public PKBT_TuutirirekiMeisaiHokan(String pTuutirirekirenno) {
        tuutirirekirenno = pTuutirirekirenno;
    }

    @Transient
    @Override
    public Class<BT_TuutirirekiMeisaiHokan> getEntityClass() {
        return BT_TuutirirekiMeisaiHokan.class;
    }

    private String tuutirirekirenno;

    public String getTuutirirekirenno() {
        return tuutirirekirenno;
    }

    public void setTuutirirekirenno(String pTuutirirekirenno) {
        tuutirirekirenno = pTuutirirekirenno;
    }

}