package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.JM_SyujyutuKyuuhu;
import yuyu.def.db.mapping.GenJM_SyujyutuKyuuhu;
import yuyu.def.db.meta.GenQJM_SyujyutuKyuuhu;
import yuyu.def.db.meta.QJM_SyujyutuKyuuhu;

/**
 * 手術給付マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_SyujyutuKyuuhu}</td><td colspan="3">手術給付マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyujyutubunruicd syujyutubunruicd}</td><td>手術分類コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyuuhucd kyuuhucd}</td><td>給付コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyujyututekiyoukkanfrom syujyututekiyoukkanfrom}</td><td>手術適用期間（自）</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyujyututekiyoukkanto syujyututekiyoukkanto}</td><td>手術適用期間（至）</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syujyutukyhbairitu</td><td>手術給付倍率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kyuuhugendokikan</td><td>給付限度期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syujyutusyurui</td><td>手術種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tokusyusyujyutukbn</td><td>特殊手術区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JM_SyujyutuKyuuhu
 * @see     GenJM_SyujyutuKyuuhu
 * @see     QJM_SyujyutuKyuuhu
 * @see     GenQJM_SyujyutuKyuuhu
 */
public class PKJM_SyujyutuKyuuhu extends AbstractExDBPrimaryKey<JM_SyujyutuKyuuhu, PKJM_SyujyutuKyuuhu> {

    private static final long serialVersionUID = 1L;

    public PKJM_SyujyutuKyuuhu() {
    }

    public PKJM_SyujyutuKyuuhu(
        String pSyujyutubunruicd,
        String pSyouhncd,
        Integer pSyouhnsdno,
        String pKyuuhucd,
        BizDate pSyujyututekiyoukkanfrom,
        BizDate pSyujyututekiyoukkanto
    ) {
        syujyutubunruicd = pSyujyutubunruicd;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        kyuuhucd = pKyuuhucd;
        syujyututekiyoukkanfrom = pSyujyututekiyoukkanfrom;
        syujyututekiyoukkanto = pSyujyututekiyoukkanto;
    }

    @Transient
    @Override
    public Class<JM_SyujyutuKyuuhu> getEntityClass() {
        return JM_SyujyutuKyuuhu.class;
    }

    private String syujyutubunruicd;

    public String getSyujyutubunruicd() {
        return syujyutubunruicd;
    }

    public void setSyujyutubunruicd(String pSyujyutubunruicd) {
        syujyutubunruicd = pSyujyutubunruicd;
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
    private String kyuuhucd;

    public String getKyuuhucd() {
        return kyuuhucd;
    }

    public void setKyuuhucd(String pKyuuhucd) {
        kyuuhucd = pKyuuhucd;
    }
    private BizDate syujyututekiyoukkanfrom;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyujyututekiyoukkanfrom() {
        return syujyututekiyoukkanfrom;
    }

    public void setSyujyututekiyoukkanfrom(BizDate pSyujyututekiyoukkanfrom) {
        syujyututekiyoukkanfrom = pSyujyututekiyoukkanfrom;
    }
    private BizDate syujyututekiyoukkanto;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyujyututekiyoukkanto() {
        return syujyututekiyoukkanto;
    }

    public void setSyujyututekiyoukkanto(BizDate pSyujyututekiyoukkanto) {
        syujyututekiyoukkanto = pSyujyututekiyoukkanto;
    }

}