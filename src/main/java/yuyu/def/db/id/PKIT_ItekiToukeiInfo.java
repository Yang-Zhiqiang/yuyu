package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_ItekiToukeiInfo;
import yuyu.def.db.mapping.GenIT_ItekiToukeiInfo;
import yuyu.def.db.meta.GenQIT_ItekiToukeiInfo;
import yuyu.def.db.meta.QIT_ItekiToukeiInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 医的統計用情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_ItekiToukeiInfo}</td><td colspan="3">医的統計用情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ketkekkacd</td><td>決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Ketkekkacd C_Ketkekkacd}</td></tr>
 *  <tr><td>palketsyacd</td><td>ＰＡＬ決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_ItekiToukeiInfo
 * @see     GenIT_ItekiToukeiInfo
 * @see     QIT_ItekiToukeiInfo
 * @see     GenQIT_ItekiToukeiInfo
 */
public class PKIT_ItekiToukeiInfo extends AbstractExDBPrimaryKey<IT_ItekiToukeiInfo, PKIT_ItekiToukeiInfo> {

    private static final long serialVersionUID = 1L;

    public PKIT_ItekiToukeiInfo() {
    }

    public PKIT_ItekiToukeiInfo(String pSyono) {
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<IT_ItekiToukeiInfo> getEntityClass() {
        return IT_ItekiToukeiInfo.class;
    }

    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

}