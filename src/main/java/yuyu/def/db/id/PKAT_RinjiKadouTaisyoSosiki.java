package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.mapping.GenAT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.meta.GenQAT_RinjiKadouTaisyoSosiki;
import yuyu.def.db.meta.QAT_RinjiKadouTaisyoSosiki;

/**
 * 臨時稼働対象組織テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_RinjiKadouTaisyoSosiki}</td><td colspan="3">臨時稼働対象組織テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKadouSosikiCd kadouSosikiCd}</td><td>稼働組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_RinjiKadouTaisyoSosiki
 * @see     GenAT_RinjiKadouTaisyoSosiki
 * @see     QAT_RinjiKadouTaisyoSosiki
 * @see     GenQAT_RinjiKadouTaisyoSosiki
 */
public class PKAT_RinjiKadouTaisyoSosiki extends AbstractExDBPrimaryKey<AT_RinjiKadouTaisyoSosiki, PKAT_RinjiKadouTaisyoSosiki> {

    private static final long serialVersionUID = 1L;

    public PKAT_RinjiKadouTaisyoSosiki() {
    }

    public PKAT_RinjiKadouTaisyoSosiki(String pKadouSosikiCd) {
        kadouSosikiCd = pKadouSosikiCd;
    }

    @Transient
    @Override
    public Class<AT_RinjiKadouTaisyoSosiki> getEntityClass() {
        return AT_RinjiKadouTaisyoSosiki.class;
    }

    private String kadouSosikiCd;

    public String getKadouSosikiCd() {
        return kadouSosikiCd;
    }

    public void setKadouSosikiCd(String pKadouSosikiCd) {
        kadouSosikiCd = pKadouSosikiCd;
    }

}