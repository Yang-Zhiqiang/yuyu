package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.IM_IktSyuunouRate;
import yuyu.def.db.mapping.GenIM_IktSyuunouRate;
import yuyu.def.db.meta.GenQIM_IktSyuunouRate;
import yuyu.def.db.meta.QIM_IktSyuunouRate;

/**
 * 一括収納率マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_IktSyuunouRate}</td><td colspan="3">一括収納率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getIktkaisuu iktkaisuu}</td><td>一括回数</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>iktsyunoritu</td><td>一括収納率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_IktSyuunouRate
 * @see     GenIM_IktSyuunouRate
 * @see     QIM_IktSyuunouRate
 * @see     GenQIM_IktSyuunouRate
 */
public class PKIM_IktSyuunouRate extends AbstractExDBPrimaryKey<IM_IktSyuunouRate, PKIM_IktSyuunouRate> {

    private static final long serialVersionUID = 1L;

    public PKIM_IktSyuunouRate() {
    }

    public PKIM_IktSyuunouRate(
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pIktkaisuu
    ) {
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        iktkaisuu = pIktkaisuu;
    }

    @Transient
    @Override
    public Class<IM_IktSyuunouRate> getEntityClass() {
        return IM_IktSyuunouRate.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private Integer syouhnsdno;

    public Integer getSyouhnsdno() {
        return syouhnsdno;
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        syouhnsdno = pSyouhnsdno;
    }
    private Integer iktkaisuu;

    public Integer getIktkaisuu() {
        return iktkaisuu;
    }

    public void setIktkaisuu(Integer pIktkaisuu) {
        iktkaisuu = pIktkaisuu;
    }

}