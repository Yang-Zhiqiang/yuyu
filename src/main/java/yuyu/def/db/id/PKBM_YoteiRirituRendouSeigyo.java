package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.BM_YoteiRirituRendouSeigyo;
import yuyu.def.db.mapping.GenBM_YoteiRirituRendouSeigyo;
import yuyu.def.db.meta.GenQBM_YoteiRirituRendouSeigyo;
import yuyu.def.db.meta.QBM_YoteiRirituRendouSeigyo;

/**
 * 予定利率連動制御マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_YoteiRirituRendouSeigyo}</td><td colspan="3">予定利率連動制御マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getYoteirirituhanteidfrom yoteirirituhanteidfrom}</td><td>予定利率作成判定日（自）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getYoteirirituhanteidto yoteirirituhanteidto}</td><td>予定利率作成判定日（至）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_YoteiRirituRendouSeigyo
 * @see     GenBM_YoteiRirituRendouSeigyo
 * @see     QBM_YoteiRirituRendouSeigyo
 * @see     GenQBM_YoteiRirituRendouSeigyo
 */
public class PKBM_YoteiRirituRendouSeigyo extends AbstractExDBPrimaryKey<BM_YoteiRirituRendouSeigyo, PKBM_YoteiRirituRendouSeigyo> {

    private static final long serialVersionUID = 1L;

    public PKBM_YoteiRirituRendouSeigyo() {
    }

    public PKBM_YoteiRirituRendouSeigyo(
        String pYoteirirituhanteidfrom,
        String pYoteirirituhanteidto,
        String pSyouhncd
    ) {
        yoteirirituhanteidfrom = pYoteirirituhanteidfrom;
        yoteirirituhanteidto = pYoteirirituhanteidto;
        syouhncd = pSyouhncd;
    }

    @Transient
    @Override
    public Class<BM_YoteiRirituRendouSeigyo> getEntityClass() {
        return BM_YoteiRirituRendouSeigyo.class;
    }

    private String yoteirirituhanteidfrom;

    public String getYoteirirituhanteidfrom() {
        return yoteirirituhanteidfrom;
    }

    public void setYoteirirituhanteidfrom(String pYoteirirituhanteidfrom) {
        yoteirirituhanteidfrom = pYoteirirituhanteidfrom;
    }
    private String yoteirirituhanteidto;

    public String getYoteirirituhanteidto() {
        return yoteirirituhanteidto;
    }

    public void setYoteirirituhanteidto(String pYoteirirituhanteidto) {
        yoteirirituhanteidto = pYoteirirituhanteidto;
    }
    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }

}